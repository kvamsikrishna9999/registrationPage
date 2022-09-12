package com.telus.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class SuccessfulValidationPage {
	WebDriver driver;
	//	@FindBy(xpath ="//*[contains(text(),'Registration Form is Successfully Submitted')]")
	//	@CacheLookup
	//	WebElement validationOutput;

	public SuccessfulValidationPage(WebDriver driver) {
		this.driver=driver;
	}

	public void validationSuccessfulMessage() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement validationOutput = driver.findElement(By.xpath("//*[contains(text(),'Registration Form is Successfully Submitted')]"));

		if(validationOutput.isDisplayed()) {
			Reporter.log("Validation successfull message is displayed successfully");

			String actualValidationCode = validationOutput.getText();

			// Expected result
			String expectedValidationCode = "Registration Form is Successfully Submitted.";
			String validationMsg[] = actualValidationCode.split(":");
			String outputValidation = validationMsg[1].trim();
			if(actualValidationCode.contains(expectedValidationCode)) {
				Reporter.log("The Registration message of the page is :" + expectedValidationCode);
				Reporter.log("The Transaction ID is :" + outputValidation );
				Reporter.log("Actual and expected validation codes are same");
			} else {
				Reporter.log("Actual and expected validation codes are not same");
				Reporter.log("The Actual validation code is :" + actualValidationCode);
				Reporter.log("The Expected validation Code is :" + expectedValidationCode);
			}
		}
		else {
			Reporter.log("Validation successfull message is not displayed successfully");	
		}

	}
}
