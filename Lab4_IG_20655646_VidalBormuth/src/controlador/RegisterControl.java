package controlador;

import javax.swing.JOptionPane;

import interfaz.RegistroFrame;

/**
 * Clase que representa el controlador para la vista de la ventana que permite registrarse en StackOverflow.
 * @author Alma
 *
 */
public class RegisterControl {
	
	public static RegistroFrame registro = new RegistroFrame(); //Posee una ventana de Registro a stack.
	
	/**
	 * Muestra la ventana.
	 */
	public static void mostrar() {
		registro.setVisible(true);
	}
	
	/**
	 * Cierra la ventana.
	 */
	public static void ocultar() {
		registro.setVisible(false);
	}
	
	
	/**
	 * Define el evento producido al presionar Btn volver.
	 */
	public static void eventoBtnVolver() {
		//Se limpian las barras que piden los datos.
		registro.getTextFieldNewUserName().setText("");
		registro.getTextFieldNewPass().setText("");
		ocultar();//Se oculta la ventana.
		InicioControl.mostrar(); //Se muestra la ventana de inicio.
	}
	
	/**
	 * Define el evento producido al presionar el boton registrar
	 * Permite resgistrar un usuario en el stack usando la función resgister, siempre que las datos sean correctos.
	 */
	public static void eventoBtnRegister() {
		//Obtiene los datos ingresados, como string.
		String newUserName = registro.getTextFieldNewUserName().getText();
		String newUserPass = registro.getTextFieldNewPass().getText();
		
		//Se llama al metodo register.
		if(controlador.InicioControl.stackService.register(newUserName, newUserPass)){ //Si se produce el registro correctamente.
			//Se limpian las barras que piden los datos.
			registro.getTextFieldNewUserName().setText("");
			registro.getTextFieldNewPass().setText("");
			ocultar(); //Se cierra la ventana.
			JOptionPane.showMessageDialog(null,"Usuario registrado con existo !!"+"\n Bienvenido a nuestra comunidad :)");
			InicioControl.mostrar(); //Y se muestra el inicio de stack.
		}else { //Si no ocurrio el registro...
			JOptionPane.showMessageDialog(null,"Nombre de usuario existente !!" + "\nNo se ha podido registrar, por favor intente de nuevo con otro nombre.");
			//Se limpian las barras que piden los datos.
			registro.getTextFieldNewUserName().setText("");
			registro.getTextFieldNewPass().setText("");
		}
		
		
	}

}
