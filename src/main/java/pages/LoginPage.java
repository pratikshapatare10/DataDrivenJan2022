package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Declaration 
		@FindBy (xpath="//input[@id='user-name']") private WebElement un;
		@FindBy(xpath="//input[@id='password']") private WebElement pwd;
		@FindBy(xpath="//input[@id='login-button']") private WebElement lgnBtn;
		
		//Initilization
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Usage
		public void setLoginPageUN(String uname)
		{
			un.sendKeys(uname);
		}
		
		public void setLoginPagePWD(String password)
		{
			pwd.sendKeys(password);
		}
		
		public void clickLoginPageLgnBtn()
		{
			lgnBtn.click();
		}
}
