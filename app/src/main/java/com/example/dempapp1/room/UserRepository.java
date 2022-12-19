package com.example.dempapp1.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private Dao dao;
    private LiveData<List<UserModel>> allUser;

    public UserRepository(Application application){
        UserDataBase dataBase = UserDataBase.getInstance(application);
        dao = dataBase.dao;
    }

    public void insert(UserModel userModel){
        new InsertUserAsyncTask(dao).execute(userModel);
    }

    public void update(UserModel userModel){
        new UpdateUserAsyncTask(dao).execute(userModel);
    }

    public LiveData<List<UserModel>> getAllUsers(){
        return allUser;
    }

    private static class InsertUserAsyncTask extends AsyncTask<UserModel,Void,Void> {
        private Dao dao;

        private InsertUserAsyncTask(Dao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            dao.insert(userModels[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<UserModel,Void,Void> {
        private Dao dao;

        private UpdateUserAsyncTask(Dao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            dao.update(userModels[0]);
            return null;
        }
    }

}
