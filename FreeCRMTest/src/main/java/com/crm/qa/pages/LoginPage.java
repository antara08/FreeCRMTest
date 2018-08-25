package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;
    
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
    WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement img;
	
	//initializing page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	//validation of title of the page
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	//validation of logo of the page
	
	public boolean validateLogo(){
		return img.isDisplayed();
	}
	// Test that login works
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage(); 
	}
}
