package pageObjects;

import classes.Enums.FieldType;
import classes.Enums.Locators;
import classes.Objects.FieldToComplete;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Forms.AbstractForm;

import static classes.Utils.by;

/**
 * Created by USER on 13-Jan-17.
 */
public class AbstractPageObject {
    protected final WebDriver driver;
    private AbstractForm formsObjects;

    public AbstractPageObject(WebDriver driver){
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
                xpath = xpath + "//input[@value = '"+fieldToComplete.getValue()+"']";
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

    public AbstractForm getAbstractFormInstance()
    {
        if (formsObjects != null){
            return formsObjects;
        }else{
            return new AbstractForm(driver);
        }
    }
}
