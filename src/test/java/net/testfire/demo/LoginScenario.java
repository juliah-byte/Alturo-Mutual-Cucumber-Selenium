package net.testfire.demo;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

//import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import net.testfire.demo.pom.AccountPage;
import net.testfire.demo.pom.Checking;
import net.testfire.demo.pom.Credit;
import net.testfire.demo.pom.CustomizeSiteLanguage;
import net.testfire.demo.pom.LoginPage;
import net.testfire.demo.pom.LogoutPage;
import net.testfire.demo.pom.RecentTransactionsPage;
import net.testfire.demo.pom.Savings;
import net.testfire.demo.pom.SearchArticlesPage;
import net.testfire.demo.pom.TransferFundsPage;


public class LoginScenario {

	static WebDriver driver;
	static String url = "https://demo.testfire.net/";
	static long waitTime = 10;
	//static String user = "jsmith";
	//static String password = "Demo1234";

	static {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
	}

	// step definition -method stubs that hook into the Gherkin file
	// @give @when @then - hook annotations

	
	// admincred
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		System.out.println("I am on login page");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.navigateToPage();

	}

	@And("^I have typed in the (.*) and (.*)$")
	public void i_have_typed_in_the_and(String username, String pass) {
		System.out.println("I type in username and password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(username);
		loginPage.setPassword(pass);

	}

	// Gherkin - describes user's interactions
	@When("I click login") // Cucumber - glues the gherkin and selenium (the test runner)
	public void i_click_login() {

		// selenium - IS the 'user' interaction
		System.out.println("I click on login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
	}
	


	@Then("I am signed into Altoro Mutual")
	public void i_am_signed_into_altoro_mutual() {
		System.out.println("I am signed in to altoro mutual");
		AccountPage accountPage = new AccountPage(driver);
		accountPage.viewSummary();
		assertEquals("Sign Off", accountPage.getLogoutText());
	}
	
	
	//transfer funds from savings
	@Given("I am on the Transfer Funds Page")
	public void i_am_on_the_transfer_funds_page() {
	   TransferFundsPage transferFunds = new TransferFundsPage(driver);
	   transferFunds.clickTransferFunds();
	}
	
	
	@Given("I transfer ${float} from savings account to my checking account")
	public void i_transfer_$_from_savings_account_to_my_checking_account(float amount) {
		String newAmount = String.valueOf(amount);
		TransferFundsPage transferFunds = new TransferFundsPage(driver);
		transferFunds.fromSavingstoChecking(newAmount);
	}
	
	
	@When("I click transfer money")
	public void i_click_transfer_money() {
		TransferFundsPage transferFunds = new TransferFundsPage(driver);
		transferFunds.clickTransfer();
	}
	
	
	
	@Then("I have transfered money")
	public void i_have_transfered_money() throws InterruptedException {
	  TransferFundsPage transferFunds = new TransferFundsPage(driver);
	  assertTrue(transferFunds.transferSuccessMessage());
	  
	}
	
	
	
	//Incorrect Funds
//	@Then("I have transfered incorrect funds")
//	public void i_have_transfered_incorrect_funds() {
//		TransferFundsPage transferFunds = new TransferFundsPage(driver);
//		  assertFalse(transferFunds.transferSuccessMessage());
//	}
	
	//transfer funds from checking
	
	
	

	
	@Given("I tranfer ${float} from checking account to my savings account")
	public void i_tranfer_$_from_checking_account_to_my_savings_account(float amount) {
		String newAmount = String.valueOf(amount);
		TransferFundsPage transferFunds = new TransferFundsPage(driver);
		transferFunds.fromSavingstoChecking(newAmount);
	}
	@Then("I have tranfered money")
	public void i_have_tranfered_money() {
		TransferFundsPage transferFunds = new TransferFundsPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
		assertTrue(transferFunds.transferSuccessMessage());
	}
	
	
	@Given("^I click (.*) account$")
	public void i_click_checking_account(String type) {
		
		
		if(type.equals("checking")) {
			AccountPage accountPage = new AccountPage(driver);
			accountPage.clickChecking();
		}
		
		if(type.equals("savings")) {
			AccountPage accountPage = new AccountPage(driver);
			accountPage.clickSavings();
			
		}
		
		if(type.equals("credit")) {
			AccountPage accountPage = new AccountPage(driver);
			accountPage.clickCredit();
			
		}
	}

	
	
	@When("I click go")
	public void i_click_go() {
		
	    AccountPage accountPage = new AccountPage(driver);
	    accountPage.clickGo();
	    
	}
	
	@Then("^I can view my (.*) account$")
	public void i_can_view_my_account(String account) {
		
		
		if(account.equals("checking")) {
			Checking checking = new Checking(driver);
			assertTrue(checking.confirmChecking());
			
		}
		
		if(account.equals("savings")) {
			Savings savings = new Savings(driver);
			assertTrue(savings.confirmSavings());
			
		}
		
		
		if(account.equals("credit")) {
			Credit credit = new Credit(driver);
			assertTrue(credit.confirmCredit());
			
		}
			
	   
	}
	
	
	//Seach Articles
	
	@Given("I am on the Search Articles Page")
	public void i_am_on_the_search_articles_page() {
	    
		SearchArticlesPage articlesPage = new SearchArticlesPage(driver);
		articlesPage.clickSearchArticles();
		
	}
	
	
	
	@Given("I search Watchfire")
	public void i_search_watchfire() {
		
		SearchArticlesPage articlesPage = new SearchArticlesPage(driver);
		articlesPage.searchWatchfire();
		
	   
	}
	@When("I click Query")
	public void i_click_query() {
	    SearchArticlesPage articlesPage = new SearchArticlesPage(driver);
	    articlesPage.clickQuery();
	}
	
	
	
	
	@Then("I have found article")
	public void i_have_found_article() {
	    
		SearchArticlesPage articlesPage = new SearchArticlesPage(driver);
		assertTrue(articlesPage.findArticle());
		
	}

	
	// Customize Site Language
	
	@Given("I am on the Customize Site Page")
	public void i_am_on_the_customize_site_page() {
		
	    CustomizeSiteLanguage languagePage = new CustomizeSiteLanguage(driver);
	    languagePage.clickCustomizeSiteLanguage();
	}

	@When("^I select (.+)$")
	public void i_select(String language) {
		CustomizeSiteLanguage languagePage = new CustomizeSiteLanguage(driver);
		System.out.println(language);
    	
		if(language == "English") {
			languagePage.clickEnglish();
		}
		
		
		if (language == "International") {
			
			languagePage.clickInternational();
		}
	}
	
	@Then("^My customized Site Language is (.*)$")
	public void my_customized_site_language_is(String language) {
		CustomizeSiteLanguage languagePage = new CustomizeSiteLanguage(driver);
		
		if(language == "English") {
			languagePage.isEnglish();
		}
		
		
		if (language == "International") {
			
			languagePage.isInternational();
		}
	
	}

//	@When("I click International")
//	public void i_click_international() {
//		CustomizeSiteLanguage languagePage = new CustomizeSiteLanguage(driver);
//    	languagePage.clickInternational();
//	}
//
//	@Then("My customized Site Language is International")
//	public void my_customized_site_language_is_international() {
//		CustomizeSiteLanguage languagePage = new CustomizeSiteLanguage(driver);
//    	languagePage.isInterantional();
//	}
	

	
	
	
	
	//signed on
	@When("I click logout")
	public void i_click_logout() {
		 AccountPage accountPage = new AccountPage(driver);
		 accountPage.clickLogout();
		 
	}

	
	@Then("I am signed out of Altoro Mutual")
	public void i_am_signed_out_of_altoro_mutual() {
		System.out.println("I am signed out");
		LogoutPage logoutPage = new LogoutPage(driver);
		assertEquals("Sign In", logoutPage.getSignInText());
	}


	//failedcred

	@Given("I have typed in invalid credentials")
	public void i_have_typed_in_invalid_credentials() {
		System.out.println("I have typed in invalid credentials");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername("bogus12656789192");
		loginPage.setPassword("bogus12687uiok1");
	}
	

	
	

	@Then("I receive error message")
	public void i_receive_error_message() {
		
		System.out.println("I receive an error message");
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.hasErrorMessage());
		driver.quit();
	}

}
