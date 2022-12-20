package com.example.dempapp1;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextInputEditText employeeName,employeeId;
    MaterialButton btnInsertNew,btnUpdate,btnDeleteExisting,btnView;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        employeeName = findViewById(R.id.etUserName);
        employeeId = findViewById(R.id.etEmployeeId);

        btnInsertNew = findViewById(R.id.btnInsertNew);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDeleteExisting = findViewById(R.id.btnDeleteExisting);
        btnView = findViewById(R.id.btnView);
        DB = new DBHelper(this);

        btnInsertNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employeeNameTXT = Objects.requireNonNull(employeeName.getText()).toString();
                String employeeIdTXT = Objects.requireNonNull(employeeId.getText()).toString();

                Boolean checkInsertData = DB.insertEmployeeData(employeeNameTXT,employeeIdTXT);
                if (checkInsertData){
                    Toast.makeText(MainActivity.this, "New Employee Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "New Employee Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employeeNameTXT = Objects.requireNonNull(employeeName.getText()).toString();
                String employeeIdTXT = Objects.requireNonNull(employeeId.getText()).toString();

                Boolean checkUpdateData = DB.updateEmployeeData(employeeNameTXT,employeeIdTXT);
                if (checkUpdateData){
                    Toast.makeText(MainActivity.this, "Employee Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Employee Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDeleteExisting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employeeNameTXT = Objects.requireNonNull(Objects.requireNonNull(employeeName.getText()).toString());

                Boolean checkDeleteData = DB.deleteEmployeeData(employeeNameTXT);
                if (checkDeleteData){
                    Toast.makeText(MainActivity.this, "Employee Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Employee Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getData();
                if (res.getCount() == 0){
                    Toast.makeText(MainActivity.this, "No Employees Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuilder buffer = new StringBuilder();
                while (res.moveToNext()){
                    buffer.append("Employee Name :").append(res.getString(0)).append("\n");
                    buffer.append("Employee Id :").append(res.getString(1)).append("\n");
                }
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Employee Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }


}