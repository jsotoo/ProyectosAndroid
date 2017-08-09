package com.example.administrador.textviewandedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText login;
    EditText password;
    Button button;
    TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login =(EditText) findViewById(R.id.editText);
        password =(EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
        mensaje = (Button) findViewById(R.id.button);
    }

    @Override
    public void onClick(View view) {

    }
}
