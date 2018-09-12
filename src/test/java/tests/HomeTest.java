/* ****************************************************************************
 * Fernando Ito - 09/07/2018
 * tests.HomeTest.java - login.
 * v1.0
 ******************************************************************************/

package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeTest extends newTours {

    public static void homeLogin(WebDriver driver) {

        // Enter User Name
        driver.findElement(By.name("userName")).sendKeys("mercury");

        // Enter Password
        driver.findElement(By.name("password")).sendKeys("mercury");

    }

    public void readExcel(String filePath, String fileName, String sheetName) throws IOException {

        // Create an object of File class to open xlsx file
        File file = new File(filePath + "/" + fileName);

        // Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        Workbook loginWorkbook = null;

        // Find the file extension by splitting file name in substring and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        // Check condition if the file is xlsx file

        if (fileExtensionName.equals(".xlsx")) {

            // If it is xlsx file then create object of XSSFWorkbook class
            loginWorkbook = new XSSFWorkbook(inputStream);

        } else {

            // if it is xls file then create object of HSSFWorkbook class
            loginWorkbook = new HSSFWorkbook(inputStream);

        }

        // Read sheet inside the workbook by its name
        Sheet loginSheet = loginWorkbook.getSheet(sheetName);

        // Find number of rows in Excel file
        int rowCount = loginSheet.getLastRowNum()-loginSheet.getFirstRowNum();

        // Create a loop over all the rows of Excel file to read it

        for (int i = 0; i < rowCount+1; i++) {

            Row row = loginSheet.getRow(i);

            // Create a loop to print cell values in a row

            for (int j = 0; j < row.getLastCellNum(); j++) {

                // Print Excel data in console

                System.out.print(row.getCell(j).getStringCellValue() + " || ");

            }

            System.out.println();

        }

    }

}

