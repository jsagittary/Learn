package com.learn.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-03 19:05
 * @Description:
 * @Modified By:
 */
public class Demo1 {

    public static void main(String[] args) {
        // String files = "D:/负荷预测结果分析";
        String files = Demo1.class.getResource("/").getPath();
        System.out.println(files);
        File file = new File(files);
        File[] dir = file.listFiles();//取得文件列表
        // Connection conn = new DB().getConnection();
        // try {
        //     conn.setAutoCommit(false);
        // } catch (SQLException e1) {
        //     e1.printStackTrace();
        // }
        // PreparedStatement stmt = null;
        for (int i = 0; i < dir.length; i++) {//遍历文件并读取入库
            String fileName = dir[i].getName();//取得文件名称
            // String time = fileName.substring(0, 4);//根据文件取得时间
            // try {
            //     Double.parseDouble(time);//判断时间格式是否正确
            // } catch (Exception e) {
            //     System.out.println("【" + dir[i].getName() + "】 时间格式不正确");
            //     return;
            // }
            try {
                InputStream inp = new FileInputStream(dir[i].getAbsoluteFile());


                // POIFSFileSystem ps = new POIFSFileSystem(inp);
                // HSSFWorkbook wb = new HSSFWorkbook(ps);


                XSSFWorkbook wb = new XSSFWorkbook(inp);//①②两种写法都可以，原理我却是不是很清楚待以后补充吧
                Sheet st = wb.getSheetAt(0);//取得第一个sheet
                for (int k = 1; k < 3; k++) {
                    for (int r = 2; r < 50; r++) {
                        Row row = st.getRow(r);
                        int col = 2;
                        if (k == 2) col = 7;
                        Cell c2 = row.getCell(col);
                        Cell c3 = row.getCell(col + 1);
                        // try {
                        //     if (stmt != null) {
                        //         stmt.close();
                        //         stmt = null;
                        //     }
                        //     String sql = "insert into d_HB01_wpf values(to_date(?,'yyyy-MM-dd hh24:mi:ss'),?,?)";
                        //     stmt = conn.prepareStatement(sql);
                        //     stmt.setString(1, getDate(time, r, k));//取得时间
                        //     stmt.setDouble(2, c2.getNumericCellValue());//因为单元格是数字格式故用次方式取得。
                        //     stmt.setDouble(3, c3.getNumericCellValue());
                        //     stmt.executeUpdate();
                        // } catch (SQLException e) {
                        //     e.printStackTrace();
                        // }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            dir[i].delete();
            System.out.println(fileName + "处理完毕已删除");
        }
    }

    private static String getDate(String time, int r, int k) {
        String month = time.substring(0, 1);
        String day = time.substring(2, 4);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        cal.set(2012, Integer.parseInt(month) - 1, Integer.parseInt(day));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "";
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, (r - 2) * 15);
        if (k == 1) {
            cal.set(Calendar.HOUR_OF_DAY, 0);//设置小时从0点开始
        } else {
            cal.set(Calendar.HOUR_OF_DAY, 12);//设置小时从12点开始
        }
        str = sf.format(cal.getTime());
        return str;
    }
}
