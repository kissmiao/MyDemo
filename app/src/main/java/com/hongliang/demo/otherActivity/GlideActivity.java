package com.hongliang.demo.otherActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hongliang.demo.R;

public class GlideActivity extends Activity {

    private ImageView mIvGlide;
    private String url = "https://cn.bing.com/th?id=OHR.GobiSheep_EN-CN3893154532_1920x1080.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        initView();
        String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/WeiXin/";


        Log.i("LOG", "=======" + dir);

        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.avastar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher)
                .into(mIvGlide);

        //  GlideApp.with(this).load(url).into(mIvGlide);

      /*  Glide.with(this).load(url).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                Log.i("LOG","===============onLoadFailed");
                return false;

            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                Log.i("LOG","=================onResourceReady");
                return false;
            }
        }).into(mIvGlide);*/


    }


    private void initView() {
        mIvGlide = (ImageView) findViewById(R.id.iv_glide);
    }
}
