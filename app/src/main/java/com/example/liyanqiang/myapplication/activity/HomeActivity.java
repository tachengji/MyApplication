package com.example.liyanqiang.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.liyanqiang.myapplication.R;
import com.example.liyanqiang.myapplication.adapter.DlayAdapter;
import com.example.liyanqiang.myapplication.fragment.BaseFragment;
import com.example.liyanqiang.myapplication.fragment.HomeFragment;
import com.example.liyanqiang.myapplication.fragment.LessonFragment;
import com.example.liyanqiang.myapplication.fragment.PersonFragment;
import com.example.liyanqiang.myapplication.model.ItemList;
import com.gongwen.marqueen.SimpleMF;
import com.gongwen.marqueen.SimpleMarqueeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeActivity extends BasicActivity {

    private BottomNavigationView navigationView;
    private BaseFragment[] baseFragments;
    private int lastShowFragment;

    /**
     * 首页
     * @param savedInstanceState
     */
    private BaseFragment homeFragment;
    private BaseFragment lessonFragment;
    private BaseFragment personFragment;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        initFragment();

    }





    public void init(){
        navigationView=(BottomNavigationView)findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation__home:
                        if(lastShowFragment!=0){
                            switchFragment(lastShowFragment,0);
                            lastShowFragment=0;
                        }

                        return true;
                    case R.id.navigation_lesson:
                        if(lastShowFragment!=1){
                            switchFragment(lastShowFragment,1);
                            lastShowFragment=1;
                        }

                        return true;
                    case R.id.navigation_person:

                        if (lastShowFragment!=2){
                            switchFragment(lastShowFragment,2);
                            lastShowFragment=2;
                        }
                        return true;
                }

                return false;
            }
        });


    }

    public void initFragment(){
        homeFragment=new HomeFragment();
        lessonFragment=new LessonFragment();
        personFragment=new PersonFragment();

        baseFragments=new BaseFragment[]{
                homeFragment,
                lessonFragment,
                personFragment
        };

        lastShowFragment=0;

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentLayout,homeFragment)
                .show(homeFragment)
                .commit();
        }

        public void switchFragment(int lastIndex,int index){
            FragmentTransaction transaction=getSupportFragmentManager()
                    .beginTransaction();
            transaction.hide(baseFragments[lastIndex]);

            if(!baseFragments[index].isAdded()){
                transaction.add(R.id.fragmentLayout,baseFragments[index]);
            }

            transaction.show(baseFragments[index])
                    .commitAllowingStateLoss();
        }
}
