package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {
    private By emailField = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");
    private By successMessage = By.xpath("//*[contains(text(), " +
            " 'The instructions have been sent to your email address')]");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmailField(String value) {
        waitForElementToBeClickable(emailField);
        driver.findElement(emailField).sendKeys(value);
    }

    public void clickSubmitButton() {
        driver.findElement(retrievePasswordButton).click();
    }

    public boolean isSuccessResetMessagePresent() {
        return isElementVisible(successMessage);
    }
}
