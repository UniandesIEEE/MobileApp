package co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores;

import java.io.Serializable;

import co.edu.uniandes.ieee.ramaieeeuniandes.R;

/**
 * Created by juanm on 4/07/2016.
 */
public abstract class Articulo implements Serializable{

    /**
     * Constante que modela la imagen de la dependencia de la Rama
     */
    public static final int RAMA_IMG = R.mipmap.logo_rama_min;

    /**
     * Constante que modela la imagen renderizada de la Rama
     */
    public static final int RAMA_IMG_REN = R.mipmap.logo_rama_ren;

    /**
     * Constante que modela el nombre de la dependencia de la Rama
     */
    public static final String RAMA = "Rama Estudiantil IEEE Uniandes";

    /**
     * Constante que modela la imagen del capítulo Computer
     */
    public static final int COMPUTER_IMG = R.mipmap.logo_computer;

    /**
     * Constante que modela la imagen renderizada del capítulo Computer
     */
    public static final int COMPUTER_IMG_REN = R.mipmap.logo_computer_ren;

    /**
     * Constante que modela el nombre de la dependencia del capítulo Computer
     */
    public static final String COMPUTER = "Uniandes Computer Society";

    /**
     * Constante que modela la imagen de la dependencia del capítulo IAS
     */
    public static final int IAS_IMG = R.mipmap.logo_ias_min;

    /**
     * Constante que modela la imagen renderizada del capítulo IAS
     */
    public static final int IAS_IMG_REN = R.mipmap.logo_ias_ren;

    /**
     * Constante que modela el nombre de la dependencia del capítulo Computer
     */
    public static final String IAS = "SB IAS Uniandes";

    /**
     * Constante que modela la dependencia del capítulo CSS
     */
    public static final int CSS_IMG = R.mipmap.logo_css_min;

    /**
     * Constante que modela la dependencia del capítulo CSS
     */
    public static final int CSS_IMG_REN = R.mipmap.logo_css_ren;

    /**
     * Constante que modela la dependencia del capítulo CSS
     */
    public static final String CSS = "CCS";

    /**
     * Constante que modela la dependencia del capítulo Eta Kappa Nu
     */
    public static final String HKN = "HKN";

    /**
     * Constante que modela la dependencia del grupo de afinidad WIE
     */
    public static final String WIE = "WIE";

    /**
     * Constante que modela la dependencia del capítulo COMSOC
     */
    public static final String COMSOC = "COMSOC";

    /**
     * Constante que modela la dependencia del capítulo PES
     */
    public static final String PES = "PES";

    /**
     * Atributo que modela el título de la noticia
     */
    protected String titulo;

    /**
     * Atributo que modela el contenido de la noticia
     */
    protected String contenido;

    /**
     * Atributo que modela la imagen de la dependencia a la cual pertenece la noticia
     */
    protected int imagenDependencia;

    /**
     * Atributo que modela la imagen de la dependencia de manera renderizada
     */
    protected int imagenDependenciaRenderizada;

    /**
     * Atributo que modela la fecha en la cual se publicó la noticia
     */
    protected String fecha;

    /**
     * Atributo que modela el nombre de la dependencia a la cual pertenece la noticia
     */
    protected String capitulo;

    /**
     * Atributo que modela la imagen del contenido del articulo.
     */
    protected int imagenContenido;

    public Articulo(String pTitulo, String pContenido, String pFecha, String pCapitulo){
        titulo=pTitulo;
        contenido=pContenido;
        fecha = pFecha;
        capitulo = pCapitulo;

        if(pCapitulo.equals(RAMA)){
            imagenDependencia = RAMA_IMG;
            imagenDependenciaRenderizada = RAMA_IMG_REN;
        }
        else if(pCapitulo.equals(COMPUTER)){
            imagenDependencia = COMPUTER_IMG;
            imagenDependenciaRenderizada = COMPUTER_IMG_REN;
        }
        else if(pCapitulo.equals(IAS)){
            imagenDependencia = IAS_IMG;
            imagenDependenciaRenderizada = IAS_IMG_REN;
        }
        else if(pCapitulo.equals(CSS)){
            imagenDependencia = CSS_IMG;
            imagenDependenciaRenderizada = CSS_IMG_REN;
        }
    }

    /**
     * Método que retorna el título de la notcia
     * @return Título de la noticia
     */
    public String darTitulo(){
        return titulo;
    }

    /**
     * Método que retorna el contenido de la noticia.
     * @return Contenido de la noticia
     */
    public String darContenido(){
        return contenido;
    }

    /**
     * Método que retorna la imagen de la dependencia a la cual pertenece la notica
     * @return Imagen de la dependencia a la que pertenece
     */
    public int darImagenDependencia(){
        return imagenDependencia;
    }

    /**
     * Método que retorna la imagen de la dependencia renderizada
     * @return Imagen renderizada de la dependencia
     */
    public int darImagenDependenciaRenderizada(){ return imagenDependenciaRenderizada; }

    /**
     * Métodod que retorna la imagen del contenido del artículo
     * @return Imagen del contenido del artículo
     */
    public int darImagenContenido(){return imagenContenido; }

    /**
     * Método que retorna la fecha de la noticia
     * @return Fecha de la noticia
     */
    public String darFecha() {
        return fecha;
    }

    /**
     * Método que retorna el nombre de la dependencia a la cual pertenece la noticia
     * @return Nombre de la dependencia
     */
    public String darCapitulo() {
        return capitulo;
    }
}
