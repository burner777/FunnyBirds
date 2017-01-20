package com.example.student2.funnybirds;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.View;

/**
 * Created by student2 on 20.01.17.
 */
public class GameView extends View {

    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;

}
    protected void onDraw(Canvas canvas){
    super.onDraw(canvas);
            canvas.drawARGB(250,127,199,255);
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setTextSize(55.0f);
        p.setColor(Color.WHITE);
        canvas.drawText(points+"", viewWidth - 100, 70, p);
    }
    private int viewWidth;
    private int viewHeight;
    private int points = 0;
    private Sprite playerBird;

    public GameView(Context context) {
        super(context);
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.yyy);
        int w = b.getWidth()/5;
        int h = b.getHeight()/3;
        Rect firstFrame = new Rect(0, 0, w, h);
        playerBird = new Sprite(10, 0, 0, 100, firstFrame, b);
        Timer t = new Timer();
        t.start();
    }
    private final int timerInterval = 30;
    protected void update () {
        playerBird.update(timerInterval);
        invalidate();
    }
    class Timer extends CountDownTimer {
        public Timer() {
            super(Integer.MAX_VALUE, timerInterval);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            update ();
        }
        @Override
        public void onFinish() {
        }
    }
    




}
