package service;

import java.util.List;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import _TDAs.Recompensa;
import _TDAs.Respuesta;
import _TDAs.Stack;
import _TDAs.Usuario;

/**
 * Clase que representa los servicios que ofrece stackOverflow.. 
 * @author Alma
 *
 */
public class StackService {
	
	private Stack stack;

	/**
	 * Crea un stackService en base a un stack.
	 * @param stack Stack con el que se trabaja.
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
	
	/**
	 * Modifica el stack de stack service.
	 * @param stack Stack que reemplaza al stack dentro de la clase.
	 */
	public void setStack(Stack stack) {
		this.stack = stack;
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
		GettersStackService getS = new GettersStackService(stack);
		if(getS.getUser(newUserName) == null) { //Si no se encontro un usuario con el nuevo nombre de usuario...
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
	 * @return número. Sirve para determinar si se inicio sesion y si no fue asi, el porque paso.
	 */
	public int login(String userName, String userPass) {
		
		GettersStackService getS = new GettersStackService(stack);
		Usuario user = getS.getUser(userName); //Se obtiene al usuario con el nombre.
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
	 * * @return un booleano, true si se cierra sesión y false sino. 
	 */
	public boolean logout() {
		
		Usuario userA = stack.getActiveUser();
		
		if(userA != null) {//Si existe sesion activa...
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
	 * @return número. Sirve para determinar si se agrego una respuesta y si no fue asi, el porque paso.
	 */
	public int answer(int idPregunta, String contenidoRespuesta) {
        
		GettersStackService getS = new GettersStackService(stack);
        Pregunta pregunta = getS.getPregunta(idPregunta); //Se obtiene la pregunta que se desea responder.
        Usuario userA = stack.getActiveUser(); // y al usuario activo.
        
        if(pregunta == null || userA == null) { //Se la pregunta no existe o no existe usuario activo...
        	return 1; //Se retorna 1.
        }else if(pregunta.getEstado().equals("Abierta.")) { //Si existe la pregunta, existe usuario activo y esta abierta la pregunta..
        	pregunta.getRespuestas().add(new Respuesta(userA.getName(), contenidoRespuesta)); //Se le agrega una respuesta a su lista de respuestas.
        	return 0; //Se retorna 0.
        }else { //Si la pregunta esta cerrada.
        	return 2; //Se retorna un 2.
        }		
	}
		
	
	//__________________________________________________________________
	
	/**
	 * Permite agregar una recompensa por una pregunta. Actualiza reputación del ofertor. 
	 * @param pregunta Pregunta a la que se le entrega la recompensa.
	 * @param montoRecompensa Monto que se le agrega a la recompensa (Debe der menor que la reputación actual del usuario al realizarce).
	 * @param userA //Usuario activo que agrega la recompensa.
	 */
	private void realizarRecompensa(Pregunta pregunta, int montoRecompensa, Usuario userA) {
		
		RewardService rewardService = new RewardService(pregunta.getRecompensa());
		rewardService.aumentarRecompensa(montoRecompensa, userA.getName()); //Se realiza la recompensa.
		userA.setReputacion(userA.getReputacion()-montoRecompensa); //se actualiza reputacion de usuario activo.
	}
	
	/**
	 * Le permite a un usuario con sesión activa entregar una recompensa por una pregunta abierta.
	 * @param pregunta Pregunta a la que se le quiere agregar recompensa. 
	 * @param montoRecompensa Monto a agregar en la recompensa (debe ser menor que la reputación
	 * del usuario activo.
	 * @return número. Sirve para determinar si se agrego una recompensa y si no fue asi, el porque paso.
	 */
	public int reward(Pregunta pregunta, int montoRecompensa) {
		
		Usuario userA = stack.getActiveUser();
		if(pregunta == null || userA == null) { //Si no hay usuario activo o no existe la pregunta...
			return -2; //Retorna -2.
		}else {
			int reputacionUA = userA.getReputacion();
			if(reputacionUA < montoRecompensa) {//Si la recompensa es mayor que la reputacion de UA...
				return reputacionUA; //Retorna la reputación del usuario activo.
			}else { //Sino..
				realizarRecompensa(pregunta, montoRecompensa, userA); //Se entrega la recompensa.
				return -3; //retorna -3;
			}
		}
	}

	
	
	//_______________________________________________________________________

	/**Permite aceptar una respuesta y modificar recompensas segun lo establecido por stackOverflow.
	 * @param respuesta Respuesta  que se quiere aceptar.
	 * @param recompensa Recompensa por la pregunta a la que corresponde la respuesta. 
	 * @return número. Sirve para determinar si se acepto una respuesta y si no fue asi, el porque paso.
	 */
	private int aceptarRespuesta(Respuesta respuesta, Recompensa recompensa) {
		
		GettersStackService getS = new GettersStackService(stack);
		RewardService rewardService = new RewardService(recompensa);
		
		if(respuesta != null && respuesta.getEstado().equals("Pendiente.")) {//Si la respuesta existe y su estado es pendiente.
			respuesta.setEstado("Aceptada."); //Se acepta la respuesta.
			getS.getUser(respuesta.getAutor()).agregarPuntosAReputacion((15+rewardService.entregarRecompensa())); //Se actualiza reputacion de autor de la respuesta.
			stack.getActiveUser().agregarPuntosAReputacion(2);//Se actualiza reputación del usuario Activo.
			return 0; // Retorna 0: Se acepto respuesta.
		}else {
			return 1; // Retorna 1: No se acepto, pues la respuesta ya esta aceptada.
		}
	}
	
	/**
	 * Permite a un usuario con sesión activa  aceptar una respuesta de una de sus preguntas.
	 * @param idPregunta Identificador de la pregunta a la que corresponde la respuestas. 
	 * @param idRespuesta Identificador de la respuesta a aceptar. 
	 * @return número. Sirve para determinar si se agrego una recompensa y si no fue asi, el porque paso.
	 */
	public int accept(Pregunta pregunta, Respuesta respuesta) {

		//Si la pregunta existe, esta abierta y pertenece al usuario. 
		if(pregunta != null && pregunta.getEstado().equals("Abierta.") && pregunta.getAutor().equals(stack.getActiveUser().getName())) { 
			Recompensa recompensa = pregunta.getRecompensa(); //Se toma la recompensa de la pregunta.
			int aux = aceptarRespuesta(respuesta, recompensa); //Se acepta la respuesta tomando como parametros la respuesta y la recompensa de la pregunta.
			return aux; //Retorna un 0 o 1. Segun lo sucedido en la funcion aceptarRespuesta.
		}else {
			return 2; // Retorna 2: No se acepto, pues la pregunta esta cerrada.
		}

	}
	
	/**
	 * Permite agregar un reporte a una pregunta.
	 * @param pregunta Pregunta a la que se le agrega el reporte.
	 * @return un numero que sirve para identificar que pasa.
	 */
	public int report(Pregunta pregunta) {
		Usuario userA = stack.getActiveUser();
        if(pregunta == null || userA == null) { //Se la pregunta no existe o no existe usuario activo...
        	return 1; //Se retorna 1.
        }else {
        	pregunta.setReportes(pregunta.getReportes()+1);
        	return 2; //Se retorn 2.
        }
		
	}
	
	/**
	 * Permite agregar un reporte a una respuestas.
	 * @param respuesta Respuesta a la que se le agrega el reporte.
	 * @return un numero que sirve para identificar que pasa.
	 */
	public int report(Respuesta respuesta) {
		
		Usuario userA = stack.getActiveUser();
        if(respuesta == null || userA == null) { //Se la pregunta no existe o no existe usuario activo...
        	return 1; //Se retorna 1.
        }else {
        	respuesta.setReportes(respuesta.getReportes()+1);
        	return 2; //Se retorn 2;
        }
    }
}
