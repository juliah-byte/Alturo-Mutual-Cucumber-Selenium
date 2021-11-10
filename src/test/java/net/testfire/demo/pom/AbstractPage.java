package net.testfire.demo.pom;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	
	WebDriver driver;
	String url;
	
	public void navigateToPage() {
		
		driver.get(url);
	}

}
