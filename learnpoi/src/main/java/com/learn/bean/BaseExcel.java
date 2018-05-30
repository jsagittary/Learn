package com.learn.bean;

import com.learn.constant.ExcelConstant;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-04 13:56
 * @Description:
 * @Modified By:
 */
public interface BaseExcel {

    /**
     * 获取Entity与Excel的对应关系
     * @return
     */
    ExcelConstant.EntityExcelMapper getExlSheetMapper();
}
