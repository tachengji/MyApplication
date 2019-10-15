package com.example.liyanqiang.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liyanqiang.myapplication.R;
import com.example.liyanqiang.myapplication.model.ItemList;

import java.util.List;

public class DlayAdapter extends BaseAdapter {

    private Context context;
    private List<ItemList> list;



    public DlayAdapter(Context context,List<ItemList> list){
        this.context=context;
        this.list=list;

    }


    @Override
    public int getCount() {
        return list==null?0:list.size();
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
            convertView=LayoutInflater.from(context).inflate(R.layout.item_main,null);

            holder.picture=(ImageView)convertView.findViewById(R.id.item_image);
            holder.title=(TextView)convertView.findViewById(R.id.item_title);
            holder.introduce=(TextView)convertView.findViewById(R.id.item_introduce);

            convertView.setTag(holder);

        }else {
            holder=(ImageHolder)convertView.getTag();
        }

        holder.title.setText(list.get(position).getTitle());
        holder.introduce.setText(list.get(position).getIntroduce());
        holder.picture.setImageResource(list.get(position).getImg());

        return convertView;
    }

    class ImageHolder{
        ImageView picture;
        TextView title;
        TextView introduce;

    }
}
