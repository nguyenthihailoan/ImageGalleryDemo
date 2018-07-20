package com.lx.ltuddd.imagegallerydemo.utils;

import com.lx.ltuddd.imagegallerydemo.objects.ImageObject;

import java.io.File;
import java.util.List;

/**
 * Created by DaiPhongPC on 7/18/2018.
 */

public class LoadImage {
    public static final String PNGCAP = "PNG";
    public static final String PNG = "png";
    public static final String JPGCAP = "JPG";
    public static final String JPG = "jpg";
    public static final String JPEGCAP = "jpeg";
    public static final String JPEG = "JPEG";
    public static final String GIFGCAP = "GIF";
    public static final String GIF = "gif";

    public static void getAllImage(File folder, List<ImageObject> listImage) {
        File[] listFile = folder.listFiles();
        for (File file : listFile) {
            if (file.isDirectory()) getAllImage(file, listImage);
            else addImage(file, listImage);
        }
    }

    public static void addImage(File fileImage, List<ImageObject> listImage) {
        if (checkImage(fileImage.getPath()))
            listImage.add(new ImageObject(fileImage.getName(), fileImage.getPath()));
        else return;
    }

    public static boolean checkImage(String name) {
        return name.endsWith(JPEG) ||
                name.endsWith(JPEGCAP) ||
                name.endsWith(GIFGCAP) ||
                name.endsWith(GIF) ||
                name.endsWith(PNG) ||
                name.endsWith(PNGCAP) ||
                name.endsWith(JPG) ||
                name.endsWith(JPGCAP);
    }
}
