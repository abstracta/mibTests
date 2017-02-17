package pageObjects.FrontEnd;

import classes.Enums.IntendedUseVehicle;
import classes.Objects.FieldToComplete;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.CommonPageObject;

import java.util.List;

/**
 * Created by USER on 13-Jan-17.
 */
public class QuickQuotePageObject extends CommonPageObject {
    @FindBy(xpath = ".//*[@id='myMessage']//h2[contains(text(), 'Your Lowest Quote is')]") public WebElement lowestQuote;

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

    public boolean lowestPriceIsDisplayed(){
        try {
            waitLoadingMessage();
            return lowestQuote.isDisplayed();
        }catch(Exception ex){
            return false;
        }
    }
}
