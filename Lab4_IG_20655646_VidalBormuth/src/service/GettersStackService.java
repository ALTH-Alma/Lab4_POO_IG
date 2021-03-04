package service;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import _TDAs.Respuesta;
import _TDAs.Stack;
import _TDAs.Usuario;

/**
 * Clase que representa los servicios de busqueda de elementos en las lista que tiene un stack.
 * Esta determinada por un stack.
 * @author Alma
 *
 */
public class GettersStackService {
	
	private Stack stack; //Stack con el que se trabaja.
	
	/**
	 * Contructor de clase.
	 * @param stack Stack con el que se desea trabajar.
	 */
	public GettersStackService(Stack stack) {
		super();
		this.stack = stack;
	}

	
	/**
	 * Enceuntra y entrega una pregunta en la lista de preguntas segun su id.
	 * @param idPregunta Identificador de la pregunta buscada.
	 * @return Pregunta del id si es que se encuentra. 
	 */
	public Pregunta getPregunta(int idPregunta) {
		
	    for(Pregunta pregunta: stack.getPreguntas()){
			if(pregunta.getId() == idPregunta) {
				return pregunta;
			}
	    }
	    return null;
	}
	
	/**
	 * Encuentra y entrega una respuestas de una pregunta segun su id.
	 * @param pregunta Pregunta donde se encuentra la respuesta.
	 * @param idRespuesta //Identificador de la respuesta que se busca.
	 * @return Respuesta buscada.
	 */
	public Respuesta getRespuesta(Pregunta pregunta, int idRespuesta) {
	
	    for(Respuesta respuesta: pregunta.getRespuestas()){
			if(respuesta.getId() == idRespuesta) {
				return respuesta;
			}
	    }
	    return null;
		
	}
	
	/**
	 * Permite encontrar y entregar un usuario en la lista de usuarios del stack según su nombre.
	 * @param userName Nombre del usuarios buscado.
	 * @return Usuario con el nombre de entrada. 
	 */
	public Usuario getUser(String userName) {
		
		for(Usuario user: stack.getUsuarios()) {//Recorre toda la lista de usuarios hasta encontrarlo.
			if(user.getName().equals(userName)) {
				return user; //Si lo encuentra retorna al usuario. 
			}
		}
		return null; //Si no lo encuentra retorna null.
	}
	
	/**
	 * Encuentra y entrega una etiqueta de una lista de etiquetas segun su nombre.
	 * @param etiquetaName String nombre que identifica a la etiqueta.
	 * @return Etiqueta buscada.
	 */
	public Etiqueta getEtiqueta(String etiquetaName) {
		
		for(Etiqueta etiqueta: stack.getEtiquetas()) {//Recorre toda la lista de etiquetas hasta encontrarlo.
			if(etiqueta.getName().equals(etiquetaName)) {
				return etiqueta; //Si lo encuentra retorna la etiqueta. 
			}
		}
		return null; //Si no la encuentra retorna null.
	}


	
}
