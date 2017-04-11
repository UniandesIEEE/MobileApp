package co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores;

import co.edu.uniandes.ieee.ramaieeeuniandes.R;

/**
 * Created by juanm on 9/07/2016.
 */
public class IEEEinfo {

    /**
     * Atributo que modela la imagen correspondiente al logo de IEEE
     */
    public static final int IMAGEN_IEEE = R.mipmap.ieee_logo;

    /**
     * Atributo que modela el enlace correspondiente a IEEE
     */
    public static final String ENLACE_IEEE = "https://www.ieee.org/index.html";

    /**
     * Atributo que modela la imagen de la revista Spectrum
     */
    public static final int IMAGEN_SPECTRUM = R.mipmap.spectrum_icon;

    /**
     * Atributo que modela el enlace correspondiente a la revista Spectrum
     */
    public static final String ENLACE_SPECTRUM = "http://spectrum.ieee.org/";

    /**
     * Atributo que modela la imagen de la base de datos IEEExplore
     */
    public static final int IMAGEN_XPLORE = R.mipmap.logo_xplore;

    /**
     * Atributo que modela el enlace correspondiente a la base de datos IEEExpectrum
     */
    public static final String ENLACE_XPLORE = "http://ieeexplore.ieee.org/Xplore/home.jsp";

    /**
     * Atributo que modela la imagen de la red Collabratec
     */
    public static final int IMAGEN_COLLABRATEC = R.mipmap.ieee_collabratec_logo;

    /**
     * Atributo que modela el enlace correspondiente a la red profesional Collabratec
     */
    public static final String ENLACE_COLLABRATEC = "https://ieee-collabratec.ieee.org/";

    /**
     * Atributo que modela la imagen del grupo Young Professionals
     */
    public static final int IMAGEN_IEEE_TV = R.mipmap.ieeetv;

    /**
     * Atributo que modela el enlace correspondiente al enlace de IEEE_TV
     */
    public static final String ENLACE_IEEE_TV= "https://ieeetv.ieee.org/";

    /**
     * Atributo que modela la imagen de la revista The Institute
     */
    public static final int IMAGEN_THE_INSTITUTE = R.mipmap.the_institute_logo;

    /**
     * Atributo que modela el enlace correspondiente al enlace de IEEE_TV
     */
    public static final String ENLACE_THE_INSTITUTE= "http://theinstitute.ieee.org/";

    /**
     * Atributo que modela la imagen que contiene el elemento de la lista
     */
    private int imagen;

    /**
     * Atributo que modela el enlace de la página web asociada a cada uno de los elementos de la lista
     */
    private String enlace;

    public IEEEinfo(int idImagen){
        imagen = idImagen;
        if(imagen==IMAGEN_IEEE){
            enlace = ENLACE_IEEE;
        }
        else if(imagen==IMAGEN_COLLABRATEC){
            enlace = ENLACE_COLLABRATEC;
        }
        else if(imagen==IMAGEN_IEEE_TV){
            enlace = ENLACE_IEEE_TV;
        }
        else if(imagen==IMAGEN_SPECTRUM){
            enlace = ENLACE_SPECTRUM;
        }
        else if(imagen==IMAGEN_XPLORE){
            enlace = ENLACE_XPLORE;
        }
        else if(imagen==IMAGEN_THE_INSTITUTE){
            enlace = ENLACE_THE_INSTITUTE;
        }
    }

    /**
     * Método que retorna la imagen del elemento
     * @return Imagen del elemento
     */
    public int darImagen(){
        return imagen;
    }

    /**
     * Método que retorna el enlace de la página web relacionada a cada uno de los elementos de IEEE definidos
     * @return Enlace de la página web relacionada
     */
    public String darEnlace() {
        return enlace;
    }
}
