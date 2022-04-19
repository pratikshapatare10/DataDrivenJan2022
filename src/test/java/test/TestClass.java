package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.BaseClass;
import net.bytebuddy.utility.RandomString;
import pages.HomePage;
import pages.LoginPage;
import utility.Utility;

public class TestClass extends BaseClass {

	WebDriver driver;
	LoginPage lgn;
	HomePage home;
	
	String expectedUrl="https://www.saucedemo.com/inventory.html";
	
	@BeforeMethod
	public void openBrowser()
	{
		driver=openChromeBrowser();
		lgn=new LoginPage(driver);
		home=new HomePage(driver);
	}
	
	@Test(priority=1,dataProvider="fetchFromexcel")
	public void loginWithDP(String username, String password)
	{
		logger=reports.createTest("Login to SauceLab");
		logger.info("Starting application..");
		logger.info(username+"  "+password);
		
		lgn.setLoginPageUN(username);
		lgn.setLoginPagePWD(password);
		lgn.clickLoginPageLgnBtn();
		String currentUrl=driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, expectedUrl);
	}
	
	@DataProvider(name="fetchFromexcel")
	public Object[][] loginData() {
		Object[][] arrayObject = null;
		try {
			arrayObject = Utility.getData();
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return arrayObject;
	}
	
	@AfterMethod
	public void screenShot(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenShot(driver)).build());
		}
		else if(ITestResult.SUCCESS==result.getStatus())
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.screenShot(driver)).build());
		}
		
		reports.flush();	
	}
	
	@AfterMethod
	public void z_close()
	{
		closeBrowser(driver);
	}
	
	
}
