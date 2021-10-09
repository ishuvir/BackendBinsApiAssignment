#Author: Ishuvir Singh
#Keywords Summary :
Feature: Test Bins API with Update operations
  Description: The purpose of this feature is to test the BinsApi Update operations

  Scenario: BinApi Update with new Sample value
    Given I created the GET request with BinID
    And I verified the sample value in Response
    When I updated the sample value as "<Hello Universe>"
    And I sent the PUT Request with updated sample
    Then I validate the response status is '200'
    And I validate resonse with update sample value "<Hello Universe>"

  Scenario: BinApi Update with new ID value
    Given I created the GET request with ID
    And I verified the ID value in Response
    When I updated the ID value as "616010bf4a82881d6c5d2061"
    And I sent the PUT Request with updated id
    Then I validate the response status is '200'
    And I validate resonse with updated ID as "616010bf4a82881d6c5d2061"
    And I validate response with old parentID

  Scenario: BinApi Update request with Invalid token for BinID request
    Given I updated the sample value as "<Hello Universe>" with Invalid token
    When I sent the PUT Request with updated sample
    Then I validate the response status is '401'
    And I validate the Error message
