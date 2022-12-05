package rahulshettyacademy.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.Plugin.Engine.Dispatcher.ForParallelTransformation.WithThrowawayExecutorService;
import rahulshettyacademy.PageObjects.LandingPage;
public class BaseTest {
	public  WebDriver driver;
	public  LandingPage landingPage;

	public WebDriver intializingDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties"); 
		prop.load(file);
		String browsername=System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		//String browsername=prop.getProperty("browser");
		//headless m3naha eny mesh 3awza ashof l execution by7sel 2odami
		if (browsername.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if (browsername.contains("headless")) {
			options.addArguments("headless");
			
		}
		driver=new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1440, 900));
		}
		else if (browsername.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\13632\\Downloads\\geckodriver\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	
		return driver;
	}

	
	public String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot tScreenshot=(TakesScreenshot) driver;
		File sourceFile=tScreenshot.getScreenshotAs(OutputType.FILE);
		File fileDest=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+ ".png");
		FileUtils.copyFile(sourceFile, fileDest);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+ ".png";
	}
	
		public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
		{
			String jsonContent=FileUtils.readFileToString(new File (filepath),StandardCharsets.UTF_8);
			ObjectMapper mapper= new ObjectMapper();
			List<HashMap<String, String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
			return data;
		}
		
	
		@BeforeMethod(alwaysRun = true)
		public LandingPage launchApplication() throws IOException 
		{
			driver=intializingDriver();
			landingPage=new LandingPage(driver);
			landingPage.goTo();
			return landingPage;
		}
		
	@AfterMethod(alwaysRun = true) 
		public void closeBrowser () throws IOException
	{
            //driver.quit();
		
		}
	}

