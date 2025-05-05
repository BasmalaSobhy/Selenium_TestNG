package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Tests.Hooks_TestNG;

public class P01_LoginPage_DropDownPage {
    /*  We create a page class for each webpage we have on the website under test

        The page class will be divided into 3 sections:
        1. locators
            >> will have "By" locators for all web elements we have
        2. Actions
            >> will be all performed actions on these locators
        3. Assertions
            >> will be for comparing AR with ER
     */

    /*
        locators:
            we have multiple types of locators:

            1. id >> uses the id attribute of the webElement
                  >> the ID is supposed to be unique across the whole page

            2. className >> uses the class attribute of the webElement
                         >> classes can be used more than one time across the page

            3. tagName >> uses the <tag> of the webElement
                       >> not recommended to use because tags exists more than one time across the page

            4. linkText >> uses the text of an <a> tag
                        >> you have to write the complete sentence

            5. PartialLinkText >> uses the text of <a> tag
                               >> you can use a part of the sentence not the complete sentence

            6. cssSelector >> tagName[attribute = 'value']
                           >> uses any attribute of the element

            7. xPath >> //tagName[@attribute = 'value']
                     >> searches across the html code to find the element that matches this path
     */

    // locators
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");

    By loginButtonLocator = By.className("radius");

    By ElementalSeleniumLinkLocator = By.linkText("Elemental Selenium");
    By ElementalSeleniumLinkLocator2 = By.partialLinkText("Elemental");


    // locators for dropdown page
    By dropdownLocator = By.id("dropdown");


    // Actions for login page
    public WebElement getUsername() {
        return Hooks_TestNG.driver.findElement(usernameLocator);
    }

    public WebElement getPassword() {
        return Hooks_TestNG.driver.findElement(passwordLocator);
    }

    public WebElement getLoginButton() {
        return Hooks_TestNG.driver.findElement(loginButtonLocator);
    }

    // Actions for dropdown Page
    public WebElement dropdown() {
        return Hooks_TestNG.driver.findElement(dropdownLocator);
    }


    // Assertions
        // written in alert page
}
