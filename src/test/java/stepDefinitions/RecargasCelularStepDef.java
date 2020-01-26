package stepDefinitions;

import java.util.Properties;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageClass.RecargasCelularPage;




public class RecargasCelularStepDef {
	RecargasCelularPage RechargePage =  new RecargasCelularPage();
	Properties prop = Hooks.prop;
	
	@Given("Launch Url as {string}")
	public void launch_Url_as(String url) {
		RechargePage.launchUrl(url);
	}
	
	@When("user selects {string} , {string} and {string} and click RechargeButton")
	public void user_selects_and_and_click_RechargeButton(String operator, String cellNumber, String Amount) {
		RechargePage.selectOperator(prop.getProperty(operator));
		RechargePage.setPhoneNumer(prop.getProperty(cellNumber));
		RechargePage.selectAmount(prop.getProperty(Amount));
		RechargePage.clickPaymet();
	}

}
