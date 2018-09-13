/* ****************************************************************************
 * Fernando Ito - 09/07/2018
 * tests.newTours.java - main class.
 * v1.0
 ******************************************************************************/

package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class newTours {

    public static void main(String[] args) throws IOException {

        // Set the property for webdriver.chrome.driver to be the location to your local download of chromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/fernandoito/selenium/chromeDriver");

        // Create new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // And now use this to visit Mercury Tours website
        driver.get("http://newtours.demoaut.com");

        // --- HOME --- //

        // Wait Home page appears
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Create an object of HomeTest class
        //HomeTest objExcelFile = new HomeTest();

        // Prepare the path of Excel file

        String filePath = System.getProperty("user.dir") + "/src/test/java/resources";
        String fileName = "testdata.xlsx";
        String sheetName = "newTours";

        // Call read file method of the class to read data
        //objExcelFile.readExcel(filePath, fileName, sheetName);
        //Workbook loginWorkbook = null;
        //Sheet loginSheet = loginWorkbook.getSheet(sheetName);

        //int qty = readExcel(filePath, fileName, sheetName, loginWorkbook, loginSheet);

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
        loginSheet = loginWorkbook.getSheet(sheetName);

        // Find number of rows in Excel file
        int rowCount = loginSheet.getLastRowNum()-loginSheet.getFirstRowNum();
        HomeTest homeTest = new HomeTest();


        // --- HOME - Login ------------------------------------------------ //
        //String userName = row.getCell(0).getStringCellValue();
        //String password = row.getCell(1).getStringCellValue();

        homeTest.homeLogin(driver);

        // Click on Sign-In
        driver.findElement(By.name("login")).click();


        // Create a loop over all the rows of Excel file to read it
        for (int i = 1; i < rowCount+1; i++) {

            Row row = loginSheet.getRow(i);

            // Create a loop to print cell values in a row

//            for (int j = 0; j < row.getLastCellNum(); j++) {

                // Print Excel data in console

                //System.out.print(row.getCell(j).getStringCellValue() + " || ");


//            }

//            System.out.println();

            // --- FLIGHT FINDER ----------------------------------------------- //

            // Wait Flight Finder page appears
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("findFlights")));

            FlightFinderTest flightFinderTest = new FlightFinderTest();

            // --- FLIGHT FINDER - Flight Details --- //
            String str_passCount = row.getCell(2).getStringCellValue();
            String str_fromPort = row.getCell(3).getStringCellValue();
            String str_fromMonth = row.getCell(4).getStringCellValue();
            String str_fromDay = row.getCell(5).getStringCellValue();
            String str_toPort = row.getCell(6).getStringCellValue();
            String str_toMonth = row.getCell(7).getStringCellValue();
            String str_toDay = row.getCell(8).getStringCellValue();

            flightFinderTest.flightDetails(driver, str_passCount, str_fromPort, str_fromMonth, str_fromDay, str_toPort, str_toMonth, str_toDay);

            // --- FLIGHT FINDER - Preferences --- //
            String str_svcClass = row.getCell(9).getStringCellValue();
            String str_airline = row.getCell(10).getStringCellValue();

            flightFinderTest.flightPreferences(driver, str_svcClass, str_airline);

            // Click Continue button
            driver.findElement(By.name("findFlights")).click();


            // --- SELECT FLIGHT ----------------------------------------------- //

            // Wait SELECT FLIGHT page appears
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reserveFlights")));

            SelectFlightTest selectFlightTest = new SelectFlightTest();

            // --- SELECT FLIGHT - Departure --- //
            String str_outFlight = row.getCell(11).getStringCellValue();

            selectFlightTest.selectFlightDeparture(driver, str_outFlight);

            // --- SELECT FLIGHT - Return --- //
            String str_inFlight = row.getCell(12).getStringCellValue();

            selectFlightTest.selectFlightReturn(driver, str_inFlight);


            // Click Continue button
            driver.findElement(By.name("reserveFlights")).click();


            // --- BOOK A FLIGHT ----------------------------------------------- //

            // Wait BOOK A FLIGHT page appears
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("buyFlights")));

            BookAFlightTest bookAFlightTest = new BookAFlightTest();

            // --- BOOK A FLIGHT - Passengers --- //
            String str_passFirst0 = row.getCell(13).getStringCellValue();
            String str_passLast0 = row.getCell(14).getStringCellValue();
            String str_pass0_meal = row.getCell(15).getStringCellValue();
            String str_passFirst1 = row.getCell(16).getStringCellValue();
            String str_passLast1 = row.getCell(17).getStringCellValue();
            String str_pass1_meal = row.getCell(18).getStringCellValue();

            bookAFlightTest.bookAFlightPassengers(driver, str_passFirst0, str_passLast0, str_pass0_meal, str_passFirst1, str_passLast1, str_pass1_meal);

            // --- BOOK A FLIGHT - Credit Card --- //
            String str_creditCard = row.getCell(19).getStringCellValue();
            String str_creditnumber = row.getCell(20).getStringCellValue();
            String str_cc_exp_dt_mn = row.getCell(21).getStringCellValue();
            String str_cc_exp_dt_yr = row.getCell(22).getStringCellValue();
            String str_cc_frst_name = row.getCell(23).getStringCellValue();
            String str_cc_mid_name = row.getCell(24).getStringCellValue();
            String str_cc_last_name = row.getCell(25).getStringCellValue();

            bookAFlightTest.bookAFlightCreditCard(driver, str_creditCard, str_creditnumber, str_cc_exp_dt_mn, str_cc_exp_dt_yr, str_cc_frst_name, str_cc_mid_name, str_cc_last_name);

            // --- BOOK A FLIGHT - Billing Address --- //
            String str_billAddress1 = row.getCell(26).getStringCellValue();
            String str_billAddress2 = row.getCell(27).getStringCellValue();
            String str_billCity = row.getCell(28).getStringCellValue();
            String str_billState = row.getCell(29).getStringCellValue();
            String str_billZip = row.getCell(30).getStringCellValue();
            String str_billCountry = row.getCell(31).getStringCellValue();

            bookAFlightTest.bookAFlightBillingAddress(driver, str_billAddress1, str_billAddress2, str_billCity, str_billState, str_billZip, str_billCountry);

            // --- BOOK A FLIGHT - Delivery Address --- //
            String str_delAddress1 = row.getCell(32).getStringCellValue();
            String str_delAddress2 = row.getCell(33).getStringCellValue();
            String str_delCity = row.getCell(34).getStringCellValue();
            String str_delState = row.getCell(35).getStringCellValue();
            String str_delZip = row.getCell(36).getStringCellValue();
            String str_delCountry = row.getCell(37).getStringCellValue();

            bookAFlightTest.bookAFlightDeliveryAddress(driver, str_delAddress1, str_delAddress2, str_delCity, str_delState, str_delZip, str_delCountry);

            // Click SECURE PURCHASE button
            driver.findElement(By.name("buyFlights")).click();


            // --- FLIGHT CONFIRMATION ----------------------------------------- //

            // Wait FLIGHT CONFIRMATION page appears
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='/images/forms/Logout.gif']")));

            FlightConfirmationTest flightConfirmationPage = new FlightConfirmationTest();

            // Get confirmation text and check if is valid
            flightConfirmationPage.flightConfirmation(wait);

            if (i == rowCount+1) {
                // Click LOG OUT button
                driver.findElement(By.cssSelector("img[src='/images/forms/Logout.gif']")).click();
            } else {
                // Click BACK TO FLIGHTS button
                driver.findElement(By.cssSelector("img[src='/images/forms/backtoflights.gif']")).click();
            }

        }

        // Close the browser
        driver.quit();

    }

}
