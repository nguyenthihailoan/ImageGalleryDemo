package com.lx.ltuddd.imagegallerydemo.objects;

/**
 * Created by DaiPhongPC on 7/16/2018.
 */

public class ImageObject {
    private String mName;
    private String mPath;

    public ImageObject(String name, String path) {
        this.mName = name;
        this.mPath = path;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        this.mPath = path;
    }
}
