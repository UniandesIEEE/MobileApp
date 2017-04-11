package co.edu.uniandes.ieee.ramaieeeuniandes.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Articulo;
import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Evento;
import co.edu.uniandes.ieee.ramaieeeuniandes.R;

/**
 * Created by juanm on 29/06/2016.
 */
public class AdaptadorNoticia extends ArrayAdapter<Articulo> {

    private ArrayList<Articulo> noticias;

    private Context contexto;

    public AdaptadorNoticia(Context context, int textViewResourceId, ArrayList<Articulo> users) {
        super(context, textViewResourceId, users);
        noticias = users;
        contexto=context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.lista_noticia, null);
        }
        Articulo articulo = noticias.get(position);
        if (articulo != null) {
            TextView fecha = (TextView) v.findViewById(R.id.fechaNoticia);
            TextView username = (TextView) v.findViewById(R.id.tituloNoticia);
            TextView capitulo = (TextView) v.findViewById(R.id.dependenciaNoticia);
            ImageView imagen = (ImageView) v.findViewById(R.id.imagen_noticia);
            if (username != null) {
                username.setText(articulo.darTitulo());
            }
            if (imagen != null){
                imagen.setImageResource(articulo.darImagenDependenciaRenderizada());
            }
            if (fecha != null){
                fecha.setText(articulo.darFecha());
            }
            if (capitulo != null){
                capitulo.setText(articulo.darCapitulo());
            }

            TextView lugar = (TextView) v.findViewById(R.id.lugarEvento);
            if (articulo instanceof Evento){
                Evento ev = (Evento) articulo;
                if (lugar != null){
                    lugar.setText(ev.darLugar());
                }
            }
            else{
                lugar.setVisibility(View.GONE);
            }
        }
        return v;
    }
}
