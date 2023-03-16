Feature: Helion

  Scenario: Add book to cart
    Given   I open Chrome browser
    And I go to "https://helion.pl/" page
    And I click <Rozumiem> at RODO message
    And I type "python dla każdego" in search bar and click search button
    When  I click button with price under a first book
    Then Book is in the cart