package com.example.dempapp1.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dempapp1.R;
import com.google.android.material.button.MaterialButton;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton btnStart,btnStop,btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnNext = findViewById(R.id.btnNext);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStart:
                startService(new Intent(this,MyService.class));
                break;
            case R.id.btnStop:
                stopService(new Intent(this,MyService.class));
                break;
            case R.id.btnNext:
                Intent intent = new Intent(this,NextPage.class);
                startActivity(intent);
                break;
        }
    }
}