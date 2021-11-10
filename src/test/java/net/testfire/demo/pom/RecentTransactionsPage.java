package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecentTransactionsPage extends AbstractPage {
	
	WebDriver driver;

	public RecentTransactionsPage(WebDriver driver) {
		
		this.driver = driver;
		this.url = "https://demo.testfire.net/bank/transaction.jsp";	
	}
	
	
	public void clickRecentTransactionsPage() {
		
		
		driver.findElement(By.id("Query")).click();
	}
	
	


}
