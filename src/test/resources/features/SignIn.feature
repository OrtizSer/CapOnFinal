Feature: Sign In Feature


@signInTest
Scenario: Verify user can sign in into Retail Aplication
Given User is on retail website
When User click on sign in button
And User enter email '1234@gmail.com' and password 'S12345678s!'
And User click on sign in button
Then User should be logged in into Account

@SignUpTest
Scenario: Verify user can create an account into Retail website
And User click on Create New Account button
And User fill the signUp information with the below data
|name       |email            |password    |confirmPassword|
|panthers   |pantera1@gmail.com   |Tek@12345   |Tek@12345      |
And User click on SignUp button
Then User should be logged into account page