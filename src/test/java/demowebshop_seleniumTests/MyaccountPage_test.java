package demowebshop_seleniumTests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonLib.ExtentListener;
import commonLib.Get_excelData;


public class MyaccountPage_test extends BaseTest {

	@DataProvider(name = "get_excelData")
	public Object[][] read_excelData(Method method) throws Exception {
		return new Get_excelData().get_excelData("src/test/resources/TestData/demoWebShop_testdata.xlsx", method.getName());
	}

	@Test(dataProvider = "get_excelData", priority = 1)
	public void myAccount_ChPas_test(String title,String oldPassword, String newPassword, String confirmPassword) throws Exception {	
		ma_page.login(gp.getProperty("email"), gp.getProperty("password"));
		ExtentListener.eTest().info("User successfully logged in to demoWebShop");
		
		ma_page.myAccount();
		ExtentListener.eTest().info("User is inside the Myaccount");
		// verifying the mandatory fields in My account page
		Assert.assertEquals(ma_page.firstname$.getAttribute("value"), "sku", "User firstname isnot correct");
		Assert.assertEquals(ma_page.lastname$.getAttribute("value"), "k", "Userlastname is incorrect");
		Assert.assertEquals(ma_page.email$.getAttribute("value"), "sku@mail.com", "User email is incorrect");
		
		ma_page.changePassword(oldPassword, newPassword, confirmPassword);
		ExtentListener.eTest().info("Verifying change password functionalitiy");
		
		if(title.contains("New and confirm passwords mismatch")) {
			System.out.println(title+":");
			assertTrue(ma_page.newP_ErrorMsg$.isDisplayed(),"New password error message not visible");  
			System.out.println("==>"+ma_page.newP_ErrorMsg$.getText());
			assertTrue(ma_page.confirmP_Error_Msg$.isDisplayed(),"Confirm password error message  is not visible");
			System.out.println("==>"+ma_page.confirmP_Error_Msg$.getText());
		}
		else if(title.contains("blank values")) {
			System.out.println(title+":");
			assertTrue(ma_page.oldP_Error_Msg$.isDisplayed(),"Old password error message is not visible");
			System.out.println("==>"+ma_page.oldP_Error_Msg$.getText());
			assertTrue(ma_page.newP_ErrorMsg$.isDisplayed(),"New password error message not visible");  
			System.out.println("==>"+ma_page.newP_ErrorMsg$.getText());
			assertTrue(ma_page.confirmP_Error_Msg$.isDisplayed(),"Confirm password error message  is not visible");
			System.out.println("==>"+ma_page.confirmP_Error_Msg$.getText());
		}
		else if(title.contains("old password mismatch")) {
			System.out.println(title+":");
			assertTrue(ma_page.oldP_Error_MsgMismatch$.isDisplayed(),"Old password mismatch error message is not visible");
			System.out.println("==>"+ma_page.oldP_Error_MsgMismatch$.getText());
		}
		else if(title.contains("confirm password mismatch")) {
			System.out.println(title+":");
			assertTrue(ma_page.confirmP_Error_Msg$.isDisplayed(),"Confirm password error message  is not visible");
			System.out.println("==>"+ma_page.confirmP_Error_Msg$.getText());
		}		
	}
	@Test(dataProvider = "get_excelData", priority = 2)
	public void add_dlt_address(String fname,String lname,String email,String country, String city,String address,String zip,String phNum) throws Exception {
		ma_page.login(gp.getProperty("email"), gp.getProperty("password"));
		ExtentListener.eTest().info("User successfully logged in to demoWebShop");
		ma_page.myAccount();
		ExtentListener.eTest().info("User is inside the Myaccount");
		ma_page.add_address(fname,lname, email, country,  city, address, zip, phNum);
		ExtentListener.eTest().info("User is inside the Address tab");
		System.out.println("Successfully added new address..!");
		assertTrue(ma_page.editBtn$.isDisplayed(),"Edit button is not visible");
		assertTrue(ma_page.deleteBtn$.isDisplayed(),"Delete button is not visible");
		ExtentListener.eTest().info("User is inside the Myaccount");
		ma_page.dltAddress();
	}
}
