package com.example.mobileverification;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

public class RectangularLoaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rectangular_loader_activity);

        LineView lineView=(LineView) findViewById(R.id.LineView1);

       lineView.startAnimation();

//        Path sPath = new Path();
//        sPath.moveTo(100, 100);
//        sPath.lineTo(300, 100);
//        sPath.lineTo(300, 300);
//        sPath.lineTo(100,300);
//        sPath.lineTo(100,100);
//        sPath.close();
//
////        Path path = new Path();
////        path.arcTo(0f, 0f, 1000f, 1000f, 270f, -180f, true);
//        ObjectAnimator animator = ObjectAnimator.ofFloat(lineView, View.X, View.Y, sPath);
//        animator.setDuration(2000);
//        animator.start();
    }
}