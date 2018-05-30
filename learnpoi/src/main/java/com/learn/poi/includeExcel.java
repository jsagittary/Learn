package com.learn.poi;

import com.learn.bean.BaseExcel;
import com.learn.bean.StaticConditon;
import com.learn.constant.ExcelConstant;
import com.learn.util.ImportExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-04 11:22
 * @Description:
 * @Modified By:
 */
public class includeExcel {

    /**
     * key:Excel全名, value:文件最后修改时间
     */
    private Map<String, Long> incluedExcelMap = new HashMap<>();

    private ImportExcel ie = new ImportExcel();

    // public List<BaseExcel> includeExcel(BaseExcel baseExcel) throws IOException {
    //     if (baseExcel == null) {
    //         return null;
    //     }
    //     System.out.println(new FileSystemResource(ExcelConstant.EXCEL_DIR));
    //     // Excel存放目录
    //     File curFile = new FileSystemResource(ExcelConstant.EXCEL_DIR).getFile();
    //
    //     Workbook workbook = includeExcel.readExcelDir(null, curFile, incluedExcelMap, baseExcel.getExlSheetMapper());
    //     if (workbook == null) {
    //         return null;
    //     }
    //     List<BaseExcel> emplist = new ArrayList<>();
    //     String sheetName = baseExcel.getExlSheetMapper().getSheetName();
    //     if (workbook.getSheet(sheetName) != null) {
    //         emplist = (List<BaseExcel>) ie.getListBySheet(workbook.getSheet(sheetName), baseExcel.getClass());
    //     }
    //
    //     return emplist;
    //
    // }

    public <T extends BaseExcel> List<T> includeExcel(Class<T> baseClzz) throws IOException {
        BaseExcel baseExcel = null;
        List<T> emplist = new ArrayList<>();
        try {
            baseExcel = baseClzz.newInstance();
            // Excel存放目录
            File curFile = new FileSystemResource(ExcelConstant.EXCEL_DIR).getFile();
            Workbook workbook = includeExcel.readExcelDir(null, curFile, incluedExcelMap, baseExcel.getExlSheetMapper());
            if (workbook == null) {
                return null;
            }
            String sheetName = baseExcel.getExlSheetMapper().getSheetName();
            if (workbook.getSheet(sheetName) != null) {
                emplist =  ie.getListBySheet(workbook.getSheet(sheetName), baseClzz);
            }

            return emplist;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 读取Excel配置文件
     *
     * @param parent
     * @param curFile
     * @param fileTimeMap
     * @param excelMapper
     * @return
     */
    public static Workbook readExcelDir(String parent, File curFile, Map<String, Long> fileTimeMap, ExcelConstant.EntityExcelMapper excelMapper) {
        Workbook wb = null;
        if (curFile.isDirectory()) {
            File[] files = curFile.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        String packageName = parent != null ? parent + "." + file.getName() : file.getName();
                        readExcelDir(packageName, file, fileTimeMap, excelMapper);
                    } else {
                        return readExcelDir(parent, file, fileTimeMap, excelMapper);
                    }
                }
            }
        } else {
            try {
                int excelNameIdx = 0;
                for (String suffix : ExcelConstant.EXCEL_SUFFIX) {
                    if (excelNameIdx != 0) {
                        break;
                    }
                    excelNameIdx = curFile.getName().indexOf(suffix);
                    if (suffix == ExcelConstant.XLSX_SUFFIX) {
                        wb = new XSSFWorkbook(curFile);
                    } else if (suffix == ExcelConstant.XLS_SUFFIX) {
                        POIFSFileSystem fs = new POIFSFileSystem(curFile);
                        wb = new HSSFWorkbook(fs);
                    }
                }
                if (excelNameIdx >= 0) {
                    String excelName = curFile.getName().substring(0, excelNameIdx);
                    if (excelName.equals(excelMapper.getExlName())) {
                        String exlFullName = parent != null ? parent + "." + excelName : excelName;
                        fileTimeMap.put(exlFullName, curFile.lastModified());
                        return wb;
                    }
                }
            } catch (Exception e) {
                // LogUtil.hotfix(String.format("parent :%s, file :%s", parent, curFile.getName()), e);
            }

        }
        return null;
    }


    /**
     * 测试导入Excel配置表
     *
     * @throws Exception
     */
    @Test
    public void testIncludeExcel() throws Exception {
        List<StaticConditon> conditons = includeExcel(StaticConditon.class);
        for (StaticConditon conditon : conditons) {
            System.out.println(conditon);
        }
    }

    @Test
    public void name() throws Exception {
        Class<StaticConditon> aClass = StaticConditon.class;
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            System.out.println(name);
        }
    }
}
