package com.learn.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ListIntTypeHandler implements UserTypeHandler<List<Integer>> {

    private List<Integer> getIntegerList(String convertParam) {
        List<Integer> list = new ArrayList<Integer>();
        if (convertParam == null || convertParam.isEmpty() || "".equals(StringUtils.trim(convertParam))) {
            return list;
        }

        try {
            JSONArray array = JSONArray.parseArray(convertParam);
            for (int i = 0; i < array.size(); i++) {
                int value = array.getIntValue(i);
                list.add(value);
            }
        } catch (Exception e) {
            // LogUtil.error("解析错误: columnName:", columnName, " columnValue:", columnValue);
        }
        return list;
    }

    private String listToString(List<Integer> parameter) {
        JSONArray arrays = null;
        if (parameter == null || parameter.isEmpty()) {
            arrays = new JSONArray();
            return arrays.toJSONString();
        }

        return JSON.toJSONString(parameter);
    }

    @Override
    public List<Integer> getResult(String convertParam) {
        return getIntegerList(convertParam);
    }
}
