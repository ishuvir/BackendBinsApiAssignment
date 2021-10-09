#Author: Ishuvir Singh
Feature: Test Bins API with create operations
  Description: The purpose of this feature is to test the BinsApi Update operations


  Scenario Outline: I created bin with valid and invalid date for Post validation
    Given I created the request with private "<token>" & "<BinName>"
    When I POST the request to create a bin with "<route>"
    Then I validate the response status is<code>
    And I validate the Bin created with ID

    Examples: 
      | token                                                        | BinName | route | code |
      | $2b$10$Xqj5gYYEb/U4SJa63A2EPehOh8v51WrYuVBzYlqdqT9Z/mHeMCzIK | null    | /b    |  200 |
      | null                                                         | null    | /b    |  401 |

  Scenario Outline: I create bin with bin name
    Given I created the request with private "<token>" & "<BinName>"
    When I POST the request to create a bin with "<route>"
    Then I validate the response status is<code>
    And I validate the Bin created with ID
    And I validate the created bin with provided "<BinName>"

    Examples: 
      | token                                                        | BinName | route | code |
      | $2b$10$Xqj5gYYEb/U4SJa63A2EPehOh8v51WrYuVBzYlqdqT9Z/mHeMCzIK | ishu1   | /b    |  200 |

  Scenario: BinApi created with invalid token
    Given I created the post request with invalid token
    When I POST the request to create a bin with "</b>"
    Then I validate the response status is'404'
    And I validate the failure message
