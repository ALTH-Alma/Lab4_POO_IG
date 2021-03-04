package controlador;

import javax.swing.JOptionPane;

import _TDAs.Pregunta;
import _TDAs.Respuesta;
import interfaz.RespuestaFrame;

/**
 * Clase que representa el controlador para la vista de la ventana que permite visualizar una respuesta.
 * Permite Aceptar una respuesta.
 * @author Alma
 *
 */
public class RespuestaControl {
	
	public static RespuestaFrame respuestaFrame = new RespuestaFrame(); //Posee una ventana de respuesta.
	private static Pregunta pregunta; //una pregunta
	private static Respuesta respuesta; //y y una respuesta.
	
	/**
	 * Permite mostrar la ventana actualizando alguno de sus datos.
	 * @param ask Prgunta a la que corresponde la respuesta.
	 * @param answer Respuesta que se mostrara por ventana.
	 * @param bool Un booleano que sirve para identificar si el usuario se encuentra en su lista de preguntas propias o no.
	 */
	public static void mostrar(Pregunta ask, Respuesta answer, Boolean bool) {
		respuesta = answer; //Se guarda la respuesta
		pregunta = ask; //Y la pregunta
		//Se modifican los lbl's de la ventana con los datos de la respuesta, de esta forma mostrar por la ventana la respuesta y sus componentes.
		respuestaFrame.getLblRespuesta().setText(answer.getContenido());
		respuestaFrame.getLblFecha().setText(answer.getFechaDePublicacion());
		respuestaFrame.getLblAutor().setText("Autor: "+answer.getAutor());
		respuestaFrame.getLblEstado().setText(answer.getEstado());
		respuestaFrame.getLblVotosFavor().setText(Integer.toString(answer.getVotosAFavor()));
		respuestaFrame.getLblVotosContra().setText(Integer.toString(answer.getVotosEnContra()));
		
		if(!bool) { //Si el usuario no se encuentra en sus lista personal de preguntas (Bool = false), 
			respuestaFrame.remove(respuestaFrame.getBtnAceptar()); //Se remueve el boton que permite aceptar una respuesta de la venttana.
		}else {
			respuestaFrame.add(respuestaFrame.getBtnAceptar()); //y si esta en su lista personal le da la opcion, de aceptar respuestas, muestra el boton.
		}
		respuestaFrame.setVisible(true); //Se muestra la ventana.
	}
	
	/**
	 * Cierra la ventana respuesta.
	 */
	public static void ocultar() {
		respuestaFrame.setVisible(false);
	}

	
	/**
	 * Define el evento producido al presionar Btn volver.
	 */
	public static void eventoBtnVolverR() {
		ocultar();//Se oculta la ventana.
	}
	
	
	/**
	 * Define el evento producido al presionar el boton aceptar.
	 * Permite aceptar una respuesta del stack usando la función accept.
	 */
	public static void eventoBtnAceptar() {
		
		int aux = controlador.InicioControl.stackService.accept(pregunta, respuesta); //Se intenta aceptar la respuesta con accept.
		//Segun el valor que tome el aux se determina si se acepto la respuesta y si no fue asi, se determina porque.
		if(aux == 0) {
			JOptionPane.showMessageDialog(null, "Respuesta aceptada!!");
		}else if(aux == 1){
			JOptionPane.showMessageDialog(null, "Esta pregunta no se puede aceptar, pues ya esta aceptada!!");
		}else {
			JOptionPane.showMessageDialog(null, "Esta pregunta no se puede aceptar, pues la pregunta a la que pertenece se encuentra cerrada!!");
		}
		ocultar(); //Se oculta la ventana.
		
	}
}
