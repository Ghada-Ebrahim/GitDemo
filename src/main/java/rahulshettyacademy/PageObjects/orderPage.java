package rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class orderPage extends AbstractComponent {
	WebDriver driver;

	public orderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ordersProducts;
	
	public Boolean verifyOrderDisplay(String productname)
	{
		Boolean match=ordersProducts.stream().anyMatch(ordersProduct -> ordersProduct.getText().equalsIgnoreCase(productname));
		return match;
}
}
