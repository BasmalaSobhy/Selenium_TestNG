package Tests;

import Pages.P02_AlertPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class T02_AlertTests extends Hooks_TestNG {

    P02_AlertPage alertPage = new P02_AlertPage();
    Alert alert;

   /* Alert Actions

       Alert alert = driver.switchTo().alert(); >> to move the access from the browser window
                                                   to the small window of the alert

          - alert.accept(); >> click the OK button on an alert
          - alert.dismiss(); >> click on this cancel button on an alert
          - alert.sendKeys(); >> send word or sentence to an input on an alert

     */

    @Test
    public void dealWithAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        alertPage.clickOnJSConfirm().click();
        alert = driver.switchTo().alert();
        alert.accept();

        alertPage.clickOnJSConfirm().click();
        alert = driver.switchTo().alert();
        alert.dismiss();

        alertPage.clickOnJsPrompt().click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Alert");
        alert.accept();
    }

    @Test
    public void listOfElements() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        List<WebElement> elementsList = alertPage.getAllButtons();

        for(WebElement element : elementsList) {

            System.out.println(element.getText());
        }
    }

    @Test
    public void usingPassHardAssertion() { // This will pass
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        alertPage.clickOnJsPrompt().click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Alert");
        alert.accept();

        String AR = alertPage.getResult().getText();
        alertPage.assertResult(AR, "You entered: Alert","Check HardAssertion");
        alertPage.assertTrueResult(AR, "You entered","Check HardAssertion2");
    }
    @Test
    public void usingFailHardAssertion() { // This will fail
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        alertPage.clickOnJsPrompt().click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Assert");
        alert.accept();

        alertPage.softAssertion();
        String AR = alertPage.getResult().getText();
        alertPage.assertResult(AR, "You entered: Alert", "Check HardAssertion"); // This should fail
        alertPage.assertTrueResult(AR, "Alert", "Check HardAssertion2"); // This should fail

        // This will show only one failed assertion
    }

    @Test
    public void usingPassSoftAssertion() { // This will fail
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Alert alert;

        alertPage.clickOnJsPrompt().click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Assert");
        alert.accept();

        alertPage.softAssertion();
        String AR = alertPage.getResult().getText();
        alertPage.assertResult(AR, "You entered: Assert"); // This should fail
        alertPage.assertTrueResult(AR, "You get"); // This should pass
        alertPage.assertAll();
    }

    @Test
    public void usingFailedSoftAssertion() { // This will fail
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Alert alert;

        alertPage.clickOnJsPrompt().click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Assert");
        alert.accept();

        String AR = alertPage.getResult().getText();
        alertPage.assertResult(AR, "You entered: Alert"); // This should fail
        alertPage.assertTrueResult(AR, "Alert"); // This should fail
        alertPage.assertAll(); // will show both failed assertions
    }
}
