package com.example.mobileverification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MobileVerification extends AppCompatActivity {

    TextView resendbtn,otp;
    int bottomSectionHeight;
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
        inputScreenLayout.post(new Runnable() {
            @Override
            public void run() {
                ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), (v, insets) -> {
                    boolean isKeyboardVisible = insets.isVisible(WindowInsetsCompat.Type.ime());
                    int keyboardHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
                    if(isKeyboardVisible){
                        inputScreenLayout.bottomSection.animate().y(keyboardHeight-400).setDuration(200);
                    }
                    else{
                        int currentBottom = inputScreenLayout.bottomSection.getTop();
                        int h = height-(inputScreenLayout.bottomSection.getBottom()-currentBottom);
                        inputScreenLayout.bottomSection.animate().y(h).setDuration(200).start();
                    }
                    return insets;
                });
            }
        });






        inputScreenLayout.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputBox.getText().toString().isEmpty()){
                    inputScreenLayout.errorText.setVisibility(View.VISIBLE);
                    TextView setRequired=inputScreenLayout.errorText;
                    setRequired.setText("Required");

                }
                else{
//                    BottomScreenLayout bottomScreenLayout=new BottomScreenLayout(MobileVerification.this);
//                    inputScreenLayout.addView(bottomScreenLayout);
                    Intent intent=new Intent(MobileVerification.this,BottomScreenLoader.class);
                    startActivity(intent);
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
                resendbtn.setTextColor(ContextCompat.getColor(MobileVerification.this,R.color.nextbtnColor));
            }

        }.start();

    }
}