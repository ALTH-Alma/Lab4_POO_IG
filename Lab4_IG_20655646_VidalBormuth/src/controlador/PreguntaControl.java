package controlador;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import _TDAs.Respuesta;
import _TDAs.Usuario;
import interfaz.PreguntaFrame;

/**
 * Clase que representa el controlador para la vista de la ventana que permite visualizar una pregunta del stack. 
 * @author Alma
 *
 */
public class PreguntaControl {
	
	public static PreguntaFrame askFrame = new PreguntaFrame(); //Posee una ventana de pregunta.
	private static Pregunta pregunta; //Una pregunta
	private static Boolean perfil; //Y un booleano que ayuda a determinar si el usuario esta viendo su lista de preguntas propias o la lista general. True = personal, False = general.
	
	
	/**
	 *  * Permite mostrar la ventana actualizando alguno de sus datos.
	 * @param ask Pregunta que se muestra por la ventana.
	 * @param bool el booleano aux para determianar personal o general.
	 */
	public static void mostrar(Pregunta ask, Boolean bool) {
		//Se guardan los datos.
		pregunta = ask;
		perfil = bool;
		//Se modifican los lbl's de la ventana con los datos de la pregunta, de esta forma mostrar por la ventana la preguntay sus componentes.
		askFrame.getLblPregunta().setText(ask.getTitulo());
		askFrame.getLblDescripcion().setText(ask.getContenido());
		askFrame.getLblFecha().setText(ask.getFechaDePublicacion());
		askFrame.getLblAutor().setText(ask.getAutor());
		askFrame.getLblEstado().setText(ask.getEstado());
		askFrame.getLblVotosFavor().setText(Integer.toString(ask.getVotosAFavor()));
		askFrame.getLblVotosContra().setText(Integer.toString(ask.getVotosEnContra()));
		mostrarListaEtiquetasPregunta(); //Se muestra la lista de etiquetas de la pregunta.
		mostrarTableRespuestas(); //Y sus respuestas listadas en una tabla.
		askFrame.setVisible(true); //Se muestra la ventana.
	}
	
	/**
	 * Oculta la ventana.
	 */
	public static void ocultar() {
		askFrame.setVisible(false);
	}
	
	
	public static void eventoBtnVolverPregunta() {
		Usuario userA = InicioControl.stackService.getStack().getActiveUser();
		ocultar();
		if( userA== null) {
			InicioControl.mostrar();
		}else if(perfil) {
			PerfilControl.mostrar();
		}else {
			SesionIniciadaControl.mostrar(userA.getName());
		}
	}
	
	/**
	 * Permite mostrar la lista de etiquetas de una pregunta en un combobox.
	 */
	private static void mostrarListaEtiquetasPregunta() {
		
		List<Etiqueta> etiquetas = pregunta.getEtiquetas();
		String lista[] = new String[etiquetas.size()];
		
		for( int i = 0; i < etiquetas.size(); i++) {//Se copia la lista de etiquetas en la nueva lista.
			lista[i] = etiquetas.get(i).getName();
		}
		askFrame.getComboBoxEtiquetasPregunta().setModel(new DefaultComboBoxModel(lista));	//Se modifica la comboboc con una lista hecha de la lista de etiquetas.
	}

	
	/**
	 * Permite ver una etiqueta y su descripcion al hacer click en combobox con la etiqueta selecionada.
	 */
	public static void eventoMostrarContenidoEtiquetaPregunta() {

		String nombreEtiqueta = (String) askFrame.getComboBoxEtiquetasPregunta().getSelectedItem(); //Se obtine el nombre de la etiqueta seleccionada en el combobox.
		String descripcion = pregunta.getEtiqueta(nombreEtiqueta).getDescripcion();//Se toma la etiqueta y su descripcion.
		JOptionPane.showMessageDialog(null,nombreEtiqueta+ "\n"+descripcion);//Se muestra como Massage.
	}
	
	
	private static void mostrarTableRespuestas() {
		
		List<Respuesta> respuestas = pregunta.getRespuestas();
		
		String matriz[][] = new String[respuestas.size()][4];
		
		for( int i = 0; i < respuestas.size(); i++) {
			matriz[i][0] = Integer.toString(respuestas.get(i).getId());
			matriz[i][1] = respuestas.get(i).getContenido();
			matriz[i][2] = respuestas.get(i).getAutor();
			matriz[i][3] = respuestas.get(i).getFechaDePublicacion();
		}
		
		askFrame.getTableRespuestas().setModel(new DefaultTableModel(
				matriz,
				new String[] {
					"ID", "Respuestas", "Usuario", "Fecha de publicaci\u00F3n"
				}
			));
	}
	
	public static void eventoClickRespuestaTable(int idRespuesta) {
		Respuesta respuesta = pregunta.getRespuesta(idRespuesta);
		RespuestaControl.mostrar(pregunta, respuesta, perfil);
	}
	
	public static void eventoBtnEnviarRespuesta() {
	
		String respuesta = askFrame.getTextAreaRespuesta().getText();
		
		int aux = controlador.InicioControl.stackService.answer(pregunta.getId() , respuesta);
		if(aux == 0) {
			JOptionPane.showMessageDialog(null, "Respuesta enviada !!");
			mostrarTableRespuestas();
		}else if(aux == 2){
			JOptionPane.showMessageDialog(null, "Esta pregunta se encuentra cerrado, no es posible recibir respuestas !!");
		}else {
			JOptionPane.showMessageDialog(null, "Sesión cerrada !! \n Para entregar una respuesta primero debe iniciar sesión.!!");
		}
		askFrame.getTextAreaRespuesta().setText("");

	}
	
	public static void eventoBtnRecompensa() {
		if(pregunta.getEstado().equals("Abierta.")) {//Y si la pregunta no esta abierta.
			RecompensaControl.mostrar(pregunta);
		}else {
			JOptionPane.showMessageDialog(null, "No se pueden realizar recompensas!! \n Esta pregunta ya se encuentra cerrada.");
		}
		
	}
}
