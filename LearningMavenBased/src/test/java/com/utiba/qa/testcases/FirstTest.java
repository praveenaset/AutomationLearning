package com.utiba.qa.testcases;

import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utiba.qa.pojos.TestPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;

import io.restassured.specification.RequestSpecification;

public class FirstTest {
	
	
@BeforeClass

public void setup() {
	Connection c = null;
    try {
       Class.forName("org.postgresql.Driver");
       c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres",
          "postgres", "admin");
    } catch (Exception e) {
       e.printStackTrace();
       System.err.println(e.getClass().getName()+": "+e.getMessage());
       System.exit(0);
    }
    System.out.println("Opened database successfully");
 }


@Test
public void CreateUser() {
	
	TestPojo newUser = new TestPojo("chat kumar","Male","ck.ramegdgshna@15ce.com","active");
	String baseURL ="https://gorest.co.in/public/v2/users/";
	
/*	RequestSpecification request=RestAssured.given();
	
	request.header("Content-Type","application/xml");
	request.header("Authorization","Bearer 3a66706e01cd6d700e009bf17f45630edd0ffa0ccf1bfaff64d8d23e240f8f63");
	
	JsonSerializer jsonS = JsonSerializer.DEFAULT_READABLE;
	
	String json=null;
	
	try {
		json = jsonS.serialize(newUser).trim();
	} catch (SerializeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	System.out.println(json);
	
	request.body(newUser);
	Response resp = request.post("https://gorest.co.in/public/v2/users/");
	
	System.out.println(resp.prettyPrint());
	System.out.println(resp.getStatusCode());
	
	*/
	
	/*Response resp = */
		
	given().log().all()
	.header("Authorization","Bearer 3a66706e01cd6d700e009bf17f45630edd0ffa0ccf1bfaff64d8d23e240f8f63").accept(ContentType.JSON)
	.contentType("application/json").and().body(newUser).post("https://gorest.co.in/public-api/users").then().assertThat().statusCode(201);
	

}
	
	
	
	
}
