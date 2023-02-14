package com.example.mobileverification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Field;

public class InputScreenActivity extends AppCompatActivity {

    TextView resendbtn,otp;

    @SuppressLint("SoonBlockedPrivateApi")
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

//        inputScreenLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), (v, insets) -> {
//                    boolean isKeyboardVisible = insets.isVisible(WindowInsetsCompat.Type.ime());
//                    int keyboardHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
//                    if(isKeyboardVisible){
//                        inputScreenLayout.bottomSection.animate().y(keyboardHeight-400).setDuration(200);
//                    }
//                    else{
//                        int currentBottom = inputScreenLayout.bottomSection.getTop();
//                        int h = height-(inputScreenLayout.bottomSection.getBottom()-currentBottom);
//                        inputScreenLayout.bottomSection.animate().y(h).setDuration(200).start();
//                    }
//                    return insets;
//                });
//            }
//        });


        inputScreenLayout.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputBox.getText().toString().isEmpty()){
                    inputScreenLayout.errorText.setVisibility(View.VISIBLE);
                    TextView setRequired=inputScreenLayout.errorText;
                    setRequired.setText("Required");
                    inputScreenLayout.hline1.setBackgroundColor(ContextCompat.getColor(InputScreenActivity.this,R.color.invalidColor));
                    inputScreenLayout.hline2.setBackgroundColor(ContextCompat.getColor(InputScreenActivity.this,R.color.invalidColor));

                }
                else{
                    BottomScreenLayout bottomScreenLayout=new BottomScreenLayout(InputScreenActivity.this);
                    inputScreenLayout.addView(bottomScreenLayout);
//                    startActivity(new Intent(InputScreenActivity.this,BottomScreenLoaderActivity.class));
                }

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


}