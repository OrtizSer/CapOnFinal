Feature: Retail Home Page

  Background: 
    Given User is on retail website

  @test 
  Scenario: Verify Retail page logo
    Then User verify retail page logo is present

  @search
  Scenario: Verify User can Search in Electronics Department
    When User change the category to 'Electronics'
    And User search for an item 'PlayStation'
    And User click on Search icon
    Then Item should be present

  @test1 
  Scenario: Verify User can click on All section
    When User click on All section
    Then User verifies 'Shop By department' is present

  @testCart
  Scenario: Verify Cart icon is present
    Then User verifies cart icon is present