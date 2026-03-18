package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import healing.HealDriver;

public class LoginPage {

    WebDriver driver;
    HealDriver healDriver;

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.cssSelector("button.radius");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.healDriver = new HealDriver(driver);
    }

    public void enterUsername(String user) {
        healDriver.findElement("usernameField", username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        healDriver.findElement("passwordField", password).sendKeys(pass);
    }

    public void clickLogin() {
        healDriver.findElement("loginButton", loginBtn).click();
    }

}