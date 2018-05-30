package com.learn.util;

import com.learn.handler.UserTypeHandler;
import com.learn.annot.ExcelProperty;
import com.learn.constant.ExcelConstant;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-04 11:15
 * @Description:
 * @Modified By:
 */
public class ImportExcel {

    //通过工作簿 Sheet 获取对象的List集合
    public <T> List<T> getListBySheet(Sheet sheet, Class<T> clas) {
        List<T> list = new ArrayList<>();
        Row rowtitle = sheet.getRow(ExcelConstant.HEAD_LINE_NUM);//获得表头行
        //列数
        int colums = rowtitle.getPhysicalNumberOfCells();
        //表头信息
        HashMap<String, Integer> titleMap = new HashMap<>();
        ArrayList<String> title = new ArrayList<>();
        for (int i = 0; i < colums; i++) {
            title.add(rowtitle.getCell(i).toString());
            titleMap.put(rowtitle.getCell(i).toString(), i);
        }
        //  得到总行数
        int rows = sheet.getLastRowNum();
        for (int i = ExcelConstant.VALUE_LINE_NUM; i <= rows; i++) {
            try {
                Row row = sheet.getRow(i);
                T t = clas.newInstance();
                Field[] fields = clas.getDeclaredFields();
                //通过 k 来处理Excel中对应属性和实体类中的不一致问题
                for (int j = 0; j < fields.length; j++) {
                    Field field = fields[j];
                    field.setAccessible(true);
                    ExcelProperty annotation = field.getAnnotation(ExcelProperty.class);
                    String aliasName = annotation != null && !annotation.value().equals("") ? annotation.value() : field.getName();
                    int falg = -1;
                    for (Map.Entry<String, Integer> entry : titleMap.entrySet()) {
                        if (entry.getKey().equalsIgnoreCase(aliasName)) {
                            falg = entry.getValue();
                            break;
                        }
                    }
                    if (falg < 0) {
                        continue;
                    }
                    //有  NoExport 注解的  则让k-- ，保证不会有空列
                    // if (field.getAnnotation(NoExport.class) != null) {
                    //     k--;
                    //     continue;
                    // }
                    if (row == null) {
                        break;
                    }
                    Cell cell = row.getCell(falg);
                    // 策划没有填写此字段
                    if (cell == null) {
                        field.set(t, null);
                        break;
                    }
                    switch (cell.getCellTypeEnum()) {
                        //数值类型
                        case NUMERIC: {
                            // Date类型
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                                if (field.getType() == Date.class) {//Date 类型接收 Date类型
                                    field.set(t, date);
                                } else if (field.getType() == String.class) {//String 类型 接收 Date类型
                                    field.set(t, new SimpleDateFormat("yyyy-MM-dd").parse(cell.getStringCellValue()));
                                }
                            } else { //纯数值
                                if (field.getType() == Integer.class) {//Integer 类型接收 纯数值
                                    String str = cell.toString();
                                    //去掉 结尾为.0的情况  正常小数 不会去掉有精度意义的小数
                                    if (str != null && !"".equals(str.trim())) {
                                        String[] strs = str.split("\\.");
                                        if (strs.length > 1 && "0".equals(strs[1])) {
                                            str = strs[0];
                                        }
                                    }
                                    field.set(t, Integer.parseInt(str));
                                } else if (field.getType() == String.class) { //String 类型接收 纯数值
                                    field.set(t, String.valueOf(cell.getNumericCellValue()));
                                }

                            }
                            break;
                        }
                        // 字符串类型
                        case STRING: {
                            String cellValue = cell.getStringCellValue();
                            if (field.getType() == Date.class) { //Data类型接收String
                                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(cellValue);
                                field.set(t, date);
                            } else if (field.getType() == Integer.class) { //Integer 类型接收 String
                                field.set(t, Integer.parseInt(cellValue));
                            } else {
                                if (annotation != null) {
                                    Class<? extends UserTypeHandler> clazz = annotation.convertHandler();
                                    if (clazz != null) {
                                        UserTypeHandler handler = clazz.newInstance();
                                        field.set(t, handler.getResult(cellValue));
                                    }
                                } else {
                                    field.set(t, cellValue);
                                }
                            }
                            break;
                        }
                        //空值的情况 可以抛异常 也可以 设空值
                        case BLANK: {
                            field.set(t, null);
                            break;
                        }
                    }
                    //以下  为 以实体类中 属性为基准
                    // if (row.getCell(k) == null) {
                    //     field.set(t, null);
                    // } else {
                    //
                    //     if (field.getType() == Integer.class) {
                    //         if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                    //             field.set(t, Integer.parseInt(cell.getStringCellValue()));
                    //         }
                    //         if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                    //             field.set(t, Integer.valueOf((int) (cell.getNumericCellValue())));
                    //         }
                    //     } else if (field.getType() == Date.class) {
                    //         if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                    //             field.set(t, HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                    //         }
                    //         if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                    //             field.set(t, new SimpleDateFormat("yyyy-MM-dd").parse(cell.getStringCellValue()));
                    //         }
                    //     } else {
                    //         String str = cell.toString();
                    //         //去掉 结尾为.0的情况  正常小数 不会去掉有精度意义的小数
                    //         if (str != null && !"".equals(str.trim())) {
                    //             String[] strs = str.split("\\.");
                    //             if (strs.length > 1 && "0".equals(strs[1])) {
                    //                 str = strs[0];
                    //             }
                    //         }
                    //     }
                    // }
                }
                list.add(t);
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }


    private boolean checkInTitle(String aliasName) {
        return false;
    }
}
