package tests;

import classes.BaseTest;
import classes.Objects.FieldToComplete;
import classes.Utils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import junit.framework.Assert;
import org.testng.annotations.Test;
import pageObjects.BackEnd.BackEndHomePage;
import pageObjects.BackEnd.BackEndLoginPage;
import pageObjects.BackEnd.ClientManagementGeneralTab;
import pageObjects.BackEnd.ClientManagementPage;

import java.util.List;

/**
 * Created by USER on 18-Jan-17.
 */
public class TestBackEnd extends BaseTest {

    @Test(description = "Create an Instant Quick Quote")
    public void test() throws Exception {
        BackEndLoginPage loginPage = new BackEndLoginPage(driver);
        loginPage.login("SuperAdmin", "An%!Sm@4(Vm9");

        BackEndHomePage homePage = new BackEndHomePage(driver);
        homePage.clickOnClientManagement();

        ClientManagementPage clientManagementPage = new ClientManagementPage(driver);
        clientManagementPage.findClientByTrn("874-365-413");
        clientManagementPage.selectClientOnClientProfileList("874-365-413");
        clientManagementPage.selectPolicyFromPolicyDetails("PLCY-NYHZWOVL15");

        ClientManagementGeneralTab generalTab = new ClientManagementGeneralTab(driver);

        // This JSON is to simulate a database
        Utils utils = new Utils();
        JsonObject database = utils.readJsonFromResources("generalTabDataBase.json");

        //Policy Details
        Assert.assertTrue("Error in 'Policy Start Date' field", (generalTab.getInformationField("Policy Start Date").equals(database.get("Policy Start Date").getAsString())));
        Assert.assertTrue("Error in 'Policy Status' field", (generalTab.getInformationField("Policy Status").equals(database.get("Policy Status").getAsString())));
        Assert.assertTrue("Error in 'Issuing Company' field", (generalTab.getInformationField("Issuing Company").equals(database.get("Issuing Company").getAsString())));
        Assert.assertTrue("Error in 'Date of Birth' field", (generalTab.getInformationField("Date of Birth").equals(database.get("Date of Birth").getAsString())));
        Assert.assertTrue("Error in 'Taxpayer Registration Number' field", (generalTab.getInformationField("Taxpayer Registration Number").equals(database.get("Taxpayer Registration Number").getAsString())));
        Assert.assertTrue("Error in 'Policy Start time' field", (generalTab.getInformationField("Policy Start time").equals(database.get("Policy Start time").getAsString())));
        Assert.assertTrue("Error in 'Cover Type", (generalTab.getInformationField("Cover Type").equals(database.get("Cover Type").getAsString())));
        Assert.assertTrue("Error in 'Proposer Name' field", (generalTab.getInformationField("Proposer Name").equals(database.get("Proposer Name").getAsString())));
        Assert.assertTrue("Error in 'Policy Number' field", (generalTab.getInformationField("Policy Number").equals(database.get("Policy Number").getAsString())));

        //Proposer Contact Details
        Assert.assertTrue("Error in 'Address Residential' field", (generalTab.getInformationField("Address Residential").equals(database.get("Address Residential").getAsString())));
        Assert.assertTrue("Error in 'Parish' field", (generalTab.getInformationField("Parish").equals(database.get("Parish").getAsString())));
        Assert.assertTrue("Error in 'Contact Number Home' field", (generalTab.getInformationField("Contact Number Home").equals(database.get("Contact Number Home").getAsString())));
        Assert.assertTrue("Error in 'Contact Number Mobile' field", (generalTab.getInformationField("Contact Number Mobile").equals(database.get("Contact Number Mobile").getAsString())));
        Assert.assertTrue("Error in 'Address Work' field", (generalTab.getInformationField("Address Work").equals(database.get("Address Work").getAsString())));
        Assert.assertTrue("Error in 'Parish' field", (generalTab.getInformationField("Parish").equals(database.get("Parish").getAsString())));
        Assert.assertTrue("Error in 'Contact Number Work' field", (generalTab.getInformationField("Contact Number Work").equals(database.get("Contact Number Work").getAsString())));

        //Insured Personal & Contact Detail
        JsonElement listInsuredPersonal = database.get("Insured Personal & Contact Detail");

        for (int i = 0; i < listInsuredPersonal.getAsJsonArray().size(); i++) {
            JsonObject personalInsured = listInsuredPersonal.getAsJsonArray().get(i).getAsJsonObject();
            List<String> information = generalTab.getInsuredPersonalContactDetailRow(personalInsured.get("rowNumber").getAsInt());

            Assert.assertTrue("Error in 'Insured Name' Field in row '"+ personalInsured.get("rowNumber") + "' of Insured Personal & Contact Detail table", information.get(0).equals(personalInsured.get("Insured Name").getAsString()));
            Assert.assertTrue("Error in 'Date of Birth' Field in row '"+ personalInsured.get("rowNumber") + "' of Insured Personal & Contact Detail table", information.get(1).equals(personalInsured.get("Date Of Birth").getAsString()));
            Assert.assertTrue("Error in 'Gender' Field in row '"+ personalInsured.get("rowNumber") + "' of Insured Personal & Contact Detail table", information.get(2).equals(personalInsured.get("Gender").getAsString()));
            Assert.assertTrue("Error in 'TRN' Field in row '"+ personalInsured.get("rowNumber") + "' of Insured Personal & Contact Detail table", information.get(3).equals(personalInsured.get("TRN").getAsString()));
        }

        //Vehicle Details
        // Validacion de la tabla fila por fila

        //Payment
        Assert.assertTrue("Error in 'Source of funds' field", (generalTab.getInformationField("Source of funds").equals(database.get("Source of funds").getAsString())));
        Assert.assertTrue("Error in 'Premium Amount' field", (generalTab.getInformationField("Premium Amount").equals(database.get("Premium Amount").getAsString())));
        Assert.assertTrue("Error in 'Next payment date' field", (generalTab.getInformationField("Next payment date").equals(database.get("Next payment date").getAsString())));
        Assert.assertTrue("Error in 'Is Finance' field", (generalTab.getInformationField("Is Finance").equals(database.get("Is Finance").getAsString())));
        Assert.assertTrue("Error in 'Type of Plan' field", (generalTab.getInformationField("Type of Plan").equals(database.get("Type of Plan").getAsString())));

        ///Payment History
        // Validacion de la tabla fila por fila

        //Benefits Details
        Assert.assertTrue("Error in 'Excess' field", (generalTab.getInformationField("Excess").equals(database.get("Excess").getAsString())));
        Assert.assertTrue("Error in 'Loss of Use' field", (generalTab.getInformationField("Loss of Use").equals(database.get("Loss of Use").getAsString())));
        Assert.assertTrue("Error in 'Wrecker Fees' field", (generalTab.getInformationField("Wrecker Fees").equals(database.get("Wrecker Fees").getAsString())));
        Assert.assertTrue("Error in 'Roadside Assistance' field", (generalTab.getInformationField("Roadside Assistance").equals(database.get("Roadside Assistance").getAsString())));
        Assert.assertTrue("Error in 'Uninsured Motorist Coverage' field", (generalTab.getInformationField("Uninsured Motorist Coverage").equals(database.get("Uninsured Motorist Coverage").getAsString())));
        Assert.assertTrue("Error in 'Comprehensive Plus' field", (generalTab.getInformationField("Comprehensive Plus").equals(database.get("Comprehensive Plus").getAsString())));
        Assert.assertTrue("Error in 'Personal accidents' field", (generalTab.getInformationField("Personal accidents").equals(database.get("Personal accidents").getAsString())));
        Assert.assertTrue("Error in 'Act of God' field", (generalTab.getInformationField("Act of God").equals(database.get("Act of God").getAsString())));
        Assert.assertTrue("Error in 'Personal effects' field", (generalTab.getInformationField("Personal effects").equals(database.get("Personal effects").getAsString())));
        Assert.assertTrue("Error in 'Assist- Accident scene and Breakdown assistance' field", (generalTab.getInformationField("Assist- Accident scene and Breakdown assistance").equals(database.get("Assist- Accident scene and Breakdown assistance").getAsString())));
        Assert.assertTrue("Error in 'Free Annual Valuation' field", (generalTab.getInformationField("Free Annual Valuation").equals(database.get("Free Annual Valuation").getAsString())));
        Assert.assertTrue("Error in 'Windscreen' field", (generalTab.getInformationField("Windscreen").equals(database.get("Windscreen").getAsString())));
        Assert.assertTrue("Error in 'Fire Damage to Garage' field", (generalTab.getInformationField("Fire Damage to Garage").equals(database.get("Fire Damage to Garage").getAsString())));
        Assert.assertTrue("Error in 'Theft Cover' field", (generalTab.getInformationField("Theft Cover").equals(database.get("Theft Cover").getAsString())));
        Assert.assertTrue("Error in 'Indemnity whilst in hand of Motor Trader' field", (generalTab.getInformationField("Indemnity whilst in hand of Motor Trader").equals(database.get("Indemnity whilst in hand of Motor Trader").getAsString())));
        Assert.assertTrue("Error in 'Motor Trade coverage' field", (generalTab.getInformationField("Motor Trade coverage").equals(database.get("Motor Trade coverage").getAsString())));
        Assert.assertTrue("Error in 'Infant Seat Replacement' field", (generalTab.getInformationField("Infant Seat Replacement").equals(database.get("Infant Seat Replacement").getAsString())));
        Assert.assertTrue("Error in 'Key Replacement' field", (generalTab.getInformationField("Key Replacement").equals(database.get("Key Replacement").getAsString())));
        Assert.assertTrue("Error in 'Limits of Liability' field", (generalTab.getInformationField("Limits of Liability").equals(database.get("Limits of Liability").getAsString())));
        Assert.assertTrue("Error in 'Personal accidents rider' field", (generalTab.getInformationField("rider").equals(database.get("Personal accidents rider").getAsString())));
        Assert.assertTrue("Error in 'Manslaughter' field", (generalTab.getInformationField("Manslaughter").equals(database.get("Manslaughter").getAsString())));
        Assert.assertTrue("Error in 'Windscreen Damage' field", (generalTab.getInformationField("Windscreen Damage").equals(database.get("Windscreen Damage").getAsString())));
        Assert.assertTrue("Error in 'Accident Forgiveness' field", (generalTab.getInformationField("Accident Forgiveness").equals(database.get("Accident Forgiveness").getAsString())));
        Assert.assertTrue("Error in 'Flood, Hurricane, Earthquake, Riot, Strike & Civil commotion' field", (generalTab.getInformationField("Flood, Hurricane, Earthquake, Riot, Strike & Civil commotion").equals(database.get("Flood, Hurricane, Earthquake, Riot, Strike & Civil commotion").getAsString())));
        Assert.assertTrue("Error in 'ThirdParty Plus' field", (generalTab.getInformationField("ThirdParty Plus").equals(database.get("ThirdParty Plus").getAsString())));
        Assert.assertTrue("Error in 'Medical expenses' field", (generalTab.getInformationField("Medical expenses").equals(database.get("Medical expenses").getAsString())));
        Assert.assertTrue("Error in 'Advantage 24/7' field", (generalTab.getInformationField("Advantage 24/7").equals(database.get("Advantage 24/7").getAsString())));
        Assert.assertTrue("Error in 'Passenger Negligence and Passenger liability' field", (generalTab.getInformationField("Passenger Negligence and Passenger liability").equals(database.get("Passenger Negligence and Passenger liability").getAsString())));
        Assert.assertTrue("Error in 'Protected No Claim Discount' field", (generalTab.getInformationField("Protected No Claim Discount").equals(database.get("Protected No Claim Discount").getAsString())));
        Assert.assertTrue("Error in 'Authorized repair limit' field", (generalTab.getInformationField("Authorized repair limit").equals(database.get("Authorized repair limit").getAsString())));
        Assert.assertTrue("Error in 'Audio Equipment' field", (generalTab.getInformationField("Audio Equipment").equals(database.get("Audio Equipment").getAsString())));
        Assert.assertTrue("Error in 'Accident plus ( react)' field", (generalTab.getInformationField("Accident plus ( react)").equals(database.get("Accident plus ( react)").getAsString())));
        Assert.assertTrue("Error in 'Malicious Damage' field", (generalTab.getInformationField("Malicious Damage").equals(database.get("Malicious Damage").getAsString())));
        Assert.assertTrue("Error in 'Coverage for Radio/Tapes' field", (generalTab.getInformationField("Coverage for Radio/Tapes").equals(database.get("Coverage for Radio/Tapes").getAsString())));
        Assert.assertTrue("Error in 'New Car Replacement' field", (generalTab.getInformationField("New Car Replacement").equals(database.get("New Car Replacement").getAsString())));
        Assert.assertTrue("Error in 'Hand bag Coverage' field", (generalTab.getInformationField("Hand bag Coverage").equals(database.get("Hand bag Coverage").getAsString())));
        Assert.assertTrue("Error in 'Critcal Illness Cover' field", (generalTab.getInformationField("Critcal Illness Cover").equals(database.get("Critcal Illness Cover").getAsString())));

        //Discounts

        Assert.assertTrue("Error in 'Tracking device installed on the vehicle' field", (generalTab.getInformationField("Tracking device installed on the vehicle").equals(database.get("Tracking device installed on the vehicle").getAsString())));
        Assert.assertTrue("Error in 'Jamaica Teacher's Association (JTA)' field", (generalTab.getInformationField("Jamaica Teacher").equals(database.get("Jamaica Teacher's Association (JTA)").getAsString())));
        Assert.assertTrue("Error in 'Jamaica Defense Force (JDF)' field", (generalTab.getInformationField("Jamaica Defense Force (JDF)").equals(database.get("Jamaica Defense Force (JDF)").getAsString())));
        Assert.assertTrue("Error in 'Are you a Non-Commissioned JDF Officer?' field", (generalTab.getInformationField("Are you a Non-Commissioned JDF Officer?").equals(database.get("Are you a Non-Commissioned JDF Officer?").getAsString())));
        Assert.assertTrue("Error in 'Jamaica Constabulary Force (JCF)' field", (generalTab.getInformationField("Jamaica Constabulary Force (JCF)").equals(database.get("Jamaica Constabulary Force (JCF)").getAsString())));
        Assert.assertTrue("Error in 'Jamaica Automobile Association (JAA)' field", (generalTab.getInformationField("Jamaica Automobile Association (JAA)").equals(database.get("Jamaica Automobile Association (JAA)").getAsString())));
        Assert.assertTrue("Error in 'Jamaica Auto Club' field", (generalTab.getInformationField("Jamaica Auto Club").equals(database.get("Jamaica Auto Club").getAsString())));
        Assert.assertTrue("Error in 'Jamaica Civil Service Association (JCSA)' field", (generalTab.getInformationField("Jamaica Civil Service Association (JCSA)").equals(database.get("Jamaica Civil Service Association (JCSA)").getAsString())));
        Assert.assertTrue("Error in 'Insurance Institute of Jamaica Discount (IIJ)' field", (generalTab.getInformationField("Insurance Institute of Jamaica Discount (IIJ)").equals(database.get("Insurance Institute of Jamaica Discount (IIJ)").getAsString())));
        Assert.assertTrue("Error in 'NCD' field", (generalTab.getInformationField("NCD").equals(database.get("NCD").getAsString())));
        Assert.assertTrue("Error in 'Would you like to apply the NCD to this vehicle?' field", (generalTab.getInformationField("Would you like to apply the NCD to this vehicle?").equals(database.get("Would you like to apply the NCD to this vehicle?").getAsString())));
        Assert.assertTrue("Error in 'Do you have valuation/proforma invoice for your vehicle' field", (generalTab.getInformationField("Do you have valuation/proforma invoice for your vehicle").equals(database.get("Do you have valuation/proforma invoice for your vehicle").getAsString())));
        Assert.assertTrue("Error in 'Do you have a home owner’s policy?' field", (generalTab.getInformationField("Do you have a home owner").equals(database.get("Do you have a home owner’s policy?").getAsString())));
        Assert.assertTrue("Error in 'Do you have this policy through Marathon?' field", (generalTab.getInformationField("Do you have this policy through Marathon?").equals(database.get("Do you have this policy through Marathon?").getAsString())));
        Assert.assertTrue("Error in 'How many years with insurance provider' field", (generalTab.getInformationField("How many years with insurance provider").equals(database.get("How many years with insurance provider").getAsString())));
        Assert.assertTrue("Error in 'Please specify provider name' field", (generalTab.getInformationField("Please specify provider name").equals(database.get("Please specify provider name").getAsString())));
        Assert.assertTrue("Error in 'Do you have another motor insurance policy?' field", (generalTab.getInformationField("Do you have another motor insurance policy?").equals(database.get("Do you have another motor insurance policy?").getAsString())));
        Assert.assertTrue("Error in 'How many vehicles are currently insured with same provider' field", (generalTab.getInformationField("How many vehicles are currently insured with same provider").equals(database.get("How many vehicles are currently insured with same provider").getAsString())));
        Assert.assertTrue("Error in 'How many years with insurance provider' field", (generalTab.getInformationField("How many years with insurance provider").equals(database.get("How many years with insurance provider").getAsString())));
        Assert.assertTrue("Error in 'Please specify provider name' field", (generalTab.getInformationField("Please specify provider name").equals(database.get("Please specify provider name").getAsString())));
        Assert.assertTrue("Error in 'Are you presently insured through a broker?' field", (generalTab.getInformationField("Are you presently insured through a broker?").equals(database.get("Are you presently insured through a broker?").getAsString())));


        //Credit/Debit/Cover Note Details
        // Validacion de la tabla fila por fila

    }
}
