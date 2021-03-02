package controlador;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import _TDAs.Pregunta;
import interfaz.*;
import service.StackService;

public class InicioControl {
	
	
	public static StackService stackService = new StackService();
	public static InicioFrame inicio = new InicioFrame();
	
	
	public static void setStackService(StackService stackService) {
		InicioControl.stackService = stackService;
	}

	
	
	
	public static void mostrarTablaPreguntas() {
		
		List<Pregunta> preguntas = stackService.getStack().getPreguntas();
		
		String matriz[][] = new String[preguntas.size()][4];
		
		for( int i = 0; i < preguntas.size(); i++) {
			matriz[i][0] = preguntas.get(i).getTitulo();
			matriz[i][1] = preguntas.get(i).getAutor();
			matriz[i][2] = Integer.toString(preguntas.get(i).getRespuestas().size());
			matriz[i][3] = preguntas.get(i).getFechaDePublicacion();
		}
		
		inicio.getTablePreguntasStack().setModel(new DefaultTableModel(
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
	
	public static void mostrar() {
		inicio.setVisible(true);
		mostrarTablaPreguntas();
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
