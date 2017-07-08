package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.BaseClassHybrid;
import page.ProductSelection;
import utility.CustomLogger;

public class ThirdTestCase extends BaseClassHybrid {

	ProductSelection product;
	
	@Parameters("Browser")
	@Test
	public void selectProduct(String browser) throws InterruptedException {

		logger = reports.startTest("Select Product Scenario",
				"This test will verify whether user is able to select product from Portal");
		
		product=PageFactory.initElements(driver, ProductSelection.class);
		
		product.pickTShirtsNew(browser);
		
		CustomLogger.logInfo(logger, "Product is Selected from Portal");
		

	}

}
