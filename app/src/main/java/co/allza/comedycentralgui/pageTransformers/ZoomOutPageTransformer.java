package co.allza.comedycentralgui.pageTransformers;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Tavo on 17/08/2016.
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;



    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position <= 1) { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setPivotX(0f);
                view.setPivotY(0f);
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                view.setPivotX(0f);
                view.setPivotY(0f);
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Scale the page down (between MIN_SCALE and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);


        }
    }}