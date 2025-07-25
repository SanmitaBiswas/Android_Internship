package com.example.android;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Phone extends AppCompatActivity {
    Button b1,b2;
    EditText e1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_phone);
        b1= (Button) findViewById(R.id.button11);

        b2=(Button)findViewById(R.id.button42);
        e1=(EditText)findViewById(R.id.editTextText9);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Phone.this,MainActivity2.class);
                startActivity(i1);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                if(s1!=""){
                    if (ActivityCompat.checkSelfPermission(Phone.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        Intent i1 = new Intent(Intent.ACTION_CALL);
                        i1.setData(Uri.parse("tel:" + s1));
                        startActivity(i1);
                    } else {
                        ActivityCompat.requestPermissions(Phone.this,new String[]{Manifest.permission.CALL_PHONE}, 100);
                    }
                }else{
                    Toast.makeText(Phone.this, "Enter phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}