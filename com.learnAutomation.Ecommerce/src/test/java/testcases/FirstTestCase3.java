package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.BaseClass;
import page.HomePage;
import page.LoginPage;
import utility.CustomLogger;

public class FirstTestCase3 extends BaseClass {

	LoginPage login;
	HomePage home;
	
	@Test
	public void verifyValidUser() {

		logger = reports.startTest("Home Page Verification", "This test will verify the valid user login");

		home = PageFactory.initElements(driver, HomePage.class);

		login = PageFactory.initElements(driver, LoginPage.class);

		home.clickOnSignIn();

		CustomLogger.logInfo(logger, "Sign in Completed");
	
		home.verifyHomePageLanding();

		CustomLogger.logPass(logger, "Home Page verified");

	}
	
	@Test(dependsOnMethods="verifyValidUser")
	public void verifyLogin()
	{
		
		logger = reports.startTest("Login Page Verification", "This test will verify the valid user login");
		
		login.loginToApplication("mukeshotwani123s@gmail.com", "Abcd1234");

		login.verifyLogin();

		CustomLogger.logPass(logger, "Login Verified");
	
	}

}
