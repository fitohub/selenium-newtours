/* ****************************************************************************
 * Fernando Ito - 09/07/2018
 * HomePage.java - login.
 * v1.0
 ******************************************************************************/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public static void homeLogin(WebDriver driver) {

        // Enter User Name
        driver.findElement(By.name("userName")).sendKeys("mercury");

        // Enter Password
        driver.findElement(By.name("password")).sendKeys("mercury");

    }

}

