/* ****************************************************************************
 * Fernando Ito - 09/07/2018
 * tests.SelectFlightTest.java - displays availability flights for departure/return.
 * v1.0
 ******************************************************************************/

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class SelectFlightTest {

    public static void selectFlightDeparture(WebDriver driver, String str_outFlight) {

        // --- SELECT FLIGHT - Departure --- //

        // Select 2nd flight
        List<WebElement> outFlight = driver.findElements(By.name("outFlight"));
        outFlight.get(toInt(str_outFlight)).click();

    }

    public static void selectFlightReturn(WebDriver driver, String str_inFlight) {

        // --- SELECT FLIGHT - Return --- //

        // Select 3rd flight
        List<WebElement> inFlight = driver.findElements(By.name("inFlight"));
        inFlight.get(toInt(str_inFlight)).click();

    }

}
