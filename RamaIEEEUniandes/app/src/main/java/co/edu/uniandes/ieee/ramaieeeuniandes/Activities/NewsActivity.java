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
import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Noticia;
import co.edu.uniandes.ieee.ramaieeeuniandes.R;

public class NewsActivity extends AppCompatActivity {

    /**
     * Atributo que modela la imagen de la noticia
     */
    private ImageView imagenNoticia;

    /**
     * Atributo que modela el título de la noticia
     */
    private TextView tituloNoticia;

    /**
     * Atributo que modela el autor de la noticia
     */
    private TextView autorNoticia;

    /**
     * Atributo que modela el copete de la notica
     */
    private TextView fechaNoticia;

    /**
     * Atributo que modela el cuerpo de la noticia
     */
    private TextView contenidoNoticia;

    /**
     * Atributo que modela la imagen del contenido de la noticia
     */
    private ImageView imagenContenidoNoticia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Intent i = getIntent();
        Noticia art = (Noticia) i.getSerializableExtra("Noticia");

        imagenNoticia = (ImageView) findViewById(R.id.imageNews);
        Bitmap bm = BitmapFactory.decodeResource(getResources(),art.darImagenDependencia());
        RoundImage roundedImage = new RoundImage(bm);
        imagenNoticia.setImageDrawable(roundedImage);

        imagenContenidoNoticia = (ImageView) findViewById(R.id.imageNewsContent);
        imagenContenidoNoticia.setImageResource(art.darImagenContenido());

        tituloNoticia = (TextView) findViewById(R.id.newsTitle);
        tituloNoticia.setText(art.darTitulo());

        autorNoticia = (TextView) findViewById(R.id.newsAuthor);
        autorNoticia.setText(art.darCapitulo());

        fechaNoticia = (TextView) findViewById(R.id.newsDate);
        fechaNoticia.setText(art.darFecha());

        contenidoNoticia = (TextView) findViewById(R.id.newsContent);
        contenidoNoticia.setText(art.darContenido());

        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutHeader);

        int pL = layout.getPaddingLeft();
        int pT = layout.getPaddingTop();
        int pR = layout.getPaddingRight();
        int pB = layout.getPaddingBottom();

        LinearLayout layoutContent = (LinearLayout) findViewById(R.id.layoutNewsContent);

        int pL1 = layoutContent.getPaddingLeft();
        int pT1 = layoutContent.getPaddingTop();
        int pR1 = layoutContent.getPaddingRight();
        int pB1 = layoutContent.getPaddingBottom();

        if(art.darCapitulo().equals(Articulo.IAS)){
            layout.setBackgroundResource(R.drawable.round_border_ias);
            layout.setPadding(pL, pT, pR, pB);
            layoutContent.setBackgroundResource(R.drawable.round_border_text_ias);
            layoutContent.setPadding(pL1, pT1, pR1, pB1);
        }
        else if(art.darCapitulo().equals(Articulo.COMPUTER)){
            layout.setBackgroundResource(R.drawable.round_border_computer);
            layout.setPadding(pL, pT, pR, pB);
            layoutContent.setBackgroundResource(R.drawable.round_border_text_computer);
            layoutContent.setPadding(pL1, pT1, pR1, pB1);
        }
        else if(art.darCapitulo().equals(Articulo.CSS)){
            layout.setBackgroundResource(R.drawable.round_border_css);
            layout.setPadding(pL, pT, pR, pB);
            layoutContent.setBackgroundResource(R.drawable.round_border_text_css);
            layoutContent.setPadding(pL1, pT1, pR1, pB1);
        }
    }
}
