package utilities;

import org.json.JSONObject;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class requestUtility {
	RequestSpecification request ;
	JSONObject requestParams;
	
	public Response response;
	
    public RequestSpecification baseRequest(String baseURIL) {
    	RestAssured.baseURI =baseURIL;
   	    return request = RestAssured.given();
    }
    
	public void requestParam(String baseURIL,String token, String bName) {
	 baseRequest(baseURIL);
	 requestParams = new JSONObject();
	 requestbody();
	 requestHeader(token,bName);
	 request.body(requestParams.toString());
		
	}
	
	public void updateParam(String baseURIL,String token, boolean update, String bName,String bodyUpdate,String Key) {
		 baseRequest(baseURIL);
		 requestParams = new JSONObject();
		if(update==true) {
			requestbodyupdate(bodyUpdate,Key);
		}
		else {
			requestbody();
		}
		 requestHeader(token,bName);
		 request.body(requestParams.toString());
			
		}
	
	
	public void getRequestParam(String baseURIL,String token, String bName) {
	  baseRequest(baseURIL);
	  requestHeaderKey(token);
	 
	}
	
	public void getRequestParam(String baseURIL,String token, boolean header) {
		  baseRequest(baseURIL);
		  requestHeaderKey(token);
		  requestMetaData(header);
		}
	
	public void requestMetaData(boolean headerstatus) {
		
		 request.header("X-Bin-Meta", headerstatus);  
	} 
	
	public void requestHeaderKey(String tokenValue) {
	
		 request.header("X-Master-Key", tokenValue);  
	} 
	
	public void requestHeader(String tokenValue,String binName) {
		if(binName!=null) 
			{
				request.header("X-Bin-Name", binName);
			}
		request.header("Content-Type", "application/json");
		requestHeaderKey(tokenValue);
	} 
	
	
	public void requestbody() {
		requestParams.put("sample","Hello World"); 
			}
	
	public void requestbodyupdate(String sampleText,String Key) {
		requestParams.put(Key,sampleText); 
			}
}
