package com.learn.handler;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ListListLongTypeHandler implements UserTypeHandler<List<List<Long>>> {
    private String listToString(List<List<Long>> parameter) {
        JSONArray arrays = null;
        if (parameter == null || parameter.isEmpty()) {
            arrays = new JSONArray();
            return arrays.toJSONString();
        }

        // arrays = JSONArray.fromObject(parameter);
        return JSONArray.toJSONString(parameter);
    }

    private List<List<Long>> getListList(String columnValue) {
        List<List<Long>> listList = new ArrayList<List<Long>>();
        if (columnValue == null || columnValue.isEmpty()) {
            return listList;
        }

        // JSONArray arrays = JSONArray.fromObject(columnValue);
        JSONArray arrays = JSONArray.parseArray(columnValue);
        for (int i = 0; i < arrays.size(); i++) {
            List<Long> list = new ArrayList<Long>();
            JSONArray array = arrays.getJSONArray(i);
            for (int j = 0; j < array.size(); j++) {
                list.add(array.getLong(j));
            }

            if (!list.isEmpty()) {
                listList.add(list);
            }
        }
        return listList;
    }

    @Override
    public List<List<Long>> getResult(String convertParam) {
        return getListList(convertParam);
    }
}
