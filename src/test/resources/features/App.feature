Feature: Verify BoredAPI response

  Scenario: Verify response code and schema
    Given the BoredAPI is available
    When I request for an activity
    Then I should receive a response with status code 200
    And the response should contain the following schema:
      | activity      | string |
      | type          | string |
      | participants  | integer|
      | price         | float  |
      | link          | string |
      | key           | string |
      | accessibility | float  |