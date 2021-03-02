package controlador;

import javax.swing.JOptionPane;

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
		
		registro.getTextFieldNewUserName().setText("");
		registro.getTextFieldNewPass().setText("");
		ocultar();
		InicioControl.mostrar();
	}
	
	public static void eventoBtnRegister() {
		
		String newUserName = registro.getTextFieldNewUserName().getText();
		String newUserPass = registro.getTextFieldNewPass().getText();
		
		if(controlador.InicioControl.stackService.register(newUserName, newUserPass)){
			registro.getTextFieldNewUserName().setText("");
			registro.getTextFieldNewPass().setText("");
			ocultar();
			JOptionPane.showMessageDialog(null,"Usuario registrado con existo !!"+"\n Bienvenido a nuestra comunidad :)");
			InicioControl.mostrar();
		}else {
			JOptionPane.showMessageDialog(null,"Nombre de usuario existente !!" + "\nNo se ha podido registrar, por favor intente de nuevo con otro nombre.");
			registro.getTextFieldNewUserName().setText("");
			registro.getTextFieldNewPass().setText("");
		}
		
		
	}

}
