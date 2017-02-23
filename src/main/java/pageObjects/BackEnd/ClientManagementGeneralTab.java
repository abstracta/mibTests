package pageObjects.BackEnd;

import classes.Enums.FieldType;
import classes.Enums.Locators;
import classes.Enums.Tables;
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
    @FindBy(id = "VehicleDetailGrid") private WebElement vehicleDetailTable;
    @FindBy(id = "PaymentGrid") private WebElement paymentTable;

    public ClientManagementGeneralTab(WebDriver driver) throws Exception {
        super(driver);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by(Locators.XPATH, ".//li[@class = 'active']//*[text() = 'General']")));
            waitLoadingMessageBackEnd();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public String getInformationField(String field) throws Exception {
        try {
            return driver.findElement(By.xpath("//*[contains(text(), '" + field + "')]/ancestor::div[2]/following-sibling::div[1]//label")).getText();
        }catch(Exception ex){
            throw new Exception("Error trying to get information from field " + field + " . Error : " + ex.getMessage());
        }
    }

    public WebElement getNextButtonFromTable(Tables table) throws Exception {
        try {
            String tableName = idFromTable(table);
            return driver.findElement(By.xpath(".//*[@id = '" + tableName + "']/ancestor::rx-grid//a[@class = 'link-next']"));
        }catch(Exception ex){
            throw new Exception("Error trying to click on next button from table " + table + " . Error : " + ex.getMessage());
        }
    }

    public String idFromTable(Tables table) throws Exception {
        String name = "";

        try {
            switch (table) {
                case PERSONAL_CONTACT_DETAIL:
                    name = "insurancePersonGrid";
                    break;
                case VEHICLE_DETAILS:
                    name = "VehicleDetailGrid";
                    break;
                case PAYMENT_HISTORY:
                    name = "PaymentGrid";
                    break;
            }
        }catch(Exception ex){
            throw new Exception("Error trying to obtain name from table " + table + " . Error : " + ex.getMessage());
        }
        return name;
    }

    public List<String> getInformationFromRow(Tables table, int rowNumber) throws Exception {
        List<String> row = new ArrayList<>();

        try {
            WebElement tableElement = null;

            switch (table) {
                case PERSONAL_CONTACT_DETAIL:
                    tableElement = insuredPersonalTable;
                    break;
                case VEHICLE_DETAILS:
                    tableElement = vehicleDetailTable;
                    break;
                case PAYMENT_HISTORY:
                    tableElement = paymentTable;
                    break;
            }

            List<WebElement> tableRows = tableElement.findElements(By.tagName("tr"));
            WebElement rowTr = tableRows.get(rowNumber);
            List<WebElement> tableColumns = rowTr.findElements(By.tagName("td"));

            for (WebElement value : tableColumns) {
                row.add(value.getText());
            }

            if (rowNumber == 10) {
                getNextButtonFromTable(table).click();
            }
        }catch(Exception ex){
            throw new Exception("Error trying to obtain information from table " + table + " . Error : " + ex.getMessage() );
        }
        return row;
    }

    public List<String> getCreditDebitNoteRow(String type) throws Exception {
        List<String> row = new ArrayList<>();

        try {
            row.add(type);
            WebElement eventName = driver.findElement(By.xpath(".//label[contains(text(), '" + type + "')]/ancestor::div[2]/following-sibling::div[1]//label"));
            row.add(eventName.getText());
            WebElement fileName = eventName.findElement(By.xpath("./ancestor::div[2]/following-sibling::div[1]//a"));
            row.add(fileName.getText());
        }catch(Exception ex){
            throw new Exception("Error trying to obtain information from note " + type + " . Error : "+ ex.getMessage());
        }

        return row;
    }
}
