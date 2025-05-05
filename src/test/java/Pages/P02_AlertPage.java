package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import Tests.Hooks_TestNG;

import java.util.List;

public class P02_AlertPage {

    // locators for alert page
    By jsConfirmLocator = By.cssSelector("button[onclick=\"jsConfirm()\"]");
    By jsPromptLocator = By.xpath("//button[@onclick=\"jsPrompt()\"]");
    By resultLocator = By.id("result");
    By allButtonsLocator = By.tagName("button");

    // Actions
    public WebElement clickOnJSConfirm() {
        return Hooks_TestNG.driver.findElement(jsConfirmLocator);
    }

    public WebElement clickOnJsPrompt() {
        return Hooks_TestNG.driver.findElement(jsPromptLocator);
    }

    public WebElement getResult() {
        return Hooks_TestNG.driver.findElement(resultLocator);
    }

    public List<WebElement> getAllButtons() {
        return Hooks_TestNG.driver.findElements(allButtonsLocator);
    }

    /*
        Assertions:
            There are 2 type of assertions in TestNG

            1. Hard Assertion : This compare AR with ER and if the result is fail(AR!=ER)
                                then it will stop completing the remaining commands of this test
                                however it will continue running any other test

                            >> Assert.----();

            2. Soft Assertion : This compare AP with ER and collects the result of every soft assert
                                and store it in AssertAll() so if any fail(AR!=ER) the test won't stop running

                             >> SoftAssert soft = new SoftAssert();
                             >> soft.----();
                             >> soft.AssertAll();


         >> both soft and hard assertions have these 4 types of:

         1. AssertTrue("AR", "message") >> it will compare if the AR is true (pass) or not(fail)

         2. AssertFalse("AR", "message") >> it will compare if the AR is false (pass) or not(fail)

         3. AssertEquals("AR", "ER", "message") >> it will compare if the AR equals the ER(pass) or not (fail)

         4. AssertNotEquals("AR", "ER", "message") >> it will compare if the AR not equals the ER(pass) or not (fail)

        Note: Equals check for match between AR and ER to avoid that we can use
                AssertTrue(AR.contains(ER)); >> which search if the ER sentence is part of the whole sentence of the AR

         Note: message here will be shown only if the assertion is fail,
                it's a message which you write for yourself as a note when failure to know what happens
     */

    // Assertions of the alert page
    SoftAssert soft;
    public void softAssertion() {
        soft = new SoftAssert();
    }

    // hard assertion
    public void assertResult(String AR, String ER, String message) {
        Assert.assertEquals(AR, ER, message);
    }

    // soft assertion
    public void assertResult(String AR, String ER) {
        soft.assertEquals(AR, ER);
    }

    public void assertTrueResult(String AR, String ER, String message) {
        Assert.assertTrue(AR.contains(ER), message);
    }

    public void assertTrueResult(String AR, String ER) {
        soft.assertFalse(AR.contains(ER));
    }

    public void assertAll() {
        soft.assertAll();
    }
}
