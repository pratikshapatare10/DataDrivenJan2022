package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.BaseClass;
import net.bytebuddy.utility.RandomString;
import pages.HomePage;
import pages.LoginPage;
import utility.Utility;

public class HomePAgeTest extends BaseClass {
 
	WebDriver driver;
	LoginPage lgn;
	HomePage home;
	
	@BeforeMethod
	public void openBrowser()
	{
		driver=openChromeBrowser();
		lgn=new LoginPage(driver);
		home=new HomePage(driver);
	}
	
	@Test(priority=0)
	@Parameters({"username","password"})
	public void login(String username, String password)
	{
		System.out.println(username+" "+password);
		lgn.setLoginPageUN(username);
		lgn.setLoginPagePWD(password);
		lgn.clickLoginPageLgnBtn();
	}
	
	@Test(priority=1)
	public void verifyLogo()
	{
		Assert.assertTrue(home.verifyLogo());
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
	public void x_close()
	{
		closeBrowser(driver);
	}
}
