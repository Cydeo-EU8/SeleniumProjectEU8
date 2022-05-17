package com.cydeo.reviewWithOscar.week03.avengersHours;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

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
    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome"); // initialize your variable
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test
    public void Test1_1() {


        // Verify that home page is visible successfully : What they mean? --> Verify that you have Hope Page URL and Title, another option verify that test cases button is displayed
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        // verify Title
        Assert.assertEquals(actualTitle, expectedTitle, "Home Page is NOT displayed");

        // Click on 'Signup / Login' button
        driver.findElement(By.partialLinkText("Signup")).click();

    }

    @Test
    public void Test1_2(){
        String name = "Scolfield";
        String email = "scolfield@test.com";
        // Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        Assert.assertTrue(newUser.isDisplayed());
        // Enter name and email address
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement emailBox = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        nameBox.sendKeys(name);
        emailBox.sendKeys(email);
        // click sign up button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

    }
    @Test
    public void Test1_3(){

        //  Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2/b[.='Enter Account Information']")).isDisplayed(),"ENTER Account Details Fields Are NOT Displayed");
    }

    @Test
    public void Test1_4(){
        // Select United States and verify that it is selected
        // locate your DropDown Element
        WebElement country = driver.findElement(By.id("country"));
        // Create your Select Class object with using this locator as parameter for Constructor
        Select countryDropDown = new Select(country);
        countryDropDown.selectByVisibleText("United States");

        List<WebElement> allOptions = countryDropDown.getOptions();
        for (WebElement eachOption : allOptions) {
            System.out.println(eachOption.getText());
        }
        BrowserUtils.sleep(3);
        String expectedText = "United States";
        String actualText = countryDropDown.getFirstSelectedOption().getText(); // brings you the selected option
        Assert.assertEquals(actualText,expectedText,"Country WAS NOT selected correctly");
    }

}
