Feature: Retail Home Page

#Background:
#Given User is on retail website
#When User click on sign in button
#And User enter email '1234@gmail.com' and password 'S12345678s!'
#And User click on login button
#And User should be logged in into Account

#@test
#Scenario: Verify Retail Page logo
#Given User is on retail website
#Then User verify retail page logo is present
#
#
#@Search
#Scenario: Verify User can Search in Electronic Department
#Given User is on retail website
#When User change the category to 'Electronics'
#And User search for an item 'PlayStation'
#And User click on Search icon
#Then Item should be present
#
#
#@test1
#Scenario: Verify User can click on All section
#Given User is on retail website
#When User click on All section
#Then User verifies 'Shop By department' is present
#
#@testCart
#Scenario: Verify Cart icon is present
#Given User is on retail website
#Then User verifies Cart icon is present

#passed
@ShopSideBar
 Scenario: Verify Shop by Department sidebar
 Given User is on retail website
 When User click on All section
 Then below options are present in Shop by Department sidebar
 | Electronics | Computers | Smart Home | Sports | Automative |

#passed
@DepOptions
Scenario Outline: Verify department sidebar options
    Given User is on retail website
    When User click on All section
    And User on <department>
    Then below options are present in department
      | <optionOne> | <optionTwo> |

    Examples: 
      | department    | optionOne                      | optionTwo                |
      | 'Electronics' | TV & Video                     | Video Games              |
      | 'Computers'   | Accessories                    | Networking               |
      | 'Smart Home'  | Smart Home Lightning           | Plugs and Outlets        |
      | 'Sports'      | Athletic Clothing              | Exercise & Fitness       |
      | 'Automative'  | Automative Parts & Accessories | MotorCycle & Powersports |
      

#passed
@AddItem
Scenario: Verify User can add an item to cart
    Given User is on retail website
    When User click on Sign in option
    And User enter email '1234@gmail.com' and password 'S12345678s!'
    And User click on login button
    Then User should be logged in into Account
    When User change the category to 'Smart Home'
    And User search for an item 'kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'

#Passed
@PlaceOrder
  Scenario: Verify User can place an order without Shipping address and payment Method on file
    Given User is on retail website
    When User click on Sign in option
    And User enter email '1234@gmail.com' and password 'S12345678s!'
    And User click on login button
    Then User should be logged in into Account
    When User change the category to 'Smart Home'
    And User search for an item 'kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click Add a new address link for shipping address
    And user fill new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipCode      |
      | countryValue | fullnameValue | PhoneValue  | stAddress     | aptValue | cityValue | stateValue | zipCodeValue |
    And User click Add Your Address button
    And User click Add a credit card or Debit Card for Payment method
    * User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 9876543213214511 | Panthers   |              11 |           2024 |          123 |
    * User click on Add your card button
    And User click on Place Your Order
    Then a message should be displayed 'Order Placed, Thanks'

#Passed
 @ShippingAddress
 Scenario: Verify User can place an order with Shipping address and payment Method on file
    Given User is on retail website
    When User click on Sign in option
    And User enter email '1234@gmail.com' and password 'S12345678s!'
    And User click on login button
    Then User should be logged in into Account
    When User change the category to 'Electronics'
    And User search for an item 'Apex Legends'
    And User click on Search icon
    And User click on item
    And User select quantity '5'
    And User click add to Cart button
    Then the cart icon quantity should change to '5'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click on Place Your Order
    Then a message should be displayed 'Order Placed, Thanks'
