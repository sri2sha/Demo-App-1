package com.example.demoapp1.room;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

@androidx.room.Dao
public interface Dao {
    @Insert
    void insert(UserModel userModel);

    @Update
    void update(UserModel userModel);

    @Delete
    void delete(UserModel userModel);

}

