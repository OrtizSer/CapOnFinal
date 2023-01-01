Feature: Retail Account Page

Background:
Given User is on retail website
When User click on sign in button
And User enter email '1234@gmail.com' and password 'S12345678s!'
And User click on login button
And User should be logged in into Account

#passed
@UpdateInfo
Scenario: Verify User can update Profile Information
When User click on Account option
And User update Name 'Sergioo' and Phone '9992223333'
And User click on Update button
Then User profile information should be updated

#passed
@UpdatePassword
Scenario: Verify user can update Password
When User click on Account option
And User enter below information
|previousPassword  | newPassword | confirmPassword |
|S12345679s!       | S12345678s! | S12345678s!     |
And User click on Change Password button
Then a messege should be displayed 'Password Updated Successfully'

#passed
@AddPayment
Scenario: Verify User can add a payment method
When User click on Account option
* User click on Add a payment method link
* User fill Debit or credit card information
| cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
| 9876543213214561 | Panthers   |              11 |           2024 |          123 |
* User click on Add your card button
Then a message should be displayed 'Payment Method added sucessfully'

#passed
@EditCard
Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User select card with ending '9852'
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 7412589633698521 | Panthers   |              12 |           2025 |          456 |
    And user click on Update Your Card button
    Then a message should be displayed 'Payment Method updated Successfully'

#passed
@RemoveCard
Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User select card with ending '3654'
    And User click on remove option of card section
    Then payment details should be removed

#passed
@AddAddress
Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipCode      |
      | countryValue | fullnameValue | PhoneValue  | stAddress     | aptValue | cityValue | stateValue | zipCodeValue |
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'

#passed
@EditAddress
Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipCode      |
      | countryValue | fullnameValue | PhoneValue  | stAddress     | aptValue | cityValue | stateValue | zipCodeValue |
    And User click update Your Address button
    Then a message should be displayed 'Address Updated Successfully'

#passed
@RemoveAddress
Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed