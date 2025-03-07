package commonLib;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	static WebDriver driver;

	public Utilities(WebDriver driver) {
		this.driver = driver;
	}

	Select select;

	public void select_byText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void select_byValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public void select_byOption(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public static String take_screenshot(String file_name) throws Exception {
		TakesScreenshot capture = (TakesScreenshot) driver;
		File temp_path = capture.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(temp_path, new File(file_name));
		return file_name;
	}

	public void acceptAlerts() {
		new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void elementList(List<WebElement> eleList$) {
		for (WebElement element : eleList$) {

			if (element.isDisplayed())
				element.click();
		}
	}
	
	public static HashMap<String, String> get_browserDetails() {
		Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
		HashMap<String, String> browserDetails = new HashMap<String, String>();
		browserDetails.put("browserName", cap.getBrowserName());
		browserDetails.put("browserVersion", cap.getBrowserVersion());
		return browserDetails;
	}
}
