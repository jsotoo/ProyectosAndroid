package com.example.jonathan.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.jonathan.proyectofinal.CursosInfo.Ballet;
import com.example.jonathan.proyectofinal.CursosInfo.Baloncesto;
import com.example.jonathan.proyectofinal.CursosInfo.Capoeira;
import com.example.jonathan.proyectofinal.CursosInfo.Futbol;
import com.example.jonathan.proyectofinal.CursosInfo.PingPong;
import com.example.jonathan.proyectofinal.CursosInfo.Tenis;
import com.example.jonathan.proyectofinal.RegistroCurso.RegistroCurso;

public class Cursos extends AppCompatActivity implements View.OnClickListener{

    ImageButton pingPong, tenis, capoeira, baloncesto, futbol, ballet;
    Button registro;
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
        tenis.setOnClickListener(this);
        baloncesto.setOnClickListener(this);
        ballet.setOnClickListener(this);
        futbol.setOnClickListener(this);
        capoeira.setOnClickListener(this);

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
            case R.id.imgBallet:
                Intent bal = new Intent(this, Ballet.class);
                startActivity(bal);
                break;
            case R.id.imgBaloncesto:
                Intent balon = new Intent(this, Baloncesto.class);
                startActivity(balon);
                break;
            case R.id.imgFutbol:
                Intent fut = new Intent(this, Futbol.class);
                startActivity(fut);
                break;
            case R.id.imgTenis:
                Intent ten = new Intent(this, Tenis.class);
                startActivity(ten);
                break;


        }
    }
}
