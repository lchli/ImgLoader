package com.lchli.imgloader;

import android.content.Context;
import android.widget.ImageView;

import com.lchli.imgloader.glide.GlideImgLoader;

/**
 * Created by Administrator on 2018/12/29.
 */

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
    public void display(ImageView imageView, ImgSource source, ImgConfig config) {
        imgLoader.display(imageView, source, config);
    }
}
