package API_Framework.API_Framework;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.API.Base.BasePage;
import com.API.classes.posts;
import com.API_Framework.URLs.resources;
import com.API_Framework.WebServices.WebServices;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.gson.*;

import Utility.UtilityFunctions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import  static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;
public class Test1 extends BasePage{
	public static Gson g;
	
	@BeforeSuite
	public void testB(){
		g=new Gson(); 
	}
	//get posts by id
	@Test
	public void test1(){
		
		String uri=pr.getProperty("FixedURL")+resources.get_itemsById.getResources("1");
		Response rsp=WebServices.get(uri);
		//System.out.println(rsp.asString());
		posts p=g.fromJson(rsp.asString(), posts.class);
		int code=rsp.getStatusCode();
		double rsptime=rsp.getTimeIn(TimeUnit.SECONDS);
		System.out.println(rsp.statusLine());
	
		
		
		
		int path= rsp.then().contentType(ContentType.JSON).extract().path("id");
		//System.out.println(rsp.then().contentType(ContentType.JSON).extract().path("[0].id"));
		System.out.println(path);
	System.out.println(rsp.asString());
		SoftAssert s=new SoftAssert();
		//int a=p.getId();
		s.assertEquals(p.getId(), 1,"IDmatched");
		s.assertEquals(p.getAuthor(), "43", "author matched");
		s.assertEquals(p.getTitle(), "43-server","Title matched");
	s.assertEquals(code, 200, code+"not matched");
	s.assertTrue(rsptime<30.0, rsptime+"timeexceeds");
		s.assertAll();
		
		
	}
	
	//schemavalidation
	//@Test
	public void validate(){
		String uri=pr.getProperty("FixedURL")+resources.get_itemsById.getResources();
		Response rsp=WebServices.get(uri);
		//JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();
		rsp.then().assertThat().body(matchesJsonSchemaInClasspath("PostsGetById.JSON"));
		
		
		
	}
	
	
	
	
	//get all posts
	//@Test
	public void test2(){
		String uri=pr.getProperty("FixedURL")+resources.get_itemsById.getResources();
		//Response rsp=WebServices.get(uri);

	}
	
	
	
	
	
	//get posts by id
	//@Test
	public void test6(){
		
		String URl=pr.getProperty("FixedURL")+resources.get_itemsById.getResources("1");
		System.out.println(URl);
		Response rsp=WebServices.get("https://restcountries.eu/rest/v2/name/ind");
		Gson gson=new Gson();
		String s=rsp.asString();
//Country c = gson.fromJson(s.substring(1, s.length()-2), Country.class);
	//System.out.println(c.getName());
		
		/*System.out.println(s.substring(1, s.length()));
		System.out.println(rsp.asString());
		System.out.println(rsp.getTime());
	*/	Assert.assertEquals(200, rsp.getStatusCode());
	}
	
	//post items
	//@Test(dataProvider="getDataForAddPostData")
	public void AddPostData(Hashtable hs){
		/*posts p=new posts();
		p.setId(9);
		p.setTitle("mytitle");p.setAuthor("viki");*/
		String URl=pr.getProperty("FixedURL")+resources.post_items.getResources();
		Response resp=WebServices.post(URl, hs.get("json"));
		System.out.println(resp.asString());
		Assert.assertEquals(201, resp.getStatusCode());
		
	}
	
/*	@DataProvider
	public Object[][] getDataForAddPostData(){
		Object[][]a=UtilityFunctions.getData("AddPostData", BasePage.ex);
		return a;
	}//public void test(){
	
	@Test(dataProvider="getDataForTests")
	public void test(Hashtable<String, String> hs){
		Response resp=given().contentType("application/xml").body(hs.get("xml")).post("https://czcholsint1203.prg-dc.dhl.com:8009/label-api/misc/rest/v7/parcels");
		System.out.println(resp.asString());
	}*/
	
	
	
	
	
/*	@DataProvider
	public Object[][] getDataForTests(){
		Object[][]a=UtilityFunctions.getData("Tests", BasePage.ex);
		return a;
	}*/

}
