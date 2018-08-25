package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory - OR:
		@FindBy(xpath="//td[contains(text(),'antara ray')]")
		WebElement username;
	    
		@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
		WebElement logo;
		
		@FindBy(xpath="//a[contains(text(),'Contacts')]")
	    WebElement contactsLink;
		
		@FindBy(xpath="//ul//li//ul//li//a[text()='New Contact']")
		WebElement newContact;
		
  //Initialize page objects
		public HomePage()
		{
			PageFactory.initElements(driver, this);
		}
  //Actions
  //Click on new contact submenu
		public NewContactsPage newContactClick() throws InterruptedException{
			Actions action=new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			Thread.sleep(3000);
			newContact.click();
			return new NewContactsPage();
		}
		
  //Validate logo is displayed
		public boolean logo(){
			return logo.isDisplayed();
		}
  //validate logo text
		public String logo1(){
			return logo.getText();
		}
		
  //validate username is displayed
		public boolean user(){
			return username.isDisplayed();
		}
		
  //validate username
		public String user1(){
			return username.getText();
		}
  //Contacts page
		public ContactsPage contactClick(){
			contactsLink.click();
			return new ContactsPage();
		}
}
