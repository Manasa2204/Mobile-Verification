package com.example.mobileverification;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.content.ContextCompat;

import java.lang.reflect.Field;

public class InputScreenLayout extends ConstraintLayout {

    ImageView backButton, cancelButton, smallCircle, bigCircle,graphicImage;
    TextView pageTitle, bottomSectionHeading, inputTitle, resendButton, nextButton, errorText;
    EditText inputOtp;
    ConstraintLayout bottomConstraintLayout,bottomSection;
    View hline1,hline2;
    Context context;

    public InputScreenLayout(@NonNull Context context) {
        super(context);

        this.context=context;
        setId(View.generateViewId());

        ViewGroup.LayoutParams layoutParams=
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        setLayoutParams(layoutParams);
        setBackgroundColor(ContextCompat.getColor(context,R.color.backGround));


        addChildViews(context);

    }


    private void addChildViews(Context context) {
        backButton = new ImageView(context);
        backButton.setId(View.generateViewId());
        backButton.setImageResource(R.drawable.back);
        backButton.setBackgroundResource(R.drawable.icon_bg);
        addView(backButton);

        ConstraintLayout.LayoutParams backButtonlayoutParams= new Constraints.LayoutParams(80, 80);
        backButtonlayoutParams.startToStart=getId();
        backButtonlayoutParams.topToTop=getId();
        backButtonlayoutParams.setMargins(dpToPx(15),dpToPx(15),backButtonlayoutParams.rightMargin,backButtonlayoutParams.bottomMargin);
        backButton.setLayoutParams(backButtonlayoutParams);


        cancelButton = new ImageView(context);
        cancelButton.setId(View.generateViewId());
        cancelButton.setImageResource(R.drawable.cancel);
        cancelButton.setBackgroundResource(R.drawable.icon_bg);
        addView(cancelButton);

        ConstraintLayout.LayoutParams cancleButtonlayoutParams= new Constraints.LayoutParams(80, 80);
        cancleButtonlayoutParams.endToEnd=getId();
        cancleButtonlayoutParams.topToTop=getId();
        cancleButtonlayoutParams.setMargins(cancleButtonlayoutParams.leftMargin,dpToPx(15),dpToPx(15),cancleButtonlayoutParams.bottomMargin);
        cancelButton.setLayoutParams(cancleButtonlayoutParams);

        pageTitle = new TextView(context);
        pageTitle.setId(View.generateViewId());
        pageTitle.setText(R.string.mobile_verification);
        pageTitle.setTextColor(ContextCompat.getColor(context,R.color.grey));
        pageTitle.setTextSize(24);
        pageTitle.setTypeface(Typeface.DEFAULT_BOLD);
        addView(pageTitle);

        ConstraintLayout.LayoutParams pageTitlelayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pageTitlelayoutParams.endToEnd=getId();
        pageTitlelayoutParams.startToStart=getId();
        pageTitlelayoutParams.topToBottom= cancelButton.getId();
        pageTitle.setLayoutParams(pageTitlelayoutParams);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height=displayMetrics.heightPixels;

        int bigCircle=(int)Math.round(width*1.2);
        int smallCircle=(int)Math.round(width*0.2);

        int x_offset=(int)Math.round(width*0.1);
        int y_offset=(int)Math.round(width*0.65);
        int smallCircleY_Offset=(int)Math.round(width*0.05);

        this.smallCircle =new ImageView(context);
        this.smallCircle.setBackgroundResource(R.drawable.circle);
        addView(this.smallCircle);

        ConstraintLayout.LayoutParams smallCirclelayoutParams= new Constraints.LayoutParams(smallCircle,smallCircle);
        smallCirclelayoutParams.endToEnd=getId();
        smallCirclelayoutParams.startToStart=getId();
        smallCirclelayoutParams.topToBottom= pageTitle.getId();
        smallCirclelayoutParams.setMargins(x_offset,smallCircleY_Offset,smallCirclelayoutParams.rightMargin,smallCirclelayoutParams.bottomMargin);
        this.smallCircle.setLayoutParams(smallCirclelayoutParams);


        this.bigCircle =new ImageView(context);
        this.bigCircle.setBackgroundResource(R.drawable.circle);
        addView(this.bigCircle);


        ConstraintLayout.LayoutParams bigCirclelayoutParams= new Constraints.LayoutParams(bigCircle,bigCircle);
        bigCirclelayoutParams.startToStart=getId();
        bigCirclelayoutParams.endToEnd=getId();
        bigCirclelayoutParams.topToTop=getId();
        bigCirclelayoutParams.setMargins(bigCirclelayoutParams.leftMargin,y_offset,bigCirclelayoutParams.rightMargin,bigCirclelayoutParams.bottomMargin);
        this.bigCircle.setLayoutParams(bigCirclelayoutParams);

        int graphicY_offset=(int)Math.round(width*0.3);

        graphicImage=new ImageView(context);
        graphicImage.setImageResource(R.drawable.mobile_verification);
        addView(graphicImage);

        int graphicImageHeight=(int)Math.round(height*0.85);

        ConstraintLayout.LayoutParams graphicImageLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,graphicImageHeight);
        graphicImageLayoutParams.endToEnd=getId();
        graphicImageLayoutParams.startToStart=getId();
//        graphicImageLayoutParams.bottomToBottom=getId();
        graphicImageLayoutParams.topToTop=getId();
        graphicImageLayoutParams.setMargins(graphicImageLayoutParams.leftMargin,graphicY_offset,graphicImageLayoutParams.rightMargin,graphicImageLayoutParams.bottomMargin);
        graphicImage.setLayoutParams(graphicImageLayoutParams);


        bottomSection=new ConstraintLayout(context);
        bottomSection.setId(View.generateViewId());
        addView(bottomSection);

        ConstraintLayout.LayoutParams bottomSectionConstraintLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bottomSectionConstraintLayoutParams.endToEnd=getId();
        bottomSectionConstraintLayoutParams.startToStart=getId();
        bottomSectionConstraintLayoutParams.bottomToBottom=getId();
        bottomSection.setLayoutParams(bottomSectionConstraintLayoutParams);


        View gradientView=new View(context);
        gradientView.setBackgroundResource(R.drawable.gradient_bg);
        gradientView.setId(View.generateViewId());
        bottomSection.addView(gradientView);

        ConstraintLayout.LayoutParams gradientViewLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,250);
        gradientViewLayoutParams.startToStart=bottomSection.getId();
        gradientViewLayoutParams.topToTop= bottomSection.getId();
        gradientViewLayoutParams.endToEnd=bottomSection.getId();
        gradientView.setLayoutParams(gradientViewLayoutParams);


        bottomConstraintLayout =new ConstraintLayout(context);
        bottomConstraintLayout.setId(View.generateViewId());
        bottomConstraintLayout.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        bottomSection.addView(bottomConstraintLayout);

        ConstraintLayout.LayoutParams constraintLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        constraintLayoutParams.endToEnd=bottomSection.getId();
        constraintLayoutParams.startToStart=bottomSection.getId();
        constraintLayoutParams.topToBottom=gradientView.getId();
        bottomConstraintLayout.setLayoutParams(constraintLayoutParams);



        bottomSectionHeading =new TextView(context);
        bottomSectionHeading.setId(View.generateViewId());
        bottomSectionHeading.setText(R.string.send_otp);
        bottomSectionHeading.setTextColor(ContextCompat.getColor(context,R.color.grey));
        bottomSectionHeading.setTextSize(14);
        bottomConstraintLayout.addView(bottomSectionHeading);

        ConstraintLayout.LayoutParams bottomSectionHeadingLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bottomSectionHeadingLayoutParams.endToEnd= bottomConstraintLayout.getId();
        bottomSectionHeadingLayoutParams.startToStart= bottomConstraintLayout.getId();
        bottomSectionHeadingLayoutParams.topToTop= bottomConstraintLayout.getId();
        bottomSectionHeading.setLayoutParams(bottomSectionHeadingLayoutParams);

        hline1=new View(context);
        hline1.setId(View.generateViewId());
        hline1.setBackgroundColor(ContextCompat.getColor(context,R.color.nextbtnColor));
//        hline1.setBackgroundResource(R.drawable.horizontal_line);
        bottomConstraintLayout.addView(hline1);

        ConstraintLayout.LayoutParams hLine1LayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 3);
        hLine1LayoutParams.endToEnd= bottomConstraintLayout.getId();
        hLine1LayoutParams.startToStart= bottomConstraintLayout.getId();
        hLine1LayoutParams.topToBottom= bottomSectionHeading.getId();
        hLine1LayoutParams.setMargins(hLine1LayoutParams.leftMargin,dpToPx(10),hLine1LayoutParams.rightMargin,hLine1LayoutParams.bottomMargin);
        hline1.setLayoutParams(hLine1LayoutParams);


        inputTitle = new TextView(context);
        inputTitle.setId(View.generateViewId());
        inputTitle.setTextSize(14);
        inputTitle.setText(R.string.otp_send_to);
        inputTitle.setTextColor(getResources().getColor(R.color.grey));
        bottomConstraintLayout.addView(inputTitle);

        ConstraintLayout.LayoutParams inputTitleLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        inputTitleLayoutParams.startToStart= bottomConstraintLayout.getId();
        inputTitleLayoutParams.topToBottom=hline1.getId();
        inputTitleLayoutParams.setMargins(dpToPx(30),dpToPx(10),inputTitleLayoutParams.rightMargin,inputTitleLayoutParams.bottomMargin);
        inputTitle.setLayoutParams(inputTitleLayoutParams);


        inputOtp=new EditText(context);
        inputOtp.setId(View.generateViewId());
        inputOtp.setTextSize(20);
        inputOtp.setTextCursorDrawable(R.drawable.cursor_bg);
//        inputOtp.setInputType(InputType.TYPE_CLASS_NUMBER);
        inputOtp.setMaxLines(1);
        inputOtp.setPadding(0,5,0,5);
        inputOtp.setTextColor(ContextCompat.getColor(context,R.color.grey));
        inputOtp.setBackgroundResource(R.drawable.edittext_bg);
        bottomConstraintLayout.addView(inputOtp);



        ConstraintLayout.LayoutParams inputOtpLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        inputOtpLayoutParams.startToStart= inputTitle.getId();
        inputOtpLayoutParams.topToBottom= inputTitle.getId();
        inputOtpLayoutParams.setMargins(inputTitleLayoutParams.leftMargin,dpToPx(10),inputOtpLayoutParams.rightMargin,inputTitleLayoutParams.bottomMargin);
        inputOtp.setLayoutParams(inputOtpLayoutParams);


        hline2=new View(context);
        hline2.setId(View.generateViewId());
        hline2.setBackgroundColor(ContextCompat.getColor(context,R.color.nextbtnColor));
//        hline2.setBackgroundResource(R.drawable.horizontal_line);
        bottomConstraintLayout.addView(hline2);

        ConstraintLayout.LayoutParams hline2LayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 3);
        hline2LayoutParams.endToEnd= bottomConstraintLayout.getId();
        hline2LayoutParams.startToStart= bottomConstraintLayout.getId();
        hline2LayoutParams.topToBottom=inputOtp.getId();
        hline2LayoutParams.setMargins(hline2LayoutParams.leftMargin,dpToPx(10),hline2LayoutParams.rightMargin,hline2LayoutParams.bottomMargin);
        hline2.setLayoutParams(hline2LayoutParams);

        errorText =new TextView(context);
        errorText.setId(View.generateViewId());
        errorText.setTextSize(14);
        errorText.setText("Invalid");
        errorText.setVisibility(INVISIBLE);
        errorText.setTextColor(ContextCompat.getColor(context,R.color.invalidColor));
        errorText.setBackgroundResource(R.drawable.invalid_bg);
        bottomConstraintLayout.addView(errorText);

        ConstraintLayout.LayoutParams errorTextLayoutParams=new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        errorTextLayoutParams.topToTop=hline2.getId();
        errorTextLayoutParams.bottomToBottom=hline2.getId();
        errorTextLayoutParams.endToEnd= bottomConstraintLayout.getId();
        errorTextLayoutParams.setMargins(errorTextLayoutParams.leftMargin,errorTextLayoutParams.topMargin,40,errorTextLayoutParams.bottomMargin);
        errorText.setLayoutParams(errorTextLayoutParams);


        resendButton = new TextView(context);
        resendButton.setId(View.generateViewId());
        resendButton.setTextSize(12);
        resendButton.setText(R.string.resend_otp);
        resendButton.setTextColor(ContextCompat.getColor(context,R.color.ResendColor));
        bottomConstraintLayout.addView(resendButton);

        ConstraintLayout.LayoutParams resendButtonLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        resendButtonLayoutParams.startToStart= bottomConstraintLayout.getId();
        resendButtonLayoutParams.topToBottom=errorText.getId();
        resendButtonLayoutParams.endToEnd= bottomConstraintLayout.getId();
        resendButtonLayoutParams.setMargins(resendButtonLayoutParams.leftMargin,dpToPx(10),resendButtonLayoutParams.rightMargin,resendButtonLayoutParams.bottomMargin);
        resendButton.setLayoutParams(resendButtonLayoutParams);


        nextButton = new TextView(context);
        nextButton.setId(View.generateViewId());
        nextButton.setTextSize(16);
        nextButton.setTypeface(Typeface.DEFAULT_BOLD);
        nextButton.setText(R.string.next);
        nextButton.setBackgroundResource(R.drawable.nextbtn_bg);
        nextButton.setGravity(Gravity.CENTER_HORIZONTAL| Gravity.CENTER_VERTICAL);
        nextButton.setTextColor(ContextCompat.getColor(context,R.color.textColor));
        bottomConstraintLayout.addView(nextButton);

        ConstraintLayout.LayoutParams nextButtonLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 138);
        nextButtonLayoutParams.startToStart= bottomConstraintLayout.getId();
        nextButtonLayoutParams.topToBottom= resendButton.getId();
        nextButtonLayoutParams.bottomToBottom= bottomConstraintLayout.getId();
        nextButtonLayoutParams.endToEnd= bottomConstraintLayout.getId();
        nextButtonLayoutParams.setMargins(dpToPx(15),dpToPx(45),dpToPx(15),dpToPx(15));
        nextButton.setLayoutParams(nextButtonLayoutParams);



    }

    public int dpToPx(int dp) {
        return (int)(dp * context.getResources().getDisplayMetrics().density);
    }

}
