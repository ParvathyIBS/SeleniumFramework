package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {

       WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/login");

        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {

        loginPage.enterUsername("tomsmith");

        loginPage.enterPassword("SuperSecretPassword!");

        loginPage.clickLogin();

        System.out.println("Login test executed successfully");

    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

    }
}