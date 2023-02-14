package com.example.mobileverification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BottomScreenLoaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BottomScreenLayout bottomScreenLayout=new BottomScreenLayout(this);
        setContentView(bottomScreenLayout);

    }
}