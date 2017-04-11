package co.edu.uniandes.ieee.ramaieeeuniandes.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import co.edu.uniandes.ieee.ramaieeeuniandes.ObjetosContenedores.IEEEinfo;
import co.edu.uniandes.ieee.ramaieeeuniandes.R;

/**
 * Created by juanm on 9/07/2016.
 */
public class AdaptadorIEEE extends ArrayAdapter<IEEEinfo> {

    private ArrayList<IEEEinfo> ieeeInfo;

    private Context contexto;

    public AdaptadorIEEE(Context context, int textViewResourceId, ArrayList<IEEEinfo> users) {
        super(context, textViewResourceId, users);
        ieeeInfo = users;
        contexto=context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.lista_ieee, null);
        }
        IEEEinfo info = ieeeInfo.get(position);
        if (info != null) {
            ImageView imagen = (ImageView) v.findViewById(R.id.imageIEEE);
            if (imagen != null){
                imagen.setImageResource(info.darImagen());
            }
        }
        return v;
    }
}
