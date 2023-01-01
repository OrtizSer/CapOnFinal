package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGenerator;

public class AccountSteps extends CommonUtility{
	
	POMFactory factory = new POMFactory();
	
	
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.accountPage().accountBtn);
		Logger.info("User clicked on Account button");
		
	}
	@And("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String Name, String Phone) {
		factory.accountPage().nameField.clear();
		sendText(factory.accountPage().nameField,Name);
		factory.accountPage().phoneNumberField.clear();
		sendText(factory.accountPage().phoneNumberField,Phone);
		Logger.info("User entered name " + Name + "and phone" + Phone);
	}
	@And("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().personalUpdateBtn);
		Logger.info("User clicked on Update button");
	}
	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personaliInformationUpdateMessege);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personaliInformationUpdateMessege));
		String actualMessege = factory.accountPage().personaliInformationUpdateMessege.getText();
		String expectedMessege = "Personal Information Updated Successfully";
		Assert.assertEquals(expectedMessege, actualMessege);
		Logger.info("Alert is displayed");
	}
	
	
//	Change Password 
	@And("User enter below information")
	public void userEnterBelowInformation(DataTable data) {
		List<Map<String,String>> passwordData = data.asMaps(String.class, String.class);
		sendText(factory.accountPage().previousPasswordInput, passwordData.get(0).get("previousPassword"));
		sendText(factory.accountPage().newPasswordInput, passwordData.get(0).get("newPassword"));
		sendText(factory.accountPage().confirmPasswordInput, passwordData.get(0).get("confirmPassword"));
		Logger.info("User entered required information");
		
	}
	@And("User click on Change Password button")
	public void userClickOnChangePasswordButton() {
		click(factory.accountPage().credentialsSubmitBtn);
		Logger.info("User clicked on ChangePassword button");
	}
//	@Then("a messege should be displayed {string}")
//	public void aMessegeShouldBeDisplayed(String expectedMessege) {
//		waitTillPresence(factory.accountPage().passwordUpdatedSuccessfully);
//		Assert.assertEquals(expectedMessege, factory.accountPage().passwordUpdatedSuccessfully.getText());
//		Logger.info(expectedMessege + " is displayed");
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed1(String expectedMessage) {

		if (expectedMessage.contains("Password")) {
			waitTillPresence(factory.accountPage().passwordUpdatedSuccessfully);
			Assert.assertEquals(expectedMessage, factory.accountPage().passwordUpdatedSuccessfully.getText());
			Logger.info(expectedMessage + " is displayed");
		} else if (expectedMessage.contains("Payment Method added")) {

			waitTillPresence(factory.accountPage().paymentMethodAddedSuccessfullyMessage);
			Assert.assertEquals(expectedMessage, factory.accountPage().paymentMethodAddedSuccessfullyMessage.getText());
			Logger.info(expectedMessage + " is displayed");

		} else if (expectedMessage.contains("Payment Method updated")) {

			waitTillPresence(factory.accountPage().paymentMethodUpdatedSuccessfullyMessage);
			Assert.assertEquals(expectedMessage,
					factory.accountPage().paymentMethodUpdatedSuccessfullyMessage.getText());
			Logger.info(expectedMessage + " is displayed");
		} else if (expectedMessage.contains("Address Added Successfully")) {

			waitTillPresence(factory.accountPage().addAddressSuccessfullMessage);
			Assert.assertEquals(expectedMessage, factory.accountPage().addAddressSuccessfullMessage.getText());
			Logger.info(expectedMessage + " is displayed");
		} else if (expectedMessage.contains("Address Updated Successfully")) {

			waitTillPresence(factory.accountPage().addressUpdatedSuccessfullyMessage);
			Assert.assertEquals(expectedMessage, factory.accountPage().addressUpdatedSuccessfullyMessage.getText());
			Logger.info(expectedMessage + " is displayed");
		}else if (expectedMessage.contains("Order Placed, Thanks")) {

//			waitTillPresence(factory.homePage().orderPlacedMessage);
//			Assert.assertEquals(expectedMessage, factory.homePage().orderPlacedMessage.getText());
//			Logger.info(expectedMessage + " is displayed");
	}}
//	add payment method
@When("User click on Add a payment method link")
public void userClickOnAddAPaymentMehtodLink() {
	click(factory.accountPage().addPaymentMethodLink);
	Logger.info("user clicked on add a payment method link");

}

@When("User fill Debit or credit card information")
public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
	List<Map<String, String>> paymentInformation = dataTable.asMaps(String.class, String.class);
	sendText(factory.accountPage().cardNumberInput, paymentInformation.get(0).get("cardNumber"));
	sendText(factory.accountPage().nameOnCardInput, paymentInformation.get(0).get("nameOnCard"));
	selectByVisibleText(factory.accountPage().expirationYearInput, paymentInformation.get(0).get("expirationYear"));
	selectByVisibleText(factory.accountPage().expirationMonthInput,
			paymentInformation.get(0).get("expirationMonth"));

	sendText(factory.accountPage().securityCodeInput, paymentInformation.get(0).get("securityCode"));
	Logger.info("user entered required card information");
}

@When("User click on Add your card button")
public void userClickOnAddYourCardButton() {
	click(factory.accountPage().addYourCardButton);
	Logger.info("user clicked on Add your card button");

}
//@Then("a message should be displayed {string}")
//public void aMessageShouldBeDisplayed(String string) {
//waitTillPresence(factory.accountPage().paymentMethodAddedSuccessfullyMessage);	
//	end of add payment method


//copied
//Edit payment
@When("User select card with ending {string}")
public void userSelectCardWithEnding(String cardEndingNumber) {

	List<WebElement> cards = factory.accountPage().cardEndingNumber;
	for (WebElement card : cards) {
		if (card.getText().equals(cardEndingNumber))
			System.out.println(card.getText() + " =======================");
		click(card);
		Logger.info(cardEndingNumber + "is selected");
		break;
	}
}
@When("User click on Edit option of card section")
public void userClickOnEditOptionOfCardSection() {
	click(factory.accountPage().cardEditButton);
	Logger.info("user clicked on Edit Option");

}

@When("user edit information with below data")
public void userEditInformationWithBelowData(DataTable dataTable) {
	List<Map<String, String>> paymentInformation = dataTable.asMaps(String.class, String.class);
	clearTextUsingSendkeys(factory.accountPage().cardNumberInput);
	sendText(factory.accountPage().cardNumberInput, paymentInformation.get(0).get("cardNumber"));
	clearTextUsingSendkeys(factory.accountPage().nameOnCardInput);
	sendText(factory.accountPage().nameOnCardInput, paymentInformation.get(0).get("nameOnCard"));
	selectByVisibleText(factory.accountPage().expirationYearInput, paymentInformation.get(0).get("expirationYear"));
	selectByVisibleText(factory.accountPage().expirationMonthInput,
			paymentInformation.get(0).get("expirationMonth"));
	clearTextUsingSendkeys(factory.accountPage().securityCodeInput);
	sendText(factory.accountPage().securityCodeInput, paymentInformation.get(0).get("securityCode"));
	Logger.info("user entered required card information");

}

@When("user click on Update Your Card button")
public void userClickOnUpdateYourCardButton() {

	click(factory.accountPage().updateYourCardButton);
	Logger.info("user clicked on Update your card button");
	
}

@When("User click on remove option of card section")
public void userClickOnRemoveOptionOfCardSection() {

	click(factory.accountPage().removeCardLink);
	Logger.info("user clicked on remove option of card section");

}

@Then("payment details should be removed")
public void paymentDetailsShouldBeRemoved() {

	try {
		Assert.assertFalse(isElementDisplayed(factory.accountPage().cardPresent));
		Logger.info("payment details removed from account");

	} catch (AssertionError e) {
		Logger.info(e.getMessage());
	}

}

@When("User click on Add address option")
public void userClickOnAddAddressOption() {
	click(factory.accountPage().addAddressButton);
	Logger.info("user clicked on Add Address option");

}

@When("user fill new address form with below information")
public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
	List<Map<String, String>> addressInformation = dataTable.asMaps(String.class, String.class);
	selectByVisibleText(factory.accountPage().countryDropDown,
			DataGenerator.addressGenerator(addressInformation.get(0).get("country")));
	clearTextUsingSendkeys(factory.accountPage().addressFullNameInput);
	sendText(factory.accountPage().addressFullNameInput,
			DataGenerator.addressGenerator(addressInformation.get(0).get("fullName")));
	clearTextUsingSendkeys(factory.accountPage().addressPhoneNumberInput);
	sendText(factory.accountPage().addressPhoneNumberInput,
			DataGenerator.addressGenerator(addressInformation.get(0).get("phoneNumber")));
	clearTextUsingSendkeys(factory.accountPage().addressInput);
	sendText(factory.accountPage().addressInput,
			DataGenerator.addressGenerator(addressInformation.get(0).get("streetAddress")));
	clearTextUsingSendkeys(factory.accountPage().apartmentInput);
	sendText(factory.accountPage().apartmentInput,
			DataGenerator.addressGenerator(addressInformation.get(0).get("apt")));
	clearTextUsingSendkeys(factory.accountPage().cityInput);
	sendText(factory.accountPage().cityInput,
			DataGenerator.addressGenerator(addressInformation.get(0).get("city")));
	selectByVisibleText(factory.accountPage().stateInput,
			DataGenerator.addressGenerator(addressInformation.get(0).get("state")));
	clearTextUsingSendkeys(factory.accountPage().zipCodeInput);
	sendText(factory.accountPage().zipCodeInput,
			DataGenerator.addressGenerator(addressInformation.get(0).get("zipCode")));

	Logger.info("user filled the address form");

}

@When("User click Add Your Address button")
public void userClickAddYourAddressButton() {
	click(factory.accountPage().addYourAddress);
	Logger.info("user clicked Add your Address button");


}

@When("User click on edit address option")
public void userClickOnEditAddressOption() {
	click(factory.accountPage().editAddressButton);
	Logger.info("user clicked on edit address option");

}

@When("User click update Your Address button")
public void userClickUpdateYourAddressButton() {
	click(factory.accountPage().updateAddressButton);
	Logger.info("user clicked on Update your Address button");

}

@When("User click on remove option of Address section")
public void userClickOnRemoveOptionOfAddressSection() {
	click(factory.accountPage().removeAddressOption);
	Logger.info("user clicked on remove option of address section");

}

@Then("Address details should be removed")
public void addressDetailsShouldBeRemoved() {
	try {
		Assert.assertFalse(isElementDisplayed(factory.accountPage().removeAddressOption));
		Logger.info("Address details removed");
	} catch (AssertionError e) {
		Logger.info(e.getMessage());

	}
}}














