package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Logger;

public class Hooks {
	Logger log = Logger.getLogger(Hooks.class.getName());
	public static WebDriver driver;
	public static String browserType;
	public static Properties prop = new Properties();

	@Before
	public void setup() throws Exception {
		getPropertiesFile();
		Hooks.browserType = prop.getProperty("BrowserName");
		log.info("browserType" + browserType);
		setWebdriver(Hooks.browserType);

	}

	private void getPropertiesFile() throws IOException {
		InputStream fl = new FileInputStream("src/test/resources/TestData.properties");
		prop.load(fl);

	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {

			embedScreenshot(scenario);
			closeDriver();
		} else {

			embedScreenshot(scenario);
			closeDriver();
		}

	}

	private void embedScreenshot(Scenario scenario) {
		String scenarioName = scenario.getName();
		DateFormat dat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
	//	scenario.write("SCENARIO_NAME = " + scenarioName + " Date & Time = " + dat.format(date));
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		// embed it in the report.
	//	scenario.embed(screenshot, "image/png");

	}

	private void closeDriver() {
		driver.quit();
		System.out.println("Driver closed");

	}

//	private void setwebdriver() {
//		System.out.println("Driver Initiating");
//		setWebdriver(null);
//		
//	}

	private void setWebdriver(String browserType) {

		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			 driver = new FirefoxDriver();       
			
		}

	}
}
