package Tests;

import Pages.P03_ActionsPage;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class T03_ActionsTests extends Hooks_TestNG {
    P03_ActionsPage page = new P03_ActionsPage();
    Actions action;

    /* Actions
            >> represents actions done using mouse

           Actions action = new Actions(driver);

           - action.dragAndDrop(source, destination).perform(); >> move item from one place to another
           - action.moveToElement(WebElement).perform(); >> move the mouse over an element (without clicking) >> hovering
           - action.contextClick(WebElement).perform(); >> acts like a right click
           - action.doubleClick().perform(); >> acts like clicking double click
           - action.clickAndHold().perform(); >> clicking on an element and hold
     */

    @Test (priority = 0, dependsOnMethods = "hover")
    public void dragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        action = page.actions();

        action.dragAndDrop(page.getA(), page.getB());
    }

    @Test(priority = 10)
    public void hover() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> imgs = page.getAllImages();
        action = page.actions();

        for (WebElement img: imgs) {
            action.moveToElement(img).perform();
        }
    }
}
