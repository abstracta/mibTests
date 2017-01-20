package pageObjects;

import classes.Enums.IntendedUseVehicle;
import classes.Objects.FieldToComplete;
import org.openqa.selenium.WebDriver;
import pageObjects.CommonPageObject;

import java.util.List;

/**
 * Created by USER on 13-Jan-17.
 */
public class QuickQuotePageObject extends CommonPageObject {
    public QuickQuotePageObject(WebDriver driver){
        super(driver);
    }

    public void completeFormStepOne(List<FieldToComplete> informationForFields, List<IntendedUseVehicle> vehicleIntentededUse) throws Exception {
        getAbstractFormInstance().completeForm(informationForFields);
        getAbstractFormInstance().selectCheckboxesForIntendedUse(vehicleIntentededUse);
        getAbstractFormInstance().goToNextForm();
    }

    public void completeFormStepTwo(List<FieldToComplete> informationForFields) throws Exception {
        getAbstractFormInstance().completeForm(informationForFields);
        getAbstractFormInstance().goToNextForm();
    }

    public void completeFormStepThree(List<FieldToComplete> informationForFields) throws Exception {
        getAbstractFormInstance().completeForm(informationForFields);
        getAbstractFormInstance().clickOnSubmit();
    }
}
