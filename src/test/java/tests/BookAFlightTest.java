/* ****************************************************************************
 * Fernando Ito - 09/07/2018
 * tests.BookAFlightTest.java - set passengers and payment information.
 * v1.0
 ******************************************************************************/

package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class BookAFlightTest {

    public static void bookAFlightPassengers(WebDriver driver, String str_passFirst0, String str_passLast0, String str_pass0_meal, String str_passFirst1, String str_passLast1, String str_pass1_meal) {

        // Enter 1st passenger First Name
        driver.findElement(By.name("passFirst0")).sendKeys(str_passFirst0);

        // Enter 1st passenger Last Name
        driver.findElement(By.name("passLast0")).sendKeys(str_passLast0);

        // Select 1st passenger Meal
        new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText(str_pass0_meal);

        // Enter 2nd passenger First Name
        driver.findElement(By.name("passFirst1")).sendKeys(str_passFirst1);

        // Enter 2nd passenger Last Name
        driver.findElement(By.name("passLast1")).sendKeys(str_passLast1);

        // Select 2nd passenger Meal
        new Select(driver.findElement(By.name("pass.1.meal"))).selectByVisibleText(str_pass1_meal);

    }

    public static void bookAFlightCreditCard(WebDriver driver, String str_creditCard, String str_creditnumber, String str_cc_exp_dt_mn, String str_cc_exp_dt_yr, String str_cc_frst_name, String str_cc_mid_name, String str_cc_last_name) {

        // --- BOOK A FLIGHT - Credit Card --- //

        // Select Card Type
        new Select(driver.findElement(By.name("creditCard"))).selectByVisibleText(str_creditCard);

        // Enter Number
        driver.findElement(By.name("creditnumber")).sendKeys(str_creditnumber);

        // Select Expiration month
        new Select(driver.findElement(By.name("cc_exp_dt_mn"))).selectByVisibleText(str_cc_exp_dt_mn);

        // Select Expiration year
        new Select(driver.findElement(By.name("cc_exp_dt_yr"))).selectByVisibleText(str_cc_exp_dt_yr);

        // Enter credit card First Name
        driver.findElement(By.name("cc_frst_name")).sendKeys(str_cc_frst_name);

        // Enter credit card Middle Name
        driver.findElement(By.name("cc_mid_name")).sendKeys(str_cc_mid_name);

        // Enter credit card Last Name
        driver.findElement(By.name("cc_last_name")).sendKeys(str_cc_last_name);

    }

    public static void bookAFlightBillingAddress(WebDriver driver, String str_billAddress1, String str_billAddress2, String str_billCity, String str_billState, String str_billZip, String str_billCountry) {

        // --- BOOK A FLIGHT - Billing Address --- //

        // Enter Billing Address
        WebElement billAddress1 = driver.findElement(By.name("billAddress1"));
        billAddress1.clear();
        billAddress1.sendKeys(str_billAddress1);

        // Enter Billing Address Complement
        driver.findElement(By.name("billAddress2")).sendKeys(str_billAddress2);

        // Enter Billing City
        WebElement billCity = driver.findElement(By.name("billCity"));
        billCity.clear();
        billCity.sendKeys(str_billCity);

        // Enter Billing State/Province
        WebElement billState = driver.findElement(By.name("billState"));
        billState.clear();
        billState.sendKeys(str_billState);

        // Enter Billing Postal Code
        WebElement billZip = driver.findElement(By.name("billZip"));
        billZip.clear();
        billZip.sendKeys(str_billZip);

        // Select Billing Country
        new Select(driver.findElement(By.name("billCountry"))).selectByVisibleText(str_billCountry);

    }

    public static void bookAFlightDeliveryAddress(WebDriver driver, String str_delAddress1, String str_delAddress2, String str_delCity, String str_delState, String str_delZip, String str_delCountry) {

        // --- BOOK A FLIGHT - Delivery Address --- //

        // Enter Delivery Address
        WebElement delAddress1 = driver.findElement(By.name("delAddress1"));
        delAddress1.clear();
        delAddress1.sendKeys(str_delAddress1);

        // Enter Delivery Address Complement
        driver.findElement(By.name("delAddress2")).sendKeys(str_delAddress2);

        // Enter Delivery City
        WebElement delCity = driver.findElement(By.name("delCity"));
        delCity.clear();
        delCity.sendKeys(str_delCity);

        // Enter Delivery State/Province
        WebElement delState = driver.findElement(By.name("delState"));
        delState.clear();
        delState.sendKeys(str_delState);

        // Enter Delivery Postal Code
        WebElement delZip = driver.findElement(By.name("delZip"));
        delZip.clear();
        delZip.sendKeys(str_delZip);

        // Select Delivery Country
        String country = str_delCountry;

        new Select(driver.findElement(By.name("delCountry"))).selectByVisibleText(country);

        if (!country.equals("UNITED STATES")) {

            waitForAlert(driver);

            System.out.println("Alert text: " + "'" + getAlertText(driver) + "'");

        }

    }

    public static void waitForAlert(WebDriver driver) {

        WebDriverWait waitAlert = new WebDriverWait(driver, 5);
        waitAlert.until(ExpectedConditions.alertIsPresent());

    }

    public static String getAlertText(WebDriver driver) {

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        alert.accept();

        return alertText;

    }

}
