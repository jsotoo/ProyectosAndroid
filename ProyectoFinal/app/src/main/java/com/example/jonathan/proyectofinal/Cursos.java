package com.example.jonathan.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Cursos extends AppCompatActivity implements View.OnClickListener{

    ImageButton pingPong, tenis, capoeira, baloncesto, futbol, ballet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);
        pingPong = (ImageButton) findViewById(R.id.imgPingPong);
        tenis = (ImageButton) findViewById(R.id.imgTenis);
        baloncesto = (ImageButton) findViewById(R.id.imgBaloncesto);
        ballet = (ImageButton) findViewById(R.id.imgBallet);
        futbol = (ImageButton) findViewById(R.id.imgFutbol);
        capoeira = (ImageButton) findViewById(R.id.imgCapoeira);
        pingPong.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imgPingPong:
                Intent pong = new Intent(this, PingPong.class );
                startActivity(pong);
                break;
            case R.id.imgCapoeira:
                Intent cap = new Intent(this, Capoeira.class );
                startActivity(cap);
                break;

        }
    }
}
