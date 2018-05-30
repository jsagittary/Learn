package com.learn.bean;

import com.learn.constant.ExcelConstant;
import com.learn.handler.ListListTypeHandler;
import com.learn.annot.ExcelProperty;

import java.util.List;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-03 11:00
 * @Description:
 * @Modified By:
 */
public class StaticConditon implements BaseExcel {

    private Integer id;
    private String actionName;
    private String description;
    private String remark;
    @ExcelProperty(convertHandler = ListListTypeHandler.class)
    private List<Integer> lists;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Integer> getLists() {
        return lists;
    }

    public void setLists(List<Integer> lists) {
        this.lists = lists;
    }

    /*public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "StaticConditon{" +
                "id=" + id +
                ", actionName='" + actionName + '\'' +
                ", description='" + description + '\'' +
                ", action='" + action + '\'' +
                ", parameter='" + parameter + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "StaticConditon{" +
                "id=" + id +
                ", actionName='" + actionName + '\'' +
                ", description='" + description + '\'' +
                ", remark='" + remark + '\'' +
                ", lists=" + lists +
                '}';
    }

    @Override
    public ExcelConstant.EntityExcelMapper getExlSheetMapper() {
        return ExcelConstant.EntityExcelMapper.STATIC_CONDITION;
    }
}
