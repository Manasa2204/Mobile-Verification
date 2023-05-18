package com.example.mobileverification;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;

public class BasketBallLoader extends ConstraintLayout {
    Context context;
    ImageView ball;
    public BasketBallLoader(@NonNull Context context) {
        super(context);
        this.context=context;

        setId(View.generateViewId());

        ImageView ring=new ImageView(context);
        ring.setId(View.generateViewId());
//        ring.setBackground(newRingShapeDrawable(R.color.black));
        ring.setImageResource(R.drawable.ring_shape);
        ring.setRotationX(75f);
        addView(ring);

        ConstraintLayout.LayoutParams ringLayoutParams=new Constraints.LayoutParams(100, 100);
        ringLayoutParams.topToTop=getId();
        ringLayoutParams.bottomToBottom=getId();
        ringLayoutParams.startToStart=getId();
        ringLayoutParams.endToEnd=getId();
        ring.setLayoutParams(ringLayoutParams);

        ball= new ImageView(context);
        ball.setId(View.generateViewId());
        ball.setImageResource(R.drawable.gradient_circle);
//        ball.setBackground(drawCircle(ContextCompat.getColor(this,R.color.black),Color.parseColor("#ffffff")));
        addView(ball);

        ConstraintLayout.LayoutParams ballLayoutParams= new Constraints.LayoutParams(30,30);
        ballLayoutParams.endToEnd=ring.getId();
        ballLayoutParams.startToStart=ring.getId();
        ballLayoutParams.topToTop=ring.getId();
        ballLayoutParams.bottomToBottom=ring.getId();
        ball.setLayoutParams(ballLayoutParams);

    }

    public void startAnimation() {
        ObjectAnimator translateY = ObjectAnimator.ofFloat(ball, "translationY", ball.getY()-50).setDuration(400);
        ObjectAnimator scaleY= ObjectAnimator.ofFloat(ball,"scaleY",0.7f, 1f).setDuration(500);
        scaleY.setRepeatCount(ObjectAnimator.INFINITE);
        scaleY.setRepeatMode(ObjectAnimator.REVERSE);
        translateY.setRepeatMode(ValueAnimator.REVERSE);
        translateY.setRepeatCount(ObjectAnimator.INFINITE);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(translateY,scaleY);
        animatorSet.start();
    }

}
