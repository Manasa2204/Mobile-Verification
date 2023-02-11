package com.example.mobileverification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout constraintLayout=new ConstraintLayout(this);
        constraintLayout.setId(View.generateViewId());

        ViewGroup.LayoutParams constraintLayoutParams=
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        constraintLayout.setLayoutParams(constraintLayoutParams);

        setContentView(constraintLayout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        videoView=new VideoView(this);
        videoView.setId(View.generateViewId());

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.full_screen_loader);
        videoView.start();
        videoView.setOnCompletionListener(this);
        constraintLayout.addView(videoView);

        ConstraintLayout.LayoutParams videoViewLayoutParams=new Constraints.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        videoViewLayoutParams.dimensionRatio="1:1";
        videoViewLayoutParams.topToTop=constraintLayout.getId();
        videoViewLayoutParams.startToStart=constraintLayout.getId();
        videoViewLayoutParams.bottomToBottom=constraintLayout.getId();
        videoViewLayoutParams.endToEnd=constraintLayout.getId();
        videoView.setLayoutParams(videoViewLayoutParams);

        ImageView cancelButton= new ImageView(this);
        cancelButton.setId(View.generateViewId());
        cancelButton.setImageResource(R.drawable.cancel);
        cancelButton.setBackgroundResource(R.drawable.icon_bg);
        constraintLayout.addView(cancelButton);

        ConstraintLayout.LayoutParams cancelButtonLayoutParams= new Constraints.LayoutParams(80, 80);
        cancelButtonLayoutParams.endToEnd=constraintLayout.getId();
        cancelButtonLayoutParams.topToTop=constraintLayout.getId();
        cancelButtonLayoutParams.setMargins(cancelButtonLayoutParams.leftMargin,50,50,cancelButtonLayoutParams.bottomMargin);
        cancelButton.setLayoutParams(cancelButtonLayoutParams);

        ConstraintLayout endConstraint=new ConstraintLayout(this);
        endConstraint.setId(View.generateViewId());
        constraintLayout.addView(endConstraint);

        ConstraintLayout.LayoutParams endConstraintLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        endConstraintLayoutParams.endToEnd=constraintLayout.getId();
        endConstraintLayoutParams.startToStart=constraintLayout.getId();
        endConstraintLayoutParams.bottomToBottom=constraintLayout.getId();
        endConstraintLayoutParams.setMargins(endConstraintLayoutParams.leftMargin,endConstraintLayoutParams.topMargin,endConstraintLayoutParams.rightMargin,16);
        endConstraint.setLayoutParams(endConstraintLayoutParams);

        TextView verificationTxt=new TextView(this);
        verificationTxt.setId(View.generateViewId());
        verificationTxt.setText(R.string.verifying_your_otp);
        verificationTxt.setTypeface(Typeface.DEFAULT_BOLD);
        verificationTxt.setTextColor(ContextCompat.getColor(this,R.color.grey));
        verificationTxt.setTextSize(24);
        endConstraint.addView(verificationTxt);

        ConstraintLayout.LayoutParams verificationTxtLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        verificationTxtLayoutParams.endToEnd=endConstraint.getId();
        verificationTxtLayoutParams.startToStart=endConstraint.getId();
        verificationTxtLayoutParams.topToTop=endConstraint.getId();
        verificationTxt.setLayoutParams(verificationTxtLayoutParams);


        TextView subTxt=new TextView(this);
        subTxt.setId(View.generateViewId());
        subTxt.setText(R.string.take_a_moment);
        subTxt.setTextColor(ContextCompat.getColor(this,R.color.grey));
        subTxt.setTextSize(14);
        endConstraint.addView(subTxt);

        ConstraintLayout.LayoutParams subTxtLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        subTxtLayoutParams.endToEnd=endConstraint.getId();
        subTxtLayoutParams.startToStart=endConstraint.getId();
        subTxtLayoutParams.topToBottom=verificationTxt.getId();
        subTxtLayoutParams.setMargins(subTxtLayoutParams.leftMargin,20,subTxtLayoutParams.rightMargin,subTxtLayoutParams.bottomMargin);
        subTxt.setLayoutParams(subTxtLayoutParams);

        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setId(View.generateViewId());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setBackgroundResource(R.drawable.rectangle);
        endConstraint.addView(linearLayout);

        ConstraintLayout.LayoutParams LinearLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayoutParams.endToEnd=endConstraint.getId();
        LinearLayoutParams.startToStart=endConstraint.getId();
        LinearLayoutParams.topToBottom=subTxt.getId();
        LinearLayoutParams.bottomToBottom=endConstraint.getId();
        LinearLayoutParams.setMargins(LinearLayoutParams.leftMargin,90,LinearLayoutParams.rightMargin,42);
        linearLayout.setLayoutParams(LinearLayoutParams);


        TextView poweredTxt=new TextView(this);
        poweredTxt.setText(R.string.powered_by);
        linearLayout.addView(poweredTxt);

        LinearLayout.LayoutParams poweredByLayoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        poweredTxt.setLayoutParams(poweredByLayoutParams);

        View horizontalLine= new View(this);
        horizontalLine.setBackgroundColor(getResources().getColor(R.color.grey));
        linearLayout.addView(horizontalLine);

        LinearLayout.LayoutParams HorizontalLineLayoutParams=new LinearLayout.LayoutParams(4,40);
        HorizontalLineLayoutParams.setMargins(18,10,18,HorizontalLineLayoutParams.bottomMargin);
        horizontalLine.setLayoutParams(HorizontalLineLayoutParams);

        ImageView yesbancLogo=new ImageView(this);
        yesbancLogo.setImageResource(R.drawable.yesbank);
        linearLayout.addView(yesbancLogo);

        LinearLayout.LayoutParams yesBancLogoLayoutParams=new LinearLayout.LayoutParams(150,60);
        yesbancLogo.setLayoutParams(yesBancLogoLayoutParams);


    }


    @Override
    public void onCompletion(MediaPlayer mp)
    {
        videoView.start();
    }
}