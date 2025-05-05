package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Tests.Hooks_TestNG;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class P03_ActionsPage {
    Actions action;

    //locators of dragAndDrop Page
    By ALocator = By.id("column-a");
    By BLocator = By.id("column-b");

    // locators of hover page
    By imgsLocator = By.tagName("img");


    // Actions of dragAndDrop Page
    public WebElement getA() {
        return Hooks_TestNG.driver.findElement(ALocator);
    }

    public WebElement getB() {
        return Hooks_TestNG.driver.findElement(BLocator);
    }

    public Actions actions() {
        return new Actions(Hooks_TestNG.driver);
    }

    //Actions of hoverPage
    public List<WebElement> getAllImages() {
        return Hooks_TestNG.driver.findElements(imgsLocator);
    }
}
