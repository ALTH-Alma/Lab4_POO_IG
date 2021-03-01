package controlador;
import interfaz.*;

public class InicioControl {
	
	public static InicioFrame inicio = new InicioFrame();
	public static void mostrar() {
		inicio.setVisible(true);
	}
	public static void ocultar() {
		inicio.setVisible(false);
	}
	
	public static void eventoBtnIngresar() {
		ocultar();
		AccederControl.mostrar();
	}
	
	public static void eventoBtnRegistrarse() {
		ocultar();
		RegisterControl.mostrar();
	}

}
