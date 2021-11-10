package net.testfire.demo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends AbstractPage{
	
	
	
	public LogoutPage(WebDriver driver) {
		
		this.driver = driver;
		this.url = "https://demo.testfire.net/index.jsp";
	}
	
	
	
	public String getSignInText() {
		
		return driver.findElement(By.id("LoginLink")).getText();
	}

}

