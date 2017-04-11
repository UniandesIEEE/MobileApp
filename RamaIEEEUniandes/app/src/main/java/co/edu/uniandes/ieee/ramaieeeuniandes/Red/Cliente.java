package co.edu.uniandes.ieee.ramaieeeuniandes.Red;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Articulo;
import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Evento;
import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Noticia;
import co.edu.uniandes.ieee.ramaieeeuniandes.Activities.RamaMain;

/**
 * Created by juanm on 15/05/2016.
 */
public class Cliente extends Thread{

    /**
     * Constante que modela el numero de puerto de conexión
     * con el servidor
     */
    private static final int PORT = 9999;

    /**
     * Constante que modela la dirección IP del servidor
     */
    private static final String SERVER_IP = "192.168.1.34";

    /**
     * Atributo que modela el socket del teléfono
     */
    private Socket cliente;

    /**
     * Atributo que modela un buffer de entrada de información
     */
    private BufferedReader buffer;

    /**
     * Atributo que modela un camino de salida de información
     */
    private PrintWriter printer;

    /**
     * Atributo que modela la relación con la actividad de la rama
     */
    private RamaMain activityRama;

    public Cliente(RamaMain rama){
        activityRama = rama;
    }

    public void run(){
        try {
            InetAddress serverAdd = InetAddress.getByName(SERVER_IP) ;
            cliente= new Socket(serverAdd,PORT);
            cliente.setKeepAlive(true);
            printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())),true);
            buffer = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            printer.println(Protocolo.GET_NOT+Protocolo.SPLIT_COMMAND+"0");
            procesarMensaje();

            printer.println(Protocolo.GET_EVT+Protocolo.SPLIT_COMMAND+"0");
            procesarMensaje();

            cliente.close();
            buffer.close();
            printer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que procesa el mensaje proveniente del servidor
     */
    private void procesarMensaje() throws Exception{
        String[] split = buffer.readLine().split(Protocolo.SPLIT_COMMAND);
        String comando = split[0];
        String param = split[1];
        if(comando.equals(Protocolo.NEWS)){
            ArrayList<Articulo> noticias = new ArrayList<Articulo>();
            int max = Integer.parseInt(param);
            for (int i=0;i<max;i++){
                String[] line = buffer.readLine().split(Protocolo.SPLIT_COMMAND);
                String comandoNot = line[0];
                String[] paramsNot = line[1].split(Protocolo.SPLIT_PARAMETER);
                if (comandoNot.equals(Protocolo.NEW)){
                    noticias.add(new Noticia(paramsNot[0],paramsNot[1],paramsNot[2],paramsNot[3]));
                }
            }
            activityRama.actualizarNoticias(noticias);
        }
        else if(comando.equals(Protocolo.EVENTS)){
            ArrayList<Articulo> eventos = new ArrayList<Articulo>();
            int max = Integer.parseInt(param);
            for (int i=0;i<max;i++){
                String[] line = buffer.readLine().split(Protocolo.SPLIT_COMMAND);
                String comandoNot = line[0];
                String[] paramsNot = line[1].split(Protocolo.SPLIT_PARAMETER);
                if (comandoNot.equals(Protocolo.EVENT)){
                    eventos.add(new Evento(paramsNot[0],paramsNot[1],paramsNot[2],paramsNot[3],paramsNot[4],Integer.parseInt(paramsNot[5])));
                }
            }
            activityRama.actualizarEventos(eventos);
        }
    }
}
