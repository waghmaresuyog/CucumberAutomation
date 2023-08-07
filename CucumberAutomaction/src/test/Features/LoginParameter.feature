Feature: feature to test Login  functionality by BDD

  Scenario: validate Login with valid input
    Given Open the browser firefox
    When user open URL "https://example.testproject.io/web/"
    And user is enters username as "admin" and password as "12345"
    And user click on login button
    Then user is go to home page