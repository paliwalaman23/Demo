package com.mindtree.StepDefinitions;

import com.mindtree.runner.TestRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.pageObjects.WishList;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WishListSD {
	
	static WebDriver driver;
	public WishList wi;
	Logger log = LogManager.getLogger(TestRunner.class.getName());
	
	@Given("^Get the driver form the AllOfItSD file$")
    public void get_the_driver_form_the_allofitsd_file() throws Throwable {
        driver = AllOfItSD.getDriver();
    }

    @Then("^Click on the WishList in the web page$")
    public void click_on_the_wishlist_in_the_web_page() throws Throwable {
        wi = new WishList(driver);
        wi.getWishList().click();
    }

    @Then("^close the popup in the page$")
    public void close_the_popup_in_the_page() throws Throwable {
    	
    	wi = new WishList(driver);
    	log.info("Going to close the popup");
    	Thread.sleep(4000);
    	if(wi.getPopup().isDisplayed())
    		wi.getPopup().click();
        log.info("closed the pop up");
    }

    @And("^Validate if product is present or not$")
    public void validate_if_product_is_present_or_not() throws Throwable {
    	wi = new WishList(driver);
    	if (wi.getProduct().isDisplayed()) {
			Assert.assertTrue(true);
			log.info("Product is present over there in WishList");
		} else {
			Assert.assertTrue(false);
			log.info("Product is not present in the WishList");
		}
    }
    
    public static WebDriver getDriver() {
    	return driver;
    }


}
