package net.testfire.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test {
  @Given("^you are in Given annotation$")
  public void given() throws Throwable {
  }

  @When("^you are in When annotation$")
  public void when() throws Throwable {
  }

  @Then("^you are in Then annotation$")
  public void then() throws Throwable {
  }

}
