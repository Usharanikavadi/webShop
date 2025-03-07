package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MyaccountPage;

public class LoginSteps {

	private WebDriver driver = Hooks.getDriver();
	MyaccountPage ma_page = new MyaccountPage(driver);

	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		driver.get("https://demowebshop.tricentis.com");
	}

	@When("clicks on login link")
	public void clicks_on_login_link() {
		ma_page.login$.click();
	}

	@And("the user enters the email {string} and the password {string}")
	public void the_user_enters_credentials(String email, String password) {

		ma_page.email$.sendKeys(email);
		ma_page.password$.sendKeys(password);

	}

	@And("clicks the login button")
	public void clicks_the_login_button() throws Exception {
		ma_page.lloginBtn$.click();
	}

	@Then("the user should see logout and myaccount links")
	public void see_logout_and_myaccount_links() {
		Assert.assertTrue(ma_page.myaccount$.isDisplayed(), "User is not able to see Myaccount");
		Assert.assertTrue(ma_page.logoutBtn$.isDisplayed(), "User is not able to see logout");

		System.out.println("User is Successfully loggedin");
	}
}
