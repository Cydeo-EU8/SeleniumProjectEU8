package com.cydeo.reviewWithOscar.week06;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTask {
    /*
    Task3:
    1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    2. Login with username: Tester, password: test
    3. Click  Order button
    4. Verify under Product Information, selected option is “MyMoney”
    5. Then select FamilyAlbum, make quantity 2, and click Calculate,
    6. Then verify Total is equal to Quantity*PricePerUnit
     */

    @Test
    public void Task03(){
        // Go to page
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        // Log in
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

        // click on Order
        Driver.getDriver().findElement(By.linkText("Order")).click();

        /*
        How do we use Select class methods:
        1. Dropdown should have Select tag
        2. Find locator for the dropdown
        3. Create select class object by passing  located webElement as Constructor parameter
         */

        WebElement dropDownElement = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        Select dropDown = new Select(dropDownElement);
        // selected option should be “MyMoney” when you click Order button: getFirstSelectedOption method
        String expectedValue ="MyMoney";
        String actualValue = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualValue,expectedValue,"Default Option Test Failed");

        // select FamilyAlbum
        dropDown.selectByVisibleText("FamilyAlbum");
        ReviewUtils.staticWait(2);
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),"FamilyAlbum");

        WebElement quantityInput = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
      //  quantityInput.clear();
      //  quantityInput.sendKeys("2");

        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(quantityInput).sendKeys("2").perform();

    }

}
