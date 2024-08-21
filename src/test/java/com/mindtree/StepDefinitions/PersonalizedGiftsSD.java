package com.mindtree.StepDefinitions;

import com.mindtree.runner.TestRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.PersonalizedGift;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class PersonalizedGiftsSD {
		
	static WebDriver driver;
	public PersonalizedGift pg;
	Logger log = LogManager.getLogger(TestRunner.class.getName());
	
	 @Given("^Get the driver from the SignInSD file$")
	    public void get_the_driver_from_the_signinsd_file() throws Throwable {
		 	driver = SignInSD.getDriver();
	    }

	    @Then("^Click on the Personalized Gift section$")
	    public void click_on_the_personalized_gift_section() throws Throwable {
	    	log.info("going to click on Pggggg");
	    	Thread.sleep(3000);
	    	pg = new PersonalizedGift(driver);
	    	pg.getPersonalGift().click();
	    	Thread.sleep(3000);
	    }

	    @Then("^Click on Sort By option$")
	    public void click_on_sort_by_option() throws Throwable {
	    	pg = new PersonalizedGift(driver);
	    	Thread.sleep(3000);
	    	pg.getsortby().click();
	    }

	    @Then("^Select the High To Low option$")
	    public void select_the_high_to_low_option() throws Throwable {
	    	pg = new PersonalizedGift(driver);
	    	pg.gethightolow().click();
	    	
	    }
	    @And("^Verify it$")
	    public void verify_it() throws Throwable {
	    	pg = new PersonalizedGift(driver);
	    	if (pg.getmaxprice().getText().contains("Rs. 4,500")) {
				Assert.assertTrue(true);
				log.info("Successfully sorted the Price from High to low");
			} else {
				Assert.assertTrue(false);
				log.info("Price is not sorted from High to Low");
			}
	    }
	    
	    public static WebDriver getDriver() {
	    	return driver;
	    }

}
