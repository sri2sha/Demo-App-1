package com.example.dempapp1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        configUserName();
    }

    public void configUserName(){
        MaterialButton btnSave = (MaterialButton) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> Toast.makeText(MainActivity.this, getDetails(), Toast.LENGTH_SHORT).show());
    }

    CharSequence getDetails(){
        TextInputEditText etUserName = (TextInputEditText) findViewById(R.id.etUserName);
        TextInputEditText etEmployeeId= (TextInputEditText) findViewById(R.id.etEmployeeId);

        Toast.makeText(this, etUserName.getText(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, etEmployeeId.getText(), Toast.LENGTH_SHORT).show();
        return null;
    }
}