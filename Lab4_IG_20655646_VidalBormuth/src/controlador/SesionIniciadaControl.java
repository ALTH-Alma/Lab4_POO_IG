package controlador;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import _TDAs.Pregunta;
import interfaz.SesionIniciadaFrame;

/**
 * Clase que representa el controlador para la vista de la ventana que permite dar el inicio de una sesión iniciada de StackOverflow.
 * @author Alma
 *
 */
public class SesionIniciadaControl {
	
	private static String activeUserName; //Posee un string para el nombre del usuario activo.
	public static SesionIniciadaFrame sesionIniciada = new SesionIniciadaFrame(); //Posee una ventana de sesionIniciada.
	
	
	/**
	 * Muestra la ventana, con modificaciones en sus labl's segun el usuario activo.
	 * @param actUserName nombre de usuario activo.
	 */
	public static void mostrar(String actUserName) {
		mostrarTablaPreguntas(); //Muestra la tabla de preguntas del stack.
		activeUserName = actUserName;
		sesionIniciada.getLblTitulo().setText("Bienvenido "+actUserName);
		sesionIniciada.setVisible(true);
	}
	
	/**
	 * Oculta la ventana.
	 */
	public static void ocultar() {
		sesionIniciada.setVisible(false);
	}
	
	
	/**
	 * Permite mostrar las preguntas del stack listadas en una tabla.
	 */
	public static void mostrarTablaPreguntas() {
		
		List<Pregunta> preguntas = InicioControl.stackService.getStack().getPreguntas();
		
		String matriz[][] = new String[preguntas.size()][5]; //Se copian en una matriz.
		
		for( int i = 0; i < preguntas.size(); i++) {
			matriz[i][0] = Integer.toString(preguntas.get(i).getId());
			matriz[i][1] = preguntas.get(i).getTitulo();
			matriz[i][2] = preguntas.get(i).getAutor();
			matriz[i][3] = Integer.toString(preguntas.get(i).getRespuestas().size());
			matriz[i][4] = preguntas.get(i).getFechaDePublicacion();
		}
		
		sesionIniciada.getTablePreguntasStack().setModel(new DefaultTableModel(
			matriz,
			new String[] { "ID", "Preguntas", "Usuario", "Respuestas", "Fecha de publicacion"}
			)  {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});//Se modifica la tabla de la ventana añadiendo la matriz con las preguntas.
	}
	
	/**
	 * Define el evento producido al presionar Btn cerrarSesion.
	 * Permite cerrar la sesion activa el stack con el metodo logout.
	 */
	public static void eventoBtnCerrarSesion() {
		
		if(controlador.InicioControl.stackService.logout()) { //Si se logra cerrar sesion..
			ocultar(); //Se oculta la ventana
			JOptionPane.showMessageDialog(null, activeUserName + " ha cerrado sesion !!");
			InicioControl.mostrar(); //y se muestra la ventada de inicio stack.
			
		}else { //Si no
			ocultar();
			JOptionPane.showMessageDialog(null,"No existe sesion iniciada !!");
			InicioControl.mostrar(); //Se muestra el inicio.
		}
		
	}
	
	/**
	 * Define el evento producido al presionar Btn hacer pregunta.
	 * Permite entrar a la ventana para crear pregunta.
	 */
	public static void eventoBtnHacerPregunta() {
		ocultar(); //Se oculta ventana
		GenerarPreguntaControl.mostrar(); // y se muestra la ventana para generar una nueva pregunta.
		
	}
	


}
