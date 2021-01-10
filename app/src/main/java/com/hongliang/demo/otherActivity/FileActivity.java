package com.hongliang.demo.otherActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;


import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hongliang.demo.R;
import com.hongliang.demo.bean.RecordBean;
import com.hongliang.demo.bean.Text;
import com.hongliang.demo.util.FileUtils;
import com.hongliang.demo.util.IOUtils;
import com.hongliang.demo.util.RecordUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 清除缓存：我们知道应用程序在运行过程中需要经过很多过程，比如读入程序，计算，输入输出等等，这些过程中肯定会产生很多的数据，它们在内存中，以供程序运行时调用。所以清除缓存清除的是APP运行过程中所产生的临时数据。
 * 清除数据：清除数据才是真正的删除了我们保存在文件中的数据（永久性数据，如果不人为删除的话会一直保存在文件中）例如当我们在设置里面清除了某个应用的数据，那么/data/user/0/packname/和/storage/emulated/0/Android/data/packname/下的文件里面的数据会全部删除，包括cache，files，lib，shared_prefs等等
 */


/**
 * getFilesDir().getAbsolutePath()和getExternalFilesDir(“”).getAbsolutePath()
 * 一个在内部存储里面，一个在外部存储里面，这是它们的区别。
 * 它们的共同点:就是它们的路径都带有包名，表明是这个APP的专属文件，这类文件应该是随着app卸载而一起被删除的，并且我们在设置里面清除该应用的数据时，这两个文件夹下的数据都会被清除
 */


//https://blog.csdn.net/u010937230/article/details/73303034?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2.not_use_machine_learn_pai&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2.not_use_machine_learn_pai
public class FileActivity extends Activity {


    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        textView=findViewById(R.id.text);
        getInside();
        getExternal();
        getOther();

        // SharedPreferences
        //主线程那就是同步运行
        //开线程就是异步执行

        //添加一次，就调用一次上传 是异步（加上上传标识符号）
        //再添加同步
        //synchronized 是保证线程同步该方法的是处于等待
        //上传的同时 再上传， 上传方法加同步，就等待，上传成功可以使用对列将数据清除
        //上传数据可以放在service 中，

        //埋点使用 key  value

        Text text = new Text(1, 2);
        Map<String, Text> map1 = new HashMap<>();
        map1.put("2021", text);
        RecordUtils.getInstance().saveData(map1);
        RecordUtils.getInstance().saveData(map1);
        RecordUtils.getInstance().saveData(map1);
        textView.setText(RecordUtils.getInstance().getJsonData());

//        String fileUrl = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.txt";
//
//        String mes = "hello,world";
//        byte[] b = mes.getBytes();
//
//        ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
//        try {
//
//            FileOutputStream fileOutputStream = new FileOutputStream(fileUrl);
//            byteArrayInputStream.write(b);
//            byteArrayInputStream.writeTo(fileOutputStream);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                byteArrayInputStream.flush();
//                byteArrayInputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }




    }

    private synchronized void getdata() {

    }


    /**
     * 内部存储 4.4  真机
     */
    private void getInside() {

        Environment.getDataDirectory();//   /data  这个方法是获取内部存储的根路径
        getFilesDir().getAbsolutePath();//  /data/data/com.hongliang.demo/files
        getCacheDir().getAbsolutePath();//  /data/data/com.hongliang.demo/cache
        getDir("myFile", MODE_PRIVATE).getAbsolutePath();//  /data/data/com.hongliang.demo/app_myFile  获取某个应用在内部存储中的自定义路径


        Log.e("LOG", "Environment.getDataDirectory():" + Environment.getDataDirectory());
        Log.e("LOG", "getFilesDir().getAbsolutePath():" + getFilesDir().getAbsolutePath());
        Log.e("LOG", "getCacheDir().getAbsolutePath():" + getCacheDir().getAbsolutePath());
        Log.e("LOG", "getDir(\"myFile\", MODE_PRIVATE).getAbsolutePath():" + getDir("myFile", MODE_PRIVATE).getAbsolutePath());


    }


    /**
     * 外部存储 4.4 真机
     */
    private void getExternal() {
        Environment.getExternalStorageDirectory().getAbsolutePath();//   /storage/emulated/0
        Environment.getExternalStoragePublicDirectory("").getAbsolutePath();//  /storage/emulated/0
        getExternalFilesDir("").getAbsolutePath();// /storage/emulated/0/Android/data/com.hongliang.demo/files
        getExternalCacheDir().getAbsolutePath();//  /storage/emulated/0/Android/data/com.hongliang.demo/cache

        Log.e("LOG", "Environment.getExternalStorageDirectory().getAbsolutePath():" + Environment.getExternalStorageDirectory().getAbsolutePath());

        Log.e("LOG", "Environment.getExternalStoragePublicDirectory(\"\").getAbsolutePath():" + Environment.getExternalStoragePublicDirectory("").getAbsolutePath());

        Log.e("LOG", "getExternalFilesDir(\"\").getAbsolutePath():" + getExternalFilesDir("").getAbsolutePath());

        Log.e("LOG", "getExternalCacheDir().getAbsolutePath():" + getExternalCacheDir().getAbsolutePath());

        // 后面两个 4.4以前的系统中getExternalFilesDir(“”)和getExternalCacheDir()将返回null，如果是4.4及以上的系统才会返回上面的结果
        // 4.4之前使用这个获取外置SD卡 getExternalFilesDirs(Environment.MEDIA_MOUNTED)
    }


    private void getOther() {
        Environment.getDownloadCacheDirectory();// /cache
        Environment.getRootDirectory();// /system

        Log.e("LOG", " Environment.getDownloadCacheDirectory():" + Environment.getDownloadCacheDirectory());
        Log.e("LOG", "   Environment.getRootDirectory():" + Environment.getRootDirectory());
    }


}
