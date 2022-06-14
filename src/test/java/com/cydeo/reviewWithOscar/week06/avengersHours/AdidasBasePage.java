package com.cydeo.reviewWithOscar.week06.avengersHours;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class AdidasBasePage {

    public AdidasBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void getLink(String link){   // we need instance methods
        Driver.getDriver().findElement(By.partialLinkText(link)).click();
        ReviewUtils.staticWait(1);
    }
}
