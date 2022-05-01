package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;


public class TestsExample {
	@Test
	public void Test1()
	{
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getStatusLine());
		
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	
		
	}
	
@Test
public void Test_2() {
     RestAssured.baseURI ="https://reqres.in/";
	RestAssured.given().
	get("api/users?page=2").
	then().
	statusCode(200).
	body("data[2].id", equalTo(9))
	.log().all();
}

}


