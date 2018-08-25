package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	TestUtil tu;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		tu=new TestUtil();
		lp=new LoginPage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void validatelogo(){
		tu.switchToFrame("mainpanel");
		boolean flag=hp.logo();
		Assert.assertTrue(flag, "expected logo not found");
	}
	@Test(priority=2)
	public void validateUser(){
		tu.switchToFrame("mainpanel");
		Assert.assertTrue(hp.user(), "user not displayed");
	}
	@Test(priority=3)
	public void userTextTest(){
		tu.switchToFrame("mainpanel");
		String name=hp.user1();
		System.out.println(name);
	}
	@Test(priority=4)
	public void newContactClickTest()
	{
		tu.switchToFrame("mainpanel");
		try{
		hp.newContactClick();}
		catch(Exception e)
		{System.err.println(e.getMessage());}
		
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
