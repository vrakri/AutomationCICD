package rahulshettyacademy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CheckOutPage  extends AbstractComponents {
   
	WebDriver driver;
	
     public CheckOutPage (WebDriver driver) 
     {
		super(driver);	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	@FindBy (css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy (xpath="//body//app-root//button[2]")
	WebElement selectCountry;
	
	@FindBy (css=".btnn.action__submit.ng-star-inserted")
	WebElement submitButton;
	
		
	By results = By.cssSelector(".ta-results.list-group.ng-star-inserted");
	
	
	public void selectCountry(String countryName) 
	
	
	{
		  Actions a = new Actions(driver);
	      a.sendKeys(country, countryName).build().perform();
	      waitForElementToAppear(results);
	      selectCountry.click();
	      submitButton.click();

	}
	
    public ConfirmationPage submitOrder() 
	
	
	 {
	       submitButton.click();
    
           ConfirmationPage confirmationPage = new ConfirmationPage (driver);
           return confirmationPage;

	  }
}