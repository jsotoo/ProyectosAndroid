package com.example.jonathan.proyectofinal.RegistroEstudiante;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jonathan.proyectofinal.ConexionBD;
import com.example.jonathan.proyectofinal.R;


public class RegistroEstudiante extends AppCompatActivity {

    EditText nombres, correo, usuario, password, password2;
    Button Registrar;
    ConexionBD helper = new ConexionBD(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_estudiante);

        Registrar = (Button) findViewById(R.id.btnResgistro);
        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombres = (EditText) findViewById(R.id.txtNombre);
                correo = (EditText) findViewById(R.id.txtCorreo);
                usuario = (EditText) findViewById(R.id.txtUser);
                password = (EditText) findViewById(R.id.txtPass);
                password2 = (EditText) findViewById(R.id.txtpass2);

                String nombreStr = nombres.getText().toString();
                String correoStr = correo.getText().toString();
                String usuarioStr = usuario.getText().toString();
                String passStr = password.getText().toString();
                String pass2Str = password2.getText().toString();

                if(!passStr.equals(pass2Str)){
                    Toast pass = Toast.makeText(getApplicationContext(),"las contrasenas no coinciden",Toast.LENGTH_LONG);
                    pass.show();
                }
                else{
                    Estudiante est = new Estudiante();
                    est.setNombre(nombreStr);
                    est.setCorreo(correoStr);
                    est.setUsuario(usuarioStr);
                    est.setPassword(passStr);

                    helper.insertarEstudiante(est);
                    Toast.makeText(getApplicationContext(),"Registro Correcto", Toast.LENGTH_LONG).show();
                    nombreStr.equals("");
                    correoStr.equals("");
                    usuarioStr.equals("");
                    passStr.equals("");
                    pass2Str.equals("");

                }
            }
        });

    }











}
