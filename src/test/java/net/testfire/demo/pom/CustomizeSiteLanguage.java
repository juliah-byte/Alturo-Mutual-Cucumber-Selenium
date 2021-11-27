package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomizeSiteLanguage {
	
	WebDriver driver;

	public CustomizeSiteLanguage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void clickCustomizeSiteLanguage() {
		
		driver.findElement(By.id("MenuHyperLink5")).click();
		
	}
	
	
	public void clickInternational() {
		
		System.out.println("Test");
		
		driver.findElement(By.cssSelector(".fl > form:nth-child(2) > p:nth-child(3) > a:nth-child(1)")).click();
	}
	
	
	 
	public void clickEnglish() {
		
		System.out.println("English");
		
		driver.findElement(By.cssSelector("#HyperLink2")).click();
	}
	
	
	public boolean isEnglish() {
		String success = "Current Language: english";
		
		System.out.println(driver.findElement(By.cssSelector("#HyperLink2")).getText());
		
		return driver.findElement(By.cssSelector("#HyperLink2")).getText().contains(success);
	}
	
	
	public boolean isInternational() {
		
		String success = "Current Language: international";
		
		System.out.println("International");
		
		return driver.findElement(By.cssSelector(".fl > form:nth-child(2) > p:nth-child(3) > a:nth-child(1)")).getText().contains(success);
		
	}
	
}
