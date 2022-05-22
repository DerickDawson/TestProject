package com.supervillain.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Covid19TheGameVillain {
	
	String TOKEN = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJrZXkiOiJjcmF6eVRob3IiLCJlbWFpbCI6ImRlcmljay5kYXdzb25AZ21haWwuY29tIiwiaWF0IjoxNjUzMTU1MTk4LCJleHAiOjE2NTM0MTQzOTh9.gP3JyXD3Yi2ENWi6EXUYKs7v9sX6B8_zkOkNY57c5lhfKgKYnHWsGs2gcy_5MHWD7ceShnAkGhRDiUXE4rd08Q";
	String REGISTER_LOGIN_USER = "swagthor016";
	String NEW_UPDATE_USER = "swagthor053";
	String NEW_USER_SCORE = "500";
	String UPDATE_USER_SCORE = "2500";
	
	/*
	 * 01 - Application Authorization
	 * To Check is Token is still valid.
	 * Token created on 22 May 2022 12:46 PM CST
	 * 
	 */

	@Test
	public void testSuperVillainVerifyToken() {
		baseURI = "https://supervillain.herokuapp.com";
		given().
			header("Authorization", TOKEN).
		when().	
			get("/auth/verifytoken").
		then().
			statusCode(200);
		System.out.println("Test 1 : Token is valid");
	}

	/*
	 * 02 - User Authentication (Register User and Login User)
	 * 
	 */
	
	// Register User
	@Test(dependsOnMethods = {"testSuperVillainVerifyToken"})
	public void testUserRegistration() {
		
		JSONObject request = new JSONObject();
		request.put("username", REGISTER_LOGIN_USER);
		request.put("password", REGISTER_LOGIN_USER);
		
		baseURI = "https://supervillain.herokuapp.com";
		given().
			header("accept", "*/*").
			header("Authorization", TOKEN).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().	
			post("/auth/user/register").
		then().
			statusCode(200);
		System.out.println("Test 2 : "+REGISTER_LOGIN_USER+" is registered.");
	}
	
	// User Login
	@Test(dependsOnMethods = {"testSuperVillainVerifyToken", "testUserRegistration"})
	public void testUserLogin() {
			
		JSONObject request = new JSONObject();
		request.put("username", REGISTER_LOGIN_USER);
		request.put("password", REGISTER_LOGIN_USER);
					
		baseURI = "https://supervillain.herokuapp.com";
		given().
			header("accept", "*/*").
			header("Authorization", TOKEN).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().	
			post("/auth/user/login").
		then().
			statusCode(200);
		System.out.println("Test 3 : "+REGISTER_LOGIN_USER+" logged in.");
	}
	
	/*
	 * 03 - User Leaderboard (User lists, Add new user and Update user)
	 * 
	 */

	// List of users
	@Test(dependsOnMethods = {"testSuperVillainVerifyToken"})
	public void testListofUsers() {
			
		baseURI = "https://supervillain.herokuapp.com";
		given().
			header("accept", "application/json").
			header("Authorization", TOKEN).
		when().	
			get("/v1/user").
		then().
			statusCode(200).log().all();
		System.out.println("Test 4 : List of users returned");
	}
	
	
	// Add new user
	@Test(dependsOnMethods = {"testSuperVillainVerifyToken"})
	public void testAddNewUser() {
		JSONObject request = new JSONObject();
		request.put("username", NEW_UPDATE_USER);
		request.put("score", NEW_USER_SCORE);
		
		baseURI = "https://supervillain.herokuapp.com";
		given().
			header("accept", "*/*").
			header("Authorization", TOKEN).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().	
			post("/v1/user").
		then().
			statusCode(201);
		System.out.println("Test 5 : "+NEW_UPDATE_USER+ " with score "+NEW_USER_SCORE+" is added.");
	}
	
	
	// Update user
	@Test (dependsOnMethods = {"testAddNewUser"})
	public void testUpdateUser() {
		JSONObject request = new JSONObject();
		request.put("username", NEW_UPDATE_USER);
		request.put("score", UPDATE_USER_SCORE);
		
		baseURI = "https://supervillain.herokuapp.com";
		given().
			header("accept", "*/*").
			header("Authorization", TOKEN).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().	
			put("/v1/user").
		then().
			statusCode(204);
		System.out.println("Test 6 : "+NEW_UPDATE_USER+ " with score "+UPDATE_USER_SCORE+" is added.");
	}
	
	
}
