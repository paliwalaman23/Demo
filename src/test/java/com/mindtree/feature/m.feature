Feature: Myntra Shopping

  Scenario: Verifying Mens section functoinality
    Given user launches the browser and open the url
    Then Myntra page should be opened
    And user hovers on Mens section
    When user clicks on Tshrt
    And Tshrts should display
    When user filter the "van Heusen" tshrts
    Then "Van Heusen" tshrt should display