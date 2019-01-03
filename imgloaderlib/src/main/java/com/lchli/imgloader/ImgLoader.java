package com.lchli.imgloader;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018/12/29.
 */

public interface ImgLoader {

    void init(Context context,ImgInitConfig config);

    void display(ImageView imageView, ImgSource source, @Nullable ImgConfig config);
}
