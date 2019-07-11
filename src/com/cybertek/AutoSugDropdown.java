package com.cybertek;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoSugDropdown {
    WebDriver driver = null;
    //WebDriverWait wait = new WebDriverWait(driver ,3);

    @BeforeClass
    public void setUp(){
      // WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Shvednazar994\\Desktop\\Cybertek\\Selenium dependecies\\Drivers\\chromedriver.exe");


        driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
    }

    @Test(priority = 1)
    public void currencySel(){
        WebElement currency = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
        Select curr = new Select(currency);
        curr.selectByValue("USD");
        Assert.assertEquals(curr.getFirstSelectedOption().getText(), "USD");
    }

//    @Test(priority = 2)
//    public void adultsCount() throws InterruptedException {
//        WebElement adultsWindow = driver.findElement(By.cssSelector("#divpaxinfo"));
//        adultsWindow.click();
//
//        int i =0;
//        for ( i = 0; i < 5;i++ ) {
//            driver.findElement(By.id("hrefIncAdt")).click();
//        }

//        driver.findElement(By.id("btnclosepaxoption")).click();
//        Assert.assertEquals(adultsWindow.getText().charAt(0), '6');
//    }


    @Test(priority = 3)
    public void depCity() throws InterruptedException {
        WebElement depWind = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        depWind.click();

        driver.findElement(By.xpath("//a[@value = 'BOM']")).click();
        Thread.sleep(1000);
        Assert.assertEquals(depWind.getAttribute("value"), "Mumbai (BOM)");
    }

    @Test(priority = 4)
    public void arrCity(){
        WebElement arrWind = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
        arrWind.click();
        driver.findElement(By.xpath("(//a[@value = 'HBX'])[2]")).click();
        Assert.assertEquals(arrWind.getAttribute("value"), "Hubli (HBX)");
    }

    @Test(priority = 5)
    public void claendarTest(){
        if(driver.findElement(By.cssSelector(".ui-datepicker-month"))
                .getText().equalsIgnoreCase("november")) {
            driver.findElement(By.linkText("20")).click();
        }else{
            while(true){
                if(driver.findElements(By.cssSelector(".ui-datepicker-month")).get(1)
                        .getText().equalsIgnoreCase("november")){
                    driver.findElements(By.linkText("20")).get(1).click();
                    break;
                }
                driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
            }

        }

        Assert.assertEquals(driver.findElement(By.id("view_fulldate_id_1")).getText() ,"Wed, Nov 20 2019");
    }

    @AfterTest
    public void closeDown(){
        driver.close();
    }


}
