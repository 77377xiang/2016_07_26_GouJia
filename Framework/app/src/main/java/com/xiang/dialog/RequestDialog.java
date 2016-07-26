package com.xiang.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.xiang.framework.R;

/**
 * Created by Administrator on 2016/7/9.
 */
public class RequestDialog extends Dialog  {
    TextView textView;
    public RequestDialog(Context context, int themeResId) {
        super(context, themeResId);
    }
    public RequestDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_request, null);
        setContentView(view);
        textView=(TextView) view.findViewById(R.id.textView);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = ((Activity) context).getWindowManager()
                .getDefaultDisplay().getWidth() * 5 / 6;
        window.setAttributes(params);
    }
    public void setDialogString(String string) {
        if (!string.equals("")){
            textView.setText(string);
        }
    }
}
