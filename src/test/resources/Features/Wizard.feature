Feature:
  @invalidPhoneDetails
  Scenario Outline:
    Given I am on Wizard page and there is no device selected
    When User selects a device <type>
    Then User must select a brand <brand> if there is no brand selected
    Then User must select a storage <storage> if there is no storage selected
    Then User must select a quantity <quantity> if there is no quantity selected
    Then User must capture address <address> if there is no address
    When Next button is clicked and there are missing fields
    Then User should see an error message <deviceErrorMessage>
    Examples:
      |deviceType   | deviceBrand  | deviceStorage | Quantity | Address      | DeviceErrorMessage                          |
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
