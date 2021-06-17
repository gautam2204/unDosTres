package pageClass;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.Hooks;
import utilities.Constants;
import utilities.GenericUtilitiesInterface;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PaymentPage {
	
	Constants con = new Constants();
	Properties prop;
	WebDriver driver;
	Logger log = Logger.getLogger(PaymentPage.class.getName());

	public PaymentPage() {
		this.driver = Hooks.driver;
		this.prop = Hooks.prop;

		PageFactory.initElements(this.driver, this);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, SECONDS);
	}

	@FindBy(id = "payment-form")
	WebElement payform;
	
	@FindBy(css = "#payform > div>a")
	List<WebElement> paymentOptions;
	
	@FindBy(xpath = "//*[@class='card-info-box']//input[@name='cardname']")
	WebElement cardname;
	
	@FindBy(xpath = "//*[@class='card-info-box']//input[@name='cardno']")
	WebElement cardno;
	
	@FindBy(xpath = "//*[@class='card-info-box']//input[@name='expmonth']")
	WebElement expMon;
	
	@FindBy(xpath = "//*[@class='card-info-box']//input[@name='expyear']")
	WebElement expyear;
	
	@FindBy(xpath = "//*[@class='card-info-box']//input[@name='cvvno']")
	WebElement cvv;
	
	@FindBy(xpath = "//*[@id='email_block']//input[@name='txtEmail']")
	WebElement email;
	
	@FindBy(xpath = "//button[@id='paylimit']")
	WebElement payment;
	
	@FindBy(xpath = "//*[@class='modal-dialog']/div[@class='modal-content']//div[@class='modal-body']/table//div[@class='facebookButton point']")
	WebElement fbLoginButton;
	
	public void validatePaymentPageLoaded() {/*
WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
	webDriverWait.until(ExpectedConditions.visibilityOf(payform));*/
		//		Assert.assertTrue(payform.isDisplayed());
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("foo"));
			}
		});





	}

	public void enterDetails(List<String> al) {
		System.out.println(al);
		selectPaymetMode(al);
		cardname.sendKeys("Test");
		cardno.sendKeys(al.get(1));
		expMon.sendKeys(al.get(2));
		expyear.sendKeys(al.get(3));
		cvv.sendKeys(al.get(4));
		email.sendKeys(al.get(5));
		GenericUtilitiesInterface.clickElement(payment);		
	}
	
	

	private void selectPaymetMode(List<String> al) {
		for(WebElement elm : paymentOptions)
		{
			String text = elm.getText();
			System.out.println(text);
			if(text.equalsIgnoreCase(al.get(0)))
			{
				elm.click();
				break;
			}
			
		}
		
	}

	public void verifyModalWindowForRegistration() {
		
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(fbLoginButton));
		Assert.assertTrue(GenericUtilitiesInterface.elementDisplayed(fbLoginButton));
			
	}

}
