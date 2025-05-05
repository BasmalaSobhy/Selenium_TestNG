package Pages;

import Tests.Hooks_TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P04_Frames {

    // locators
    By topFrameLocator = By.xpath("//frame[@name='frame-top']");
    By leftFrameLocator = By.xpath("//frame[@name='frame-left']");
    By bottomFrameLocator = By.xpath("//frame[@name='frame-bottom']");
    By textLocator = By.tagName("body");

    //Actions
    public WebElement getTopFrame() {
        return Hooks_TestNG.driver.findElement(topFrameLocator);
    }

    public void switchToTopFrame() {
        Hooks_TestNG.driver.switchTo().frame(getTopFrame());
    }

    public WebElement getLeftFrame() {
        return Hooks_TestNG.driver.findElement(leftFrameLocator);
    }

    public void switchToLeftFrame() {
        Hooks_TestNG.driver.switchTo().frame(getLeftFrame());
    }

    public WebElement getBottomFrame() {
        return Hooks_TestNG.driver.findElement(bottomFrameLocator);
    }

    public void switchToBottomFrame() {
        Hooks_TestNG.driver.switchTo().frame(getBottomFrame());
    }

    public void switchBack() {Hooks_TestNG.driver.switchTo().parentFrame();}

    public WebElement getFrameText() {
        return Hooks_TestNG.driver.findElement(textLocator);
    }
}
