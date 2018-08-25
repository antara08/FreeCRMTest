package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.util.TestUtil;

public class NewContactPageTest extends TestBase{
	
	NewContactsPage newContactPage;
	HomePage hp;
	TestUtil tu;
	LoginPage lp;
	
	public NewContactPageTest(){
		super();
		
	}
    
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		lp=new LoginPage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame("mainpanel");
		newContactPage=hp.newContactClick();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=TestUtil.getTestData("contacts");
		return data;
	}
	
	@Test(priority=1,dataProvider="getData")
	public void testCreateContact(String ttl,String frstname,String lstname,String cmpny) throws InterruptedException{
		newContactPage.createContact(ttl, frstname, lstname, cmpny);	
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
