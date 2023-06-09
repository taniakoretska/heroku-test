package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DigestAuthPage extends BasePage {
    private By errorMessage = By.xpath("//*[contains(text(), 'error message')]");

    public DigestAuthPage(WebDriver driver) {
        super(driver);
    }

    public boolean isErrorLoginMessagePresent() {
        return isElementVisible(errorMessage);
    }
}
