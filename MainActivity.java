package com.example.kavyasmusicapp;

import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.Toast;
import com.example.kavyasmusicapp.R;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private double startTime = 0;
    private double finalTime = 0;
    private double sTime = 0;
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    MediaPlayer music;
    private TextView songName,txt1,txt2;
    private SeekBar songPrgs;
    public static int oneTimeOnly = 0;
    private Handler myHandler = new Handler();

    @Override
    protected void onCreate(
            Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music = MediaPlayer.create(
                this, R.raw.sound);
        songName = (TextView)findViewById(R.id.songinfo);
        songName.setText("love you zindagi");
        songPrgs = (SeekBar)findViewById(R.id.sBar);
        songPrgs.setClickable(false);
        txt1 = (TextView)findViewById(R.id.txtStartTime);
        txt2 = (TextView)findViewById(R.id.txtSongTime);
        if (oneTimeOnly == 0) {
            songPrgs.setMax((int) finalTime);
            oneTimeOnly = 1;
        }

        startTime = music.getCurrentPosition();
        finalTime = music.getDuration();
        txt2.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                finalTime)))
        );

        txt1.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                startTime)))
        );

        songPrgs.setProgress((int)startTime);
        myHandler.postDelayed(UpdateSongTime,100);
    }
    
    public void musicplay(View v) {
        Toast.makeText(getApplicationContext(), "Playing music", Toast.LENGTH_SHORT).show();
        music.start();
    }

    public void musicpause(View v) {
        Toast.makeText(getApplicationContext(), "Pausing music", Toast.LENGTH_SHORT).show();
        music.pause();

    }

    public void musicstop(View v) {
        Toast.makeText(getApplicationContext(), "Stopped playing music", Toast.LENGTH_SHORT).show();
        music.stop();
        music = MediaPlayer.create(this, R.raw.sound);
    }

    public void musicrevind(View v) {
        int temp = (int)startTime;
        startTime = music.getCurrentPosition();

        if((temp-backwardTime)>0){
            startTime = startTime - backwardTime;
            music.seekTo((int) startTime);
            Toast.makeText(getApplicationContext(),"You have Jumped backward 5 seconds",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
        }

    }

    public void musicff(View v) {
        int temp = (int) startTime;
        startTime = music.getCurrentPosition();
        finalTime = music.getDuration();

        if ((temp + forwardTime) <= finalTime) {
            startTime = startTime + forwardTime;
            music.seekTo((int) startTime);
            Toast.makeText(getApplicationContext(), "You have Jumped forward 5 seconds", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Cannot jump forward 5 seconds", Toast.LENGTH_SHORT).show();
        }
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            sTime = music.getCurrentPosition();
            txt1.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) sTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) sTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) sTime)))
            );
            songPrgs.setProgress((int)sTime);
            myHandler.postDelayed(this, 100);
        }
    };

}
