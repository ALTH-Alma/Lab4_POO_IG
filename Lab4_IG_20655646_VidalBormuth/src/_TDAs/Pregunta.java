package _TDAs;

import java.util.ArrayList;
import java.util.List;

//import Service.EtiquetasService;
//import Service.MostrarListStackService;



/**
 * Clase para representar una pregunta en el stack.
 * La clase pregunta hereda de la clase ComunRP.
 * La clase pregunta queda determinada por un incrementador de id, un titulo, una recompensa, una lista de etiquetas, una lista de respuestas
 * y de los atributos heredados: un id único incremental, un autor, contenido, votos a favor, votos en contra, reportes,
 * un estado y una fecha de publicación.
 * @author Alma
 *
 */

public class Pregunta extends ComunRP{
	
	private static int count2 = 0; //Incrementador del id de la clase Pregunta.
	private String titulo; //Un titulo.
	private Recompensa recompensa; //Una recompensa.
	private List<Etiqueta> etiquetas = new ArrayList<Etiqueta>(); //Una lista de etiquetas.
	private List<Respuesta> respuestas; //Una lista de respuestas.

	
	/**
	 * Crea una nueva pregunta a partir de un autor, un titulo, contenido y una lista de etiquetas.
	 * @param autor Autor de la pregunta.
	 * @param titulo Titulo de la pregunta.
	 * @param contenido Contenido de la pregunta.
	 * @param etiquetas Lista de etiquetas de la pregunta.
	 */
	public Pregunta(String autor, String titulo, String contenido, List<Etiqueta> etiquetas) {
		super(autor, contenido);
		this.titulo = titulo;
		setEstado("Abierta."); //Al crear la respuesta su estado pasa a ser "Abierta."
		this.etiquetas = etiquetas;
		respuestas = new ArrayList<Respuesta>(); //Se inicializa la lista de preguntas.
		recompensa = new Recompensa(); //Se inicializa una recompensa vacía.
		setId(++count2); //El id autoincremental se incrementa.
	}

	/**
	 * Crea una nueva pregunta a partir de todos sus atributos a excepción del id único incremental y la fecha de publicación.
	 * @param autor Autor de la pregunta
	 * @param titulo Titulo de la pregunta.
	 * @param contenido Contenido de la pregunta.
	 * @param etiquetas Lista de etiquetas de la pregunta.
	 * @param estado Estado de la pregunta ("Abierta." o "Cerrada.").
	 * @param votosAFavor Cantidad de votos a favor de la pregunta.
	 * @param votosEnContra Cantidad de votos en contra de la pregunta.
	 * @param reportes Cantidad de reportes de la pregunta.
	 * @param recompensa Recompensa por la pregunta.
	 * @param respuestas Lista de respuestas de la pregunta.
	 */
	public Pregunta(String autor, String titulo, String contenido, List<Etiqueta> etiquetas, String estado, int votosAFavor, 
			int votosEnContra, int reportes, Recompensa recompensa, List<Respuesta> respuestas) {
		super(autor, contenido, estado, votosAFavor, votosEnContra, reportes);
		this.titulo = titulo;
		this.recompensa = recompensa;
		this.etiquetas = etiquetas;
		this.respuestas = respuestas;
		setId(++count2); //El id autoincremental se incrementa.
	}


	/**
	 * Entrega el titulo de la pregunta.
	 * @return Titulo de la pregunta.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Permite modificar el titulo de la pregunta.
	 * @param titulo Titulo de la pregunta.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Entrega la recompensa por la pregunta.
	 * @return La recompensa de la pregunta.
	 */
	public Recompensa getRecompensa() {
		return recompensa;
	}
	
	/**
	 * Permite modificar la recompensa de la pregunta.
	 * @param recompensa Recompensa.
	 */
	public void setRecompensa(Recompensa recompensa) {
		this.recompensa = recompensa;
	}

	/**
	 * Entrega la lista de etiquetas de una pregunta.
	 * @return Lista de etiquetas de la pregunta.
	 */
	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	/**
	 * Permite modificar la lista de etiquetas de la pregunta.
	 * @param etiquetas Lista de etiquetas.
	 */
	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	/**
	 * Entrega la lista de etiquetas de la pregunta.
	 * @return Lista de preguntas de la etiqueta.
	 */
	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	/**
	 * Permite modificar la lista de respuestas de la pregunta. 
	 * @param respuestas Una lista de respuestas.
	 */
	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	public Respuesta getRespuesta(int idRespuesta) {
		
        for(Respuesta respuesta: respuestas){
			if(respuesta.getId() == idRespuesta) {
				return respuesta;
			}
        }
        return null;
		
	}
	
	public Etiqueta getEtiqueta(String etiquetaName) {
		
		for(Etiqueta etiqueta: etiquetas) {//Recorre toda la lista de usuarios hasta encontrarlo.
			if(etiqueta.getName().equals(etiquetaName)) {
				return etiqueta; //Si lo encuentra retorna al usuario. 
			}
		}
		return null; //Si no lo encuentra retorna null.
	}
	

	/**
	 * Muestra una pregunta con todos sus elementos.
	 */
//	@Override
//	public void mostrarComun() {
//		
//		EtiquetasService es = new EtiquetasService(etiquetas);
//		MostrarListStackService ms= new MostrarListStackService();
//		
//		System.out.println("ID Pregunta: "+getId()+"\nTitulo: "+titulo);
//		super.mostrarComun();
//		System.out.println("Recompensa ofrecida: "+recompensa.getMontoRecompensa()+" puntos.");
//		System.out.println("----Etiquetas---- ");
//		es.mostrarEtiquetas();
//		System.out.println("----Respuestas---- ");
//		ms.mostrarRespuestas(respuestas);
//	}
//	
//	
//	/**
//	 * Muestra una pregunta con todos sus elementos a excepción de sus respuestas, pues muestra solo las respuestas que no pertenecen 
//	 * al autor de la pregunta.
//	 * @param nameAutor Nombre 
//	 */
//	public void mostrarComun(String nameAutor) {
//		
//		EtiquetasService es = new EtiquetasService(etiquetas);
//		MostrarListStackService ms= new MostrarListStackService();
//		
//		System.out.println("ID Pregunta: "+getId()+"\nTitulo: "+titulo);
//		super.mostrarComun();
//		System.out.println("Recompensa ofrecida: "+recompensa.getMontoRecompensa()+" puntos.");
//		System.out.println("----Etiquetas---- ");
//		es.mostrarEtiquetas();
//		System.out.println("----Respuestas---- ");
//		ms.mostrarRespuestas(respuestas,nameAutor);
//	}

	
}
