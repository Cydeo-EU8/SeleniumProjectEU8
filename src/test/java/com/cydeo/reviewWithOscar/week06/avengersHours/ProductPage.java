package com.cydeo.reviewWithOscar.week06.avengersHours;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AdidasBasePage{

    // when we create object of this class, it will call parent constructor

    @FindBy(xpath = "//h2[@class='name']")
    public WebElement productName;

    // create a method that will locate the price and return the price as double

}
