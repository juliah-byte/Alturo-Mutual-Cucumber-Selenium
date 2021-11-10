package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AccountPage extends AbstractPage {
	
	private WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		this.url = "https://demo.testfire.net/bank/main.jsp";
	}
	
	// take action on the page
	public void clickLogout() {
		
		driver.findElement(By.id("LoginLink")).click();
	}

	// inspecting the page
	public String getLogoutText() {
		
		return driver.findElement(By.id("LoginLink")).getText();
	}
	
	
	
}
