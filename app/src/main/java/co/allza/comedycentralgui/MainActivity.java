package co.allza.comedycentralgui;

import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import co.allza.comedycentralgui.adapter.PagerChicoAdapter;
import co.allza.comedycentralgui.adapter.PagerGrandeAdapter;
import co.allza.comedycentralgui.custom.ViewPagerScrollSync;
import co.allza.comedycentralgui.models.PChicoModel;
import co.allza.comedycentralgui.models.PGrandeModel;
import co.allza.comedycentralgui.pageTransformers.DefaultTransformer;
import co.allza.comedycentralgui.pageTransformers.ScaleInOutTransformer;
import co.allza.comedycentralgui.pageTransformers.ZoomOutPageTransformer;

public class MainActivity extends AppCompatActivity {

    ArrayList<PGrandeModel> grande;
    ArrayList<PChicoModel> chico;
    PagerGrandeAdapter adapterGrande;
    PagerChicoAdapter adapterChico;
    ViewPager pagerGrande;
    ViewPager pagerChico;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pagerGrande=(ViewPager) findViewById(R.id.vpGrande);
        pagerChico=(ViewPager) findViewById(R.id.vpChico);

        grande=new ArrayList<>();
        chico=new ArrayList<>();

        for(int i=0;i<10;i++) {
            grande.add(new PGrandeModel());
            chico.add(new PChicoModel());
        }

        adapterGrande=new PagerGrandeAdapter(this,grande);
        adapterChico=new PagerChicoAdapter(this,chico);

        pagerGrande.setAdapter(adapterGrande);
        pagerChico.setAdapter(adapterChico);

        pagerChico.setOffscreenPageLimit(7);
        pagerChico.setPageMargin(-20);
        pagerChico.setPageTransformer(true,new ZoomOutPageTransformer());

        pagerChico.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                pagerGrande.onTouchEvent(motionEvent);
                return true;
            }
        });
        pagerGrande.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            pagerChico.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pagerGrande.setPageTransformer(true,new DefaultTransformer());
    }
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
