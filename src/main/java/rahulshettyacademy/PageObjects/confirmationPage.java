package rahulshettyacademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class confirmationPage extends AbstractComponent{
	
	WebDriver driver;
	public confirmationPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement confiremedMessage;
	
	public String getConfirmationmessage()
	{
		return confiremedMessage.getText();
		
	}
	
	
}
