package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesforceLoginPage {

    WebDriver driver;
 // Page Object Model for Salesforce login page
 // elements: username field, password field, login button
 // create locators using By.id, By.name, By.cssSelector, etc.

	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("Login");

	public SalesforceLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}

	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}

	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}

}