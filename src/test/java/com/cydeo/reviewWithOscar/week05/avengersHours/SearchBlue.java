package com.cydeo.reviewWithOscar.week05.avengersHours;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchBlue extends TestBaseForAvengers {

    @Test
    public void Test(){

        // click products
        ReviewUtils.getLink("Products");

        WebElement searchBox = Driver.getDriver().findElement(By.id("search_product"));

        WebElement searchButton = Driver.getDriver().findElement(By.id("submit_search"));
        searchBox.sendKeys("blue"); // search and enter
         searchButton.click();

    }


}
