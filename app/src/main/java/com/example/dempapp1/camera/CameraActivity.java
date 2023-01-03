package com.example.dempapp1.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.dempapp1.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class CameraActivity extends AppCompatActivity {


    public static final int picId = 1;
    MaterialButton btnCamera;
    AppCompatImageView mImage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        Objects.requireNonNull(getSupportActionBar()).hide();

        btnCamera = (MaterialButton) findViewById(R.id.btnOpenCamera);
        mImage = (AppCompatImageView) findViewById(R.id.ivCamera);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(intent, picId);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == picId){
            assert data != null;
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            mImage.setImageBitmap(photo);
        }
    }
}