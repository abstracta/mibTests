package tests;

import classes.BaseTest;
import classes.Enums.FieldType;
import classes.Enums.IntendedUseVehicle;
import classes.Objects.FieldToComplete;
import org.testng.annotations.Test;
import pageObjects.QuickQuotePageObject;
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

        QuickQuotePageObject quickQuote = new QuickQuotePageObject(driver);
        List<FieldToComplete> fields = new ArrayList();
        List<IntendedUseVehicle> carFields = new ArrayList();

        // FORM NUMBER 1 //
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
        fields.clear();
        carFields.clear();

        // FORM NUMBER 2 //
        fields.add(new FieldToComplete("First name", "Automation", FieldType.TEXTBOX));
        fields.add(new FieldToComplete("Last name", "Testing", FieldType.TEXTBOX));
        fields.add(new FieldToComplete("Gender of Insured", "Male", FieldType.CHECKBOX));
        fields.add(new FieldToComplete("Date of Birth of Insured", "Dec/18/1990", FieldType.DATEPICKER));
        fields.add(new FieldToComplete("Do you possess a valid driver", "true", FieldType.CHECKBOX));
        fields.add(new FieldToComplete("Date insured was first issued a driver", "Oct/8/2015", FieldType.DATEPICKER));
        fields.add(new FieldToComplete("Issuing country of driver", "JAMAICA", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("Occupation", "Accountant", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("Employment Status", "Employed", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("Have you had any motor accidents or claims?", "None at all", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("parish of residence", "ST.ANN", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("Select Community", "Aboukir", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("Are you a full-time Government Employee?", "false", FieldType.CHECKBOX));
        fields.add(new FieldToComplete("Are you the sole owner of this vehicle?", "true", FieldType.CHECKBOX));
        fields.add(new FieldToComplete("Would you like to add a driver?", "false", FieldType.CHECKBOX));

        quickQuote.completeFormStepTwo(fields);
        fields.clear();
        carFields.clear();

        // FORM NUMBER 3 //
        fields.add(new FieldToComplete("Is a tracking device installed on this vehicle?", "true", FieldType.CHECKBOX));
        fields.add(new FieldToComplete("How many years of NCD do you currently enjoy?", "0", FieldType.SELECT_FIELD));
        fields.add(new FieldToComplete("Do you have valuation/proforma invoice for this vehicle?", "true", FieldType.CHECKBOX));
        fields.add(new FieldToComplete("Do you have a homeowner", "false", FieldType.CHECKBOX));
        fields.add(new FieldToComplete("Do you have another motor insurance policy?", "false", FieldType.CHECKBOX));

        quickQuote.completeFormStepThree(fields);
        fields.clear();
        carFields.clear();
    }
}
