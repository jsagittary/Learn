package com.learn.handler;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ListStringTypeHandler implements UserTypeHandler<List<String>> {
    private List<String> getLongList(String columnValue) {
        List<String> list = new ArrayList<String>();
        if (columnValue == null || columnValue.isEmpty()) {
            return list;
        }

        // JSONArray array = JSONArray.fromObject(columnValue);
        JSONArray array = JSONArray.parseArray(columnValue);
        for (int i = 0; i < array.size(); i++) {
            String value = array.getString(i);
            list.add(value);
        }
        return list;
    }

    private String listToString(List<String> parameter) {
        JSONArray arrays = null;
        if (parameter == null || parameter.isEmpty()) {
            arrays = new JSONArray();
            return arrays.toString();
        }

        // arrays = JSONArray.fromObject(parameter);
        return JSONArray.toJSONString(parameter);
    }

    @Override
    public List<String> getResult(String convertParam) {
        return getLongList(convertParam);
    }
}
