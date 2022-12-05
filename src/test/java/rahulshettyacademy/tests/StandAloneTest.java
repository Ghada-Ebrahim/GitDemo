package rahulshettyacademy.tests;
import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;
import rahulshettyacademy.PageObjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productname="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("ghadaebrahim875@yahoo.com");
		driver.findElement(By.id("userPassword")).sendKeys("Dodo@1997");
		driver.findElement(By.id("login")).click();
		LandingPage landingPage =new LandingPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
WebElement pro=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
pro.findElement(By.cssSelector(".card-body button:last-of-type")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
driver.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();
Thread.sleep(3000);
List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
Boolean match=cartproducts.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productname));
Assert.assertTrue(match);
driver.findElement(By.cssSelector(".totalRow button")).click();
Actions a=new Actions(driver);
a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "Egypt").build().perform();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[1]")).click();
driver.findElement(By.cssSelector(".action__submit")).click();
String confirmedmessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
//Assert.assertTrue(confirmedmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
Assert.assertEquals(confirmedmessage, "THANKYOU FOR THE ORDER.");
		
	

	}

}
