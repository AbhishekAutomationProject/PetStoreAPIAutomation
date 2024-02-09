package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndpoint;
import api.endpoints.userEndpoint2;
import api.payload.Users;
import freemarker.log.Logger;
import groovyjarjarantlr4.v4.runtime.misc.LogManager;
import io.restassured.response.Response;

public class userTests2 {
	
	Faker fr;
	Users userPayload ;
	
	public org.apache.logging.log4j.Logger logger;
   
	@BeforeTest
	void payloadData()
	{
		
		fr= new Faker();
		userPayload = new Users();
		
		userPayload.setId(fr.idNumber().hashCode());
		userPayload.setUsername(fr.name().username());
		userPayload.setFirstname(fr.name().firstName());
		userPayload.setLastname(fr.name().lastName());
		userPayload.setEmail(fr.internet().safeEmailAddress());
		userPayload.setPassword(fr.internet().password(5,10));
		userPayload.setPhone(fr.phoneNumber().cellPhone());
		
		logger=org.apache.logging.log4j.LogManager.getLogger(this.getClass());
		
	}
	
     @Test(priority = 1)
     void testCreate()
     {
    	 logger.info("************Creating  User********************");
    	 Response response=userEndpoint2.createUser(userPayload);
    	 response.then().log().all();
    	 
    	 AssertJUnit.assertEquals(response.statusCode(), 200);
    	 
    	 logger.info("************Creating  Created********************");
     }
     
     @Test(priority = 2)
     void testGet()
     {
    	 logger.info("************Getting User Details********************");
    	 Response response=userEndpoint2.getUser(this.userPayload.getUsername());
    	 AssertJUnit.assertEquals(response.getStatusCode(), 200); 
    	 logger.info("************User Details Retrieved********************");
     }
     
     @Test(priority = 3)
     void testUpdate()
     {
    	 logger.info("************Updating User Details********************");
    	 userPayload.setFirstname(fr.name().firstName());
  		userPayload.setLastname(fr.name().lastName());
  		userPayload.setEmail(fr.internet().safeEmailAddress());
  		
  		
  		
  		
     	 Response response=userEndpoint2.putUser(userPayload,this.userPayload.getUsername());
     	 response.then().log().all();
     	 
     	 AssertJUnit.assertEquals(response.statusCode(), 200);
     	 
     	logger.info("************User Details Updated********************");
     }
     
     @Test(priority = 4)
     void testDelete()
     {
    	 logger.info("************Deleting User Details********************"); 
    	 Response response=userEndpoint2.deleteUser(this.userPayload.getUsername());
    	 AssertJUnit.assertEquals(response.getStatusCode(), 200); 
    	 logger.info("************User Details Deleted********************");
     }
}
