package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;

public class AbstractComponents {

	WebDriver driver;
	
	
	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	public CartPage goToCartPage ()
	
	{
		 cartButton.click();
		 CartPage cartPage = new CartPage (driver);
		 return cartPage;
		
	}
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait w = new WebDriverWait (driver, Duration.ofSeconds(5));
	     w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait w = new WebDriverWait (driver, Duration.ofSeconds(5));
	     w.until(ExpectedConditions.visibilityOf(findBy));
	}
	public void waitForElementToDisappear(WebElement element)
	{
		
        WebDriverWait w = new WebDriverWait (driver, Duration.ofSeconds(5));
	     w.until(ExpectedConditions.invisibilityOf(element));
	}
}
