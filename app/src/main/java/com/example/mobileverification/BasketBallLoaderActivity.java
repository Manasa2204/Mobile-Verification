package com.example.mobileverification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.content.ContextCompat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BasketBallLoaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ConstraintLayout constraintLayout=new ConstraintLayout(this);
        constraintLayout.setId(View.generateViewId());

        ViewGroup.LayoutParams constraintLayoutParams=
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        constraintLayout.setLayoutParams(constraintLayoutParams);

        setContentView(constraintLayout);

        LinearLayout linearLayout= new LinearLayout(this);
        linearLayout.setBackgroundResource(R.drawable.nextbtn_bg);
        linearLayout.setId(View.generateViewId());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
        constraintLayout.addView(linearLayout);

        ConstraintLayout.LayoutParams linearLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150);
        linearLayoutParams.startToStart=constraintLayout.getId();
        linearLayoutParams.endToEnd=constraintLayout.getId();
        linearLayoutParams.topToTop=constraintLayout.getId();
        linearLayoutParams.bottomToBottom=constraintLayout.getId();
        linearLayoutParams.setMargins(20,linearLayoutParams.topMargin,20,linearLayoutParams.bottomMargin);
        linearLayout.setLayoutParams(linearLayoutParams);

        BasketBallLoader basketBallLoader= new BasketBallLoader(this);
        linearLayout.addView(basketBallLoader);

        LinearLayout.LayoutParams loaderLayoutParams= new LinearLayout.LayoutParams(100,150);
        loaderLayoutParams.setMargins(loaderLayoutParams.leftMargin,loaderLayoutParams.topMargin,20,-10);
        basketBallLoader.setLayoutParams(loaderLayoutParams);


        TextView nextButton = new TextView(this);
        nextButton.setId(View.generateViewId());
        nextButton.setTextSize(16);
        nextButton.setTypeface(Typeface.DEFAULT_BOLD);
        nextButton.setText("Saving");

        nextButton.setTextColor(ContextCompat.getColor(this,R.color.textColor));
        linearLayout.addView(nextButton);
        LinearLayout.LayoutParams nextButtonLayoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        nextButton.setLayoutParams(nextButtonLayoutParams);

    }

//    public static GradientDrawable drawCircle(int backgroundColor, int innerShadowColor) {
//        GradientDrawable shape = new GradientDrawable();
//        shape.setShape(GradientDrawable.OVAL);
//        shape.setGradientType(GradientDrawable.RADIAL_GRADIENT);
//        shape.setGradientRadius(300);
//        shape.setGradientCenter(3,3);
//        shape.setColors(new int[]{backgroundColor, innerShadowColor});
//        return shape;
//    }
//    private ShapeDrawable newRingShapeDrawable(int color) {
//        ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
//        drawable.getPaint().setColor(color);
//        drawable.getPaint().setStrokeWidth(10);
//        drawable.getPaint().setStyle(Paint.Style.STROKE);
//        return drawable;
//    }
}