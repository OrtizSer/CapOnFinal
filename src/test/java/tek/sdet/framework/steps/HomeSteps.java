package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class HomeSteps extends CommonUtility {
	// all your step definitions classes will extends
	// CommonUtility class
	// we need to create object of POMFactory class
	// PomFactory instance should be on top of the class
	POMFactory factory = new POMFactory();

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String expectedTitle = "React App";
		String actualTitle = getTitle();// wrote this one in CommonUtility
		Assert.assertEquals(expectedTitle, actualTitle);
		Logger.info(actualTitle + " is equal to " + expectedTitle);
	}

	@Then("User verify retail page logo is present")
	public void userVerifyRetailPageLogoIsPresent() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().logo));
		Logger.info("logo is present");

	}

	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String value) {
		selectByVisibleText(factory.homePage().allDepartments, value);
		Logger.info(value + " was selected from the drop down");

	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String value) {
		sendText(factory.homePage().searchInputField, value);
		Logger.info("user entered " + value);

	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.homePage().searchButton);
		Logger.info("user clicked on search button");
	}

	@Then("Item should be present")
	public void itemShouldBePresent() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().playStationItem));
		Logger.info("item is present");

	}

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().allElement);
		Logger.info("user clicked on All element");
	}

	@Then("User verifies {string} is present")
	public void user_verifies_is_present(String value) {
		String expectedValue = value;
		String actualValue = getElementText(factory.homePage().shopByDepartment);
		Assert.assertEquals(expectedValue, actualValue);
		Logger.info(expectedValue + " is present");
	}

	@And("User verifies cart icon is present")
	public void userVerifiesCartIconIsPresent() {
		HighlightElement(factory.homePage().cart);
		Assert.assertTrue(isElementDisplayed(factory.homePage().cart));
		Logger.info("cart icon is present");
		scrollPageDownWithJS();
	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {

		List<List<String>> shopByDepartment = dataTable.asLists(String.class);

		for (int i = 0; i < shopByDepartment.get(0).size(); i++) {
			Assert.assertTrue(isElementDisplayed(
					getDriver().findElement(By.xpath("//span[text()='" + shopByDepartment.get(0).get(i) + "']"))));
			Logger.info(shopByDepartment.get(0).get(i) + " is present");
		}

	}

	@When("User on {string}")
	public void userOnElectronics(String department) {

		getDriver().findElement((By.xpath("//span[text()='" + department + "']"))).click();

	List<WebElement> dept = factory.homePage().sideBar;
	for(WebElement element : dept) {
		if(element.getText().equals(department)) {
			element.click();
			break;
		}
	}
	if(department.equals("Electronics")) {
		getDriver().findElement((By.xpath("//span[text()='Electronics']"))).click();
	}else if(department.equals("Computers")) {
		getDriver().findElement((By.xpath("//span[text()='Computers']"))).click();
	}else if(department.equals("Computers")) {
			getDriver().findElement((By.xpath("//span[text()='Computers']"))).click();
	}else if(department.equals("Smart Home")) {
		getDriver().findElement((By.xpath("//span[text()='Smart Home']"))).click();
	}else if(department.equals("Sports")) {
		getDriver().findElement((By.xpath("//span[text()='Sports']"))).click();
	}else 
		getDriver().findElement((By.xpath("//span[text()='Automative']"))).click();

	}
	
	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> departmentOptions = dataTable.asLists(String.class);
		List<WebElement> dept = factory.homePage().sideBar;
		for(int i=0; i<departmentOptions.get(0).size();i++) {
			
			for(WebElement element: dept) {
				if(element.getText().equals(departmentOptions.get(0).get(i))){
					Assert.assertTrue(element.isDisplayed());
				Logger.info(element.getText() + " is present ");	
				}
			}
			
		}
//		
//		Assert.assertTrue(getDriver().findElement(By.xpath("//span[text()='"+departmentOptions.get(0).get(0)+"']")).isDisplayed());
//		Assert.assertTrue(getDriver().findElement(By.xpath("//span[text()='"+departmentOptions.get(0).get(1)+"']")).isDisplayed());


	}
	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.signInPage().signInButton);
		
	}

	@When("User click on item")
	public void userClickOnItem() {
		
		waitTillPresence(factory.homePage().productNameItem);
		click(factory.homePage().productNameItem);
		Logger.info("User clicked on item");

	}
	@When("User select quantity {string}")
	public void userSelectQuantity(String qty) {
		selectByVisibleText(factory.homePage().quantitySelection,qty);
		Logger.info("user selected quantity " + qty );

	}
	@When("User click add to Cart button")
	public void userclickAddToCartButton() {
		click(factory.homePage().addToCartButton);
		Logger.info("user clicked add to cart button");

	}
	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String expectedQuantity) {
		
		Assert.assertEquals(expectedQuantity, factory.homePage().cartQuantity.getText());
		Logger.info("the cart icon quantity changed to " + expectedQuantity );
	}
	
	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.homePage().cart);
		Logger.info("user clicked on cart option");

	}
	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.homePage().proceedToCheckOut);
		Logger.info("user clicked on Proceed to Checkout button");

	}
	@Then("User click Add a new address link for shipping address")
	public void userClickAddANewAddressLinkForShippingAddress() {
		click(factory.homePage().addAddressBtnCheckout);
		Logger.info("user clicked add a new address link for shipping address");

	}
	@Then("User click Add a credit card or Debit Card for Payment method")
	public void userClickAddACreditCardOrDebitCardForPaymentMethod() {
		click(factory.homePage().addPaymentBtnCheckout);
		Logger.info("User clicked Add a credit card or Debit Card for Payment method");

	}
	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.homePage().placeOrderBtn);
		Logger.info("user clicked on place your order");

	}
	
}
