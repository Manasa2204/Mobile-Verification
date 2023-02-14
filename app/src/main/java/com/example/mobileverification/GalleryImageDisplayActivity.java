package com.example.mobileverification;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GalleryImageDisplayActivity extends AppCompatActivity {

    ImageView capturedImage;
    ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            Intent data = result.getData();
            int resultCode=result.getResultCode();
            if(resultCode==RESULT_OK){

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();

                capturedImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            }

        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setId(View.generateViewId());

        ViewGroup.LayoutParams linearLayoutParams=
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        linearLayout.setLayoutParams(linearLayoutParams);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        setContentView(linearLayout);

        Button cameraButton=new Button(this);
        cameraButton.setText("camera");
        linearLayout.addView(cameraButton);

        LinearLayout.LayoutParams cameraButtonLayoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        cameraButtonLayoutParams.setMargins(cameraButtonLayoutParams.leftMargin,200,cameraButtonLayoutParams.rightMargin,cameraButtonLayoutParams.bottomMargin);
        cameraButton.setLayoutParams(cameraButtonLayoutParams);

        Button galleryButton=new Button(this);
        galleryButton.setText("Gallery");
        linearLayout.addView(galleryButton);

        LinearLayout.LayoutParams galleryButtonLayoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        galleryButtonLayoutParams.setMargins(galleryButtonLayoutParams.leftMargin,50,galleryButtonLayoutParams.rightMargin,galleryButtonLayoutParams.bottomMargin);
        galleryButton.setLayoutParams(galleryButtonLayoutParams);

        capturedImage= new ImageView(this);
//        capturedImage.setImageResource(R.drawable.graphic);
        linearLayout.addView(capturedImage);

        LinearLayout.LayoutParams capturedImageLayoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        capturedImageLayoutParams.setMargins(capturedImageLayoutParams.leftMargin,200,capturedImageLayoutParams.rightMargin,capturedImageLayoutParams.bottomMargin);
        capturedImage.setLayoutParams(capturedImageLayoutParams);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askUserPermission();
            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityResultLauncher.launch(i);;
            }
        });


    }
    private void askUserPermission() {

        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.CAMERA},101);
            ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},103);
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},105);

        }
        else{
            openCamera();
        }
    }

    private void openCamera() {
    }
}