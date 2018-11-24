package API_Framework.API_Framework;

import java.io.File;
import java.io.IOException;

import com.google.gson.Gson;


import io.restassured.path.json.JsonPath;

public class JSONREADER {
	public static void main(String[] args){
		
		File f=new File(".\\src\\test\\java\\user.json");
	String user1=JsonPath.with(f).getString("FR.username");
	String user2=JsonPath.with(f).getString("IT.username");
	System.out.println(user1);
	System.out.println(user2);
	
		
	
	}
}
