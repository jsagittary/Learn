package com.learn.poi;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-04 10:12
 * @Description:
 * @Modified By:
 */
public class Readsheet {

    static HSSFRow row;

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(
                new File("pve.xls"));
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        while (sheetIterator.hasNext()) {
            // HSSFSheet spreadsheet = workbook.getSheetAt(0);
            Sheet spreadsheet = sheetIterator.next();
            Iterator<Row> rowIterator = spreadsheet.iterator();
            while (rowIterator.hasNext()) {
                row = (HSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellTypeEnum()) {
                        case NUMERIC:
                            System.out.print(
                                    cell.getNumericCellValue() + " \t\t ");
                            break;
                        case STRING:
                            System.out.print(
                                    cell.getStringCellValue() + " \t\t ");
                            break;
                    }
                }
                System.out.println();
            }
        }
        fis.close();
    }

}
