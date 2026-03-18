package healing;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HealDriver {

    private WebDriver driver;

    public HealDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(String elementName, By locator) {

        try {
            System.out.println("Trying original locator for: " + elementName);

            WebElement element = driver.findElement(locator);

            ElementMetadata metadata = new ElementMetadata(
                    elementName,
                    element.getTagName(),
                    element.getText(),
                    element.getAttribute("id"),
                    element.getAttribute("class")
            );

            LocatorStore.save(elementName, metadata);

            System.out.println("Original locator worked for: " + elementName);

            return element;

        } catch (NoSuchElementException e) {
            System.out.println("Original locator failed for: " + elementName);

            By healedLocator = LocatorHealer.heal(driver, elementName);

            System.out.println("Using healed locator for: " + elementName + " -> " + healedLocator);

            return driver.findElement(healedLocator);
        }
    }
}