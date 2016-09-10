package co.allza.comedycentralgui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.allza.comedycentralgui.R;
import co.allza.comedycentralgui.models.PChicoModel;


/**
 * Created by Tavo on 17/08/2016.
 */
public class PagerChicoAdapter  extends PagerAdapter{

    Context context;
    ArrayList<PChicoModel> models;
    LayoutInflater inflater;

    public PagerChicoAdapter(){}

    public PagerChicoAdapter(Context ctx, ArrayList<PChicoModel> list) {
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
        if(position<models.size()-2){
        View vistaChica = inflater.inflate(R.layout.view_foreground, container, false);
        TextView text=(TextView)vistaChica.findViewById(R.id.textChico);
        text.setText(context.getResources().getString(R.string.abbeyroad)+" "+position);
        container.addView(vistaChica);
        return vistaChica;}
        else
            return inflater.inflate(R.layout.view_empty,container,false);


    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public float getPageWidth(int position) {
        return (0.4f);
    }
}


