package pageObjects;

import classes.Enums.Locators;
import classes.Objects.FieldToComplete;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Forms.CommonForm;

import java.util.concurrent.TimeUnit;

import static classes.Utils.by;

/**
 * Created by USER on 13-Jan-17.
 */
public class CommonPageObject {
    @FindBy(xpath = ".//*[contains(text(), 'Next')]") public WebElement nextButton;
    @FindBy(xpath = ".//*[contains(text(), 'Submit')]") public WebElement submitButton;

    protected final WebDriver driver;
    private CommonForm formsObjects;

    public CommonPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFieldXpath(FieldToComplete fieldToComplete) throws Exception {
        String xpath = "//*[contains(text(), '" + fieldToComplete.getFieldName() + "')]/ancestor::div[@class = 'fieldbox']";

        try {
            switch (fieldToComplete.getFieldType()) {
                case TEXTBOX:
                    xpath = xpath + "//input";
                    break;
                case SELECT_FIELD:
                    xpath = xpath + "//select";
                    break;
                case CHECKBOX:
                    String otherValue = "";

                    if (fieldToComplete.getValue().equals("false"))
                        otherValue = "No";
                    else
                        otherValue = "Yes";

                    xpath = xpath + "//input[@value = '" + getValueForRadioButton(fieldToComplete.getValue()) + "' or @value = '" + otherValue + "']";
                    break;
            }
        }catch(Exception ex){
            throw new Exception("Error trying to get the field " + fieldToComplete.getFieldName() + " . Error : " + ex.getMessage());
        }

        return xpath;
    }

    public WebElement findElement(Locators locator, String identificator) throws Exception {
        try {
            return driver.findElement(by(locator, identificator));
        }catch(Exception ex){
            throw new Exception("There is an error trying to find an the element " + identificator + " .Error : " + ex.getMessage());
        }
    }

    public WebElement getField(FieldToComplete fieldToComplete) throws Exception {
        try {
            return findElement(Locators.XPATH, getFieldXpath(fieldToComplete));
        }catch(Exception ex){
            throw new Exception("There is an error finding the field. Error : " + ex.getMessage());
        }
    }

    public CommonForm getAbstractFormInstance() {
        if (formsObjects != null){
            return formsObjects;
        }else{
            return new CommonForm(driver);
        }
    }

    public String getValueForRadioButton(String value) throws Exception {
        String valueOutput = "";

        try {
            if (value.equals("true") || value.equals("false")) {
                valueOutput = value;
            } else {
                switch (value) {
                    case "Male":
                        valueOutput = "2468";
                        break;
                    case "Female":
                        valueOutput = "2469";
                        break;
                }
            }
        }catch(Exception ex){
            throw new Exception("There is an error trying to get value from a radio button " + value + " . Error : " + ex.getMessage());
        }

        return valueOutput;
    }

    public void waitLoadingMessage() throws Exception {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by(Locators.ID, "loadImage")));
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }catch(Exception ex){
            throw new Exception("Problem waiting the loading message dissapeared. Error : " + ex.getMessage());
        }
    }

    public void waitLoadingMessageBackEnd() throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by(Locators.XPATH, ".//*[@id='rxload']//img")));
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Thread.sleep(1000);
        }catch(Exception ex){
            throw new Exception("Problem waiting the loading message in back-end dissapeared. Error : " + ex.getMessage());
        }
    }

}
