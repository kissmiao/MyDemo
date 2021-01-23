package com.hongliang.demo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.widget.ImageView;

import com.hongliang.demo.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BitmapUtil {

    /**
     * 加载网络图片
     *
     * @param url
     * @return
     */
    public static Bitmap getBitmapByUrl(String url) {
        URL imgUrl = null;
        Bitmap bitmap = null;
        try {
            imgUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) imgUrl
                    .openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }


    /**
     * 根据本地图片地址加载图片
     *
     * @param url
     * @return
     */
    public static Bitmap getBitmapByPhone(String url) {
        Bitmap bitmap = BitmapFactory.decodeFile(url);

        return bitmap;
    }


    public static Bitmap getBitmapByPhoneCompress(String url, Bitmap.CompressFormat format, int quality) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeFile(url);
        bitmap.compress(format, quality, baos);
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        bitmap = BitmapFactory.decodeStream(isBm, null, null);// 把ByteArrayInputStream数据生成图片
        return bitmap;
    }

    /**
     * 计算图片大小 适用于网络，本地等图片
     * 内存大小 = 图片长度 x 图片宽度 x 单位像素占用的字节数
     *
     * @param bitmap
     * @return
     */
    public static int getBitmapSize(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {    //API 19
            return bitmap.getAllocationByteCount();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {//API 12
            return bitmap.getByteCount();
        }
        // 在低版本中用一行的字节x高度
        return bitmap.getRowBytes() * bitmap.getHeight();                //earlier version
    }


    public static Bitmap getBitmap565(String url) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeFile(url, options);
        return bitmap;
    }


    /**
     * 根据图片路径进行压缩保存图片
     *
     * @param bitmap
     * @param format
     * @param quality
     * @param name
     * @param type
     */
    public static void saveImage(Bitmap bitmap, Bitmap.CompressFormat format, int quality, String name, String type) {
        String dir = Environment.getExternalStorageDirectory().getAbsolutePath();
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        File file = new File(dir, name + quality + type);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(format, quality, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Bitmap bitmapFactory(String url, int width, int height) {

        // 配置压缩的参数
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; //获取当前图片的边界大小，而不是将整张图片载入在内存中，避免内存溢出
        BitmapFactory.decodeFile(url, options);
        options.inJustDecodeBounds = false;
        ////inSampleSize的作用就是可以把图片的长短缩小inSampleSize倍，所占内存缩小inSampleSize的平方
        options.inSampleSize = caculateSampleSize(options, width, height);
        Bitmap bm = BitmapFactory.decodeFile(url, options); // 解码文件
        return bm;
    }

    /**
     * 计算出所需要压缩的大小
     *
     * @param options
     * @param reqWidth  我们期望的图片的宽，单位px
     * @param reqHeight 我们期望的图片的高，单位px
     * @return
     */
    private static int caculateSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int sampleSize = 1;
        int picWidth = options.outWidth;
        int picHeight = options.outHeight;
        if (picWidth > reqWidth || picHeight > reqHeight) {
            int halfPicWidth = picWidth / 2;
            int halfPicHeight = picHeight / 2;
            while (halfPicWidth / sampleSize > reqWidth || halfPicHeight / sampleSize > reqHeight) {
                sampleSize *= 2;
            }
        }
        return sampleSize;
    }

    public static void saveBitmap(Bitmap bitmap, String path) {

        FileUtils.createOrExistsFile(path);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


//private  static  void  loadResImage(Context content, ImageView imageView){
//        BitmapFactory.Options options=new BitmapFactory.Options();
//        BitmapFactory.decodeResource(c)
//}


    public static void loadResImage(Context content, ImageView imageView, int id) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeResource(content.getResources(), id, options);
        //Bitmap bitmap = BitmapFactory.decodeFile("mnt/sdcard/weixin.png", options);
        imageView.setImageBitmap(bitmap);

        Log.i("LOG", "bitmap：ByteCount = " + bitmap.getByteCount() + ":::bitmap：AllocationByteCount = " + bitmap.getAllocationByteCount());
        Log.i("LOG", "width:" + bitmap.getWidth() + ":::height:" + bitmap.getHeight());
        Log.i("LOG", "inDensity:" + options.inDensity + ":::inTargetDensity:" + options.inTargetDensity);
        Log.i("LOG", "imageview.width:" + imageView.getWidth() + ":::imageview.height:" + imageView.getHeight());
    }


}
