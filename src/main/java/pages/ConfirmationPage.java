package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage {
    private By successMessage = By.cssSelector("#content > div > p");

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessLoginMessagePresent() {
        return isElementVisible(successMessage);
    }
}
