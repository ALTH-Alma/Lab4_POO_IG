package controlador;
import interfaz.*;
import service.StackService;

public class InicioControl {
	
	
	public static StackService stackService = new StackService();
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
