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
import java.io.IOException;

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
        HomeTest objExcelFile = new HomeTest();

        // Prepare the path of Excel file

        String filePath = System.getProperty("user.dir") + "/src/test/java/resources";
        String fileName = "testdata.xlsx";
        String sheetName = "HomeData";

        // Call read file method of the class to read data
        objExcelFile.readExcel(filePath, fileName, sheetName);

        HomeTest homeTest = new HomeTest();

        // --- HOME - Login ------------------------------------------------ //
        homeTest.homeLogin(driver);

        // Click on Sign-In
        driver.findElement(By.name("login")).click();


        // --- FLIGHT FINDER ----------------------------------------------- //

        // Wait Flight Finder page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("findFlights")));

        FlightFinderTest flightFinderTest = new FlightFinderTest();

        // --- FLIGHT FINDER - Flight Details --- //
        flightFinderTest.flightDetails(driver);

        // --- FLIGHT FINDER - Preferences --- //
        flightFinderTest.flightPreferences(driver);

        // Click Continue button
        driver.findElement(By.name("findFlights")).click();


        // --- SELECT FLIGHT ----------------------------------------------- //

        // Wait SELECT FLIGHT page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reserveFlights")));

        SelectFlightTest selectFlightTest = new SelectFlightTest();

        // --- SELECT FLIGHT - Departure --- //
        selectFlightTest.selectFlightDeparture(driver);

        // --- SELECT FLIGHT - Return --- //
        selectFlightTest.selectFlightReturn(driver);


        // Click Continue button
        driver.findElement(By.name("reserveFlights")).click();


        // --- BOOK A FLIGHT ----------------------------------------------- //

        // Wait BOOK A FLIGHT page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("buyFlights")));

        BookAFlightTest bookAFlightTest = new BookAFlightTest();

        // --- BOOK A FLIGHT - Passengers --- //
        bookAFlightTest.bookAFlightPassengers(driver);

        // --- BOOK A FLIGHT - Credit Card --- //
        bookAFlightTest.bookAFlightCreditCard(driver);

        // --- BOOK A FLIGHT - Billing Address --- //
        bookAFlightTest.bookAFlightBillingAddress(driver);

        // --- BOOK A FLIGHT - Delivery Address --- //
        bookAFlightTest.bookAFlightDeliveryAddress(driver);

        // Click SECURE PURCHASE button
        driver.findElement(By.name("buyFlights")).click();


        // --- FLIGHT CONFIRMATION ----------------------------------------- //

        // Wait FLIGHT CONFIRMATION page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='/images/forms/Logout.gif']")));

        FlightConfirmationTest flightConfirmationPage = new FlightConfirmationTest();

        // Get confirmation text and check if is valid
        flightConfirmationPage.flightConfirmation(wait);


        // Click LOG OUT button
        driver.findElement(By.cssSelector("img[src='/images/forms/Logout.gif']")).click();

        // Close the browser
        driver.quit();

    }
/*
    public static void readExcel(String filePath, String fileName, String sheetName) throws IOException {

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
*/

}
