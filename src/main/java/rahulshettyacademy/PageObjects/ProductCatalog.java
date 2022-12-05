//This class is initiated to identify the elements and actions

package rahulshettyacademy.PageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By allproducts=By.cssSelector(".mb-3");
	By addtocart=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.cssSelector("#toast-container");
	
	public List<WebElement> getElementes()
	{
		waitForElementToAppear(allproducts);
		return products;
	}
	
	public WebElement getProductByName(String productname)
	{
		WebElement pro=getElementes().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname))
				.findFirst().orElse(null);
		return pro;
      }
	
	
	public void addProductToCart(String productname)
	{
		WebElement prod=getProductByName(productname);
		prod.findElement(addtocart).click();
		waitForElementToAppear(toastmessage);
		waitForElementToDisappear(spinner);
		

	}
}

