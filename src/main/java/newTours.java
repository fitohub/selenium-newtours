import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class newTours {
    public static void main(String[] args) {

        // Set the property for webdriver.chrome.driver to be the location to your local download of chromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/fernandoito/selenium/chromeDriver");

        // Create new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // And now use this to visit Mercury Tours website
        driver.get("http://newtours.demoaut.com");

        // --- HOME --- //

        // Wait Home page appears
        WebDriverWait wait = new WebDriverWait(driver, 10);


        // --- HOME - Login --- //

        // Enter User Name
        driver.findElement(By.name("userName")).sendKeys("mercury");

        // Enter Password
        driver.findElement(By.name("password")).sendKeys("mercury");


        // Click on Sign-In
        driver.findElement(By.name("login")).click();


        // --- FLIGHT FINDER --- //

        // Wait Flight Finder page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("findFlights")));


        // --- FLIGHT FINDER - Flight Details --- //

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


        // --- FLIGHT FINDER - Preferences --- //

        // Set Service Class
        driver.findElement(By.cssSelector("input[value='First']")).click();

        // Select Airline
        new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Unified Airlines");


        // Click Continue button
        driver.findElement(By.name("findFlights")).click();


        // --- SELECT FLIGHT --- //

        // Wait SELECT FLIGHT page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reserveFlights")));


        // --- SELECT FLIGHT - Departure --- //

        // Select 2nd flight
        List<WebElement> outFlight = driver.findElements(By.name("outFlight"));
        outFlight.get(1).click();
        //System.out.println("Departure flight selected: " + outFlight.isSelected());


        // --- SELECT FLIGHT - Return --- //

        // Select 3rd flight
        List<WebElement> inFlight = driver.findElements(By.name("inFlight"));
        inFlight.get(2).click();


        // Click Continue button
        driver.findElement(By.name("reserveFlights")).click();


        // --- BOOK A FLIGHT --- //

        // Wait BOOK A FLIGHT page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("buyFlights")));


        // --- BOOK A FLIGHT - Passengers --- //

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
        new Select(driver.findElement(By.name("delCountry"))).selectByVisibleText("CANADA");
        Alert alert = driver.switchTo().alert();
        alert.accept();


        // Click SECURE PURCHASE button
        driver.findElement(By.name("buyFlights")).click();


        // --- FLIGHT CONFIRMATION --- //

        // Wait FLIGHT CONFIRMATION page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='/images/forms/Logout.gif']")));

        // Click LOG OUT button
        driver.findElement(By.cssSelector("img[src='/images/forms/Logout.gif']")).click();


        // --- HOME --- //

        // Close the browser
        driver.quit();
    }
}
