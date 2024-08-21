package com.mindtree.StepDefinitions;

import java.util.ArrayList;

import com.mindtree.runner.TestRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.SearchPage;
import com.mindtree.utility.RetreiveExcelData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearcProductSD {
	static WebDriver driver;
	public SearchPage sp;
	public RetreiveExcelData re;
	Logger log = LogManager.getLogger(TestRunner.class.getName());
	
	@Given("^Get the driver form the PersonalizedGiftsSD file$")
    public void get_the_driver_form_the_personalizedgiftssd_file() throws Throwable {
        driver = PersonalizedGiftsSD.getDriver();
    }

    @Then("^Click the SearchBox$")
    public void click_the_searchbox() throws Throwable {
    	sp= new SearchPage(driver);
        sp.getSearchBox().click();
    }

    @Then("^Enter any Product$")
    public void enter_any_product() throws Throwable {
    	re = new RetreiveExcelData();
    	sp= new SearchPage(driver);
    	
    	ArrayList<String> product = RetreiveExcelData.getData("searchproduct");

		for (int i = 1; i < product.size(); i++) {

			sp.getSearchBox().sendKeys(product.get(i));
			sp.getSearchBox().sendKeys(Keys.ENTER);

		}

		
        
    }

    @Then("^Verify the products which are displayed$")
    public void verify_the_products_which_are_displayed() throws Throwable {
    	
    	sp= new SearchPage(driver);
    	
    	if (sp.getSearchProduct().isDisplayed()) {
			Assert.assertTrue(true);
			log.info("Products has been Displayed");
		} else {
			Assert.assertTrue(false);
			log.info("Product is not Displayed");
		}
        
    }
    
    public static WebDriver getDriver() {
    	return driver;
    }

}
