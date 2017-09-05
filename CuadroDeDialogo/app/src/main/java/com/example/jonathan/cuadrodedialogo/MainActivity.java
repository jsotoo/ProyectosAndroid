package com.example.jonathan.cuadrodedialogo;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    Button button;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setMessage("Mensaje").setCancelable(false).setPositiveButton("SI", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplication(),"Selecciono SI", Toast.LENGTH_LONG).show();
            }
        })
          .setNegativeButton("NO", new DialogInterface.OnClickListener(){


              @Override
              public void onClick(DialogInterface dialog, int which) {
                  Toast.makeText(getApplication(),"Selecciono NO", Toast.LENGTH_LONG).show();
              }
          });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
