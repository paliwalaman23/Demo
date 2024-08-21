package com.mindtree.StepDefinitions;

import com.mindtree.runner.TestRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.pageObjects.AllOfIt;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AllOfItSD {
		
		static WebDriver driver;
		public AllOfIt ai;
	Logger log = LogManager.getLogger(TestRunner.class.getName());
	
	  @Given("^Get the driver from the ShopByCategorySD file$")
	    public void get_the_driver_from_the_shopbycategorysd_file() throws Throwable {
	       driver = ShopByCategorySD.getDriver();
	    }

	    @Then("^Click on the AllOfIt option from the menu bar$")
	    public void click_on_the_allofit_option_from_the_menu_bar() throws Throwable {
	    	
	    	ai = new AllOfIt(driver);
	    	Thread.sleep(4000);
	    	ai.getAllOfIT().click();
	    }

	    @Then("^Click on the frst product$")
	    public void click_on_the_frst_product() throws Throwable {
	    	ai = new AllOfIt(driver);
	    	ai.getProduct().click();
	    }

	    @And("^Validate its title$")
	    public void validate_its_title() throws Throwable {
	    	
	    	ai = new AllOfIt(driver);
	    	if (ai.getTitle().getText().contains("Auto Rickshaw Pen Stand")) {
				Assert.assertTrue(true);
				log.info("Title under All Of It is verified");
			} else {
				Assert.assertTrue(false);
				log.info("Title under All Of It is not verified");
			}
	    }
	    public static WebDriver getDriver() {
	    	return driver;
	    }

}
