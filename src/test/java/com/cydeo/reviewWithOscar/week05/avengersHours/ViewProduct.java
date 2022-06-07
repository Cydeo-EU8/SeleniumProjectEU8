package com.cydeo.reviewWithOscar.week05.avengersHours;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ViewProduct extends TestBaseForAvengers{

    @Test
    public void Test(){

        // find how many products

        List<WebElement> productElements = Driver.getDriver().findElements(By.xpath("//a[.='View Product']"));

        int numberOfProducts = productElements.size();
        System.out.println("numberOfProducts = " + numberOfProducts);

        Random random = new Random();
        int randomProductNumber = random.nextInt(numberOfProducts);

        Driver.getDriver().findElement(By.xpath("(//a[.='View Product'])["+randomProductNumber+"]")).click();

        // Verify product detail is opened
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("product_details"));

        WebElement quantityBox = Driver.getDriver().findElement(By.id("quantity"));
        quantityBox.clear();
        quantityBox.sendKeys("4");

        int expectedValue = 4;
        int actualValue = Integer.parseInt(quantityBox.getAttribute("value"));
        Assert.assertEquals(actualValue,expectedValue);

    }


}
