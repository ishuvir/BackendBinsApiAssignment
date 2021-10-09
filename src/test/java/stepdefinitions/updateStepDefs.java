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

public class updateStepDefs extends configReader{
	private static Logger log = loggerHelper.getLogger(updateStepDefs.class);
	
	responseUtility res=new responseUtility();
	String statusLineCode="HTTP/1.1 200 OK";
	String sampleText="<Hello World>";
	String masterKeyMessage="Invalid X-Master-Key provided";

	@Given("^I hold valid Bin$")
	public void i_hold_valid_Bin() {
		res.getRequestParam(getBaseUrl(),getToken(),"null");
		
	}
	
	@Given("^I hold Invalid token Bin$")
	public void i_hold_Invalid_Bin() {
		res.getRequestParam(getBaseUrl(),getInvalidToken(),"null");
		
	}

	@When("^I sent the delete request$")
	public void i_sent_the_delete_request() {
		res.sendRequest(responseUtility.DELETE_REQUEST,binroute()+binToBeDelete());  
	}
	
	@And("^I validate the Response ID with deleted BinID$")
	public void I_validate_the_Response_ID_with_deleted_BinID()  {
		String idFound=res.getCreatedID();
		log.info("BINID for response: "+ idFound);
		Assert.assertEquals("/"+idFound,binToBeDelete());
		log.info("Correct response found for BinID ");
		log.info("Status Line code"+ res.getStatusLineCode());
	}

	@Then("^I verify the deletion message$")
	public void i_verify_the_deletion_message()  {
	   if(res.getBody().contains("Bin deleted successfully")){
		   log.info("Bin deleted successfully");
		   Assert.assertEquals("Bin deleted successfully",res.getBinMessage());
		   
	   }
	   else {
		   Assert.fail();
	   }
	}

	

	@Then("^I verified Delete version$")
	public void i_verified_Delete_version()  {
		Assert.assertEquals(0,res.getdeleteVersion());
	}
	
	@Then("^I sent the get request$")
	public void i_sent_the_get_request() throws Throwable {
		res.getRequestParam(getBaseUrl(),getToken(),"null");
		res.sendRequest(responseUtility.GET_REQUEST,binroute()+binDelete());
	}

	@Then("^I verified Bin not found$")
	public void i_verified_Bin_not_found() {
		 if(res.getBody().contains("Bin not found or it doesn't belong to your account")){
			   log.info("Bin not found or it doesn't belong to your account");
			   Assert.assertEquals("Bin not found or it doesn't belong to your account",res.getBinMessage());
			   
		   }
		   else {
			   Assert.fail();
		   }
	}
	
	
	@And("^I verified Invalid master key response$")
	public void i_verified_Invalid_Master_found() {
		 if(res.getBody().contains(masterKeyMessage)){
			   log.info(masterKeyMessage);
			   Assert.assertEquals(masterKeyMessage,res.getBinMessage());
			   
		   }
		   else {
			   Assert.fail();
		   }
	}
	
	@Then("^I validate the response code is '(\\d+)'$")
	public void i_validate_the_response_status_is(int codeS)  {
		 int statuscode=res.getStatusCode();
	       Assert.assertEquals(codeS, statuscode);
	       
	       log.info(" response code "+ statuscode );
	}
}
