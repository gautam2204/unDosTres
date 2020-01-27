package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import stepDefinitions.Hooks;

public interface GenericUtilitiesInterface {
	
	WebDriver driver = Hooks.driver;
	
	public static void clickElement(WebElement elm)
	{
		elm.click();
		
	}
	
	public static boolean elementDisplayed(WebElement elm) {
		boolean val = false;
		if(elm.isDisplayed())
		{
			val=true;
		}
		return val;
		
	}

}
