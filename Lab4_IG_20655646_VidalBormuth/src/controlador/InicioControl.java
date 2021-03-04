package controlador;
import java.awt.Point;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import _TDAs.Pregunta;
import _TDAs.Usuario;
import interfaz.*;
import service.GettersStackService;
import service.StackService;


/**
 * Clase que representa el controlador para la vista de la ventana inicio de stackOverflow.
 * @author Alma
 *
 */
public class InicioControl {
	
	
	public static StackService stackService = new StackService(); //Y posee un stackService con el se trabajo.
	public static InicioFrame inicio = new InicioFrame(); //Posee una ventana de inicio a stack.
	
	/**
	 * Constructor de la clase InicioControl.
	 * permite contruir un inicio control a partir de un stackService.
	 * @param stackService stackService con el se trabajo, posee el stack.
	 */
	public static void setStackService(StackService stackService) {
		InicioControl.stackService = stackService;
	}
	
	/**
	 * Muestra la ventana.
	 */
	public static void mostrar() {
		inicio.setVisible(true);
		mostrarTablaPreguntas(); //muestra la tabla de preguntas del stack.
	}
	
	/**
	 * Oculta la ventana.
	 */
	public static void ocultar() {
		inicio.setVisible(false);
	}

	/**
	 * Define el evento producido al presionar Btn Ingresar.
	 */
	public static void eventoBtnIngresar() {
		ocultar();
		AccederControl.mostrar(); //Se muestra la ventana para acceder al stack.
	}
	
	/**
	 * Define el evento producido al presionar Btn registrarse.
	 */
	public static void eventoBtnRegistrarse() {
		ocultar();
		RegisterControl.mostrar(); //Se muestra la ventana para registrarse en el stack.
	}
	
	
	/**
	 * Permite mostrar las preguntas del stack listadas en una tabla.
	 */
	public static void mostrarTablaPreguntas() {
		
		List<Pregunta> preguntas = stackService.getStack().getPreguntas();
		
		String matriz[][] = new String[preguntas.size()][5]; //Se copian en una matriz.
		
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
			}); //Se modifica la tabla de la ventana añadiendo la matriz con las preguntas.
	}
	
	
	/**
	 *  Define el evento producido al hacer click a alguna de las preguntas en la tabla.
	 *  permite abrir una pregunta y mostrar sus caracteristicas..
	 * @param idPregunta identificador númerico de la pregunta clickeada.
	 */
	public static void eventoClickPreguntaTable(int idPregunta, Boolean bool) {
		Usuario userA = stackService.getStack().getActiveUser();

		if( userA == null) { //Si no existe sesion abierta se oculta la ventana.
			ocultar();
		}else {
			SesionIniciadaControl.ocultar(); //Si existe, se oculta la ventana de inico de sesion.
		}
		GettersStackService getS = new GettersStackService(stackService.getStack());
		Pregunta pregunta = getS.getPregunta(idPregunta); //Se obtiene la pregunta.
		PreguntaControl.mostrar(pregunta, bool); //Se muestra la pregunta.
		
		
	}
	
	
	

}
