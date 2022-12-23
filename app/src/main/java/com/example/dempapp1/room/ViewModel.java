package com.example.dempapp1.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private UserRepository repository;
    private LiveData<List<UserModel>> allUser;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUser = repository.getAllUsers();
    }

    public void insert(UserModel userModel){
        repository.insert(userModel);
    }

    public void update(UserModel userModel){
        repository.update(userModel);
    }

    public LiveData<List<UserModel>> getAllUser(){
        return allUser;
    }
}
