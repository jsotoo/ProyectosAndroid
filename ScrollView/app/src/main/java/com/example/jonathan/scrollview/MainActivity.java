package com.example.jonathan.scrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button);
        tv1= (TextView)findViewById(R.id.textView);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String tabla= "";
        Toast.makeText(this,"Generando la tabla del 8",Toast.LENGTH_SHORT).show();
        for (int i = 1; i < 21; i++){
            tabla+="8 X "+i+" = "+8*i+"\n";
        }
            tv1.setText(tabla);
    }
}
