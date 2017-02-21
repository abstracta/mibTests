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

import java.util.ArrayList;
import java.util.List;

import static classes.Utils.by;

/**
 * Created by USER on 13-Jan-17.
 */
public class ClientManagementGeneralTab extends CommonPageObject {
    @FindBy(id = "insurancePersonGrid") private WebElement insuredPersonalTable;
    @FindBy(xpath = ".//*[@id = 'insurancePersonGrid']/ancestor::rx-grid//a[@class = 'link-next']") private WebElement insuredNextButton;

    public ClientManagementGeneralTab(WebDriver driver) throws InterruptedException {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by(Locators.XPATH,".//li[@class = 'active']//*[text() = 'General']")));
        waitLoadingMessageBackEnd();
    }

    public String getInformationField(String field){
        return driver.findElement(By.xpath("//*[contains(text(), '"+field+"')]/ancestor::div[2]/following-sibling::div[1]//label")).getText();
    }

    public List<String> getInsuredPersonalContactDetailRow(int rowNumber){
        List<String> row = new ArrayList<>();
        List<WebElement> tableRows = insuredPersonalTable.findElements(By.tagName("tr"));
        WebElement rowTr = tableRows.get(rowNumber);
        List<WebElement> tableColumns = rowTr.findElements(By.tagName("td"));

        for (WebElement value : tableColumns) {
            row.add(value.getText());
        }

        if (rowNumber == 10){
            insuredNextButton.click();
        }
        return row;
    }
}
