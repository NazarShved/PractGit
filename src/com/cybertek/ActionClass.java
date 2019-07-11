package com.cybertek;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ActionClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Shvednazar994\\Desktop\\Cybertek\\Selenium dependecies\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.qaclickacademy.com/practice.php");

        driver.findElement(By.id("autocomplete")).sendKeys("uni");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "return document.getElementById(\"autocomplete\").value;";

        String value = "";

        int count = 0;
        while(!value.equalsIgnoreCase("united states") && count++ < 10){
            driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
            value = (String)js.executeScript(script);
            System.out.println(value);
        }
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
    }
}
