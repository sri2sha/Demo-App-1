package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.demoapp1.R;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart Activity 2", Toast.LENGTH_SHORT).show();    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume Activity 2", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause Activity 2", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop Activity 2", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "OnReStart Activity 2", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy Activity 2", Toast.LENGTH_SHORT).show();
    }
}