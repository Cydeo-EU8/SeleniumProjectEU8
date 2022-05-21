package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframeTask {
    //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
//2. Switch to iframe.
//3. Get the text “Double-click me to change my text color.” and verify the text

    /*
    What is Iframe and why do we need to handle them?
    Iframes are HTML inside another HTML
    When you automate, in order to interact with WebElements inside the iframe we need to get into that frame
     */

    @Test
    public void iframeTest(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        // we need to change frame
          driver.switchTo().frame("iframeResult");
     //   ReviewUtils.staticWait(2);
   //     driver.switchTo().frame(0);

        ReviewUtils.staticWait(2);
        WebElement demoElement =    driver.findElement(By.id("demo"));

        String demoText = demoElement.getText();

        System.out.println("demoText = " + demoText);

        driver.close();

    }
}
