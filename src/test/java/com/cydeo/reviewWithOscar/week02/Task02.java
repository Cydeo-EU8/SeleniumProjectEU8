package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task02 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        // title verification before log-in
        String expectedTitleBeforeLogin = "Web Orders Login";
       if(expectedTitleBeforeLogin.equals(driver.getTitle())){
            System.out.println("success");
        }else {
            System.exit(-1);
        }

        WebElement userNameBox = driver.findElement(By.id("ctl00_MainContent_username"));
       WebElement passwordBox = driver.findElement(By.id("ctl00_MainContent_password"));
       WebElement signInButton = driver.findElement(By.id("ctl00_MainContent_login_button"));

        userNameBox.sendKeys("Tester");
        passwordBox.sendKeys("test");
        signInButton.click();

        String expectedHomePageTitle = "Web Orders";
        if(expectedHomePageTitle.equals(driver.getTitle())){
            System.out.println("PASSED");
        }else{
            System.exit(-1);
        }

        ReviewUtils.staticWait(2);
       driver.close();

    }
}
