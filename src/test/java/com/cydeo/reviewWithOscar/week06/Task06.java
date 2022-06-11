package com.cydeo.reviewWithOscar.week06;

import com.cydeo.reviewWithOscar.week06.pomForReview.ContactUsPage;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task06 {


    @Test
    public void Test(){

        Driver.getDriver().get("http://automationexercise.com");

        // create object so that you can use elements and methods
        ContactUsPage page = new ContactUsPage();

        // click contact us
        // page.contactUs.click();
        page.getElement("Contact us").click();

        Faker faker = new Faker();

        page.name.sendKeys(faker.name().fullName());
        page.email.sendKeys(faker.internet().emailAddress());
        page.subject.sendKeys(faker.chuckNorris().fact());
        page.message.sendKeys(faker.howIMetYourMother().catchPhrase());

        String path = "C:/Users/Oscar/Desktop/testFile.txt";

        // to upload file use sendkeys method and provide pat of the file as parameter

        page.uploadFile.sendKeys(path);

        page.submit.click();

        // We get JS ALert -- to click OK button
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();


        String expectedValue = "Success! Your details have been submitted successfully.";
        String actualValue = page.success.getText();

        Assert.assertEquals(actualValue,expectedValue,"Message Test Failed!");


    }
}
