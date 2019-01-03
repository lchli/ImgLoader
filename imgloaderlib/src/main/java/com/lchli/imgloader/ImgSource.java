package com.lchli.imgloader;

import android.net.Uri;

/**
 * Created by Administrator on 2018/12/29.
 */

public class ImgSource {
    private Uri imgUri;
    private Integer imgResId;


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

    public Integer getImgResId() {
        return imgResId;
    }


    public Uri getImgUri() {
        return imgUri;
    }
}
