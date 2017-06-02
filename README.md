> ## 栗子——高仿美团首页分类按钮（更灵活）

---


> ### 栗子惯例，先上GIF

![栗子.gif](http://upload-images.jianshu.io/upload_images/2071764-c9416063ff366935.gif)



## 使用姿势

**引入（使用Gradle或者Maven）**

1）Gradle

    allprojects {
        repositories {
			...
            maven { url 'https://jitpack.io' }
        }
    }
    dependencies {
        compile 'com.github.FJ917:FJMtSortButton:v1.1'
    }
2）Maven

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

	<dependency>
	    <groupId>com.github.FJ917</groupId>
	    <artifactId>FJMtSortButton</artifactId>
	    <version>v1.1</version>
	</dependency>
	
---

#### v1.1版本
## 新增自定义控件DynamicSoreView
实现通过服务器获取的数据，动态添加按钮，可以设置每页显示的个数。
## 使用方法
1）xml文件
```
    <fj.mtsortbutton.lib.DynamicSoreView
        android:id="@+id/dynamicSoreView"
        android:background="#ffffff"
        app:SoreRadioSelect="@drawable/radio1"
        app:SoreRadioUnselected="@drawable/radio2"
        app:SoreNumber="6"
        app:SoreDistance="20"
        android:layout_width="match_parent"
        android:layout_height="170dp"/>
```
2 )java
```
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
```

#### 说明：修改了1.0里的使用方式，但原来的也可以用，详细参考1.0使用方法
---

#### v1.0版本

## 使用方法

1）xml文件
```
	<!--以前 -->
    <fj.mtsortbutton.lib.SoreButton
        android:id="@+id/soreButton"
        android:background="#ffffff"
        android:layout_width="match_parent"
        android:layout_height="170dp"/>
	<!-- 修改 -->
	<fj.mtsortbutton.lib.SoreButton
        android:id="@+id/soreButton"
        android:background="#ffffff"
        app:SoreRadioSelect="@drawable/radio1"
        app:SoreRadioUnselected="@drawable/radio2"
        app:SoreDistance="20"
        android:layout_width="match_parent"
        android:layout_height="170dp"/>
```	
        
2）java文件
1.对自定义控件做一些设置

        //设置界面监听
        soreButton.setViewControl(this);
        //添加界面到list
        list = new ArrayList<>();
        list.add(R.layout.viewpager_page);
        list.add(R.layout.viewpager_page);
        list.add(R.layout.viewpager_page_text);

        //控件相关设置
		//以前
        soreButton
                //设置选中和未选中指示器图标
                .setIndicator(R.drawable.radio1,R.drawable.radio2)
                //设置指示器半间距px
                .setDistance(10)
                //设置view组
                .setView(list)
                .init();
		//修改（废弃了设置参数的方法，但是也可以用，只是建议在xml设置）
		soreButton.setView(list).init();
将layout的布局add进去list中，然后调用setView方法把list传过去，
还提供了设置指示器图标的方法，以及指示器间距的方法，最后必须调用初始化方法init进行初始化


这是其中的一个layout布局，其实这里可以添加任意布局文件进去，是不是比美团更灵活呢？
`布局R.layout.viewpager_page`

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="5dp"
        android:background="#ffffff" >
    
        <GridView
            android:id="@+id/gridView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:horizontalSpacing="5dp"
            android:numColumns="5"
            android:scrollbars="none"
            android:stretchMode="columnWidth"
            android:verticalSpacing="10dp" />
    
    </LinearLayout>

2.设置soreButton监听事件(具体的可以参考GIt里面的Demo)

      public class MainActivity extends AppCompatActivity implements ViewControl {
    
        private SoreButton soreButton;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            soreButton = (SoreButton) findViewById(R.id.soreButton);
    
            soreButton.setViewControl(this);
        }
    
        @Override
        public void setView(View view, final int type) {
            //这里会返回前面设置进去的View及对应的type,然后就可以进行操作了
        }
    }

**划重点：上面的list中可以传入任意layout布局，然后通过接口回掉拿到View。比美团更加灵活。**

**[博客地址](http://www.jianshu.com/p/e1631a8fab68)**
