package com.example.android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Browser extends AppCompatActivity {
    Button b1, b2;
    EditText e1;
    WebView w1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browser);
        b1= (Button) findViewById(R.id.button9);
        b2= (Button) findViewById(R.id.button16);
        e1=(EditText)findViewById(R.id.editTextText7);
        w1=(WebView)findViewById(R.id.webView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Browser.this,MainActivity2.class);
                startActivity(i1);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                w1.loadUrl("https://"+s1);
                w1.getSettings().setJavaScriptEnabled(true);
                w1.setWebViewClient(new WebViewClient());
            }
        });

    }
}