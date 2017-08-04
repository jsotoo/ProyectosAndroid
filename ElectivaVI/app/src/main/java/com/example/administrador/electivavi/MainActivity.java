package com.example.administrador.electivavi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Variables que se van a manejar
    Button button;
    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.button);
        nombre = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                //Toast para mostrar mensajes
                Toast.makeText(getApplicationContext(),"Hola " + nombre.getText(),Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
