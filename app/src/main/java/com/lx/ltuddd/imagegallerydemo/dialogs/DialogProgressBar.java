package com.lx.ltuddd.imagegallerydemo.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.lx.ltuddd.imagegallerydemo.R;

/**
 * Created by DaiPhongPC on 7/20/2018.
 */

public class DialogProgressBar extends AlertDialog {
    private Context mContext;

    public DialogProgressBar(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.setCancelable(false);
        setContentView(R.layout.dialog_progressbar);
    }
}
