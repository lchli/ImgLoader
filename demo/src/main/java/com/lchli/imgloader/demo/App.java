package com.lchli.imgloader.demo;

import android.app.Application;

import com.lchli.imgloader.ImgConfig;
import com.lchli.imgloader.ImgLoaderManager;
import com.lchli.imgloader.ImgSource;

/**
 * Created by Administrator on 2018/12/29.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImgLoaderManager.getINS().init(this, null);


        ImgLoaderManager.getINS().display(null, ImgSource.create(), ImgConfig.create());
    }
}
