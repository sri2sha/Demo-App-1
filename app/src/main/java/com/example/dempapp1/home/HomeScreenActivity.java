package com.example.dempapp1.home;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dempapp1.R;
import com.example.dempapp1.camera.CameraActivity;
import com.example.dempapp1.intent.explicitIntent.IntentActivityFirst;
import com.example.dempapp1.intent.implicitIntent.IntentActivity;
import com.example.dempapp1.service.ServiceActivity;
import com.example.dempapp1.sqlite.SQLActivity;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class HomeScreenActivity extends AppCompatActivity {

    MaterialButton btnMySQL, btnImplicit, btnExplicit,btnService,btnCamera,btnTest;

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

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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