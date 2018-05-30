package com.learn.handler;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapListType2Handler implements UserTypeHandler<Map<Integer, List<Integer>>> {


    private Map<Integer, List<Integer>> getMapList(String columnValue) {
        Map<Integer, List<Integer>> mapList = new HashMap<Integer, List<Integer>>();
        if (columnValue == null || columnValue.isEmpty()) {
            return mapList;
        }

        // JSONArray arrays = JSONArray.fromObject(columnValue);
        JSONArray arrays = JSONArray.parseArray(columnValue);
        for (int i = 0; i < arrays.size(); i++) {
            JSONArray array = arrays.getJSONArray(i);
            Integer key = array.getJSONArray(0).getInteger(0);
            JSONArray valArr = array.getJSONArray(1);

            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < valArr.size(); j++) {
                list.add(valArr.getIntValue(j));
            }
            mapList.put(key, list);
        }

        return mapList;
    }

    @Override
    public Map<Integer, List<Integer>> getResult(String convertParam) {
        return getMapList(convertParam);
    }
}
