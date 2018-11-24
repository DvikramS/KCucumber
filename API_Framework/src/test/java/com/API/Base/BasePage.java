package com.API.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.lang.model.element.ExecutableElement;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utility.ExcelUtility;

public class BasePage {
	
	public static Properties pr;
	public static FileInputStream f;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports er;
	public static ExcelUtility ex;
	
	static{
		reporter=new ExtentHtmlReporter(".\\Reports\\extentreports.html");
		er=new ExtentReports();
		er.attachReporter(reporter);
		ex=new ExcelUtility(".\\TestData.xlsx");
		try {
			
			pr=new Properties();
			f=new FileInputStream(".\\src\\test\\java\\com\\API_Framework\\URLs\\config.properties");
			pr.load(f);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
