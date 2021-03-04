package _TDAs;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase que representa un stack.
 * Esta clase esta determinada por un id único incremental, una lista de usuarios, una lista de preguntas, una lista de etiquetas y un usuario para representar el usuario activo en el stack. 
 * @author Alma
 *
 */
public class Stack  {
	
	private List<Usuario> usuarios; //Lista de usuarios.
	private List<Pregunta> preguntas; //Lista de preguntas.
	private List<Etiqueta> etiquetas; //Lista de etiquetas. 
	private Usuario activeUser = null; //Usuario activo.
	/**
	 * Crea un nuevo stack a partir de una lista de usuarios, una lista de preguntas y una lista de etiquetas. 
	 * @param usuarios Lista de usuarios.
	 * @param preguntas Lista de preguntas.
	 * @param etiquetas Lista de etiquetas. 
	 */
	public Stack(List<Usuario> usuarios, List<Pregunta> preguntas, List<Etiqueta> etiquetas) {
		this.usuarios = usuarios;
		this.preguntas = preguntas;
		this.etiquetas = etiquetas;

	}
	
	/**
	 * Crea un nuevo stack sin ningun parametro, inicializando todo desde cero.
	 */
	public Stack() {
		this.usuarios = new ArrayList<Usuario>();
		this.preguntas = new ArrayList<Pregunta>();
		this.etiquetas = new ArrayList<Etiqueta>();
	}
	

	/**
	 * Permite obtener la lista de usuarios del stack.
	 * @return Lista de usuarios.
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	/**
	 * Permite modificar la lista de usuarios del stack.
	 * @param usuarios Lista de usuarios. 
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	/**
	 * Entraga la lista de preguntas del stack.
	 * @return Lista de preguntas.
	 */
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	/**
	 * Permite modificar las lista de preguntas del stack.
	 * @param preguntas Nueva lista de preguntas. 
	 */
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	/**
	 * Entrega la lista de etiquetas del stack.
	 * @return Lista de etiquetas del stack.
	 */
	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}
	/**
	 * Permite modificar la lista de etiquetas del stack.
	 * @param etiquetas Nueva lista de etiquetas. 
	 */
	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	/**
	 * Entrega al usuario activo en el stack
	 * @return Usuario activo.
	 */
	public Usuario getActiveUser() {
		return activeUser;
	}

	/**
	 * Permite modificar al usuario activo del stack.
	 * @param activeUser Nuevo usuario activo.
	 */
	public void setActiveUser(Usuario activeUser) {
		this.activeUser = activeUser;
	}
	
	
}
