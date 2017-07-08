package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.BaseClass;
import page.HomePage;
import page.LoginPage;
import utility.CustomLogger;

public class SecondTestCase extends BaseClass {

	LoginPage login;
	HomePage home;

	@Test(dataProvider="TestData")
	public void verifyValidUser(String user,String pass) {

		logger = reports.startTest("Home Page Verification", "This test will verify the valid user login");

		home = PageFactory.initElements(driver, HomePage.class);

		login = PageFactory.initElements(driver, LoginPage.class);

		home.clickOnSignIn();

		CustomLogger.logInfo(logger, "Sign in Completed");

		home.verifyHomePageLanding();

		CustomLogger.logPass(logger, "Home Page verified");

		login.loginToApplication(user, pass);

		login.verifyLogin();

		CustomLogger.logPass(logger, "Login Verified");
		
		home.clickOnSignOut();

	}

	
	@DataProvider(name="TestData")
	public Object[][] getData() 
	{

		System.out.println("Test Data is getting ready");
		
		Object[][] arr1 = new Object[2][2];

		arr1[0][0] = "mukeshotwani.50@gmail.com";
		arr1[0][1] = "Abcd1234";

		arr1[1][0] = "mukeshotwani@gmail.com";
		arr1[1][1] = "Abcd1234";
		
		System.out.println("Test Data is ready and Test can be started now");

		return arr1;
	}

}
