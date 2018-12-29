package com.lchli.imgloader;

import android.net.Uri;

/**
 * Created by Administrator on 2018/12/29.
 */

public class ImgSource {
    private String imgPath;
    private Uri imgUri;
    private int imgResId;


    public static ImgSource create() {
        return new ImgSource();
    }

    public ImgSource setImgPath(String imgPath) {
        this.imgPath = imgPath;
        return this;
    }

    public ImgSource setImgResId(int imgResId) {
        this.imgResId = imgResId;
        return this;
    }

    public ImgSource setImgUri(Uri imgUri) {
        this.imgUri = imgUri;
        return this;
    }

    public int getImgResId() {
        return imgResId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public Uri getImgUri() {
        return imgUri;
    }
}
