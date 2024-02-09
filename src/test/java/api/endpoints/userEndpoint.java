package api.endpoints;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.github.javafaker.Internet.UserAgent;

import api.payload.Users;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndpoint {
	
	
	public static Response createUser(Users payload)
	{
		Response response=given()
				          .contentType(ContentType.JSON)
				          .accept(ContentType.JSON)
				          .body(payload)
				          .when()
				          .post(rootsURL.post_url);
				          
		return response;
		
	}
	
	public static Response getUser(String userName)
	{
		Response response=given()
				.pathParam("username", userName)
				.when()
				.get(rootsURL.get_url);
		
		return response;
	}
	
	public static Response putUser(Users payload,String userName)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
				.when()
				.put(rootsURL.put_url);
         return response;
	}
	
	public static Response deleteUser(String userName)
	{
		Response response=given()
				.pathParam("username", userName)
				.when()
				.delete(rootsURL.delete_url);
		
		return response;
	}
	

}
