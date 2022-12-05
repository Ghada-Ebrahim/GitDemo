package rahulshettyacademy.tests;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.lang.module.FindException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.zip.CheckedOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;
import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.CheckOutPage;
import rahulshettyacademy.PageObjects.LandingPage;
import rahulshettyacademy.PageObjects.ProductCatalog;
import rahulshettyacademy.PageObjects.confirmationPage;
import rahulshettyacademy.PageObjects.orderPage;
import rahulshettyacademy.TestComponent.BaseTest;

public class SubmitOrder extends BaseTest{
	String productname="ZARA COAT 3";

	@Test(dataProvider = "getData", groups = {"purchase"})
	public void submitOrderTest(HashMap<String, String> input) throws IOException,InterruptedException
	{
		
		String countryName="Egypt";
		//LandingPage landingPage=launchApplication();
		ProductCatalog productslist=landingPage.loginApplication(input.get("email"),input.get("password"));
		Thread.sleep(5000);

	    List<WebElement> products=productslist.getElementes();
		productslist.addProductToCart(input.get("product"));
		Thread.sleep(5000);

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		CartPage cartpage=productslist.goToCart();
		Boolean match=cartpage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage checkout=cartpage.goToCheck();
		checkout.insertingCountry(countryName);
		confirmationPage confirmationPage=checkout.actionButton();
		//Assert.assertTrue(confirmedmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		String confirmedmessage=confirmationPage.getConfirmationmessage();
		Assert.assertTrue(confirmedmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
     /* driver.findElement(By.xpath("//button[contains(text(),'Sign Out')]")).click();
		Thread.sleep(5000);*/


	}
	
	@Test(dependsOnMethods = {"submitOrderTest"})
	public void orderHistory() {
		ProductCatalog productslist=landingPage.loginApplication("ghadaebrahim875@yahoo.com","Dodo@1997");
        orderPage orderPage=productslist.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productname));
	}
	
	
	
@DataProvider
public Object[][] getData() throws IOException  {
	/*HashMap<String,String> map1=new HashMap<String,String>();
	map1.put("email", "shetty@gmail.com");
	map1.put("password", "Iamking@000");
	map1.put("product", "ADIDAS ORIGINAL");
	
	HashMap<String,String> map2=new HashMap<String,String>();
	map2.put("email", "ghadaebrahim875@yahoo.com");
	map2.put("password", "Dodo@1997");
	map2.put("product", "ZARA COAT 3");*/
	
	List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchasesOrder.json");

	return new Object[][] {{data.get(0)},{data.get(1)}};
	
}
}
