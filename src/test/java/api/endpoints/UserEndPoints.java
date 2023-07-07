package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response creatUser(User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
	.when()
	     .post(Routes.post_url);
		return response;
	
	}
	
	public static Response readUser(String firstName)
	{
		Response response=given()
				.pathParam("first_name", firstName)
				.when()
				  .get(Routes.get_url);
		
		return response;
	}

	public static Response updateUser(String firstName,User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("first_name",firstName)
		.body(payload)
	.when()
	     .post(Routes.post_url);
		return response;
		
	}
	
}
