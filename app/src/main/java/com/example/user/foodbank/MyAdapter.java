package com.example.user.foodbank;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.resource;
import static android.R.attr.title;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;


public class MyAdapter extends ArrayAdapter<String> {
    Context context;
    List<String> Items;
    List<String> Prices;
    List<String> ShopName;
    List<String> ShopArea;
    public MyAdapter( Context context, List<String> itemsName,List<String> prices,List<String> shopName,List<String> shopArea) {
        super(context, R.layout.list_layout, R.id.txtview,itemsName);
        this.context = context;
        this.Items = itemsName;
        this.Prices = prices;
        this.ShopName = shopName;
        this.ShopArea = shopArea;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View row = inflater.inflate(R.layout.list_layout,parent,false);
       TextView itemName = (TextView) row.findViewById(R.id.txtview);
        TextView shopName = (TextView) row.findViewById(R.id.shopName);
        TextView price = (TextView) row.findViewById(R.id.price);
        TextView area = (TextView) row.findViewById(R.id.textArea);

        itemName.setText(Items.get(position));
        shopName.setText("Restaurant Name "+ShopName.get(position));
        price.setText("Price "+Prices.get(position)+" Tk ");
        area.setText("Restaurant Area: "+ShopArea.get(position));
        return row;

    }
}
