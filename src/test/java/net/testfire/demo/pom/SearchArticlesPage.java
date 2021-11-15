package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
		
		driver.findElement(By.cssSelector("#QueryXpath > #query")).click();
		driver.findElement(By.cssSelector("#QueryXpath > #query")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.cssSelector("#QueryXpath > #query")).sendKeys(Keys.DELETE);
		driver.findElement(By.cssSelector("#QueryXpath > #query")).sendKeys("Watchfire");
	}
	
	public void clickQuery() {
		
		driver.findElement(By.id("Button1")).click();
	}
	
	public boolean findArticle() {
		
		String success = "Found news title:";
		
		//WebElement element = driver.findElement(By.cssSelector("#QueryXpath > #query"));
	    //Actions builder = new Actions(driver);
	    //builder.doubleClick(element).perform();
		System.out.println(driver.findElement(By.id("QueryXpath")).getText());
		return driver.findElement(By.id("QueryXpath")).getText().contains(success);
	}

}
