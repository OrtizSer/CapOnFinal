package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class SignInSteps extends CommonUtility{
	
POMFactory factory = new POMFactory();


//@Given("User is on retail website")
//public void userIsOnRetailWebsite() {
//	String expectedTitle = "React App";
//	String actualTitle = getTitle();
//	Assert.assertEquals(expectedTitle, actualTitle);
//	Logger.info("");
 

@When("User click on sign in button")
public void userClickOnSingInButton() {
	click(factory.signInPage().signInButton);
	Logger.info("User clicked on Sing In option");
	
}

@And("User enter email {string} and password {string}")
public void userEnterEmailAndPassword(String email,String password) {
	sendText(factory.signInPage().emailField,email);
	sendText(factory.signInPage().passwordField,password);
	Logger.info("user entered email "+ email +"and password "+password);
	
}

@And("User click on login button")
public void userClickOnLoginButton() {
	click(factory.signInPage().logInButton);
	Logger.info("user clicked on login button");

}

@Then("User should be logged in into Account")
public void userShouldBeLoggedInIntoAccount() {
	Assert.assertTrue(isElementDisplayed(factory.accountPage().accountBtn));
	Logger.info("user logged in into account");
	
	
}
//Create new account
@And("User click on Create New Account button")
public void userClickOnCreateNewAccountButton() {
	click(factory.signInPage().newAccountButton);
	Logger.info("user clicked on Create New Account button");
	
	
}
@And("User fill the signUp information with the below data")
public void userFillTheSignUpInformationWithTheBelowData(DataTable data) {
	List<Map<String, String>> signUpData = data.asMaps(String.class,String.class);
	sendText(factory.signInPage().nameInput,signUpData.get(0).get("name"));
	sendText(factory.signInPage().emailInput,signUpData.get(0).get("email"));
	sendText(factory.signInPage().passwordInput,signUpData.get(0).get("password"));
	sendText(factory.signInPage().confirmPasswordInput,signUpData.get(0).get("confirmPassword"));
	Logger.info("user entered required information into sign up form");
	
		}
@And("User click on SignUp button")
public void userClickOnSignUpButton() {
	click(factory.signInPage().signUpButton);
	Logger.info("user clicked on Sign up button");
}
@Then("User should be logged into account page")
public void userShouldBeLoggedIntoAccountPage() {
	Logger.info("User created new account");
	
	
	
//https://tek-retail-ui.azurewebsites.net/

}}