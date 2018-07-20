package com.lx.ltuddd.imagegallerydemo.utils;

import android.os.AsyncTask;

import com.lx.ltuddd.imagegallerydemo.interfaces.ReloadImages;
import com.lx.ltuddd.imagegallerydemo.objects.ImageObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DaiPhongPC on 7/18/2018.
 */

public class ImageAsyncTask extends AsyncTask<Void, Void, List<ImageObject>> {
    private ReloadImages mReloadImages;

    public ImageAsyncTask(ReloadImages mReloadImages) {
        this.mReloadImages = mReloadImages;
    }

    @Override
    protected List<ImageObject> doInBackground(Void... voids) {
        List<ImageObject> images = new ArrayList<>();
        File folder = new File(Constant.FOLDER_IMAGE);
        LoadImage.getAllImage(folder, images);
        return images;
    }

    @Override
    protected void onPostExecute(List<ImageObject> mImages) {
        mReloadImages.loadListImage(mImages);
        this.cancel(true);
    }
}
