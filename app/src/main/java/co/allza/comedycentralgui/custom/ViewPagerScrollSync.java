package co.allza.comedycentralgui.custom;

import android.support.v4.view.ViewPager;

/**
 * Created by Tavo on 17/08/2016.
 */
public class ViewPagerScrollSync implements ViewPager.OnPageChangeListener {
    private ViewPager actor; // the one being scrolled
    private ViewPager target; // the one that needs to be scrolled in sync

    public ViewPagerScrollSync(ViewPager actor, ViewPager target) {
        this.actor = actor;
        this.target = target;
        actor.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (actor.isFakeDragging()) {
            return;
        }

        if (state == ViewPager.SCROLL_STATE_DRAGGING) {
            // actor has begun a drag
            target.beginFakeDrag();
        } else if (state == ViewPager.SCROLL_STATE_IDLE) {
            // actor has finished settling
            target.endFakeDrag();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (actor.isFakeDragging()) {
            return;
        }
        if (target.isFakeDragging()) {
            // calculate drag amount in pixels.
            // i don't have code for this off the top of my head, but you'll probably
            // have to store the last position and offset from the previous call to
            // this method and take the difference.
            float dx = positionOffset;
            target.fakeDragBy(100);

        }
    }

    @Override
    public void onPageSelected(int position) {
        if (actor.isFakeDragging()) {
            return;
        }

        // Check isFakeDragging here because this callback also occurs when
        // the user lifts his finger on a drag. If it was a real drag, we will
        // have begun a fake drag of the target; otherwise it was probably a
        // programmatic change of the current page.
        if (!target.isFakeDragging()) {
            target.setCurrentItem(position);
        }
    }
}