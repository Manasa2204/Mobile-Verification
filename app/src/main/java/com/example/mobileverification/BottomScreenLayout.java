package com.example.mobileverification;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
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
    Context context;
    public BottomScreenLayout(@NonNull Context context) {
        super(context);

        setId(View.generateViewId());
        this.context=context;

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
        cancelButtonLayoutParams.setMargins(cancelButtonLayoutParams.leftMargin,dpToPx(15) ,dpToPx(15),cancelButtonLayoutParams.bottomMargin);
        cancelButton.setLayoutParams(cancelButtonLayoutParams);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height=(int)Math.round(0.2*width);

        CircleLoader circleLoader=new CircleLoader(context);
//        circleLoader.setBackgroundColor(ContextCompat.getColor(context,R.color.green));
        bottomSection.addView(circleLoader);


        ConstraintLayout.LayoutParams smallCirclelayoutParams= new Constraints.LayoutParams(height,height);
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
        titleHeadingLayoutParams.setMargins(titleHeadingLayoutParams.leftMargin,dpToPx(20),titleHeadingLayoutParams.rightMargin,titleHeadingLayoutParams.bottomMargin);
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
        subTextLayoutParams.setMargins(subTextLayoutParams.leftMargin,dpToPx(10),subTextLayoutParams.rightMargin,subTextLayoutParams.bottomMargin);
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
        linearLayoutParams.setMargins(linearLayoutParams.leftMargin,dpToPx(30),linearLayoutParams.rightMargin,30);
        linearLayout.setLayoutParams(linearLayoutParams);

        ImageView logo= new ImageView(context);
        logo.setId(View.generateViewId());
        logo.setImageResource(R.drawable.security_icon);
        linearLayout.addView(logo);

        LinearLayout.LayoutParams logoLayoutParams=new LinearLayout.LayoutParams(dpToPx(14),dpToPx(14));
        logo.setLayoutParams(logoLayoutParams);

        TextView securityTxt= new TextView(context);
        securityTxt.setId(View.generateViewId());
        securityTxt.setTextColor(ContextCompat.getColor(context,R.color.green));
        securityTxt.setTextSize(10);
        securityTxt.setText(R.string.secure_txt);
        linearLayout.addView(securityTxt);

        LinearLayout.LayoutParams securityTxtLayoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        securityTxtLayoutParams.setMargins(dpToPx(2),securityTxtLayoutParams.topMargin,securityTxtLayoutParams.rightMargin,securityTxtLayoutParams.bottomMargin);
        securityTxt.setLayoutParams(securityTxtLayoutParams);



    }
    public int dpToPx(int dp) {
        return (int)(dp * context.getResources().getDisplayMetrics().density);
    }
}
