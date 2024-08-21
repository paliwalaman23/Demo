package com.mindtree.pageObjects;

import com.mindtree.uistore.FlipkartHomeUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartHomePage {
    WebDriver driver;
    WebDriverWait wait;
    static String productName = null;

    // Constructor
    public FlipkartHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    // Locators


    // Actions
    public void openWebsite() {
        driver.get("https://www.flipkart.com");

        // Close login popup if it appears

    }

    public void searchProduct(String productName) {
        this.productName=productName;
        try {
            WebElement closePopupElement = wait.until(ExpectedConditions.elementToBeClickable(FlipkartHomeUI.closeLoginPopup));
            closePopupElement.click();
        } catch (Exception e) {
            System.out.println("Login popup didn't appear");
        }
        WebElement searchElement = driver.findElement(FlipkartHomeUI.searchBox);
        searchElement.sendKeys(productName);
        searchElement.submit();
    }
}
