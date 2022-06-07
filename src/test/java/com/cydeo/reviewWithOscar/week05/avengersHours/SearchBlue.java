package com.cydeo.reviewWithOscar.week05.avengersHours;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchBlue extends TestBaseForAvengers {

    @Test
    public void Test(){

        // click products
        ReviewUtils.getLink("Products");

        WebElement searchBox = Driver.getDriver().findElement(By.id("search_product"));

        WebElement searchButton = Driver.getDriver().findElement(By.id("submit_search"));
        searchBox.sendKeys("blue"); // search and enter
         searchButton.click();

         // get the names of products that comes with search

        List<WebElement> elementsList = Driver.getDriver().findElements(By.xpath("//img[contains(@src,'product_picture')]/../p"));

        for (WebElement webElement : elementsList) {
            System.out.println("webElement.getText() = " + webElement.getText());
            Assert.assertTrue(webElement.getText().toLowerCase().contains("blue"));
        }

    }


}
