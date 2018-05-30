package com.learn.util;

import com.learn.constant.ExcelConstant;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-04 11:56
 * @Description:
 * @Modified By:
 */
public class FileUtil {

    /**
     * key:热更类全名, value:文件最后修改时间
     */
    private Map<String, Long> incluedExcelMap = new HashMap<>();

    /**
     * 读取class热更文件
     *
     * @param parent
     * @param curFile
     * @param fileTimeMap
     */
    public static void readExcelDir(String parent, File curFile, Map<String, Long> fileTimeMap) {
        if (curFile.isDirectory()) {
            File[] files = curFile.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        String packageName = parent != null ? parent + "." + file.getName() : file.getName();
                        readExcelDir(packageName, file, fileTimeMap);
                    } else {
                        readExcelDir(parent, file, fileTimeMap);
                    }
                }
            }
        } else {
            try {
                int excelNameIdx = curFile.getName().indexOf(".xlsx");
                if (excelNameIdx >= 0) {
                    String excelName = curFile.getName().substring(0, excelNameIdx);
                    String exlFullName = parent != null ? parent + "." + excelName : excelName;
                    fileTimeMap.put(exlFullName, curFile.lastModified());
                }
            } catch (Exception e) {
                // LogUtil.hotfix(String.format("parent :%s, file :%s", parent, curFile.getName()), e);
            }

        }
    }

    @Test
    public void testReadExcelDir() throws Exception {
        File curFile = new FileSystemResource(ExcelConstant.EXCEL_DIR).getFile();
        FileUtil.readExcelDir(null, curFile, incluedExcelMap);
    }
}
