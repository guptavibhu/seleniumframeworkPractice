package Utility;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by vibhu on 9/23/2016.
 */
public class ExcelReader {
    public static String[][] cellStringValue = new String[20][5];
    public static int rowCount;

    public static void readExcel(String filePath, String fileName, String sheetName) throws IOException {
        //Create a object of File class to open xlsx file
        File file = new File(filePath + "\\" + fileName);
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        //Find the file extension by spliting file name in substring and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        //Check condition if the file is xlsx file
        if (fileExtensionName.equals(".xlsx")) {
            //If it is xlsx file then create object of XSSFWorkbook class
            workbook = new XSSFWorkbook(inputStream);
        }
        //Check condition if the file is xls file
        else if (fileExtensionName.equals(".xls")) {
            //If it is xls file then create object of XSSFWorkbook class
            workbook = new HSSFWorkbook(inputStream);
        }
        //Read sheet inside the workbook by its name
        Sheet sheet = workbook.getSheet(sheetName);
        //Find number of rows in excel file
        //   int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        //Create a loop over all the rows of excel file to read it
        for (int i = 0; i < rowCount + 1; i++) {
            Row row = sheet.getRow(i);
            //Create a loop to print cell values in a row

            for (int j = 0; j < row.getLastCellNum(); j++) {
                //Print excel data in console
                Cell cell = row.getCell(j);
                cellStringValue[i][j] = row.getCell(j).getStringCellValue();
            }
            System.out.println();
        }
    }


}
