package com.learn.handler;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ListLongTypeHandler implements UserTypeHandler<List<Long>> {

    private List<Long> getLongList(String columnValue) {
        List<Long> list = new ArrayList<Long>();
        if (columnValue == null || columnValue.isEmpty()) {
            return list;
        }
        JSONArray array = JSONArray.parseArray(columnValue);
        for (int i = 0; i < array.size(); i++) {
            long value = array.getLong(i);
            list.add(value);
        }
        return list;
    }

    private String listToString(List<Long> parameter) {
        JSONArray arrays = null;
        if (parameter == null || parameter.isEmpty()) {
            arrays = new JSONArray();
            return arrays.toString();
        }

        // arrays = JSONArray.fromObject(parameter);
        return JSONArray.toJSONString(parameter);
    }

    @Override
    public List<Long> getResult(String convertParam) {
        return getLongList(convertParam);
    }
}
