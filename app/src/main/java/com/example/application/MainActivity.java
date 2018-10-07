package com.example.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        ArrayList<String> items=new ArrayList<>();
        items.add("Numbers");
        items.add("Family");
        items.add("colors");
        items.add("Phrases");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,items);
        ListView listView=findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (position){
                   case 0:
                       Intent intent=new Intent(MainActivity.this,NumbersActivity.class);
                       startActivity(intent);
                       break;
                   case 1:
                       Intent intent1=new Intent(MainActivity.this,FamilyActivity.class);
                       startActivity(intent1);
                       break;
                   case 2:
                       Intent intent2=new Intent(MainActivity.this,ColorsActivity.class);
                       startActivity(intent2);
                       break;
                   case 3:
                       Intent intent3=new Intent(MainActivity.this,PhrasesActivity.class);
                       startActivity(intent3);
                       break;
                       default:
                           Toast.makeText(MainActivity.this, "Oooobs", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}