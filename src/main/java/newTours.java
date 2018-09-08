import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class newTours {
    public static void main(String[] args) {

        // Set the property for webdriver.chrome.driver to be the location to your local download of chromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/fernandoito/selenium/chromeDriver");

        // Create new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // And now use this to visit Mercury Tours website
        driver.get("http://newtours.demoaut.com");

        // --- Home ---
        // Wait Home page appears
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Enter User Name
        driver.findElement(By.name("userName")).sendKeys("mercury");

        // Enter Password
        driver.findElement(By.name("password")).sendKeys("mercury");

        // Click on Sign-In
        driver.findElement(By.name("login")).click();

        // Wait Flight Finder page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("findFlights")));


        // --- Flight Finder - Flight Details ---

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

        // Set Service Class
        driver.findElement(By.cssSelector("input[value='First']")).click();

        // Select Airline
        new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Unified Airlines");

        // Click Continue button
        driver.findElement(By.name("findFlights")).click();

        // Wait SELECT FLIGHT page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reserveFlights")));


        // Close the browser
        //driver.quit();
    }
}
