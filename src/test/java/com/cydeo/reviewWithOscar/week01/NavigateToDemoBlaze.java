package com.cydeo.reviewWithOscar.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToDemoBlaze {

    public static void main(String[] args) {

        // https://www.demoblaze.com/index.html
        // Verify Title "STORE"

        // Analogy: Taxi Driver Example
        // taxi car: browser-Chrome, taxiDriver: Selenium Webdriver- who can drive this particular car

        WebDriverManager.chromedriver().setup(); // I am setting up my taxi driver

        WebDriver driver = new ChromeDriver(); // the car itself --- This line opens an empty Chrome webPage
        // there is polymorphisim: WebDriver is a interface , ChromeDriver is the concrete class

        driver.get("https://www.demoblaze.com/index.html");

      //  driver.navigate().to("https://www.demoblaze.com/index.html");

        String expectedTitle = "STORE";  // comes from documentation, SRS: system requirements specification
        // we have getTitle() method in Selenium WebDriver library
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);



        // As a tester, without verification/validation what is your VALUE to the Company
        if(expectedTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Fail");
        }

    }

}
