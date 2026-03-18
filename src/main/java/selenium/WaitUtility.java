package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 * Utility class providing explicit wait helper methods for Selenium WebDriver.
 * - waitFor: generic explicit wait using an ExpectedCondition
 * - waitForVisibility: wait until element located by a locator is visible
 * - waitForClickable: wait until element located by a locator is clickable
 *
 * Default timeouts are configurable via method arguments. This class is kept
 * small and dependency-free (uses Selenium WebDriver APIs).
 */
public class WaitUtility {

    private final WebDriver driver;

    public WaitUtility(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Generic explicit wait that waits until the provided ExpectedCondition is met.
     *
     * @param <T>       the expected condition return type
     * @param condition the ExpectedCondition to wait for
     * @param timeoutSec timeout in seconds
     * @param pollMillis poll interval in milliseconds
     * @return the condition's result when it is met
     */
    public <T> T waitFor(ExpectedCondition<T> condition, long timeoutSec, long pollMillis) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSec))
                .pollingEvery(Duration.ofMillis(pollMillis))
                .ignoring(Exception.class);

        return wait.until(condition);
    }

    /**
     * Waits until the element located by the given locator is visible.
     *
     * @param locator   locator for the element
     * @param timeoutSec timeout in seconds
     * @return the visible WebElement
     */
    public WebElement waitForVisibility(By locator, long timeoutSec) {
        return waitFor(ExpectedConditions.visibilityOfElementLocated(locator), timeoutSec, 500);
    }

    /**
     * Waits until the element located by the given locator is clickable.
     *
     * @param locator   locator for the element
     * @param timeoutSec timeout in seconds
     * @return the clickable WebElement
     */
    public WebElement waitForClickable(By locator, long timeoutSec) {
        return waitFor(ExpectedConditions.elementToBeClickable(locator), timeoutSec, 500);
    }
}
