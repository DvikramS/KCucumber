package com.API_Framework.WebServices;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
public class WebServices {

	public static Response get(String Uri){
		
		RequestSpecification rs=given();
		rs.contentType(ContentType.JSON);
		Response rsp=rs.get(Uri);
		return rsp;
	}
	public static Response post(String Uri, String stringJson){
		Response resp=given().body(stringJson).when().contentType(ContentType.JSON).post(Uri);
		
		
		
		
		return resp;
	}
	public static Response post(String Uri, Object obj){
		Response resp=given().body(obj).when().contentType(ContentType.JSON).post(Uri);
		
		
		return resp;
	}
	public static Response put(String uri,String stringJson){
		Response resp=given().body(stringJson).when().contentType(ContentType.JSON).put(uri);
		return resp;
	}
	public static Response put(String uri,Object obj){
		Response resp=given().body(obj).when().contentType(ContentType.JSON).put(uri);
		return resp;
	}

public static Response patch(String uri,String stringJson){
	Response resp=given().body(stringJson).when().contentType(ContentType.JSON).put(uri);
	return resp;
}
public static Response patch(String uri,Object obj){
	Response resp=given().body(obj).when().contentType(ContentType.JSON).put(uri);
	return resp;
}
public static Response delete(String uri){
	Response resp=given().when().contentType(ContentType.JSON).delete(uri);
	return resp;
}
}