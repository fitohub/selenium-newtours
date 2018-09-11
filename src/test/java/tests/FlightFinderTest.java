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

    public static void flightDetails(WebDriver driver) {

        // Select Quantity of Passengers
        new Select(driver.findElement(By.name("passCount"))).selectByVisibleText("2");

        // Select Departure City
        new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("New York");

        // Select Departure Month
        new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText("September");

        // Select Departure Day
        new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("30");

        // Select Arrival City
        new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Paris");

        // Select Arrival Month
        new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText("October");

        // Select Arrival Day
        new Select(driver.findElement(By.name("toDay"))).selectByVisibleText("25");

    }

    public static void flightPreferences(WebDriver driver) {

        // Set Service Class
        driver.findElement(By.cssSelector("input[value='First']")).click();

        // Select Airline
        new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Unified Airlines");

    }
}
