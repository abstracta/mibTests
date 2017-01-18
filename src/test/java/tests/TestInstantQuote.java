package tests;

import classes.BaseTest;
import classes.Enums.FieldType;
import classes.Enums.IntendedUseVehicle;
import classes.Objects.FieldToComplete;
import org.testng.annotations.Test;
import pageObjects.Forms.InstantQuickQuote;
import pageObjects.HomePage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 18-Jan-17.
 */
public class TestInstantQuote extends BaseTest {

    @Test(description = "Create a Instant Quick Quote")
    public void test() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnQuickQuote();

        InstantQuickQuote quickQuote = new InstantQuickQuote(driver);
        List<FieldToComplete> fields = new ArrayList();
        List<IntendedUseVehicle> carFields = new ArrayList();

        fields.add(new FieldToComplete("Year of Manufacture", "2015", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("Make of the vehicle", "Acura", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("Model of the vehicle", "2.3CL", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("Value of the vehicle ", "3000000", FieldType.TEXTBOX   ));
        fields.add(new FieldToComplete("Is this vehicle left-hand or right-hand drive?", "Left Hand", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("Number of seats", "5", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("Does this vehicle have any performance modifications?", "true", FieldType.CHECKBOX));
        fields.add(new FieldToComplete("Select the type of policy you require", "Third Party", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("Is this vehicle currently insured?", "false", FieldType.CHECKBOX));
        fields.add(new FieldToComplete("Will your cover be open or restricted?", "Insured +2", FieldType.SELECT_FIELD));

        carFields.add(IntendedUseVehicle.SOCIAL_AND_DOMESTIC);
        carFields.add(IntendedUseVehicle.CONNECTION_WITH_BUSINESS);

        quickQuote.completeFormStepOne(fields, carFields);
    }
}
