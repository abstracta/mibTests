package pageObjects.Forms;

import classes.Enums.IntendedUseVehicle;
import classes.Objects.FieldToComplete;
import org.openqa.selenium.WebDriver;
import pageObjects.AbstractPageObject;

import java.util.List;
import java.util.Map;

/**
 * Created by USER on 13-Jan-17.
 */
public class InstantQuickQuote extends AbstractPageObject{
    public InstantQuickQuote(WebDriver driver){
        super(driver);
    }

    public void completeFormStepOne(List<FieldToComplete> informationForFields, List<IntendedUseVehicle> vehicleIntentededUse) throws Exception {
        getAbstractFormInstance().completeForm(informationForFields);
        getAbstractFormInstance().selectCheckboxesForIntendedUse(vehicleIntentededUse);
        //toDo : Siguiente y siguiente FORM
    }
}
