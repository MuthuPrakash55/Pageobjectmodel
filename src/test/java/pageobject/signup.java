package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class signup {
		WebDriver driver;
		
		public signup(WebDriver rdriver) {
			driver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath ="//input[@name='firstName']")
		WebElement firstname;
		
		@FindBy(xpath ="//input[@name='lastName']" )
		WebElement surname;
		
		@FindBy(xpath ="//button[@type='button']")
		WebElement button;
		
		@FindBy(xpath = "//div[@id='headingSubtext']")
		WebElement check;
		
		public void name(String fname) {
			firstname.sendKeys(fname);
		}
		
		public void lastname(String lname) {
			surname.sendKeys(lname);
		}
		public void next() {
			button.click();
		}
		public boolean checking() {
			String name=check.getText();
			Assert.assertEquals(name, "Enter your name");
			return true;
		}
		
}
