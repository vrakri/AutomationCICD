package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ConfirmationPage  extends AbstractComponents {
   
	WebDriver driver;
	
     public ConfirmationPage (WebDriver driver) 
     {
		super(driver);	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
     @FindBy (css=".hero-primary")
 	 WebElement Message; 
	
     public String getconfirmationMessage() 
 	
 	
 	{ 	  
       return Message.getText(); // assert ne može ovdje, mora u testu
              
 	}
	
}