package co.edu.uniandes.ieee.ramaieeeuniandes.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.util.ArrayList;

import co.edu.uniandes.ieee.ramaieeeuniandes.Adaptadores.AdaptadorIEEE;
import co.edu.uniandes.ieee.ramaieeeuniandes.Adaptadores.AdaptadorNoticia;
import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Articulo;
import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Evento;
import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.IEEEinfo;
import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Noticia;
import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Usuario;
import co.edu.uniandes.ieee.ramaieeeuniandes.R;


public class RamaMain extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener, AdapterView.OnItemClickListener {

    /**
     * Atributo que modela el botón de imagen para las noticias
     */
    private ImageButton btnNoticias;

    /**
     * Atributo que modela el botón de imagen para los eventos
     */
    private ImageButton btnEventos;

    /**
     * Atributo que modela el botón de imagen para la búsqueda
     */
    private ImageButton btnBuscar;

    /**
     * Atributo que modela el botón de imagen para mostrar lo destacado
     */
    private ImageButton btnDestacado;

    /**
     * Atributo que modela el botón de imagen para mostrar el contenido de IEEE mundial
     */
    private ImageButton btnIEEE;

    /**
     * Atributo que modela el botón utilizado para scanear los códigos QR de los eventos
     */
    private Button btnScanner;

    /**
     * Atributo que modela el botón utilizado para mostrar el ranking de los miembros
     */
    private Button btnMember;

    /**
     * Atributo que modela el botón utilizado para mostrar el ranking de los no miembros
     */
    private Button btnNotMember;

    /**
     * Atributo que modela el animador del contenido de la aplicación
     */
    private ViewAnimator animator;

    /**
     * Atributo que modela el animador del ranking
     */
    private ViewAnimator animator1;

    /**
     * Atributo que modela la vista de lista de las noticias
     */
    private ListView listaNoticias;

    /**
     * Atributo que modela la vista de lista de las noticias
     */
    private ListView listaEventos;

    /**
     * Atributo que modela la vista de lista del ranking de los miembros
     */
    private ListView listaRankingMember;

    /**
     * Atributo que modela la vista de lista del ranking de los no miembros
     */
    private ListView listaRankingNoMember;

    /**
     * Atributo que modela la vista de lista de la información del IEEE
     */
    private ListView listaIEEE;

    /**
     * Atributo que modela la vista de lista de los resultados de búsqueda
     */
    private ListView listaBuscados;

    /**
     * Atributo que modela el cuadro de texto utilizado para el texto de búsqueda
     */
    private EditText txtBuscar;

    /**
     * Atributo que modela la lista de noticias de la aplicación
     */
    private ArrayList<Articulo> noticias;

    /**
     * Atributo que modela la lista de los eventos de la aplicación
     */
    private ArrayList<Articulo> eventos;

    /**
     * Atributo que modela la lista del ranking de los miembros
     */
    private ArrayList<Usuario> rankingMem;

    /**
     * Atributo que modela la lista del ranking de los no miembros
     */
    private ArrayList<Usuario> rankingNoMem;

    /**
     * Atributo que modela la lista de resultados de búsqueda
     */
    private ArrayList<Articulo> resultados;

    /**
     * Atributo que modela el cliente que envía y recibe mensajes del servidor
     */
    //private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rama_main);

        noticias = new ArrayList<Articulo>();
        eventos = new ArrayList<Articulo>();
        resultados = new ArrayList<Articulo>();
        rankingMem = new ArrayList<Usuario>();
        rankingNoMem = new ArrayList<Usuario>();

        btnNoticias = (ImageButton) findViewById(R.id.newsButton);
        btnNoticias.setOnTouchListener(this);
        btnNoticias.setOnClickListener(this);

        btnEventos = (ImageButton) findViewById(R.id.eventButton);
        btnEventos.setOnTouchListener(this);
        btnEventos.setOnClickListener(this);

        btnIEEE = (ImageButton) findViewById(R.id.ieeeButton);
        btnIEEE.setOnTouchListener(this);
        btnIEEE.setOnClickListener(this);

        btnBuscar = (ImageButton) findViewById(R.id.searchButton);
        btnBuscar.setOnTouchListener(this);
        btnBuscar.setOnClickListener(this);

        btnDestacado = (ImageButton) findViewById(R.id.highlightButton);
        btnDestacado.setOnTouchListener(this);
        btnDestacado.setOnClickListener(this);

        btnScanner = (Button) findViewById(R.id.btnRegistration);

        animator = (ViewAnimator) findViewById(R.id.viewAnimator);
        Animation inAnim = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation outAnim = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        animator.setInAnimation(inAnim);
        animator.setOutAnimation(outAnim);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        btnMember = new Button(this);
        btnMember.setText("Membresía");
        btnMember.setBackgroundColor(Color.rgb(0,103,146));
        btnMember.setTextColor(Color.WHITE);

        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator(btnMember);
        host.addTab(spec);

        btnNotMember = new Button(this);
        btnNotMember.setText("Sin Membresía");
        btnNotMember.setBackgroundColor(Color.rgb(0,103,146));
        btnNotMember.setTextColor(Color.WHITE);

        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator(btnNotMember);
        host.addTab(spec);

        listaNoticias = (ListView) findViewById(R.id.listNews);
        noticias.add(new Noticia("Hola Mundo","La Rama se complace en entregar la versión beta del aplicativo que esta desarrollando con el fin de" +
                "tener un nuevo canal de comunicación. Este estará destinado a facilitar la información y mejorar el acercamiento e interacción de los usuarios" +
                " con la Rama. De la misma forma, se tiene la expectativa de que esta iniciativa se convierta en un modelo sostenible y fácilmente replicable" +
                " para otras ramas y capítulos estudiantiles.(Nota: esta versión beta es un modelo demostrativo de la interfaz gráfica de usuario y las funcionalidades" +
                " básicas de la aplicación. Por el momento no se encuentra en línea). Para mayor información o cualquier sugerencia pueden escribirnos a ieee@uniandes.edu.co.","27/07/2016",Articulo.RAMA));
        listaNoticias.setAdapter(new AdaptadorNoticia(this,R.layout.lista_noticia,noticias));
        listaNoticias.setOnItemClickListener(this);

        listaEventos = (ListView) findViewById(R.id.listEvents);
        eventos.add(new Evento("Asamblea General","La asamblea general tiene como objetivo presentar el balance del periodo 2016-1" +
                "y presentar la planeación del periodo 2016-2","27/07/2016",Articulo.RAMA,"ML 509",100));
        listaEventos.setAdapter(new AdaptadorNoticia(this,R.layout.lista_noticia,eventos));
        listaEventos.setOnItemClickListener(this);

        listaIEEE = (ListView) findViewById(R.id.listIEEE);
        ArrayList<IEEEinfo> listaInfo = new ArrayList<IEEEinfo>();
        listaInfo.add(new IEEEinfo(IEEEinfo.IMAGEN_IEEE));
        listaInfo.add(new IEEEinfo(IEEEinfo.IMAGEN_SPECTRUM));
        listaInfo.add(new IEEEinfo(IEEEinfo.IMAGEN_XPLORE));
        listaInfo.add(new IEEEinfo(IEEEinfo.IMAGEN_COLLABRATEC));
        listaInfo.add(new IEEEinfo(IEEEinfo.IMAGEN_IEEE_TV));
        listaInfo.add(new IEEEinfo(IEEEinfo.IMAGEN_THE_INSTITUTE));
        listaIEEE.setAdapter(new AdaptadorIEEE(this,R.layout.lista_ieee,listaInfo));
        listaIEEE.setOnItemClickListener(this);

        listaRankingMember = (ListView) findViewById(R.id.listRankingMember);
        listaRankingNoMember = (ListView) findViewById(R.id.listRankingNoMember);

        listaBuscados = (ListView) findViewById(R.id.listResults);
        listaBuscados.setOnItemClickListener(this);

        txtBuscar = (EditText) findViewById(R.id.txtSearch);
        txtBuscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                buscarCoincidencias(s.toString());
            }
        });
        //cliente = new Cliente(this);
        //cliente.start();
    }

    /**
     * Método que busca coincidencias entre las noticias y los eventos dado lo que ingrese el usuario por parámetro
     * @param s Cadena de caracteres referente a la palabra de búsqueda del usuario
     */
    public void buscarCoincidencias(String s) {

        resultados.clear();
        if(!s.equals("")) {
            for (int i = 0; i < eventos.size(); i++) {
                Evento ev = (Evento) eventos.get(i);
                if (ev.darLugar().toLowerCase().contains(s.toLowerCase()) || ev.darCapitulo().toLowerCase().contains(s.toLowerCase())
                        || ev.darTitulo().toLowerCase().contains(s.toLowerCase()) || ev.darFecha().toLowerCase().contains(s.toLowerCase())) {
                    resultados.add(ev);
                }
            }
            for (int i = 0; i < noticias.size(); i++) {
                Noticia not = (Noticia) noticias.get(i);
                if (not.darCapitulo().toLowerCase().contains(s.toLowerCase()) || not.darTitulo().toLowerCase().contains(s.toLowerCase())
                        || not.darFecha().toLowerCase().contains(s.toLowerCase())) {
                    resultados.add(not);
                }
            }
        }
        listaBuscados.setAdapter(new AdaptadorNoticia(this,R.layout.lista_noticia,resultados));
    }

    public void QrScanner(View view){

        Intent intent = new Intent(this, QRScannerActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("result");
                Toast t = Toast.makeText(this,result,Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }

    @Override
    public void onClick(View v) {

        if(animator.getDisplayedChild()==4){
            txtBuscar.setText("");
        }
        if (v.getId() == R.id.newsButton) {
            animator.setDisplayedChild(0);
        } else if (v.getId() == R.id.eventButton) {
            animator.setDisplayedChild(1);
        } else if (v.getId() == R.id.ieeeButton) {
            animator.setDisplayedChild(2);
        } else if (v.getId() == R.id.highlightButton) {
            animator.setDisplayedChild(3);
        } else if (v.getId() == R.id.searchButton) {
            animator.setDisplayedChild(4);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.eventButton) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    btnEventos.setColorFilter(Color.argb(60, 55, 46, 46));
                    return false; // if you want to handle the touch event
                case MotionEvent.ACTION_UP:
                    btnEventos.clearColorFilter(); // White Tint
                    return false; // if you want to handle the touch event
            }
        } else if (v.getId() == R.id.newsButton) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    btnNoticias.setColorFilter(Color.argb(60, 55, 46, 46)); // White Tint
                    return false; // if you want to handle the touch event
                case MotionEvent.ACTION_UP:
                    btnNoticias.clearColorFilter(); // White Tint
                    return false; // if you want to handle the touch event
            }
        } else if (v.getId() == R.id.searchButton) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    btnBuscar.setColorFilter(Color.argb(60, 55, 46, 46)); // White Tint
                    return false; // if you want to handle the touch event
                case MotionEvent.ACTION_UP:
                    btnBuscar.clearColorFilter(); // White Tint
                    return false; // if you want to handle the touch event
            }
        } else if (v.getId() == R.id.highlightButton) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    btnDestacado.setColorFilter(Color.argb(60, 55, 46, 46)); // White Tint
                    return false; // if you want to handle the touch event
                case MotionEvent.ACTION_UP:
                    btnDestacado.clearColorFilter(); // White Tint
                    return false; // if you want to handle the touch event
            }
        }
        else if (v.getId() == R.id.ieeeButton) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    btnIEEE.setColorFilter(Color.argb(60, 55, 46, 46)); // White Tint
                    return false; // if you want to handle the touch event
                case MotionEvent.ACTION_UP:
                    btnIEEE.clearColorFilter(); // White Tint
                    return false; // if you want to handle the touch event
            }
        }
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.listNews){
            Articulo art = (Articulo) listaNoticias.getItemAtPosition(position);
            if(art!=null){
                Intent intent = new Intent(this, NewsActivity.class);
                intent.putExtra("Noticia",art); //Put your id to your next Intent
                startActivity(intent);
            }
        }
        else if(parent.getId() == R.id.listIEEE){
            IEEEinfo link = (IEEEinfo) listaIEEE.getItemAtPosition(position);
            if(link!=null){
                Intent intent = new Intent(this, WebDisplayActivity.class);
                intent.putExtra("Link",link.darEnlace()); //Put your id to your next Intent
                startActivity(intent);
            }
        }
        else if(parent.getId() == R.id.listEvents){
            Articulo art = (Articulo) listaEventos.getItemAtPosition(position);
            if(art!=null){
                Intent intent = new Intent(this, EventActivity.class);
                intent.putExtra("Evento",art); //Put your id to your next Intent
                startActivity(intent);
            }
        }
        else if(parent.getId() == R.id.listResults){
            Articulo art = (Articulo) listaBuscados.getItemAtPosition(position);
            if(art!=null){
                if(art instanceof Evento){
                    Intent intent = new Intent(this, EventActivity.class);
                    intent.putExtra("Evento",art); //Put your id to your next Intent
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(this, NewsActivity.class);
                    intent.putExtra("Noticia",art); //Put your id to your next Intent
                    startActivity(intent);
                }
            }
        }
    }

    /**
     * Método que actualiza las noticias cargadas desde el servidor
     * @param pNoticias Lista de noticias
     */
    public void actualizarNoticias(ArrayList<Articulo> pNoticias) {
        noticias = pNoticias;
        listaNoticias.setAdapter(new AdaptadorNoticia(this,R.layout.lista_noticia,noticias));
    }

    /**
     * Método que actualiza los eventos cargados desde el servidor
     * @param pEventos Lista de eventos
     */
    public void actualizarEventos(ArrayList<Articulo> pEventos) {
        eventos = pEventos;
        listaEventos.setAdapter(new AdaptadorNoticia(this,R.layout.lista_noticia,eventos));
    }

}
