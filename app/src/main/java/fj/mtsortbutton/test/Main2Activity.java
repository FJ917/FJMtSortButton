package fj.mtsortbutton.test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fj.mtsortbutton.lib.DynamicSoreView;
import fj.mtsortbutton.lib.Interface.IDynamicSore;
import fj.mtsortbutton.test.adapter.SortButtonAdapter;
import fj.mtsortbutton.test.model.ButtonModel;

public class Main2Activity extends AppCompatActivity implements IDynamicSore {

    private Context context;
    private DynamicSoreView dynamicSoreView;
    private List<Integer> list;

    List buttonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context = this;
        dynamicSoreView = (DynamicSoreView) findViewById(R.id.dynamicSoreView);

        data();
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data();
            }
        });
    }

    private void data(){
        buttonList = setData();//模拟服务器获取到的按钮列表
        //设置界面监听
        dynamicSoreView.setiDynamicSore(this);
        //控件相关设置
        dynamicSoreView.setGridView(R.layout.viewpager_page).init(buttonList);
    }


    @Override
    public void setGridView(View view, final int type, List data) {
        List<ButtonModel> buttonModels= data;
        GridView gridView = (GridView) view.findViewById(R.id.gridView);
        dynamicSoreView.setNumColumns(gridView);
        SortButtonAdapter adapter = new SortButtonAdapter(this,buttonModels);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"第"+type+"页"+position,Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<ButtonModel> setData(){
        List<ButtonModel> data = new ArrayList<>();
        ButtonModel buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_1);
        buttonModel.setName("美食");
        data.add(buttonModel);
        
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_2);
        buttonModel.setName("电影");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_3);
        buttonModel.setName("酒店");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_4);
        buttonModel.setName("休闲娱乐");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_5);
        buttonModel.setName("外卖");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_6);
        buttonModel.setName("机票/火车票");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_7);
        buttonModel.setName("KTV");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_8);
        buttonModel.setName("周边游");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_9);
        buttonModel.setName("丽人");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_10);
        buttonModel.setName("旅游出行");
        data.add(buttonModel);

        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_11);
        buttonModel.setName("品质酒店");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_12);
        buttonModel.setName("生活服务");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_13);
        buttonModel.setName("足疗按摩");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_14);
        buttonModel.setName("母婴亲子");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_15);
        buttonModel.setName("结婚");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_16);
        buttonModel.setName("景点");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_17);
        buttonModel.setName("温泉");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_18);
        buttonModel.setName("学习培训");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_19);
        buttonModel.setName("洗浴/汗蒸");
        data.add(buttonModel);
        buttonModel = new ButtonModel();
        buttonModel.setDrawableIcon(R.drawable.icon_20);
        buttonModel.setName("全部分类");
        data.add(buttonModel);
        return data;
    }

}
