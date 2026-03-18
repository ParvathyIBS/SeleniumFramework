package healing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHealer {

    public static By heal(WebDriver driver, String elementName) {

        ElementMetadata oldMeta = LocatorStore.get(elementName);

        if (oldMeta == null) {
            throw new RuntimeException("No metadata found for element: " + elementName);
        }

        List<WebElement> allElements = driver.findElements(By.xpath("//*"));

        WebElement bestMatch = null;
        int bestScore = -1;

        for (WebElement element : allElements) {

            int score = 0;

            String currentTag = safe(element.getTagName());
            String currentText = safe(element.getText());
            String currentId = safe(element.getAttribute("id"));
            String currentClass = safe(element.getAttribute("class"));

            if (currentTag.equalsIgnoreCase(safe(oldMeta.getTagName()))) {
                score += 20;
            }

            if (!safe(oldMeta.getText()).isEmpty() && currentText.equalsIgnoreCase(safe(oldMeta.getText()))) {
                score += 40;
            }

            if (!safe(oldMeta.getClassName()).isEmpty() && currentClass.equalsIgnoreCase(safe(oldMeta.getClassName()))) {
                score += 20;
            }

            if (!safe(oldMeta.getId()).isEmpty() && currentId.contains(removeSpecialPart(safe(oldMeta.getId())))) {
                score += 20;
            }

            if (score > bestScore) {
                bestScore = score;
                bestMatch = element;
            }
        }

        if (bestMatch != null) {

            String healedId = safe(bestMatch.getAttribute("id"));

            if (!healedId.isEmpty()) {
                System.out.println("Healed by ID: " + healedId);
                return By.id(healedId);
            }

            String healedText = safe(bestMatch.getText());

            if (!healedText.isEmpty()) {
                System.out.println("Healed by TEXT: " + healedText);
                return By.xpath("//*[text()='" + healedText + "']");
            }
        }

        throw new RuntimeException("Unable to heal locator for element: " + elementName);
    }

    private static String safe(String value) {
        return value == null ? "" : value.trim();
    }

    private static String removeSpecialPart(String id) {
        return id.replace("Btn", "").replace("-", "").toLowerCase();
    }
}