package testcases;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import dataprovider.MyStoreData;
import page.BaseClass;
import page.HomePage;
import page.LoginPage;
import utility.CustomLogger;

public class SecondTestCase4 extends BaseClass {

	LoginPage login;
	HomePage home;
	public static ArrayList<String> status=new ArrayList<String>();;

	@Test(dataProvider="TestData1",dataProviderClass=MyStoreData.class)
	
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
	
	

}
