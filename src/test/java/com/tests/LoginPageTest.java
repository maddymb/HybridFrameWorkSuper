package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.Method;

import com.base.TestBase;
import com.pages.CreateLeadPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utility.Log;
import com.utility.RunnerTest;

public class LoginPageTest extends TestBase {

	LoginPage  objLoginPage;
	HomePage objHomePage;
	CreateLeadPage objCreateLeadPage;
	
	public String TCID="LoginPageTest";
	RunnerTest objRunnerTest= new RunnerTest(TCID);
	
	public LoginPageTest() throws IOException {
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
		else
			System.out.println("The Test Case id is either invalid or Runmode of it is not 'Y' ");
			//System.exit(1);
	}
	
	
	@Test
	public void loginTest() throws Exception
	{
		objHomePage= new HomePage();
		objLoginPage=objHomePage.clickLoginBtn();
		objCreateLeadPage=objLoginPage.login("madhurbhrdwj3@gmail.com", "maddymb18");
		Thread.sleep(3000);	
		//objCreateLeadPage.createLead();
		//Thread.sleep(3000);	
		
		
	}
	
	
}
