package com.mindtree.StepDefinitions;

import com.mindtree.runner.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusableComponent.WebDriverHelper;
import com.mindtree.utility.ReadPropertyFile;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import org.testng.asserts.Assertion;

@RunWith(Cucumber.class)

public class HomePageSD {
	
	static WebDriver driver;
	ReadPropertyFile rp = null;
	Logger log = LogManager.getLogger(TestRunner.class.getName());
	
	@Given("Open the Browser")
	public void openTheBrowser() throws Exception {
		WebDriverHelper.initializeDriver();
		driver = WebDriverHelper.getDriver();
	}

	@Then("hit the url")
	public void hitTheUrl() throws Exception {
		rp = new ReadPropertyFile();
		driver.get(rp.getUrl());
		log.info("Url has been opened");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}


}
