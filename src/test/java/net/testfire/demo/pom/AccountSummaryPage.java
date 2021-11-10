package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSummaryPage extends AbstractPage {
	
	private WebDriver driver;

	public AccountSummaryPage(WebDriver driver) {
		this.driver = driver;
		this.url = "https://demo.testfire.net/bank/main.jsp";
			
			
	}
	
	
	public void clickAccountSummmary() {
	
		driver.findElement(By.id("MenuHyperLink1")).click();
	}
	
	
	public void savingsSummary() {
		driver.findElement(By.id("listAccounts")).click();
	    driver.findElement(By.cssSelector("option:nth-child(1)")).click();
	    driver.findElement(By.id("btnGetAccount")).click();
	}

}
