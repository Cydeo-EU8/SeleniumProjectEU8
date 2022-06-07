package com.cydeo.reviewWithOscar.week05;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCaseWithSingleton {

    @Test
    public void Test(){
        double expectedPrice = 0;
        Driver.getDriver().get("https://www.demoblaze.com/index.html");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// ConfigurationReader.getProperty("category1") ----> returns Laptops
        // add Sony vaio i5
        expectedPrice += ReviewUtils.addProduct(ConfigurationReader.getProperty("category1"),"Sony vaio i5");
        ReviewUtils.getLink("Home");

        // add Samsung galaxy s6
        expectedPrice += ReviewUtils.addProduct(ConfigurationReader.getProperty("category2"),"Samsung galaxy s6");
        // go to Cart
        ReviewUtils.getLink("Cart");
        ReviewUtils.staticWait(3); // PUT one second waiting time

        // delete Samsung galaxy s6
        expectedPrice -= ReviewUtils.removeProduct("Samsung galaxy s6");

        // First get Cart price then click on place order
        double cartPrice = Double.parseDouble(Driver.getDriver().findElement(By.id("totalp")).getText());
        System.out.println("cartPrice = " + cartPrice);
        // click on Place order : //button[.='Place Order']
        System.out.println("expectedPrice = " + expectedPrice);

        Driver.getDriver().findElement(By.xpath("//button[.='Place Order']")).click();
        ReviewUtils.staticWait(2);

        ReviewUtils.fillForm();

        String confirmationText = Driver.getDriver().findElement(By.xpath("//p[@class='lead text-muted ']")).getText();

        String IDtext = Driver.getDriver().findElement(By.xpath("//p[@class='lead text-muted ']//br")).getText();
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

        Driver.closeDriver();

        Driver.getDriver(); // a new empty browser

    }
}
