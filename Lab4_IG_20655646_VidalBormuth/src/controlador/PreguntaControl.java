package controlador;

import _TDAs.Pregunta;
import _TDAs.Usuario;
import interfaz.PreguntaFrame;


public class PreguntaControl {
	
	public static PreguntaFrame askFrame = new PreguntaFrame();
	private static Pregunta pregunta;
	
	public static void mostrar(Pregunta preg) {
		pregunta = preg;
		
		askFrame.getLblPregunta().setText(preg.getTitulo());
		askFrame.getLblDescripcion().setText(preg.getContenido());
		askFrame.getLblFecha().setText(preg.getFechaDePublicacion());
		askFrame.getLblAutor().setText(preg.getAutor());
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
		}else {
			SesionIniciadaControl.mostrar(userA.getName());
		}
	}
}
