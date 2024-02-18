


Feature: Per store API test

  Scenario: Store API test
    Given I have a pet store API
    When I call get end point for fetching pets and with status as "available"
    Then I should get the status code as 200
    Then I should get the list of all the available pets
