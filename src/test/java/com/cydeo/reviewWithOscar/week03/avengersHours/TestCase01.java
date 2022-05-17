package com.cydeo.reviewWithOscar.week03.avengersHours;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase01 {
    /*
   1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    WebDriver driver; // Declare your variable global
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome"); // initialize your variable
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void Test1() {
        driver.get("http://automationexercise.com");

        // Verify that home page is visible successfully : What they mean? --> Verify that you have Hope Page URL and Title, another option verify that test cases button is displayed
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        // verify Title
        Assert.assertEquals(actualTitle, expectedTitle, "Home Page is NOT displayed");

        // Click on 'Signup / Login' button
        driver.findElement(By.partialLinkText("Signup")).click();

        String name = "Scolfield";
        String email = "scolfield@test.com";

        // Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        Assert.assertTrue(newUser.isDisplayed());
    }

}
