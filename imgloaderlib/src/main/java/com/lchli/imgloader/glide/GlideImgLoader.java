package com.lchli.imgloader.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.lchli.imgloader.ImgConfig;
import com.lchli.imgloader.ImgInitConfig;
import com.lchli.imgloader.ImgLoader;


public class GlideImgLoader implements ImgLoader {

    @Override
    public void init(Context context, ImgInitConfig config) {
    }

    @Override
    public void display(@NonNull ImageView imageView, @NonNull Object source) {
        display(imageView, source, null);
    }

    @Override
    public void display(ImageView imageView, Object source, ImgConfig config) {

        if (source == null) {
            return;
        }

        if (imageView == null) {
            return;
        }

        Context context = imageView.getContext();
        if (!isValidContextForGlide(context)) {
            return;
        }

        if (config == null) {
            config = new ImgConfig();
        }

        final RequestManager requestManager = Glide.with(context);
        RequestBuilder<Drawable> requestBuilder;

        if (source instanceof String) {
            requestBuilder = requestManager.load((String) source);
        } else if (source instanceof Uri) {
            requestBuilder = requestManager.load((Uri) source);
        } else if (source instanceof Integer) {
            requestBuilder = requestManager.load((Integer) source);
        } else {
            return;
        }

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);

        if (config.getPlaceHolderDrawable() != null) {
            requestOptions.placeholder(config.getPlaceHolderDrawable());
        } else if (config.getPlaceHolderResId() != null) {
            requestOptions.placeholder(config.getPlaceHolderResId());
        }

        if (config.getRoundCornerRadius() != null) {
            requestOptions.transform(new GlideRoundTransform(config.getRoundCornerRadius()));
        } else if (config.isCircleImage()) {
            requestOptions.circleCrop();
        }

        if (config.getResizeHeight() > 0 && config.getResizeWidth() > 0) {
            requestBuilder.override(config.getResizeWidth(), config.getResizeHeight());
        }

        requestBuilder
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }


    private static boolean isValidContextForGlide(final Context context) {
        if (context == null) {
            return false;
        }
        if (context instanceof Activity) {
            final Activity activity = (Activity) context;
            if (activity.isDestroyed() || activity.isFinishing()) {
                return false;
            }
        }

        return true;
    }
}
