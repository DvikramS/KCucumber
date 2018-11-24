package API_Framework.API_Framework;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.API.Base.BasePage;
import com.API.classes.posts;
import com.API_Framework.URLs.resources;
import com.API_Framework.WebServices.WebServices;

import Utility.UtilityFunctions;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Test2 {

	
	
	
	@Test
	public void AddPatchData(){
		
		
		posts p=new posts();
		p.setId(6);
		p.setTitle("mytitle1");
		String URl=BasePage.pr.getProperty("FixedURL")+resources.post_items.getResources("6");
		Response resp=WebServices.patch(URl, p);
		System.out.println(resp.asString());
		Assert.assertEquals(201, resp.getStatusCode());
		
	}
	
	@DataProvider
	public Object[][] getDataForAddPatchData(){
		Object[][]a=UtilityFunctions.getData("AddPatchData", BasePage.ex);
		return a;
	}
}
