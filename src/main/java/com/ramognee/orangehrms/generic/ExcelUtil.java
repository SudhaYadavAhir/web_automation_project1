package com.ramognee.orangehrms.generic;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    public String readDataExcelSheet(String fileName, int rowNum, int cellNum) {
        String data = null;
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));
            XSSFSheet sheet = workbook.getSheet("LoginDataSheet");
            XSSFRow row = sheet.getRow(rowNum);
            data = row.getCell(cellNum).getStringCellValue();
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
