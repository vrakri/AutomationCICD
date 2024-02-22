package rahulshettyacademy.tests;

import java.io.IOException;
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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTests;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogPage;

public class ErrorValidation extends BaseTests {

	
	@Test
	public void LogInErrorValidation() throws IOException, InterruptedException
	
	{
		
				
		String productName = "ZARA COAT 3";
		String countryName = "India";
		landingPage.loginAplication("kike11.vrankulj@gmail.com", "Krist1234");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
    }
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
		
	String productName = "ZARA COAT 3";
	ProductCatalogPage productCatalogPage = landingPage.loginAplication("kike.vrankulj@gmail.com", "Krist1234");
	//ProductCatalogPage productCatalogPage1 = new ProductCatalogPage (driver);
	List<WebElement> products = productCatalogPage.getProductList();
	productCatalogPage.AddProductToCart(productName);
			
   Thread.sleep(500);
   CartPage cartPage = productCatalogPage.goToCartPage();
   Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
   Assert.assertFalse(match);
	}
	}


