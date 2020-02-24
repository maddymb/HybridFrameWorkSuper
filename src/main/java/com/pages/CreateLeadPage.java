package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class CreateLeadPage extends TestBase {

	@FindBy(xpath = "//*[@id='Crm_Leads_FIRSTNAME']")
	WebElement firstName;

	@FindBy(xpath = "//*[@id='Crm_Leads_LASTNAME']")
	WebElement lastName;
	
	@FindBy(xpath = "//*[@id='Crm_Leads_DESIGNATION']")
	WebElement title;

	@FindBy(xpath = "//*[@id='Crm_Leads_EMAIL']")
	WebElement email;
	
	@FindBy(xpath = "//*[@id='Crm_Leads_COMPANY']")
	WebElement company;
	
	@FindBy(xpath = "//*[@id='Crm_Leads_PHONE']")
	WebElement phone;

	@FindBy(xpath = "//*[@id='Crm_Leads_FAX']")
	WebElement fax;
	
	@FindBy(xpath = "//*[@id='Crm_Leads_MOBILE']")
	WebElement mobile;

	@FindBy(xpath = "//*[@id='Crm_Leads_WEBSITE']")
	WebElement webSite;
	
	@FindBy(xpath = "//*[@id='Crm_Leads_FIRSTNAME']")
	WebElement leadSource;

	@FindBy(xpath = "//*[@id='Crm_Leads_FIRSTNAME']")
	WebElement leadStatus;
	
	@FindBy(xpath = "//*[@id='Crm_Leads_FIRSTNAME']")
	WebElement industry;

	@FindBy(xpath = "//*[@id='Crm_Leads_EMPCT']")
	WebElement noOfEmp;
	
	@FindBy(xpath = "//*[@id='Crm_Leads_ANNUALREVENUE']")
	WebElement annualRevenue;

	@FindBy(xpath = "//*[@id='Crm_Leads_FIRSTNAME']")
	WebElement rating;
	
	@FindBy(xpath = "//*[@id='Crm_Leads_SKYPEIDENTITY']")
	WebElement skypeId;

	@FindBy(xpath = "//*[@id='Crm_Leads_LANE']")
	WebElement street;
	
	@FindBy(xpath = "//*[@id='Crm_Leads_CITY_label']")
	WebElement city;
	
	@FindBy(xpath = "//*[@id='Crm_Leads_STATE']")
	WebElement state;

	@FindBy(xpath = "//*[@id='Crm_Leads_CODE']")
	WebElement zipCode;
	
	@FindBy(xpath = "///*[@id='Crm_Leads_COUNTRY']")
	WebElement country;

	
	//Constructor of the Class
	public CreateLeadPage() {	
		PageFactory.initElements(driver, this); // or we can write PageFactory.initElements(driver, LoginPage.class);
	}
	
	
	public void createLead() {
		firstName.sendKeys("sdff");
		lastName.sendKeys("sdg");
		title.sendKeys("sdfsd");
		email.sendKeys("sdf");
		company.sendKeys("sdfsf");
		phone.sendKeys("sdfsdf");
		fax.sendKeys("sfdfs");
	
		
	}
	
	
	
	
}
