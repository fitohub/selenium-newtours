/* ****************************************************************************
 * Fernando Ito - 09/07/2018
 * SelectFlightPage.java - displays availability flights for departure/return.
 * v1.0
 ******************************************************************************/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectFlightPage {

    public static void selectFlightDeparture(WebDriver driver) {

        // --- SELECT FLIGHT - Departure --- //

        // Select 2nd flight
        List<WebElement> outFlight = driver.findElements(By.name("outFlight"));
        outFlight.get(1).click();

    }

    public static void selectFlightReturn(WebDriver driver) {

        // --- SELECT FLIGHT - Return --- //

        // Select 3rd flight
        List<WebElement> inFlight = driver.findElements(By.name("inFlight"));
        inFlight.get(2).click();

    }

}
