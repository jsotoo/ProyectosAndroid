package com.example.jonathan.proyectofinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jonathan.proyectofinal.RegistroEstudiante.RegistroEstudiante;

public class MainActivity extends AppCompatActivity {

    Button button,button2;
    EditText user, pass;
    ConexionBD helper = new ConexionBD(this);
    SQLiteDatabase db;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btnIngresar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = (EditText) findViewById(R.id.txtUser);
                String usu = user.getText().toString();
                pass = (EditText) findViewById(R.id.txtPassword);
                String contr = pass.getText().toString();

                String passF = helper.buscarPass(usu);
                if(contr.equals(passF)){
                    Intent i = new Intent(MainActivity.this, MenuPrincipal.class);
                    startActivity(i);
                    user.setText("");
                    pass.setText("");

                }
                else{
                    Toast temp = Toast.makeText(getApplicationContext(),"Usuario o contrasena incorrectos", Toast.LENGTH_LONG);
                    temp.show();
                    user.setText("");
                    pass.setText("");
                }




        }});
        button2 = (Button) findViewById(R.id.btnRegistrar);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(MainActivity.this, RegistroEstudiante.class);
                startActivity(registro);

            }
        });
    }
}
