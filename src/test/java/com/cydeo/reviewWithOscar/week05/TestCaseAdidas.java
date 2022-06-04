package com.cydeo.reviewWithOscar.week05;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseAdidas extends TestBase {

   @Test
    public void Test(){
       double expectedPrice = 0;
       driver.get("https://www.demoblaze.com/index.html");
// ConfigurationReader.getProperty("category1") ----> returns Laptops
      expectedPrice += ReviewUtils.addProduct(driver, ConfigurationReader.getProperty("category1"),"Sony vaio i5");
      ReviewUtils.getLink(driver,"Home");
      expectedPrice += ReviewUtils.addProduct(driver,ConfigurationReader.getProperty("category2"),"Samsung galaxy s6");
        // go to Cart
       ReviewUtils.getLink(driver,"Cart");
        ReviewUtils.staticWait(3); // PUT one second waiting time
      // First get Cart price then click on place order
     double cartPrice = Double.parseDouble(driver.findElement(By.id("totalp")).getText());
       System.out.println("cartPrice = " + cartPrice);
      // click on Place order : //button[.='Place Order']
       System.out.println("expectedPrice = " + expectedPrice);

       driver.findElement(By.xpath("//button[.='Place Order']")).click();
       ReviewUtils.staticWait(2);

       ReviewUtils.fillForm(driver);

       String confirmationText = driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();

       String IDtext = driver.findElement(By.xpath("//p[@class='lead text-muted ']//br")).getText();
       System.out.println("IDtext = " + IDtext);
       System.out.println("confirmationText = " + confirmationText);
       /*
    Id: 8761753
    Amount: 1150 USD
    Card Number: 3436-094090-48661
    Name: Mrs. Tracey Kuhlman
    Date: 4/5/2022
        */
       
       String ID = confirmationText.split("\n")[0];
       double actualPrice = Double.parseDouble(confirmationText.split("\n")[1].split(" ")[1]);

       System.out.println(ID);
       System.out.println("actualPrice = " + actualPrice);

       Assert.assertEquals(actualPrice,expectedPrice);
       Assert.assertEquals(cartPrice,expectedPrice);
       

   }


}
