package Tests;

import Pages.P01_LoginPage_DropDownPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;

public class T01_LoginTests_DropDownTests extends Hooks_TestNG {

    P01_LoginPage_DropDownPage loginPage = new P01_LoginPage_DropDownPage();


    /* Manage the window of the browser

       Note: opening the browser, its window will open in small size

    - driver.manage().window().maximize(); >> will increase the window size to max
    - driver.manage().window().fullscreen(); >> will increase it to the fullscreen mode
    - driver.manage().window().minimize(); >> will minimize it like using "-" button

     */
    @Test
    public void controlBrowserWindow() {
        System.out.println("Test");

        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.manage().window().minimize();
    }

    /* Go to specific url

        - driver.get("url"); >> go to this url
     */

    @Test
    public void getToUrl() {
        System.out.println("Test");

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }


    /* Go to specific url

         - driver.navigate().to("url"); >> go to this url
                                and have history feature to go back and forth through urls

         - driver.navigate().back(); >> move in the history to the previous url "←"
         - driver.navigate().forward(); >> move in the history to the previous url "→"
     */

    @Test
    public void navigateToUrl() {

        driver.navigate().to("https://www.google.com");
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        driver.navigate().back();
        driver.navigate().forward();
    }

    /* elements:
        >> each webpage consists of a group of webElements that we need locate to deal with.

        WebElement element = driver.findElement(By.---());

        - element.clear(); >> deletes all the written data inside an input
        - element.sendKeys(""); >> writes the sentence or word in the input
        - element.sendKeys(Keys.---); >> acts like clicking on the special keys of the keyboard
        - element.click(); >> clicks on this link or button
        - element.getText(); >> gets the text inside an element as string
        - element.getTagName(); >> gives us the tag name of an element
        - element.getAttribute("attribute"); >> gets the value of specific attribute

        Note: if the locator you use locate more than one element,
                the first element will be used however that is the one you want or not.

       List<WebElement> elementsList = driver.findElements(By.---()); >> to get more than one element with the same locator

            - for(WebElement element : elementsList) {

                    element.----;
              }



        here we are using the methods created in pages that return a webElement
     */

    @Test
    public void elementActions() {

        driver.get("https://the-internet.herokuapp.com/login");

        loginPage.getUsername().sendKeys("username");
        loginPage.getUsername().clear();
        loginPage.getUsername().sendKeys("tomsmith");
        loginPage.getPassword().sendKeys("SuperSecretPassword!");

        //loginPage.getPassword().sendKeys(Keys.ENTER);
        loginPage.getLoginButton().click();
        //you can login either by clicking enter of click on login button
    }


    /* Dropdown Actions

        To interact with dropdown list we have to create a select object to select items from the dropdown
            >> Select select = new Select(WebElement); >> WebElement = driver.findElement(By.--());

            - select.selectByVisibleText(""); >> select by the text you see in the dropdown list
            - select.selectByIndex(); >> select by the index of the option (starting from 0)
            - select.selectByValue(); >> select by the value attribute

            - select.getFirstSelectedOption(); >> result in a webElement of the selected option
            - select.getAllSelectedOptions(); >> return a list of all selected items (even if its only one selected item)

           Note: deselect can only be used with dropdown lists that allows you to select more than one option
            - select.deselectAll(); >> deselect all selected options
            - select.deselectByIndex(); >> deselect by the index of the option (starting from 0)
            - select.deselectByValue(); >> deselect by the value attribute

           Note: you can't select a disabled option
     */

    @Test
    public void selectFromDropDownList() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(loginPage.dropdown());
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("1");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        // This list will contain only one webElement
        List<WebElement> selectedElements = select.getAllSelectedOptions();
        for(WebElement element: selectedElements) {
            System.out.println(element.getText());
        }
    }
}
