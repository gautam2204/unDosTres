package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.CalculationPage;
import pageClass.PaymentPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CalculationPageStepDef {
	Properties prop = Hooks.prop;
	CalculationPage calculationPage=new CalculationPage();


	@When("^enter value for (\\d)$")
	public void enter_value_for(int num) {
    System.out.println("===============   "+num);
 	calculationPage.enterValueinList(9);

	}


	@Then("Calculate the sum of numbers")
	public void calculate_the_sum_of_numbers() {

	}
	@Then("validate the {string} to be correct")
	public void validate_the_to_be_correct(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
