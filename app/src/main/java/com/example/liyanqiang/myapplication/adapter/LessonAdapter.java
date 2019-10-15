package com.example.liyanqiang.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liyanqiang.myapplication.R;
import com.example.liyanqiang.myapplication.model.ItemHome;
import com.example.liyanqiang.myapplication.model.ItemLesson;
import com.example.liyanqiang.myapplication.tool.Circle;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LessonAdapter extends BaseAdapter {

    private Context context;
    private List<ItemLesson> list;



    public LessonAdapter(Context context,List<ItemLesson> list){
        this.context=context;
        this.list=list;
    }




    @Override
    public int getCount() {
        return list==null?null:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list==null?null:list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageHolder holder;
        if(convertView==null){
            holder=new ImageHolder();
            convertView=LayoutInflater.from(context)
                    .inflate(R.layout.item_lesson,null);

            holder.flag=(TextView)convertView.findViewById(R.id.item_lesson_flag);
            holder.title=(TextView)convertView.findViewById(R.id.lesson_title_one);
            holder.introdue=(TextView)convertView.findViewById(R.id.item_lesson_introdue);
            holder.picture=(ImageView)convertView.findViewById(R.id.item_lesson_picture);


            convertView.setTag(holder);
        }else {
            holder=(ImageHolder)convertView.getTag();

        }

        holder.flag.setText(list.get(position).getFlag());
        holder.title.setText(list.get(position).getTitle());
        holder.title.setText(list.get(position).getIntroduce());
        Picasso.with(context)
                .load(list.get(position).getPicture())
                .transform(new Circle())
                .into(holder.picture);


        return convertView;
    }

    class ImageHolder{
        TextView flag;
        TextView title;
        TextView introdue;
        ImageView picture;



    }
}
