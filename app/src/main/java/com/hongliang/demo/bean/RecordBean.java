package com.hongliang.demo.bean;

import java.util.List;
import java.util.Map;

public class RecordBean {

    private List<Map<String , Text>>  data;

    public List<Map<String, Text>> getData() {
        return data;
    }

    public void setData(List<Map<String, Text>> data) {
        this.data = data;
    }

    public RecordBean(List<Map<String, Text>> data) {
        this.data = data;
    }
}
