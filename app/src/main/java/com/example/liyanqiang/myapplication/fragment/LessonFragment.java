package com.example.liyanqiang.myapplication.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.liyanqiang.myapplication.R;
import com.example.liyanqiang.myapplication.activity.MainActivity;
import com.example.liyanqiang.myapplication.adapter.LessonAdapter;
import com.example.liyanqiang.myapplication.model.ItemLesson;

import java.util.ArrayList;
import java.util.List;

public class LessonFragment extends BaseFragment {

    private TextView title;
    private GridView gridView;
    private List<ItemLesson> list;
    private LessonAdapter adapter;

    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.fragment_lesson,null);

        title=(TextView)view.findViewById(R.id.head_title);
        title.setText("课程列表");

        gridView=(GridView)view.findViewById(R.id.fragment_lesson_grid_view);
        list=new ArrayList<>();
        ItemLesson lesson=new ItemLesson();
                   lesson.setFlag("优·惠");
                   lesson.setTitle("好物甄选");
                   lesson.setIntroduce("热销精品专场");
                   lesson.setPicture(R.drawable.demo_four);
        list.add(lesson);

        ItemLesson lesson1=new ItemLesson();
                   lesson1.setFlag("国·礼");
                   lesson1.setTitle("丝绸世家");
                   lesson1.setIntroduce("爱上中国丝绸");
                   lesson1.setPicture(R.drawable.demo_three);
        list.add(lesson1);

        ItemLesson lesson2=new ItemLesson();
                   lesson2.setFlag("丝·绸");
                   lesson2.setTitle("匠心品质");
                   lesson2.setIntroduce("昌南瓷器名天下");
                   lesson2.setPicture(R.drawable.demo_two);
        list.add(lesson2);

        ItemLesson lesson3=new ItemLesson();
                   lesson3.setFlag("珠·宝");
                   lesson3.setTitle("自然之选");
                   lesson3.setIntroduce("点缀高雅气质");
                   lesson3.setPicture(R.drawable.demo_one);
        list.add(lesson3);



        adapter=new LessonAdapter(getActivity(),list);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setClass(getContext(),MainActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
