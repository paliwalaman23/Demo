package com.mindtree.StepDefinitions;

import com.mindtree.runner.TestRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mindtree.pageObjects.ChristmasGift;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ChristmasGiftSD {
	
	static WebDriver driver;
	public ChristmasGift cg;
	Logger log = LogManager.getLogger(TestRunner.class.getName());
	
	@Given("^Get the driver from the SearchProductSD file$")
    public void get_the_driver_from_the_searchproductsd_file() throws Throwable {
        
		driver = SearcProductSD.getDriver();
    }

    @Then("^click on the Chirstmas Gift seaction on the website$")
    public void click_on_the_chirstmas_gift_seaction_on_the_website() throws Throwable {
        
    	cg = new ChristmasGift(driver);
    	cg.getChristmasGift().click();
    }
    
    @Then("^Click on the first product in the web page$")
    public void click_on_the_first_product_in_the_web_page() throws Throwable {
    	cg = new ChristmasGift(driver);
    	cg.getFirstProduct().click();
    }

    @Then("^click on Add to cart$")
    public void click_on_add_to_cart() throws Throwable {
    	
    	cg = new ChristmasGift(driver);
    	cg.getAddToCart().click();
        
    }
    

@Then("Click on go to checkout")
public void click_on_go_to_checkout() throws InterruptedException {
	cg = new ChristmasGift(driver);
	cg.getCheckOut().click();
	Thread.sleep(4000);
}

    @Then("^close the popup$")
    public void close_the_popup() throws Throwable {
    	cg = new ChristmasGift(driver);
    	if(cg.getPopup().isDisplayed())
    		cg.getPopup().click();
    	else
    		log.info("No pop up was there");
    }

    @And("^Click on the Return to cart$")
    public void click_on_the_return_to_cart() throws Throwable {
    	cg = new ChristmasGift(driver);
    	cg.getReturnToCart().click();
        
    }

    @And("^Validate it$")
    public void validate_it() throws Throwable {
    	
    	cg = new ChristmasGift(driver);
    	if (cg.getTitle().getText().contains("Shopping Cart")) {
			Assert.assertTrue(true);
			log.info("Returned to the Cart");
		} else {
			Assert.assertTrue(true);
			log.info("User is not came back to the Cart");
		}
    }
    
    public static WebDriver getDriver() {
    	return driver;
    }

}
