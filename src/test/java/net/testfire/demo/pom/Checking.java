package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Checking extends AbstractPage{
	
	
	WebDriver driver;

	public Checking(WebDriver driver) {
		
		this.driver = driver;
		this.url = "https://demo.testfire.net/bank/showAccount?listAccounts=800003";
	}
	

	public boolean confirmChecking() {
		
		String success = "Account History - 800003 Checking";
		
		System.out.println(success);
		
		return driver.findElement(By.cssSelector("h1")).getText().contains(success);
	}
	
	
	
	

}
