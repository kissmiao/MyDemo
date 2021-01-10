package com.hongliang.demo.util;

import android.os.Environment;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.hongliang.demo.bean.RecordBean;
import com.hongliang.demo.bean.Text;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RecordUtils implements RecodInterface {

    public static String fileUrl = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Record.txt";


    private static volatile RecordUtils recordUtils;

    private RecordUtils() {

    }

    public static RecordUtils getInstance() {
        if (recordUtils == null) {
            synchronized (RecordUtils.class) {
                if (recordUtils == null) {
                    recordUtils = new RecordUtils();
                    FileUtils.createOrExistsFile(fileUrl);
                }
            }
        }
        return recordUtils;
    }


    /**
     * 数据在本地得是一个List集合
     *
     * @param mapData
     */
    @Override
    public void saveData(Map<String, Text> mapData) {


        RecordBean dataBean = getDataBean();
        if (dataBean.getData() != null && dataBean.getData().size() > 0) {
            dataBean.getData().add(mapData);
        } else {
            List<Map<String, Text>> list = new ArrayList<>();
            list.add(mapData);
            dataBean.setData(list);
        }
        Gson gson = new Gson();
        String json = gson.toJson(dataBean);
        IOUtils.onOutputStream2(fileUrl, json, false);
    }

    @Override
    public synchronized void upload() {


    }

    @Override
    public List<Map<String, Text>> getData() {
        String json = IOUtils.onInputStream2(fileUrl);
        if (TextUtils.isEmpty(json)) {
            return new ArrayList<>();
        }
        return getData(json);
    }

    @Override
    public List<Map<String, Text>> getData(String json) {

        List<Map<String, Text>> list1 = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArra = jsonObject.getJSONArray("data");
            if (jsonArra.length() > 0) {
                for (int i = 0; i < jsonArra.length(); i++) {
                    JSONObject jsonBean = jsonArra.getJSONObject(i);
                    Map<String, Text> map = new HashMap<>();
                    Iterator it = jsonBean.keys();
                    String key = String.valueOf(it.next().toString());
                    JSONObject value = jsonBean.getJSONObject(key);
                    Text text = new Text(value.getInt("a"), value.getInt("b"));
                    map.put(key, text);
                    list1.add(map);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list1;
    }

    @Override
    public String getJsonData() {
        return IOUtils.onInputStream2(fileUrl);
    }

    @Override
    public RecordBean getDataBean() {
        String json = IOUtils.onInputStream2(fileUrl);
        if (TextUtils.isEmpty(json)) {
            return new RecordBean(new ArrayList<>());
        } else {
            Gson gson = new Gson();
            RecordBean recordBean = gson.fromJson(json, RecordBean.class);
            return recordBean;
        }
    }


}
