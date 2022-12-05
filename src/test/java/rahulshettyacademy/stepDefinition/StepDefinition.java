package rahulshettyacademy.stepDefinition;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.CheckOutPage;
import rahulshettyacademy.PageObjects.LandingPage;
import rahulshettyacademy.PageObjects.ProductCatalog;
import rahulshettyacademy.PageObjects.confirmationPage;
import rahulshettyacademy.TestComponent.BaseTest;

public class StepDefinition  extends BaseTest{
public LandingPage landingPage;
public ProductCatalog productslist;
public confirmationPage confirmationPage;
	@Given("I landed on E-Commerce page")
	public void I_landed_on_ECommerce_page() throws IOException
	{
		landingPage=launchApplication();
		
	}
	//7tet ^/$ 3lshan feha regular expressions 
	
	@Given("^Logged in with username(.+) and password (.+)$")
	public void Logged_in_with_username_and_password (String username, String password)
	{
		productslist=landingPage.loginApplication(username,password);
	}
	
	 @When("^I add the product (.+) to Cart$")
	 public void  I_add_the_product_to_Cart(String productName) throws InterruptedException
	 {

		    List<WebElement> products=productslist.getElementes();
			productslist.addProductToCart(productName);
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	 }
	 
	 @And("^Checkout this (.+) and submit the order$")
	 public void Checkout_productName_And_submit_the_order(String productName) 
	 {

			CartPage cartpage=productslist.goToCart();
			Boolean match=cartpage.verifyProductDisplay(productName);
			Assert.assertTrue(match);
			CheckOutPage checkout=cartpage.goToCheck();
			checkout.insertingCountry("Egypt");
			confirmationPage=checkout.actionButton();
	 }
	 @Then("{string} message is displayed on confirmation page")
	 public void Confirmation_Message_is_displayed_on_confirmation_page(String string)
	 {
	 String confirmedmessage=confirmationPage.getConfirmationmessage();
		Assert.assertTrue(confirmedmessage.equalsIgnoreCase(string));
		driver.close();
}
	 
	 @Then("{string} message is displayed")
	 public void ErrorValidation_Message_Is_Displayed(String string)
	 {
		 Assert.assertEquals(string, landingPage.getErrorMessage());
		 driver.close();
}
}
