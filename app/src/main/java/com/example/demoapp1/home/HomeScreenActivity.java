package com.example.demoapp1.home;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.demoapp1.R;
import com.example.demoapp1.asyncTask.AsyncTaskActivity;
import com.example.demoapp1.bmi.BMIMainActivity;
import com.example.demoapp1.broadcastReceiver.BroadcastActivity;
import com.example.demoapp1.camera.CameraActivity;
import com.example.demoapp1.intent.explicitIntent.IntentActivityFirst;
import com.example.demoapp1.intent.implicitIntent.IntentActivity;
import com.example.demoapp1.service.ServiceActivity;
import com.example.demoapp1.sqlite.SQLActivity;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class HomeScreenActivity extends AppCompatActivity {

    MaterialButton btnMySQL, btnImplicit, btnExplicit,btnService,btnCamera,btnTest,btnAsyncTask,btnBMI,btnBroadcast;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Objects.requireNonNull(getSupportActionBar()).hide();


        btnMySQL = findViewById(R.id.btnMySQL);
        btnImplicit = findViewById(R.id.btnImplicit);
        btnExplicit = findViewById(R.id.btnExplicit);
        btnService = findViewById(R.id.btnService);
        btnCamera = findViewById(R.id.btnCamera);
        btnTest = findViewById(R.id.btnTest);
        btnAsyncTask = findViewById(R.id.btnMyAsynTask);
        btnBMI = findViewById(R.id.btnBMI);
        btnBroadcast = findViewById(R.id.btnBroadcast);

        btnMySQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SQLActivity.class);
                startActivity(intent);
            }
        });

        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IntentActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bottom_up,R.anim.nothing);
            }
        });

        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IntentActivityFirst.class);
                startActivity(intent);
            }
        });

        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ServiceActivity.class);
                startActivity(intent);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
                startActivity(intent);
            }
        });

        btnAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AsyncTaskActivity.class);
                startActivity(intent);
            }
        });

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BMIMainActivity.class);
                startActivity(intent);
            }
        });

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeScreenActivity.this, "For testing use only", Toast.LENGTH_SHORT).show();
            }
        });

        btnBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BroadcastActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }


}