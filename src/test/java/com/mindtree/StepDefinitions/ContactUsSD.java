package com.mindtree.StepDefinitions;

import com.mindtree.runner.TestRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.ContactUs;
import com.mindtree.utility.ReadPropertyFile;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSD {
	
	static WebDriver driver;
	public ContactUs cu;
	public ReadPropertyFile rp;
	Logger log = LogManager.getLogger(TestRunner.class.getName());
	
	 @Given("^getting driver from GiftCardSD file$")
	    public void getting_driver_from_giftcardsd_file() throws Throwable {
	        driver = GiftCardSD.getDriver();
	    }

	    @When("^Click on ContactUs footer$")
	    public void click_on_contactus_footer() throws Throwable {
	       cu = new ContactUs(driver);
	       cu.getContinueShopping().click();
	       cu.getContactUS().click();
	       Thread.sleep(3000);
	    }

	    @Then("^Verify that data has been sent$")
	    public void verify_that_data_has_been_sent() throws Throwable {
	    	cu = new ContactUs(driver);
	    	if (cu.getTitle().getText().contains("Contact us")) {
				Assert.assertTrue(true);
				log.info("Ttile Verfied and Data has been sent successfully");
			} else {
				Assert.assertTrue(false);
				log.info("Title has not been verified and Data has not been sent yet ");
			}
	    	
	    }

	    @And("^sending email, name and message to the contact form$")
	    public void sending_email_name_and_message_to_the_contact_form() throws Throwable {
	        rp = new ReadPropertyFile();
	        cu = new ContactUs(driver);
	        cu.getname().sendKeys(rp.getname());
	        cu.getEmail().sendKeys(rp.getEmail());
	        cu.getMessage().sendKeys(rp.getMessage());
	        Thread.sleep(5000);
	    }

//	    @And("^close driver$")
//	    public void close_driver() throws Throwable {
//	      // driver.close();
//	       driver.quit();
//	    }
	    
//	    @After
//	    public void close_driver() throws Throwable {
//	      // driver.close();
//	       driver.quit();
//	       driver=null;
//	    }


}
