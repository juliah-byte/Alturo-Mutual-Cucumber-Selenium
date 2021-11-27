package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AccountPage extends AbstractPage {
	
	private WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		this.url = "https://demo.testfire.net/bank/main.jsp";
	}
	
	
	public void viewSummary() {
		
		driver.findElement(By.id("MenuHyperLink1")).click();
		
	}
	
	// take action on the page
	public void clickLogout() {
		
		driver.findElement(By.id("LoginLink")).click();
	}

	// inspecting the page
	public String getLogoutText() {
		
		return driver.findElement(By.id("LoginLink")).getText();
	}
	
	
	
	public void clickGo() {
		
		//driver.findElement(By.id("btnGetAccount")).click();
		driver.findElement(By.cssSelector("#btnGetAccount")).click();
	}
	
	

	public void clickChecking() {
		
		driver.findElement(By.id("listAccounts")).click();
		WebElement dropdown = driver.findElement(By.id("listAccounts"));
	    dropdown.findElement(By.xpath("//option[. = '800003 Checking']")).click();
	    driver.findElement(By.cssSelector("option:nth-child(2)")).click();
	}
	
	
	public void clickSavings() {
		
		driver.findElement(By.id("listAccounts")).click();
		WebElement dropdown = driver.findElement(By.id("listAccounts"));
	    dropdown.findElement(By.xpath("//option[. = '800002 Savings']")).click();
	    driver.findElement(By.cssSelector("option:nth-child(1)")).click();
	}

	
	public void clickCredit() {
		
		driver.findElement(By.id("listAccounts")).click();
		WebElement dropdown = driver.findElement(By.id("listAccounts"));
	    dropdown.findElement(By.xpath("//option[. = '4539082039396288 Credit Card']")).click();
	    driver.findElement(By.cssSelector("option:nth-child(3)")).click();
	}
}
