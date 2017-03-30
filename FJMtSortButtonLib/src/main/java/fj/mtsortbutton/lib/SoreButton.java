package fj.mtsortbutton.lib;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import fj.mtsortbutton.lib.Interface.ViewControl;
import fj.mtsortbutton.lib.adapter.ViewPagerAdapter;


public class SoreButton extends LinearLayout {
    Context mContext;
    private ViewPager viewPager;
    private LinearLayout llIndicator;
    //选中图片
    private int RadioSelect = R.drawable.radio_select;
    //未选中图片
    private int RadioUnselected = R.drawable.radio_unselected;
    //圆点间距
    private int distance = 10;

    private List<Integer> listView;
    private ViewControl viewControl;

    //设置接口
    public void setViewControl(ViewControl viewControl) {
        this.viewControl = viewControl;
    }

    public SoreButton(Context context) {
        super(context);
    }

    public SoreButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.anfq_sore_button, this, true);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        llIndicator = (LinearLayout) findViewById(R.id.llIndicator);
        //设置空布局
        listView = new ArrayList<>();
        listView.add(R.layout.viewpager_default);
    }

    //初始化ViewPager
    private void initViewPager() {
        //设置viewPager的Adapter
        viewPager.setAdapter(new ViewPagerAdapter(listView, viewControl));
        //初始化LinearLayout，加入指示器
        initLinearLayout(viewPager, listView.size(), llIndicator);
    }

    /**
     * 设置指示器，设置ViewPager滑动事件监听
     *
     * @param viewPager    --ViewPager
     * @param pageSize     --View的页数
     * @param linearLayout --LinearLayout
     */
    private void initLinearLayout(ViewPager viewPager, int pageSize, LinearLayout linearLayout) {
        //定义数组放置指示器的点，pageSize是View个数
        final ImageView[] imageViews = new ImageView[pageSize];
        for (int i = 0; i < pageSize; i++) {
            //创建ImageView
            ImageView image = new ImageView(mContext);
            //将ImageView放入数组
            imageViews[i] = image;
            //默认选中第一个
            if (i == 0) {
                //选中的点
                image.setImageResource(RadioSelect);
            } else {
                //未选中的点
                image.setImageResource(RadioUnselected);
            }
            //设置宽高
            LayoutParams params = new LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.setMargins(distance, 0, distance, 0);
            //将点添加到LinearLayout中
            linearLayout.addView(image, params);
        }

        //ViewPager的滑动事件
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int arg0) {
                //arg0当前ViewPager
                for (int i = 0; i < imageViews.length; i++) {
                    //设置为选中的点
                    imageViews[arg0].setImageResource(RadioSelect);
                    //判断当前的点i如果不等于当前页的话就设置为未选中
                    if (arg0 != i) {
                        imageViews[i].setImageResource(RadioUnselected);
                    }
                }
            }
        });
    }

    /**
     * 设置圆点距离
     *
     * @param distance --距离
     * @return
     */
    public SoreButton setDistance(int distance) {
        this.distance = distance;
        return this;
    }

    /**
     * 设置指示器图片
     *
     * @param radioSelect     --选中图片
     * @param radioUnselected --未选中图片
     * @return
     */
    public SoreButton setIndicator(int radioSelect, int radioUnselected) {
        //选中图片
        RadioSelect = radioSelect;
        //未选中图片
        RadioUnselected = radioUnselected;
        return this;
    }

    /**
     * 设置view
     *
     * @param listView --view
     * @return
     */
    public SoreButton setView(List<Integer> listView) {
        this.listView = listView;
        return this;
    }

    /**
     * 设置初始化
     */
    public SoreButton init() {
        initViewPager();
        return this;
    }
}
