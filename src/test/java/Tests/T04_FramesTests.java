package Tests;

import Pages.P04_Frames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T04_FramesTests extends Hooks_TestNG{

    P04_Frames frames = new P04_Frames();

    /*
        The webPage can have an embedded webpage (page within the page) (frame that contains a page inside the main page) like this
            >> https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe_frameborder_css

        the driver can only see the webElement of the iframe not the page inside the frame
            >> driver.switchTo().frame(webElement) >> used to move the driver inside the frame
                >> when the driver is inside the frame, it can only see the elements inside that frame only

        To move back to the main page (or the parent of that frame)
            >> driver.switchTo().parentFrame();
     */

    @Test
    public void getBottomFrameText() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        frames.switchToBottomFrame();
        System.out.println(frames.getFrameText().getText());
    }

    @Test
    public void getLeftFrameText() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        frames.switchToTopFrame();
        frames.switchToLeftFrame();
        System.out.println(frames.getFrameText().getText());

        // move from left frame to the bottom frame
        // moving up to the top frame then up to the main page then to bottom frame
        frames.switchBack();
        frames.switchBack();
        frames.switchToBottomFrame();
        System.out.println(frames.getFrameText().getText());
    }
}
