package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[contains(@title, 'Sign in')]")
    WebElement link;

    public MainPage(WebDriver driver){
        this.webDriver = driver;
        this.wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }

    public void clickF(){
        link.click();
    }
    public void goTo(String url){
        webDriver.get(url);
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Shvednazar994\\Desktop\\Cybertek\\Selenium dependecies\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        driver.get("http://www.qaclickacademy.com/");
        driver.findElement(By.xpath("//a[contains(@href, 'interview')]")).click();
        driver.findElement(By.cssSelector("li#tablist1-tab1")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id = 'tablist1-tab1']/following-sibling::li[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id = 'tablist1-tab1']/following-sibling::li[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id = 'tablist1-tab1']/following-sibling::li[3]")).click();
        Thread.sleep(2000);
        driver.close();
////*[@id="tablist1-tab1"]
    }
}
