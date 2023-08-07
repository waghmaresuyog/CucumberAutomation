Feature: User Login

  Scenario Outline: User logs in with different credentials
    Given the user is open browser
    When the user enters "<username>" and "<password>"
    And the user clicks the login button
    Then the user should be "<login_status>"

    Examples:
      | username   | password   | login_status   |
      | user1      | 12345  | successful     |
   #   | user2      | password2  | unsuccessful   |
      | user3      | 12345  | successful     |
