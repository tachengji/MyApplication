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
import com.example.liyanqiang.myapplication.model.ItemList;
import com.example.liyanqiang.myapplication.tool.Circle;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends BaseAdapter {

    private Context context;
    private List<ItemHome> list;



    public HomeAdapter(Context context, List<ItemHome> list){
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
            convertView=LayoutInflater.from(context).inflate(R.layout.item_home,null);

            holder.flag=(ImageView)convertView.findViewById(R.id.item_flag);
            holder.title=(TextView)convertView.findViewById(R.id.item_titles);
            holder.number=(TextView)convertView.findViewById(R.id.lesson_number);

            holder.imgOne=(ImageView) convertView.findViewById(R.id.img_one);
            holder.tvOne=(TextView)convertView.findViewById(R.id.tv_one);

            holder.imgTwo=(ImageView) convertView.findViewById(R.id.img_two);
            holder.tvTwo=(TextView)convertView.findViewById(R.id.tv_two);

            holder.imgThree=(ImageView) convertView.findViewById(R.id.img_three);
            holder.tvThree=(TextView)convertView.findViewById(R.id.tv_three);

            holder.imgFour=(ImageView) convertView.findViewById(R.id.img_four);
            holder.tvFour=(TextView)convertView.findViewById(R.id.tv_four);

            holder.money=(TextView)convertView.findViewById(R.id.money);


            convertView.setTag(holder);

        }else {
            holder=(ImageHolder)convertView.getTag();
        }

        if(list.get(position).isFlag()){
            //图标
            holder.flag.setVisibility(View.VISIBLE);
            holder.flag.setImageResource(list.get(position).getLabel());

        }else {
            holder.flag.setVisibility(View.GONE);//隐藏不占位
        }

        //课程名
        holder.title.setText(list.get(position).getTitle());
        //课时数
        holder.number.setText(list.get(position).getNumber());
        //价格
        holder.money.setText("￥"+list.get(position).getMoney());

        Picasso.with(context)
                .load(list.get(position).getList().get(0).getPicture())
                .error(R.drawable.dialog_anonymity_like)
                .transform(new Circle())
                .into(holder.imgOne);
        holder.tvOne.setText(list.get(position).getList().get(0).getName());

        Picasso.with(context)
                .load(list.get(position).getList().get(1).getPicture())
                .error(R.drawable.dialog_anonymity_like)
                .transform(new Circle())
                .into(holder.imgTwo);
        holder.tvTwo.setText(list.get(position).getList().get(1).getName());

        Picasso.with(context)
                .load(list.get(position).getList().get(2).getPicture())
                .error(R.drawable.dialog_anonymity_like)
                .transform(new Circle())
                .into(holder.imgThree);
        holder.tvThree.setText(list.get(position).getList().get(2).getName());

        Picasso.with(context)
                .load(list.get(position).getList().get(3).getPicture())
                .error(R.drawable.dialog_anonymity_like)
                .transform(new Circle())
                .into(holder.imgFour);
        holder.tvFour.setText(list.get(position).getList().get(3).getName());






        return convertView;
    }

    class ImageHolder{
        ImageView flag;//图标
        TextView title;//课程名字
        TextView number;//课时数

        ImageView imgOne;
        TextView tvOne;

        ImageView imgTwo;
        TextView tvTwo;

        ImageView imgThree;
        TextView tvThree;

        ImageView imgFour;
        TextView tvFour;

        TextView money;

    }
}
