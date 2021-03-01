package controlador;


import interfaz.AccederFrame;

public class AccederControl {
	
	public static AccederFrame inicioSesion = new AccederFrame();
	public static void mostrar() {
		inicioSesion.setVisible(true);
	}
	public static void ocultar() {
		inicioSesion.setVisible(false);
	}
	
	public static void eventoBtnVolver() {
		ocultar();
		InicioControl.mostrar();
	}
	
	public static void eventoBtnIngresar() {
		
		String userName = inicioSesion.getTextNameUser().getText();
		String userPass = inicioSesion.getPasswordUser().getText();
		
		inicioSesion.setTextNameUser(null);
		inicioSesion.setPasswordUser(null);
	}

}
