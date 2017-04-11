package co.edu.uniandes.ieee.ramaieeeuniandes.Red;

public class Protocolo {

	/**
	 * Constante que modela el comando de noticias del protocolo
	 */
	public static final String NEWS = "NEWS";

	/**
	 * Constante que modela el comando de eventos del protocolo
	 */
	public static final String EVENTS = "EVENTS";

	/**
	 * Constante que modela el comando de noticia del protocolo
	 */
	public static final String NEW = "NEW";

	/**
	 * Constante que modela el comando de eventos del protocolo
	 */
	public static final String EVENT = "EVENT";

	/**
	 * Constante que modela el comando de env�o de imagen
	 */
	public static final String IMAGE = "IMAGE";

	/**
	 * Constante que modela el comando de registro de evento del protocolo
	 */
	public static final String EVENT_REG = "EVENT_REG";

	/**
	 * Constante que modela la respuesta de protocolo de recibido al servidor
	 */
	public static final String RECEIVED = "RECEIVED";

	/**
	 * Constante que modela el comando para pedir todos los eventos del servidor
	 */
	public static final String GET_EVT = "GET_EVT";

	/**
	 * Constante que modela el comando para pedir todas las noticias del servidor
	 */
	public static final String GET_NOT = "GET_NOT";

	/**
	 * Constante que modela el comando para indicar que se termin� de enviar la informaci�n al cliente
	 */
	public static final String DONE = "DONE";

	/**
	 * Constante que modela el separador de comandos del protocolo
	 */
	public static final String SPLIT_COMMAND = "<CMD>";

	/**
	 * Constante que modela el separador de par�metros del protocolo
	 */
	public static final String SPLIT_PARAMETER = "<PARAM>";

	/**
	 * Constante que modela el comando de error del protocolo.
	 */
	public static final String ERROR = "ERROR";
}
