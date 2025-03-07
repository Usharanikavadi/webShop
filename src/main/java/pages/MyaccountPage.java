package pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import commonLib.Utilities;

public class MyaccountPage {

	WebDriver driver;

	//@ Register locators
	
	@FindBy(xpath = "//*[@class='ico-register']") public WebElement register$;
	@FindBy(id = "FirstName") public WebElement firstname$;
	@FindBy(id = "LastName") public WebElement lastname$;
	@FindBy(id = "Email") public WebElement email$;
	@FindBy(xpath = "//*[@name='Password']") public WebElement password$;
	@FindBy(id = "ConfirmPassword") public WebElement confirmPassword$;
	@FindBy(xpath = "//*[@name='register-button']") public WebElement registerBtn$; 
	@FindBy(className = "account") public WebElement myaccount$;

	//@ login locators
	
	@FindBy(className = "ico-login") public WebElement login$;
	@FindBy(className = "email") public WebElement lemail$;
	@FindBy(id = "Password") public WebElement lPassword$;
	@FindBy(xpath = "//*[@class='button-1 login-button']") public WebElement lloginBtn$;
	
	//@ logout button in home page
	@FindBy(xpath = "//*[@href='/logout']") public WebElement logoutBtn$;

	//@ customer info button locator in My account
	@FindBy(xpath = "(//*[@href='/customer/info'])[2]") public WebElement customerInfo$;
	
	//@ change password locators in My account
	
	@FindBy(xpath = "//*[@href='/customer/changepassword']") 
	public WebElement changePasswordlink$;
	
	@FindBy(id = "OldPassword") public WebElement oldPassword$;
	@FindBy(id = "NewPassword") public WebElement newPassword$;
	@FindBy(id = "ConfirmNewPassword") public WebElement ConfirmNewPassword$;
	@FindBy(xpath = "//*[@class='button-1 change-password-button']") public WebElement changePasswordBtn$;

	//@ change password error messages
	
	@FindBy(xpath = "//*[@data-valmsg-for= 'NewPassword']") public WebElement newP_ErrorMsg$;
	@FindBy(xpath = "//*[@data-valmsg-for= 'ConfirmNewPassword']")
	public WebElement confirmP_Error_Msg$;
	@FindBy(xpath = "//*[@data-valmsg-for= 'OldPassword']") public WebElement oldP_Error_Msg$;
	@FindBy(xpath = "//*[@class='message-error']/div/ul/li")
	public WebElement oldP_Error_MsgMismatch$;

	//@ addresses locators
	@FindBy(xpath = "(//*[@href='/customer/addresses'])[1]")
	public WebElement addresslink$;
	
	@FindBy(xpath = "//*[@class='button-1 add-address-button']") WebElement addnewAddress$;
	
	@FindBy(id = "Address_FirstName") WebElement fname$;
	@FindBy(id = "Address_LastName") WebElement lname$;
	@FindBy(name = "Address.Email") WebElement Adrs_email$;
	@FindBy(name = "Address.CountryId") WebElement selectCountry$;
	@FindBy(id = "Address_City") WebElement city$;
	@FindBy(id = "Address_Address1") WebElement adrs1$;
	@FindBy(name = "Address.ZipPostalCode") WebElement zipcode$;
	@FindBy(id = "Address_PhoneNumber") WebElement phnum$;
	@FindBy(xpath = "//*[@class = 'button-1 save-address-button']") public WebElement saveBtn$;
	@FindBy(xpath = "//*[@class='button-2 edit-address-button']") public WebElement editBtn$;
	@FindBy(xpath = "(//*[@class='button-2 delete-address-button'])[1]") public WebElement deleteBtn$;
	
	Utilities util = new Utilities(driver);
	
	public MyaccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void register() throws Exception {
		assertTrue(register$.isDisplayed(), "Register button is not visible");
		Thread.sleep(2000);
		// lo$.click();
		register$.click();
		Thread.sleep(2000);
		firstname$.sendKeys("sku");
		lastname$.sendKeys("k");
		email$.sendKeys("sku@mail.com");
		password$.sendKeys("sku1234");
		confirmPassword$.sendKeys("sku1234");
		registerBtn$.click();
	}

	public void login(String email, String password) {
		login$.click();
		lemail$.sendKeys(email);
		lPassword$.sendKeys(password);
		lloginBtn$.click();
	}

	public void myAccount() {
		Assert.assertTrue(myaccount$.isDisplayed(), "My account button is not visible");
		myaccount$.click();
		assertTrue(customerInfo$.isDisplayed(), "CustomerInfo is not visible");
		customerInfo$.click();
	}

	public void changePassword(String oldPassword, String newPassword, String confirmPassword) throws Exception {
		changePasswordlink$.click();
//		System.out.println("successfully in change password");
		oldPassword$.sendKeys(oldPassword);
		newPassword$.sendKeys(newPassword);
		ConfirmNewPassword$.sendKeys(confirmPassword);
		Thread.sleep(2000);
		changePasswordBtn$.click();
	}

	public void add_address(String fname,String lname,String email,String country, String city,String address,String zip,String phNum) throws Exception {
		addresslink$.click();
		assertTrue(addnewAddress$.isDisplayed(),"Addnew address button is not visible");
		addnewAddress$.click();
		fname$.sendKeys(fname);
		lname$.sendKeys(lname);
		Adrs_email$.sendKeys(email);
		util.select_byText(selectCountry$, country);
		city$.sendKeys(city);
		adrs1$.sendKeys(address);
		zipcode$.sendKeys(zip);
		phnum$.sendKeys(phNum);
		Thread.sleep(2000);
		saveBtn$.click();		
	}
	
	public void dltAddress() {
		addresslink$.click();
		deleteBtn$.click();
		util.acceptAlerts();
		System.out.println("Successfully deleted..!");
	}
}
