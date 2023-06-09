package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseAuthPage extends BasePage {
    private By errorMessage = By.xpath("//*[contains(text(), 'error message')]");

    public BaseAuthPage(WebDriver driver) {
        super(driver);
    }

    public boolean isErrorLoginMessagePresent() {
        return isElementVisible(errorMessage);
    }
}