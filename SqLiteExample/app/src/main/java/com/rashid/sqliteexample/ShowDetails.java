package com.rashid.sqliteexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Reshka on 22.03.2016.
 */
public class ShowDetails extends Activity {

    EditText etNameDeatil, etSurnameDetail;
    Button btnDelete, btnUpdate;
    DbCon dbCon = new DbCon(this);
    String id,name,surname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdetails);
        etNameDeatil = (EditText) findViewById(R.id.etNameDetail);
        etSurnameDetail = (EditText) findViewById(R.id.etSurnameDetail);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        Intent intent = getIntent();
        name = intent.getStringExtra("sendName");
        surname = intent.getStringExtra("sendSurname");
        id = intent.getStringExtra("sendId");
        etNameDeatil.setText(name);
        etSurnameDetail.setText(surname);

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
                dbCon.update(Long.parseLong(id),etNameDeatil.getText().toString(),etSurnameDetail.getText().toString());
                returnHome();
            }
        });

    }

    public void returnHome(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
