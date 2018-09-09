import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
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

        HomePage homePage = new HomePage();

        // --- HOME - Login ------------------------------------------------ //
        homePage.homeLogin(driver);

        // Click on Sign-In
        driver.findElement(By.name("login")).click();


        // --- FLIGHT FINDER ----------------------------------------------- //

        // Wait Flight Finder page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("findFlights")));

        FlightFinderPage flightFinderPage = new FlightFinderPage();

        // --- FLIGHT FINDER - Flight Details --- //
        flightFinderPage.flightDetails(driver);

        // --- FLIGHT FINDER - Preferences --- //
        flightFinderPage.flightPreferences(driver);

        // Click Continue button
        driver.findElement(By.name("findFlights")).click();


        // --- SELECT FLIGHT ----------------------------------------------- //

        // Wait SELECT FLIGHT page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reserveFlights")));

        SelectFlightPage selectFlightPage = new SelectFlightPage();

        // --- SELECT FLIGHT - Departure --- //
        selectFlightPage.selectFlightDeparture(driver);

        // --- SELECT FLIGHT - Return --- //
        selectFlightPage.selectFlightReturn(driver);


        // Click Continue button
        driver.findElement(By.name("reserveFlights")).click();


        // --- BOOK A FLIGHT ----------------------------------------------- //

        // Wait BOOK A FLIGHT page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("buyFlights")));

        BookAFlightPage bookAFlightPage = new BookAFlightPage();

        // --- BOOK A FLIGHT - Passengers --- //
        bookAFlightPage.bookAFlightPassengers(driver);

        // --- BOOK A FLIGHT - Credit Card --- //
        bookAFlightPage.bookAFlightCreditCard(driver);

        // --- BOOK A FLIGHT - Billing Address --- //
        bookAFlightPage.bookAFlightBillingAddress(driver);

        // --- BOOK A FLIGHT - Delivery Address --- //
        bookAFlightPage.bookAFlightDeliveryAddress(driver);

        // Click SECURE PURCHASE button
        driver.findElement(By.name("buyFlights")).click();


        // --- FLIGHT CONFIRMATION ----------------------------------------- //

        // Wait FLIGHT CONFIRMATION page appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='/images/forms/Logout.gif']")));

        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage();

        // Get confirmation text and check if is valid
        flightConfirmationPage.flightConfirmation(wait);


        // Click LOG OUT button
        driver.findElement(By.cssSelector("img[src='/images/forms/Logout.gif']")).click();

        // Close the browser
        driver.quit();
    }

}
