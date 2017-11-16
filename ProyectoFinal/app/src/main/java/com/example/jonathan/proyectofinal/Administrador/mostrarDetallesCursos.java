package com.example.jonathan.proyectofinal.Administrador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jonathan.proyectofinal.R;
import com.example.jonathan.proyectofinal.RegistroCurso.DbCon;

public class mostrarDetallesCursos extends AppCompatActivity {

    EditText etNombreDetail, etCodigoDetail,etCorreoDetail, etCursoDetail;
    Button btnDelete, btnUpdate;
    DbCon dbCon = new DbCon(this);
    String id,nombre,codigo, correo, curso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalles_cursos);
        etNombreDetail = (EditText) findViewById(R.id.etNombre);
        etCodigoDetail = (EditText) findViewById(R.id.etCodigo);
        etCorreoDetail = (EditText) findViewById(R.id.etCorreo);
        etCursoDetail = (EditText) findViewById(R.id.etCurso);
        btnDelete = (Button) findViewById(R.id.btEliminar);
        btnUpdate = (Button) findViewById(R.id.btEditar);

        Intent intent = getIntent();
        nombre = intent.getStringExtra("sendNombre");
        codigo = intent.getStringExtra("sendCodigo");
        correo= intent.getStringExtra("sendCorreo");
        curso = intent.getStringExtra("sendCurso");
        id = intent.getStringExtra("sendId");
        etNombreDetail.setText(nombre);
        etCodigoDetail.setText(codigo);
        etCorreoDetail.setText(correo);
        etCursoDetail.setText(curso);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbCon.delete(Long.parseLong(id));
                returnHome();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbCon.update(Long.parseLong(id),etNombreDetail.getText().toString(),etCodigoDetail.getText().toString(),etCorreoDetail.getText().toString(),etCursoDetail.getText().toString());
                returnHome();
            }
        });

    }

    public void returnHome(){
        Intent intent=new Intent(this,adminEventos.class);
        startActivity(intent);
    }

    }

