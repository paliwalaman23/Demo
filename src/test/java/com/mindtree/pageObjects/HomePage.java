package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import com.mindtree.uistore.HomePageUI;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getLogin() {
		return driver.findElement(HomePageUI.SignIn);
	}
	public WebElement getLogo(){
		return driver.findElement(HomePageUI.logo);
	}
	public WebElement getMenSection(){
		return driver.findElement(HomePageUI.menSection);
	}

}
