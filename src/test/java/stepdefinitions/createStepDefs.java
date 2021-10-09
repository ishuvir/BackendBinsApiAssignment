package stepdefinitions;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import dataprovider.configReader;
import helper.loggerHelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.requestUtility;
import utilities.responseUtility;


import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class createStepDefs extends configReader {

	private static Logger log = loggerHelper.getLogger(createStepDefs.class);
	responseUtility res=new responseUtility();

	
	@Given("^I created the request with private \"([^\"]*)\" & \"([^\"]*)\"$")
	public void i_created_the_request_with_private(String token,String binName)  {
		res.requestParam(getBaseUrl(),token,binName);		
	}
	
	
	@Given("^I created the post request with invalid token$")
	public void i_created_the_post_request_with_invalid_token()  {
		res.requestParam(getBaseUrl(),getInvalidToken(),"null");		
	}
	
	
	@When("^I POST the request to create a bin with \"([^\"]*)\"$")
	public void user_send_the_request_to_create_a_bin(String route) {
		res.sendRequest(responseUtility.POST_REQUEST,route); 
	//	res.postResponse(route);
	}

	@Then("^I validate the response status is(\\d+)$")
	public void user_validate_the_response_status_is(int httpCode) {
        int code=res.response.getStatusCode();
        Assert.assertEquals(httpCode, code);
        if(code==200) {
        	log.info("POST Request sucessfull"+code);
        }
        else if(code==401) {
        	log.info("POST Request Failed: need to pass X-Master-Key in the header"+code); 	
        }
        else {
        	log.info("BAD Request or Forbidden Request"+code);
        }
        
         
	}
	
	
	@Then("^I validate the response status is'(\\d+)'$")
	public void i_validate_the_response_status_is(int arg1) throws Throwable {
		user_validate_the_response_status_is(arg1);
	}
	
	@Then("^I validate the Bin created with ID$")
	public void i_validate_the_Bin_created_with_ID()  {
		
		try {
			log.info(res.getCreatedID());
			}
			catch(Exception e) {
				log.info("Caught Exception");
				res.getFailMessage();
			}
		
	}

	@Then("^I validate the failure message$")
	public void i_validate_the_failue_message()  {
		log.info(res.getFailMessage());
		if(res.getFailMessage().contains("Error Message")) {
			Assert(true);
		}
		else {
			Assert(false);
		}
	}
	
	private void Assert(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Then("^I validate the created bin with provided \"([^\"]*)\"$")
	public void i_validate_the_created_bin_with_provided(String binName) {
		log.info(res.getBinName());
		try {
		Assert.assertEquals(binName,res.getBinName());
		}
		catch(Exception e) {
			Assert.fail();
		}
		
	}
	
	
	
	
}
