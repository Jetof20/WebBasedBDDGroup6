Feature: Search
  As a user
  I want to search for products
  So that I can find what I'm looking for

Scenario: Search for a product
  Given the search page is displayed
  When I enter "apple" in the search field
  Then the search results should contain "Apple iPhone"