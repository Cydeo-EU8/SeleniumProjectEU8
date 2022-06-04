package com.cydeo.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.util.Set;

public class ReviewUtils {

    public static void staticWait(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (Exception e){

        }
    }

    // will be used in demoblaze application, to navigate to different links at the page
    // will click on different elements/links at the page
    public static void getLink(WebDriver driver, String link){
        driver.findElement(By.partialLinkText(link)).click();
        staticWait(1);
    }
    public static void getLink(String link){
        Driver.getDriver().findElement(By.partialLinkText(link)).click();
        staticWait(1);
    }

    public static double addProduct(WebDriver driver,String category, String product){
            getLink(driver,category); // click on category
            getLink(driver,product); // click on product
// Let's get product's price
String priceText = driver.findElement(By.tagName("h3")).getText();
double price = Double.parseDouble(priceText.substring(1,4));

            getLink(driver,"Add to cart");
            Alert alert = driver.switchTo().alert();
            alert.accept();
            return price;
    }
    public static double addProduct(String category, String product){
        getLink(category); // click on category
        getLink(product); // click on product
// Let's get product's price
        String priceText = Driver.getDriver().findElement(By.tagName("h3")).getText();
        double price = Double.parseDouble(priceText.substring(1,4));

        getLink("Add to cart");
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        return price;
    }

    public static void fillForm(WebDriver driver){

        Faker faker = new Faker();
        driver.findElement(By.id("name")).sendKeys(faker.name().fullName());
        driver.findElement(By.id("country")).sendKeys(faker.country().name());
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        driver.findElement(By.id("card")).sendKeys(faker.finance().creditCard());
        driver.findElement(By.id("month")).sendKeys(""+faker.number().numberBetween(1,12));
        driver.findElement(By.id("year")).sendKeys(""+faker.number().numberBetween(2022,2032));
        driver.findElement(By.xpath("//button[.='Purchase']")).click();
        staticWait(2);
    }
    public static void fillForm(){

        Faker faker = new Faker();
        Driver.getDriver().findElement(By.id("name")).sendKeys(faker.name().fullName());
        Driver.getDriver().findElement(By.id("country")).sendKeys(faker.country().name());
        Driver.getDriver().findElement(By.id("city")).sendKeys(faker.address().city());
        Driver.getDriver().findElement(By.id("card")).sendKeys(faker.finance().creditCard());
        Driver.getDriver().findElement(By.id("month")).sendKeys(""+faker.number().numberBetween(1,12));
        Driver.getDriver().findElement(By.id("year")).sendKeys(""+faker.number().numberBetween(2022,2032));
        Driver.getDriver().findElement(By.xpath("//button[.='Purchase']")).click();
        staticWait(2);
    }


    public static void windowHandle(WebDriver driver, String pickDateWindowTitle) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);

            if (driver.getTitle().equals(pickDateWindowTitle)) {
                break;
            }
        }
    }

}
