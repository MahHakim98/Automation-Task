//package com.automation.utils;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class ExcelUtil {
//    private String excelFilePath;
//
//    public ExcelUtil(String excelFilePath) {
//        this.excelFilePath = excelFilePath;
//    }
//
//    public Object[][] readExcelData() throws IOException {
//        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
//        Workbook workbook = new XSSFWorkbook(fileInputStream);
//        Sheet sheet = workbook.getSheetAt(0);
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//
//        Object[][] data = new Object[rowCount - 1][colCount];
//
//        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip header
//            Row row = sheet.getRow(i);
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                data[i - 1][j] = getCellValue(cell);
//            }
//        }
//        workbook.close();
//        return data;
//    }
//
//    private String getCellValue(Cell cell) {
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue();
//            case NUMERIC:
//                return String.valueOf((long) cell.getNumericCellValue());
//            case BOOLEAN:
//                return String.valueOf(cell.getBooleanCellValue());
//            default:
//                return "";
//        }
//    }
//}
