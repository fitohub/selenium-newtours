/* ****************************************************************************
 * Fernando Ito - 09/07/2018
 * BookAFlightPage.java - set passengers and payment information.
 * v1.0
 ******************************************************************************/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class BookAFlightPage {

    public static void bookAFlightPassengers(WebDriver driver) {

        // Enter 1st passenger First Name
        driver.findElement(By.name("passFirst0")).sendKeys("Firstname1");

        // Enter 1st passenger Last Name
        driver.findElement(By.name("passLast0")).sendKeys("Lastname1");

        // Select 1st passenger Meal
        new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Hindu");

        // Enter 2nd passenger First Name
        driver.findElement(By.name("passFirst1")).sendKeys("Firstname2");

        // Enter 2nd passenger Last Name
        driver.findElement(By.name("passLast1")).sendKeys("Lastname2");

        // Select 2nd passenger Meal
        new Select(driver.findElement(By.name("pass.1.meal"))).selectByVisibleText("Low Calorie");

    }

    public static void bookAFlightCreditCard(WebDriver driver) {

        // --- BOOK A FLIGHT - Credit Card --- //

        // Select Card Type
        new Select(driver.findElement(By.name("creditCard"))).selectByVisibleText("Visa");

        // Enter Number
        driver.findElement(By.name("creditnumber")).sendKeys("1234567890");

        // Select Expiration month
        new Select(driver.findElement(By.name("cc_exp_dt_mn"))).selectByVisibleText("11");

        // Select Expiration year
        new Select(driver.findElement(By.name("cc_exp_dt_yr"))).selectByVisibleText("2010");

        // Enter credit card First Name
        driver.findElement(By.name("cc_frst_name")).sendKeys("Jean");

        // Enter credit card Middle Name
        driver.findElement(By.name("cc_mid_name")).sendKeys("Paul");

        // Enter credit card Last Name
        driver.findElement(By.name("cc_last_name")).sendKeys("Doe");

    }

    public static void bookAFlightBillingAddress(WebDriver driver) {

        // --- BOOK A FLIGHT - Billing Address --- //

        // Enter Billing Address
        WebElement billAddress1 = driver.findElement(By.name("billAddress1"));
        billAddress1.clear();
        billAddress1.sendKeys("1, Billing Address");

        // Enter Billing Address Complement
        driver.findElement(By.name("billAddress2")).sendKeys("Billing Address Complement ");

        // Enter Billing City
        WebElement billCity = driver.findElement(By.name("billCity"));
        billCity.clear();
        billCity.sendKeys("Billing City");

        // Enter Billing State/Province
        WebElement billState = driver.findElement(By.name("billState"));
        billState.clear();
        billState.sendKeys("ON");

        // Enter Billing Postal Code
        WebElement billZip = driver.findElement(By.name("billZip"));
        billZip.clear();
        billZip.sendKeys("12345");

        // Select Billing Country
        new Select(driver.findElement(By.name("billCountry"))).selectByVisibleText("CANADA");

    }

    public static void bookAFlightDeliveryAddress(WebDriver driver) {

        // --- BOOK A FLIGHT - Delivery Address --- //

        // Enter Delivery Address
        WebElement delAddress1 = driver.findElement(By.name("delAddress1"));
        delAddress1.clear();
        delAddress1.sendKeys("2, Delivery Address");

        // Enter Delivery Address Complement
        driver.findElement(By.name("delAddress2")).sendKeys("2, Delivery Address Complement");

        // Enter Delivery City
        WebElement delCity = driver.findElement(By.name("delCity"));
        delCity.clear();
        delCity.sendKeys("Delivery City");

        // Enter Delivery State/Province
        WebElement delState = driver.findElement(By.name("delState"));
        delState.clear();
        delState.sendKeys("ON");

        // Enter Delivery Postal Code
        WebElement delZip = driver.findElement(By.name("delZip"));
        delZip.clear();
        delZip.sendKeys("67890");

        // Select Delivery Country
        String country = "CANADA";

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
