package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Credit extends AbstractPage {
	
	WebDriver driver;

	public Credit(WebDriver driver) {
		
		this.driver = driver;
		this.url = "http://altoromutual.com/bank/showAccount?listAccounts=4539082039396288";
	}
	
	
	public boolean confirmCredit() {
		
		String success = "Account History - 4539082039396288 Credit Card";
		
		System.out.println(success);
		
		return driver.findElement(By.cssSelector("h1")).getText().contains(success);
		
		
	}
	
	
	

}
