package com.example.android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculator extends AppCompatActivity {
    Button b1;
    EditText e1;
    Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num0,add,sub,mul,div,eq,dot,cl;
    Boolean isAdd, isSub,isMul,isDiv;
    TextView t1;
    float r1,r2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        b1= (Button) findViewById(R.id.button12);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Calculator.this,MainActivity2.class);
                startActivity(i1);
                finish();
            }
        });

        e1=(EditText)findViewById(R.id.editTextText8);
        t1=(TextView)findViewById(R.id.textView4);
        num1=(Button) findViewById(R.id.button17);
        num2=(Button) findViewById(R.id.button18);
        num3=(Button) findViewById(R.id.button19);
        num4=(Button) findViewById(R.id.button21);
        num5=(Button) findViewById(R.id.button22);
        num6=(Button) findViewById(R.id.button23);
        num7=(Button) findViewById(R.id.button25);
        num8=(Button) findViewById(R.id.button26);
        num9=(Button) findViewById(R.id.button27);
        num0=(Button) findViewById(R.id.button30);

        add=(Button) findViewById(R.id.button20);
        sub=(Button) findViewById(R.id.button24);
        mul=(Button) findViewById(R.id.button28);
        div=(Button) findViewById(R.id.button31);
        eq=(Button) findViewById(R.id.button29);

        dot=(Button) findViewById(R.id.button32);
        cl=(Button) findViewById(R.id.button33);

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + "1");
            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + "2");
            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + "3");
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + "4");
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + "5");
            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + "6");
            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + "7");
            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + "8");
            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + "9");
            }
        });

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText().toString() + "0");
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().length()>0){
                    r1=Float.parseFloat(e1.getText().toString());
                    isAdd=true;

                    e1.setText("");
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().length()>0){
                    r1=Float.parseFloat(e1.getText().toString());
                    isSub=true;

                    e1.setText("");
                }

            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().length()>0){
                    r1=Float.parseFloat(e1.getText().toString());
                    isMul=true;

                    e1.setText("");
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().length()>0){
                    r1=Float.parseFloat(e1.getText().toString());
                    isDiv=true;
                }
            }
        });

        eq.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(e1.getText().length()>0){
                    r2=Float.parseFloat(e1.getText().toString());
                    if(isAdd){
                        t1.setText(String.valueOf(r1+r2));
                    }else if(isSub){
                        t1.setText(String.valueOf(r1-r2));
                    }else if(isMul){
                        t1.setText(String.valueOf(r1+r2));
                    }else if(isDiv){
                        if(r2!=0){
                            t1.setText(String.valueOf(r1/r2));
                        }else{
                            t1.setText("Error");
                        }
                    }
                }
                isAdd=false;
                isSub=false;
                isMul=false;
                isDiv=false;
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!e1.getText().toString().contains(".")){
                    e1.setText(e1.getText().toString()+".");
                }
            }
        });

        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                t1.setText("0");
                isAdd=false;
                isSub=false;
                isMul=false;
                isDiv=false;
            }
        });
    }
}