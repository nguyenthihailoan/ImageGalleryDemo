package com.lx.ltuddd.imagegallerydemo.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lx.ltuddd.imagegallerydemo.R;
import com.lx.ltuddd.imagegallerydemo.adapters.AdapterImage;
import com.lx.ltuddd.imagegallerydemo.dialogs.DialogProgressBar;
import com.lx.ltuddd.imagegallerydemo.interfaces.ReloadImages;
import com.lx.ltuddd.imagegallerydemo.objects.ImageObject;
import com.lx.ltuddd.imagegallerydemo.utils.ImageAsyncTask;
import com.lx.ltuddd.imagegallerydemo.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String[] PERMISSION = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
    public static final int REQUESTCODE_PERMISSION = 100;
    private RecyclerView mRecyclerImage;
    private AdapterImage mAdapterImage;
    private List<ImageObject> mImages;
    private DialogProgressBar mDialogProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUESTCODE_PERMISSION) {
            if (permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupView();
            } else {
                finish();
            }
        }
    }

    public void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermissionM();
        } else {
            setupView();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkPermissionM() {
        if (Utils.checkPermission(getBaseContext(), PERMISSION) == PackageManager.PERMISSION_GRANTED) {
            setupView();
        } else {
            this.requestPermissions(PERMISSION, REQUESTCODE_PERMISSION);
        }
    }

    public void setupView() {
        mDialogProgressBar = new DialogProgressBar(MainActivity.this);
        mDialogProgressBar.show();
        mRecyclerImage = (RecyclerView) findViewById(R.id.recycle_image);
        mRecyclerImage.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));
        mImages = new ArrayList<>();
        mAdapterImage = new AdapterImage(getBaseContext(), mImages);
        mRecyclerImage.setAdapter(mAdapterImage);
        new ImageAsyncTask(reloadImages).execute();
    }

    private ReloadImages reloadImages = new ReloadImages() {
        @Override
        public void loadListImage(List<ImageObject> mImages) {
            mDialogProgressBar.dismiss();
            mAdapterImage.setArrImage(mImages);
            mAdapterImage.notifyDataSetChanged();
        }
    };
}
