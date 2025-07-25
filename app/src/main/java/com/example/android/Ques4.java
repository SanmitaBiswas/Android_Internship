package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ques4 extends AppCompatActivity {
    Button b1,b2;
    RadioButton r1,r2,r3,r4;
    static int a4=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ques4);
        b1=(Button) findViewById(R.id.button50);
        b2=(Button) findViewById(R.id.button51);
        r1=(RadioButton) findViewById(R.id.radioButton13);
        r2=(RadioButton) findViewById(R.id.radioButton14);
        r3=(RadioButton) findViewById(R.id.radioButton15);
        r4=(RadioButton) findViewById(R.id.radioButton16);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r4.isChecked()){
                    a4=1;
                }else{
                    a4=0;
                }
                Intent i1=new Intent(Ques4.this, Result.class);
                startActivity(i1);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i2=new Intent(Ques4.this, Ques3.class);
                startActivity(i2);
                finish();
            }
        });
    }
}