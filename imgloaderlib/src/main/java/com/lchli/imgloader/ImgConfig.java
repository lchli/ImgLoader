package com.lchli.imgloader;

import android.graphics.drawable.Drawable;

public class ImgConfig {
    private int resizeWidth;
    private int resizeHeight;
    private Integer placeHolderResId;
    private Drawable placeHolderDrawable;
    private Float roundCornerRadius;
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

    public ImgConfig setRoundCornerRadius(float roundCornerRadius) {
        this.roundCornerRadius = roundCornerRadius;
        return this;
    }

    public Float getRoundCornerRadius() {
        return roundCornerRadius;
    }

    public ImgConfig setCircleImage(boolean circleImage) {
        this.circleImage = circleImage;
        return this;
    }


    public boolean isCircleImage() {
        return circleImage;

    }
}
