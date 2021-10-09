#Author: Ishuvir Singh
Feature: Test Bins API with Delete operations
  Description: The purpose of this feature is to test the BinsApi Delete operations

  Scenario: BinApi Delete request for Bin api
    Given I hold valid Bin
    When I sent the delete request
    Then I validate the response code is '200'
    And I validate the Response ID with deleted BinID
    And I verify the deletion message
    And I verified Delete version
    And I sent the get request
    And I verified Bin not found

  Scenario: BinApi Delete request for Bin api
    Given I hold valid Bin
    When I sent the delete request
    Then I validate the response code is '404'
    And I verified Bin not found

  Scenario: BinApi Delete request for Bin api with invalid token
    Given I hold Invalid token Bin
    When I sent the delete request
    Then I validate the response code is '401'
    And I verified Invalid master key response
