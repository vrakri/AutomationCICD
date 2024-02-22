package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage  extends AbstractComponents {
   
	WebDriver driver;
	
     public LandingPage (WebDriver driver) 
     {
		super(driver);	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//ili možemo pisati: 
     
	@FindBy(id="userEmail")
	WebElement userEmail;
	//driver.findElement(By.id("userPassword")).sendKeys("Krist1234");
	
	@FindBy(id="userPassword")
    WebElement passwordEle;
	
	//driver.findElement(By.cssSelector("#login")).click();
	
	@FindBy(css="#login")
	WebElement login;

	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;


   public ProductCatalogPage loginAplication(String email, String password)

  {
	userEmail.sendKeys (email);
	passwordEle.sendKeys(password);
	login.click();
	ProductCatalogPage productCatalogPage = new ProductCatalogPage (driver);
	return productCatalogPage;
   }

   public String getErrorMessage()
   
   {
	   waitForWebElementToAppear(errorMessage);
	    return errorMessage.getText();
	   
   }
   
   public void goTo() 
   
   {
	   driver.get("https://rahulshettyacademy.com/client");
   }
   
}
