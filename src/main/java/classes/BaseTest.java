package classes;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by USER on 18-Jan-17.
 */
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({TestParameters.BROWSER, TestParameters.URL})
    protected void setUp(String browser, String url){
        switch (browser){
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "src/geckodriver.exe");
                FirefoxProfile profile = new FirefoxProfile();
                profile.setAcceptUntrustedCertificates(true);
                driver = new FirefoxDriver(profile);
                break;
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("chrome.switches","--disable-extensions");
                System.setProperty("webdriver.chrome.driver","src/chromedriver.exe");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
        }

        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown(){
        if(this.driver != null){
            driver.close();
            driver.quit();
        }
    }
}
