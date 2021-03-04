package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import interfaz.GenerarPreguntaFrame;
import service.GettersStackService;

/**
 * Clase que representa el controlador para la vista de la ventana que permite crear una nueva pregunta en stack. 
 * Permite agregar una nueva pregunta al stack.
 * @author Alma
 *
 */
public class GenerarPreguntaControl {
	
	public static GenerarPreguntaFrame generadorAsk = new GenerarPreguntaFrame(); //Posee una ventana de generar pregunta
	static List<Etiqueta> etiquetasNewAsk = new ArrayList<>(); //Y una lista de etiquetas para la pregunta a generar.
	
	/**
	 * Muestra la ventana.
	 */
	public static void mostrar() {
		generadorAsk.setVisible(true);
		mostrarListaEtiquetas(); //Muestra tambien la lista de etiquetas disponibles para generar la pregunta.
	}
	
	/**
	 * Cierra la ventana.
	 */
	public static void ocultar() {
		generadorAsk.setVisible(false);
	}
	

	/**
	* Define el evento producido al presionar Btn cancelar.
	*/
	public static void eventoBtnCancelar() {
		ocultar();//Se oculta la ventana.
		//Se limpian las barras que piden los datos.
		generadorAsk.getTextFieldTPregunta().setText("");
		generadorAsk.getTextAreaContenidoR().setText("");
		etiquetasNewAsk.clear(); //Se limpia la lista de etiquetas hecha para la pregunta.
		SesionIniciadaControl.mostrar("");//Se muestra la ventana de inicio de sesion iniciada.

	}
	
	/**
	 * Permite mostrar la lista de etiquetas del stack en un combobox.
	 */
	public static void mostrarListaEtiquetas() {
		
		List<Etiqueta> etiquetas = InicioControl.stackService.getStack().getEtiquetas();
		String lista[] = new String[etiquetas.size()];
		
		for( int i = 0; i < etiquetas.size(); i++) { //Se copia la lista de etiquetas en la nueva lista.
			lista[i] = etiquetas.get(i).getName();
		}
		generadorAsk.getComboBoxEtiquetas().setModel(new DefaultComboBoxModel(lista));	//Se modifica la comboboc con una lista hecha de la lista de etiquetas.
	}
	
	
	/**
	* Define el evento producido al presionar Btn crear etiqueta.
	* Permite abrir una ventana para crear una etiqueta.
	*/
	public static void eventoBtnCrearEtiqueta() {
		ocultar();
		CrearEtiquetaControl.mostrar();
	}
	
	
	/**
	* Define el evento producido al presionar Btn agregar etiqueta.
	* Permite agregar etiquetas del stack a la nueva lista de etiquetas, que seran parte de la nueva pregunta.
	*/
	public static void eventoBtnAgregarEtiqueta() {
		
		String nombreEtiqueta = (String) generadorAsk.getComboBoxEtiquetas().getSelectedItem(); //Se optiene el nombre de la etiqueta seleccionada.
		GettersStackService getS = new GettersStackService(InicioControl.stackService.getStack());
		etiquetasNewAsk.add(getS.getEtiqueta(nombreEtiqueta)); //Se toma la etiqueta de la lista de stack y se agrega a la nueva lista.
		JOptionPane.showMessageDialog(null,"Se ha gregado la etiqueta "+nombreEtiqueta+ " a la lista de etiquetas de su pregunta.");
	}
	
	/**
	 * Permite crear una nueva lista de etiquetas para la pregunta con la lista de etiquetas seleccionadas, para poder formatear la lista de la clase, para la proxima pregunta.
	 * @param listaEtiquetas Etiquetas seleccionadas a añadir.
	 * @return la nueva lista de etiquetas para la pregunta.
	 */
	private static List<Etiqueta> crearListEtiquetas(List<Etiqueta> listaEtiquetas){
		
		List<Etiqueta> etiquetasNew = new ArrayList<>();
		for( int i = 0; i < listaEtiquetas.size(); i++) {
			etiquetasNew.add(listaEtiquetas.get(i));
		}
		return etiquetasNew;
	}
	
	
	/**
	 * Permite crear y agregar una nueva pregunta a el stack con la funcion ask.
	 */
	public static void eventoBtnEnviarPregunta() {
		//Obtiene los datos ingresados, como string.
		String titulo = generadorAsk.getTextFieldTPregunta().getText();
		String contenido = generadorAsk.getTextAreaContenidoR().getText();
		//Se crea la pregunta.
		controlador.InicioControl.stackService.ask(titulo, contenido, crearListEtiquetas(etiquetasNewAsk));
		
		ocultar(); //Se oculta la ventana.
		//Se limpia la lista de etiquetas auxiliar de la clase.
		etiquetasNewAsk.clear();
		//Se limpian las barras que piden los datos.
		generadorAsk.getTextFieldTPregunta().setText("");
		generadorAsk.getTextAreaContenidoR().setText("");
		SesionIniciadaControl.mostrar(""); //Se muestra el inicio de la sesion iniciada.
		
	}
	
	
	/**
	 * Permite ver una etiqueta y su descripcion al hacer click en combobox con la etiqueta selecionada.
	 */
	public static void eventoMostrarContenidoEtiqueta() {

		String nombreEtiqueta = (String) generadorAsk.getComboBoxEtiquetas().getSelectedItem(); //Se obtine el nombre de la etiqueta seleccionada en el combobox.
		GettersStackService getS = new GettersStackService(InicioControl.stackService.getStack());
		String descripcion = getS.getEtiqueta(nombreEtiqueta).getDescripcion(); //Se toma la etiqueta y su descripcion.
		JOptionPane.showMessageDialog(null,nombreEtiqueta+ "\n"+descripcion); //Se muestra como Massage.
	}
	
	

}
