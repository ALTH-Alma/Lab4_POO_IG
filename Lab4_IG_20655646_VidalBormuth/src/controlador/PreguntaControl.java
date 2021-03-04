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


public class PreguntaControl {
	
	public static PreguntaFrame askFrame = new PreguntaFrame();
	private static Pregunta pregunta;
	private static Boolean perfil;
	
	public static void mostrar(Pregunta ask, Boolean bool) {
		pregunta = ask;
		perfil = bool;
		askFrame.getLblPregunta().setText(ask.getTitulo());
		askFrame.getLblDescripcion().setText(ask.getContenido());
		askFrame.getLblFecha().setText(ask.getFechaDePublicacion());
		askFrame.getLblAutor().setText(ask.getAutor());
		askFrame.getLblEstado().setText(ask.getEstado());
		askFrame.getLblVotosFavor().setText(Integer.toString(ask.getVotosAFavor()));
		askFrame.getLblVotosContra().setText(Integer.toString(ask.getVotosEnContra()));
		mostrarListaEtiquetasPregunta();
		mostrarTableRespuestas();
		askFrame.setVisible(true);
	}
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
	
	private static void mostrarListaEtiquetasPregunta() {
		
		List<Etiqueta> etiquetas = pregunta.getEtiquetas();
		String lista[] = new String[etiquetas.size()];
		
		for( int i = 0; i < etiquetas.size(); i++) {
			lista[i] = etiquetas.get(i).getName();
		}
		askFrame.getComboBoxEtiquetasPregunta().setModel(new DefaultComboBoxModel(lista));	
	}

	public static void eventoMostrarContenidoEtiquetaPregunta() {

		String nombreEtiqueta = (String) askFrame.getComboBoxEtiquetasPregunta().getSelectedItem();
		String descripcion = pregunta.getEtiqueta(nombreEtiqueta).getDescripcion();
		JOptionPane.showMessageDialog(null,nombreEtiqueta+ "\n"+descripcion);
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
		RespuestaControl.mostrar(respuesta, perfil);
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
