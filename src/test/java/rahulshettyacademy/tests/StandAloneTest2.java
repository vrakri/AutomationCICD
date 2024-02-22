package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class StandAloneTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedr/chromedriver.exe");

	    //	ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");

		
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait (5,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
        LandingPage landingPage = new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("kike.vrankulj@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Krist1234");
		driver.findElement(By.cssSelector("#login")).click();
		WebDriverWait w = new WebDriverWait (driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
	    WebElement prod = products.stream().filter(product->
	    product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
	    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
	  // WebDriverWait w = new WebDriverWait (driver, Duration.ofSeconds(5)); 
	   
      // w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

       //ng-animating - class name kruga koji se kratko prikazuje dok se stranica loada; ponuđeno je bilo, teško je inspectati to, brzo nestane
       
	   Thread.sleep(500);
	   
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-animating")));
	    
	    w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
       
       w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
       
       driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
       
      List<WebElement> productList = driver.findElements(By.cssSelector(".cartSection h3"));
      Boolean match =productList.stream().anyMatch(product->product.getText().equals(productName));
      
      Assert.assertTrue(match);
      
      driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
      
      Actions a = new Actions(driver);
      
      a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
      
      w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
      
      driver.findElement(By.xpath("//body//app-root//button[2]")).click();
      
      driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
      
      String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
      
      Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
      
      driver.close();
      
      //driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
      
     // .ta-results.list-group.ng-star-inserted
      
   //   List<WebElement> countryList =  driver.findElements(By.cssSelector(".ta-results.list-group.ng-star-inserted"));
    //  
   //  ((WebElement) countryList).click();
     
   //  WebElement option = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
     
   //  String optionValue = option.getAttribute("value");
     
    // ((WebElement) countryList).sendKeys(optionValue);
     
   //  ((Object) assertThat(optionValue)).isEqualTo("India");
     
     
     
     
     
      //for (WebElement option: countryList)
     
     // {
    	//  if (option.getText().equalsIgnoreCase("India"))
     
     // {
    //	  option.click();
     // break;
      
     // }
      }

	private static Object assertThat(String optionValue) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}


