package com.mindtree.runner;

import com.mindtree.reusableComponent.WebDriverHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Clock;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SouledStoreTest  {

    WebDriver driver;
    //@Test
    public void getUrl() throws Exception {
        //Create a instance of ChromeOptions class
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver","D:\\CA_Cucumber\\driver\\chromedriver.exe");

         driver =new ChromeDriver(options);
        //Create a instance of ChromeOptions class
        driver.get("https://www.thesouledstore.com/");
    }
    @Test
    public void getTshrt() throws Exception {
        getUrl();
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[text()='MEN ']")).click();
        WebElement theme = driver.findElement(By.xpath("//div[@class='nav-link dropdown-toggle pointer' and contains(text(),'Themes')]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='nav-link dropdown-toggle pointer' and contains(text(),'Themes')]"))));
        Actions ac = new Actions(driver);
        ac.clickAndHold().moveToElement(theme).build().perform();
        driver.findElement(By.partialLinkText("Spider-Man")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='priceColor' and contains(text(),'Men')]")));


        driver.findElement(By.xpath("//span[@class='priceColor' and contains(text(),'Men')]/parent::label//input")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search for Products']")).sendKeys("Oversized T-Shirts");


        driver.findElement(By.xpath("//div[1]/label/div/span[text()='Oversized T-Shirts']//parent::div//parent::label//parent::div/input")).click();
        driver.findElement(By.xpath("//option[@value='PRICE_H2L']")).click();

        List<WebElement> links = driver.findElements(By.xpath("//div[@class='row']//div[@class='col-lg-3 col-md-6 col-6 animate-card']"));

        for(WebElement wb : links){
            System.out.println(wb.getText());
        }

    }
}

//1. Go to https://www.thesouledstore.com/
//2. Click on Allow Button on the ""This website would like to send you awesome updates and offers!"" popup
//3. Handle the Browser Notification i.e., Allow Browser notification
//4. Click the MENS Tile
//5. Click Spider-Man (TM) from the THEMES List
//6. Select Men from the Gender Section
//7. Search for ""Oversized T-Shirts"" under PRODUCT Section and Select all the values listed
//8. Select Price-High to Low from the Sort By dropdown
//9. Print the Name and Price of items displayed after sorting them in the order High Price to Lowest Price