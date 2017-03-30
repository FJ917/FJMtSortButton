package fj.mtsortbutton.lib.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fj.mtsortbutton.lib.Interface.ViewControl;

public class ViewPagerAdapter extends PagerAdapter {

    private List<Integer> layoutArray = null;
    private Map<Integer, View> viewMap = null;
    //接口
    private ViewControl viewControl;

    public ViewPagerAdapter(@NonNull List<Integer> layoutArray, ViewControl viewControl) {
        this.layoutArray = layoutArray;
        this.viewControl = viewControl;

        viewMap = new HashMap<>();
    }

    @Override
    public int getCount() {
        return layoutArray.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = viewMap.get(i);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutArray.get(i), null);
            if (viewControl != null) {
                viewControl.setView(view, i);
            }
            viewMap.put(i, view);
        }
        viewGroup.addView(view, i);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup viewGroup, int i, Object object) {
        viewGroup.removeView(viewMap.get(i));
    }

}
