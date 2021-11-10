package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * 
 * Page Object Model - design pattern
 * 
 * Represent the Login Page - decouple Selenium code from tests
 * - Resuability of Selenium code
 * - Easier to create new tests by making new tests using POJO syntax
 * - Easier to read tests
 *
 */
public class LoginPage extends AbstractPage {
	
	//private WebDriver driver;
	private By username = By.id("uid");
	private By password = By.id("passw");
	private By loginButton = By.name("btnSubmit");
	private By errorMessage = By.id("_ctl0__ctl0_Content_Main_message");
	
	public LoginPage (WebDriver driver) {
		
		this.driver = driver;
		this.url = "https://demo.testfire.net/login.jsp";
	}
	
	
	public void setUsername(String username) {
		
		driver.findElement(this.username).sendKeys(username);
	}
	
	public void setPassword(String password) {
		
		driver.findElement(this.password).sendKeys(password);
	}
	
	public void clickLoginButton() {
		
		driver.findElement(this.loginButton).click();
	}
	
	public boolean hasErrorMessage() {
		String fail = "Login Failed";
		
		return driver.findElement(this.errorMessage).getText().contains(fail);
		
	}

	

}
