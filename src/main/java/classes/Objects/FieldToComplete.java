package classes.Objects;

import classes.Enums.FieldType;
import org.openqa.selenium.WebElement;

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

    public void completeField(){
        if (fieldType != FieldType.CHECKBOX){
            webElement.sendKeys(value);
        }
        else{
            webElement.click();
        }
    }


}
