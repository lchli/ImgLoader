package com.lchli.imgloader;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018/12/29.
 */

public class ImgConfig {
    private int resizeWidth;
    private int resizeHeight;
    private Integer placeHolderResId;
    private Drawable placeHolderDrawable;
    private boolean isGif = false;
    private int borderColor = Color.BLACK;
    private float borderWidth;
    private boolean circleImage = false;

    public static ImgConfig create() {
        return new ImgConfig();
    }

    public Drawable getPlaceHolderDrawable() {
        return placeHolderDrawable;
    }

    public int getResizeHeight() {
        return resizeHeight;
    }

    public int getResizeWidth() {
        return resizeWidth;
    }

    public Integer getPlaceHolderResId() {
        return placeHolderResId;
    }

    public ImgConfig setPlaceHolderDrawable(Drawable placeHolderDrawable) {
        this.placeHolderDrawable = placeHolderDrawable;
        return this;
    }

    public ImgConfig setPlaceHolderResId(Integer placeHolderResId) {
        this.placeHolderResId = placeHolderResId;
        return this;
    }

    public ImgConfig setResizeHeight(int resizeHeight) {
        this.resizeHeight = resizeHeight;
        return this;
    }

    public ImgConfig setResizeWidth(int resizeWidth) {
        this.resizeWidth = resizeWidth;
        return this;
    }

    public ImgConfig setGif(boolean gif) {
        isGif = gif;
        return this;
    }

    public boolean isGif() {
        return isGif;
    }

    public boolean isCircleImage() {
        return circleImage;
    }

    public ImgConfig setCircleImage(boolean circleImage) {
        this.circleImage = circleImage;
        return this;
    }

    public ImgConfig setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public int getBorderColor() {
        return borderColor;
    }

    public ImgConfig setBorderWidth(float borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public float getBorderWidth() {
        return borderWidth;
    }
}
