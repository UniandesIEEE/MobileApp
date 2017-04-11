package co.edu.uniandes.ieee.ramaieeeuniandes.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Articulo;
import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Evento;
import co.edu.uniandes.ieee.ramaieeeuniandes.R;

public class EventActivity extends AppCompatActivity {

    /**
     * Atributo que modela la vista de imagen de la dependencia del evento
     */
    private ImageView imagenDependenciaEvento;

    /**
     * Atributo que modela la vista de imagen del flyer del evento
     */
    private ImageView flyerEvento;

    /**
     * Atributo que modela la vista de texto del título del evento
     */
    private TextView tituloEvento;

    /**
     * Atributo que modela la vista de texto de la fecha del evento
     */
    private TextView fechaEvento;

    /**
     * Atributo que modela la vista de texto del lugar del evento
     */
    private TextView lugarEvento;

    /**
     * Atributo que modela la vista de texto de la dependencia que organiza el evento
     */
    private TextView dependenciaEvento;

    /**
     * Atributo que modela la vista de texto del contenido del evento
     */
    private TextView contenidoEvento;

    /**
     * Atributo que modela la vista de texto del puntaje del evento
     */
    private TextView puntajeEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Intent i = getIntent();
        Evento art = (Evento) i.getSerializableExtra("Evento");

        imagenDependenciaEvento = (ImageView) findViewById(R.id.imageEventDependence);
        Bitmap bm = BitmapFactory.decodeResource(getResources(),art.darImagenDependencia());
        RoundImage roundedImage = new RoundImage(bm);
        imagenDependenciaEvento.setImageDrawable(roundedImage);

        flyerEvento = (ImageView) findViewById(R.id.imageFlyer);
        flyerEvento.setImageResource(art.darImagenContenido());

        tituloEvento = (TextView) findViewById(R.id.titleEvent);
        tituloEvento.setText(art.darTitulo());

        dependenciaEvento = (TextView) findViewById(R.id.dependenceEvent);
        dependenciaEvento.setText(art.darCapitulo());

        lugarEvento = (TextView) findViewById(R.id.placeEvent);
        lugarEvento.setText(art.darLugar());

        fechaEvento = (TextView) findViewById(R.id.dateEvent);
        fechaEvento.setText(art.darFecha());

        contenidoEvento = (TextView) findViewById(R.id.contentEvent);
        contenidoEvento.setText(art.darContenido());

        puntajeEvento = (TextView) findViewById(R.id.scoreEvent);
        puntajeEvento.setText(""+art.darPuntaje()+" Seneca PTS");

        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutHeaderEvent);

        int pL = layout.getPaddingLeft();
        int pT = layout.getPaddingTop();
        int pR = layout.getPaddingRight();
        int pB = layout.getPaddingBottom();

        if(art.darCapitulo().equals(Articulo.IAS)){
            layout.setBackgroundResource(R.drawable.round_border_ias);
            layout.setPadding(pL, pT, pR, pB);
        }
        else if(art.darCapitulo().equals(Articulo.COMPUTER)){
            layout.setBackgroundResource(R.drawable.round_border_computer);
            layout.setPadding(pL, pT, pR, pB);
        }
        else if(art.darCapitulo().equals(Articulo.CSS)){
            layout.setBackgroundResource(R.drawable.round_border_css);
            layout.setPadding(pL, pT, pR, pB);
        }
    }
}
