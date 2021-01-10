package com.hongliang.demo.util;

import com.hongliang.demo.bean.RecordBean;
import com.hongliang.demo.bean.Text;

import java.util.List;
import java.util.Map;

public interface RecodInterface {

    public void saveData(Map<String, Text> data);

    public void upload();

    public List<Map<String, Text>> getData();


    public List<Map<String, Text>> getData(String json);

    public String getJsonData();


    public RecordBean getDataBean();

}
