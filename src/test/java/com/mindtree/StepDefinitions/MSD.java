package com.mindtree.StepDefinitions;

import com.mindtree.pageObjects.M;
import com.mindtree.reusableComponent.WebDriverHelper;
import com.mindtree.utility.ReadPropertyFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import java.util.List;

public class MSD {


    private static final Logger log = Logger.getLogger(MSD.class);
    ReadPropertyFile rp = new ReadPropertyFile();
    WebDriver driver;
    public M myntra;


    @Given("user launches the browser and open the url")
    public void userLaunchesTheBrowserAndOpenTheUrl() throws Exception {
//        System.setProperty("webdriver.chrome.driver",rp.getDriverPath());
//         driver = new ChromeDriver();
        WebDriverHelper.initializeDriver();
        driver = WebDriverHelper.getDriver();
        driver.get(rp.getUrl());
        driver.manage().window().maximize();
    }

    @Then("Myntra page should be opened")
    public void myntraPageShouldBeOpened() {
        if(driver.getTitle().contains("Myntra")){
            Assert.assertTrue(true);
            log.info("Myntra Page has been opened");
        }
        else
            log.info("Please open the Myntra web page");
    }

    @And("user hovers on Mens section")
    public void userHoversOnMensSection() throws InterruptedException {
        Actions ac = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-group='men']")));
        ac.clickAndHold().moveToElement(driver.findElement(By.xpath("//a[@data-group='men']"))).build().perform();
    }

    @When("user clicks on Tshrt")
    public void userClicksOnTshrt() {
         myntra = new M(driver);
       myntra.getTshrt().click();
       // driver.findElement(By.xpath("//a[text()='T-Shirts']")).click();
    }

    @And("Tshrts should display")
    public void tshrtsShouldDisplay() {
        if(myntra.getLabelTshrt().isDisplayed()){
            Assert.assertTrue(true);
            log.info("All Tshirts has been displayed");
        }
        else{
            Assert.assertTrue(false);
            log.info("Tshrts has not been displayed");
        }

    }

    @When("user filter the {string} tshrts")
    public void userFilterTheTshrts(String brand) {
        myntra.getIconSearch().click();
        myntra.getTxaSearch().sendKeys(brand);
        myntra.getChkBrand().click();
    }


    @Then("{string} tshrt should display")
    public void tshrtShouldDisplay(String brand) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> elements = myntra.getSpecificTshrt();
        for(WebElement element: elements) {
            System.out.println(element.getText());
        }
        System.out.println((myntra.getSpecificTshrt().subList(0,2)));
    }
    @AfterSuite
    public void tearDown(){
        driver.close();
        driver.quit();
    }



}
