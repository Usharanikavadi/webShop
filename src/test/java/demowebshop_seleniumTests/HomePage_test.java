package demowebshop_seleniumTests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonLib.ExtentListener;


public class HomePage_test extends BaseTest {

	@Test
	public void test_homePagelinks() throws Exception {
		hm_page.books();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/books",
				"user is not able to see books");
		ExtentListener.eTest().info("User successfully navigated to books");
		
		hm_page.computers();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/computers",
				"user is not able to see computers");
		ExtentListener.eTest().info("User successfully navigated to computers");
		
		hm_page.electronics();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/electronics",
				"user is not able to see electronics");
		ExtentListener.eTest().info("User successfully navigated to electronics");
		
		hm_page.shoes();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/apparel-shoes",
				"user is not able to see apperal-shoes");
		ExtentListener.eTest().info("User successfully navigated to apperal-shoes");
		
		hm_page.digitals();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/digital-downloads",
				"user is not able to see digital-downloads");
		ExtentListener.eTest().info("User successfully navigated to digital-downloads");
		
		hm_page.jewelry();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/jewelry",
				"user is not able to see jewelry");
		ExtentListener.eTest().info("User successfully navigated to jewelry");
		
		hm_page.giftcards();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/gift-cards",
				"user is not able to see gift cards");
		ExtentListener.eTest().info("User successfully navigated to gift cards");
		
		hm_page.shoppingCart();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/cart",
				"user is not able to see cart");
		ExtentListener.eTest().info("User successfully navigated to shoppingCart");
		
		hm_page.wishlist();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/wishlist",
				"user is not able to see wishlist");
		ExtentListener.eTest().info("User successfully navigated to wishlist");
		
		assertTrue(hm_page.searchBtn$.isDisplayed(), "Search button is not visible");
		hm_page.search();
		ExtentListener.eTest().info("User is able to search");
	}

}
