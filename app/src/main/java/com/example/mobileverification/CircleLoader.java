package com.example.mobileverification;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.content.ContextCompat;

public class CircleLoader extends ConstraintLayout {

    ImageView circle1,circle2,circle3,circle4;
    int circle1Coordinate_x;
    int circle1Coordinate_y;
    int circle2Coordinate_x;
    int circle2Coordinate_y;
    int circle3Coordinate_x;
    int circle3Coordinate_y;
    int circle4Coordinate_x;
    int circle4Coordinate_y;
    Context context;

    int circle1size=(int)Math.round(400*0.46);
    int circle2size=(int)Math.round(400*0.45);
    int circle3size=(int)Math.round(400*0.40);
    int circle4size=(int)Math.round(400*0.35);

    public CircleLoader(@NonNull Context context) {
        super(context);
        this.context=context;

        setId(View.generateViewId());

        circle3=new ImageView(context);
        circle3.setId(View.generateViewId());
        circle3.setBackground(drawCircle(ContextCompat.getColor(context,R.color.smallCircle3),Color.parseColor("#ffffff")));

        circle2=new ImageView(context);
        circle2.setId(View.generateViewId());
        circle2.setBackground(drawCircle(ContextCompat.getColor(context,R.color.smallCircle2),Color.parseColor("#000000")));

        circle1=new ImageView(context);
        circle1.setId(View.generateViewId());
        circle1.setBackground(drawCircle(ContextCompat.getColor(context,R.color.smallCircle1),Color.parseColor("#ffffff")));

        circle4=new ImageView(context);
        circle4.setId(View.generateViewId());
        circle4.setBackground(drawCircle(ContextCompat.getColor(context,R.color.smallCircle4),Color.parseColor("#000000")));


    }

    public void startAnimation(){
        circle1Animation();
        circle2Animation();
        circle3Animation();
        circle4Animation();
    }

    private void circle1Animation(){
        int animationDuration = 500;
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(circle1, "scaleY", 1f, 1.2f).setDuration(animationDuration);
        scaleY.setRepeatCount(ObjectAnimator.INFINITE);
        scaleY.setRepeatMode(ObjectAnimator.REVERSE);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(circle1, "scaleX", 1f, 1.2f).setDuration(animationDuration);
        scaleX.setRepeatCount(ObjectAnimator.INFINITE);
        scaleX.setRepeatMode(ObjectAnimator.REVERSE);
        AnimatorSet scaleAnimatorSet = new AnimatorSet();
        scaleAnimatorSet.playTogether(scaleX, scaleY);

        ObjectAnimator translateX1 = ObjectAnimator.ofFloat(circle1, "translationX", circle1.getX()+100).setDuration(animationDuration);
        ObjectAnimator translateY1 = ObjectAnimator.ofFloat(circle1, "translationY", circle1.getY()+100).setDuration(animationDuration);
        ObjectAnimator translateX2 = ObjectAnimator.ofFloat(circle1, "translationX", circle1.getX()).setDuration(animationDuration);
        ObjectAnimator translateY2 = ObjectAnimator.ofFloat(circle1, "translationY", circle1.getY()).setDuration(animationDuration);
        AnimatorSet translateAnimatorSet = new AnimatorSet();
        translateAnimatorSet.playSequentially(translateX1,translateY1, translateX2, translateY2);
        translateAnimatorSet.addListener(new Animator.AnimatorListener(){

            @Override
            public void onAnimationStart(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {
                translateAnimatorSet.start();
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {
            }
        });

        scaleAnimatorSet.start();
        translateAnimatorSet.start();
    }

    private void circle2Animation(){
        int animationDuration = 500;
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(circle2, "scaleY", 1f, 0.8f).setDuration(animationDuration);
        scaleY.setRepeatCount(ObjectAnimator.INFINITE);
        scaleY.setRepeatMode(ObjectAnimator.REVERSE);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(circle2, "scaleX", 1f, 0.8f).setDuration(animationDuration);
        scaleX.setRepeatCount(ObjectAnimator.INFINITE);
        scaleX.setRepeatMode(ObjectAnimator.REVERSE);
        AnimatorSet scaleAnimatorSet = new AnimatorSet();
        scaleAnimatorSet.playTogether(scaleX, scaleY);

        ObjectAnimator translateX1 = ObjectAnimator.ofFloat(circle2, "translationY", circle2.getY()+100).setDuration(animationDuration);
        ObjectAnimator translateY1 = ObjectAnimator.ofFloat(circle2, "translationX", circle2.getX()-100).setDuration(animationDuration);
        ObjectAnimator translateX2 = ObjectAnimator.ofFloat(circle2, "translationY", circle2.getY()).setDuration(animationDuration);
        ObjectAnimator translateY2 = ObjectAnimator.ofFloat(circle2, "translationX", circle2.getX()).setDuration(animationDuration);
        AnimatorSet translateAnimatorSet = new AnimatorSet();
        translateAnimatorSet.playSequentially(translateX1,translateY1, translateX2, translateY2);
        translateAnimatorSet.addListener(new Animator.AnimatorListener(){

            @Override
            public void onAnimationStart(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {
                translateAnimatorSet.start();
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {
            }
        });

        scaleAnimatorSet.start();
        translateAnimatorSet.start();
    }

    private void circle3Animation(){
        int animationDuration = 500;
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(circle3, "scaleY", 1f, 0.8f).setDuration(animationDuration);
        scaleY.setRepeatCount(ObjectAnimator.INFINITE);
        scaleY.setRepeatMode(ObjectAnimator.REVERSE);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(circle3, "scaleX", 1f, 0.8f).setDuration(animationDuration);
        scaleX.setRepeatCount(ObjectAnimator.INFINITE);
        scaleX.setRepeatMode(ObjectAnimator.REVERSE);
        AnimatorSet scaleAnimatorSet = new AnimatorSet();
        scaleAnimatorSet.playTogether(scaleX, scaleY);

        ObjectAnimator translateX1 = ObjectAnimator.ofFloat(circle3, "translationX", circle3.getX()-100).setDuration(animationDuration);
        ObjectAnimator translateY1 = ObjectAnimator.ofFloat(circle3, "translationY", circle3.getY()-100).setDuration(animationDuration);
        ObjectAnimator translateX2 = ObjectAnimator.ofFloat(circle3, "translationX", circle3.getX()).setDuration(animationDuration);
        ObjectAnimator translateY2 = ObjectAnimator.ofFloat(circle3, "translationY", circle3.getY()).setDuration(animationDuration);
        AnimatorSet translateAnimatorSet = new AnimatorSet();
        translateAnimatorSet.playSequentially(translateX1,translateY1, translateX2, translateY2);
        translateAnimatorSet.addListener(new Animator.AnimatorListener(){

            @Override
            public void onAnimationStart(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {
                translateAnimatorSet.start();
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {
            }
        });

        scaleAnimatorSet.start();
        translateAnimatorSet.start();
    }
    
    private void circle4Animation(){
        int animationDuration =500;
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(circle4, "scaleY", 1f, 0.8f).setDuration(animationDuration);
        scaleY.setRepeatCount(ObjectAnimator.INFINITE);
        scaleY.setRepeatMode(ObjectAnimator.REVERSE);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(circle4, "scaleX", 1f, 0.8f).setDuration(animationDuration);
        scaleX.setRepeatCount(ObjectAnimator.INFINITE);
        scaleX.setRepeatMode(ObjectAnimator.REVERSE);
        AnimatorSet scaleAnimatorSet = new AnimatorSet();
        scaleAnimatorSet.playTogether(scaleX, scaleY);

        ObjectAnimator translateX1 = ObjectAnimator.ofFloat(circle4, "translationY", circle4.getY()-100).setDuration(animationDuration);
        ObjectAnimator translateY1 = ObjectAnimator.ofFloat(circle4, "translationX", circle4.getX()+100).setDuration(animationDuration);
        ObjectAnimator translateX2 = ObjectAnimator.ofFloat(circle4, "translationY", circle4.getY()).setDuration(animationDuration);
        ObjectAnimator translateY2 = ObjectAnimator.ofFloat(circle4, "translationX", circle4.getX()).setDuration(animationDuration);
        AnimatorSet translateAnimatorSet = new AnimatorSet();
        translateAnimatorSet.playSequentially(translateX1,translateY1, translateX2, translateY2);
        translateAnimatorSet.addListener(new Animator.AnimatorListener(){

            @Override
            public void onAnimationStart(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {
                translateAnimatorSet.start();
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {
            }
        });

        scaleAnimatorSet.start();
        translateAnimatorSet.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec,widthMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        setUpUI(w);
        ConstraintLayout.LayoutParams circle3LayoutParams= (LayoutParams) circle3.getLayoutParams();
        circle3LayoutParams.height =(int) Math.round(w*0.4);
        circle3LayoutParams.width = (int) Math.round(w*0.4);
        circle3.setLayoutParams(circle3LayoutParams);
        circle3.setX(circle3Coordinate_x);
        circle3.setY(circle3Coordinate_y);
        circle3.post(new Runnable() {
            @Override
            public void run() {
                circle3.requestLayout();
            }
        });

        ConstraintLayout.LayoutParams circle2LayoutParams=(LayoutParams) circle2.getLayoutParams();
        circle2LayoutParams.height =(int) Math.round(w*0.65);
        circle2LayoutParams.width = (int) Math.round(w*0.65);
        circle2.setLayoutParams(circle3LayoutParams);
        circle2.setX(circle2Coordinate_x);
        circle2.setY(circle2Coordinate_y);
        circle2.post(new Runnable() {
            @Override
            public void run() {
                circle2.requestLayout();
            }
        });

        ConstraintLayout.LayoutParams circle1LayoutParams=(LayoutParams) circle1.getLayoutParams();
        circle1LayoutParams.height =(int) Math.round(w*0.6);
        circle1LayoutParams.width = (int) Math.round(w*0.6);
        circle1.setLayoutParams(circle3LayoutParams);
        circle1.setX(circle1Coordinate_x);
        circle1.setY(circle1Coordinate_y);
        circle1.post(new Runnable() {
            @Override
            public void run() {
                circle1.requestLayout();
            }
        });

        ConstraintLayout.LayoutParams circle4LayoutParams=(LayoutParams) circle4.getLayoutParams();
        circle4LayoutParams.height =(int) Math.round(w*0.2);
        circle4LayoutParams.width = (int) Math.round(w*0.2);
        circle4.setLayoutParams(circle3LayoutParams);
        circle4.setX(circle4Coordinate_x);
        circle4.setY(circle4Coordinate_y);
        circle4.post(new Runnable() {
            @Override
            public void run() {
                circle4.requestLayout();
            }
        });

    }

    private void setUpUI(int w) {
         circle1Coordinate_x=(int)Math.round(w*0.35);
         circle1Coordinate_y=(int)Math.round(w*0.35);
         circle2Coordinate_x=(int)Math.round(w*0.65);
         circle2Coordinate_y=(int)Math.round(w*0.35);
         circle3Coordinate_x=(int)Math.round(w*0.65);
         circle3Coordinate_y=(int)Math.round(w*0.65);
         circle4Coordinate_x=(int)Math.round(w*0.35);
         circle4Coordinate_y=(int)Math.round(w*0.65);

//        ConstraintLayout.LayoutParams circle1LayoutParams=new Constraints.LayoutParams(circle1size,circle1size);
//        circle1LayoutParams.topToTop=getId();
//        circle1LayoutParams.leftToLeft=getId();
//        circle1LayoutParams.setMargins(circle1Coordinate_x,circle1Coordinate_y,circle1LayoutParams.rightMargin,circle1LayoutParams.bottomMargin);
//        circle1.setLayoutParams(circle1LayoutParams);
//
//
//        ConstraintLayout.LayoutParams circle4LayoutParams=new Constraints.LayoutParams(circle4size,circle4size);
//        circle4LayoutParams.topToTop=getId();
//        circle4LayoutParams.leftToLeft=getId();
//        circle4LayoutParams.setMargins(circle4Coordinate_x,circle4Coordinate_y,circle4LayoutParams.rightMargin,circle4LayoutParams.bottomMargin);
//        circle4.setLayoutParams(circle4LayoutParams);


    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        addView(circle3);
        addView(circle2);
        addView(circle1);
        addView(circle4);

    }

    public static GradientDrawable drawCircle(int backgroundColor, int innerShadowColor ) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.OVAL);
        shape.setGradientRadius(500);
        shape.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        shape.setColor(backgroundColor);
        shape.setGradientCenter(0,0);
        shape.setColors(new int[]{backgroundColor, innerShadowColor});
        return shape;
    }
}
