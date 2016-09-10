package co.allza.comedycentralgui.pageTransformers;

import android.util.Log;
import android.view.View;

/**
 * Created by Tavo on 19/08/2016.
 */
public class DefaultTransformer extends ABaseTransformer {



    @Override
    protected void onTransform(View view, float position) {
        float scale = position < 0 ? 1f  : 1f+ position ;
      //  view.setPivotX(view.getWidth()/2f);
        view.setPivotY(view.getHeight() / 1.5f);
        view.setScaleX(scale);
        view.setScaleY(scale);
    }

    @Override
    public boolean isPagingEnabled() {
        return true;
    }

}
