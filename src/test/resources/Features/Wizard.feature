Feature: Device validation

  @invalidPhoneDetails
  Scenario Outline: As a user, I want to enter invalid device details and see appropriate error messages
    Given I am on Wizard page and there is no device selected
    When User selects a device <deviceType>
    And User must select a brand <deviceBrand> if there is no brand selected
    And User must select a storage <deviceStorage> if there is no storage selected
    And User must select a quantity <quantity> if there is no quantity selected
    And User must select a color <deviceColor> if there is no colour selected
    And User must capture address <address> if there is no address
    Then Next button should not be enabled if any field is empty
    Examples:
      | deviceType | deviceBrand | deviceStorage | quantity | deviceColor | address     |
      | Phone      | Samsung     | 128GB         | 1        | Black       | 123 Main St |
#      | Phone      | Apple       |               | 1        | White       | 123 Main St |
#      | Phone      | Apple       | 128GB         |          | Blue        | 123 Main St |
#      | Phone      | Apple       | 128GB         | 1        | Gold        |             |
#      |            | Apple       | 128GB         | 1        |             | 123 Main St |

  @validPhoneDetails
  Scenario Outline: As a user, I want to buy device(s) on the wizard page
    Given I am on Wizard page and there is no device selected
    When User selects a device <deviceType>
    And User must select a brand <deviceBrand> if there is no brand selected
    And User must select a storage <deviceStorage> if there is no storage selected
    And User must select a quantity <quantity> if there is no quantity selected
    And User must select a color <deviceColor> if there is no colour selected
    And User must capture address <address> if there is no address
    And Next button is clicked and all fields are filled
    Then User should be taken to the next step where pricing panel is displayed
    And Order total should be correctly calculated based on device quantity <quantity> unit price <unitPrice> storage price <priceOfStorage>
    When User clears the device selection
    Then Pricing should be reset
    When User selects Express shipping <expressShipping>
    And User selects warranty <warranty>
    Then Shipping cost <shippingCost>  and warranty <warrantyCost> should be added to the order total

    Examples:
      | deviceType | deviceBrand | deviceStorage | quantity | deviceColor | address     | unitPrice | priceOfStorage | expressShipping | warranty | shippingCost | warrantyCost |
      | Phone      | Apple       | 128GB         | 1        | Black       | 123 Main St | 400.00    | 80.00          | Yes             | 1yr      | 25.00        | 49.00        |
#      | Tablet     | Samsung     | 256GB | 2        | White       | 456 Oak Ave |600 |160.00|No|2yr|0.00|89.00|
#      | Laptop     | Xiaomi      | 64GB  | 3        | Blue        | 789 Pine Rd |1200 |0.00|Yes||25.00|0.00|
#      | Phone      | Other       | 256GB | 1        | Gold        | 321 Elm St  |400 |160.00| No|1yr|0.00"|49.00|
