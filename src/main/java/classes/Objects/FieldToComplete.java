package classes.Objects;

import classes.Enums.FieldType;
import javafx.scene.control.DatePicker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import pageObjects.DatePickerPageObject;

import java.util.List;

/**
 * Created by USER on 18-Jan-17.
 */
public class FieldToComplete {
    private String fieldName;
    private String value;
    private FieldType fieldType;
    private WebElement webElement;

    public FieldToComplete(String fieldName, String value, FieldType fieldType){
        this.fieldName = fieldName;
        this.value = value;
        this.fieldType = fieldType;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getValue() {
        return value;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void completeField(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);

        switch (fieldType){
            case CHECKBOX:
                webElement.click();
                break;
            case DATEPICKER:
                ((JavascriptExecutor)driver).executeScript("document.evaluate(\"//*[contains(text(), '"+getFieldName()+"')]/ancestor::div[@class = 'fieldbox']//input\" ,document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click()");
                break;
            default:
                webElement.sendKeys(value);
                break;
        }
    }


}
