package pageObjects.Forms;

import classes.Enums.IntendedUseVehicle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.AbstractPageObject;

/**
 * Created by USER on 18-Jan-17.
 */
public class AbstractChecksList extends AbstractPageObject {

    // All the checkboxes for "Intended use of the vehicle"
    @FindBy(xpath = ".//input[@ng-true-value = '2458']") private WebElement intendedUseSocialAndDomestic;
    @FindBy(xpath = ".//input[@ng-true-value = '2459']") private WebElement intendedUseMotorAndRallies;
    @FindBy(xpath = ".//input[@ng-true-value = '2460']") private WebElement intendedUseCarriageOwnGoods;
    @FindBy(xpath = ".//input[@ng-true-value = '2461']") private WebElement intendedUseHireOrReward;
    @FindBy(xpath = ".//input[@ng-true-value = '2462']") private WebElement intendedUseEmployees;
    @FindBy(xpath = ".//input[@ng-true-value = '10670']") private WebElement intendedUseLearnToDrive;
    @FindBy(xpath = ".//input[@ng-true-value = '11752']") private WebElement intendedUseConnectionBusiness;
    @FindBy(xpath = ".//input[@ng-true-value = '14011']") private WebElement intendedUseEmployersBusiness;
    @FindBy(xpath = ".//input[@ng-true-value = '16381']") private WebElement intendedUseFlammable;
    @FindBy(xpath = ".//input[@ng-true-value = '16382']") private WebElement intendedUseEmergency;

    public AbstractChecksList(WebDriver driver){
        super(driver);
    }

    public void checkIntendedUse(IntendedUseVehicle field) throws Exception {
        try{
            WebElement checkbox = null;

            switch(field) {
                case SOCIAL_AND_DOMESTIC:
                    checkbox = intendedUseSocialAndDomestic;
                    break;
                case MOTOR_RACING_TRAILS_AND_RALLIES:
                    checkbox = intendedUseMotorAndRallies;
                    break;
                case CARRIAGE_OWN_GOODS:
                    checkbox = intendedUseCarriageOwnGoods;
                    break;
                case HIRE_OR_REWARD:
                    checkbox = intendedUseHireOrReward;
                    break;
                case EMPLOYEES:
                    checkbox = intendedUseEmployees;
                    break;
                case LEARN_TO_DRIVE:
                    checkbox = intendedUseLearnToDrive;
                    break;
                case CONNECTION_WITH_BUSINESS:
                    checkbox = intendedUseConnectionBusiness;
                    break;
                case EMPLOYERS_BUSINESS:
                    checkbox = intendedUseEmployersBusiness;
                    break;
                case FLAMMABLE_EXPLOSIVE_SUBSTANCES:
                    checkbox = intendedUseFlammable;
                    break;
                case EMERGENCY_SERVICE:
                    checkbox = intendedUseEmergency;
                    break;
            }

            checkbox.click();
        }catch(Exception ex){
            throw new Exception("There is an error checking the box '" + field + "' : " + ex.getMessage());
        }
    }
}
