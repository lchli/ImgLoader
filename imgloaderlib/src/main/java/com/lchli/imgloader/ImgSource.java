package com.lchli.imgloader;

import android.net.Uri;

import java.io.File;

/**
 * Created by Administrator on 2018/12/29.
 */

public class ImgSource {
    private Uri imgUri;
    private Integer imgResId;
    private File imgFile;
    private String imgPath;


    public static ImgSource create() {
        return new ImgSource();
    }


    public ImgSource setImgResId(int imgResId) {
        this.imgResId = imgResId;
        return this;
    }

    public ImgSource setImgUri(Uri imgUri) {
        this.imgUri = imgUri;
        return this;
    }

    public ImgSource setImgFile(File imgFile) {
        this.imgFile = imgFile;
        return this;
    }

    public ImgSource setImgPath(String imgPath) {
        this.imgPath = imgPath;
        return this;
    }

    public Integer getImgResId() {
        return imgResId;
    }


    public Uri getImgUri() {
        return imgUri;
    }

    public File getImgFile() {
        return imgFile;
    }

    public String getImgPath() {
        return imgPath;
    }
}
