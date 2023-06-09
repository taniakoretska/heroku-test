package tests;

import org.testng.Assert;

import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class UITests extends BaseTest {
    @Test
    public void verifyExistingDataLogin() {
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        boolean isSuccessMessagePresent = confirmationPage.isSuccessLoginMessagePresent();
        Assert.assertTrue(isSuccessMessagePresent, "The successful login message is absent.");
    }

    @Test // This is the basic HTTP auth, so there's no error message when you click login, even if creds are wrong
    public void verifyInvalidDataLogin() {
        driver.navigate().to("https://mickey:mouse@the-internet.herokuapp.com/basic_auth");
        BaseAuthPage baseAuthPage = new BaseAuthPage(driver);
        boolean isErrorMessagePresent = baseAuthPage.isErrorLoginMessagePresent();
        Assert.assertFalse(isErrorMessagePresent, "No error message.");
    }

    @Test // similar situation to TC 2, there are no error messages in basic auth window
    public void verifyEmptyFieldsLogin() {
        driver.navigate().to("https://:@the-internet.herokuapp.com/digest_auth");
        DigestAuthPage digestAuthPage = new DigestAuthPage(driver);
        boolean isErrorMessagePresent = digestAuthPage.isErrorLoginMessagePresent();
        Assert.assertFalse(isErrorMessagePresent, "No error message.");
    }

    @Test // Bug - 500 Error (Internal Server Error)
    public void verifyForgotPasswordFunctionality() {
        driver.navigate().to("https://the-internet.herokuapp.com/");

        HomePage homePage = new HomePage(driver);

        ForgotPasswordPage forgotPasswordPage = homePage.openForgotPasswordPage();
        forgotPasswordPage.fillEmailField("testautomationtest@yopmail.com");
        forgotPasswordPage.clickSubmitButton();

        boolean isSuccessResetMessagePresent = forgotPasswordPage.isSuccessResetMessagePresent();

        Assert.assertTrue(isSuccessResetMessagePresent, "There is no success message.");
    }
}
