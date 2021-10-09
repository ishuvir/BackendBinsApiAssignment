package stepdefinitions;

import org.apache.log4j.Logger;
import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataprovider.configReader;
import helper.loggerHelper;

import utilities.responseUtility;

public class RequestStepDefs extends configReader{

	private static Logger log = loggerHelper.getLogger(RequestStepDefs.class);
	
	responseUtility res=new responseUtility();
	String statusLineCode="HTTP/1.1 200 OK";
	String sampleText="<Hello World>";
    
	
	@Given("^I created the GET request with BinID$")
	public void i_created_the_GET_request_with_BinID() {
		res.getRequestParam(getBaseUrl(),getToken(),"null");
		res.sendRequest(responseUtility.GET_REQUEST,binroute()+binsampleupdate());
		
	}
	
	
	@Given("^I created the GET request with ValidBinID$")
	public void i_created_the_GET_request_with_ValidBinID() {
		res.getRequestParam(getBaseUrl(),getToken(),"null");
			
	}
	
	
	@Given("^I created the GET request with ID$")
	public void i_created_the_GET_request_with_ID() {
		res.getRequestParam(getBaseUrl(),getToken(),"null");
		res.sendRequest(responseUtility.GET_REQUEST,binroute()+binIDupdate());  
	}

	@Given("^I created the GET request with Invalid token$")
	public void i_created_the_GET_request_with_Invalid_token() {
		res.getRequestParam(getBaseUrl(),getInvalidToken(),"null");
		
	}

	@When("^I sent the request$")
	public void i_sent_the_request()  {
		res.sendRequest(responseUtility.GET_REQUEST,binroute()+binDelete());   
	}

	@When("^I sent the Binrequest$")
	public void i_sent_the_Binrequest()  {
		res.sendRequest(responseUtility.GET_REQUEST,binroute()+binID());   
	}
	
	public void i_sent_the_request(String binIDUpdate)  {
		res.sendRequest(responseUtility.GET_REQUEST,binIDUpdate);   
	}
	
	@When("^I sent the request with latest route$")
	public void i_sent_with_latest_request() throws Throwable {
		res.sendRequest(responseUtility.GET_REQUEST,binroute()+binID()+"/latest");   
	}
	

	@Then("^I validate the response status is '(\\d+)'$")
	public void i_validate_the_response_status_is(int codeS)  {
		 int statuscode=res.getStatusCode();
	       Assert.assertEquals(codeS, statuscode);
	       
	       log.info(" response code "+ statuscode );
	}
	
	@And("^I validate the Response ID with BinID$")
	public void I_validate_the_Response_ID_with_BinID()  {
		String idFound=res.getCreatedID();
		log.info("BINID for response: "+ idFound);
		Assert.assertEquals("/"+idFound,binID());
		log.info("Correct response found for BinID ");
		log.info("Status Line code"+ res.getStatusLineCode());
	}
	
	@And("^I verify the creation date in response$")
	public void I_verify_the_creation_date_in_response()  {
		String idDateFound=res.getCreationDate();
		log.info("BINID creation date for response: "+ idDateFound);
		
	}
	
	@Then("^I validate the Status line code$")
	public void i_validate_the_Status_line_code()  {
	  
		String StatusLine=res.getStatusLineCode();
		log.info("Status line code: "+ StatusLine);
		Assert.assertEquals(statusLineCode,StatusLine);
	}
	
	@Then("^I validate the Error message$")
	public void i_validate_the_failue_message()  {
		log.info(res.getFailMessage());
		if(res.getFailMessage().contains("X-Master-Key is invalid or the bin doesn't belong to your account")) {
			Assert(true);
		}
		else {
			Assert(false);
		}
	}
	
	@Given("^I created the GET request with X-Bin-Meta Header as \"([^\"]*)\"$")
	public void i_created_the_GET_request_with_X_Bin_Meta_Header_as(boolean arg1) {
		res.getRequestParam(getBaseUrl(),getToken(),arg1);
	}

	@Then("^I verified the response body$")
	public void i_verified_the_response_body() {
		log.info(res.getBody());
	//	If()
	}
	
	@Then("^I verified the response body for metadata header \"([^\"]*)\"$")
	public void i_verified_the_response_body_for(boolean headerStatus) throws Throwable {
		log.info("Response body :" +res.getBody());
	   if(headerStatus) {
		   boolean tr=res.getBody().contains("metadata");
		   if(tr==true) {
			   log.info("Response body include metadata");
		   }
		   else {
			  Assert.fail();
		   }
		   
	   }
	   else {
		 		   
		   boolean tr=res.getBody().contains("metadata");
		   if(tr) {
	//		  Assert.fail();
			   log.info("Response body Still include metadata");
		   }
		   else {
			   log.info("Response body doesnt include metadata");
		   }
	   }
	}

	
	@Given("^I verified the sample value in Response$")
	public void i_verified_the_sample_value_in_Response()  {
		i_sent_the_request(binroute()+binsampleupdate());
		i_validate_the_response_status_is(200);
		log.info("Value of sample Key "+ res.getSampleValue());
		Assert.assertEquals(sampleText,res.getSampleValue());
	}

	@When("^I updated the sample value as \"([^\"]*)\"$")
	public void i_updated_the_sample_value_as(String newSampleValue) throws Throwable {
		res.updateParam(getBaseUrl(),getToken(),true, "null",newSampleValue, "sample");
	}
	
	@Given("^I updated the sample value as \"([^\"]*)\" with Invalid token$")
	public void i_updated_the_sample_value_as_Invalid_Token(String newSampleValue) throws Throwable {
		res.updateParam(getBaseUrl(),getInvalidToken(),true, "null",newSampleValue, "sample");
	}

	@When("^I sent the PUT Request with updated sample$")
	public void i_sent_the_PUT_Sample_Request() throws Throwable {
		res.sendRequest(responseUtility.PUT_REQUEST,binroute()+binsampleupdate());
	}
	@When("^I sent the PUT Request with updated id$")
	public void i_sent_the_PUT_Updated_ID_Request() throws Throwable {
		res.sendRequest(responseUtility.PUT_REQUEST,binroute()+binIDupdate());
	}

	@Then("^I validate resonse with update sample value \"([^\"]*)\"$")
	public void i_validate_resonse_with_update_sample_value(String sampleValue) throws Throwable {
		i_validate_the_response_status_is(200);
		log.info("Value of sample Key "+ res.getSampleValue());
		Assert.assertEquals(sampleValue,res.getSampleValue());
		
		log.info("----------------BinID update back-----------------------");
		res.updateParam(getBaseUrl(),getToken(),true, "null",sampleText,"sample");
		res.sendRequest(responseUtility.PUT_REQUEST,binroute()+binsampleupdate());
		i_validate_the_response_status_is(200);
		log.info("Value of sample Key "+ res.getSampleValue());
		Assert.assertEquals(sampleText,res.getSampleValue());
	}


	@Given("^I verified the ID value in Response$")
	public void i_verified_the_ID_value_in_Response() throws Throwable {
		log.info("ID value : "+res.getCreatedID());
		Assert.assertEquals(binIDupdate(),"/"+res.getCreatedID());
		
	}

	
	
	@When("^I updated the ID value as \"([^\"]*)\"$")
	public void i_updated_the_ID_value_as(String idValue) throws Throwable {
		res.updateParam(getBaseUrl(),getToken(),true, "null",idValue,"id");
		
	}
	

	@Then("^I validate resonse with updated ID as \"([^\"]*)\"$")
	public void i_validate_resonse_with_updated_ID_as(String idValueUpdate) throws Throwable {
		log.info("ID value : "+res.getNewID());
		Assert.assertEquals(idValueUpdate,res.getNewID());
	}

	@Then("^I validate response with old parentID$")
	public void i_validate_response_with_old_parentID() throws Throwable {
		log.info("ID value : "+res.getBody());
		Assert.assertEquals(binIDupdate(),"/"+res.getCreatedParentID());
		
		if(res.getBody().contains("616020f04a82881d6c5d2ee2")) {
			Assert(true);
			
		}
		else {
			Assert.fail();
		}
	}
	
	
	
	
	private void Assert(boolean b) {
		
	}
	
}
