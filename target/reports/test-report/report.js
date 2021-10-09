$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/requestBinApi.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Ishuvir Singh"
    }
  ],
  "line": 2,
  "name": "Test Bins API with request operations",
  "description": "Description: The purpose of this feature is to test the BinsApi Request operations",
  "id": "test-bins-api-with-request-operations",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "BinApi GET request with valid BinID",
  "description": "",
  "id": "test-bins-api-with-request-operations;binapi-get-request-with-valid-binid",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I created the GET request with ValidBinID",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I sent the Binrequest",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I validate the response status is \u0027200\u0027",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I validate the Response ID with BinID",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I validate the Status line code",
  "keyword": "And "
});
formatter.match({
  "location": "RequestStepDefs.i_created_the_GET_request_with_ValidBinID()"
});
formatter.result({
  "duration": 2699266100,
  "status": "passed"
});
formatter.match({
  "location": "RequestStepDefs.i_sent_the_Binrequest()"
});
formatter.result({
  "duration": 2866604500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 35
    }
  ],
  "location": "RequestStepDefs.i_validate_the_response_status_is(int)"
});
formatter.result({
  "duration": 14278700,
  "status": "passed"
});
formatter.match({
  "location": "RequestStepDefs.I_validate_the_Response_ID_with_BinID()"
});
formatter.result({
  "duration": 1812515100,
  "status": "passed"
});
formatter.match({
  "location": "RequestStepDefs.i_validate_the_Status_line_code()"
});
formatter.result({
  "duration": 17378300,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "BinApi GET request with latest version of BinID",
  "description": "",
  "id": "test-bins-api-with-request-operations;binapi-get-request-with-latest-version-of-binid",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "I created the GET request with ValidBinID",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I sent the request with latest route",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I validate the response status is \u0027200\u0027",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "I validate the Response ID with BinID",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I verify the creation date in response",
  "keyword": "And "
});
formatter.match({
  "location": "RequestStepDefs.i_created_the_GET_request_with_ValidBinID()"
});
formatter.result({
  "duration": 2659400,
  "status": "passed"
});
formatter.match({
  "location": "RequestStepDefs.i_sent_with_latest_request()"
});
formatter.result({
  "duration": 500775100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 35
    }
  ],
  "location": "RequestStepDefs.i_validate_the_response_status_is(int)"
});
formatter.result({
  "duration": 1096800,
  "status": "passed"
});
formatter.match({
  "location": "RequestStepDefs.I_validate_the_Response_ID_with_BinID()"
});
formatter.result({
  "duration": 122587800,
  "status": "passed"
});
formatter.match({
  "location": "RequestStepDefs.I_verify_the_creation_date_in_response()"
});
formatter.result({
  "duration": 26994000,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "BinApi GET request with Invalid token for BinID request",
  "description": "",
  "id": "test-bins-api-with-request-operations;binapi-get-request-with-invalid-token-for-binid-request",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "I created the GET request with Invalid token",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "I sent the Binrequest",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "I validate the response status is \u0027401\u0027",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "I validate the Error message",
  "keyword": "And "
});
formatter.match({
  "location": "RequestStepDefs.i_created_the_GET_request_with_Invalid_token()"
});
formatter.result({
  "duration": 8065000,
  "status": "passed"
});
formatter.match({
  "location": "RequestStepDefs.i_sent_the_Binrequest()"
});
formatter.result({
  "duration": 557858600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "401",
      "offset": 35
    }
  ],
  "location": "RequestStepDefs.i_validate_the_response_status_is(int)"
});
formatter.result({
  "duration": 944800,
  "status": "passed"
});
formatter.match({
  "location": "RequestStepDefs.i_validate_the_failue_message()"
});
formatter.result({
  "duration": 4844100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 25,
  "name": "BinApi GET request for X-Bin-Meta Header as true \u0026 false",
  "description": "",
  "id": "test-bins-api-with-request-operations;binapi-get-request-for-x-bin-meta-header-as-true-\u0026-false",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 26,
  "name": "I created the GET request with X-Bin-Meta Header as \u003cstatus\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I sent the request with latest route",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "I validate the response status is \u0027200\u0027",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "I verified the response body for metadata header \u003cstatus\u003e",
  "keyword": "And "
});
formatter.examples({
  "line": 31,
  "name": "",
  "description": "",
  "id": "test-bins-api-with-request-operations;binapi-get-request-for-x-bin-meta-header-as-true-\u0026-false;",
  "rows": [
    {
      "cells": [
        "status"
      ],
      "line": 32,
      "id": "test-bins-api-with-request-operations;binapi-get-request-for-x-bin-meta-header-as-true-\u0026-false;;1"
    },
    {
      "cells": [
        "\"true\""
      ],
      "line": 33,
      "id": "test-bins-api-with-request-operations;binapi-get-request-for-x-bin-meta-header-as-true-\u0026-false;;2"
    },
    {
      "cells": [
        "\"false\""
      ],
      "line": 34,
      "id": "test-bins-api-with-request-operations;binapi-get-request-for-x-bin-meta-header-as-true-\u0026-false;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 33,
  "name": "BinApi GET request for X-Bin-Meta Header as true \u0026 false",
  "description": "",
  "id": "test-bins-api-with-request-operations;binapi-get-request-for-x-bin-meta-header-as-true-\u0026-false;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 26,
  "name": "I created the GET request with X-Bin-Meta Header as \"true\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I sent the request with latest route",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "I validate the response status is \u0027200\u0027",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "I verified the response body for metadata header \"true\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 53
    }
  ],
  "location": "RequestStepDefs.i_created_the_GET_request_with_X_Bin_Meta_Header_as(boolean)"
});
formatter.result({
  "duration": 12906400,
  "status": "passed"
});
formatter.match({
  "location": "RequestStepDefs.i_sent_with_latest_request()"
});
formatter.result({
  "duration": 624667700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 35
    }
  ],
  "location": "RequestStepDefs.i_validate_the_response_status_is(int)"
});
formatter.result({
  "duration": 1166700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 50
    }
  ],
  "location": "RequestStepDefs.i_verified_the_response_body_for(boolean)"
});
formatter.result({
  "duration": 3286500,
  "status": "passed"
});
formatter.scenario({
  "line": 34,
  "name": "BinApi GET request for X-Bin-Meta Header as true \u0026 false",
  "description": "",
  "id": "test-bins-api-with-request-operations;binapi-get-request-for-x-bin-meta-header-as-true-\u0026-false;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 26,
  "name": "I created the GET request with X-Bin-Meta Header as \"false\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I sent the request with latest route",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "I validate the response status is \u0027200\u0027",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "I verified the response body for metadata header \"false\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 53
    }
  ],
  "location": "RequestStepDefs.i_created_the_GET_request_with_X_Bin_Meta_Header_as(boolean)"
});
formatter.result({
  "duration": 10673600,
  "status": "passed"
});
formatter.match({
  "location": "RequestStepDefs.i_sent_with_latest_request()"
});
formatter.result({
  "duration": 675830900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 35
    }
  ],
  "location": "RequestStepDefs.i_validate_the_response_status_is(int)"
});
formatter.result({
  "duration": 1389500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 50
    }
  ],
  "location": "RequestStepDefs.i_verified_the_response_body_for(boolean)"
});
formatter.result({
  "duration": 3074100,
  "status": "passed"
});
});