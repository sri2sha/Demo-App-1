package com.example.demoapp1.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "UserModel table")
public class UserModel {
    @PrimaryKey (autoGenerate = true)
    public Integer employeeId;

    public String userName;
}
