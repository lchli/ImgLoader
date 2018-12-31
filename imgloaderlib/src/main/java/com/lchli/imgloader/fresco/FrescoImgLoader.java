package com.lchli.imgloader.fresco;

import android.content.Context;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lchli.imgloader.ImgConfig;
import com.lchli.imgloader.ImgInitConfig;
import com.lchli.imgloader.ImgLoader;
import com.lchli.imgloader.ImgSource;

/**
 * Created by Administrator on 2018/12/29.
 */

public class FrescoImgLoader implements ImgLoader {

    @Override
    public void init(Context context, ImgInitConfig config) {
        Fresco.initialize(context);
    }

    @Override
    public void display(ImageView imageView, ImgSource source, ImgConfig config) {

        if (source == null) {
            return;
        }

        if (!(imageView instanceof SimpleDraweeView)) {
            return;
        }

        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) imageView;
        ImageRequestBuilder requestBuilder = ImageRequestBuilder.newBuilderWithSource(source.getImgUri());

        if (config == null) {
            simpleDraweeView.setController(
                    Fresco.newDraweeControllerBuilder()
                            .setOldController(simpleDraweeView.getController())
                            .setImageRequest(requestBuilder.build())
                            .build());
            return;
        }


        if (config.getResizeHeight() > 0 && config.getResizeWidth() > 0) {
            requestBuilder.setResizeOptions(new ResizeOptions(config.getResizeWidth(), config.getResizeHeight()));
        }
        if (config.getPlaceHolderDrawable() != null) {
            simpleDraweeView.getHierarchy().setPlaceholderImage(config.getPlaceHolderDrawable());
        } else if (config.getPlaceHolderResId() != null) {
            simpleDraweeView.getHierarchy().setPlaceholderImage(config.getPlaceHolderResId());
        }

        simpleDraweeView.setController(
                Fresco.newDraweeControllerBuilder()
                        .setOldController(simpleDraweeView.getController())
                        .setImageRequest(requestBuilder.build())
                        .build());
    }
}
