package com.cydeo.reviewWithOscar.week06;

import com.cydeo.reviewWithOscar.week06.pomForReview.WaitTasksPage;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
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
     */

    WaitTasksPage page;  // Declare

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        page = new WaitTasksPage(); // initialize
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
    }

    @Test
    public void Task02(){

    }

}
