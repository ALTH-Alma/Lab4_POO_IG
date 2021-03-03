package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import interfaz.GenerarPreguntaFrame;


public class GenerarPreguntaControl {
	public static GenerarPreguntaFrame generadorAsk = new GenerarPreguntaFrame();
	private static List<Etiqueta> etiquetasNewAsk = new ArrayList<>();
	
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

	}
	
	public static void eventoBtnAgregarEtiqueta() {
		
		
	}
	
	public static void eventoBtnCrearEtiqueta() {
		CrearEtiquetaControl.mostrar();
	}
	
	public static void eventoBtnEnviarPregunta() {
		
		String titulo = generadorAsk.getTextFieldTPregunta().getText();
		String contenido = generadorAsk.getTextAreaContenidoR().getText();
		
		controlador.InicioControl.stackService.ask(titulo, contenido, etiquetasNewAsk);
		
	}
	
	
	public static void mostrarListaEtiquetas() {
		
		List<Etiqueta> etiquetas = InicioControl.stackService.getStack().getEtiquetas();
		String lista[] = new String[etiquetas.size()];
		
		for( int i = 0; i < etiquetas.size(); i++) {
			lista[i] = etiquetas.get(i).getName();

		}
		generadorAsk.getComboBoxEtiquetas().setModel(new DefaultComboBoxModel(lista));
				
			
	}
}
