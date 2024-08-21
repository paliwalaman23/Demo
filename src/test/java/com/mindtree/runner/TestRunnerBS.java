package com.mindtree.runner;

import com.mindtree.reusableComponent.BrowserStackBaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


@Test
@CucumberOptions(
        features="src\\test\\java\\com\\mindtree\\feature",
        glue = {"com.mindtree.StepDefinitions"},
        tags = "@Flipkart",
        dryRun = false)
public class TestRunnerBS extends AbstractTestNGCucumberTests {

    WebDriver driver;
    public static final String USERNAME = "amanpaliwal_L2mYWp";
    public static final String AUTOMATE_KEY = "9NdnNSMBxRVJG239gJn3";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    @Parameters({"browser", "browser_version", "os", "os_version"})
    @BeforeMethod
    public void setUp(String browserName, String browser_version, String os, String os_version,  Method name) {

        System.out.println("browser name is : " + browserName);
        String methodName = name.getName();

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", os);
        caps.setCapability("os_version", os_version);
        caps.setCapability("browser_version", browser_version);
        caps.setCapability("name", methodName);
        caps.setCapability("name", "Cucumber Test on BrowserStack");

        if (browserName.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            caps.setCapability("browser", "Chrome");
        } else if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            caps.setCapability("browser", "Firefox");
        } else if (browserName.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            caps.setCapability("browser", "Edge");
        }
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}







