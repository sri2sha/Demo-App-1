package com.example.dempapp1.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dempapp1.R;
import com.example.dempapp1.recyclerview.EmployeeDetailAdapter;
import com.example.dempapp1.recyclerview.EmployeeModelData;
import com.example.dempapp1.sqlite.DBHelper;

import java.util.List;
import java.util.Objects;

public class RecyclerViewActivity extends AppCompatActivity {

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Objects.requireNonNull(getSupportActionBar()).hide();

        DB = new DBHelper(this);
        List<EmployeeModelData> res = DB.getAllEmployee();



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvEmployees);
        EmployeeDetailAdapter employeeDetailAdapter = new EmployeeDetailAdapter(res.toArray(new EmployeeModelData[0]));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(employeeDetailAdapter);
    }
}
