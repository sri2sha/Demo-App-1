package com.example.demoapp1.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.demoapp1.R;
import com.example.demoapp1.recyclerview.RecyclerViewActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class SQLActivity extends AppCompatActivity {

    TextInputEditText employeeName, employeeId;
    MaterialButton btnInsertNew, btnUpdate, btnDeleteExisting, btnView;
    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlactivity);
        Objects.requireNonNull(getSupportActionBar()).hide();

        employeeId = findViewById(R.id.etEmployeeId);
        employeeName = findViewById(R.id.etUserName);

        btnInsertNew = findViewById(R.id.btnInsertNew);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDeleteExisting = findViewById(R.id.btnDeleteExisting);
        btnView = findViewById(R.id.btnView);
        DB = new DBHelper(this);

        btnInsertNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employeeIdTXT = Objects.requireNonNull(employeeId.getText()).toString();
                String employeeNameTXT = Objects.requireNonNull(employeeName.getText()).toString();

                Boolean checkInsertData = DB.insertEmployeeData(employeeIdTXT, employeeNameTXT);
                if (checkInsertData) {
                    Toast.makeText(SQLActivity.this, "New Employee Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SQLActivity.this, "New Employee Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employeeNameTXT = Objects.requireNonNull(employeeName.getText()).toString();
                String employeeIdTXT = Objects.requireNonNull(Objects.requireNonNull(employeeId.getText()).toString());

                Boolean checkUpdateData = DB.updateEmployeeData(employeeIdTXT, employeeNameTXT);
                if (checkUpdateData) {
                    Toast.makeText(SQLActivity.this, "Employee Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SQLActivity.this, "Employee Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDeleteExisting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employeeIdTXT = Objects.requireNonNull(Objects.requireNonNull(employeeId.getText()).toString());

                Boolean checkDeleteData = DB.deleteEmployeeData(employeeIdTXT);
                if (checkDeleteData) {
                    Toast.makeText(SQLActivity.this, "Employee Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SQLActivity.this, "Employee Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getData();
                if (res.getCount() == 0) {
                    Toast.makeText(SQLActivity.this, "No Employees Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuilder buffer = new StringBuilder();
                while (res.moveToNext()) {
                    buffer.append("Employee Id :").append(res.getString(0)).append("\n");
                    buffer.append("Employee Name :").append(res.getString(1)).append("\n");
                }
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SQLActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Employee Entries");
                builder.setMessage(buffer.toString());
                builder.show();

                Intent intent = new Intent(getApplicationContext(), RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}