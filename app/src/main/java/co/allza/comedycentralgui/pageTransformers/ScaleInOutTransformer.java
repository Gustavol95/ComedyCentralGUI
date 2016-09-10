package co.allza.comedycentralgui.pageTransformers;

import android.view.View;

/**
 * Created by Tavo on 19/08/2016.
 */
public class ScaleInOutTransformer extends ABaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        view.setPivotX(position < 0 ? 0 : view.getWidth());
        view.setPivotY(view.getHeight() / 2f);
        float scale = position < 0 ? 1f + position : 1f ;
        view.setScaleX(scale);
        view.setScaleY(scale);
    }

}