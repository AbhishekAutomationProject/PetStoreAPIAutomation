package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndpoint;
import api.payload.Users;
import api.utilities.dataProvideres;
import io.restassured.response.Response;

public class DDTests {
	
	
	@Test(priority = 1,dataProvider = "data",dataProviderClass = dataProvideres.class)
    public void testPostuser(String userID,String userName,String fname,String lname,String email,String pass,String phone)
    {
		 Users usersPayload=new Users();
		 
		 usersPayload.setId(Integer.parseInt(userID));
		 usersPayload.setUsername(userName);
		 usersPayload.setFirstname(fname);
		 usersPayload.setLastname(lname);
		 usersPayload.setEmail(email);
		 usersPayload.setPassword(pass);
		 usersPayload.setPhone(phone);
		 
		 Response response=userEndpoint.createUser(usersPayload);
		 AssertJUnit.assertEquals(response.getStatusCode(),200);
    }
	
	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = dataProvideres.class)
	public void testDeleteUser(String userName) {
		Response response=userEndpoint.deleteUser(userName);
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}
	
}
