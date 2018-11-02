package com.example.jin.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout redLiner,blueLiner;
    private RelativeLayout invitaionTv;
    private RelativeLayout KachingTask;
    private LinearLayout myWallet;
    int screenWidth;
    int screenHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAndroiodScreenProperty();
        redLiner = (LinearLayout)findViewById(R.id.redliner);
        blueLiner = (LinearLayout)findViewById(R.id.blueliner);

        invitaionTv = findViewById(R.id.invitaionTv);
        KachingTask = findViewById(R.id.KachingTask);
        myWallet = findViewById(R.id.myWallet);

        final LinearLayout.LayoutParams redParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        final LinearLayout.LayoutParams blueParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        int widthOne = screenWidth/4;

        int leftMargin = widthOne/2;

        int blueLeftMargin = widthOne+leftMargin;

        redParams.setMargins(leftMargin,20,0,0);
        blueParams.setMargins(blueLeftMargin,20,0,0);

        redLiner.setLayoutParams(redParams);
        int redWidth = redLiner.getWidth();
        blueLiner.setLayoutParams(blueParams);

        invitaionTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                H5CongratulationDialogNew h5CongratulationDialogNew = new H5CongratulationDialogNew(MainActivity.this,1, new H5CongratulationDialogNew.CongratulationDialogListener() {
                    @Override
                    public void closeDialog() {
                    }
                });
                h5CongratulationDialogNew.show();
            }
        });

        KachingTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                H5CongratulationDialogNew h5CongratulationDialogNew = new H5CongratulationDialogNew(MainActivity.this,2, new H5CongratulationDialogNew.CongratulationDialogListener() {
                    @Override
                    public void closeDialog() {
                    }
                });
                h5CongratulationDialogNew.show();
            }
        });

        myWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                H5CongratulationDialogNew h5CongratulationDialogNew = new H5CongratulationDialogNew(MainActivity.this,3, new H5CongratulationDialogNew.CongratulationDialogListener() {
                    @Override
                    public void closeDialog() {
                    }
                });
                h5CongratulationDialogNew.show();
            }
        });


    }

    public void getAndroiodScreenProperty() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int height = dm.heightPixels;       // 屏幕高度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = dm.densityDpi;     // 屏幕密度dpi（120 / 160 / 240）
        // 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        screenWidth = width;  // 屏幕宽度(dp)
        int widthdp = (int)(width/density);
        screenHeight = (int) (height / density);// 屏幕高度(dp)


        Log.d("h_bl", "屏幕宽度（像素）：" + width);
        Log.d("h_bl", "屏幕高度（像素）：" + height);
        Log.d("h_bl", "屏幕密度（0.75 / 1.0 / 1.5）：" + density);
        Log.d("h_bl", "屏幕密度dpi（120 / 160 / 240）：" + densityDpi);
        Log.d("h_bl", "屏幕宽度（dp）：" + screenWidth);
        Log.d("h_bl", "屏幕高度（dp）：" + screenHeight);
    }
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    }
