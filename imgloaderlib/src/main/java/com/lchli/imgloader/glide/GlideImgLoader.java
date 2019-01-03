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

        if (config == null) {
            if (imgSource.getImgUri() != null) {
                requestBuilder.apply(requestOptions)
                        .transition(transitionOptions)
                        .load(imgSource.getImgUri()).into(imageView);
            } else if (imgSource.getImgResId() != null) {
                requestBuilder.apply(requestOptions)
                        .transition(transitionOptions)
                        .load(imgSource.getImgResId()).into(imageView);
            }
            return;
        }

        if (config.getResizeHeight() > 0 && config.getResizeWidth() > 0) {
            requestOptions.override(config.getResizeWidth(), config.getResizeHeight());
        }

        if (config.getPlaceHolderDrawable() != null) {
            requestOptions.placeholder(config.getPlaceHolderDrawable());
        } else if (config.getPlaceHolderResId() != null) {
            requestOptions.placeholder(config.getPlaceHolderResId());
        }

        if (!config.isGif()) {
            if (config.isCircleImage()) {
                requestOptions.transform(new CircleTransformation(config.getBorderWidth(), config.getBorderColor()));
            }
        }

        if (imgSource.getImgUri() != null) {
            requestBuilder.apply(requestOptions)
                    .transition(transitionOptions)
                    .load(imgSource.getImgUri()).into(imageView);
        } else if (imgSource.getImgResId() != null) {
            requestBuilder.apply(requestOptions)
                    .transition(transitionOptions)
                    .load(imgSource.getImgResId()).into(imageView);
        }
    }
}
