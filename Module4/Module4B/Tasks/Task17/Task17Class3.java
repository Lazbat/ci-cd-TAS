package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task17Class3 {
    //Navigate to the homepage and click on the Widgets tile

    WebDriver driver = null;

    @BeforeClass
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\SeleniumIntro1\\src\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //launch browser
        driver = new ChromeDriver();
        //maximize browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser launched");
    }

    @Test
    public void widgetsPageNavigation() {
        //navigates to the url
        driver.get("https://demoqa.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement widgetsTile = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[4]"));
        widgetsTile.click();
        WebElement widgetHeader = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/span[1]/div[1]/div[1]"));
        String widgetsPage = widgetHeader.getText();
        //Assert that you are on the Widgets page
        Assert.assertEquals(widgetsPage, "Widgets");
        System.out.println("I am on the Widgets page");
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
        System.out.println("Browser closed");
    }

}
