package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods{
	
//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//		initialize();
//	}
//	
//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	}
	
	@Test(groups="smoke")
	public void validAdminLogin() {
		//LoginPageElements login = new LoginPageElements();
		sendKeys(login.username, ConfigsReader.getProperty("username"));
		sendKeys(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		//DashboardPageElements dashboard = new DashboardPageElements();
		String expectedUser="Welcome Admin";
		String actualUser=dashboard.welcome.getText();
		Assert.assertEquals(actualUser, expectedUser, "Admin is NOT Logged in");
		//Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
	}
	
	@Test(groups="regression")
	public void invalidPasswordLogin() {
		//LoginPageElements login = new LoginPageElements();
		sendKeys(login.username, ConfigsReader.getProperty("username"));
		sendKeys(login.password, "uiuguig");
		click(login.loginBtn);
		
		String expected="Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}

	@Test(enabled=true, groups="regression")
	public void emptyUsernameLogin() {
		//LoginPageElements login = new LoginPageElements();
		sendKeys(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		String expected="Username cannot be empty";
		
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}
	

}
