package com.cydeo.reviewWithOscar.week05.avengersHours;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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


    }


}
