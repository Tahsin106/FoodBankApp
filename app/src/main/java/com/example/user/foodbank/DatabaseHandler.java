package com.example.user.foodbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 8/10/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION=2;
    private static final String DATABASE_NAME="foodbank";
    private static final String TABLE_NAME="food";
    private static final String F_ID="id";
    private static final String R_NAME="rname";
    private static final String R_AREA="rarea";
    private static final String F_PRICE = "price";
    private static final String F_NAME = "foodname";

    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        String CREATE_CONTACT_TABLE="CREATE TABLE "+ TABLE_NAME +"("
                + F_ID +" INTEGER PRIMARY KEY,"
                + F_NAME +" TEXT,"
                + F_PRICE +" TEXT,"
                + R_NAME +" TEXT,"
                + R_AREA +" TEXT" +")";




        db.execSQL(CREATE_CONTACT_TABLE);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void addData(ItemInfo food)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        /*
        String query = "INSERT INTO FOOD(FOODNAME,PRICE,RNAME" +
                ")VALUES("+food.getItemName()+","+food.getPrice()+","+food.getShopName()+")";
                */
        //db.execSQL(query);

        ContentValues value=new ContentValues();
        value.put(F_NAME, food.getItemName());
        value.put(F_PRICE,food.getPrice());
        value.put(R_NAME,food.getShopName());
        value.put(R_AREA,food.getShopArea());

        db.insert(TABLE_NAME, null,value);

        db.close();

    }

    public List<ItemInfo> getAllData()
    {
        List<ItemInfo> List=new ArrayList<ItemInfo>();

        String selectquery="SELECT * FROM "+ TABLE_NAME;

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                ItemInfo fd = new ItemInfo(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
                List.add(fd);
            }while(cursor.moveToNext());
        }
        db.close();
        return List;
    }

    boolean isEmpty()
    {

        String selectquery="SELECT * FROM "+ TABLE_NAME;

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
           return false;
        }

        return true;
    }
}
