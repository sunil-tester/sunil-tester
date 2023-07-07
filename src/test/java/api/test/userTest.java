package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class userTest {
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData() 
	{
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setAvatar(faker.avatar().image());
	}

	@Test(priority=1)
	public void testPostUser() {
		
		
		Response response=UserEndPoints.creatUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=2)
	public void getUserByName() {
		Response response=UserEndPoints.readUser(this.userPayload.getFirstname());
response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=3)
	
	public void putUser() {
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		
		Response response=UserEndPoints.updateUser(this.userPayload.getFirstname(),userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		Response afterResponse=UserEndPoints.readUser(this.userPayload.getFirstname());
		response.then().log().all();
				
				Assert.assertEquals(afterResponse.getStatusCode(),200);

		
	}
	

}
