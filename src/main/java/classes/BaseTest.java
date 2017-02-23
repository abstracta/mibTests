package classes;

import classes.Enums.TestParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Created by USER on 18-Jan-17.
 */
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({TestParameters.BROWSER})
    protected void setUp(String browser) throws Exception {
        try {
            switch (browser) {
                case "Firefox":
                    System.setProperty("webdriver.gecko.driver", "src/geckodriver.exe");
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setAcceptUntrustedCertificates(true);
                    driver = new FirefoxDriver(profile);
                    break;
                case "Chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("chrome.switches", "--disable-extensions");
                    System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
                    driver = new ChromeDriver(options);
                    break;
            }

            driver.manage().window().maximize();
        }catch(Exception ex){
            throw new Exception("Error trying to open the browser " + browser + " . Error : " + ex.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() throws Exception {
        try {
            if (this.driver != null) {
                driver.close();
                driver.quit();
            }
        }catch(Exception ex){
            throw new Exception("Error trying to close browser. Error : " + ex.getMessage());
        }
    }
}
