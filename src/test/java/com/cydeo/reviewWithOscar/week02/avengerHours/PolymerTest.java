package com.cydeo.reviewWithOscar.week02.avengerHours;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PolymerTest {
     /*
    Here is this week's task:
Write a basic browser automation framework to validate a Polymer website.
The focus should be on the interaction with the browser.
The Web Application under test http://todomvc.com/
    The first step should be to load the website,
    click within the JavaScript tab,
    and select the Polymer link.
    The second step should be: Add one Todo item
    Then Verify that the item added.
     */

     static WebDriver driver;  // when we declare a variable outside main method, it becomes global variable, so it can be usable at other methods inside class
    public static void main(String[] args) {

        // The first step should be to load the website
        // From Selenium Library (Version 3 - pom.xml: dependency) we use WebDriver Interface, and with a polymorphic way we create driver instance
        // driver instance initiates a 'session', until we say driver.close or driver.quit
        driver = WebDriverFactory.getDriver("chrome"); // opens an empty Chrome browser

        // our driver object brings us many useful methods from the library
        driver.get("http://todomvc.com/");
        // maximize page
        driver.manage().window().maximize();

        // click within the JavaScript tab
// (//div[contains(@class,'tab-content')])[1] with dynamic formula
       // WebElement JSElement = driver.findElement(By.xpath("//div[.='JavaScript']"));

        // why do we locate a webelement? to do an action on it
        // JSElement.click();
        getTab("JavaScript");
    /*    HandleWait.staticWait(1);
        // if We want to click other Tabs: just call this reusable method
        getTab("Compile-to-JS");
        HandleWait.staticWait(1);
        getTab("Labs");
        HandleWait.staticWait(1);
        getTab("JavaScript");*/
        // and select the Polymer link.
        WebElement polymerLink = driver.findElement(By.linkText("Polymer"));
        polymerLink.click();


        // The second step should be: Add one Todo item

        String toDoItem = "This Todo Item is added by user";

        ReviewUtils.staticWait(1);
        WebElement toDoBox = driver.findElement(By.id("new-todo"));
        toDoBox.sendKeys(toDoItem+Keys.ENTER);

        // to locate the weblement for item we entered: //label[.='customText']

      //  String locator = "//label[.='customText']";  // I want to use text I am sending as String variable
        String locator = "//label[.='"+toDoItem+"']";
        ReviewUtils.staticWait(1);
        WebElement customToDOItem = driver.findElement(By.xpath(locator));

        if(customToDOItem.isDisplayed()){
            System.out.println("We added our toDO item successfully");
        }

        driver.close();  // driver.quit() to close all opened windows of that session
    }


    // create a method that accepts String parameter which is Tab Text
    // this method will click on that Tab

    public static void getTab(String tabText){  // main method is static method.
        // I can NOT use an instance method inside static method, so we declare this method static
        // Second problem was our driver object, we had to make it global and static
        WebElement tab = driver.findElement(By.xpath("//div[.='"+tabText+"']"));
        tab.click();
    }
}
