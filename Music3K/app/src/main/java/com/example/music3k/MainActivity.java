package com.example.music3k;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp [] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relacion entre la parte logica y diseno

        play_pause = (Button)findViewById(R.id.btn_play);
        btn_repetir = (Button)findViewById(R.id.btn_repetir);
        iv = (ImageView)findViewById(R.id.imageView2);

        vectormp[0] = MediaPlayer.create(this, R.raw.me);
        vectormp[1] = MediaPlayer.create(this, R.raw.flow);
        vectormp[2] = MediaPlayer.create(this, R.raw.victor);
    }

    //Metodo para el boton Playpause
    public void PlayPause(View v){
        if (vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }else{
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    public void Stop(View v){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();

            vectormp[0] = MediaPlayer.create(this, R.raw.me);
            vectormp[1] = MediaPlayer.create(this, R.raw.flow);
            vectormp[2] = MediaPlayer.create(this, R.raw.victor);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.reproducir);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }


    }


    //Metodo repetir una pista
    public void Repetir(View v) {
        if (repetir == 1) {
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        } else {
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }
        //Metodo para saltar canciones
        public void Siguiente(View v){
            if (posicion < vectormp.length - 1){
                if (vectormp[posicion].isPlaying()){
                    vectormp[posicion].stop();
                    posicion++;
                    vectormp[posicion].start();

                    if(posicion == 0){
                        iv.setImageResource(R.drawable.portada1);
                    }else if (posicion == 1){
                        iv.setImageResource(R.drawable.portada2);
                    }else if(posicion == 2){
                        iv.setImageResource(R.drawable.portada3);
                    }
                }else{
                    posicion++;

                    if(posicion == 0){
                        iv.setImageResource(R.drawable.portada1);
                    }else if (posicion == 1){
                        iv.setImageResource(R.drawable.portada2);
                    }else if(posicion == 2){
                        iv.setImageResource(R.drawable.portada3);
                    }
                }
            }else{
                Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
            }
        }

    public void Anterior(View v){
        if (posicion >= 1){
            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();

                vectormp[0] = MediaPlayer.create(this, R.raw.me);
                vectormp[1] = MediaPlayer.create(this, R.raw.flow);
                vectormp[2] = MediaPlayer.create(this, R.raw.victor);
                posicion--;

                vectormp[posicion].start();

            }else{
                posicion--;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                }else if (posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();

        }
    }
}