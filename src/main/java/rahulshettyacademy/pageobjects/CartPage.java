package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage  extends AbstractComponents {
   
	WebDriver driver;
	
     public CartPage (WebDriver driver) 
     {
		super(driver);	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	@FindBy(css=".cartSection h3")
	List<WebElement> productList;
	
	@FindBy(css="li[class='totalRow'] button[type='button']")
	WebElement  checkOut;
	
	public Boolean VerifyProductDisplay (String productName)
	
	{
		Boolean match = productList.stream().anyMatch(product->product.getText().equals(productName));
        return match;
  
     }
	
	public CheckOutPage goToCheckOut() 
	
	{
		checkOut.click();
		CheckOutPage checkOutPage = new CheckOutPage (driver);
		return checkOutPage;
	}
	
	
}