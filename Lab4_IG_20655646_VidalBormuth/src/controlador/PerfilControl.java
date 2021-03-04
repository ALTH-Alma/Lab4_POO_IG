package controlador;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import _TDAs.Pregunta;
import _TDAs.Usuario;
import interfaz.PerfilFrame;


public class PerfilControl {
	public static PerfilFrame perfilFrame = new PerfilFrame();

	public static void mostrar() {
		Usuario userA = InicioControl.stackService.getStack().getActiveUser();
		perfilFrame.getLblUserName().setText(userA.getName());
		perfilFrame.getLblReputacionUser().setText(Integer.toString(userA.getReputacion())+" puntos.");
		mostrarPreguntasUser();
		perfilFrame.setVisible(true);
	}
	
	public static void ocultar() {
		perfilFrame.setVisible(false);
	}
	
	public static void eventoBtnVolverP() {
		ocultar();
		SesionIniciadaControl.mostrar(InicioControl.stackService.getStack().getActiveUser().getName());
	}

	private static List<Pregunta> obtenerPreguntasPerfil(){
		
		List<Pregunta> preguntas = InicioControl.stackService.getStack().getPreguntas();
		List<Pregunta> preguntasUser = new ArrayList<>();
	
		for(Pregunta pregunta: preguntas){
			if(pregunta.getAutor().equals(InicioControl.stackService.getStack().getActiveUser().getName())) {
				preguntasUser.add(pregunta);
			}
        }
		return preguntasUser;
	}
	
	public static void mostrarPreguntasUser() {
		List<Pregunta> preguntas = obtenerPreguntasPerfil();
		String matriz[][] = new String[preguntas.size()][5];
		
		for( int i = 0; i < preguntas.size(); i++) {
			matriz[i][0] = Integer.toString(preguntas.get(i).getId());
			matriz[i][1] = preguntas.get(i).getTitulo();
			matriz[i][2] = preguntas.get(i).getAutor();
			matriz[i][3] = Integer.toString(preguntas.get(i).getRespuestas().size());
			matriz[i][4] = preguntas.get(i).getFechaDePublicacion();
		}
		
		perfilFrame.getTablePreguntasUser().setModel(new DefaultTableModel(
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

	public static void eventoClickPreguntaTableUser(int idPregunta, boolean b) {
		ocultar();
		InicioControl.eventoClickPreguntaTable(idPregunta, b);
		
	}
	

}
