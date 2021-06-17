package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import stepDefinitions.Hooks;

import java.util.Set;

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
	
	public String getSingleWindowHandle()
	{
		return driver.getWindowHandle();
	}

  public Set<String> getMulWindowHandle() {
    return driver.getWindowHandles();
}

public void findFrames()
{
	driver.findElements(By.tagName("Some Name"));
	driver.switchTo().defaultContent();
}

public void rightClick(WebElement webElement)
{
	Actions actions = new Actions(driver);
	actions.contextClick(webElement);
}
}
