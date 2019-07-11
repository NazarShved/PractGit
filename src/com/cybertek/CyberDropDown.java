package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CyberDropDown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Shvednazar994\\Desktop\\Cybertek\\Selenium dependecies\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Amazon")).click();

        WebElement links = driver.findElement(By.cssSelector("select[name = 'Languages']"));
        Select select = new Select(links);

       select.selectByVisibleText("Ruby");


    }
}
