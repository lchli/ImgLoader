package com.lchli.imgloader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;


public interface ImgLoader {

    void init(@NonNull Context context, ImgInitConfig config);

    void display(@NonNull ImageView imageView, @NonNull Object source, ImgConfig config);

    void display(@NonNull ImageView imageView, @NonNull Object source);
}
