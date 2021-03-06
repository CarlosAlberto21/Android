package com.example.reproducciondeaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.view.View;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play;
    SoundPool sp;
    int sonido_de_Reproduccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button)findViewById(R.id.btn_s);

        sp = new SoundPool( 1, AudioManager.STREAM_MUSIC, 1);

        sonido_de_Reproduccion  = sp.load(this, R.raw.sound_short, 1);

    }

    public void AudioSoundPoul(View v){
        sp.play(sonido_de_Reproduccion, 1, 1, 1,0, 0 );
    }

    public void AudioMediaPlayer(View v){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.sound_long);
        mp.start();

    }
}