package rahulshettyacademy.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.orderPage;

public class AbstractComponent {
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	@FindBy(css="[routerlink*='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='/dashboard/myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy) {
		
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	public void waitForElementToDisappear(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	public CartPage goToCart(){
		cartHeader.click();
		CartPage cartpage=new CartPage(driver);
        return cartpage;
	}
	
	public orderPage goToOrdersPage(){
		orderHeader.click();
		orderPage orderPage=new orderPage(driver);
        return orderPage;
	}
}