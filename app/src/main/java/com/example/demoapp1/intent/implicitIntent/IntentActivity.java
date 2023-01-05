package com.example.demoapp1.intent.implicitIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.demoapp1.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class IntentActivity extends AppCompatActivity {

    EditText content;
    MaterialButton btnVisit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        Objects.requireNonNull(getSupportActionBar()).hide();

        content = findViewById(R.id.etContent);
        btnVisit = findViewById(R.id.btnVisit);

        btnVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = content.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}