package net.testfire.demo;


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
import net.testfire.demo.pom.LoginPage;
import net.testfire.demo.pom.LogoutPage;
import net.testfire.demo.pom.RecentTransactionsPage;
import net.testfire.demo.pom.SearchArticlesPage;
import net.testfire.demo.pom.TransferFundsPage;


public class LoginScenario {

	static WebDriver driver;
	static String url = "https://demo.testfire.net/";
	static long waitTime = 10;
	static String user = "jsmith";
	static String password = "Demo1234";

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

	@And("I have typed in the username and password")
	public void i_have_typed_in_the_username_and_password() {
		System.out.println("I type in username and password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(user);
		loginPage.setPassword(password);

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
		assertEquals("Sign Off", accountPage.getLogoutText());
	}
	
	
	//transfer funds from savings
	@Given("I am on the Transfer Funds Page")
	public void i_am_on_the_transfer_funds_page() {
	   TransferFundsPage transferFunds = new TransferFundsPage(driver);
	   transferFunds.clickTransferFunds();
	}
	
	
	@Given("I transfer ${int} from savings account to my checking account")
	public void i_transfer_$_from_savings_account_to_my_checking_account(int amount) {
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
	
	//transfer funds from checking
	
	@Given("I tranfer ${int} from checking account to my savings account")
	public void i_tranfer_$_from_checking_account_to_my_savings_account(Integer amount) {
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
	
	
	//Seach Articles
	
	@Given("I am on the Search Articles Page")
	public void i_am_on_the_search_articles_page() {
	    
		SearchArticlesPage articlesPage = new SearchArticlesPage(driver);
		articlesPage.clickSearchArticles();
		
	}
	
	
	
	@Given("I search Watchfire")
	public void i_search_watchfire() {
		
		SearchArticlesPage articlesPage = new SearchArticlesPage(driver);
		articlesPage.clickSearchArticles();
		
	   
	}
	@When("I click Query")
	public void i_click_query() {
	    SearchArticlesPage articlesPage = new SearchArticlesPage(driver);
	    articlesPage.clickQuery();
	}
	
	
	
	
	@Then("I have found article")
	public void i_have_found_article() {
	    
	}


	
	
	
	
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
