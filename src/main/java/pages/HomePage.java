package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy (xpath="//div[@class='app_logo']") private WebElement logo;
	@FindBy (xpath="//div[@class='bm-burger-button']") private WebElement menubutton;
	@FindBy (xpath="//a[text()='Logout']") private WebElement logout;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogo()
	{
		boolean result=logo.isDisplayed();
		return result;
	}
	
	public void clickMenuButton()
	{
		menubutton.click();
	}
	
	public void clickLogout()
	{
		logout.click();
	}
}
