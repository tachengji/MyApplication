package com.example.liyanqiang.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.liyanqiang.myapplication.R;
import com.example.liyanqiang.myapplication.adapter.DlayAdapter;
import com.example.liyanqiang.myapplication.model.ItemList;
import com.gongwen.marqueen.SimpleMF;
import com.gongwen.marqueen.SimpleMarqueeView;


public class MainActivity extends BasicActivity {

    /**
     * listview
     */
    private ListView listView;
    private DlayAdapter adapter;
    private List<ItemList> list;



    private  SimpleMarqueeView<String> marqueeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    @Override
    protected void onStart() {
        super.onStart();
        marqueeView.startFlipping();
    }

    @Override
    protected void onStop() {
        super.onStop();
       marqueeView.stopFlipping();
    }

    public void init(){

        listView=(ListView)findViewById(R.id.list_view);

        list=new ArrayList<>();
        for(int i=0;i<6;i++){
            ItemList obj=new ItemList();
            obj.setTitle("中国"+i);
            obj.setIntroduce("淞花水乐园主要是游玩，约会的"+i);
            obj.setImg(R.drawable.baby);

            list.add(i,obj);
        }

        adapter=new DlayAdapter(MainActivity.this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this
                        ,"当前位置"+position,Toast.LENGTH_SHORT).show();

                Intent intent=new Intent();
                intent.setClass(MainActivity.this,PictureActivity.class);
                startActivity(intent);
            }
        });



        final List<String> datas = Arrays.asList("《赋得古原草送别》",
                "离离原上草，一岁一枯荣。", "野火烧不尽，春风吹又生。",
                "远芳侵古道，晴翠接荒城。", "又送王孙去，萋萋满别情。");
//SimpleMarqueeView<T>，SimpleMF<T>：泛型T指定其填充的数据类型，比如String，Spanned等
       marqueeView = (SimpleMarqueeView) findViewById(R.id.simpleMarqueeView);
        SimpleMF<String> marqueeFactory = new SimpleMF(this);
        marqueeFactory.setData(datas);
        marqueeView.setMarqueeFactory(marqueeFactory);
        marqueeView.startFlipping();
    }






}
