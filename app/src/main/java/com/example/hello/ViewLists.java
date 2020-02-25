package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewLists extends AppCompatActivity {
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_lists);
        list=findViewById(R.id.views);
    final ArrayList<String>arrayList = new ArrayList<>();
    arrayList.add("Bread");
        arrayList.add("Bread");
        arrayList.add("Shoes");
        arrayList.add("Clothes");
        arrayList.add("Sugar");
        arrayList.add("Rice");
        arrayList.add("Posho");
        arrayList.add("Bread");
        arrayList.add("Shoes");
        arrayList.add("Clothes");
        arrayList.add("Sugar");
        arrayList.add("Rice");
        arrayList.add("Posho");
        arrayList.add("Bread");
        arrayList.add("Shoes");
        arrayList.add("Clothes");
        arrayList.add("Sugar");
        arrayList.add("Rice");
        arrayList.add("Posho");
        arrayList.add("Bread");
        arrayList.add("Shoes");
        arrayList.add("Clothes");
        arrayList.add("Sugar");
        arrayList.add("Rice");
        arrayList.add("Posho");
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
