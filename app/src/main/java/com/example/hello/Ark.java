package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ark extends AppCompatActivity {
    Button music;
    Button stop;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ark);
        music = findViewById(R.id.btnPlay);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player = MediaPlayer.create(getApplicationContext(), R.raw.camila);
                player.start();
            }

        });
        stop = (Button) findViewById(R.id.btnstop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player != null && player.isPlaying()) {
                    player.stop();

                }
            }


        });
    }
}