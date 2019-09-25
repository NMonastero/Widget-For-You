package com.example.widgetforyouultra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity  {

    private Spinner colorMenu = null;

    private Spinner stickerMenu = null;

    private boolean drawBall = true;

    private LinearLayout canvasLayout = null;

    private PaintView paintView;

    MySurface customSurfaceView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorMenu = findViewById(R.id.colorMenu);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        String[] optionsC = {"Sunset", "City","Graph"};
        ArrayAdapter<String> adapterC = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, optionsC);
        colorMenu.setAdapter(adapterC);
        colorMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        PaintView.currentColor = R.color.red;
                        Paint paint = new Paint();
                        customSurfaceView.setPaint(paint);
                        //customSurfaceView.drawBall();
                        customSurfaceView.sunSet();
                        break;
                    case 1:
                        PaintView.currentColor = R.color.orange;
                        paint = new Paint();
                        customSurfaceView.setPaint(paint);
                        customSurfaceView.city();
                        break;
                    case 2:
                        paint = new Paint();
                        customSurfaceView.setPaint(paint);
                        customSurfaceView.graph();
                        PaintView.currentColor = R.color.green;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        setTitle("SurfaceView");

        initControls();

        // Hide the app title bar.
        getSupportActionBar().hide();

        // Make app full screen to hide top status bar.
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Create custom surfaceview object.
        customSurfaceView = new MySurface(getApplicationContext());

        // Set this as the onTouchListener to process custom surfaceview ontouch event.
        //customSurfaceView.setOnTouchListener(this);

        // Add the custom surfaceview object to the layout.
        canvasLayout.addView(customSurfaceView);

    }

    /* Initialise ui controls. */
    private void initControls() {
        if (colorMenu == null) {
            colorMenu = (Spinner) findViewById(R.id.colorMenu);
        }

        if (stickerMenu == null) {
            stickerMenu = (Spinner) findViewById(R.id.stickerMenu);
        }

        // This layout is used to contain custom surfaceview object.
        if (canvasLayout == null) {
            canvasLayout = (LinearLayout) findViewById(R.id.customViewLayout);
        }
    }

    /* If user finger touch the surfaceview object. */
//       @Override
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//
//        // If user touch the custom SurfaceView object.
//        if(view instanceof SurfaceView) {
//            view.invalidate();
//
//            float x = motionEvent.getX();
//
//            float y = motionEvent.getY();
//
//            customSurfaceView.setCircleX(x);
//
//            customSurfaceView.setCircleY(y);
//
//            if (drawBall) {
//                // Create and set a red paint to custom surfaceview.
//                Paint paint = new Paint();
//                paint.setColor(Color.RED);
//                customSurfaceView.setPaint(paint);
//
//                customSurfaceView.drawBall();
//            } else {
//                // Create and set a green paint to custom surfaceview.
//                Paint paint = new Paint();
//                paint.setColor(Color.GREEN);
//                customSurfaceView.setPaint(paint);
//                customSurfaceView.drawRect();
//            }
//
//            // Tell android os the onTouch event has been processed.
//            return true;
//        }else
//        {
//            // Tell android os the onTouch event has not been processed.
//            return false;
//        }
//    }

}

