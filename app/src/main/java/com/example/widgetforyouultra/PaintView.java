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

public class PaintView extends View {
    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float circleX = 0;
    private float circleY = 0;
    private static final int TOUCH_TOLERANCE = 4;
    public static int brushSize = 20;
    public static final int DEFAULT_BRUSH_COLOR = R.color.red;
    public static final int DEFAULT_BACKGROUND_COLOR = R.color.white;
    private ArrayList<FingerPaint> paths = new ArrayList();
    public static int currentColor;
    private int currentBackgroundColor = DEFAULT_BACKGROUND_COLOR;
    private int strokeWidth;
    private Canvas canvas;
    private Bitmap bitmap;

    public PaintView(Context context) {
        super(context, null);

        //surfaceHolder = getHolder();

        //paint = new Paint();
        //paint.setColor(Color.RED);

        // this.getHolder().setFormat(PixelFormat.TRANSLUCENT);
        // paint.setStyle(Style.FILL);
    }

    public PaintView(Context context, AttributeSet attrs) {
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

    //sets the surface back to the defaults
    public void clearVeiw() {
        currentBackgroundColor = DEFAULT_BACKGROUND_COLOR;
        paths.clear();
        invalidate(); //This function is weird because I never would have thought to use it but
        //everyone on stack overflow is confident that every time the surface is changed, you should call invalidate
    }

    @Override
    protected void onDraw(Canvas canvas) {//using a canvas instead of a surface holder
        canvas.save();

        for (FingerPaint fingerPath : paths) {
            paint.setColor(currentColor);
            paint.setStrokeWidth(strokeWidth);
        }
    }
}
