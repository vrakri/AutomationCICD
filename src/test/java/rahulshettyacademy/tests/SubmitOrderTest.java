package rahulshettyacademy.tests;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTests;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogPage;

public class SubmitOrderTest extends BaseTests {

	
	@Test (dataProvider="getData", groups= {"Purchase"})
	public void SubmitOrderTest(HashMap<String,String>input) throws IOException, InterruptedException
	
	{
		
	//public static void main(String[] args) throws InterruptedException {
			
		String productName = "ZARA COAT 3";
		String countryName = "India";
		//LandingPage landingPage = launchApplication();
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver= new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
       // LandingPage landingPage = new LandingPage(driver);
       // landingPage.goTo();
        ProductCatalogPage productCatalogPage = landingPage.loginAplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogPage.getProductList();
		productCatalogPage.AddProductToCart(input.get("product"));
		 		
	   Thread.sleep(500);
	   CartPage cartPage = productCatalogPage.goToCartPage();
	   Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
       Assert.assertTrue(match);
       CheckOutPage checkOutPage = cartPage.goToCheckOut();
      
	   checkOutPage.selectCountry(countryName);
	   ConfirmationPage confirmationPage = checkOutPage.submitOrder();
       String confirmMessage = confirmationPage.getconfirmationMessage();
       AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
      // driver.close();
      

      }

	//@Test (dependsOnMethods= {"submitOrder"})
	
	//public void OrderHistoryTest()
	
	//"ZARA COAT 3";
	
	//ProductCatalogPage productCatalogPage = landingPage.loginAplication("kike.vrankulj@gmail.com", "Krist1234");
	//OrderPage ordersPage= productCatalogPage.goToOrdersPage();
	//Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
		
	
	@DataProvider
	
	public Object[][] getData()
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("email", "kike.vrankulj@gmail.com");
		map.put("password", "Krist1234m");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String,String> map1=new HashMap<String,String>();
	    map1.put("email", "shetty@gmail.com");
		map1.put("password", "Iamking@000");
		map1.put("product", "ADIDAS ORIGINAL");
		
		return new Object [][] {{"map"},{"map1"}};
    }
	
	
//@DataProvider() --prva opcija dataProvider, ovo poviše je pojednostavljeni način
	
	//public Object[][] getData()
	
	//return new Object [][] {{"kike.vrankulj@gmail.com","Krist1234", ""},{"shetty@gmail.com","Iamking@000", "ADIDAS ORIGINAL"}};
}
	//}
  


