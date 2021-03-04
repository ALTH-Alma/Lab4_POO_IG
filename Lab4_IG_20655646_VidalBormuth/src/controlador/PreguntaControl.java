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
	 * Permite mostrar la ventana actualizando alguno de sus datos.
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
	
	/**
	 * Define el evento producido al presionar Btn volver.
	 */
	public static void eventoBtnVolverPregunta() {
		Usuario userA = InicioControl.stackService.getStack().getActiveUser();
		ocultar();
		if( userA== null) { //Si no existe sesion abierta se devuelve a la ventana de inicio.
			InicioControl.mostrar();
		}else if(perfil) { //Si existe sesion abierta y se encuntra en la tabla de preguntas propias, se devuelve a la ventana de perfil del usuario.
			PerfilControl.mostrar();
		}else { //Si no
			SesionIniciadaControl.mostrar(userA.getName()); //Se devuelve a la ventana de inicio de sesion activa.
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
	
	/**
	 * Permite mostrar las respuestas de una pregunta listadas en una tabla.
	 */
	private static void mostrarTableRespuestas() {
		
		List<Respuesta> respuestas = pregunta.getRespuestas(); //Se toman las respuestas de la pregunta.
		
		String matriz[][] = new String[respuestas.size()][4];
		
		for( int i = 0; i < respuestas.size(); i++) { //Se copian en una matriz.
			matriz[i][0] = Integer.toString(respuestas.get(i).getId());
			matriz[i][1] = respuestas.get(i).getContenido();
			matriz[i][2] = respuestas.get(i).getAutor();
			matriz[i][3] = respuestas.get(i).getFechaDePublicacion();
		}
		
		askFrame.getTableRespuestas().setModel(new DefaultTableModel(
				matriz,
				new String[] {
					"ID", "Respuestas", "Usuario", "Fecha de publicacion"
				}
			)); //Se modifica la tabla de la ventana añadiendo la matriz con las respuestas.
	}

	
	/**
	 *  Define el evento producido al hacer click a alguna de las respuestas en la tabla.
	 *  permite abrir una respuesta y mostrar sus caracteristicas..
	 * @param idRespuesta identificador númerico de la respuesta clickeada.
	 */
	public static void eventoClickRespuestaTable(int idRespuesta) {
		Respuesta respuesta = pregunta.getRespuesta(idRespuesta); //Toma la respuesta.
		RespuestaControl.mostrar(pregunta, respuesta, perfil); // y se muestra la ventana de respuesta.
	}
	
	
	/**
	 * Define el evento producido al presionar Btn enviar respuesta
	 * Permite agregar una nueva respuesta a una pregunta utilizando el metodo answer.
	 */
	public static void eventoBtnEnviarRespuesta() {
	
		String respuesta = askFrame.getTextAreaRespuesta().getText(); //Se obtienen los datos ingresados, como string.
		
		int aux = controlador.InicioControl.stackService.answer(pregunta.getId() , respuesta); //Se llama a answer
		//Segun el valor entregado por answer se sabe si se realizo para respuesta y sino, se determiana las razones del fallo. 
		if(aux == 0) {
			JOptionPane.showMessageDialog(null, "Respuesta enviada !!");
			mostrarTableRespuestas(); //Si se realiza, se muestra la tabla de respuestas actualizadas.
		}else if(aux == 2){
			JOptionPane.showMessageDialog(null, "Esta pregunta se encuentra cerrado, no es posible recibir respuestas !!");
		}else {
			JOptionPane.showMessageDialog(null, "Sesion cerrada !! \n Para entregar una respuesta primero debe iniciar sesion.!!");
		}
		askFrame.getTextAreaRespuesta().setText(""); //Se limpia la barra que pide la respuesta.

	}
	
	/**
	 * Define el evento producido al presionar Btn recompensa.
	 * Permite mostrar una ventanilla recompensa, esta muestra la recompensa y permite ofrecer nueva recompensa.
	 */
	public static void eventoBtnRecompensa() {
		if(pregunta.getEstado().equals("Abierta.")) {//si la pregunta no esta abierta.
			RecompensaControl.mostrar(pregunta); //Se muestra recompensa.
		}else {//Si no, no hace nada.
			JOptionPane.showMessageDialog(null, "No se pueden realizar recompensas!! \n Esta pregunta ya se encuentra cerrada.");
		}
		
	}
}
