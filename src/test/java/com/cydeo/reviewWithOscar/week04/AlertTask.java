package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AlertTask {
    /*
    You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
• Customer navigation through product categories: Phones, Laptops and Monitors
• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
     */

    @Test
    public void alertTest(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.demoblaze.com/index.html");

        // Navigate to "Laptop": call the utility method
        ReviewUtils.getLink(driver,"Laptops");

        ReviewUtils.getLink(driver,"Sony vaio i5");

        ReviewUtils.getLink(driver,"Add to cart");

        // After this step I should see the ALERT

        Alert alert = driver.switchTo().alert();  // How did you use Polymorphism in your framework?
        alert.accept(); // dismiss will also work

        driver.close();
    }
}
