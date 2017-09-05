package com.example.jonathan.cuadrodedialogo;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
    }
    protected Dialog onCreateDialog(int id){
        Dialog dialog = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder = builder.setIcon(R.drawable.encendido);
        builder = builder.setTitle("Mi cuadro de dialogo");
        dialog = builder.create();
        return dialog;
    }

    @Override
    public void onClick(View v) {
        onCreateDialog(0).show();
    }
}
