package controlador;

import _TDAs.Respuesta;
import interfaz.RespuestaFrame;

public class RespuestaControl {
	public static RespuestaFrame respuestaFrame = new RespuestaFrame();
	private static Respuesta respuesta;
	
	public static void mostrar(Respuesta answer) {
		respuesta = answer;
		
		respuestaFrame.getLblRespuesta().setText(answer.getContenido());
		respuestaFrame.getLblFecha().setText(answer.getFechaDePublicacion());
		respuestaFrame.getLblAutor().setText(answer.getAutor());
		respuestaFrame.getLblEstado().setText(answer.getEstado());
		respuestaFrame.getLblVotosFavor().setText(Integer.toString(answer.getVotosAFavor()));
		respuestaFrame.getLblVotosContra().setText(Integer.toString(answer.getVotosEnContra()));
		respuestaFrame.setVisible(true);
	}
	public static void ocultar() {
		respuestaFrame.setVisible(false);
	}
}
