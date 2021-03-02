package controlador;


import javax.swing.JOptionPane;

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
		
		inicioSesion.getTextNameUser().setText("");
		inicioSesion.getPasswordUser().setText("");
		ocultar();
		InicioControl.mostrar();
	}
	
	public static void eventoBtnIngresar() {
		
		String userName = inicioSesion.getTextNameUser().getText();
		String userPass = inicioSesion.getPasswordUser().getText();
		
		int aux = controlador.InicioControl.stackService.login(userName, userPass);
		
		inicioSesion.getTextNameUser().setText("");
		inicioSesion.getPasswordUser().setText("");
		
		if( aux == 0){
			ocultar();
			JOptionPane.showMessageDialog(null, userName+" ha iniciado sesión !!");
			SesionIniciadaControl.mostrar(userName);
			
		}else if(aux == 1) {
			JOptionPane.showMessageDialog(null,"Contraseña incorrecta !!"+"\n Por favor intentelo nuevamente.");
		}else if(aux == 2) {
			JOptionPane.showMessageDialog(null,"Nombre de usuario incorrecto o usuario inexistente !!"+"\n Por favor intentelo nuevamente.");
		}else if (aux == 3) {
			ocultar();
			JOptionPane.showMessageDialog(null,"Ya existe sesión activa !!"+"\n Si desea inciar una nueva sesión cierre sesión activa.");
			SesionIniciadaControl.mostrar(userName);
		}else {
			JOptionPane.showMessageDialog(null,"ERROR");
		}
		
	}

	
	
}
