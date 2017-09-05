package com.example.jonathan.tougglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    ToggleButton toogleButton;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toogleButton = (ToggleButton) findViewById(R.id.toggleButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        toogleButton.setOnCheckedChangeListener(this);

        };


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked){
            imageView.setImageResource(R.drawable.encendido);
        }
        else{
            imageView.setImageResource(R.drawable.apagado);
        }
    }
}
