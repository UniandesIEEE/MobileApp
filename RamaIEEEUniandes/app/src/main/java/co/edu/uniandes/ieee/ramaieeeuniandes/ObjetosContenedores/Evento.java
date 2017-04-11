package co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores;

/**
 * Created by juanm on 4/07/2016.
 */
public class Evento extends  Articulo{

    /**
     * Atributo que modela la fecha del evento.
     */
    private String lugar;

    /**
     * Atributo que modela el puntaje que se adquiere al asistir a este evento
     */
    private int puntaje;

    /**
     * Constructor de la clase Evento
     * @param pTitulo Titulo del evento
     * @param pContenido Descripción del evento
     * @param pFecha Fecha del evento
     * @param pCapitulo Capítulo al cual pertenece el evento
     */
    public Evento(String pTitulo, String pContenido, String pFecha, String pCapitulo, String pLugar, int pPuntaje) {
        super(pTitulo, pContenido, pFecha, pCapitulo);
        lugar = pLugar;
        puntaje = pPuntaje;
    }

    /**
     * Método que retorna el lugar donde se va a llevar a cabo el evento
     * @return Lugar del evento
     */
    public String darLugar(){
        return lugar;
    }

    /**
     * Método que retorna el puntaje que se obtiene al asistir a este evento
     * @return Puntaje de asistencia al evento
     */
    public int darPuntaje(){
        return puntaje;
    }
}
