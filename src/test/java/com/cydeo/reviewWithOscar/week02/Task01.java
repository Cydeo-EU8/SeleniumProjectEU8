package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task01 {
    public static void main(String[] args) {
// open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
// maximize your page
        driver.manage().window().maximize();
// go to https://practice.cydeo.com/    driver.get(url) ---> to navigate to a website
        driver.get("https://practice.cydeo.com/");

     // then click on "forgot_password" link
     /*
     2 ways of using webElelements : long way or lazy way
      */
        ReviewUtils.staticWait(1);
        // we are using Thread.sleep in a more cleaner syntax
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
        forgotPasswordLink.click();
      // enter any email
        ReviewUtils.staticWait(1);
      WebElement emailBox= driver.findElement(By.name("email"));

      String expectedEmail = "mike.smith@garbage.com";

      emailBox.sendKeys(expectedEmail);

// verify that email is displayed in the input box

    //   String actualEmail = emailBox.getText(); // let's see if it works?
        // not in the text of the element, it is at the 'value' attribute of the webElement
       String actualEmail = emailBox.getAttribute("value"); // let's see if it works?

        // verify the test
       if(actualEmail.equalsIgnoreCase(expectedEmail)){
           System.out.println("PASS email verification");
       }else {
           System.out.println("FAILED email verification");
           System.out.println("actualEmail = " + actualEmail);
           System.out.println("expectedEmail = " + expectedEmail);
       }

       // click on Retrieve password
        // use id
       // driver.findElement(By.id("form_submit")).click();

        // use CSS
      //  driver.findElement(By.cssSelector("#form_submit")).click();

       // using tagName locator, since it is the only one : //button
      //  driver.findElement(By.tagName("//button")).click();

       // use Retrieve word to locate with XPATH : //i[contains(text(),'Retrieve')]
        driver.findElement(By.xpath("//i[contains(text(),'Retrieve')]")).click();


       ReviewUtils.staticWait(1);
       // close or quit the page

        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = driver.findElement(By.name("confirmation_message")).getText();
        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASSED message test!");
        }else{
            System.out.println("FAILED message test!");
        }

        driver.close();

    }
}
