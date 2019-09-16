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
import android.graphics.BlurMaskFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
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
    private static final int TOUCH_TOLERANCE = 4;
    public static int brushSize = 20;
    public static final int DEFAULT_BRUSH_COLOR = R.color.red;
    public static final int DEFAULT_BACKGROUND_COLOR = R.color.white;
    private ArrayList<FingerPaint> paths = new ArrayList();
    private int currentColor;
    private int currentBackground = DEFAULT_BACKGROUND_COLOR;
    private int strokeWidth;
    private Canvas canvas;
    private Bitmap bitmap;

    public MySurface(Context context) {
        super(context, null);

        //surfaceHolder = getHolder();

        //paint = new Paint();
        //paint.setColor(Color.RED);

        // this.getHolder().setFormat(PixelFormat.TRANSLUCENT);
        // paint.setStyle(Style.FILL);
    }

    public MySurface(Context context, AttributeSet attrs){
        super(context, attrs);
        paint.setAntiAlias(true); //smooths out the lines
        paint.setDither(true); //a little slower but allows for more precise colors
        //If I was using the default colors I wouldn't want dither but those colors are ugly
        paint.setColor(getResources().getColor(DEFAULT_BRUSH_COLOR));

        paint.setStyle(Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);//this makes all of the strokes rounded at the end instead of rectangles

        paint.setXfermode(null); //this clears the last path continuity
        //without it, you would only be able to have one continuous stroke

        paint.setAlpha(0xff);//Some sources say this is necessary as a helper to setColor
        //However I believe that because I define colors in an xml file, this might not be needed (might remove later)
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

