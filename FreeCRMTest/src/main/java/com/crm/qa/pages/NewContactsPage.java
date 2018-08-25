package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewContactsPage extends TestBase{
    //title	firstname	lastname	company 
	//Xpath=//tagname[@attribute='value']
	//Page Factory -OR:
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="surname")
	WebElement surname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
    WebElement contactsLink;
	
	@FindBy(xpath="//ul//li//ul//li//a[text()='New Contact']")
	WebElement newContact;
	
	
	
	//initializing OR
	
	public NewContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void createContact(String ttl,String frstname,String lstname,String cmpny){
		Select select=new Select(title);
		select.selectByVisibleText(ttl);
		firstname.sendKeys(frstname);
		surname.sendKeys(lstname);
		company.sendKeys(cmpny);
		
		saveBtn.click();
	}
	
}

