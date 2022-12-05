package rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	
WebDriver driver;
	
	public CheckOutPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement countryName;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[1]")
	WebElement Selectegypt;
	
	@FindBy (css=".action__submit")
	WebElement actionElement;
	
	
	By items=By.cssSelector(".ta-results");



public confirmationPage insertingCountry(String country)
{
	Actions a=new Actions(driver);
	a.sendKeys(countryName, country).build().perform();
	waitForElementToAppear(items);
	Selectegypt.click();
	return new confirmationPage(driver);
	
}


public confirmationPage actionButton()
{
	actionElement.click();
	return new confirmationPage(driver);
	
}
 

}



