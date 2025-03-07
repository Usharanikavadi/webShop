package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private static WebDriver driver;

    // Hook to set up WebDriver before each scenario
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); 
    }

    
    @After
    public void tearDown() {
            driver.quit();         
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
