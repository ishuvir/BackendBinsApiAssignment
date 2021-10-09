package utilities;

import org.apache.log4j.Logger;
import org.junit.Assert;

import helper.loggerHelper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepdefinitions.RequestStepDefs;

public class responseUtility extends requestUtility{
	
	private static Logger log = loggerHelper.getLogger(responseUtility.class);
	
	public static final int GET_REQUEST = 0;
	public static final int POST_REQUEST = 1;
	public static final int DELETE_REQUEST = 2;
	public static final int PUT_REQUEST = 3;
	public Response response;
	public JsonPath jsonPathEvaluator;
	
	
	
	public int getStatusCode() {
			return response.getStatusCode();	
					
	}
	
	public String getBody() {
		return response.body().asString();	
				
}
	
	public String getCreatedID() {
		String successCode = response.jsonPath().get("SuccessCode");
		log.info("Success code is"+successCode);
		jsonEvua();
		String idNum = jsonPathEvaluator.get("metadata.id");
		log.info(idNum);
		return idNum;
	}
	
	public String getNewID() {
		String successCode = response.jsonPath().get("SuccessCode");
		log.info("Success code is"+successCode);
		jsonEvua();
		String idNum = jsonPathEvaluator.get("record.id");
		return idNum;
	}
	
	public String getCreatedParentID() {
		String successCode = response.jsonPath().get("SuccessCode");
		log.info("Success code is"+successCode);
		jsonEvua();
		String parentidNum = jsonPathEvaluator.get("metadata.parentId");
		return parentidNum;
	}
	
	public JsonPath jsonEvua() {
		 jsonPathEvaluator = response.jsonPath();
		return jsonPathEvaluator;
		
	}
	
	public String getFailMessage() {
		jsonEvua();
		String errorMessage = response.asString();
		return errorMessage;
	}

	public String getBinName() {
		jsonEvua();
		String idName = jsonPathEvaluator.get("metadata.name");
		return idName;
	}
	
	public String getSampleValue() {
		jsonEvua();
		String sampleValue = jsonPathEvaluator.get("record.sample");
		return sampleValue;
	}
	
	public String getCreationDate() {
		jsonEvua();
		String idDate = jsonPathEvaluator.get("metadata.createdAt");
		return idDate;
	}
	public String getBinMessage() {
		jsonEvua();
		String message = jsonPathEvaluator.get("message");
		return message;
	}
	
	public int getdeleteVersion() {
		jsonEvua();
		int messageVersion = jsonPathEvaluator.get("metadata.versionsDeleted");
		return messageVersion;
	}
	
	public String getStatusLineCode() {
		return response.statusLine();
	}
	
	public Response sendRequest( int requestType, String route) {
		
		// need to add a switch based on request type
		switch (requestType) {
		case responseUtility.GET_REQUEST:
			if (null == request) {
				response =RestAssured.when().get(route); 
			} else {
			 
			response = request.get(route); 
		}
			break;
		case responseUtility.POST_REQUEST:
			if (null == request) {
				response = RestAssured.when().post(route);
			} else {
				response = request.post(route);
			}
			break;
		case responseUtility.DELETE_REQUEST:
			if (null == request) {
				response = RestAssured.when().delete(route);
			} else {
				response = request.delete(route);
			}
			break;
		case responseUtility.PUT_REQUEST:
			if (null == request) {
				response = RestAssured.when().put(route);
			} else {
				response = request.put(route);
			}
			break;
		default:
			if (null == request) {
				response = RestAssured.when().post(route);
			} else {
				response = request.post(route);
			}
			response = request.post(route);
			break;
		}
		return response;
		
	}
	
	
	
	
}
