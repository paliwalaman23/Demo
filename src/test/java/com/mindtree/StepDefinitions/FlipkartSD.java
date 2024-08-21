package com.mindtree.StepDefinitions;


import com.mindtree.pageObjects.FlipkartCartPage;
import com.mindtree.pageObjects.FlipkartHomePage;
import com.mindtree.pageObjects.FlipkartProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class FlipkartSD {

    WebDriver driver = HomePageSD.getDriver();
    FlipkartHomePage homePage = new FlipkartHomePage(driver);
    FlipkartProductPage  productPage = new FlipkartProductPage(driver);
    FlipkartCartPage cartPage = new FlipkartCartPage(driver);


    @When("user search for {string}")
    public void userSearchFor(String productName) {
        homePage.searchProduct(productName);
    }

    @And("user select the first product")
    public void userSelectTheFirstProduct() {
        productPage.selectFirstProduct();
    }

    @And("user add the product to the cart")
    public void userAddTheProductToTheCart() {
        if (productPage.isProductOutOfStock()) {
            System.out.println("Test case failed: Product is out of stock.");
            driver.quit();
            assert false;
        } else {
            productPage.addToCart();
        }
    }
    @Then("the product should be added to the cart successfully")
    public void theProductShouldBeAddedToTheCartSuccessfully() {
        cartPage.openCart();
        assert cartPage.isProductInCart() : "Product not found in the cart!";
        System.out.println("Product added to cart successfully.");

        // Close the browser
        //driver.quit();
    }

}

