package com.learn.handler;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapListTypeHandler implements UserTypeHandler<Map<Integer, List<Integer>>> {


    private Map<Integer, List<Integer>> getMapList(String columnValue) {
        Map<Integer, List<Integer>> mapList = new HashMap<Integer, List<Integer>>();
        if (columnValue == null || columnValue.isEmpty()) {
            return mapList;
        }

        // JSONArray arrays = JSONArray.fromObject(columnValue);
        JSONArray arrays = JSONArray.parseArray(columnValue);
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> list = new ArrayList<Integer>();
            JSONArray array = arrays.getJSONArray(i);
            for (int j = 0; j < array.size(); j++) {
                list.add(array.getIntValue(j));
            }

            if (!list.isEmpty()) {
                mapList.put(list.get(0), list);
            }
        }

        return mapList;
    }

    @Override
    public Map<Integer, List<Integer>> getResult(String convertParam) {
        return getMapList(convertParam);
    }
}
