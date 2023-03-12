Feature: Login

  Scenario: Correct Credentials
    Given I open browser
    And I go to login page
    And I click <Przejdz do serwisu>
    When I type "correctLogin" as login
    And I type "correctPassword" as password
    And I click login button
    Then I am logged in

  Scenario: Incorrect Credentials
    Given I open browser
    And I go to login page
    And I click <Przejdz do serwisu>
    When I type "incorrectLogin" as login
    And I type "incorrectPassword" as password
    And I click login button
    Then I am NOT logged in

