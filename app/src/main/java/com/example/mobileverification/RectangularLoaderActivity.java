package com.example.mobileverification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RectangularLoaderActivity extends AppCompatActivity {

    int pStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rectangular_loader_activity);

//        Resources res = getResources();
//        Drawable drawable = ContextCompat.getDrawable(this,R.drawable.rectangle);
//        final ProgressBar mProgress = (ProgressBar) findViewById(R.id.circularProgressbar);
//        mProgress.setProgress(0);   // Main Progress
//        mProgress.setSecondaryProgress(100); // Secondary Progress
//        mProgress.setMax(100); // Maximum Progress
//        mProgress.setProgressDrawable(drawable);
//      /*  ObjectAnimator animation = ObjectAnimator.ofInt(mProgress, "progress", 0, 100);
//        animation.setDuration(50000);
//        animation.setInterpolator(new DecelerateInterpolator());
//        animation.start();*/
//        TextView tv = (TextView) findViewById(R.id.tv);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                while (pStatus < 100) {
//                    pStatus += 1;
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            // TODO Auto-generated method stub
//                            mProgress.setProgress(pStatus);
//                            tv.setText(pStatus + "%");
//                        }
//                    });
//                    try {
//                        // Sleep for 200 milliseconds.
//                        // Just to display the progress slowly
//                        Thread.sleep(16); //thread will take approx 3 seconds to finish
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

//        Path sPath = new Path();
//        sPath.moveTo(100, 100);
//        sPath.lineTo(300, 100);
//        sPath.lineTo(300, 300);
//        sPath.lineTo(100,300);
//        sPath.lineTo(100,100);
//        sPath.close();
//
//        ObjectAnimator animator = ObjectAnimator.ofFloat(lineView, View.X, View.Y, sPath);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setDuration(2000);
//        animator.start();

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