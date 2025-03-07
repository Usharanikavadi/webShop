package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageNavigationSteps {

	private WebDriver driver = Hooks.getDriver();
	HomePage hm_page = new HomePage(driver);
	
	@Given("user is on homepage")
	public void home_page() {
		driver.get("https://demowebshop.tricentis.com");
	}

	@When("clicks and verifying all the visible links in homepage")
	public void clicks_and_verifying_all_the_visible_links_in_homepage() {
		driver.get("https://demowebshop.tricentis.com/");		
		hm_page.bookslink$.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/books",
				"user is not able to see books");
		hm_page.computerslink$.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/computers",
				"user is not able to see computers");
		hm_page.electronicslink$.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/electronics",
				"user is not able to see electronics");
		hm_page.shoeslink$.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/apparel-shoes",
				"user is not able to see apperal-shoes");
		hm_page.digitalslink$.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/digital-downloads",
				"user is not able to see digital-downloads");
		hm_page.jewelrylink$.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/jewelry",
				"user is not able to see jewelry");
		hm_page.giftcardslink$.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/gift-cards",
				"user is not able to see gift cards");
		hm_page.shoppingCartlink$.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/cart",
				"user is not able to see cart");
		hm_page.wishlistlink$.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/wishlist",
				"user is not able to see wishlist");

	}

	@And("clicks on search button")
	public void clicks_on_search_button() {
		Assert.assertTrue(hm_page.searchBtn$.isDisplayed(),"Search button is not visible");
		hm_page.searchBtn$.click();
	}

	@Then("accepts the pop-up")
	public void accepts_the_pop_up() {
		Alert alert = driver.switchTo().alert();
        alert.accept(); 
	}

	@And("enters search text")
	public void enters_search_text() {
		hm_page.searchTxt$.sendKeys("computers");
		hm_page.searchBtn$.click();
	}
	
}
