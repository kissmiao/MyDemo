package com.hongliang.demo.otherActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hongliang.demo.R;

import me.zhouzhuo810.cameracardcrop.CameraConfig;
import me.zhouzhuo810.cameracardcrop.CropActivity;

public class GlideActivity extends Activity {

    private ImageView mIvGlide;
    private String url = "https://cn.bing.com/th?id=OHR.GobiSheep_EN-CN3893154532_1920x1080.jpg";

    private ImageView iv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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


        findViewById(R.id.bt_touch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GlideActivity.this, CropActivity.class);
                intent.putExtra(CameraConfig.RATIO_WIDTH, 855);
                intent.putExtra(CameraConfig.RATIO_HEIGHT, 541);
                intent.putExtra(CameraConfig.PERCENT_LARGE, 0.8f);
                intent.putExtra(CameraConfig.MASK_COLOR, 0x2f000000);
                intent.putExtra(CameraConfig.RECT_CORNER_COLOR, 0xff00ff00);
                intent.putExtra(CameraConfig.TEXT_COLOR, 0xffffffff);
                intent.putExtra(CameraConfig.HINT_TEXT, "请将方框对准证件拍照");
                intent.putExtra(CameraConfig.IMAGE_PATH, Environment.getExternalStorageDirectory().getAbsolutePath() + "/CameraCardCrop/" + System.currentTimeMillis() + ".jpg");
                startActivityForResult(intent, 0x01);
            }
        });

    }


    private void initView() {
        mIvGlide = (ImageView) findViewById(R.id.iv_glide);

        iv_image = findViewById(R.id.iv_image);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 0x01) {
                String path = data.getStringExtra(CameraConfig.IMAGE_PATH);
                iv_image.setImageURI(Uri.parse("file://" + path));
            }
        }
    }
}
