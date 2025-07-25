package com.example.android;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    Button b11;

    BluetoothAdapter ba;
    CameraManager cm;
    WifiManager wm;
    static boolean w2=false, cm2=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        b1=(ImageButton) findViewById(R.id.imageButton3);
        b2=(ImageButton) findViewById(R.id.imageButton4);
        b3=(ImageButton) findViewById(R.id.imageButton5);
        b4=(ImageButton) findViewById(R.id.imageButton6);
        b5=(ImageButton) findViewById(R.id.imageButton7);
        b6=(ImageButton) findViewById(R.id.imageButton8);
        b7=(ImageButton) findViewById(R.id.imageButton11);
        b8=(ImageButton) findViewById(R.id.imageButton10);
        b9=(ImageButton) findViewById(R.id.imageButton12);
        b10=(ImageButton) findViewById(R.id.imageButton9);
        b11=(Button) findViewById(R.id.button8);

        ActivityResultLauncher<Intent> enableBtLauncher;

        ba=BluetoothAdapter.getDefaultAdapter();
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        wm=(WifiManager)getSystemService(WIFI_SERVICE);


        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i1);
                finish();
            }
        });

        enableBtLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->
        {
            if (ba.isEnabled()) {
                Toast.makeText(this, "Bluetooth enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bluetooth NOT enabled", Toast.LENGTH_SHORT).show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
            @Override
            public void onClick(View view) {
                if (checkPermission()) {
                    if (!ba.isEnabled()) {
                        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        enableBtLauncher.launch(enableBtIntent);
                    } else {
                        Intent intent = new Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
                        startActivity(intent);
                    }
                } else {
                    requestPermission();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(w2==false) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        Intent panelIntent = new Intent(Settings.Panel.ACTION_WIFI);
                        startActivityForResult(panelIntent, 0);
                    } else {
                        wm.setWifiEnabled(true);
                    }
                    w2=true;
                }else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        Intent panelIntent = new Intent(Settings.Panel.ACTION_WIFI);
                        startActivityForResult(panelIntent, 0);
                    } else {
                        wm.setWifiEnabled(false);
                    }
                    w2=false;
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(MainActivity2.this, Browser.class);
                startActivity(i2);
                finish();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(MainActivity2.this, Camera.class);
                startActivity(i3);
                finish();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4=new Intent(MainActivity2.this, Phone.class);
                startActivity(i4);
                finish();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5=new Intent(MainActivity2.this, Calculator.class);
                startActivity(i5);
                finish();
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cm2==false) {
                    try {
                        Toast.makeText(MainActivity2.this, "Torch ON", Toast.LENGTH_SHORT).show();
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, true);
                        b7.setImageResource(R.drawable.torch_on);
                        cm2=true;
                    } catch (CameraAccessException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    try {
                        Toast.makeText(MainActivity2.this, "Torch OFF", Toast.LENGTH_SHORT).show();
                        String id2=cm.getCameraIdList()[0];
                        cm.setTorchMode(id2,false);
                        b7.setImageResource(R.drawable.torch_off);
                        cm2=false;
                    } catch (CameraAccessException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6=new Intent(MainActivity2.this, Music.class);
                startActivity(i6);
                finish();
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i7=new Intent(MainActivity2.this, Video.class);
                startActivity(i7);
                finish();
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i8=new Intent(MainActivity2.this, Quiz.class);
                startActivity(i8);
                finish();
            }
        });
    }

    private boolean checkPermission() {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
                ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 1);
        }
    }
}