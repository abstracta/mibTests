package pageObjects.BackEnd;

import classes.Enums.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CommonPageObject;

import java.util.concurrent.TimeUnit;

import static classes.Utils.by;

/**
 * Created by USER on 13-Jan-17.
 */
public class BackEndHomePage extends CommonPageObject {
    @FindBy(xpath = ".//*[@id='sidebar']//span[contains(text(), 'Client Management')]") private WebElement clientManagementOption;

    public BackEndHomePage(WebDriver driver) throws InterruptedException {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by(Locators.CLASS_NAME, "nav-user-photo")));
        waitLoadingMessageBackEnd();
    }

    public void clickOnClientManagement() throws Exception {
        try {
            clientManagementOption.click();
        }catch(Exception ex){
            throw new Exception("There is an error trying to click on client management button. Error : " + ex.getMessage());
        }
    }
}
