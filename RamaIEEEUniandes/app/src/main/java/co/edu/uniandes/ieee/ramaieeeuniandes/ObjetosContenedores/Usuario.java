package co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores;

/**
 * Created by juanm on 15/07/2016.
 */
public class Usuario {

    /**
     * Constante que modela el estado de miembro para el usuario
     */
    public static final String MEMBER = "Member";

    /**
     * Constante que modela el estado de no miembro para el usuario
     */
    public static final String NOT_MEMBER = "Not Member";

    /**
     * Atributo que modela el nombre del usuario
     */
    private String nombre;

    /**
     * Atributo que modela el login uniandes o ieee del usuario
     */
    private String login;

    /**
     * Atributo que modela el puntaje del usuario
     */
    private int puntaje;

    /**
     * Atributo que modela el estado de miembro del usuario
     */
    private boolean miembro;

    /**
     * Constructor de un usuario y sus principales características
     * @param pNombre Nombre del usuario especificado
     * @param pLogin Login del usuario especificado
     * @param pMiembro Estado de membresía del usuario
     * @exception Exception si el login es inválido
     */
    public Usuario(String pNombre, String pLogin, String pMiembro,int pPuntaje)throws Exception{
        nombre = pNombre;
        puntaje = pPuntaje;
        if(!(pLogin.endsWith("@uniandes.edu.co")||pLogin.endsWith("@ieee.org"))){
            throw new Exception("El login de usuario no es válido, debe ingresar una cuenta IEEE o Uniandes");
        }
        login = pLogin;
        if(pMiembro.equals(MEMBER)){
            miembro = true;
        }
        else{
            miembro=false;
        }
    }

    /**
     * Método que retorna el nombre del usuario
     * @return Nombre del usuario
     */
    public String darNombre(){
        return nombre;
    }

    /**
     * Método que retorna el login del usuario
     * @return Login del usuario IEEE o Uniandes
     */
    public String darLogin(){
        return login;
    }

    /**
     * Método que retorna el estado de membresía del usuario
     * @return Estado de membresía del usuario
     */
    public boolean darEstadoMembresia(){
        return miembro;
    }

    /**
     * Método que retorna el puntaje del usuario
     * @return Puntaje del usuario
     */
    public int darPuntaje(){ return puntaje; }
}
