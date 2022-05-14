package com.cydeo.reviewWithOscar.week03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebOrdersTests {

    WebDriver driver; // declare your variable ----> polymorphic way
@BeforeMethod
    public void loginToWebOrders(){  // the name is UP to you
    System.out.println("login steps for application");
   // WebDriver driver = WebDriverFactory.getDriver("chrome"); --> local variable for this method, and CAN NOT be used at the following afterMethod, or Test methods
    driver = WebDriverFactory.getDriver("chrome"); // instantiate or initiate or create

  //   driver = new FirefoxDriver();  it can point to different browser objects
    driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    driver.manage().window().maximize();
    driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
    driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER); // witout locating submit button we directly click enter
}
@AfterMethod
    public void closeBrowser(){
    System.out.println("closing the browser for following test cases");

}

@Test
    public void checkBoxTest(){
    System.out.println("Implementing step 3 and 4 of Test Case 1");
}

@Test
    public void deletePersonTest(){
    System.out.println("Implementing step 3 and 4 of Test Case 2");
}


}
