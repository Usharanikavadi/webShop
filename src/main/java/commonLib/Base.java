package commonLib;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {

	WebDriver driver;

	public Base(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.driver.edgedriver", "");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void sleep() throws Exception {
		Thread.sleep(3000);
	}
}
