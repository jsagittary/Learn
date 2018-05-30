package com.learn.handler;

import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class MapDoubleTypeHandler implements UserTypeHandler<Map<Integer, Double>> {


    private Map<Integer, Double> getMap(String columnValue) {
        Map<Integer, Double> map = new HashMap<Integer, Double>();

        if (columnValue == null) {
            return map;
        }

        // JSONArray arrays = JSONArray.fromObject(columnValue);
        JSONArray arrays = JSONArray.parseArray(columnValue);
        for (int i = 0; i < arrays.size(); i++) {
            JSONArray array = arrays.getJSONArray(i);
            int key = array.getIntValue(0);
            double value = array.getDouble(1);
            map.put(key, value);
        }
        return map;
    }

    @Override
    public Map<Integer, Double> getResult(String convertParam) {
        return getMap(convertParam);
    }
}