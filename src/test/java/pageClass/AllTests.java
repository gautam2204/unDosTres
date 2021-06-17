package pageClass;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class AllTests {
    WebDriver driver;
    @Before
            public void initDriver()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }
    @After
    public  void close()
    {
        driver.quit();
    }

    @Test
    public void clickCheckBox()
    {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.findElement(By.cssSelector("input#isAgeSelected")).click();
        List<WebElement> chkBoxes = driver.findElements(By.xpath("//div[@class='checkbox']//input[starts-with(@class,'cb')]"));

        chkBoxes.forEach(WebElement::click);

    Assert.assertEquals("Check ALl",driver.findElement(By.id("check1")).getAttribute("value"));
    }

    @Test
    public void hadlingSelect()
    {
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        WebElement elm = driver.findElement(By.id("select-demo"));
        Select select = new Select(elm);
        select.selectByValue("Sunday");

        WebElement mutiselect = driver.findElement(By.id("multi-select"));

        Select el = new Select(mutiselect);
        assert el.isMultiple();

        el.selectByValue("New York");
        el.selectByValue("Texas");
        el.selectByValue("Ohio");

    }

    @Test
    public void handlingAJAXcall()
    {
       driver.get( "https://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
       driver.findElement(By.cssSelector("input#title")).sendKeys("input#title");
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
    javascriptExecutor.executeScript("ajaxSubmit();");

        FluentWait<WebDriver> fluentWait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Eelment is not present")
                .ignoring(NoSuchElementException.class);

        WebElement elm = fluentWait.until(e -> e.findElement(By.id("submit-control")));

        Wait<WebDriver> webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(elm));

    System.out.println("Text ================== "+elm.getText());
    }

    @Test
    public void handleBootstrapDatePicker()
    {
        driver.get( "https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
        driver.findElement(By.cssSelector("input.form-control")).click();

        System.out.println("Text ================== ");
    }

    @Test
    public void handlePagination()
    {
        driver.get("file:///C:/Users/gauta/Desktop/Pagination.html");
    System.out.println("Check = "+driver.getTitle());

    

    //name - Zorita Serrano
        //age - 56


    }



}
