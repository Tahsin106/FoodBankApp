package com.example.user.foodbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class second_activity extends AppCompatActivity {
    List<ItemInfo> list = new ArrayList<>();

    ListView listv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        listv = (ListView)findViewById(R.id.lview);
        Intent intent = getIntent();
        String foodName = intent.getStringExtra("FOOD");
        String area  = intent.getStringExtra("AREA");
        Toast.makeText(this,foodName,Toast.LENGTH_LONG).show();

        /*String[] items = {"hello","this","popo"};
        String[] price = {"hello","this","popo"};
        String[] shop = {"hello","this","popo"};*/
/*
        list.add(new ItemInfo("Burger BBQ","250","Chillox","Dhanmondi"));
        list.add(new ItemInfo("Burger CHEESE","150","Takeout","Dhanmondi"));
        list.add(new ItemInfo("Burger CHICKEN","150","Madchef","Gulshan"));
        list.add(new ItemInfo("Pasta BEEF","250","Alfresco","Gulshan"));
        list.add(new ItemInfo("Pasta BBQ","150","Tune and Bite","Dhanmondi"));
        list.add(new ItemInfo("Pasta CHICKEN","500","Appeliano","Dhanmondi"));
        list.add(new ItemInfo("Pizza SPECIAL","350","Pizza Hut","Malibag"));
        list.add(new ItemInfo("Pizza CHICKEN","170","Pizza King","Baily Road"));
        list.add(new ItemInfo("Pizza BEEF","150","KFC","Dhanmondi"));
        list.add(new ItemInfo("Set Menu REGULAR","110","BFC","Sylhet"));
        list.add(new ItemInfo("Set Menu SPECIAL","250","KFC","Shyamoli"));
        list.add(new ItemInfo("Drinks COFFEE","50","KFC","Dhanomndi"));
        list.add(new ItemInfo("Drinks Juice","100","KFC","Dhanmondi"));
*/

        DatabaseHandler db=new DatabaseHandler(this);
     /*
        db.addData(new ItemInfo("Burger BBQ","250","Chillox","Dhanmondi"));
        db.addData(new ItemInfo("Burger CHEESE","150","Takeout","Dhanmondi"));
        db.addData(new ItemInfo("Burger CHICKEN","150","Madchef","Gulshan"));
        db.addData(new ItemInfo("Pasta BEEF","250","Alfresco","Gulshan"));
        db.addData(new ItemInfo("Pasta BBQ","150","Tune and Bite","Dhanmondi"));
        db.addData(new ItemInfo("Pasta CHICKEN","500","Appeliano","Dhanmondi"));
        db.addData(new ItemInfo("Pizza SPECIAL","350","Pizza Hut","Malibag"));
        db.addData(new ItemInfo("Pizza CHICKEN","170","Pizza King","Baily Road"));
        db.addData(new ItemInfo("Pizza BEEF","150","KFC","Dhanmondi"));
*/
        list = db.getAllData();



     ///   ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.list_layout,R.id.txtview,s);
        MyAdapter adapter = new MyAdapter(this,getItemName(list,foodName,area),getItemprice(list,foodName,area),getShopName(list,foodName,area),getShopArea(list,foodName,area));
        listv.setAdapter(adapter);

    }

    List<String> getItemName(List<ItemInfo> itemLists,String food,String area){
        List<String> itemsName = new ArrayList<>();
        for (int i=0;i<itemLists.size();i++){
            if(itemLists.get(i).getItemName().contains(food)&&itemLists.get(i).getShopArea().contains(area)) {
                itemsName.add(itemLists.get(i).getItemName());
            }
        }
        return itemsName;

    }

    List<String> getItemprice(List<ItemInfo> itemLists,String food,String area){
        List<String> itemsprice = new ArrayList<>();
        for (int i=0;i<itemLists.size();i++){
            if(itemLists.get(i).getItemName().contains(food)&&itemLists.get(i).getShopArea().contains(area)) {
                itemsprice.add(itemLists.get(i).getPrice());
            }
        }
        return itemsprice;

    }
    List<String> getShopName(List<ItemInfo> itemLists,String food,String area){
        List<String> itemsShop = new ArrayList<>();
        for (int i=0;i<itemLists.size();i++){
            if(itemLists.get(i).getItemName().contains(food)&&itemLists.get(i).getShopArea().contains(area)) {
                itemsShop.add(itemLists.get(i).getShopName());
            }
        }
        return itemsShop;

    }
    List<String> getShopArea(List<ItemInfo> itemLists,String food,String area){
        List<String> itemsShop = new ArrayList<>();
        for (int i=0;i<itemLists.size();i++){
            if(itemLists.get(i).getItemName().contains(food)&&itemLists.get(i).getShopArea().contains(area)) {
                itemsShop.add(itemLists.get(i).getShopArea());
            }
        }
        return itemsShop;

    }
}
