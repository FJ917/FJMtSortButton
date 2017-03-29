package fj.mtsortbutton.test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fj.mtsortbutton.lib.Interface.ViewControl;
import fj.mtsortbutton.lib.SoreButton;
import fj.mtsortbutton.test.adapter.ButtonAdapter;

public class MainActivity extends AppCompatActivity implements ViewControl {

    private Context context;
    private SoreButton soreButton;
    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        soreButton = (SoreButton) findViewById(R.id.soreButton);

        //设置界面监听
        soreButton.setViewControl(this);
        //添加界面到list
        list = new ArrayList<>();
        list.add(R.layout.viewpager_page);
        list.add(R.layout.viewpager_page);
        list.add(R.layout.viewpager_page_text);

        //控件相关设置
        soreButton
                //设置选中和未选中指示器图标
                .setIndicator(R.drawable.radio1,R.drawable.radio2)
                //设置指示器半间距px
                .setDistance(10)
                //设置view组
                .setView(list)
                .init();
    }

    @Override
    public void setView(View view, final int type) {
        switch (type) {
            case 0://第一个界面
                GridView gridView = (GridView) view.findViewById(R.id.gridView);
                ButtonAdapter adapter = new ButtonAdapter(this,setData());
                gridView.setAdapter(adapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(context,"第"+type+"页"+position,Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 1://第二个界面
                GridView gridView2 = (GridView) view.findViewById(R.id.gridView);
                ButtonAdapter adapter2 = new ButtonAdapter(this,setData2());
                gridView2.setAdapter(adapter2);
                gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(context,"第"+type+"页"+position,Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 2://第三个界面
                TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
                tvTitle.setText("可高度定制，可设置任意layout,并且在回调中获取该layout内的所有控件");
                tvTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"点击了该文字",Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }
    }

    private List<HashMap> setData(){
        List<HashMap> data = new ArrayList<>();
        HashMap hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_1);
        hashMap.put("name","美食");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_2);
        hashMap.put("name","电影");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_3);
        hashMap.put("name","酒店");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_4);
        hashMap.put("name","休闲娱乐");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_5);
        hashMap.put("name","外卖");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_6);
        hashMap.put("name","机票/火车票");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_7);
        hashMap.put("name","KTV");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_8);
        hashMap.put("name","周边游");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_9);
        hashMap.put("name","丽人");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_10);
        hashMap.put("name","旅游出行");
        data.add(hashMap);
        return data;
    }

    private List<HashMap> setData2(){
        List<HashMap> data = new ArrayList<>();
        HashMap hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_11);
        hashMap.put("name","品质酒店");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_12);
        hashMap.put("name","生活服务");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_13);
        hashMap.put("name","足疗按摩");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_14);
        hashMap.put("name","母婴亲子");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_15);
        hashMap.put("name","结婚");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_16);
        hashMap.put("name","景点");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_17);
        hashMap.put("name","温泉");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_18);
        hashMap.put("name","学习培训");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_19);
        hashMap.put("name","洗浴/汗蒸");
        data.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("icon",R.drawable.icon_20);
        hashMap.put("name","全部分类");
        data.add(hashMap);
        return data;
    }
}
