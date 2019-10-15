package com.example.liyanqiang.myapplication.activity;

import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.liyanqiang.myapplication.R;
import com.example.liyanqiang.myapplication.adapter.PictureAdapter;
import com.example.liyanqiang.myapplication.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class PictureActivity extends BasicActivity {

    private GridView gridView;
    private PictureAdapter adapter;
    private List<ItemList> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        init();
    }

    public void init(){
        gridView=(GridView)findViewById(R.id.grid_item);

        list=new ArrayList<>();

        for(int i=0;i<12;i++){
            ItemList itemList=new ItemList();
            itemList.setImg(R.drawable.baby);
            itemList.setTitle("可爱的小baby"+i);
            list.add(i,itemList);
        }
        adapter=new PictureAdapter(PictureActivity.this,list);
        gridView.setAdapter(adapter);

    }
}
