package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public static String play= "http:/www.praiselive.com";
    public static String surf= "http:/www.google.com";
Button link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
link=findViewById(R.id.mp3);
link.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,Ark.class);
        startActivity(intent);
    }
});
            }


    public void sendMessage (View view){
        EditText message= (EditText)findViewById(R.id.message);
        Toast.makeText(this,"Sending message"+message.getText().toString(),Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSSAGE",message.getText().toString());
        startActivity(intent);
        message.setText("");
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.rin,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        switch (id) {
            case R.id.item1:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(play));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            case R.id.item2:
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(surf));
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent1);
                }
            case R.id.item3:
                startActivity(new Intent(this,ViewLists.class));
                return true;

        }
                return super.onOptionsItemSelected(item);

        }
            }
