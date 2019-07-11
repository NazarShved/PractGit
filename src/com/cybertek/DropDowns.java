package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DropDowns {
//    @FindBy (css = "a[href = '*']")
//   static List<WebElement> list;
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Shvednazar994\\Desktop\\Cybertek\\Selenium dependecies\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");

        WebElement adultsQty = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
        Select adultsDD = new Select(adultsQty);
        adultsDD.selectByValue("USD");

        driver.findElement(By.cssSelector("#divpaxinfo")).click();

        Thread.sleep(1000);
        int i =0;

            for ( i = 0; i < 5;i++ ) {
                driver.findElement(By.id("hrefIncAdt")).click();
            }

        driver.findElement(By.id("btnclosepaxoption")).click();
        //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@value = 'CCJ']")).click();

        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        driver.findElement(By.xpath("(//a[@value = 'HBX'])[2]")).click();

        //driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();


//        for (int j = 1; j < 70; j++){
//            //String str = list.get(j).getText();
//            //if(str.length() < 5) continue;
//            //Thread.sleep(1000);
//            driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//            Thread.sleep(500);
//            driver.findElement(By.xpath("(//*[@id = 'dropdownGroup1']/div//a[@href = '#'])["+j+"]")).click();
//
//           // driver.findElement(By.xpath("//a[@text = '" + str + "']")).click();
//            Thread.sleep(1000);
//        }
//        driver.findElement(By.linkText("30")).click();
//        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        //ui-datepicker-div id month window
        //1stclass window ui-datepicker-group ui-datepicker-group-first
        //2ndclass window ui-datepicker-group ui-datepicker-group-last
        //ui-datepicker-month month class

        if(driver.findElement(By.cssSelector(".ui-datepicker-month"))
                .getText().equalsIgnoreCase("november")) {
            driver.findElement(By.linkText("20")).click();
        }else{
            //boolean check = false;
            while(true){
                if(driver.findElements(By.cssSelector(".ui-datepicker-month")).get(1)
                        .getText().equalsIgnoreCase("november")){
                    driver.findElements(By.linkText("20")).get(1).click();
                    break;
                }
                driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
            }
           // driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        }

        System.out.println(driver.findElement(By.id("view_fulldate_id_1")).getText() + " 00");

    }
}
