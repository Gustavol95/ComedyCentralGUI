package co.allza.comedycentralgui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.allza.comedycentralgui.R;
import co.allza.comedycentralgui.models.PGrandeModel;

/**
 * Created by Tavo on 17/08/2016.
 */
public class PagerGrandeAdapter extends PagerAdapter {

    Context context;
    ArrayList<PGrandeModel> models;
    LayoutInflater inflater;

    public PagerGrandeAdapter(){}
    public PagerGrandeAdapter(Context ctx, ArrayList<PGrandeModel> list) {
        context=ctx;
        models=list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View vistaGrande = inflater.inflate(R.layout.view_background, container, false);
        TextView titulo=(TextView)vistaGrande.findViewById(R.id.textGrandeTitulo);
        TextView subtitulo=(TextView)vistaGrande.findViewById(R.id.textGrandeContenido);
        titulo.setText("Película o Serie"+position);
        subtitulo.setText("Informacion resumida de la pelicula o serie");
        container.addView(vistaGrande);
        return vistaGrande;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
