package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Savings extends AbstractPage {
	
	
	WebDriver driver;

	public Savings(WebDriver driver) {
		this.driver = driver;
		this.url = "https://demo.testfire.net/bank/showAccount?listAccounts=800002";
	}
	
	
	public boolean confirmSavings() {
		
		String success = "Account History - 800002 Savings";
		
		System.out.println(success);
		
		return driver.findElement(By.cssSelector("h1")).getText().contains(success);
	}
	
	
	
	

}
