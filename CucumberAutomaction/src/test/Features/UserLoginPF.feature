Feature: User Login using PF
  @SmokeOne
  Scenario Outline: User logs in with different credentials using PF
    Given user is open browser
    When user open URL
    And  user enters "<username>" and "<password>"
    And  user clicks the login button
    Then the user should be on home page

    Examples:
      | username   | password   |
      | user1      | 12345  |
      | user2      | 12345  |