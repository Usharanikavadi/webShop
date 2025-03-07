package demowebshop_seleniumTests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import commonLib.Base;
import commonLib.Get_Properties;
import commonLib.Utilities;
import pages.HomePage;
import pages.MyaccountPage;

public class BaseTest implements ITestListener {

	// Declarations
	WebDriver driver;
	Base base;
	MyaccountPage ma_page;
	HomePage hm_page;
	Utilities util;
	Get_Properties gp;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setup(@Optional("chrome") String browser) throws Exception {
		driver = new Base(browser).getDriver();
		ma_page = new MyaccountPage(driver);
		hm_page = new HomePage(driver);
		util = new Utilities(driver);
		
		gp = new Get_Properties("src/test/resources/Properties/config.properties");		
		driver.get(gp.getProperty("URL"));
	}

	@AfterMethod
	public void tear_down() throws Exception {
		if (driver != null) {
			Thread.sleep(3000);
			driver.quit();
		}
	}
}
