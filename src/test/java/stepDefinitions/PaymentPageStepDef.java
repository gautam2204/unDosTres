package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageClass.PaymentPage;
import pageClass.RecargasCelularPage;




public class PaymentPageStepDef {
	PaymentPage paymentPage =  new PaymentPage();
	Properties prop = Hooks.prop;
	
	@Then("verify user lands on Payment Screen")
	public void verify_user_lands_on_Payment_Screen() {
		paymentPage.validatePaymentPageLoaded();
	}
	
	@Then("complete the payment with {string} {string} {string} {string} {string} and {string}")
	public void complete_the_payment_with_and(String mode, String cardNum, String month, String date, String cvv, String email) {
		
		List<String> al = new ArrayList<String>();
		al.add(prop.getProperty(mode));
		al.add(prop.getProperty(cardNum));
		al.add(prop.getProperty(month));
		al.add(prop.getProperty(date));
		al.add(prop.getProperty(cvv));
		al.add(prop.getProperty(email));
		paymentPage.enterDetails(al);
		
	}
	
	@Then("verify if the recharge is success")
	public void verify_if_the_recharge_is_success() {
		paymentPage.verifyModalWindowForRegistration();
	}

}
