package com.hongliang.demo.otherActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hongliang.demo.R;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok);

        //    requestBannerApi();
    }


    /**
     * 获取轮播图接口
     * GET请求
     * https://www.jianshu.com/p/f1ab6182d6fc
     */
    private void requestBannerApi() {
        //1.第一步创建OkHttpClient对象
        final OkHttpClient okHttpClient = new OkHttpClient();

        String url = "http://www.baidu.com/";

        //2. 如果需要拼接参数 （一般有参数的都会用Post请求，除非参数不重要）
//        Map<String, String> params = new HashMap<>();
//        params.put("movieid", "246363");
//        params.put("limit", "3");
//        params.put("offset", "5");
//        url = appendParams(url,params);

        //3.第二步创建request
        Request.Builder builder = new Request.Builder();
        final Request request = builder.url(url)
                .get()
                .build();

        //4.新建一个Call对象
        final Call call = okHttpClient.newCall(request);

        //5.同步请求网络execute()
      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    if(response.isSuccessful()){
                        Log.e("Benner请求成功同步=",response.body().string());
                    }else{
                        throw new IOException("Unexpected code " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();*/


        //6.异步请求网络enqueue(Callback)
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "Benner请求失败=" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.e("TAG", "Benner请求成功异步=" + json);
            }
        });

    }

    /**
     * 拼接参数
     *
     * @param url
     * @param params
     * @return
     */
    private String appendParams(String url, Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(url + "?");
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                sb.append(key).append("=").append(params.get(key)).append("&");
            }
        }
        sb = sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
