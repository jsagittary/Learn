package com.learn.handler;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ListListTypeHandler implements UserTypeHandler<List<List<Integer>>> {
    private String listToString(List<List<Integer>> parameter) {
        JSONArray arrays = null;
        if (parameter == null || parameter.isEmpty()) {
            arrays = new JSONArray();
            return arrays.toString();
        }

        // arrays = JSONArray.fromObject(parameter);
        return JSONArray.toJSONString(parameter);
    }

    private List<List<Integer>> getListList(String columnValue) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if (columnValue == null || columnValue.isEmpty()) {
            return listList;
        }

        // JSONArray arrays = JSONArray.fromObject(columnValue);
        try {
            JSONArray arrays = JSONArray.parseArray(columnValue);
            for (int i = 0; i < arrays.size(); i++) {
                List<Integer> list = new ArrayList<Integer>();
                JSONArray array = arrays.getJSONArray(i);
                for (int j = 0; j < array.size(); j++) {
                    list.add(array.getInteger(j));
                }

                // if (!list.isEmpty()) {
                listList.add(list);
                // }
            }
        } catch (Exception e) {
            // System.out.println("ListListTypeHandler parse:" + columnValue);
            // LogUtil.error("解析错误: columnName:", columnName, " columnValue:", columnValue);
        }

        return listList;
    }

    @Override
    public List<List<Integer>> getResult(String convertParam) {
        return getListList(convertParam);
    }
}
