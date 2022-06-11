package com.cydeo.reviewWithOscar.week06;

import com.cydeo.reviewWithOscar.week06.pomForReview.ContactUsPage;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
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




    }
}
