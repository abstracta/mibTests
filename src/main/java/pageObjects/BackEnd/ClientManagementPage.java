package pageObjects.BackEnd;

import classes.Enums.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CommonPageObject;

import static classes.Utils.by;

/**
 * Created by USER on 13-Jan-17.
 */
public class ClientManagementPage extends CommonPageObject {
    @FindBy(xpath = ".//input[@ng-model='client.trn']") private WebElement trnTextBox;
    @FindBy(xpath = ".//button[@ng-click='getSearchFilteredClients(client)']") private WebElement showButton;

    public ClientManagementPage(WebDriver driver) throws Exception {
        super(driver);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOf(showButton));
            waitLoadingMessageBackEnd();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public void findClientByTrn(String trn) throws Exception {
        try {
            Thread.sleep(1000);
            trnTextBox.sendKeys(trn);
            showButton.click();
            waitLoadingMessageBackEnd();
        }catch(Exception ex){
            throw new Exception("There is an error trying to find a client using the TRN code. Error : " + ex.getMessage());
        }
    }

    public void selectClientOnClientProfileList(String trn) throws Exception {
        try {
            Thread.sleep(1000);
            WebElement clientElement = driver.findElement(By.xpath(".//*[@id='clientProfileGrid']//td[2][contains(text(), '" + trn + "')]"));
            clientElement.click();
            waitLoadingMessageBackEnd();
        }catch(Exception ex){
            throw new Exception("There is an error trying to select client " + trn + " from profile list. Error : " + ex.getMessage());
        }
    }

    public ClientManagementGeneralTab selectPolicyFromPolicyDetails(String policyNumber) throws Exception {
        try {
            Thread.sleep(1000);
            WebElement policyElement = driver.findElement(By.xpath(".//*[@id='clientPolicyGrid']//*[contains(text(), '" + policyNumber + "')]"));
            policyElement.click();
            waitLoadingMessageBackEnd();
        }catch(Exception ex){
            throw new Exception("Error trying to select policy " + policyNumber + " from Policy Details. Error : " + ex.getMessage());
        }
        return new ClientManagementGeneralTab(driver);
    }
}
