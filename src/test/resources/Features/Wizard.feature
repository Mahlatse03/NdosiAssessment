Feature:
  @invalidPhoneDetails
  Scenario Outline:
    Given I am on Wizard page and there is no device selected
    When User selects a device <type>
    And There is no devide <brand> selected
    Then User must select a <brand>
    When There is no storage <storage> selected
    Then User must select a <storage>
    When There is no quantity <quantity> selected
    Then User must select a <quantity>
    When There is no address <address> selected
    Then User must capture <address>
    When Next button is clicked and there are missing fields
    Then User should see an error message <Message>
    Examples:
      |Type   | Brand  | Storage | Quantity | Address      | Message                          |
        | Phone |        | 128GB   | 1        | 123 Main St  | Please correct highlighted fields  |
        | Phone | Apple  |         | 1        | 123 Main St  | Please correct highlighted fields  |
        | Phone | Apple  | 128GB   |          | 123 Main St  | Please correct highlighted fields  |
        | Phone | Apple  | 128GB   | 1        |              | Please correct highlighted fields  |
        |       | Apple  | 128GB   | 1        | 123 Main St  | Please correct highlighted fields  |

    @validPhoneDetails
    Examples:
        |Type   | Brand  | Storage | Quantity | Address      | Message                       |
            | Phone | Apple  | 128GB   | 1        | 123 Main St  | Details saved successfully           |
            | Phone | Samsung| 256GB   | 2        | 456 Oak Ave  | Details saved successfully           |
            | Phone | Google | 512GB   | 3        | 789 Pine Rd  | Details saved successfully           |
