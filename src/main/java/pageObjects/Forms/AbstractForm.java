package pageObjects.Forms;

import classes.Enums.FieldType;
import classes.Enums.IntendedUseVehicle;
import classes.Objects.FieldToComplete;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.AbstractPageObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by USER on 13-Jan-17.
 */
public class AbstractForm extends AbstractPageObject {
    AbstractChecksList checkLists;

    public AbstractForm(WebDriver driver){
        super(driver);
        checkLists = new AbstractChecksList(driver);
    }

    public void completeForm(List<FieldToComplete> list) throws Exception {
        try {
            for (FieldToComplete field : list){
                field.setWebElement(getField(field));
                field.completeField();
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

}
