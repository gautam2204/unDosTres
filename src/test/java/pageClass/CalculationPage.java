package pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Hooks;

import java.util.logging.Logger;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CalculationPage {


	WebDriver driver;
	Logger log = Logger.getLogger(CalculationPage.class.getName());

	public CalculationPage() {
		this.driver = Hooks.driver;

		PageFactory.initElements(this.driver, this);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, SECONDS);
	}

	private @FindBy(id = "payment-form")
	WebElement payform;

	private @FindBy(css = "input#sum1")
	WebElement inputSumVal1;

	public void enterValueinList(int num) {
		if(inputSumVal1.getText()==null)
		{
			inputSumVal1.sendKeys(String.valueOf(num));
		}

	}
}
