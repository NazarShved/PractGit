package com.cybertek;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Test {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Shvednazar994\\Desktop\\Cybertek\\Selenium dependecies\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/20273/nz-vs-aus-match-37-icc-cricket-world-cup-2019");

        //cb-col cb-col-100 cb-ltst-wgt-hdr  whole table
        //cb-col cb-col-8 text-right text-bold

        int count = 0;
        List<WebElement> list = driver.findElement(By.cssSelector(".cb-col.cb-col-100.cb-ltst-wgt-hdr")).
                findElements(By.cssSelector(".cb-col.cb-col-8.text-right.text-bold"));
        System.out.println(list.size());
        for(int i = 0; i < list.size()-1; i++){
            String str = list.get(i).getText();
            System.out.println(str);
            if(str.length() < 1) continue;
            if(!Character.isDigit(str.charAt(0))) continue;
            count += Integer.parseInt(list.get(i).getText());
        }

        System.out.println(count == Integer.parseInt(list.get(list.size()-1).getText()));

        TakesScreenshot tk = (TakesScreenshot)driver;
        File scrsht = tk.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scrsht, new File("C:/Users/Shvednazar994/Desktop/screenshot.png"));
    }




}