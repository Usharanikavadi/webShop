package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLib.Utilities;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//*[@href='/books'])[1]") public WebElement bookslink$;
	@FindBy(xpath = "(//*[@href='/computers'])[1]") public WebElement computerslink$;
	@FindBy(xpath = "(//*[@href='/electronics'])[1]") public  WebElement electronicslink$;
	@FindBy(xpath = "(//*[@href='/apparel-shoes'])[1]") public  WebElement shoeslink$;
	@FindBy(xpath = "(//*[@href='/digital-downloads'])[1]") public  WebElement digitalslink$;
	@FindBy(xpath = "(//*[@href='/jewelry'])[1]") public WebElement jewelrylink$;
	@FindBy(xpath = "(//*[@href='/gift-cards'])[1]") public WebElement giftcardslink$;
	
	@FindBy(xpath = "(//* [@class='cart-label'])[1]") public WebElement shoppingCartlink$;
	@FindBy(xpath = "(//* [@class='cart-label'])[2]") public WebElement wishlistlink$;
	
	@FindBy(xpath = "//*[@class='button-1 search-box-button']") public WebElement searchBtn$;
	@FindBy(id = "small-searchterms") public WebElement searchTxt$;
	
	@FindBy(xpath = "//*[@class='button-2 product-box-add-to-cart-button']") public List<WebElement> bookslist$;
	
	Utilities util = new Utilities(driver);
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}
	
	public void books() {
		bookslink$.click();
//		util.elementList(bookslist$);
	}
	
	public void computers() {
		computerslink$.click();
	}

	public void electronics() {
		electronicslink$.click();
	}
	
	public void shoes() {
		shoeslink$.click();
	}
	public void digitals() {
		digitalslink$.click();
	}
	
	public void jewelry() {
		jewelrylink$.click();
	}
	
	public void giftcards() {
		giftcardslink$.click();
	}
	
	public void shoppingCart() {
		shoppingCartlink$.click();
	}
	
	public void wishlist() {
		wishlistlink$.click();
	}
	
	public void search() {
		searchBtn$.click();
//		util.acceptAlerts();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
}
