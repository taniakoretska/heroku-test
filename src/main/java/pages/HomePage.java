package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By forgotPasswordLink = By.linkText("Forgot Password");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ForgotPasswordPage openForgotPasswordPage() {
        driver.findElement(forgotPasswordLink).click();
        return new ForgotPasswordPage(driver);
    }
}
