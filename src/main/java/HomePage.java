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

