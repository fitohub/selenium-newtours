/* ****************************************************************************
 * Fernando Ito - 09/07/2018
 * tests.FlightConfirmationTest.java - Get confirmation and check expected results.
 * v1.0
 ******************************************************************************/

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class FlightConfirmationTest {

    public static void flightConfirmation(WebDriverWait wait) {

        WebElement confirmation = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]"))));

        String confirmationText = confirmation.getText();

        assertEquals("Your itinerary has been booked!", confirmationText);

        System.out.println(confirmationText);
    }
}
