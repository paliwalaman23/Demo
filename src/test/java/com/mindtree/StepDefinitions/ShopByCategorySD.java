package com.mindtree.StepDefinitions;

import com.mindtree.runner.TestRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.pageObjects.ShopByCategory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ShopByCategorySD {
	
		static WebDriver driver;
		public ShopByCategory sc;
		Logger log = LogManager.getLogger(TestRunner.class.getName());
	
	 @Given("^Get the driver from the ChristmasGift file$")
	    public void get_the_driver_from_the_christmasgift_file() throws Throwable {
	        driver = ChristmasGiftSD.getDriver();
	    }

	    @Then("^click on the ShopByCategory$")
	    public void click_on_the_shopbycategory() throws Throwable {
	    	
	    	sc = new ShopByCategory(driver);
	    	Thread.sleep(4000);
	    	sc.getShopByCategory().click();
	    	
	        
	    }

	    @Then("^click on the second category$")
	    public void click_on_the_second_category() throws Throwable {
	    	sc = new ShopByCategory(driver);
	    	sc.getCategory().click();;
	    }

	    @Then("^Click on the first product$")
	    public void click_on_the_first_product() throws Throwable {
	    	sc = new ShopByCategory(driver);
	    	sc.getProduct().click();
	    }

	    @And("^Add it to the WishList$")
	    public void add_it_to_the_wishlist() throws Throwable {
	    	sc = new ShopByCategory(driver);
	    	sc.getWishList().click();
	    	log.info("Product has been added to the Wishlist");
	    }
	    
	    public static WebDriver getDriver() {
	    	return driver;
	    }

}
