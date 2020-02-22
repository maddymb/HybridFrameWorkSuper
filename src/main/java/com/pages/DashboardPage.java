package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class DashboardPage extends TestBase {

	
	@FindBy(xpath = "//*[text()='Leads']")
	WebElement btnLeads;


	public DashboardPage() {

		PageFactory.initElements(driver, this);
	}
		
	public void clickLeadsBtn() {
		btnLeads.click();
		log("Leads Button Clicked");
		
	}

	
	
	
	
}
