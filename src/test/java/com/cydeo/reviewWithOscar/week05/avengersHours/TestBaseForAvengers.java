package com.cydeo.reviewWithOscar.week05.avengersHours;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBaseForAvengers {

    @BeforeMethod
    public void setUpTestEnvironment(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlExercise"));
//        Driver.getDriver().manage().window().maximize();
//        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
   //     Driver.closeDriver();
    }


}
