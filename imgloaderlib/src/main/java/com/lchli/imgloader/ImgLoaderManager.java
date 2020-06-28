package com.lchli.imgloader;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.lchli.imgloader.glide.GlideImgLoader;

public final class ImgLoaderManager implements ImgLoader {
    private final ImgLoader imgLoader = new GlideImgLoader();

    private static ImgLoaderManager INS = new ImgLoaderManager();

    public static ImgLoaderManager getINS() {
        return INS;
    }

    @Override
    public void init(Context context, ImgInitConfig config) {
        imgLoader.init(context, config);
    }

    @Override
    public void display(ImageView imageView, Object source, ImgConfig config) {
        imgLoader.display(imageView, source, config);
    }

    @Override
    public void display(@NonNull ImageView imageView, @NonNull Object source) {
        display(imageView,source,null);
    }
}
