Feature: Login validation
  @validLogin
  Scenario Outline: As a user, I want to log in to access my account
    Given User is on the login page
    When User enters email <email>
    And User enters password <password>
    And User clicks on the login button
    Then User should land on  the landing page with <firstName> displayed
    When User switcher Tabs
    Then User should be logged out and redirected to the login page
    Examples:
      | email        | password | firstName               |
      | md@gmail.com | emd12345 | Mahlatse                 |

  @invalidLogin
  Scenario Outline: As a user, I want to log in to access my account
    Given User is on the login page
    When User enters invalid email <email> or <password>
    And User clicks on the login button
    Then User should see a message <message>
    Examples:
      | email           | password        | message                               |
      |                 |                 | Login failed: Missing required fields |
      | md@gmail.com    |                 | Login failed: Missing required fields |
      |                 | Password123     | Login failed: Missing required fields |
      | md@gmail.com    | invalidPassword | Login failed: Authentication failed   |
      | email@gmail.com | Password123     | Login failed: Authentication failed  |

