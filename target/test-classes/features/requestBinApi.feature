#Author: Ishuvir Singh
Feature: Test Bins API with request operations
  Description: The purpose of this feature is to test the BinsApi Request operations

  Scenario: BinApi GET request with valid BinID
    Given I created the GET request with ValidBinID
    When I sent the Binrequest
    Then I validate the response status is '200'
    And I validate the Response ID with BinID
    And I validate the Status line code

  Scenario: BinApi GET request with latest version of BinID
    Given I created the GET request with ValidBinID
    When I sent the request with latest route
    Then I validate the response status is '200'
    And I validate the Response ID with BinID
    And I verify the creation date in response

  Scenario: BinApi GET request with Invalid token for BinID request
    Given I created the GET request with Invalid token
    When I sent the Binrequest
    Then I validate the response status is '401'
    And I validate the Error message

  Scenario Outline: BinApi GET request for X-Bin-Meta Header as true & false
    Given I created the GET request with X-Bin-Meta Header as <status>
    When I sent the request with latest route
    Then I validate the response status is '200'
    And I verified the response body for metadata header <status>

    Examples: 
      | status  |
      | "true"  |
      | "false" |
