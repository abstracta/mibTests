package pageObjects.BackEnd;

import classes.Enums.FieldType;
import classes.Enums.Locators;
import classes.Objects.FieldToComplete;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CommonPageObject;
import pageObjects.DatePickerPageObject;

import java.util.List;

import static classes.Utils.by;

/**
 * Created by USER on 13-Jan-17.
 */
public class ClientManagementGeneralTab extends CommonPageObject {

    public ClientManagementGeneralTab(WebDriver driver) throws InterruptedException {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by(Locators.XPATH,".//li[@class = 'active']//*[text() = 'General']")));
        waitLoadingMessageBackEnd();
    }

    public String getInformationField(String field){
        return driver.findElement(By.xpath("//*[contains(text(), '"+field+"')]/ancestor::div[@class = 'row bordered']//div[2]//label")).getText();
    }
}
