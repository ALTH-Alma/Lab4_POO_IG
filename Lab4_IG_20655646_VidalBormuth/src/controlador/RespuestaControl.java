package controlador;

import javax.swing.JOptionPane;

import _TDAs.Pregunta;
import _TDAs.Respuesta;
import interfaz.RespuestaFrame;

public class RespuestaControl {
	public static RespuestaFrame respuestaFrame = new RespuestaFrame();
	private static Pregunta pregunta;
	private static Respuesta respuesta;
	
	public static void mostrar(Pregunta ask, Respuesta answer, Boolean bool) {
		respuesta = answer;
		pregunta = ask;
		respuestaFrame.getLblRespuesta().setText(answer.getContenido());
		respuestaFrame.getLblFecha().setText(answer.getFechaDePublicacion());
		respuestaFrame.getLblAutor().setText("Autor: "+answer.getAutor());
		respuestaFrame.getLblEstado().setText(answer.getEstado());
		respuestaFrame.getLblVotosFavor().setText(Integer.toString(answer.getVotosAFavor()));
		respuestaFrame.getLblVotosContra().setText(Integer.toString(answer.getVotosEnContra()));
		
		if(!bool) {
			respuestaFrame.remove(respuestaFrame.getBtnAceptar());
		}else {
			respuestaFrame.add(respuestaFrame.getBtnAceptar());
		}
		respuestaFrame.setVisible(true);
	}
	public static void ocultar() {
		respuestaFrame.setVisible(false);
	}
	
	public static void eventoBtnVolverR() {
		ocultar();
	}
	
	public static void eventoBtnAceptar() {
		
		int aux = controlador.InicioControl.stackService.accept(pregunta, respuesta);
		
		if(aux == 0) {
			JOptionPane.showMessageDialog(null, "Respuesta aceptada!!");
		}else if(aux == 1){
			JOptionPane.showMessageDialog(null, "Esta pregunta no se puede aceptar, pues ya esta aceptada!!");
		}else {
			JOptionPane.showMessageDialog(null, "Esta pregunta no se puede aceptar, pues la pregunta a la que pertenece se encuentra cerrada!!");
		}
		ocultar();
		
	}
}
