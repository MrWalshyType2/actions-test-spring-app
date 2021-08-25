package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import com.example.demo.CucumberSpringConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DvdControllerIntegrationStepDefinitions extends CucumberSpringConfig {

	@Given("the following new DVDs")
	public void theFollowingNewDvds(List<Map<String, String>> data) {
		System.out.println("in here");
	}
	
	@When("the new DVDs are added to the store")
	public void theNewDVDsAreAddedToTheStore() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}
	
	@When("then requested with a get method")
	public void thenRequestedWithAGetMethod() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("the request should return the new dvds")
	public void theRequestShouldReturnTheNewDvds() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}
}
