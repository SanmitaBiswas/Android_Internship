package com.example.android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Result extends AppCompatActivity {
    Button b1,b2;
    TextView t1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        b1= (Button) findViewById(R.id.button53);
        b2=(Button)findViewById(R.id.button52);
        t1=(TextView)findViewById(R.id.textView20);
        Quiz.score= Ques1.a1+Ques2.a2+Ques3.a3+Ques4.a4;
        t1.setText(String.valueOf(Quiz.score));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Result.this,MainActivity2.class);
                startActivity(i1);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(Result.this, Quiz.class);
                startActivity(i2);
                finish();
            }
        });
    }
}