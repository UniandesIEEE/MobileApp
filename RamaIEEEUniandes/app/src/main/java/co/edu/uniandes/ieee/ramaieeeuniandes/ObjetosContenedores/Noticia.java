package co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores;

/**
 * Created by juanm on 26/06/2016.
 */
public class Noticia extends Articulo{

    /**
     * Constructor de la clase Noticia
     * @param pTitulo Titulo de la noticia
     * @param pContenido Contenido de la noticia
     * @param pFecha Fecha de la noticia
     * @param pCapitulo Capítulo al cual pertenece la noticia
     */
    public Noticia(String pTitulo, String pContenido, String pFecha, String pCapitulo){
        super(pTitulo,pContenido,pFecha,pCapitulo);
    }
}
