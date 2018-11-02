package com.example.jin.myapplication;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class H5CongratulationDialogNew extends Dialog {

    private CongratulationDialogListener listener;
    private String dialogTitle;
    private int type;
    public H5CongratulationDialogNew(Context context,int type, CongratulationDialogListener listener) {
        super(context);
        this.listener = listener;
        this.type = type;
        init();
    }

    public interface CongratulationDialogListener {
        void closeDialog();
    }
    protected void init() {
        Window win = this.getWindow();
        win.requestFeature(Window.FEATURE_NO_TITLE);
        onCreate();
        win.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = win.getAttributes();

        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int height = dm.heightPixels;       // 屏幕高度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
        int dialogWidth = width - MainActivity.dip2px(getContext(),120f);
        float scal = 343f/265f;
        float testHeight = dialogWidth*scal;
        lp.width = dialogWidth;
        lp.height = (int)testHeight;
        lp.gravity = Gravity.CENTER_VERTICAL;
        win.setAttributes(lp);
        win.setBackgroundDrawableResource(android.R.color.transparent);
    }
    void onCreate() {
        switch (type){
            case 1:
                setContentView(R.layout.dialog_congratulation_h5_new);
                break;

            case 2:
                setContentView(R.layout.layoutskip);
                break;

            case 3:
                setContentView(R.layout.layouttext);
                break;
        }

    }
}