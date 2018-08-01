package com.jasrin.audioplayer;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnPlay,btnPause,btnStop;
    MediaPlayer player;
    //for checking sound is play or not
    boolean isPlaying=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay=findViewById(R.id.btn_play);
        btnPause=findViewById(R.id.btn_pause);
        btnStop=findViewById(R.id.btn_stop);

        player=MediaPlayer.create(MainActivity.this,R.raw.audio);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying==false)
                {
                    player.start();
                    isPlaying=true;//sound is now playing
                    btnPlay.setBackgroundColor(Color.BLUE);
                }
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying==true)
                {
                    player.pause();
                    isPlaying=false;//sound is now pausing

                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying==true)
                {
                    player.stop();
                    isPlaying=false;//sound is now stop
                }
                MainActivity.this.finish();
            }
        });
    }

    @Override
    protected void onPause() {
        player.pause();
        super.onPause();
    }

//    @Override
//    protected void onResume() {
//        player.start();
//        super.onResume();
    //}
}
