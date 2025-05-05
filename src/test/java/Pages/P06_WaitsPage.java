package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static Tests.Hooks_TestNG.driver;

public class P06_WaitsPage {

    // locators
    By startButtonLocator = By.tagName("button");
    By hiddenText = By.id("finish");


    //Actions
    public WebElement getStartButton(){
        return driver.findElement(startButtonLocator);
    }

    public WebElement getHiddenText(){
        return driver.findElement(hiddenText);
    }

    public By getHiddenTextLocator(){
        return hiddenText;
    }

}
