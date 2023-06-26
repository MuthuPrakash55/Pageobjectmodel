package bdd.test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageobject.signup;

public class loginstepdef extends baseclass{
	
	@After
	public void screenshot(Scenario scenario) {
		byte[] screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}
	
	@Given("user launch the {string} browser")
	public void userLaunchTheBrowser(String browser) {
	    switch (browser) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;

		default:
			break;
		}
	   sign=new signup(driver);
	  
	}
	@When("user enters the url for the website")
	public void userEntersTheUrlForTheWebsite() {
	    driver.get("https://accounts.google.com/signup");
	  
	}
	@Then("the user navigate to the right application page")
	public void theUserNavigateToTheRightApplicationPage() {
	   String title= driver.getTitle();
	   Assert.assertEquals(title, "Sign in – Google accounts");
	}
	@Given("user enter the name of {string} in the first name field")
	public void user_enter_the_name_of_in_the_first_name_field(String fname) {
	    sign.name(fname);    
	}

	@Given("user enter the surname of {string} in the field")
	public void user_enter_the_surname_of_in_the_field(String lname) {
	    sign.lastname(lname);
	}
	@When("user clicks the next button")
	public void userClicksTheNextButton() {
	    sign.next();
	  
	}
	@Then("user navigate to the right page")
	public void userNavigateToTheRightPage() {
	   boolean page= sign.checking(); 
	   System.out.println(page);
	}
}
