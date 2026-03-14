package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchChromeDriver {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test(priority = 1)
    public void testTitle() {
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertTrue(title.toLowerCase().contains("google"), "Title should contain 'Google'");
    }

    @Test(priority = 2)
    public void testSearchBoxPresent() {
        boolean present = driver.findElements(By.name("q")).size() > 0;
        System.out.println("its a demo of selenium framework integration in GITHUB");
        Assert.assertTrue(present, "Search box should be present on Google home page");
        System.out.println("its a demo of selenium framework integration in GITHUB");
     // Git test commit
        
    }

    @Test(priority = 3)
    public void testNavigateToAbout() {
        try {
            driver.findElement(By.linkText("About")).click();
        } catch (Exception e) {
            driver.get("https://about.google/");
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("about"), "Should navigate to an About page");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
