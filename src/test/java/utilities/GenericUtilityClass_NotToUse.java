package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.Hooks;

public class GenericUtilityClass_NotToUse {
	
	WebDriver driver;
	public GenericUtilityClass_NotToUse() {
		this.driver=Hooks.driver;
		
	}
	
	public void clickElement(WebElement elm)
	{
		elm.click();
	}

	public boolean elementDisplayed(WebElement elm) {
		boolean val = false;
		if(elm.isDisplayed())
		{
			val=true;
		}
		return val;
		
	}
	
	
	
	
	

}
