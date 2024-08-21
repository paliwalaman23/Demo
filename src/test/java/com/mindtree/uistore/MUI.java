package com.mindtree.uistore;

import org.openqa.selenium.By;

public class MUI {
    public static By tshrt = By.xpath("//a[text()='T-Shirts']");
    public static By iconSearch = By.xpath("//input[@placeholder='Search for Brand']/following-sibling::span");
    public static By txaSearch = By.xpath("//input[@placeholder='Search for Brand']");
    public static By specificTshrt = By.xpath("//div[@class='product-productMetaInfo']");
    public static By labelTshrt = By.xpath("//h1[text()='Men T-shirts']");
    public static By chkBrand = By.xpath("//label[@class='vertical-filters-label common-customCheckbox']");

}
