package com.example.demoapp1.intent.explicitIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.demoapp1.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class IntentActivitySecond extends AppCompatActivity {

    MaterialButton btnCallFirstActivity;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_second);
        Objects.requireNonNull(getSupportActionBar()).hide();

        btnCallFirstActivity = findViewById(R.id.btnA2);

        Bundle extras = getIntent().getExtras();
        String et1 = extras.getString("EditText1");
        String et2 = extras.getString("EditText2");
        Toast.makeText(this, "Edit Text 1 : " + et1 + "\n" +" Edit Text 2 : " + et2, Toast.LENGTH_SHORT).show();

        btnCallFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),IntentActivityFirst.class);
                startActivity(intent);
                finish();
            }
        });

    }
}