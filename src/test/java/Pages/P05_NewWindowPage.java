package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Tests.Hooks_TestNG.driver;

public class P05_NewWindowPage {

    // locators
    By openNewTabLinkLocator = By.linkText("Click Here");
    By text = By.tagName("h3");

    // Actions
    public WebElement getNewTabLink() {
        return driver.findElement(openNewTabLinkLocator);
    }

    public WebElement getWindowText() {
        return driver.findElement(text);
    }

    public void switchToTab(String window) {
        driver.switchTo().window(window);
    }

    public String getTitle() {
        return driver.getTitle(); // string
    }
}