

@ui
Feature: Google Search UI test

  Scenario: Search "Akash" in google
    Given I have browser open
    When I search for "Akash" in google
    Then I should see the search results


