


Feature: Per store API test

  Scenario: Store API test
    Given I have a pet store API
    When I call get pet with status as "available"
    Then I should get the list of all the available pets
