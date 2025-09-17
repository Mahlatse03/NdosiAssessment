@validlogin
Feature: Valid Login and Session

  Scenario Outline: As a user, I want to log in to access my account
    Given User is on the login page
    When User enters email <email>
    And User enters password <password>
    And User clicks on the login button
    Then User should land on  the landing page
    Examples:
      |email  | password  |
        |   md@gmail.com    | emd12345  |


  @invalidlogin
Feature: Invalid Login Attempts

  Scenario Outline: As a user, I want to log in to access my account
    Given User is on the login page
    When User enters invalid email <email> or <password>
    And User clicks on the login button
    Then User should see a message <message>
    Examples:
      |email          | password   | message                     |
        |               |            | Please fill in all fields   |
        | md@gmail.com  | invalidPassword|  Login failed: Invalid login credentials |
        | invalidemail  | Password123| Please enter a valid email address |

