package data;

import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "data-provider")
    public static Object[][] validEmailsData()
    {
        return new Object[][] { { "testautomationtest@yopmail.com" }, { "autotest@yopmail.com" } };
    }
}
