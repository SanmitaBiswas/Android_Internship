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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2,b3;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        e1=(EditText) findViewById(R.id.editTextText);
        e2=(EditText) findViewById(R.id.editTextText2);
        e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        mAuth = FirebaseAuth.getInstance();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.isEmpty() || s2.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill all entries", Toast.LENGTH_SHORT).show();
                }else {
                    SQLiteDatabase data = openOrCreateDatabase("user", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists login(email varchar, password varchar)");
                    String s3 = "select * from login where email = '" + s1 + "'";
                    Cursor cursor = data.rawQuery(s3, null);

                    if (cursor.getCount() > 0) {
                        Toast.makeText(MainActivity.this, "Logging in", Toast.LENGTH_SHORT).show();
                        Intent i3 = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(i3);
                        finish();
                    } else {
                        mAuth.signInWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Logging in", Toast.LENGTH_SHORT).show();
                                    Intent i3 = new Intent(MainActivity.this, MainActivity2.class);
                                    startActivity(i3);
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                    cursor.close();

                }
            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity.this, RegOff.class);
                startActivity(i1);
                finish();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(MainActivity.this, RegOn.class);
                startActivity(i2);
                finish();
            }
        });
    }
}