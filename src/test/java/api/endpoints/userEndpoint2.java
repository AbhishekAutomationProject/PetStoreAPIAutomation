package api.endpoints;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.github.javafaker.Internet.UserAgent;

import api.payload.Users;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndpoint2 {
	
	static ResourceBundle getURL()
	{
		ResourceBundle bunlde=ResourceBundle.getBundle("roots");
		return bunlde;
	}
	
	
	public static Response createUser(Users payload)
	{
		String post_url= getURL().getString("post_url");
		
		Response response=given()
				          .contentType(ContentType.JSON)
				          .accept(ContentType.JSON)
				          .body(payload)
				          .when()
				          .post(post_url);
				          
		return response;
		
	}
	
	public static Response getUser(String userName)
	{
		String get_url= getURL().getString("get_url");
		
		Response response=given()
				.pathParam("username", userName)
				.when()
				.get(get_url);
		
		return response;
	}
	
	public static Response putUser(Users payload,String userName)
	{
		String update_url= getURL().getString("update_url");
		
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
				.when()
				.put(update_url);
         return response;
	}
	
	public static Response deleteUser(String userName)
	{
		String delete_url= getURL().getString("delete_url");
		
		Response response=given()
				.pathParam("username", userName)
				.when()
				.delete(delete_url);
		
		return response;
	}
	

}
