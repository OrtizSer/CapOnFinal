package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class OrderSteps extends CommonUtility{
	
	POMFactory factory = new POMFactory();

	@Then("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.homePage().ordersOption);
		Logger.info("user clicked on Orders Section");

	}

	@Then("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		click(factory.orderPage().firstOrderItem);
		Logger.info("user clicked on first order in list");

	}

	@Then("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		click(factory.orderPage().cancelButton);
		Logger.info("user clicked on Cancel The Order button");

	}

	@Then("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String reason) {
		selectByVisibleText(factory.orderPage().cancelationReasonDropDown, reason);
		Logger.info("user selected the cancelation Reason " + reason);

	}

	@Then("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.orderPage().CancelOrderButton);
		Logger.info("User clicked on Cancel Order Button");

	}

	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String expectedMessage) {

		if (expectedMessage.contains("Your Order Has Been Cancelled")) {
			Assert.assertEquals(expectedMessage, factory.orderPage().yourOrderHasBeenCancelledMessage.getText());
			Logger.info("a cancelation messge displayed " + expectedMessage);
		} else if (expectedMessage.contains("Return was successful")) {
			Assert.assertEquals(expectedMessage, factory.orderPage().returnWasSuccessfullMessage.getText());
			Logger.info("a cancelation messge displayed " + expectedMessage);
		}
	}

	@Then("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(factory.orderPage().returnItemButton);
		Logger.info("user clicked on Return Items Button");

	}

	@Then("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String reason) {
		selectByVisibleText(factory.orderPage().cancelationReasonDropDown, reason);
		Logger.info("user selected the cancelation Reason " + reason);

	}

	@Then("User select the drop off service {string}")
	public void userSelectTheDropOffService(String dropOffLocation) {
		selectByVisibleText(factory.orderPage().dropOffDropDown, dropOffLocation);
		Logger.info("User select the drop off service" + dropOffLocation);
	}

	@Then("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.orderPage().CancelOrderButton);
		Logger.info("User click on Return Order button");

	}
	
	@Then("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.orderPage().reviewButton);
		Logger.info("user click on Review Button");

	}
	@Then("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String headline, String body) {
		sendText(factory.orderPage().reviewHeadlineInput, headline);
		sendText(factory.orderPage().reviewDescriptionInput, body);
		Logger.info("user wrote review on product");

	}
	@Then("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.orderPage().reviewSubmitButton);
		Logger.info("user clicked add your review button");

	}
	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String expected) {
		waitTillPresence(factory.orderPage().yourReviewWasAddedSuccessfullyMessage);
		Assert.assertEquals(factory.orderPage().yourReviewWasAddedSuccessfullyMessage.getText(), expected);
		Logger.info("a review message displayed");
	
	}


}
