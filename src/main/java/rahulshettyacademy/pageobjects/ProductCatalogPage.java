package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ProductCatalogPage extends AbstractComponents {
   
	WebDriver driver;
	
     public ProductCatalogPage (WebDriver driver) 
     {
    	super(driver);		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
    // List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	 
    @FindBy(css=".mb-3")
    List<WebElement> products;
    
    @FindBy(css=".ng-animating")
    WebElement spinner;
    
    By products1 = By.cssSelector(".mb-3");
    By addToCard = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector(".ng-animating");
   
    public List<WebElement> getProductList() 
    
     {     
    	waitForElementToAppear(products1);
    	return products;
     }

    public WebElement getProductByName(String productName)
    {
    	 WebElement prod = getProductList().stream().filter(product->
 	    product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
    	 return prod;
    }
    
    public void AddProductToCart(String productName)
    {
    	WebElement prod = getProductByName(productName);
    	prod.findElement(addToCard).click();
       	waitForElementToAppear(toastMessage);
    	waitForElementToDisappear(spinner);
}
}