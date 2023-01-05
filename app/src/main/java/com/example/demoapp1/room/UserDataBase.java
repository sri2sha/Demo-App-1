package com.example.demoapp1.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {UserModel.class}, version = 0)
public abstract class UserDataBase extends RoomDatabase {

    private static UserDataBase instance;
    public Dao dao;

    public static synchronized UserDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),UserDataBase.class,"user_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static final RoomDatabase.Callback roomCallBack   = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        PopulateDbAsyncTask(UserDataBase instance){
            Dao dao = instance.dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

}

