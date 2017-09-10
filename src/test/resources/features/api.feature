Feature: API

  @api
  Scenario Outline: Product search for known keyword
    When I search for the keyword <keyword>
    Then I should get a response code <statuscode>
    And I should get results from the keyword
    And I should get relevant results from the keyword <keyword>
  Examples:
    | keyword | statuscode |
    | kiwi    | 200        |

  @api
  Scenario: Clicking a sub category link
    When I click a sub category link
    Then I should get the sub category nav JSON response