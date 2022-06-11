package com.cydeo.reviewWithOscar.week06.webstaurantTask;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {
    @Test
    public void Test(){
        Driver.getDriver().get("https://www.webstaurantstore.com/");

        SearchResultPage page = new SearchResultPage();
        page.searchBox.sendKeys("Stainless Work Table"+ Keys.ENTER);

        List<WebElement> resultList = page.resultList;

        for (WebElement eachElement : resultList) {
            Assert.assertTrue(eachElement.getText().toLowerCase().contains("table"));
        }



    }
}
