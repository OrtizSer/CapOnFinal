@HomeFeature
Feature: Retail Home Page

@test
Scenario: Verify Retail Page logo
Given User is on retail website
Then User verify retail page logo is present


@Search
Scenario: Verify User can Search in Electronic Department
Given User is on retail website
When User change the category to 'Electronics'
And User search for an item 'PlayStation'
And User click on Search icon
Then Item should be present


@test1
Scenario: Verify User can click on All section
Given User is on retail website
When User click on All section
Then User verifies 'Shop By department' is present

@testCart
Scenario: Verify Cart icon is present
Given User is on retail website
Then User verifies Cart icon is present


