package co.edu.uniandes.ieee.ramaieeeuniandes.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.Usuario;
import co.edu.uniandes.ieee.ramaieeeuniandes.R;

/**
 * Created by juanm on 16/07/2016.
 */
public class AdaptadorRanking extends ArrayAdapter<Usuario> {

    private ArrayList<Usuario> usuarios;

    private Context contexto;

    public AdaptadorRanking(Context context, int textViewResourceId, ArrayList<Usuario> users) {
        super(context, textViewResourceId, users);
        usuarios = users;
        contexto=context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.lista_ranking, null);
        }
        Usuario usuario = usuarios.get(position);
        if (usuario != null) {
            TextView nombre = (TextView) v.findViewById(R.id.txtName);
            TextView puntaje = (TextView) v.findViewById(R.id.txtScore);
            if (nombre != null) {
                nombre.setText(usuario.darNombre());
            }
            if (puntaje != null){
                puntaje.setText(""+usuario.darPuntaje());
            }
        }
        return v;
    }
}
