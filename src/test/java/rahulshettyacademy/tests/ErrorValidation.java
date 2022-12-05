package rahulshettyacademy.tests;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.ProductCatalog;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.TestComponent.Retry;

public class ErrorValidation extends BaseTest{

	@Test /*(groups = {"ErrorHandling"})*/ (retryAnalyzer = Retry.class)
	public void loginErrorMessage() throws IOException
	{
	
		//LandingPage landingPage=launchApplication();
		landingPage.loginApplication("ghadaebrahim875@yahoo.com","Dodo1997");
	    Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	@Test (retryAnalyzer = Retry.class)
	public void productErrorMessage()
	{
		String productname="ZARA COAT 3";
		//String countryName="Egypt";
		//LandingPage landingPage=launchApplication();
		ProductCatalog productslist=landingPage.loginApplication("ghadaebrahim875@yahoo.com","Dodo@1997");
	    List<WebElement> products=productslist.getElementes();
		productslist.addProductToCart(productname);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		CartPage cartpage=productslist.goToCart();
		Boolean match=cartpage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertTrue(match);
	}
	
	@Test
	public void getPrint()
	{
		System.out.println("Hello");
	}


}
