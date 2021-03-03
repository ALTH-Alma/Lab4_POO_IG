package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import interfaz.GenerarPreguntaFrame;


public class GenerarPreguntaControl {
	public static GenerarPreguntaFrame generadorAsk = new GenerarPreguntaFrame();
	static List<Etiqueta> etiquetasNewAsk = new ArrayList<>();
	
	public static void mostrar() {
		generadorAsk.setVisible(true);
		mostrarListaEtiquetas();
	}
	public static void ocultar() {
		generadorAsk.setVisible(false);
	}
	
	public static void eventoBtnCancelar() {
		ocultar();
		generadorAsk.getTextFieldTPregunta().setText("");
		generadorAsk.getTextAreaContenidoR().setText("");
		etiquetasNewAsk.clear();
		SesionIniciadaControl.mostrar("");

	}
	
	public static void mostrarListaEtiquetas() {
		
		List<Etiqueta> etiquetas = InicioControl.stackService.getStack().getEtiquetas();
		String lista[] = new String[etiquetas.size()];
		
		for( int i = 0; i < etiquetas.size(); i++) {
			lista[i] = etiquetas.get(i).getName();
		}
		generadorAsk.getComboBoxEtiquetas().setModel(new DefaultComboBoxModel(lista));	
	}
	
	public static void eventoBtnCrearEtiqueta() {
		ocultar();
		CrearEtiquetaControl.mostrar();
	}
	
	public static void eventoBtnAgregarEtiqueta() {
		
		String nombreEtiqueta = (String) generadorAsk.getComboBoxEtiquetas().getSelectedItem();
		etiquetasNewAsk.add(InicioControl.stackService.getEtiqueta(nombreEtiqueta));
		JOptionPane.showMessageDialog(null,"Se ha gregado la etiqueta "+nombreEtiqueta+ " a la lista de etiquetas de su pregunta.");
	}
	
	private static List<Etiqueta> crearListEtiquetas(List<Etiqueta> listaEtiquetas){
		
		List<Etiqueta> etiquetasNew = new ArrayList<>();
		for( int i = 0; i < listaEtiquetas.size(); i++) {
			etiquetasNew.add(listaEtiquetas.get(i));
		}
		return etiquetasNew;
	}
	

	public static void eventoBtnEnviarPregunta() {
		
		String titulo = generadorAsk.getTextFieldTPregunta().getText();
		String contenido = generadorAsk.getTextAreaContenidoR().getText();
		
		controlador.InicioControl.stackService.ask(titulo, contenido, crearListEtiquetas(etiquetasNewAsk));
		
		ocultar();
		etiquetasNewAsk.clear();
		generadorAsk.getTextFieldTPregunta().setText("");
		generadorAsk.getTextAreaContenidoR().setText("");
		SesionIniciadaControl.mostrar("");
		
	}
	
	

}
