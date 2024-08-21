package com.mindtree.pageObjects;


import com.mindtree.uistore.FlipkartProductUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartProductPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public FlipkartProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void selectFirstProduct() {
        wait.until(ExpectedConditions.presenceOfElementLocated(FlipkartProductUI.firstProduct)).click();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }

    public boolean isProductOutOfStock() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FlipkartProductUI.outOfStockMessage));
            WebElement outOfStockElement = driver.findElement(FlipkartProductUI.outOfStockMessage);
            return outOfStockElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(FlipkartProductUI.addToCartButton));
        System.out.println("Add to cart button is visible");
        Actions ac = new Actions(driver);
        ac.moveToElement(driver.findElement(FlipkartProductUI.addToCartButton)).click().build().perform();

    }
}

