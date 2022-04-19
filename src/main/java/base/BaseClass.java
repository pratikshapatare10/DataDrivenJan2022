package base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.Utility;

public class BaseClass {
	
	public PropertyFile_Reader pro=new PropertyFile_Reader();
	public ExtentReports reports;
	public ExtentHtmlReporter extent;
	public ExtentTest logger;
	public WebDriver driver;
	
	@BeforeClass
	public void setupSuite()
	{
		extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/SauceLab_"+Utility.getCurrentDateTime()+".html"));
		reports=new ExtentReports();
		reports.attachReporter(extent);
	}

	public WebDriver openChromeBrowser()
	{
		System.setProperty(pro.getChromeKey(),pro.getChromePath());
		WebDriver driver=new ChromeDriver();	
		driver.get(pro.getUrl());
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public WebDriver openFirefoxBrowser()
	{
		System.setProperty(pro.getFirefoxKey(), pro.getFirefoxPath());
		WebDriver driver=new FirefoxDriver();
		driver.get(pro.getUrl());
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public void closeBrowser(WebDriver driver)
	{
		driver.close();
	}
	
	
	
}
