package controlador;

import _TDAs.Etiqueta;
import interfaz.CrearEtiquetaFrame;


/**
 * Clase que representa el controlador para la vista de la ventana que permite crear una nueva etiqueta en stack. 
 * Permite Crear nueva etiqueta.
 * @author Alma
 *
 */
public class CrearEtiquetaControl {
	
	public static CrearEtiquetaFrame etiqueta = new CrearEtiquetaFrame(); //Posee una ventana de Acceso a stack.

	/**
	 * Muestra la ventana.
	 */
	public static void mostrar() {
		etiqueta.setVisible(true);

	}
	/**
	 * Cierra la ventana.
	 */
	public static void ocultar() {
		etiqueta.setVisible(false);
	}
	
	/**
	 * Define el evento producido al presionar Btn cancel.
	 */
	public static void eventoBtnCancel() {
		//Se limpian las barras que piden los datos.
		etiqueta.getTextFieldNEtiqueta().setText("");
		etiqueta.getTextAreaDEtiqueta().setText("");
		//Se cierra la ventana.
		ocultar();
		GenerarPreguntaControl.mostrar(); //Se muestra la ventana de generar pregunta.
	}
	
	/**
	 * Define el evento producido al presionar Btn crear etiqueta.
	 * Permite crear una nueva etiqueta en stack.
	 */
	public static void eventoBtnCrearEtiqueta() {
		//Obtiene los datos ingresados, como string.
		String nombre = etiqueta.getTextFieldNEtiqueta().getText();
		String descripcion = etiqueta.getTextAreaDEtiqueta().getText();
		//Se crea la etiqueta.
		Etiqueta newEtiqueta= new Etiqueta(nombre, descripcion);
		InicioControl.stackService.getStack().getEtiquetas().add(newEtiqueta); //Se agrega al stack.
		//Se limpian las barras que piden los datos.
		etiqueta.getTextFieldNEtiqueta().setText("");
		etiqueta.getTextAreaDEtiqueta().setText("");
		//Se cierra la ventana.
		ocultar();
		GenerarPreguntaControl.mostrar();  //Se muestra la ventana de generar pregunta.
		
	}
}
