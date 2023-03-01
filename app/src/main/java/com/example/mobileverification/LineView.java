package com.example.mobileverification;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class LineView extends View {

    private Paint paint;
    private float startX, startY, endX, endY;
    private RectF rect;
    private boolean movingRight = true;

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public  LineView(Context context){
            super(context);
            init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        startX = 50;
        startY = 50;
        endX = 200;
        endY = 50;
        rect = new RectF(50, 50, 500, 500);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(startX, startY, endX, endY, paint);
//        canvas.drawColor(Color.BLACK);
    }

    public void startAnimation() {
        final long duration = 3000;
        final long startTime = System.currentTimeMillis();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long elapsedTime = System.currentTimeMillis() - startTime;
                float progress = (float) elapsedTime / duration;
                updateLinePosition(progress);
                postInvalidate();
            }
        }, 0, 30);
    }

    private void updateLinePosition(float progress) {
        float distance = rect.width() - (endX - startX);
        float x = startX + distance * progress;
        float y = getYAtX(x);
        endX = x;
        endY = y;
        if (x >= rect.right) {
            movingRight = false;
        } else if (x <= rect.left) {
            movingRight = true;
        }
        if (movingRight) {
            startX += distance * progress;
        } else {
            startX -= distance * progress;
        }
        startY = getYAtX(startX);
    }

    private float getYAtX(float x) {
        float a = (endY - startY) / (endX - startX);
        float b = startY - a * startX;
        return a * x + b;
    }
}