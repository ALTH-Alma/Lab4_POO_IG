package controlador;



import _TDAs.Etiqueta;
import interfaz.CrearEtiquetaFrame;

public class CrearEtiquetaControl {
	
	public static CrearEtiquetaFrame etiqueta = new CrearEtiquetaFrame();

	
	public static void mostrar() {
		etiqueta.setVisible(true);

	}
	public static void ocultar() {
		etiqueta.setVisible(false);
	}
	
	public static void eventoBtnCancel() {
		
		etiqueta.getTextFieldNEtiqueta().setText("");
		etiqueta.getTextAreaDEtiqueta().setText("");
		ocultar();
	}
	
	public static void eventoBtnCrearEtiqueta() {
		
		String nombre = etiqueta.getTextFieldNEtiqueta().getText();
		String descripcion = etiqueta.getTextAreaDEtiqueta().getText();
		
		Etiqueta newEtiqueta= new Etiqueta(nombre, descripcion);
		InicioControl.stackService.getStack().getEtiquetas().add(newEtiqueta);
		
		etiqueta.getTextFieldNEtiqueta().setText("");
		etiqueta.getTextAreaDEtiqueta().setText("");
		
		ocultar();
	}
}
