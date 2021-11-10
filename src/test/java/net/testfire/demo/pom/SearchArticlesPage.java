package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchArticlesPage extends AbstractPage {
	
	WebDriver driver;
	
	
	public SearchArticlesPage(WebDriver driver) {
		
		this.driver = driver;
		this.url = "https://demo.testfire.net/bank/queryxpath.jsp";
	}
	
	
	public void clickSearchArticles() {
		
		driver.findElement(By.id("MenuHyperLink4")).click();
	}
	
	
	public void searchWatchfire() {
		
		//driver.findElement(By.id("query")).click();
		driver.findElement(By.id("query")).sendKeys("Watchfire");
	}
	
	public void clickQuery() {
		
		driver.findElement(By.id("Button1")).click();
	}
	
	public void findArticle() {
		
		String success = "Found news title:";
		
		
	}

}
