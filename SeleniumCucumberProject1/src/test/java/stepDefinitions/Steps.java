package stepDefinitions;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException {
		// Logger configuration
		logger = Logger.getLogger("Sample Website");  // Logger
		PropertyConfigurator.configure("Log4j.properties");  //Logger
		
		//to read properties from config.properties file
		configProp=new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configProp.load(configPropfile);
// NOTE: the above Logger and config.properties cann't be defined and inherit from BaseClass as these are used in @Before.
		String br=configProp.getProperty("browser");
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		
		
		logger.info("********** Launching Browser ***********");
		
	}
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		lp = new LoginPage(driver);
	}

	@When("User open url {string}")
	public void user_open_url(String url) {
		driver.get(url);
		logger.info("********** Opening URL ***********");
		driver.manage().window().maximize();

	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
		logger.info("********** Credentials ***********");
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		lp.clickLogin();
		Thread.sleep(5000);
		logger.info("********** clicked on login ***********");
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		// here we are verifying invalid credential fail and also success message after login
		if (driver.getPageSource().contains("Login was umsuccessful.")) 
		{
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(5000);
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);

	}

	@Then("Close browser")
	public void close_browser() {
		driver.quit();
	}

// Customer Feature step definitons
	@Then("User can view Dashbord")
	public void user_can_view_Dashbord() {
		addcust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getPageTitle());
	    
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		Thread.sleep(3000);
		addcust.clickOnCustomersMenu();
	  
	}

	@When("Click on customer Menu Item")
	public void click_on_customer_Menu_Item() throws InterruptedException {
		Thread.sleep(3000);
		addcust.clickOnCustomersMenuItem();
	}

	@When("Click on Add New button")
	public void click_on_Add_New_button() throws InterruptedException {
		addcust.clickOnAddnew();
		Thread.sleep(3000);	    
	}

	@Then("User can view Add New Customer page")
	public void user_can_view_Add_New_Customer_page() {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomstring()+"@gmail.com";
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setFirstName("Venugopal");
		addcust.setLastName("Vedullapalli");
		addcust.setGender("Male");
		addcust.setDob("5/28/2080");
		addcust.setCompanyName("Gopal Arts");
		// Registered - default
		// the customer can not be in both "Guest" and "Registered" customer roles
		// Add the customer to guest or registered role

		addcust.setCustomerRoles("Vendors");
		Thread.sleep(3000);	  

		addcust.setManagerOfVendor("Vendor 2");
		addcust.setAdminContent("This is for testing...");
		
		
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		addcust.clickOnSave();
		Thread.sleep(3000);	
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	}
// Steps for search customer by EMail

	@When("Enter customer Email")
	public void enter_customer_Email() {
		searchCust = new SearchCustomerPage(driver); // for every new scenario we need to add this driver
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on Search Button")
	public void click_on_Search_Button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	}

	@Then("User should found Email in the search table")
	public void user_should_found_Email_in_the_search_table() {
		boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true,status);
	
	}
	
	// search customer by name
	
	@When("Enter customer FirstName")
	public void enter_customer_FirstName() {
		searchCust = new SearchCustomerPage(driver); // for every new scenario we need to add this driver
		searchCust.setFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_LastName() {
		searchCust.setLastName("Terces");
	}

	@Then("User should found Name in the search table")
	public void user_should_found_Name_in_the_search_table() {
		boolean status = searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true,status);
	}


}
