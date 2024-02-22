package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTests {

	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initilizeDriver() throws IOException
	
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//Resources//GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
	}
		else if(browserName.equals("firefox"))
		{
			//firefox
		}
		else if(browserName.equals("edge"))
		{
			//edge
		} 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException

	{
		
		driver= initilizeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	public String getScreenshot (String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File (System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
	    FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir")+"//reports//" + testCaseName + ".png";
	    
	}  
	@AfterMethod
	
	public void closingDriver() 
	
	{
		
		driver.close();
	}

	public String getScreenshot(String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}