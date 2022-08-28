package models.pages;

import base.BaseTest;
import models.global.Global_Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Dashboard extends BaseTest {

    private WebDriver driver;
    Dashboard dashboard;

    @Test
    public void openDashboard(){
        driver = getDriver();
        driver.get(Global_Constants.URL);
    }
}
