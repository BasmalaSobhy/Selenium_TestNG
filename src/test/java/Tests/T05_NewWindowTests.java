package Tests;

import Pages.P05_NewWindowPage;
import org.testng.annotations.Test;

public class T05_NewWindowTests extends Hooks_TestNG{

    P05_NewWindowPage windowPage = new P05_NewWindowPage();

    /*
        The driver can only see and handle webElements that are only on the tab of the url you provide
        other tabs or windows the driver can't see them

        Note: the driver can't go to specific tab directly.
        each window has it's handle, it's a unique identifier for each window and it's created when the window runs.
            >> so we can't use it to specify which window I want to switch to

        To make the driver get into specific tab you have to:

            1. you have to get all windows
                >> var windows = driver.getWindowHandles(); >> returns a list of the handles of all open windows

            2. write a for that will loop over all the list of the handles
                >> for(String window : windows){ }

            3. inside the for, you have to move from one window to another until you find the window you want
                >> driver.switchTo().window(window);

            4. inside the for, we have to make a condition to decide which window you want
            and after finding this window you have to break the loop as yu are already in the window you want
                >> if("tabTitle".equals(driver.getTitle())){
	                    break;
	                }

            5. now you find the window you want and get out from the loop

        Note: to know how many tabs or windows are open
            >> windows.size();
     */

    @Test
    public void switchToNewTab() {
        driver.get("https://the-internet.herokuapp.com/windows");
        windowPage.getNewTabLink().click();

        var windows= driver.getWindowHandles();

        System.out.println("Number of open tabs = " + windows.size());

        for(String window : windows) {
            windowPage.switchToTab(window);

            if(windowPage.getTitle().equals("New Window")) {
                break;
            }
        }

        System.out.println(windowPage.getWindowText().getText());
    }

}
