package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivilegedAction;

public class MainActivity extends AppCompatActivity {
public static String play= "http:/www.praiselive.com";
    public static String surf= "http:/www.google.com";
Button link;

private  BroadcastReceiver myReceiver = new  BroadcastReceiver(){

    public void  onReceive(Context c, Intent i){
        int level = i.getIntExtra("level",0);
        ProgressBar rin = (ProgressBar)findViewById(R.id.battLevel);
        rin.setProgress(level);

        TextView textView = (TextView)findViewById(R.id.batView);
        textView.setText("Battery level:" + Integer.toString(level) + "%");

    }

};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(myReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

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
    public void startAlarm(View view){
        EditText text =(EditText)findViewById(R.id.click);
        int in  = Integer.parseInt(text.getText().toString());
        Intent intent = new Intent(this,BroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager .set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(in*1000),pendingIntent);
        Toast.makeText(this,"Alarm set in "+ "seconds",Toast.LENGTH_LONG).show();
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.rin,menu);
        return true;
    }
    @SuppressLint("MissingPermission")
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

            case R.id.item5:
                startActivity(new Intent(this,Wifi.class));
                return true;


            case R.id.internal:
                startActivity(new Intent(this,Internal.class));


            case R.id.external:
                startActivity(new Intent(this,External.class));


            case R.id.item4:
                try{
                    int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
                        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){
                Toast.makeText(this,"This permission is required to call a pone number",Toast.LENGTH_LONG).show();
                        }
                    else{
                        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
                        }
                    }
                    Intent in = new Intent(Intent.ACTION_CALL,Uri.parse("Telephone:0777903860"));
                    startActivity(in);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                return true;
        }
                return super.onOptionsItemSelected(item);

        }
            }
