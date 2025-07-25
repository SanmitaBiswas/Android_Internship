package com.example.android;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RegOff extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reg_off);
        e1=(EditText) findViewById(R.id.editTextText3);
        e2=(EditText) findViewById(R.id.editTextText4);
        e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b1=(Button) findViewById(R.id.button4);
        b2=(Button) findViewById(R.id.button5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.isEmpty() || s2.isEmpty()){
                    Toast.makeText(RegOff.this, "Fill all entries", Toast.LENGTH_SHORT).show();
                }else{
                    SQLiteDatabase data=openOrCreateDatabase("user",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists login(email varchar, password varchar)");
                    String s3="select * from login where email = '"+s1+"'";
                    Cursor cursor=data.rawQuery(s3,null);
                    if(cursor.getCount()>0){
                        Toast.makeText(RegOff.this, "User already exists", Toast.LENGTH_SHORT).show();
                    }else{
                        data.execSQL("insert into login values ('"+s1+"','"+s2+"')");
                        Toast.makeText(RegOff.this, "User added", Toast.LENGTH_SHORT).show();
                        Intent i1=new Intent(RegOff.this, MainActivity.class);
                        startActivity(i1);
                        finish();
                    }
                    cursor.close();


                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(RegOff.this, MainActivity.class);
                startActivity(i1);
                finish();
            }
        });

    }
}