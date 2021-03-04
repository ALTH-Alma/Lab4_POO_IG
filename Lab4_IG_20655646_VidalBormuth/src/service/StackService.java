package service;

import java.util.List;

import javax.swing.JOptionPane;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import _TDAs.Recompensa;
import _TDAs.Respuesta;
import _TDAs.Stack;
import _TDAs.Usuario;

/**
 * Clase que representa los servicios que ofrece stack overflow.. 
 * @author Alma
 *
 */
public class StackService {
	
	private Stack stack;

	/**
	 * Crea un stackService en base a un satck y un usuario activo.
	 * @param s1 
	 * @param stack Stack con el que se trabaja.
	 * @param usuarioActivo Usuario Activo que realiza cambios en stack.
	 */
	public StackService() {
		this.stack = new Stack();
	}


	/**
	 * Entrega el stack de StackService.
	 * @return Stack.
	 */
	public Stack getStack() {
		return stack;
	}
	
	public void setStack(Stack stack) {
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
	private Respuesta getRespuesta(Pregunta pregunta, int idRespuesta) {
	
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
	private Usuario getUser(String userName) {
		
		for(Usuario user: stack.getUsuarios()) {//Recorre toda la lista de usuarios hasta encontrarlo.
			if(user.getName().equals(userName)) {
				return user; //Si lo encuentra retorna al usuario. 
			}
		}
		return null; //Si no lo encuentra retorna null.
	}
	
	public Etiqueta getEtiqueta(String etiquetaName) {
		
		for(Etiqueta etiqueta: stack.getEtiquetas()) {//Recorre toda la lista de usuarios hasta encontrarlo.
			if(etiqueta.getName().equals(etiquetaName)) {
				return etiqueta; //Si lo encuentra retorna al usuario. 
			}
		}
		return null; //Si no lo encuentra retorna null.
	}

	
	
	
	
//_________________________________________________________________	
	/**
	 * Permite registrar a un usuario. Agrega un nuevo usuario en la lista de usuarios del stack, si 
	 * el nombre del nuevo de usuario del usuario que desea ingresar es diferentes a todos los nombres de usuarios en el stack.
	 * Si el nombre ya existe no hace nada.
	 * @param newUserName El nuevo nombre de usuario de la persona que desea registrarse. 
	 * @param newPass La nueva clave que se desea usar en el registro.
	 * @return un booleano, true si se logra registrar al usuario y false sino. 
	 */
	public boolean register(String newUserName, String newPass) {

		if(getUser(newUserName) == null) { //Si no se encontro un usuario con el nuevo nombre de usuario...
			stack.getUsuarios().add(new Usuario(newUserName, newPass)); //Se agrega el nuevo usuario.
			return true; // Si se registra retorna true.
		}else { //Sino no hace nada y anuncia que no se pudo registrar al usuario.
			return false; //si no se registra retorna false.
		}
	}
	
//___________________________________________________________________
	/**
	 * Permite a un usuario registrarse en un stack. Si se autentifican los datos del usuario, el usuario se entrega por esta 
	 * funcion y pasa a ser el usuario activo en el menu que permite realizar cambios dentro de stack.
	 * @param userName Nombre del usuario que desea ingresar.
	 * @param userPass Contraseña del usuario.
	 * @return 
	 */
	public int login(String userName, String userPass) {
		
		Usuario user = getUser(userName); //Se obtiene al usuario con el nombre.
		Usuario userA = stack.getActiveUser();
		
		if(userA != null) { //Si ya existe sesion iniciada.
			return 3; //Retorna 3.
		}else if(user == null) { //Si el nombre de usuario no existe en registrados.
			return 2; //Retorna 2.
		}else if(!user.getPass().equals(userPass)) { //Si se encontro el usuario y la clave no coincide con la ingresada.
			return 1; //Retorna 1.
		}else { //Si pasa todas las prueba inicia sesión.
			stack.setActiveUser(user);
			return 0; //Retorna un 1.
			
		}
		
	}
	
//______________________________________________________________________
	
	/**
	 * Permite que un usuario activo desactive su sesión. 
	 */
	public boolean logout() {
		
		Usuario userA = stack.getActiveUser();
		
		if(userA != null) {//Si los datos corresponden al usuario...
			stack.setActiveUser(null); //Se cierra sesión y usario activo vacio.
			return true;
		}else {
			return false;
		}
	}
	
//________________________________________________________________________
	
	/**
	 * Le permite a un usuario realizar una nueva pregunta en un stack. Agrega una pregunta a la lista de preguntas del stack.
	 * @param newTitulo Titulo de la nueva pregunta.
	 * @param newContenido Contenido de la nueva pregunta.
	 * @param newEtiquetas Lista de etiquetas para la nueva pregunta. 
	 */
	public void ask(String newTitulo, String newContenido, List<Etiqueta> newEtiquetas) {
		
		stack.getPreguntas().add(new Pregunta(stack.getActiveUser().getName(), newTitulo, newContenido, newEtiquetas));

	}
	
	
//__________________________________________________________________
	
	
	/**
	 * Le permite a un usuario con sesión activa responde una pregunta abierta en el stack. 
	 * @param idPregunta Identificador de la pregunta que se quiere responder. 
	 * @param contenidoRespuesta Contenido de la nueva respuesta.
	 */
	public int answer(int idPregunta, String contenidoRespuesta) {
        
        Pregunta pregunta = getPregunta(idPregunta);
        Usuario userA = stack.getActiveUser();
        
        if(pregunta == null || userA == null) {
        	return 1;
        }else if(pregunta.getEstado().equals("Abierta.")) { //Si existe la pregunta, existe usuario activo y esta abierta
        	pregunta.getRespuestas().add(new Respuesta(userA.getName(), contenidoRespuesta)); //Se le agrega una respuesta a su lista de respuestas.
        	return 0;
        }else {
        	return 2;
        }		
	}
		
	
	
	/**
	 * Permite agregar una recompensa por una pregunta. Actualiza reputación del ofertor. 
	 * @param pregunta Pregunta a la que se le entrega la recompensa.
	 * @param montoRecompensa Monto que se le agrega a la recompensa (Debe der menor que la reputación actual del usuario al realizarce).
	 * @param reputacionUA //Reputacion del usuario activo que agrega la recompensa.
	 */
	public void realizarRecompensa(Pregunta pregunta, int montoRecompensa, Usuario userA) {
		
		RewardService rewardService = new RewardService(pregunta.getRecompensa());
		rewardService.aumentarRecompensa(montoRecompensa, userA.getName()); //Se realiza la recompensa.
		userA.setReputacion(userA.getReputacion()-montoRecompensa); //se actualiza reputacion de usuario activo.
	}
	
	/**
	 * Le permite a un usuario con sesión activa entrgar una recompensa por una pregunta abierta.
	 * @param idPregunta Identificador de la pregunta a la que se le quiere agregar recompensa. 
	 * @param montoRecompensa Monto a agregar en la recompensa (debe ser menor que la reputación
	 * del usuario activo.
	 */
	public int reward(Pregunta pregunta, int montoRecompensa) {
		
		Usuario userA = stack.getActiveUser();
		
		if(pregunta == null || userA == null) { //Si no hay usuario activo o no existe la pregunta...
			return -2; //Retorna -2.
		}
		else {
			int reputacionUA = userA.getReputacion();
			
			if(reputacionUA < montoRecompensa) {//Si la recompensa es mayor que la reputacion de UA...
				return reputacionUA; //Retorna -3.
			}else { //Sino..
				realizarRecompensa(pregunta, montoRecompensa, userA); //Se entrega la recompensa.
				return -3; //retorna -3;
			}
		}
	}

	
	
	
	
	
	

	
	/**Permite aceptar una respuesta y modificar recompensas segun lo establecido por stack overflow.
	 * @param respuesta Respuesta  que se quiere aceptar.
	 * @param recompensa Recompensa por la pregunta a la que corresponde la respuesta. 
	 */
	private void aceptarRespuesta(Respuesta respuesta, Recompensa recompensa) {
		RewardService rs = new RewardService(recompensa);
		if(respuesta != null && respuesta.getEstado().equals("Pendiente.")) {//Si la respuesta existe y su estado es pendiente.
			respuesta.setEstado("Aceptada."); //Se acepta la respuesta.
			//getUser(respuesta.getAutor()).agregarPuntosAReputacion((15+rs.entregarRecompensa())); //Se actualiza reputacion de autor de la respuesta.
			stack.getActiveUser().agregarPuntosAReputacion(2);//Se actualiza reputación del usuario Activo.
			System.out.println("\nSe ha aceptado la respuesta "+respuesta.getId()+".");
		}else {
			System.out.println("\n#NO ES POSIBLE ACEPTAR");
		}
	}
	
	/**
	 * Permite a un usuario con sesión activa  aceptar una respuesta de una de sus preguntas.
	 * @param idPregunta Identificador de la pregunta a la que corresponde la respuestas. 
	 * @param idRespuesta Identificador de la respuesta a aceptar. 
	 */
	public void accept(int idPregunta, int idRespuesta) {

		Pregunta pregunta = getPregunta(idPregunta);//Si la pregunta existe, esta abierta y pertenece al usuario. 
		if(pregunta != null && pregunta.getEstado().equals("Abierta.") && pregunta.getAutor().equals(stack.getActiveUser().getName())) { 
			Recompensa recompensa = pregunta.getRecompensa();
			Respuesta respuesta = getRespuesta(pregunta, idRespuesta);
			aceptarRespuesta(respuesta, recompensa); //Se acepta la respuesta tomando como parametros la respuesta y la recompensa de la pregunta.
		}else {
			System.out.println("\n#PREGUNTA INEXISTENTE"); //Sino no se hace nada.
		}

	}
}
