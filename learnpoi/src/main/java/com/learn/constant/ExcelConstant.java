package com.learn.constant;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-03 15:17
 * @Description:
 * @Modified By:
 */
public class ExcelConstant {


    /**
     * 仅支持的excel的格式
     */
    public static final String[] EXCEL_SUFFIX = {ExcelConstant.XLSX_SUFFIX};

    /**
     * Excel2007的版本，扩展名是.xlsx
     */
    public static final String XLSX_SUFFIX =  ".xlsx";

    /**
     * Excel2003以前（包括2003）的版本，扩展名是.xls
     */
    public static final String XLS_SUFFIX =  ".xls";

    /**
     * Excel的存放目录
     */
    public static final String EXCEL_DIR = "excel/";

    /**
     * Excel配置表头行数
     */
    public static final int HEAD_LINE_NUM = 0;


    /**
     * Excel配置表数据开始行号
     */
    public static final int VALUE_LINE_NUM = 2;


    /**
     * Entity与Excel映射
     */
    public enum EntityExcelMapper{
        /**
         * StaticConditon 对应的Action.xlsx Condition工作薄
         */
        STATIC_CONDITION("Action","Condition");

        private String exlName;
        private String sheetName;


        EntityExcelMapper(String exlName, String sheetName) {
            this.exlName = exlName;
            this.sheetName = sheetName;
        }

        public String getExlName() {
            return exlName;
        }

        public void setExlName(String exlName) {
            this.exlName = exlName;
        }

        public String getSheetName() {
            return sheetName;
        }

        public void setSheetName(String sheetName) {
            this.sheetName = sheetName;
        }
    }

}
