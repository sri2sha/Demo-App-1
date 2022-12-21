package com.example.dempapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dempapp1.recyclerview.EmployeeDetailAdapter;
import com.example.dempapp1.recyclerview.EmployeeModelData;

import java.util.Objects;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Objects.requireNonNull(getSupportActionBar()).hide();

        EmployeeModelData[] employeeModelData = new EmployeeModelData[]{
                new EmployeeModelData("Alpha","1"),
                new EmployeeModelData("Beta","2"),
                new EmployeeModelData("Gamma","3")
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvEmployees);
        EmployeeDetailAdapter employeeDetailAdapter = new EmployeeDetailAdapter(employeeModelData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(employeeDetailAdapter);
    }
}