package controlador;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import _TDAs.Pregunta;
import interfaz.SesionIniciadaFrame;

public class SesionIniciadaControl {
	
	private static String activeUserName;
	public static SesionIniciadaFrame sesionIniciada = new SesionIniciadaFrame();
	
	public static void mostrar(String actUserName) {
		mostrarTablaPreguntas();
		activeUserName = actUserName;
		sesionIniciada.getLblTitulo().setText("Bienvenido "+actUserName);
		sesionIniciada.setVisible(true);
	}
	public static void ocultar() {
		sesionIniciada.setVisible(false);
	}
	
	
	public static void mostrarTablaPreguntas() {
		
		List<Pregunta> preguntas = InicioControl.stackService.getStack().getPreguntas();
		
		String matriz[][] = new String[preguntas.size()][4];
		
		for( int i = 0; i < preguntas.size(); i++) {
			matriz[i][0] = preguntas.get(i).getTitulo();
			matriz[i][1] = preguntas.get(i).getAutor();
			matriz[i][2] = Integer.toString(preguntas.get(i).getRespuestas().size());
			matriz[i][3] = preguntas.get(i).getFechaDePublicacion();
		}
		
		sesionIniciada.getTablePreguntasStack().setModel(new DefaultTableModel(
			matriz,
			new String[] { "Preguntas", "Usuario", "Respuestas", "Fecha de publicaci\u00F3n"}
			)  {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			
	}
	
	public static void eventoBtnCerrarSesion() {
		
		if(controlador.InicioControl.stackService.logout()) {
			ocultar();
			JOptionPane.showMessageDialog(null, activeUserName + " ha cerrado sesión !!");
			InicioControl.mostrar();
			
		}else {
			ocultar();
			JOptionPane.showMessageDialog(null,"No existe sesión iniciada !!");
			InicioControl.mostrar();
		}
		
	}
	
	public static void eventoBtnHacerPregunta() {

		GenerarPreguntaControl.mostrar();
		
	}
	


}
