package com.example.dempapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dempapp1.intent.explicitIntent.IntentActivityFirst;
import com.example.dempapp1.intent.implicitIntent.IntentActivity;
import com.example.dempapp1.service.ServiceActivity;
import com.google.android.material.button.MaterialButton;

public class HomeScreenActivity extends AppCompatActivity {

    MaterialButton btnMySQL, btnImplicit, btnExplicit,btnService;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btnMySQL = findViewById(R.id.btnMySQL);
        btnImplicit = findViewById(R.id.btnImplicit);
        btnExplicit = findViewById(R.id.btnExplicit);
        btnService = findViewById(R.id.btnService);

        btnMySQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IntentActivity.class);
                startActivity(intent);
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

    }
}