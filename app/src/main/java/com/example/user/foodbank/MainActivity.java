package com.example.user.foodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText foodED,areaED;
    String food="";
    String area  = "";
    //static String FOODNAME = "FOOD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Toast.makeText(this,"Search based on Food and Area or only Food or only Area",Toast.LENGTH_LONG).show();

        foodED = (EditText)findViewById(R.id.field1);
        food = foodED.getText().toString();

        areaED = (EditText)findViewById(R.id.field2);
        area = foodED.getText().toString();

        DatabaseHandler db=new DatabaseHandler(this);

        if(db.isEmpty()) {
            db.addData(new ItemInfo("Burger BBQ", "250", "Chillox", "Dhanmondi"));
            db.addData(new ItemInfo("Burger CHEESE", "150", "Takeout", "Dhanmondi"));
            db.addData(new ItemInfo("Burger CHICKEN", "150", "Madchef", "Gulshan"));
            db.addData(new ItemInfo("Pasta BEEF", "250", "Alfresco", "Gulshan"));
            db.addData(new ItemInfo("Pasta BBQ", "150", "Tune and Bite", "Dhanmondi"));
            db.addData(new ItemInfo("Pasta CHICKEN", "500", "Appeliano", "Dhanmondi"));
            db.addData(new ItemInfo("Pizza SPECIAL", "350", "Pizza Hut", "Malibag"));
            db.addData(new ItemInfo("Pizza CHICKEN", "170", "Pizza King", "Baily Road"));
            db.addData(new ItemInfo("Pizza BEEF", "150", "KFC", "Dhanmondi"));
            db.addData(new ItemInfo("Drinks Coffee", "100", "Gloria Jeans", "Dhanmondi"));
            db.addData(new ItemInfo("Drinks Oreo Shake", "150", "Takeout", "Dhanmondi"));


        }

        db.close();
    }

    public void search_button(View v) {
        Intent i = new Intent(MainActivity.this, second_activity.class);
        i.putExtra("FOOD",foodED.getText().toString());
        i.putExtra("AREA",areaED.getText().toString());
        startActivity(i);

    }

}
