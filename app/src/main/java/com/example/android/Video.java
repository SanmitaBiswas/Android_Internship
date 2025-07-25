package com.example.android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Video extends AppCompatActivity {
    Button b1,b2;
    VideoView v1;
    MediaController mc;

    private boolean p=false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video);
        b1= (Button) findViewById(R.id.button14);

        b2=(Button) findViewById(R.id.button54);
        v1=(VideoView)findViewById(R.id.videoView2);
        mc=new MediaController(this);

        String path="android.resource://"+getPackageName()+"/"+R.raw.very_berry;
        Uri uri=Uri.parse(path);
        v1.setVideoURI(uri);
        v1.setMediaController(mc);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Video.this,MainActivity2.class);
                startActivity(i1);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p==false){
                    v1.start();
                    p=true;
                }else{
                    v1.pause();
                    p=false;
                }
            }
        });
    }
}