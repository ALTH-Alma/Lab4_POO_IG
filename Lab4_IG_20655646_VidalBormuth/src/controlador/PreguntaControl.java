package controlador;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import _TDAs.Respuesta;
import _TDAs.Usuario;
import interfaz.PreguntaFrame;


public class PreguntaControl {
	
	public static PreguntaFrame askFrame = new PreguntaFrame();
	private static Pregunta pregunta;
	
	public static void mostrar(Pregunta ask) {
		pregunta = ask;
		
		askFrame.getLblPregunta().setText(ask.getTitulo());
		askFrame.getLblDescripcion().setText(ask.getContenido());
		askFrame.getLblFecha().setText(ask.getFechaDePublicacion());
		askFrame.getLblAutor().setText(ask.getAutor());
		askFrame.getLblEstado().setText(ask.getEstado());
		askFrame.getLblVotosFavor().setText(Integer.toString(ask.getVotosAFavor()));
		askFrame.getLblVotosContra().setText(Integer.toString(ask.getVotosEnContra()));
		mostrarListaEtiquetasPregunta();
		mostrarTableRespuestas();
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
	
	private static void mostrarTableRespuestas() {
		
		List<Respuesta> respuestas = pregunta.getRespuestas();
		
		String matriz[][] = new String[respuestas.size()][4];
		
		for( int i = 0; i < respuestas.size(); i++) {
			matriz[i][0] = Integer.toString(respuestas.get(i).getId());
			matriz[i][1] = respuestas.get(i).getContenido();
			matriz[i][2] = respuestas.get(i).getAutor();
			matriz[i][3] = respuestas.get(i).getFechaDePublicacion();
		}
		
		askFrame.getTableRespuestas().setModel(new DefaultTableModel(
				matriz,
				new String[] {
					"ID", "Respuestas", "Usuario", "Fecha de publicaci\u00F3n"
				}
			));
	}
	
	public static void eventoClickRespuestaTable(int idRespuesta) {
		Respuesta respuesta = pregunta.getRespuestas().get(idRespuesta);
		RespuestaControl.mostrar(respuesta);
	}
}
