package com.api.tests;

import org.testng.annotations.Test;

import com.api.objects.LoginRequestObject;
import static com.api.utilities.Utils.*;
import com.ui.utilities.ConfigLoader;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class FDAPITest {
	@Test
	public void createJOb() {

		baseURI = ConfigLoader.getInstance().getBaseUri();

		File jsonSchemaFile = new File(System.getProperty("user.dir") + "//src//test//resources//responseSchemas//loginResponseSchema.json");

		LoginRequestObject loginRequestObject = new LoginRequestObject(ConfigLoader.getInstance().getUsername("FD"),
				ConfigLoader.getInstance().getPassword("FD"));

		String token = given().header("Content-Type", "application/json").body(getJsonObject(loginRequestObject)).when()
				.post("/login").then().log().all().assertThat().statusCode(200).and()
				.body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaFile)).and().extract().jsonPath()
				.getString("data.token");

		int jobNumber = given().header("Content-Type", "application/json").header("Authorization", token)
				.body(getJsonObject(getCreatJobPOJO())).when().post("/job/create").then().assertThat()
				.statusCode(200).and().body("message", equalTo("Job created successfully. ")).and().extract().jsonPath()
				.getInt("data.id");

		System.out.println("jobNumber: "+jobNumber);

	}

}
