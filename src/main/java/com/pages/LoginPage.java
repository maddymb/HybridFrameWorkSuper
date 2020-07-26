package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.utility.TestUtility;


public class LoginPage extends TestBase {

	@FindBy(id="login_id")
	WebElement username;
	
	@FindBy(id="nextbtn")
	WebElement nextbtn;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="(//*[text()='Sign in'])[2]")
	WebElement signInButton;
	
	@FindBy(xpath = "(//*[text()='Leads'])[2]")
	WebElement btnLeads;
	
	@FindBy(xpath = "//*[@id='createIcon']")
	WebElement iconCreate;
	
	@FindBy(xpath = "//*[text()='Lead']")
	WebElement createLeads;


	//Constructor of the Class
	public LoginPage() {	
		PageFactory.initElements(driver, this); 
		// or we can write PageFactory.initElements(driver, LoginPage.class);
	}
	
	//This Method will Return the Title of Web Page
	public String validateTitle() {
		return driver.getTitle();	
	}
	

	
	//This Method will perform the Login Action
	public CreateLeadPage login(String uname,String pass) {
			
		TestUtility.sendKeys(username, uname);
		log("UserName Entered "+uname);
		
		nextbtn.click();
		log("Next Button Clicked");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TestUtility.sendKeys(password, pass);
		log("Password Entered "+pass);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		signInButton.click();
		log("Sign In Button Clicked");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnLeads);
		
		btnLeads.click();
		log("Leads Button Clicked");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		iconCreate.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createLeads.click();
		
		
		return new CreateLeadPage();
		
		
	}
	

}
