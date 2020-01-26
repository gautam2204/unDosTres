package pageClass;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.Hooks;
import utilities.Constants;
import utilities.GenericUtility;

public class RecargasCelularPage {
	GenericUtility gen = new GenericUtility();
	Properties prop;
	WebDriver driver;
	Logger log = Logger.getLogger(RecargasCelularPage.class.getName());
	public RecargasCelularPage() {
		this.driver = Hooks.driver;
		this.prop = Hooks.prop;		
		
		PageFactory.initElements(this.driver, this);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	

	@FindBy(xpath = "//*[@id='header_logo']/a")
	WebElement logo;
	
	@FindBy(xpath = "//input[@name='operator' and @suggest='mobile-operator']")
	WebElement operator;
	
	
	@FindBy(xpath = "//input[@name='operator' and @suggest='mobile-operator']/parent::div//ul/li")
	List<WebElement> operatorList;
	
	@FindBy(xpath = "//input[@name='mobile' and @type='tel']")
	WebElement telNum;
	
	@FindBy(xpath = "//input[@name='amount' and @suggest='mobile-operator_amount']")
	WebElement amountEdit;
	
	@FindBy(xpath = "//input[@name='amount' and @suggest='mobile-operator_amount']/parent::div//ul/li")
	List<WebElement> amountList;
	
	@FindBy(xpath = "//button[@perform='payment' and contains(text(),'Siguiente')]")
	WebElement paymentButton;
	
	
	


	public void launchUrl(String url) {
		log.info("Url to Lauch is ==>> "+url.toString()+"  >>>>>> Value is "+prop.getProperty(url));
		this.driver.navigate().to(prop.getProperty(url));
		
	}

	public void selectOperator(String property) {
		log.info("Operator Name = "+property);
		gen.clickElement(operator);
		setOperatorFromSuggestions(property);
		
	}

	private void setOperatorFromSuggestions(String operator) {
		for(int i=0;i<=operatorList.size();i++)
		{
			if(operatorList.get(i).getAttribute("data-name").equalsIgnoreCase(operator))
			{
				gen.clickElement(operatorList.get(i));
				break;
			}
		}
		
	}

	public void setPhoneNumer(String phNum) {
		log.info("Phone Number = "+phNum);
		telNum.sendKeys(phNum);
		
	}

	public void selectAmount(String amount) {
		log.info("Amount = "+amount);
		gen.clickElement(amountEdit);
		selectamountFromSuggestions(amount);
	}

	private void selectamountFromSuggestions(String amount2) {
		for(int i=0;i<=amountList.size();i++)
		{
			if(amountList.get(i).getAttribute("data-name").equalsIgnoreCase(amount2))
			{
				gen.clickElement(amountList.get(i));
				break;
			}
		}
		
	}

	public void clickPaymet() {
		gen.clickElement(paymentButton);
		
	}
}
