package com.devalfaro.agendacontactosdevio;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

public class Main2Activity extends AppCompatActivity {
    public static final int segundos=10;
    public static final int milisegundos=segundos*1000;
    private ProgressBar progreso;
    public static final int delay=2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        progreso = (ProgressBar) findViewById(R.id.progressBar2);
        empezaranimacion();
        progreso.setMax(maximo_progreso());

    }
    public void empezaranimacion()
    {
        new CountDownTimer(milisegundos,1000){
            @Override
            public void onTick(long l) {
            progreso.setProgress(establecer_progreso(l));
            }

            @Override
            public void onFinish() {
                Intent nuevoform = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(nuevoform);
                finish();
            }
        }.start();
    }

    public int establecer_progreso(long miliseconds){
        return (int)((milisegundos-miliseconds)/1000);
    }

    public int maximo_progreso(){
        return segundos-delay;
    }
}
