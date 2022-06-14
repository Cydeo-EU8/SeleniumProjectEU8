package com.cydeo.reviewWithOscar.week06.avengersHours;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class TestAdidasPOM {
    ProductPage page = new ProductPage();
    @BeforeMethod
    public void testSetUp(){
        Driver.getDriver().get("https://www.demoblaze.com/index.html");
    }
    @AfterMethod
    public void testTearDown(){
        Driver.closeDriver();

    }


    @Test
    public void Test(){
        /*
        Navigate to home page
        click Laptops, and assert that the list of Laptops match expected
         */



        // create object for POM locators and methods

        page.getLink("Laptops");

        List<String> expectedProducts = new ArrayList<>();
        expectedProducts.addAll(Arrays.asList("MacBook Pro","Sony vaio i5","Sony vaio i7","MacBook air","Dell i7 8gb","2017 Dell 15.6 Inch"));

        Collections.sort(expectedProducts);

//        Set<String> setProducts = new LinkedHashSet<>();
//        setProducts.addAll(expectedProducts);
//        Collections.sort(setProducts);

     //   List<WebElement> products = page.products;
        List<String> actualProducts = ReviewUtils.getElementsTexts(page.products);

        Collections.sort(actualProducts);

        Assert.assertEquals(actualProducts,expectedProducts);




    }

    @Test
    public void Test2(){
/*
Go to Home page
click on Sony Vaio i7
and verify the product price is 790
 */
        page.getLink("Laptops");
        page.getLink("Sony vaio i7");

        double expectedPrice = 790.0;

        double actualPrice = page.productPrice();

        Assert.assertEquals(actualPrice,expectedPrice);
    }

}
