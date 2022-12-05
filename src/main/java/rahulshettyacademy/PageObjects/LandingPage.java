//This class is initiated to identify the elements and actions

package rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*WebElement username=driver.findElement(By.id("userEmail"));
	WebElement userpassword=driver.findElement(By.id("userPassword"));
	WebElement button=driver.findElement(By.id("login"));*/
	
	//PageFactory
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement userpassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessag;
	
public ProductCatalog loginApplication(String name,String password)
{
	username.sendKeys(name);
	userpassword.sendKeys(password);
	submit.click();
	ProductCatalog productslist=new ProductCatalog(driver);
	return productslist;
}

public String getErrorMessage()
{
	waitForWebElementToAppear(errormessag);
	return errormessag.getText();
}
public void goTo()
{
	driver.get("https://www.rahulshettyacademy.com/client");
}
}
