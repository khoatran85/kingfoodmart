package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import models.global.Global_Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver;

    private void initDriver(String browserName){
        switch (browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Global_Constants.LONG_TIME, TimeUnit.SECONDS);
    }


    @BeforeTest(alwaysRun = true, description = "Init driver")
    @Parameters("browserName")
    public void beforeTest(String browserName){
        initDriver(browserName);
    }

 //   @AfterTest(alwaysRun = true)
    public void afterTest(){
    driver.quit();
    }

}
