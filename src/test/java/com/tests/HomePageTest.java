package com.tests;

import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import com.base.TestBase;
import com.pages.HomePage;
import com.utility.Log;
import com.utility.RunnerTest;

public class HomePageTest extends TestBase {

	
	public String TCID="HomePageTest";
	RunnerTest objRunnerTest= new RunnerTest(TCID);
	
	HomePage objHomePage;
	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod()
	public void beforeMethod(Method result) throws IOException {
		boolean runFlag=RunnerTest.isTestCaseRunnable(TCID);
		System.out.println(runFlag);
		if(runFlag==true) {
			extent_test = extent_report.startTest(result.getName());
			Log.startTestCase(result.getName());
			//log(result.getName() + " test Started");
			initialization();
		}
		else {
			System.out.println("The Test Case id is either invalid or Runmode of it is not 'Y' ");
			throw new SkipException("message");
			//System.exit(1);
		}
	}
	

	//@Test
	public void logoTest() {
		
		objHomePage.validateLogo();
		
		
	}
	
	@Test
	public void loginTest() throws Exception
	{
		objHomePage=new HomePage();
		objHomePage.clickLoginBtn();
		
	}
	
	
}
