package co.allza.comedycentralgui;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.allza.comedycentralgui.adapter.PagerChicoAdapter;
import co.allza.comedycentralgui.adapter.PagerGrandeAdapter;
import co.allza.comedycentralgui.models.PChicoModel;
import co.allza.comedycentralgui.models.PGrandeModel;
import co.allza.comedycentralgui.pageTransformers.DefaultTransformer;
import co.allza.comedycentralgui.pageTransformers.ZoomOutPageTransformer;

/**
 * Created by Tavo on 24/08/2016.
 */
public class PruebaActivity extends AppCompatActivity {

    ArrayList<PGrandeModel> grande;
    ArrayList<PChicoModel> chico;
    PagerGrandeAdapter adapterGrande;
    PagerChicoAdapter adapterChico;
    ViewPager pagerGrande;
    ViewPager pagerChico;
    Toolbar toolbar;
    ImageView overflowButton;
    private static final String TITLE = "title";
    private static final String ICON = "icon";
    ListPopupWindow popupWindow;
    List<HashMap<String, Object>> data;

    HashMap<String, Object> map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);
        pagerGrande=(ViewPager) findViewById(R.id.vpGrande);
        pagerChico=(ViewPager) findViewById(R.id.vpChico);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        FrameLayout.LayoutParams lp=new FrameLayout.LayoutParams(toolbar.getLayoutParams());
        lp.setMargins(0,getStatusBarHeight(),0,0);
        toolbar.setLayoutParams(lp);
        grande=new ArrayList<>();
        chico=new ArrayList<>();

        for(int i=0;i<10;i++) {
            grande.add(new PGrandeModel());
            chico.add(new PChicoModel());
        }
        chico.add(new PChicoModel());
        chico.add(new PChicoModel());
        adapterGrande=new PagerGrandeAdapter(this,grande);
        adapterChico=new PagerChicoAdapter(this,chico);

        pagerGrande.setAdapter(adapterGrande);
        pagerChico.setAdapter(adapterChico);

        pagerChico.setOffscreenPageLimit(7);
        pagerChico.setPageMargin(0);
        pagerChico.setPageTransformer(true,new ZoomOutPageTransformer());


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


        overflowButton=(ImageView)findViewById(R.id.overflow);
        overflowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(PruebaActivity.this, overflowButton);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.menu_principal, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                PruebaActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
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
