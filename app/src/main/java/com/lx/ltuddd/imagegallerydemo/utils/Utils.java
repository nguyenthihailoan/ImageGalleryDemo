package com.lx.ltuddd.imagegallerydemo.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

/**
 * Created by DaiPhongPC on 7/18/2018.
 */

public class Utils {
    public static int checkPermission(Context context, String[] permissions) {
        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (String permission : permissions) {
            permissionCheck += ContextCompat.checkSelfPermission(context, permission);
        }
        return permissionCheck;
    }
}
