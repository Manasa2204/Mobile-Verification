package com.example.mobileverification;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import androidx.navigation.ActivityNavigator;
import androidx.transition.Slide;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeScroll;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EmailVerficationActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout,bottomSection,bottomConstraintLayout;
    ImageView smallCircle,bigCircle,graphicImage,backButton,cancelButton;
    TextView pageTitle,bottomSectionHeading,inputTitle,errorText,resendButton,nextButton;
    EditText inputOtp;
    View hline1,hline2;


 @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        constraintLayout=new ConstraintLayout(this);
        constraintLayout.setId(View.generateViewId());
        constraintLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.backGround));



        ViewGroup.LayoutParams constraintLayoutParams=
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        constraintLayout.setLayoutParams(constraintLayoutParams);

        setContentView(constraintLayout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

       constraintLayout.setFitsSystemWindows(true);

       addChildViews();

       ObjectAnimator animation = ObjectAnimator.ofFloat(graphicImage, "rotationY", 90f, 0f);
       animation.setDuration(500);

       animation.setInterpolator(new AccelerateDecelerateInterpolator());
       ObjectAnimator animation2=ObjectAnimator.ofFloat(graphicImage,"alpha",0.5f,1.0f);
       animation2.setDuration(500);
       AnimatorSet scaleAnimatorSet = new AnimatorSet();
       scaleAnimatorSet.playTogether(animation2, animation);
       scaleAnimatorSet.start();


    }

    @Override
    public void onBackPressed() {
     finishAfterTransition();
    }

    private void addChildViews() {

      pageTitle = new TextView(this);
      pageTitle.setId(View.generateViewId());
      pageTitle.setText(R.string.email_verification);
      pageTitle.setTextColor(ContextCompat.getColor(this,R.color.grey));
      pageTitle.setTextSize(24);
      pageTitle.setTypeface(Typeface.DEFAULT_BOLD);
      constraintLayout.addView(pageTitle);

      ConstraintLayout.LayoutParams pageTitlelayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
      pageTitlelayoutParams.endToEnd=constraintLayout.getId();
      pageTitlelayoutParams.startToStart=constraintLayout.getId();
      pageTitlelayoutParams.topToTop=constraintLayout.getId();
      pageTitlelayoutParams.setMargins(pageTitlelayoutParams.leftMargin,90,pageTitlelayoutParams.rightMargin,pageTitlelayoutParams.bottomMargin);
      pageTitle.setLayoutParams(pageTitlelayoutParams);


        DisplayMetrics displayMetrics = new DisplayMetrics();
       this.getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height=displayMetrics.heightPixels;

        int bigCircle=(int)Math.round(width*0.6);
        int smallCircle=(int)Math.round(width*0.2);

       int bigCircleX= (int)Math.round(width*0.76);
       int bigCircleY= (int)Math.round(height*0.15);

       int smallCircleX= (int)Math.round(width*0.055);
       int smallCircleY= (int)Math.round(height*0.35);


        this.smallCircle =new ImageView(this);
        this.smallCircle.setId(R.id.small_circle);
        this.smallCircle.setTransitionName("smallCircletranslate");
        this.smallCircle.setBackgroundResource(R.drawable.circle);
        constraintLayout.addView(this.smallCircle);

        ConstraintLayout.LayoutParams smallCirclelayoutParams= new Constraints.LayoutParams(smallCircle,smallCircle);
        this.smallCircle.setX(-smallCircleX);
        this.smallCircle.setY(smallCircleY);
       this.smallCircle.setLayoutParams(smallCirclelayoutParams);


        this.bigCircle =new ImageView(this);
        this.bigCircle.setId(R.id.big_cirle);
        this.bigCircle.setTransitionName("bigCircletranslate");
        this.bigCircle.setBackgroundResource(R.drawable.circle);
        constraintLayout.addView(this.bigCircle);


        ConstraintLayout.LayoutParams bigCirclelayoutParams= new Constraints.LayoutParams(bigCircle,bigCircle);
        this.bigCircle.setX(bigCircleX);
        this.bigCircle.setY(-bigCircleY);
       this.bigCircle.setLayoutParams(bigCirclelayoutParams);


        graphicImage=new ImageView(this);
        graphicImage.setImageResource(R.drawable.email_verification);
        graphicImage.setTransitionName("graphicImageTranslate");
        constraintLayout.addView(graphicImage);

        int graphicImageHeight=(int)Math.round(height*0.85);
        int graphicY_offset=(int)Math.round(width*0.3);

        ConstraintLayout.LayoutParams graphicImageLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,graphicImageHeight);
        graphicImageLayoutParams.endToEnd=constraintLayout.getId();
        graphicImageLayoutParams.startToStart=constraintLayout.getId();
//        graphicImageLayoutParams.bottomToBottom=getId();
        graphicImageLayoutParams.topToTop=constraintLayout.getId();
        graphicImageLayoutParams.setMargins(graphicImageLayoutParams.leftMargin,graphicY_offset,graphicImageLayoutParams.rightMargin,graphicImageLayoutParams.bottomMargin);
        graphicImage.setLayoutParams(graphicImageLayoutParams);


        bottomSection=new ConstraintLayout(this);
        bottomSection.setId(View.generateViewId());
        constraintLayout.addView(bottomSection);

        ConstraintLayout.LayoutParams bottomSectionConstraintLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bottomSectionConstraintLayoutParams.endToEnd=constraintLayout.getId();
        bottomSectionConstraintLayoutParams.startToStart=constraintLayout.getId();
        bottomSectionConstraintLayoutParams.bottomToBottom=constraintLayout.getId();
        bottomSection.setLayoutParams(bottomSectionConstraintLayoutParams);


        View gradientView=new View(this);
        gradientView.setBackgroundResource(R.drawable.gradient_bg);
        gradientView.setId(View.generateViewId());
        bottomSection.addView(gradientView);

        ConstraintLayout.LayoutParams gradientViewLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,250);
        gradientViewLayoutParams.startToStart=bottomSection.getId();
        gradientViewLayoutParams.topToTop= bottomSection.getId();
        gradientViewLayoutParams.endToEnd=bottomSection.getId();
        gradientView.setLayoutParams(gradientViewLayoutParams);


        bottomConstraintLayout =new ConstraintLayout(this);
        bottomConstraintLayout.setId(View.generateViewId());
        bottomConstraintLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        bottomSection.addView(bottomConstraintLayout);

        ConstraintLayout.LayoutParams constraintLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        constraintLayoutParams.endToEnd=bottomSection.getId();
        constraintLayoutParams.startToStart=bottomSection.getId();
        constraintLayoutParams.topToBottom=gradientView.getId();
        bottomConstraintLayout.setLayoutParams(constraintLayoutParams);



        bottomSectionHeading =new TextView(this);
        bottomSectionHeading.setId(View.generateViewId());
        bottomSectionHeading.setText(R.string.send_otp);
        bottomSectionHeading.setTextColor(ContextCompat.getColor(this,R.color.grey));
        bottomSectionHeading.setTextSize(14);
        bottomConstraintLayout.addView(bottomSectionHeading);

        ConstraintLayout.LayoutParams bottomSectionHeadingLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bottomSectionHeadingLayoutParams.endToEnd= bottomConstraintLayout.getId();
        bottomSectionHeadingLayoutParams.startToStart= bottomConstraintLayout.getId();
        bottomSectionHeadingLayoutParams.topToTop= bottomConstraintLayout.getId();
        bottomSectionHeading.setLayoutParams(bottomSectionHeadingLayoutParams);

        hline1=new View(this);
        hline1.setId(View.generateViewId());
        hline1.setBackgroundColor(ContextCompat.getColor(this,R.color.nextbtnColor));
//        hline1.setBackgroundResource(R.drawable.horizontal_line);
        bottomConstraintLayout.addView(hline1);

        ConstraintLayout.LayoutParams hLine1LayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 3);
        hLine1LayoutParams.endToEnd= bottomConstraintLayout.getId();
        hLine1LayoutParams.startToStart= bottomConstraintLayout.getId();
        hLine1LayoutParams.topToBottom= bottomSectionHeading.getId();
        hLine1LayoutParams.setMargins(hLine1LayoutParams.leftMargin,dpToPx(10),hLine1LayoutParams.rightMargin,hLine1LayoutParams.bottomMargin);
        hline1.setLayoutParams(hLine1LayoutParams);


        inputTitle = new TextView(this);
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


        inputOtp=new EditText(this);
        inputOtp.setId(View.generateViewId());
        inputOtp.setTextSize(20);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            inputOtp.setTextCursorDrawable(R.drawable.cursor_bg);
        }
//        inputOtp.setInputType(InputType.TYPE_CLASS_NUMBER);
        inputOtp.setMaxLines(1);
        inputOtp.setPadding(0,5,0,5);
        inputOtp.setTextColor(ContextCompat.getColor(this,R.color.grey));
        inputOtp.setBackgroundResource(R.drawable.edittext_bg);
        bottomConstraintLayout.addView(inputOtp);



        ConstraintLayout.LayoutParams inputOtpLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        inputOtpLayoutParams.startToStart= inputTitle.getId();
        inputOtpLayoutParams.topToBottom= inputTitle.getId();
        inputOtpLayoutParams.setMargins(inputTitleLayoutParams.leftMargin,dpToPx(10),inputOtpLayoutParams.rightMargin,inputTitleLayoutParams.bottomMargin);
        inputOtp.setLayoutParams(inputOtpLayoutParams);


        hline2=new View(this);
        hline2.setId(View.generateViewId());
        hline2.setBackgroundColor(ContextCompat.getColor(this,R.color.nextbtnColor));
//        hline2.setBackgroundResource(R.drawable.horizontal_line);
        bottomConstraintLayout.addView(hline2);

        ConstraintLayout.LayoutParams hline2LayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 3);
        hline2LayoutParams.endToEnd= bottomConstraintLayout.getId();
        hline2LayoutParams.startToStart= bottomConstraintLayout.getId();
        hline2LayoutParams.topToBottom=inputOtp.getId();
        hline2LayoutParams.setMargins(hline2LayoutParams.leftMargin,dpToPx(10),hline2LayoutParams.rightMargin,hline2LayoutParams.bottomMargin);
        hline2.setLayoutParams(hline2LayoutParams);

        errorText =new TextView(this);
        errorText.setId(View.generateViewId());
        errorText.setTextSize(14);
        errorText.setText("Invalid");
        errorText.setVisibility(View.INVISIBLE);
        errorText.setTextColor(ContextCompat.getColor(this,R.color.invalidColor));
        errorText.setBackgroundResource(R.drawable.invalid_bg);
        bottomConstraintLayout.addView(errorText);

        ConstraintLayout.LayoutParams errorTextLayoutParams=new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        errorTextLayoutParams.topToTop=hline2.getId();
        errorTextLayoutParams.bottomToBottom=hline2.getId();
        errorTextLayoutParams.endToEnd= bottomConstraintLayout.getId();
        errorTextLayoutParams.setMargins(errorTextLayoutParams.leftMargin,errorTextLayoutParams.topMargin,40,errorTextLayoutParams.bottomMargin);
        errorText.setLayoutParams(errorTextLayoutParams);


        resendButton = new TextView(this);
        resendButton.setId(View.generateViewId());
        resendButton.setTextSize(12);
        resendButton.setText(R.string.resend_otp);
        resendButton.setTextColor(ContextCompat.getColor(this,R.color.ResendColor));
        bottomConstraintLayout.addView(resendButton);

        ConstraintLayout.LayoutParams resendButtonLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        resendButtonLayoutParams.startToStart= bottomConstraintLayout.getId();
        resendButtonLayoutParams.topToBottom=errorText.getId();
        resendButtonLayoutParams.endToEnd= bottomConstraintLayout.getId();
        resendButtonLayoutParams.setMargins(resendButtonLayoutParams.leftMargin,dpToPx(10),resendButtonLayoutParams.rightMargin,resendButtonLayoutParams.bottomMargin);
        resendButton.setLayoutParams(resendButtonLayoutParams);


        nextButton = new TextView(this);
        nextButton.setId(View.generateViewId());
        nextButton.setTextSize(16);
        nextButton.setTypeface(Typeface.DEFAULT_BOLD);
        nextButton.setText(R.string.next);
        nextButton.setBackgroundResource(R.drawable.nextbtn_bg);
        nextButton.setGravity(Gravity.CENTER_HORIZONTAL| Gravity.CENTER_VERTICAL);
        nextButton.setTextColor(ContextCompat.getColor(this,R.color.textColor));
        bottomConstraintLayout.addView(nextButton);

        ConstraintLayout.LayoutParams nextButtonLayoutParams= new Constraints.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 138);
        nextButtonLayoutParams.startToStart= bottomConstraintLayout.getId();
        nextButtonLayoutParams.topToBottom= resendButton.getId();
        nextButtonLayoutParams.bottomToBottom= bottomConstraintLayout.getId();
        nextButtonLayoutParams.endToEnd= bottomConstraintLayout.getId();
        nextButtonLayoutParams.setMargins(dpToPx(15),dpToPx(45),dpToPx(15),dpToPx(15));
        nextButton.setLayoutParams(nextButtonLayoutParams);

        backButton = new ImageView(this);
        backButton.setId(View.generateViewId());
        backButton.setImageResource(R.drawable.back);
        backButton.setBackgroundResource(R.drawable.icon_bg);
        constraintLayout.addView(backButton);

        ConstraintLayout.LayoutParams backButtonlayoutParams= new Constraints.LayoutParams(80, 80);
        backButtonlayoutParams.startToStart=constraintLayout.getId();
        backButtonlayoutParams.topToTop=constraintLayout.getId();
        backButtonlayoutParams.setMargins(dpToPx(15),dpToPx(15),backButtonlayoutParams.rightMargin,backButtonlayoutParams.bottomMargin);
        backButton.setLayoutParams(backButtonlayoutParams);


        cancelButton = new ImageView(this);
        cancelButton.setId(View.generateViewId());
        cancelButton.setImageResource(R.drawable.cancel);
        cancelButton.setBackgroundResource(R.drawable.icon_bg);
        constraintLayout.addView(cancelButton);

        ConstraintLayout.LayoutParams cancleButtonlayoutParams= new Constraints.LayoutParams(80, 80);
        cancleButtonlayoutParams.endToEnd=constraintLayout.getId();
        cancleButtonlayoutParams.topToTop=constraintLayout.getId();
        cancleButtonlayoutParams.setMargins(cancleButtonlayoutParams.leftMargin,dpToPx(15),dpToPx(15),cancleButtonlayoutParams.bottomMargin);
        cancelButton.setLayoutParams(cancleButtonlayoutParams);

    }

    public int dpToPx(int dp) {
        return (int)(dp * this.getResources().getDisplayMetrics().density);
    }

 @Override
    protected void onRestart() {
     super.onRestart();
     postponeEnterTransition();
     bigCircle.post(new Runnable() {
      @Override
      public void run() {
       startPostponedEnterTransition();
      }
     });

     smallCircle.post(new Runnable() {
      @Override
      public void run() {
       startPostponedEnterTransition();

      }
     });
    }


}