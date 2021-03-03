package controlador;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import _TDAs.Usuario;
import interfaz.PreguntaFrame;


public class PreguntaControl {
	
	public static PreguntaFrame askFrame = new PreguntaFrame();
	private static Pregunta pregunta;
	
	public static void mostrar(Pregunta preg) {
		pregunta = preg;
		
		askFrame.getLblPregunta().setText(preg.getTitulo());
		askFrame.getLblDescripcion().setText(preg.getContenido());
		askFrame.getLblFecha().setText(preg.getFechaDePublicacion());
		askFrame.getLblAutor().setText(preg.getAutor());
		askFrame.getLblEstado().setText(preg.getEstado());
		askFrame.getLblVotosFavor().setText(Integer.toString(preg.getVotosAFavor()));
		askFrame.getLblVotosContra().setText(Integer.toString(preg.getVotosEnContra()));
		mostrarListaEtiquetasPregunta();
		askFrame.setVisible(true);
	}
	public static void ocultar() {
		askFrame.setVisible(false);
	}
	
	public static void eventoBtnVolverPregunta() {
		Usuario userA = InicioControl.stackService.getStack().getActiveUser();
		ocultar();
		if( userA== null) {
			InicioControl.mostrar();
		}else {
			SesionIniciadaControl.mostrar(userA.getName());
		}
	}
	
	private static void mostrarListaEtiquetasPregunta() {
		
		List<Etiqueta> etiquetas = pregunta.getEtiquetas();
		String lista[] = new String[etiquetas.size()];
		
		for( int i = 0; i < etiquetas.size(); i++) {
			lista[i] = etiquetas.get(i).getName();
		}
		askFrame.getComboBoxEtiquetasPregunta().setModel(new DefaultComboBoxModel(lista));	
	}
}
