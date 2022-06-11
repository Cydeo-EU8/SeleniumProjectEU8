package com.cydeo.reviewWithOscar.week06.pomForReview;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    // first step of POM is constructor
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // second step common locators and methods for the application
    @FindBy(xpath = "//a[.=' Contact us']") // can NOT pass a variable name
    public WebElement contactUs;


    public WebElement getElement(String str){
       return Driver.getDriver().findElement(By.partialLinkText(str));
    }

    // Can I use findElements method with @FindBy
    @FindBy(tagName = "a")
    public List<WebElement> links;

}
