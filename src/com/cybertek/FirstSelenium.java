package com.cybertek;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FirstSelenium {

      @FindBy(id = "search-query" )
       static WebElement searchBox;

      @FindBy(css = ".responsive-listing-grid.wt-grid.wt-grid--block.justify-content-flex-start.pl-xs-0" )
      static WebElement searchResults;

      @FindBy(id = "global-enhancements-search-query")
      static WebElement searchBox2;



      public void testAllResults() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Shvednazar994\\Desktop\\Cybertek\\Selenium dependecies\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");
        Thread.sleep(2000);


        if(driver.findElements( By.id("search-query") ).size() != 0) {
            PageFactory.initElements(driver, FirstSelenium.class);

            searchBox.sendKeys("wooden spoon" + Keys.ENTER);

            searchResults.
                    findElements(By.tagName("li")).
                    stream().forEach(x -> System.out.println(
                    x.findElement(By.cssSelector(".text-gray.text-truncate.mb-xs-0.text-body")).
                            getText().toLowerCase().contains("wooden spoon")
            ));

        }else {
            PageFactory.initElements(driver, FirstSelenium.class);
            searchBox2.sendKeys("wooden spoon" + Keys.ENTER);

           searchResults.
                    findElements(By.tagName("li")).
                    stream().forEach(x -> System.out.println(
                            x.findElement(By.cssSelector(".text-gray.text-truncate.mb-xs-0.text-body")).
                                    getText().toLowerCase().contains("wooden spoon")
            ));



        }
        driver.close();
    }
}
