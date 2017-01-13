package pageObjects.Forms;

import classes.Enums.IntendedUseVehicle;
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

    public void completeFormStepOne(Map<String, String> informationForFields, List<IntendedUseVehicle> vehicleIntentededUse) throws Exception {
        getAbstractFormInstance().completeForm(informationForFields);
        getAbstractFormInstance().selectCheckboxesForIntendedUse(vehicleIntentededUse);
        //toDo: Falta seleccionar YES/NO en las opciones. Buscar algo generico para buscar una pregunta y seleccionar YES o NO. XPATH!
    }
}
