package com.mindtree.uistore;

import org.openqa.selenium.By;

public class FlipkartProductUI {
    public static By firstProduct = By.className("KzDlHZ");
    public static By addToCartButton = By.xpath("//button[text()='Add to cart']");
    public static By outOfStockMessage = By.xpath("//div[contains(text(),'out of stock')]");
}
