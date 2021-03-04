package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import _TDAs.Pregunta;
import _TDAs.Usuario;
import interfaz.PerfilFrame;

/**
 * Clase que representa el controlador para  la ventana que permite vizualizar el perfil del usuario activo en el stack. 
 * @author Alma
 *
 */
public class PerfilControl {
	
	public static PerfilFrame perfilFrame = new PerfilFrame(); //Posee una ventana de perfil de usuario.

	/**
	 * Permite mostrar la ventana actualizando alguno de sus datos.
	 */
	public static void mostrar() {
		Usuario userA = InicioControl.stackService.getStack().getActiveUser();
		perfilFrame.getLblUserName().setText(userA.getName());
		perfilFrame.getLblReputacionUser().setText(Integer.toString(userA.getReputacion())+" puntos.");
		mostrarPreguntasUser(); //Muestra las una lista de las preguntas del usuario en una tabla.
		perfilFrame.setVisible(true);
	}
	
	/**
	 * Oculta la ventana.
	 */
	public static void ocultar() {
		perfilFrame.setVisible(false);
	}
	
	/**
	 * Define el evento producido al presionar Btn volver.
	 */
	public static void eventoBtnVolverP() {
		ocultar(); //Se oculta la ventana.
		SesionIniciadaControl.mostrar(InicioControl.stackService.getStack().getActiveUser().getName()); //Se muestra el inicio de sesion iniciada.
	}

	/**
	 * Permite obtener una lista de las preguntas cuyo autor es el usuario en sesion iniciada.
	 * @return lista de preguntas del usuario.
	 */
	private static List<Pregunta> obtenerPreguntasPerfil(){
		
		List<Pregunta> preguntas = InicioControl.stackService.getStack().getPreguntas(); //toma las preguntas del stack.
		List<Pregunta> preguntasUser = new ArrayList<>(); //Se crea una lista de preguntas.
	
		for(Pregunta pregunta: preguntas){ //Se agregan a la nueva lista, solo las preguntas cuyo autor es el usuario.
			if(pregunta.getAutor().equals(InicioControl.stackService.getStack().getActiveUser().getName())) {
				preguntasUser.add(pregunta);
			}
        }
		return preguntasUser; //Se retorna la lista.
	}
	
	/**
	 * Permite mostrar las preguntas del usuario activo listadas en una tabla.
	 */
	public static void mostrarPreguntasUser() {
		List<Pregunta> preguntas = obtenerPreguntasPerfil();
		String matriz[][] = new String[preguntas.size()][5]; //Se copian en una matriz.
		
		for( int i = 0; i < preguntas.size(); i++) {
			matriz[i][0] = Integer.toString(preguntas.get(i).getId());
			matriz[i][1] = preguntas.get(i).getTitulo();
			matriz[i][2] = preguntas.get(i).getAutor();
			matriz[i][3] = Integer.toString(preguntas.get(i).getRespuestas().size());
			matriz[i][4] = preguntas.get(i).getFechaDePublicacion();
		}
		
		perfilFrame.getTablePreguntasUser().setModel(new DefaultTableModel(
			matriz,
			new String[] { "ID", "Preguntas", "Usuario", "Respuestas", "Fecha de publicacion"}
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
	 */
	public static void eventoClickPreguntaTableUser(int idPregunta, boolean b) {
		ocultar();
		InicioControl.eventoClickPreguntaTable(idPregunta, b);
		
	}
	

}
