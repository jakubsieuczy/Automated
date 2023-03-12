Feature: Logowanie do systemu

  @Login
  Scenario: Poprawne logowanie
    Given Uzytkownik jest na stronie logowania
    When Uzytkownik wpisze "tomsmith" jako nazwe uzytkownika
    And Uzytkownik wpisze "SuperSecretPassword!" jako haslo
    And Uzytkownik kliknie w przycisk Login
    Then Uzytkownik zostal poprawnie zalogowany

  @Login2
  Scenario: Niepoprawne logowanie
    Given Uzytkownik jest na stronie logowania
    When Uzytkownik wpisze "tomsmith" jako nazwe uzytkownika
    And Uzytkownik wpisze "IncorrectPassword" jako haslo
    And Uzytkownik kliknie w przycisk Login
    Then Uzytkownik niezostal poprawnie zalogowany

  @Login3
  Scenario Outline: Obydwa warianty
    Given Uzytkownik jest na stronie logowania
    When Uzytkownik wpisze "<login>" jako nazwe uzytkownika
    And Uzytkownik wpisze "<password>" jako haslo
    And Uzytkownik kliknie w przycisk Login
    Then <expectedResult>
    Examples:
      | login    | password             | expectedResult                            |
      | tomsmith | SuperSecretPassword! | Uzytkownik zostal poprawnie zalogowany    |
      | tomsmith | IncorrectPassword    | Uzytkownik niezostal poprawnie zalogowany |
