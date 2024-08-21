package com.mindtree.StepDefinitions;

import com.mindtree.runner.TestRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.mindtree.pageObjects.AboutUs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AboutUsSD {
	
	static WebDriver driver;
	public AboutUs au;
	Logger log = LogManager.getLogger(TestRunner.class.getName());
	
	@Given("^Get the driver from the WishListSD file$")
    public void get_the_driver_from_the_wishlistsd_file() throws Throwable {
     
		driver = WishListSD.getDriver();
    }

    @Then("^Click on the About Us from he footer section$")
    public void click_on_the_about_us_from_he_footer_section() throws Throwable {
       
    	au = new AboutUs(driver);
    	log.info("Going to click on About us");
    	au.getAbout().click();
    	log.info("cliclked on about us");
    }

    @Then("^Validate whether About us is opened or not$")
    public void validate_whether_about_us_is_opened_or_not() throws Throwable {
        
    	//au = new AboutUs(driver);
    	if (au.getTitle().getText().contains("About us")) {
			Assert.assertTrue(true);
			log.info("Entered in About Us page");
		} else {
			Assert.assertTrue(false);
			log.info("User is not Entered in About Us Page");
		}
    }
    
    public static WebDriver getDriver() {
    	return driver;
    }

}
