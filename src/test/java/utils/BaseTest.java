package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void launchSite(@Optional("chrome") String browser) {

        switch (browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                driver = new EdgeDriver();
                driver.manage().window().maximize();
            default:
                break;
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
