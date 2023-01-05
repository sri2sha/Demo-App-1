package com.example.demoapp1.intent.explicitIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.demoapp1.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class IntentActivityFirst extends AppCompatActivity {


    EditText et1,et2;
    MaterialButton btnCallSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_first);
        Objects.requireNonNull(getSupportActionBar()).hide();

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btnCallSecondActivity = findViewById(R.id.btnA1);

        btnCallSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),IntentActivitySecond.class);
                intent.putExtra("EditText1",et1.getText().toString());
                intent.putExtra("EditText2",et2.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}