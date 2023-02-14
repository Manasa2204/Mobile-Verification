package com.example.mobileverification;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
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
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class DisplayImageActivity extends AppCompatActivity {

    ImageView capturedImage;
    OutputStream outputStream;

    ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            Intent data = result.getData();
            int resultCode=result.getResultCode();
            if(resultCode==RESULT_OK){
                Bitmap image=(Bitmap) data.getExtras().get("data");
                capturedImage.setImageBitmap(image);

                File directory= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File folder=new File(directory,"MobileVerification");
                if(!folder.exists()){
                     folder.mkdirs();
                }

                File file = new File(folder.getAbsolutePath(),"image.jpg");


                try {
                    if(file.exists()) {
                        outputStream=new FileOutputStream(file);
                    }
                    else {
                        outputStream = new FileOutputStream(file);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.d("local", "onActivityResult: ");
                }
                image.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
                try {
                    outputStream.flush();
                    outputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

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

    }

    private void askUserPermission() {

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},101);
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},103);
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},105);

        }
        else{
            openCamera();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                Toast.makeText(this, "camera permission is required", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void openCamera() {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activityResultLauncher.launch(intent);
    }

}