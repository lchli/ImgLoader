package com.lchli.imgloader.glide;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

@GlideModule
public class MyAppGlideModule extends AppGlideModule {
    private static final String TAG = "MyAppGlideModule";

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
//        BAFImageLoader.Setting setting = BAFImageLoader.instance().setting();
//        if (setting == null) {
//            BAFLog.e(IMG, TAG, "applyOptions::baf image loader is not init,skip===================");
//            return;
//        }
//
//        builder.setMemoryCache(new LruResourceCache(setting.getMemoryCacheSize()));
//        builder.setDiskCache(new DiskLruCacheFactory(setting.getDiskCacheFolder(), setting.getDiskCacheSize()));
//        builder.setLogLevel(setting.isLog() ? Log.DEBUG : Log.ERROR);
    }
}