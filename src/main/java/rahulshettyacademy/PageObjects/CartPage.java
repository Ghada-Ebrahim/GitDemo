//This class is initiated to identify the elements and actions

package rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*WebElement username=driver.findElement(By.id("userEmail"));
	WebElement userpassword=driver.findElement(By.id("userPassword"));
	WebElement button=driver.findElement(By.id("login"));*/
	
	//PageFactory
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutFile;
	
public Boolean verifyProductDisplay(String productname)
{
	Boolean match=cartproducts.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productname));
	return match;
}

public CheckOutPage goToCheck()
{
	checkOutFile.click();
	return new CheckOutPage(driver);
}
}
	