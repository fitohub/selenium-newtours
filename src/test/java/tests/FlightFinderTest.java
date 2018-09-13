/* ****************************************************************************
 * Fernando Ito - 09/07/2018
 * tests.FlightFinderTest.java - set roundtrip flight information for 2 people.
 * v1.0
 ******************************************************************************/

package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderTest {

    public static void flightDetails(WebDriver driver, String str_passCount, String str_fromPort, String str_fromMonth, String str_fromDay, String str_toPort, String str_toMonth, String str_toDay) {

        // Select Quantity of Passengers
        new Select(driver.findElement(By.name("passCount"))).selectByVisibleText(str_passCount);

        // Select Departure City
        new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText(str_fromPort);

        // Select Departure Month
        new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText(str_fromMonth);

        // Select Departure Day
        new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText(str_fromDay);

        // Select Arrival City
        new Select(driver.findElement(By.name("toPort"))).selectByVisibleText(str_toPort);

        // Select Arrival Month
        new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText(str_toMonth);

        // Select Arrival Day
        new Select(driver.findElement(By.name("toDay"))).selectByVisibleText(str_toDay);

    }

    public static void flightPreferences(WebDriver driver, String str_svcClass, String str_airline) {

        // Set Service Class
        driver.findElement(By.cssSelector("input[value='" + str_svcClass + "']")).click();

        // Select Airline
        new Select(driver.findElement(By.name("airline"))).selectByVisibleText(str_airline);

    }
}
