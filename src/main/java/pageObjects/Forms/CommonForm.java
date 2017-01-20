package pageObjects.Forms;

import classes.Enums.FieldType;
import classes.Enums.IntendedUseVehicle;
import classes.Objects.FieldToComplete;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.CommonPageObject;
import pageObjects.DatePickerPageObject;

import java.util.Iterator;
import java.util.List;

/**
 * Created by USER on 13-Jan-17.
 */
public class CommonForm extends CommonPageObject {
    CommonChecksList checkLists;

    public CommonForm(WebDriver driver){
        super(driver);
        checkLists = new CommonChecksList(driver);
    }

    public void completeForm(List<FieldToComplete> list) throws Exception {
        try {
            for (FieldToComplete field : list){
                waitLoadingMessage();
                field.setWebElement(getField(field));
                field.completeField(driver);
                if (field.getFieldType() == FieldType.DATEPICKER){
                    DatePickerPageObject datePicker = new DatePickerPageObject(driver);
                    String[] dateInformation = field.getValue().split("/");
                    datePicker.clickYear(dateInformation[2]);
                    datePicker.clickMonth(dateInformation[0]);
                    datePicker.clickDay(dateInformation[1]);
                }
            }
        }catch(Exception ex){
            throw new Exception("There is an error completing the form : " + ex.getMessage());
        }
    }

    public void selectCheckboxesForIntendedUse(List<IntendedUseVehicle> list) throws Exception {
        try{
            Iterator<IntendedUseVehicle> iterator = list.iterator();
            while(iterator.hasNext()){
                checkLists.checkIntendedUse(iterator.next());
            }
        }catch(Exception ex){
            throw new Exception("There is an error completing the checkboxes on the form : " + ex.getMessage());
        }
    }

    public void goToNextForm() throws Exception {
        try{
            nextButton.click();
            waitLoadingMessage();
        }catch(Exception ex){
            throw new Exception("There is an error clicking on Next Button : " + ex.getMessage());
        }
    }

    public void clickOnSubmit() throws Exception {
        try{
            submitButton.click();
            waitLoadingMessage();
        }catch(Exception ex){
            throw new Exception("There is an error clicking on submit Button : " + ex.getMessage());
        }
    }

}
