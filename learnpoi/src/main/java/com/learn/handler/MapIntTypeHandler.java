package com.learn.handler;

import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class MapIntTypeHandler implements UserTypeHandler<Map<Integer, Integer>> {


    private String mapToString(Map<Integer, Integer> parameter) {
        JSONArray arrays = new JSONArray();
        if (parameter == null || parameter.isEmpty()) {
            return arrays.toJSONString();
        }

        for (Map.Entry<Integer, Integer> entry : parameter.entrySet()) {
            JSONArray array = new JSONArray();
            array.add(entry.getKey());
            array.add(entry.getValue());
            arrays.add(array);
        }

        return arrays.toJSONString();
    }

    private Map<Integer, Integer> getMap(String columnValue) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (columnValue == null) {
            return map;
        }

        if (columnValue.startsWith("[[")) {
            JSONArray arrays = JSONArray.parseArray(columnValue);
            for (int i = 0; i < arrays.size(); i++) {
                JSONArray array = arrays.getJSONArray(i);
                int key = array.getIntValue(0);
                int value = array.getIntValue(1);
                map.put(key, value);
            }
        }

        else if (columnValue.startsWith("[")) {
            JSONArray array = JSONArray.parseArray(columnValue);
            map.put(array.getInteger(0), array.getInteger(1));
        }

        return map;
    }

    @Override
    public Map<Integer, Integer> getResult(String convertParam) {
        return getMap(convertParam);
    }
}
