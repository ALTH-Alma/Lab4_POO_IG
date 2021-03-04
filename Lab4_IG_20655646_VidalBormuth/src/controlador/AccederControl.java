package controlador;


import javax.swing.JOptionPane;

import interfaz.AccederFrame;

/**
 * Clase que representa el controlador para la vista de la ventana que permite acceder al sistema de stack overflow.
 * Permite iniciar sesión. 
 * @author Alma
 *
 */
public class AccederControl {
	
	public static AccederFrame inicioSesion = new AccederFrame(); //Posee una ventana de Acceso a stack.
	
	/**
	 * Muestra la ventana.
	 */
	public static void mostrar() {
		inicioSesion.setVisible(true);
	}
	
	/**
	 * Cierra la ventana.
	 */
	public static void ocultar() {
		inicioSesion.setVisible(false);
	}
	
	/**
	 * Define el evento producido al presionar Btn volver.
	 */
	public static void eventoBtnVolver() {
		//Se limpian las barras que piden los datos.
		inicioSesion.getTextNameUser().setText("");
		inicioSesion.getPasswordUser().setText("");
		ocultar(); //Se oculta la ventana.
		InicioControl.mostrar(); //Se muestra la ventana de inicio.
	}
	
	/**
	 * Define el evento producido al presionar el boton ingresar
	 * Permite ingresar al stack usando la función login, siempre que las credensiales sean correctas.
	 */
	public static void eventoBtnIngresar() {
		
		//Obtiene los datos ingresados, como string.
		String userName = inicioSesion.getTextNameUser().getText();
		String userPass = inicioSesion.getPasswordUser().getText();
		
		int aux = controlador.InicioControl.stackService.login(userName, userPass); //Se llama a login.
		
		//Se limpian las barras que piden los datos.
		inicioSesion.getTextNameUser().setText("");
		inicioSesion.getPasswordUser().setText("");
		
		if( aux == 0){ //Si login arroja un 0, se inicia sesión.
			ocultar(); //Se cierra ventana.
			JOptionPane.showMessageDialog(null, userName+" ha iniciado sesión !!");
			SesionIniciadaControl.mostrar(userName); //Se muestra ventana de inicio de sesión.
		//Si es otro numero, se muestran mensajes informando de los errores del usuarios y laas causas de que no puedan iniciar sesion segun corresponda el numero.	
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
