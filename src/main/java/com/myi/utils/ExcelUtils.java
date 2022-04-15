package com.myi.utils;

import com.myi.constants.FrameworkConstant;
import com.myi.exceptions.InvalidPathForExcelException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {

    public static List<Map<String, String>> readExcelData(String sheetname) {
        XSSFWorkbook workbook = null;
        List<Map<String, String>> list = new ArrayList<>();
            try (InputStream fileInputStream = ExcelUtils.class.getClassLoader()
                    .getResourceAsStream(FrameworkConstant.getExcelDataFilePath())) {
                workbook = new XSSFWorkbook(fileInputStream);
                XSSFSheet sheet = workbook.getSheet(sheetname);
                int maxRowNum = sheet.getLastRowNum();
                int maxColNum = sheet.getRow(0).getLastCellNum();
                for (int i = 1; i <= maxRowNum; i++) {
                    Map<String, String> map = new HashMap<>();
                    for (int j = 0; j < maxColNum; j++) {
                        String key = sheet.getRow(0).getCell(j).getStringCellValue();
                        String value = sheet.getRow(i).getCell(j).getStringCellValue();
                        map.put(key, value);
                    }
                    list.add(map);
                }
            } catch (IOException e) {
                throw new InvalidPathForExcelException("Excel file path not found");
            }
        return list;
    }
}
