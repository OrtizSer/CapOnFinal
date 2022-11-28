package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class HomeSteps extends CommonUtility{
//	All your step definition classes will 
//	extend your CommonUtility class
//	create object of POMFactory class
//POMFactory instance should be on top of the class	
	POMFactory factory= new POMFactory();

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String expectedTitle = "React App";
//		wrote actualTitle in the commonUtility package
		String actualTitle = getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		Logger.info(actualTitle +" is equals to "+ expectedTitle);
		
		
	}
	@Then("User verify retail page logo is present")
	public void userVerifyRetailPageLogoIsPresent() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().logo));
		Logger.info("logo is present");
		
	}
	

@When("User change the category to {string}")
public void userChangeTheCategoryTo(String value) {
    selectByVisibleText(factory.homePage().allDepartments,value);
    Logger.info(value + " was selected from the dropp down");
    
}
@When("User search for an item {string}")
public void userSearchForAnItem(String value) {
	sendText(factory.homePage().searchInputField,value);
	Logger.info("User enetered " + value);
   
    
}
@When("User click on Search icon")
public void userClickOnSearchIcon() {
	click(factory.homePage().searchButton);
	Logger.info("User clicked on search button");
	
    
}
@Then("Item should be present")
public void itemShouldBePresent() {
	Assert.assertTrue(isElementDisplayed(factory.homePage().playStationItem));
	Logger.info("Item is present");
  
}

@When("User click on All section")
public void userClickOnAllSection() {
	click(factory.homePage().allElement);
	Logger.info("user clicked on All element");
	}

@Then("User verifies {string} is present")
public void userVerifiesIsPresent(String value) {
	String expectedValue = value;
	String actualValue = getElementText(factory.homePage().shopByDepartment);
	Assert.assertEquals(expectedValue, actualValue);
	Logger.info(expectedValue + " is present");
}
	
	@Then("User verifies Cart icon is present")
	public void userVerifiesCartIconIsPresent() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().cart));
		Logger.info("cart icon is Present");
}
	
}
	
	
	
	

