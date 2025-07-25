package com.example.android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Music extends AppCompatActivity {
    Button b1;
    Button b2,b3,b4,b5,b6,b7,b8,b9;
    MediaPlayer m1,m2,m3,m4;
    static boolean p1=false, p2=false,p3=false,p4=false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_music);
        b1= (Button) findViewById(R.id.button13);

        b2=(Button)findViewById(R.id.button34);
        b3=(Button)findViewById(R.id.button35);
        b4=(Button)findViewById(R.id.button36);
        b5=(Button)findViewById(R.id.button37);

        b6=(Button)findViewById(R.id.button41);
        b7=(Button)findViewById(R.id.button39);
        b8=(Button)findViewById(R.id.button40);
        b9=(Button)findViewById(R.id.button38);

        m1=MediaPlayer.create(this,R.raw.song1);
        m2=MediaPlayer.create(this,R.raw.song2);
        m3=MediaPlayer.create(this,R.raw.song3);
        m4=MediaPlayer.create(this,R.raw.song4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Music.this,MainActivity2.class);
                startActivity(i1);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p1==false){
                    if(p2==true) {
                        m2.pause();
                        p2 = false;
                    }
                    else if(p3==true) {
                        m3.pause();
                        p3 = false;
                    }
                    else if(p4==true) {
                        m4.pause();
                        p4 = false;
                    }
                    m1.start();
                    p1=true;
                }else{
                    m1.pause();
                    p1=false;
                }

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p2==false){
                    if(p1==true) {
                        m1.pause();
                        p1 = false;
                    }else if(p3==true) {
                        m3.pause();
                        p3 = false;
                    }else if(p4==true) {
                        m4.pause();
                        p4 = false;
                    }
                    m2.start();
                    p2=true;
                }else{
                    m2.pause();
                    p2=false;
                }

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p3==false){
                    if(p1==true) {
                        m2.pause();
                        p2 = false;
                    }else if(p1==true) {
                        m1.pause();
                        p1 = false;
                    }else if(p4==true) {
                        m4.pause();
                        p4 = false;
                    }
                    m3.start();
                    p3=true;
                }else{
                    m3.pause();
                    p3=false;
                }

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p4==false){
                    if(p2==true) {
                        m2.pause();
                        p2 = false;
                    }else if(p3==true) {
                        m3.pause();
                        p3 = false;
                    }else if(p1==true) {
                        m1.pause();
                        p1 = false;
                    }
                    m4.start();
                    p4=true;
                }else{
                    m4.pause();
                    p4=false;
                }

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m1.stop();
                p1=false;
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m2.stop();
                p2=false;
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m3.stop();
                p3=false;
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m4.stop();
                p4=false;
            }
        });
    }
}