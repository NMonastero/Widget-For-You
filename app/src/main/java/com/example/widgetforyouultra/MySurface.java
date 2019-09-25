package com.example.widgetforyouultra;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PixelFormat;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MySurface extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float circleX = 0;
    private float circleY = 0;



    public MySurface(Context context) {
        super(context, null);

        surfaceHolder = getHolder();

        paint = new Paint();
        paint.setColor(Color.RED);

         this.getHolder().setFormat(PixelFormat.TRANSLUCENT);
         paint.setStyle(Style.FILL);
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawBall();
    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        paint = null;

    }

    /* This method will be invoked to draw a circle in canvas. */
    public void sunSet(){
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(getResources().getColor(R.color.orange));
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);
        //canvas.drawRect(0, 2000, this.getWidth(), 615, paint);

        paint.setColor(getResources().getColor(R.color.yellow));
        canvas.drawCircle(700, 700, 200, paint);

        paint.setColor(getResources().getColor(R.color.tan));
        canvas.drawRect(0,2000,this.getWidth(),805, paint);

        paint.setColor(getResources().getColor(R.color.yellow));
        canvas.drawCircle(700, 725, 175, paint);

        paint.setColor(getResources().getColor(R.color.brown));
        canvas.drawRect(0,805, this.getWidth(), 800, paint);

        paint.setColor(getResources().getColor(R.color.black));
        canvas.drawCircle(0, 1500, 800, paint);

        paint.setColor(getResources().getColor(R.color.tan));
        canvas.drawRect(0,2000,this.getWidth(),1300, paint);



        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    public void city(){
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(getResources().getColor(R.color.purple));
        canvas.drawRect(0,0,this.getWidth(), this.getHeight(), surfaceBackground);

        paint.setColor(getResources().getColor(R.color.black));
        canvas.drawRect(0, 2000, this.getWidth(), 1200, paint);

        canvas.drawRect(0,1200, 200, 200, paint);

        canvas.drawRect(230,1200, 460, 800, paint);

        canvas.drawRect(470,1200, 670, 600, paint);

        canvas.drawRect(685,1200, 880, 700, paint);

        canvas.drawRect(900,1200, 1100, 100, paint);

        canvas.drawRect(200,1200, 230, 900, paint);
        canvas.drawRect(460,1200, 470, 950, paint);
        canvas.drawRect(670,1200, 685, 750, paint);
        canvas.drawRect(880,1200, 900, 1000, paint);

        canvas.drawRect(280,1200, 290, 780, paint);
        canvas.drawRect(320,1200, 325, 760, paint);

        //windows
        paint.setColor(getResources().getColor(R.color.orange));
        canvas.drawRect(10,300, 35, 330, paint);
        canvas.drawRect(45,300, 70, 330, paint);
        canvas.drawRect(80,300, 105, 330, paint);
        canvas.drawRect(115,380, 140, 410, paint);
        canvas.drawRect(10,340, 35, 370, paint);
        canvas.drawRect(45,600, 70, 630, paint);
        canvas.drawRect(80,700, 105, 730, paint);
        canvas.drawRect(115,420, 140, 450, paint);

        canvas.drawRect(415,860, 440, 830, paint);
        canvas.drawRect(380,860, 405, 830, paint);
        canvas.drawRect(285,900, 310, 870, paint);

        canvas.drawRect(510,660, 535, 630, paint);
        canvas.drawRect(510,700, 535, 670, paint);
        canvas.drawRect(580,810, 605, 780, paint);
        canvas.drawRect(580,850, 605, 820, paint);
        canvas.drawRect(615,810, 640, 780, paint);

        canvas.drawRect(735,810, 760, 780, paint);
        canvas.drawRect(805,890, 830, 860, paint);

        canvas.drawRect(930,160, 955, 130, paint);
        canvas.drawRect(965,200, 990, 170, paint);
        canvas.drawRect(965,240, 990, 210, paint);
        canvas.drawRect(1000,400, 1025, 370, paint);
        canvas.drawRect(1035,400, 1060, 370, paint);
        canvas.drawRect(1035,360, 1060, 330, paint);
        canvas.drawRect(965,600, 990, 570, paint);
        canvas.drawRect(965,800, 990, 770, paint);
        canvas.drawRect(1000,800, 1025, 770, paint);
        //canvas.drawRect(900,1200, 1100, 100, paint);
        //canvas.drawRect(900,1200, 1100, 100, paint);

        //stars
        paint.setColor(getResources().getColor(R.color.white));
        canvas.drawCircle(600, 250, 5, paint);
        canvas.drawCircle(150, 100, 5, paint);
        canvas.drawCircle(460, 120, 5, paint);
        canvas.drawCircle(350, 430, 5, paint);
        canvas.drawCircle(745, 125, 5, paint);


        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    public void graph(){
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(getResources().getColor(R.color.white));
        canvas.drawRect(0,0,this.getWidth(), this.getHeight(), surfaceBackground);

        paint.setColor(getResources().getColor(R.color.black));
        canvas.drawLine(545, 0,555, 2000, paint);
        canvas.drawLine(0, 700,1100, 700, paint);

        paint.setColor(getResources().getColor(R.color.red));
        canvas.drawLine(0, 1000,1100, 400, paint);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    public void drawBall()
    {
        surfaceHolder = getHolder();

        // Get and lock canvas object from surfaceHolder.
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.BLACK);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the circle.
        paint.setColor(Color.RED);
        canvas.drawCircle(circleX, circleY, 100, paint);

        canvas.drawCircle(50, 50, 200, paint);

        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    /* This method will be invoked to draw a circle in canvas. */
    public void drawRect()
    {
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.BLUE);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the rectangle.
        canvas.drawRect(circleX, circleY, circleX + 200, circleY + 200, paint);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    public float getCircleX() {
        return circleX;
    }

    public void setCircleX(float circleX) {
        this.circleX = circleX;
    }

    public float getCircleY() {
        return circleY;
    }

    public void setCircleY(float circleY) {
        this.circleY = circleY;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}

