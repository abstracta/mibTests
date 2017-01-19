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

    protected final WebDriver driver;
    private CommonForm formsObjects;

    public CommonPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFieldXpath(FieldToComplete fieldToComplete){
        String xpath = "//*[contains(text(), '"+fieldToComplete.getFieldName()+"')]/ancestor::div[@class = 'fieldbox']";
        switch (fieldToComplete.getFieldType()){
            case TEXTBOX:
                xpath = xpath + "//input";
                break;
            case SELECT_FIELD:
                xpath = xpath + "//select";
                break;
            case CHECKBOX:
                xpath = xpath + "//input[@value = '"+getValueForRadioButton(fieldToComplete.getValue())+"']";
                break;
        }

        return xpath;
    }

    public WebElement findElement(Locators locator, String identificator) throws Exception {
        return driver.findElement(by(locator, identificator));
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

    public String getValueForRadioButton(String value){
        String valueOutput = "";

        if (value.equals("true") || value.equals("false")) {
            valueOutput = value;
        }else{
            switch(value){
                case "Male":
                    valueOutput = "2468";
                    break;
                case "Female":
                    valueOutput = "2469";
                    break;
            }
        }

        return valueOutput;
    }

    public void waitLoadingMessage(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by(Locators.ID, "loadImage")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
