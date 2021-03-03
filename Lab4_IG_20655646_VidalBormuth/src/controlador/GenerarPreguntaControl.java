package controlador;

import interfaz.GenerarPreguntaFrame;


public class GenerarPreguntaControl {
	public static GenerarPreguntaFrame generadorAsk = new GenerarPreguntaFrame();
	
	public static void mostrar() {
		generadorAsk.setVisible(true);
	}
	public static void ocultar() {
		generadorAsk.setVisible(false);
	}
	
	public static void eventoBtnCancelar() {
		ocultar();
		generadorAsk.getTextFieldTPregunta().setText("");
		generadorAsk.getTextAreaContenidoR().setText("");
		SesionIniciadaControl.mostrar("");
	}
	
	public static void eventoBtnEnviarPregunta() {
		
		String titulo = generadorAsk.getTextFieldTPregunta().getText();
		String contenido = generadorAsk.getTextAreaContenidoR().getText();
		
		
		
		
		controlador.InicioControl.stackService.ask(titulo, contenido, etiquetas);
		
	}
}
