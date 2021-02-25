package _TDAs;

/**
 * Clase para representar usuarios en el stack.
 * Cada usuario queda determinado por un nombre, una clave y una reputación.
 * @author Alma
 */

public class Usuario {

	private String name; //Nombre único del usuario.
	private String pass; //Clave del usuario.
	private int reputacion; //Puntos de reputación del usuario.
	
	
	/**
	 * Crea un usuario a partir de un nombre y una clave.
	 * @param name Nombre de usuario.
	 * @param pass Clave de usuario.
	 */
	public Usuario(String name, String pass) {
		this.name = name;
		this.pass = pass;
		this.reputacion = 0;
		
	}
	
	/**
	 * Crea un usuario a partir de un nombre, una contraseña y una reputación (mayor o igual a 0).
	 * @param name Nombre de usuario.
	 * @param pass Clave de usuario.
	 * @param reputacion Puntos de reputación del usuario.
	 */
	public Usuario(String name, String pass, int reputacion) {
		this.name = name;
		this.pass = pass;
		this.reputacion = reputacion;
		
	}

	/**
	 * Entrega el nombre del usuario.
	 * @return El nombre del usuario.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Modifica el nombre de usuario.
	 * @param name Nombre del usuario.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Entrega la clave del usuario.
	 * @return La clave del usuario.
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * Le permite al usuario cambiar su clave.
	 * @param pass Clave del usuario.
	 */
	public void setPass(String pass) {
		this.pass = pass;	
	}

	/**
	 * Entrega los puntos de reputación del usuario.
	 * @return Puntos de reputación del usuario.
	 */
	public int getReputacion() {
		return reputacion;
	}

	/**
	 * Permite modificar los puntos de reputación del usuario.
	 * @param reputacion Puntos de reputación usuario.
	 */
	public void setReputacion(int reputacion) {
		this.reputacion = reputacion;
	}
	
	
	/**
	 * Muestra un usuario.
	 */
	public void mostrarUsuario() {
		System.out.println("Nombre: "+name+"\nContraseña: "+pass+"\nReputación: "+reputacion+"\n");
	}

	
	/**
	 * Agrega un monto a la reputacion
	 * @param monto Monto a agregar (puede ser positivo o negativo).
	 */
	public void agregarPuntosAReputacion(int monto) {
		reputacion = reputacion + monto;
		if(reputacion < 0) {
			reputacion = 0;
		}
	}


}