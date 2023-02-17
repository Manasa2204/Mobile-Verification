package com.example.mobileverification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CircleAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.circle_animation_layout);

        TextView nextButton= findViewById(R.id.nextbtn);

        ImageView smallCircle=findViewById(R.id.small_circle);
        ImageView bigCircle=findViewById(R.id.big_cirle);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(CircleAnimationActivity.this, Pair.create(smallCircle,"smallCircletranslate"),Pair.create(bigCircle,"bigCircletranslate"));
                Intent intent = new Intent(CircleAnimationActivity.this,EmailVerficationActivity.class);
                startActivity(intent,activityOptionsCompat.toBundle());

            }
        });

        ChangeBounds bounds = new ChangeBounds();
        bounds.setDuration(1000);
        getWindow().setSharedElementEnterTransition(bounds);
    }
}