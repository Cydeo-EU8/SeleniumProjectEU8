package com.cydeo.reviewWithOscar.week06.avengersHours;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AdidasBasePage{

    // when we create object of this class, it will call parent constructor

    @FindBy(xpath = "//h2[@class='name']")
    public WebElement productName;

    // create a method that will locate the price and return the price as double

    public double productPrice() {
        String priceText = Driver.getDriver().findElement(By.tagName("h3")).getText();
        String price = priceText.substring(priceText.indexOf("$") + 1, priceText.indexOf("*") - 1);

        return Double.parseDouble(price); // returns primitive

    }

}
