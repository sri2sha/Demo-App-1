package com.example.dempapp1.aidlServer;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.dempapp1.IAidlColorInterface;

import java.util.Random;

public class AIDLColorService extends Service {
    public AIDLColorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return (IBinder) binder;
    }

    private final IAidlColorInterface binder = new IAidlColorInterface.Stub() {
        @Override
        public int getColor() throws RemoteException {
            Random rnd = new Random();
            int color = Color.argb(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
            Log.d("TAG", "getColor: " + color);
            return color;
        }
    };
}