Feature: Search and add product to cart on Flipkart

  @Flipkart
  Scenario: Search for a product and add it to the cart

    Given Open the Browser
    And hit the url
    When user search for "Apple iPhone 15"
    And user select the first product
    And user add the product to the cart
    Then the product should be added to the cart successfully

    #Apple iPhone 15 Pro Max (White Titanium, 256 GB)