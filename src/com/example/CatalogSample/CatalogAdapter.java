package com.example.CatalogSample;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CatalogAdapter extends BaseAdapter {
    Context cont;
    LayoutInflater lInflater;
    ArrayList<ListData> objects;

    CatalogAdapter(Context context, ArrayList<ListData> mylist) {
        cont = context;
        objects = mylist;
        lInflater = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return objects.size();
    }

    public Object getItem(int position) {
        return objects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            //получаем LayoutInflater для работы с layout-ресурсами
            view = lInflater.inflate(R.layout.my_item, parent, false);

            holder = new ViewHolder();
            holder.textView1 = ((TextView) view.findViewById(R.id.textView1));
            holder.textView2 = ((TextView) view.findViewById(R.id.textView2));
            holder.imageView1 = ((ImageView) view.findViewById(R.id.imageView1));
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        ListData p = ((ListData) getItem(position));

        // заполняем View в пункте списка данными
        holder.textView1.setText(p.title);
        holder.textView2.setText("Цена: " + p.price + " рублей");
        holder.imageView1.setImageResource(p.image);

        return view;
    }

    static class ViewHolder {
        TextView textView1;
        TextView textView2;
        ImageView imageView1;
    }
}
