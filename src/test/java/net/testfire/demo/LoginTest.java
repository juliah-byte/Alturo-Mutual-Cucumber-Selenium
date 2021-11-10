package net.testfire.demo;



//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:login.feature")
public class LoginTest {

	

}
