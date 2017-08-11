package com.example.administrador.aplicacion1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imagen;
    Button buttonA,buttonB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imagen = (ImageView) findViewById(R.id.imageView);
        buttonA = (Button) findViewById(R.id.button);
        buttonB = (Button) findViewById(R.id.button2);
        //this contexto se ubica en la ventana de la actividad
        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                imagen.setImageResource(R.drawable.ios);
                break;
            case R.id.button2:
                imagen.setImageResource(R.drawable.android);



        }
    }
}
