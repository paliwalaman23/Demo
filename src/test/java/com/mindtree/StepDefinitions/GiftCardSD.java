package com.mindtree.StepDefinitions;

import com.mindtree.runner.TestRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.mindtree.pageObjects.ChristmasGift;
import com.mindtree.pageObjects.GiftCard;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GiftCardSD {
	static WebDriver driver;
	public GiftCard gc;
	public ChristmasGift cg;
	Logger log = LogManager.getLogger(TestRunner.class.getName());

	 @Given("^Get the driver from the AboutUS file$")
	    public void get_the_driver_from_the_aboutus_file() throws Throwable {
	        driver = AboutUsSD.getDriver();
	    }

	    @Then("^Click on the Gift Card on the web page$")
	    public void click_on_the_gift_card_on_the_web_page() throws Throwable {
	        gc = new GiftCard(driver);
	        gc.getGiftCard().click();
	        
	    }

	    @Then("^Click on Add to cart$")
	    public void click_on_add_to_cart() throws Throwable {
	    	 cg = new ChristmasGift(driver);
	    	 cg.getAddToCart().click();
	    }

	    @And("^Validate the title$")
	    public void validate_the_title() throws Throwable {
	    	gc = new GiftCard(driver);
	    	Thread.sleep(5000);
	    	if (gc.getTitle().getText().contains("Standard delivery")) {
				Assert.assertTrue(true);
				log.info("Gift Card has been added to the cart");
			} else {
				Assert.assertTrue(false);
				log.info("Gift Card has not been added to the cart");
			}

	    }
	    public static WebDriver getDriver() {
	    	return driver;
	    }
}
