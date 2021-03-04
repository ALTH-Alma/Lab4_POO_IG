package controlador;

import javax.swing.JOptionPane;

import _TDAs.Pregunta;
import _TDAs.Recompensa;
import interfaz.RecompensaFrame;


/**
 * Clase que representa el controlador para la vista de  ventana que permite visualizar y entregar una recompensa. 
 * @author Alma
 *
 */
public class RecompensaControl {
	
	public static RecompensaFrame recompensaFrame = new RecompensaFrame(); //Posee una ventana de recomepnsa.
	private static Pregunta pregunta; //Y una pregunta.
	
	/**
	 * Muestra la ventana con la recompensa y la opcion de ofrecer, y recibe la pregunta que posee la recompensa.
	 * @param ask Pregunta que posee la recompensa.
	 */
	public static void mostrar(Pregunta ask) {
		pregunta = ask;
		//Se obtiene la recompensa de la pregunta y se muestra.
		Recompensa reward = ask.getRecompensa();
		recompensaFrame.getLblRecompensa().setText("Esta pregunta tiene una recompensa de "+Integer.toString(reward.getMontoRecompensa())+" puntos.");
		recompensaFrame.setVisible(true); //Se muestra la ventana.
	}
	
	/**
	 * Cierra la ventana.
	 */
	public static void ocultar() {
		recompensaFrame.setVisible(false);
	}
	
	/**
	 * Define el evento producido al presionar Btn volver.
	 */
	public static void eventoBtnVolverR() {
		//Se limpia la barra que piden la recompensa.
		recompensaFrame.getTextFieldPtsRecompensaOfrecida().setText("");
		ocultar(); //Se cierra la ventana.
	}
	
	
	public static void eventoBtnOfrecerRecompensa() {
		
		try {

			int montoRecompensa = Integer.parseInt(recompensaFrame.getTextFieldPtsRecompensaOfrecida().getText());
			int aux = controlador.InicioControl.stackService.reward(pregunta, montoRecompensa);
			
			if(aux == -3) {
				JOptionPane.showMessageDialog(null, "Recompensa ofrecida!!");
				ocultar();
			}else if(aux == -2) {
				JOptionPane.showMessageDialog(null, "Sesión cerrada!! \n Si desea realizara una recompensa primero debe iniciar sesión en stackOverflow.");
				ocultar();
			}else {
				JOptionPane.showMessageDialog(null, "Su reputacion es de "+aux+ " puntos \n No es suficiente para la recompensa ofrecida.");
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Por favor inserte un valor númerico");
		}
		recompensaFrame.getTextFieldPtsRecompensaOfrecida().setText("");
		
	}
}
