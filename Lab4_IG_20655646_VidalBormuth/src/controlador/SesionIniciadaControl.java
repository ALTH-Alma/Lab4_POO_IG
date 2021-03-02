package controlador;

import javax.swing.JOptionPane;

import interfaz.SesionIniciadaFrame;

public class SesionIniciadaControl {
	
	private static String activeUserName;
	public static SesionIniciadaFrame sesionIniciada = new SesionIniciadaFrame();
	
	public static void mostrar(String actUserName) {
		activeUserName = actUserName;
		sesionIniciada.getLblTitulo().setText("Bienvenido "+actUserName);
		sesionIniciada.setVisible(true);
	}
	public static void ocultar() {
		sesionIniciada.setVisible(false);
	}
	
	public static void eventoBtnCerrarSesion() {
		
		if(controlador.InicioControl.stackService.logout()) {
			ocultar();
			JOptionPane.showMessageDialog(null, activeUserName + " ha cerrado sesión !!");
			InicioControl.mostrar();
			
		}else {
			ocultar();
			JOptionPane.showMessageDialog(null,"No existe sesión iniciada !!");
			InicioControl.mostrar();
		}
		
	}
	
	public static void eventoBtnHacerPregunta() {
		
		
	}

}
