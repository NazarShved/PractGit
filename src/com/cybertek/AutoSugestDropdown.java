package com.cybertek;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSugestDropdown {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Shvednazar994\\Desktop\\Cybertek\\Selenium dependecies\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ksrtc.in/");

        WebElement inputW = driver.findElement(By.id("fromPlaceName"));
        inputW.sendKeys("Ben" );
        Thread.sleep(1000);

        inputW.sendKeys(Keys.ARROW_UP);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById(\"fromPlaceName\").value;";

        String value = "";

        while(!value.equalsIgnoreCase("bengaluru airport")){
            System.out.println(value);
            inputW.sendKeys(Keys.DOWN);
            value = (String)js.executeScript(script);
        }
    }
}
