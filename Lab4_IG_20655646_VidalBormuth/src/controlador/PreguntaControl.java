package controlador;

import interfaz.PreguntaFrame;


public class PreguntaControl {
	
	public static PreguntaFrame askFrame = new PreguntaFrame();
	
	public static void mostrar(String actUserName) {

		askFrame.setVisible(true);
	}
	public static void ocultar() {
		askFrame.setVisible(false);
	}
}
