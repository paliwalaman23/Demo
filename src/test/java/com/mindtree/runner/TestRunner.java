package com.mindtree.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.Test;



//@RunWith(Cucumber.class)		//We are commenting it because we want to run it as testng
@Test
@CucumberOptions(
		features="src\\test\\java\\com\\mindtree\\feature",
		glue = {"com.mindtree.StepDefinitions"},
		tags = "@Flipkart",
			dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests  {
}





