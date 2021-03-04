package controlador;
import java.awt.Point;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import _TDAs.Pregunta;
import _TDAs.Usuario;
import interfaz.*;
import service.GettersStackService;
import service.StackService;

public class InicioControl {
	
	
	public static StackService stackService = new StackService();
	public static InicioFrame inicio = new InicioFrame();
	
	
	public static void setStackService(StackService stackService) {
		InicioControl.stackService = stackService;
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
	
	
	
	public static void mostrarTablaPreguntas() {
		
		List<Pregunta> preguntas = stackService.getStack().getPreguntas();
		
		String matriz[][] = new String[preguntas.size()][5];
		
		for( int i = 0; i < preguntas.size(); i++) {
			matriz[i][0] = Integer.toString(preguntas.get(i).getId());
			matriz[i][1] = preguntas.get(i).getTitulo();
			matriz[i][2] = preguntas.get(i).getAutor();
			matriz[i][3] = Integer.toString(preguntas.get(i).getRespuestas().size());
			matriz[i][4] = preguntas.get(i).getFechaDePublicacion();
		}
		
		inicio.getTablePreguntasStack().setModel(new DefaultTableModel(
			matriz,
			new String[] { "ID", "Preguntas", "Usuario", "Respuestas", "Fecha de publicaci\u00F3n"}
			)  {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
	}
	

	public static void eventoClickPreguntaTable(int idPregunta, Boolean bool) {
		Usuario userA = stackService.getStack().getActiveUser();

		if( userA == null) {
			ocultar();
		}else {
			SesionIniciadaControl.ocultar();
		}
		GettersStackService getS = new GettersStackService(stackService.getStack());
		Pregunta pregunta = getS.getPregunta(idPregunta);
		PreguntaControl.mostrar(pregunta, bool);
		
		
	}
	
	
	

}
