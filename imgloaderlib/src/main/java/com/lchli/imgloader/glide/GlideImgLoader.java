package com.lchli.imgloader.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.lchli.imgloader.ImgConfig;
import com.lchli.imgloader.ImgInitConfig;
import com.lchli.imgloader.ImgLoader;
import com.lchli.imgloader.ImgSource;
import com.lchli.imgloader.transformation.CircleTransformation;

/**
 * Created by Administrator on 2019/1/3.
 */

public class GlideImgLoader implements ImgLoader {
    @Override
    public void init(Context context, ImgInitConfig config) {

    }

    @Override
    public void display(ImageView imageView, ImgSource imgSource, @Nullable ImgConfig config) {
        if (imgSource == null || imageView == null) {
            return;
        }

        RequestManager requestManager = Glide.with(imageView);
        RequestBuilder<Drawable> requestBuilder = requestManager.asDrawable();
        RequestOptions requestOptions = new RequestOptions();
        DrawableTransitionOptions transitionOptions = DrawableTransitionOptions.withCrossFade(0);
        requestBuilder = requestBuilder.transition(transitionOptions);

        if (imgSource.getImgUri() != null) {
            requestBuilder = requestBuilder.load(imgSource.getImgUri());
        } else if (imgSource.getImgResId() != null) {
            requestBuilder = requestBuilder.load(imgSource.getImgResId());
        } else if (imgSource.getImgFile() != null) {
            requestBuilder = requestBuilder.load(imgSource.getImgFile());
        } else if (imgSource.getImgPath() != null) {
            requestBuilder = requestBuilder.load(imgSource.getImgPath());
        }

        if (config == null) {
            requestBuilder.apply(requestOptions)
                    .into(imageView);
            return;
        }

        if (config.getResizeHeight() > 0 && config.getResizeWidth() > 0) {
            requestOptions = requestOptions.override(config.getResizeWidth(), config.getResizeHeight());
        }

        if (config.getPlaceHolderDrawable() != null) {
            requestOptions = requestOptions.placeholder(config.getPlaceHolderDrawable());
        } else if (config.getPlaceHolderResId() != null) {
            requestOptions = requestOptions.placeholder(config.getPlaceHolderResId());
        }

        if (!config.isGif()) {
            if (config.isCircleImage()) {
                requestOptions = requestOptions.transform(new CircleTransformation(config.getBorderWidth(), config.getBorderColor()));
            }
        }

        requestBuilder.apply(requestOptions)
                .into(imageView);
    }
}
