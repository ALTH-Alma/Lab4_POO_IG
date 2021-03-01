package controlador;

import interfaz.RegistroFrame;

public class RegisterControl {
	
	public static RegistroFrame registro = new RegistroFrame();
	
	public static void mostrar() {
		registro.setVisible(true);
	}
	public static void ocultar() {
		registro.setVisible(false);
	}
	
	public static void eventoBtnVolver() {
		ocultar();
		InicioControl.mostrar();
	}
	
	public static void eventoBtnRegister() {
		
		String newUserName = registro.getTextFieldNewUserName().getText();
		String newUserPass = registro.getTextFieldNewPass().getText();
	}

}
