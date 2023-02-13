package com.example.mobileverification;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.content.ContextCompat;

public class BottomScreenLayout extends ConstraintLayout {
    public BottomScreenLayout(@NonNull Context context) {
        super(context);

        setId(View.generateViewId());

        ViewGroup.LayoutParams layoutParams=
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        setLayoutParams(layoutParams);
        setBackgroundColor(ContextCompat.getColor(context,R.color.overlay));
        addChildViews(context);

    }

    private void addChildViews(Context context) {
        ConstraintLayout bottomSection=new ConstraintLayout(context);
        bottomSection.setId(View.generateViewId());
        bottomSection.setBackgroundResource(R.drawable.bottomloader_bg);
        addView(bottomSection);

        ConstraintLayout.LayoutParams bottomSectionLayoutParams=new Constraints.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bottomSectionLayoutParams.bottomToBottom=getId();
        bottomSectionLayoutParams.startToStart=getId();
        bottomSectionLayoutParams.endToEnd=getId();
        bottomSection.setLayoutParams(bottomSectionLayoutParams);

        ImageView cancelButton = new ImageView(context);
        cancelButton.setId(View.generateViewId());
        cancelButton.setImageResource(R.drawable.cancel);
        cancelButton.setBackgroundResource(R.drawable.icon_bg);
        bottomSection.addView(cancelButton);

        ConstraintLayout.LayoutParams cancelButtonLayoutParams= new Constraints.LayoutParams(80, 80);
        cancelButtonLayoutParams.endToEnd=bottomSection.getId();
        cancelButtonLayoutParams.topToTop=bottomSection.getId();
        cancelButtonLayoutParams.setMargins(cancelButtonLayoutParams.leftMargin,30 ,30,cancelButtonLayoutParams.bottomMargin);
        cancelButton.setLayoutParams(cancelButtonLayoutParams);

//        ImageView smallCircle =new ImageView(context);
//        smallCircle.setId(View.generateViewId());
//        smallCircle.setBackgroundResource(R.drawable.circle);
//        bottomSection.addView(smallCircle);

        CircleLoader circleLoader=new CircleLoader(context);
        bottomSection.addView(circleLoader);


        ConstraintLayout.LayoutParams smallCirclelayoutParams= new Constraints.LayoutParams(250,250);
        smallCirclelayoutParams.endToEnd=bottomSection.getId();
        smallCirclelayoutParams.startToStart=bottomSection.getId();
        smallCirclelayoutParams.topToBottom= cancelButton.getId();
        circleLoader.setLayoutParams(smallCirclelayoutParams);

        TextView titleHeading=new TextView(context);
        titleHeading.setId(View.generateViewId());
        titleHeading.setTypeface(Typeface.DEFAULT_BOLD);
        titleHeading.setTextSize(20);
        titleHeading.setTextColor(ContextCompat.getColor(context,R.color.grey));
        titleHeading.setText(R.string.Loader_heading);
        bottomSection.addView(titleHeading);

        ConstraintLayout.LayoutParams titleHeadingLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titleHeadingLayoutParams.endToEnd=bottomSection.getId();
        titleHeadingLayoutParams.startToStart=bottomSection.getId();
        titleHeadingLayoutParams.topToBottom= circleLoader.getId();
        titleHeadingLayoutParams.setMargins(titleHeadingLayoutParams.leftMargin,40,titleHeadingLayoutParams.rightMargin,titleHeadingLayoutParams.bottomMargin);
        titleHeading.setLayoutParams(titleHeadingLayoutParams);

        TextView subText= new TextView(context);
        subText.setId(View.generateViewId());
        subText.setTextColor(ContextCompat.getColor(context,R.color.grey));
        subText.setTextSize(16);
        subText.setText(R.string.take_a_moment);
        bottomSection.addView(subText);

        ConstraintLayout.LayoutParams subTextLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        subTextLayoutParams.startToStart=bottomSection.getId();
        subTextLayoutParams.endToEnd=bottomSection.getId();
        subTextLayoutParams.topToBottom=titleHeading.getId();
        subTextLayoutParams.setMargins(subTextLayoutParams.leftMargin,20,subTextLayoutParams.rightMargin,subTextLayoutParams.bottomMargin);
        subText.setLayoutParams(subTextLayoutParams);

        LinearLayout linearLayout=new LinearLayout(context);
        linearLayout.setId(View.generateViewId());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        bottomSection.addView(linearLayout);

        ConstraintLayout.LayoutParams linearLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
       linearLayoutParams.startToStart=bottomSection.getId();
       linearLayoutParams.endToEnd=bottomSection.getId();
       linearLayoutParams.topToBottom=subText.getId();
       linearLayoutParams.bottomToBottom=bottomSection.getId();
        linearLayoutParams.setMargins(linearLayoutParams.leftMargin,60,linearLayoutParams.rightMargin,30);
        linearLayout.setLayoutParams(linearLayoutParams);

        ImageView logo= new ImageView(context);
        logo.setId(View.generateViewId());
        logo.setImageResource(R.drawable.security_icon);
        linearLayout.addView(logo);

        LinearLayout.LayoutParams logoLayoutParams=new LinearLayout.LayoutParams(42,42);
        logo.setLayoutParams(logoLayoutParams);

        TextView securityTxt= new TextView(context);
        securityTxt.setId(View.generateViewId());
        securityTxt.setTextColor(ContextCompat.getColor(context,R.color.green));
        securityTxt.setTextSize(10);
        securityTxt.setText(R.string.secure_txt);
        linearLayout.addView(securityTxt);

        LinearLayout.LayoutParams securityTxtLayoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        securityTxtLayoutParams.setMargins(5,securityTxtLayoutParams.topMargin,securityTxtLayoutParams.rightMargin,securityTxtLayoutParams.bottomMargin);
        securityTxt.setLayoutParams(securityTxtLayoutParams);



    }
}
