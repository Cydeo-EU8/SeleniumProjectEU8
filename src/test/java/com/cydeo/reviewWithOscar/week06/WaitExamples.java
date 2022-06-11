package com.cydeo.reviewWithOscar.week06;

import com.cydeo.reviewWithOscar.week06.pomForReview.WaitTasksPage;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitExamples {
    /*
     Task1:
    1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    2. Click on "Click me, to Open an alert after 5 seconds"
    3. Explicitly wait until alert is present
    4. Then handle the Javascript alert

      Task2:
    1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    2. Click on "Enable button after 10 seconds"
    3. Explicitly wait until the button is enabled
    4. Then verify the button is enabled

     */

    WaitTasksPage page;  // Declare
    WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        page = new WaitTasksPage(); // initialize
        wait = new WebDriverWait(Driver.getDriver(),12);
    }
    @AfterMethod()
    public void tearDown(){
        // screenshot option - if your test case fail you will need screenshot
        ReviewUtils.staticWait(2); // optional
        Driver.closeDriver();
    }

    @Test
    public void Task01(){
        page.alertActivate.click();
// selenium.NoAlertPresentException: no such alert
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @Test
    public void Task02(){

        page.enable.click();

        wait.until(ExpectedConditions.elementToBeClickable(page.disable));
        Assert.assertTrue(page.disable.isEnabled(),"Button has NOT been enabled YET!");

        /*
        TimeoutException: Expected condition failed: waiting for element to be clickable:
        Since we initialized our wait object as 8 seconds, the time went out
         */

    }

}
