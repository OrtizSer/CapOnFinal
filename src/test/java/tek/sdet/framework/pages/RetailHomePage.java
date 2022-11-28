package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup{
	public RetailHomePage() {
	PageFactory.initElements(getDriver(), this);
	
	}
	
	@FindBy(xpath = "//a[@class='top-nav__logo active']")
	public WebElement logo;
	
	
	@FindBy(id = "search")
	public WebElement allDepartments;
	
	@FindBy(id = "searchInput")
	public WebElement searchInputField;
	
	@FindBy(id= "searchBtn")
	public WebElement searchButton;
	
	@FindBy(xpath = "//img[@alt='PlayStation 5 Console']")
	public WebElement playStationItem;
	
	@FindBy(xpath = "//span[text()='All']")
	public WebElement allElement;
	
	@FindBy(id="contentHeader")
	public WebElement shopByDepartment;
	
	@FindBy(id="cartBtn")
	public WebElement cart;
	
	@FindBy(id="signinLink")
	public WebElement signIn;
	
	@FindBy(id="accountLink")
	public WebElement account;
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
