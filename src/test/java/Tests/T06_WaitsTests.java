package Tests;

import Pages.P06_WaitsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class T06_WaitsTests extends Hooks_TestNG{
    P06_WaitsPage waitsPage = new P06_WaitsPage();

    /*
        Sometimes webElement takes time to load in the page, driver will show an error that the element can't be located "NoSuchElementException."
            >> to solve this you can tell the driver to wait for certain time until it shows that error

        Types of waits:

        1. Implicit Wait:
            A global wait that is applied to all webElements.
                >> driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(--));
                    >> you provide how many seconds you want the driver to wait before throw an error

            let's say you told the driver to implicit wait for 30 seconds
            > the driver will search in the 30 seconds for the element
            > if the driver find the element before 30 seconds, it won't wait the 30 seconds and will continue to work
            > if not it will wait to the end of the 30 seconds to throw the error


        2. Explicit Wait:
            unlike implicit wait, explicit wait works for specific condition,
            it will wait for that condition to become true for specific time before through an error

            >> WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(--));
            >> wait.until(ExpectedConditions.-----(----));

             let's say you told the driver to explicit wait for 30 seconds
            > the driver will search in the 30 seconds for the condition
            > if the driver condition is true before 30 seconds, it won't wait the 30 seconds and will continue to work
            > if not it will wait to the end of the 30 seconds to throw the error
     */

    @Test
    public void withoutWaits() { // this function will throw an error
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        waitsPage.getStartButton().click();
        System.out.println(waitsPage.getHiddenText().getText());
    }

    @Test
    public void withImplicitWaits() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        waitsPage.getStartButton().click();
        System.out.println(waitsPage.getHiddenText().getText());
    }

    @Test
    public void withExplicitWaits() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        waitsPage.getStartButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(waitsPage.getHiddenTextLocator()));

        System.out.println(waitsPage.getHiddenText().getText());
    }

    @Test
    public void withExplicitWaits2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        waitsPage.getStartButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(waitsPage.getHiddenText()));

        System.out.println(waitsPage.getHiddenText().getText());
    }
}
