package api.endpoints;

/*
     Create: https://petstore.swagger.io/v2/user
     Get:  https://petstore.swagger.io/v2/user/{username} 
     put: https://petstore.swagger.io/v2/user/{username} 
     delete: https://petstore.swagger.io/v2/user/{username} 
 */


public class rootsURL {
	
	public static String baseURL="https://petstore.swagger.io/v2";
	
	public static String post_url=baseURL+"/user";
	public static String get_url=baseURL+"/user/{username}";
	public static String put_url=baseURL+"/user/{username}";
	public static String delete_url=baseURL+"/user/{username}";
	
	

}
