package com.cybertek;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testing {
   static WebDriver driver = null;
    @FindBy(id = "email")
   static WebElement inputField;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Shvednazar994\\Desktop\\Cybertek\\Selenium dependecies\\Drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30,500);

        driver.get("https://the-internet.herokuapp.com/forgot_password");
        Thread.sleep(3000);
        PageFactory.initElements(driver, Testing.class);
        inputField.clear();
        inputField.sendKeys("mama@gmail.com" + Keys.ENTER);
    }

    @Test
    public void checkUrl(){
        Assert.assertEquals(true, driver.getCurrentUrl().contains("email_sent"));
    }

    @Test
    public void  checkMessage(){
       Assert.assertTrue(driver.findElement(By.id("content")).getText().equalsIgnoreCase("Your e-mail's been sent!"));
    }

    @After
    public void coverUp(){
        driver.quit();
    }
}
