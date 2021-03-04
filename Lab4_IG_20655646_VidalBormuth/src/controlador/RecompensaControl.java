package controlador;


import javax.swing.JOptionPane;

import _TDAs.Pregunta;
import _TDAs.Recompensa;
import interfaz.RecompensaFrame;

public class RecompensaControl {
	public static RecompensaFrame recompensaFrame = new RecompensaFrame();
	private static Pregunta pregunta;
	
	public static void mostrar(Pregunta ask) {
		pregunta = ask;
		Recompensa reward = ask.getRecompensa();
		
		recompensaFrame.getLblRecompensa().setText("Esta pregunta tiene una recompensa de "+Integer.toString(reward.getMontoRecompensa())+" puntos.");
		recompensaFrame.setVisible(true);
	}
	
	public static void ocultar() {
		recompensaFrame.setVisible(false);
	}
	
	public static void eventoBtnVolverR() {
		recompensaFrame.getTextFieldPtsRecompensaOfrecida().setText("");
		ocultar();
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
