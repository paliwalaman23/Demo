package com.mindtree.runner;

import com.mindtree.reusableComponent.BrowserStackBaseTest;
import com.mindtree.reusableComponent.WebDriverHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;


public class Demo  extends BrowserStackBaseTest {

    WebDriver driver;

  Logger log = Logger.getLogger(Demo.class);
    //@BeforeTest()
    public void getURL() throws Exception {
        WebDriverHelper.initializeDriver();
        driver  = WebDriverHelper.getDriver();
        driver.get("");
        if(driver.getTitle().contains("USI-EH25-Consulting-CBO-AMI-QE-Consultant-Automation Selenium")){
            Assert.assertTrue(true);
            log.info("");
        }
        else
            log.info("");
    }
    @Test
    public void getTshrt() throws Exception {
        getURL();
        Actions ac = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-group='men']")));
        ac.clickAndHold().moveToElement(driver.findElement(By.xpath("//a[@data-group='men']"))).build().perform();
        driver.findElement(By.xpath("//a[text()='T-Shirts']")).click();

        if(driver.findElement(By.xpath("//h1[text()='Men T-shirts']")).isDisplayed()){
            Assert.assertTrue(true);
            log.info("All Tshirts has been displayed");
        }
        else{
            Assert.assertTrue(false);
            log.info("");
        }
        driver.findElement(By.xpath("//input[@placeholder='Search for Brand']/following-sibling::span")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search for Brand']")).sendKeys("Van Heusen");
        driver.findElement( By.xpath("//label[@class='vertical-filters-label common-customCheckbox']")).click();

        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']"));
        for(WebElement element: elements) {
            System.out.println(element.getText());
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
