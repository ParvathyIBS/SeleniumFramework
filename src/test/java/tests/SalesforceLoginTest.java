package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.SalesforceLoginPage;

//Generate a Selenium TestNG automation test for Salesforce login.
//Use Page Object Model design pattern.
//Use SalesforceLoginPage class.
//Steps:
//1 Launch Chrome
//2 Navigate to Salesforce login page
//3 Enter username and password
//4 Click login button
//5 Close browser


public class SalesforceLoginTest {
	
	@Test
	public void salesforceLoginTest() {
		// Step 1: Launch Chrome
		WebDriver driver = new ChromeDriver();
		
		try {
			// Step 2: Navigate to Salesforce login page
			driver.get("https://login.salesforce.com/");
			
			// Step 3: Enter username and password
			SalesforceLoginPage loginPage = new SalesforceLoginPage(driver);
			loginPage.enterUsername("your_username");
			loginPage.enterPassword("your_password");
			
			// Step 4: Click login button
			loginPage.clickLogin();
			
			// Add assertions here to verify successful login if needed
			
		} finally {
			// Step 5: Close browser
			driver.quit();
		}
	}
	
}
