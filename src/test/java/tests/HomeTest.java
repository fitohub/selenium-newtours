/* ****************************************************************************
 * Fernando Ito - 09/07/2018
 * tests.HomeTest.java - login.
 * v1.0
 ******************************************************************************/

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.excelutils.ExcelUtil;

public class HomeTest extends newTours {
/*
    public void setupTestData() {
        //Set Test Data Excel and Sheet
        System.out.println("****************** Setup Test Level Data ******************");
        ExcelUtil.setExcelFileSheet("HomeData");
    }
*/
    public static void homeLogin(WebDriver driver) {

        // Enter User Name
        driver.findElement(By.name("userName")).sendKeys("mercury");

        // Enter Password
        driver.findElement(By.name("password")).sendKeys("mercury");

    }

}

