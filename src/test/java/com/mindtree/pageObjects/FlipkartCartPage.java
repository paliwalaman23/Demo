package com.mindtree.pageObjects;


import com.mindtree.uistore.FlipkartCartUI;
import com.mindtree.uistore.FlipkartProductUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartCartPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public FlipkartCartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    // Locators


    // Actions
    public void openCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FlipkartCartUI.cartIcon)).click();
    }

    public boolean isProductInCart() {
        WebElement productInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(FlipkartCartUI.cartProduct));
        if(productInCart.getText().contains(FlipkartHomePage.productName))
            return productInCart.isDisplayed();
        else
            return false;

    }
}

