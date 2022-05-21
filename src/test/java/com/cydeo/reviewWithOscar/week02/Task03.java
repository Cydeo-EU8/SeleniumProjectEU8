package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task03 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");

        driver.findElement(By.partialLinkText("Laptops")).click();

        ReviewUtils.staticWait(3);

        driver.findElement(By.partialLinkText("Sony vaio i5")).click();


        int expectedPrice = 790;

        ReviewUtils.staticWait(3);
     //   System.out.println("driver.findElement(By.tagName(h3)).getText() = " + driver.findElement(By.tagName("h3")).getText());  // $790 *includes tax

        String priceText = driver.findElement(By.tagName("h3")).getText();
        // int actualPrice = Integer.parseInt(priceText.substring(1,4));
        // priceText.split(" ") is an Array of String
        int actualPrice = Integer.parseInt(priceText.split(" ")[0].substring(1));
        System.out.println("actualPrice = " + actualPrice);

        if(expectedPrice == actualPrice){
            System.out.println("PASSED");
        }else{
            System.exit(-1);
        }

        driver.close();
    }
}
