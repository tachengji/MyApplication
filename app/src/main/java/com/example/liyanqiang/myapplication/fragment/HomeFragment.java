package com.example.liyanqiang.myapplication.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.liyanqiang.myapplication.R;
import com.example.liyanqiang.myapplication.activity.HomedetailActivity;
import com.example.liyanqiang.myapplication.adapter.HomeAdapter;
import com.example.liyanqiang.myapplication.model.ItemHome;
import com.example.liyanqiang.myapplication.model.ItemHomePerson;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment{
    private ListView listView;

    private List<ItemHome> list;

    private HomeAdapter adapter;

    private List<ItemHomePerson> personList;

    private List<ItemHomePerson> personList1;

    private List<ItemHomePerson> personList2;

    private TextView title;

    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.fragment_home,null);

        title=(TextView)view.findViewById(R.id.head_title);
        title.setText("这是什么");

        listView=(ListView)view.findViewById(R.id.fragment_home_list_view);

        list=new ArrayList<>();
        personList =new ArrayList<>();
        personList1=new ArrayList<>();
        personList2=new ArrayList<>();

        ItemHome itemHome=new ItemHome();
                 itemHome.setLabel(R.drawable.activity_chat_friend_companion);
                 itemHome.setTitle("2020考研张宇数学班");
                 itemHome.setNumber("300");
                 itemHome.setMoney("5600");
                 itemHome.setFlag(true);

         ItemHomePerson person=new ItemHomePerson();
                        person.setPicture(R.drawable.demo_one);
                        person.setName("张宇");

                        personList.add(person);
         ItemHomePerson person1=new ItemHomePerson();
                        person1.setPicture(R.drawable.demo_two);
                        person1.setName("王笑含");
                        personList.add(person1);
         ItemHomePerson person2=new ItemHomePerson();
                        person2.setPicture(R.drawable.demo_three);
                        person2.setName("孙井志");
                        personList.add(person2);
         ItemHomePerson person3=new ItemHomePerson();
                        person3.setPicture(R.drawable.demo_four);
                        person3.setName("王二麻子");
                        personList.add(person3);
         itemHome.setList(personList);

         list.add(itemHome);

         ////////////////////
        ItemHome itemHome1=new ItemHome();
                 itemHome1.setLabel(R.drawable.activity_chat_friend_companion);
                 itemHome1.setTitle("java学习交流版");
                 itemHome1.setNumber("600");
                 itemHome1.setMoney("4900");
                 itemHome1.setFlag(false);

        ItemHomePerson person4=new ItemHomePerson();
                       person4.setPicture(R.drawable.demo_four);
                       person4.setName("关羽与与");
                       personList1.add(person4);

        ItemHomePerson person5=new ItemHomePerson();
                       person5.setPicture(R.drawable.demo_three);
                       person5.setName("哈哈哈哈");
                       personList1.add(person5);

        ItemHomePerson person6=new ItemHomePerson();
                       person6.setPicture(R.drawable.demo_two);
                       person6.setName("赵云");
                       personList1.add(person6);

        ItemHomePerson person7=new ItemHomePerson();
                       person7.setPicture(R.drawable.demo_one);
                       person7.setName("曹操");
                       personList1.add(person7);

        itemHome1.setList(personList1);
        list.add(itemHome1);
        /////////////
        ItemHome itemHome2=new ItemHome();
                 itemHome2.setLabel(R.drawable.activity_chat_friend_companion);
                 itemHome2.setTitle("我也不知道这是什么班，也不敢问");
                 itemHome2.setNumber("250");
                 itemHome2.setMoney("10000");
                 itemHome2.setFlag(true);

        ItemHomePerson person8=new ItemHomePerson();
                       person8.setPicture(R.drawable.demo_one);
                       person8.setName("王一");
                       personList2.add(person8);

        ItemHomePerson person9=new ItemHomePerson();
                       person9.setPicture(R.drawable.demo_two);
                       person9.setName("王二");
                       personList2.add(person9);

        ItemHomePerson person10=new ItemHomePerson();
                       person10.setPicture(R.drawable.demo_three);
                       person10.setName("王三");
                       personList2.add(person10);

        ItemHomePerson person11=new ItemHomePerson();
                       person11.setPicture(R.drawable.demo_four);
                       person11.setName("王四");
                       personList2.add(person11);

        itemHome2.setList(personList2);
        list.add(itemHome2);


        adapter=new HomeAdapter(getActivity(),list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setClass(getContext(),HomedetailActivity.class);
                intent.putExtra("title",list.get(position).getTitle());
                startActivity(intent);
            }
        });

        return view;
    }
}
