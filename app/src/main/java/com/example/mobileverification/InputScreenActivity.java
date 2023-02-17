package com.example.mobileverification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;

import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class InputScreenActivity extends AppCompatActivity {

    TextView resendbtn,otp;

    private static final String PROPNAME_BACKGROUND =
            "com.example.android.customtransition:CustomTransition:background";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InputScreenLayout inputScreenLayout=new InputScreenLayout(this);
        setContentView(inputScreenLayout);

        EditText inputBox=inputScreenLayout.inputOtp;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);

        int height=displayMetrics.heightPixels;

        int width = displayMetrics.widthPixels;

        int bigCircleSize=(int)Math.round(width*0.2);
        int smallCircleSize=(int)Math.round(width*0.2);

        inputScreenLayout.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputBox.getText().toString().isEmpty()){
//                    inputScreenLayout.errorText.setVisibility(View.VISIBLE);
//                    TextView setRequired=inputScreenLayout.errorText;
//                    setRequired.setText("Required");
//                    inputScreenLayout.hline1.setBackgroundColor(ContextCompat.getColor(InputScreenActivity.this,R.color.invalidColor));
//                    inputScreenLayout.hline2.setBackgroundColor(ContextCompat.getColor(InputScreenActivity.this,R.color.invalidColor));


                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(InputScreenActivity.this, Pair.create(inputScreenLayout.smallCircle,"smallCircletranslate"),Pair.create(inputScreenLayout.bigCircle,"bigCircletranslate"));
                    Intent intent = new Intent(InputScreenActivity.this,EmailVerficationActivity.class);
                    startActivity(intent,activityOptionsCompat.toBundle());
                    overridePendingTransition(0, 0);


//                    startActivity(new Intent(InputScreenActivity.this,MainActivity.class));


                }
                else{

//                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(InputScreenActivity.this, Pair.create(inputScreenLayout.smallCircle,"smallCircletranslate"),Pair.create(inputScreenLayout.bigCircle,"bigCircletranslate"));
//                    Intent intent = new Intent(InputScreenActivity.this,EmailVerficationActivity.class);
//                    startActivity(intent,activityOptionsCompat.toBundle());

//                    BottomScreenLayout bottomScreenLayout=new BottomScreenLayout(InputScreenActivity.this);
//                    inputScreenLayout.addView(bottomScreenLayout);
//                    startActivity(new Intent(InputScreenActivity.this, EmailVerficationActivity.class));
                }

//               ImageView bigCircle= inputScreenLayout.bigCircle;
//               ImageView smallCircle=inputScreenLayout.smallCircle;
//
//               int bigCircleX= (int)Math.round(width*0.76);
//                int bigCircleY= (int)Math.round(height*0.15);
//
//                int smallCircleX= (int)Math.round(width*0.055);
//                int smallCircleY= (int)Math.round(height*0.35);
//
//
//                bigCircle.animate().y(-bigCircleY).setDuration(1000);
//                bigCircle.animate().x(bigCircleX).setDuration(1000);
////                bigCircle.animate().scaleXBy(-0.7f).setDuration(300);
////                bigCircle.animate().scaleYBy(-0.7f).setDuration(300);
//               increaseViewSize(bigCircle,750);
//
//                smallCircle.animate().y(smallCircleY).setDuration(1000);
//                smallCircle.animate().x(-smallCircleX).setDuration(1000);
//                smallCircle.animate().scaleXBy(0.1f).setDuration(1000);
//                smallCircle.animate().scaleYBy(0.1f).setDuration(1000);


            }
        });



        resendbtn=inputScreenLayout.resendButton;

        otp =inputScreenLayout.inputTitle;
        String numberText = getResources().getString(R.string.otp_send_to);
        SpannableString spannable = new SpannableString(numberText);
        StyleSpan spanBold = new StyleSpan(Typeface.BOLD);
        spannable.setSpan(spanBold,12,28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        otp.setText(spannable);


        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                resendbtn.setText("Didn't receive? Resend in " + millisUntilFinished / 1000+" secs");
            }

            public void onFinish() {
                resendbtn.setText(R.string.resend_otp);
                resendbtn.setTypeface(Typeface.DEFAULT_BOLD);
                resendbtn.setTextColor(ContextCompat.getColor(InputScreenActivity.this,R.color.nextbtnColor));
            }

        }.start();

    }

//    private void increaseViewSize(View view, int increaseValue){
//        ValueAnimator valueAnimator = ValueAnimator.ofInt(view.getMeasuredHeight(),
//                view.getMeasuredHeight()-increaseValue);
//        valueAnimator.setDuration(1000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(@NonNull ValueAnimator animation) {
//                int animatedValue = (Integer) (valueAnimator.getAnimatedValue());
//                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
//                layoutParams.height = animatedValue;
//                layoutParams.width=animatedValue;
//                view.setLayoutParams(layoutParams);
//            }
//        });
//        valueAnimator.start();
//    }


}