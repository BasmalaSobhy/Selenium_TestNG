package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Hooks_TestNG {

    /* WebDriver
        used to define the type of the browser we are going to use
        It opens the browser and perform all our actions on that browser

        WebDriver driver = new ChromeDriver();
     */

    /* Note: we split this line into 2 lines:
        one of them here to be able to use the driver all over the page
        the other will be in before method to open the browser before each test
     */
    public static WebDriver driver;

    /*
        TestNG annotations:

        1. @Test >> indicates that this is a test case
                 >> you can run any method with @Test annotation alone

        2. @BeforeTest >> will run before all the tests you have
                       >> you have 10 @Test methods, @BeforeTest will run once before all the 10 methods

        3. @BeforeMethods >> will run before each test you have
                          >> you have 10 @Test methods, @BeforeMethod will run 10 times once before each method

       2. @AfterTest >> will run after all the tests you have
                       >> you have 10 @Test methods, @AfterTest will run once after all the 10 methods

        3. @AfterMethods >> will run after each test you have
                          >> you have 10 @Test methods, @AfterMethod will run 10 times once after each method
     */

    @BeforeMethod
    public void beforeTest() {
        //System.out.println("BeforeTest");
    }

    @BeforeMethod
    public void openBrowser() {
        //System.out.println("BeforeMethod");
        driver = new ChromeDriver();
    }

    /* There are 2 ways to close the browser

        1. driver.close(); >> close the window

        2. driver.quit(); >> close any of the windows that are open.

     */
    @AfterMethod
    public void closeBrowser() {
        //System.out.println("AfterMethod");
        //driver.close();
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        //System.out.println("AfterTest");
    }
}
