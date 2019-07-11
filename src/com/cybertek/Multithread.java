package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Multithread extends Thread{
    static WebDriver driver;

    @FindBy(linkText = "Forgot your password ?")
    static WebElement link;

    @Override
    public void run()
    {
        try {

            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\Shvednazar994\\Desktop\\Cybertek\\Selenium dependecies\\Drivers\\chromedriver.exe");


           driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://zero.webappsecurity.com/login.html");
            PageFactory.initElements(driver, Multithread.class);
            link.click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            link.click();

           // driver.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }
}
