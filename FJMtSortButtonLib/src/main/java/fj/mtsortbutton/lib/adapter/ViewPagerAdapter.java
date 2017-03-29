package fj.mtsortbutton.lib.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
	
	private List<View> views = null;

	public ViewPagerAdapter(List<View> views) {
		this.views = views;
	}

	@Override
	public int getCount() {
		return views.size() > 0 ? views.size() : 0;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public Object instantiateItem(ViewGroup viewGroup, int i) {
		viewGroup.addView(views.get(i));
		return views.get(i);
	}

	@Override
	public void destroyItem(ViewGroup viewGroup, int i, Object object) {
		viewGroup.removeView(views.get(i));
	}
	
}
