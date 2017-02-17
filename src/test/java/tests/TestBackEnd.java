package tests;

import classes.BaseTest;
import classes.Enums.FieldType;
import classes.Enums.IntendedUseVehicle;
import classes.Objects.FieldToComplete;
import junit.framework.Assert;
import org.testng.annotations.Test;
import pageObjects.BackEnd.BackEndHomePage;
import pageObjects.BackEnd.BackEndLoginPage;
import pageObjects.BackEnd.ClientManagementGeneralTab;
import pageObjects.BackEnd.ClientManagementPage;
import pageObjects.FrontEnd.HomePage;
import pageObjects.FrontEnd.QuickQuotePageObject;

import java.util.ArrayList;
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

        //Policy Details
        String hola = generalTab.getInformationField("Policy Start Time");
        Assert.assertTrue("Error in 'Policy Start Date' field", (generalTab.getInformationField("Policy Start Date").equals("01/28/2016")));
        Assert.assertTrue("Error in 'Policy Status' field", (generalTab.getInformationField("Policy Status").equals("Accepted")));
        Assert.assertTrue("Error in 'Issuing Company' field", (generalTab.getInformationField("Issuing Company").equals("Advantage General Insurance Company Limited")));
        Assert.assertTrue("Error in 'Date of Birth' field", (generalTab.getInformationField("Date of Birth").equals("09/09/1985")));
        Assert.assertTrue("Error in 'Taxpayer Registration Number' field", (generalTab.getInformationField("Taxpayer Registration Number").equals("874-365-413")));
        Assert.assertTrue("Error in 'Policy Start time' field", (generalTab.getInformationField("Policy Start time").equals("00:00")));
        Assert.assertTrue("Error in 'Cover Type", (generalTab.getInformationField("Cover Type").equals("Comprehensive")));
        Assert.assertTrue("Error in 'Proposer Name' field", (generalTab.getInformationField("Proposer Name").equals("James")));
        Assert.assertTrue("Error in 'Policy Number' field", (generalTab.getInformationField("Policy Number").equals("PLCY-NYHZWOVL15")));

        //Proposer Contact Details
        Assert.assertTrue("Error in 'Address Residential' field", (generalTab.getInformationField("Address Residential").equals("name")));
        Assert.assertTrue("Error in 'Parish' field", (generalTab.getInformationField("Parish").equals("St. Andrew")));
        Assert.assertTrue("Error in 'Contact Number Home' field", (generalTab.getInformationField("Contact Number Home").equals("876-435-4352")));
        Assert.assertTrue("Error in 'Contact Number Mobile' field", (generalTab.getInformationField("Contact Number Mobile").equals("876-543-6541")));
        Assert.assertTrue("Error in 'Address Work' field", (generalTab.getInformationField("Address Work").equals("Radix")));
        Assert.assertTrue("Error in 'Parish' field", (generalTab.getInformationField("Parish").equals("St. Andrew")));
        Assert.assertTrue("Error in 'Contact Number Work' field", (generalTab.getInformationField("Contact Number Work").equals("876-416-3214")));

        //Insured Personal & Contact Detail
        // Validacion de la tabla fila por fila (HACER UN PAGEOBJECT TABLA)

        //Vehicle Details
        // Validacion de la tabla fila por fila

        //Payment
        Assert.assertTrue("Error in 'Source of funds' field", (generalTab.getInformationField("Source of funds").equals("Salary")));
        Assert.assertTrue("Error in 'Premium Amount' field", (generalTab.getInformationField("Premium Amount").equals("113583.32")));
        Assert.assertTrue("Error in 'Next payment date' field", (generalTab.getInformationField("Next payment date").equals("N/A")));
        Assert.assertTrue("Error in 'Is Finance' field", (generalTab.getInformationField("Is Finance").equals("No")));
        Assert.assertTrue("Error in 'Type of Plan' field", (generalTab.getInformationField("Type of Plan").equals("Full Payment")));

        ///Payment History
        // Validacion de la tabla fila por fila

        //Benefits Details
        Assert.assertTrue("Error in 'Excess' field", (generalTab.getInformationField("Excess").equals("Not available")));
        Assert.assertTrue("Error in 'Loss of Use' field", (generalTab.getInformationField("Loss of Use").equals("Not available")));
        Assert.assertTrue("Error in 'Wrecker Fees' field", (generalTab.getInformationField("Wrecker Fees").equals("Not available")));
        Assert.assertTrue("Error in 'Roadside Assistance' field", (generalTab.getInformationField("Roadside Assistance").equals("Not available")));
        Assert.assertTrue("Error in 'Uninsured Motorist Coverage' field", (generalTab.getInformationField("Uninsured Motorist Coverage").equals("Not available")));
        Assert.assertTrue("Error in 'Comprehensive Plus' field", (generalTab.getInformationField("Comprehensive Plus").equals("Not available")));
        Assert.assertTrue("Error in 'Personal accidents' field", (generalTab.getInformationField("Personal accidents").equals("Not available")));
        Assert.assertTrue("Error in 'Act of God' field", (generalTab.getInformationField("Act of God").equals("Not available")));
        Assert.assertTrue("Error in 'Personal effects' field", (generalTab.getInformationField("Personal effects").equals("Not available")));
        Assert.assertTrue("Error in 'Assist- Accident scene and Breakdown assistance' field", (generalTab.getInformationField("Assist- Accident scene and Breakdown assistance").equals("Not available")));
        Assert.assertTrue("Error in 'Free Annual Valuation' field", (generalTab.getInformationField("Free Annual Valuation").equals("Not available")));
        Assert.assertTrue("Error in 'Windscreen' field", (generalTab.getInformationField("Windscreen").equals("Not available")));
        Assert.assertTrue("Error in 'Fire Damage to Garage' field", (generalTab.getInformationField("Fire Damage to Garage").equals("Not available")));
        Assert.assertTrue("Error in 'Theft Cover' field", (generalTab.getInformationField("Theft Cover").equals("Not available")));
        Assert.assertTrue("Error in 'Indemnity whilst in hand of Motor Trader' field", (generalTab.getInformationField("Indemnity whilst in hand of Motor Trader").equals("Not available")));
        Assert.assertTrue("Error in 'Motor Trade coverage' field", (generalTab.getInformationField("Motor Trade coverage").equals("Not available")));
        Assert.assertTrue("Error in 'Infant Seat Replacement' field", (generalTab.getInformationField("Infant Seat Replacement").equals("Not available")));
        Assert.assertTrue("Error in 'Key Replacement' field", (generalTab.getInformationField("Key Replacement").equals("Not available")));
        Assert.assertTrue("Error in 'Limits of Liability' field", (generalTab.getInformationField("Limits of Liability").equals("Not available")));
        Assert.assertTrue("Error in 'Personal accidents rider' field", (generalTab.getInformationField("Personal accidents rider").equals("Not available")));
        Assert.assertTrue("Error in 'Manslaughter' field", (generalTab.getInformationField("Manslaughter").equals("Not available")));
        Assert.assertTrue("Error in 'Windscreen Damage' field", (generalTab.getInformationField("Windscreen Damage").equals("Not available")));
        Assert.assertTrue("Error in 'Accident Forgiveness' field", (generalTab.getInformationField("Accident Forgiveness").equals("Not available")));
        Assert.assertTrue("Error in 'Flood, Hurricane, Earthquake, Riot, Strike & Civil commotion' field", (generalTab.getInformationField("Flood, Hurricane, Earthquake, Riot, Strike & Civil commotion").equals("Not available")));
        Assert.assertTrue("Error in 'ThirdParty Plus' field", (generalTab.getInformationField("ThirdParty Plus").equals("Not available")));
        Assert.assertTrue("Error in 'Medical expenses' field", (generalTab.getInformationField("Medical expenses").equals("Not available")));
        Assert.assertTrue("Error in 'Advantage 24/7' field", (generalTab.getInformationField("Advantage 24/7").equals("Not available")));
        Assert.assertTrue("Error in 'Passenger Negligence and Passenger liability' field", (generalTab.getInformationField("Passenger Negligence and Passenger liability").equals("Not available")));
        Assert.assertTrue("Error in 'Protected No Claim Discount' field", (generalTab.getInformationField("Protected No Claim Discount").equals("Not available")));
        Assert.assertTrue("Error in 'Authorized repair limit' field", (generalTab.getInformationField("Authorized repair limit").equals("Not available")));
        Assert.assertTrue("Error in 'Audio Equipment' field", (generalTab.getInformationField("Audio Equipment").equals("Not available")));
        Assert.assertTrue("Error in 'Accident plus ( react)' field", (generalTab.getInformationField("Accident plus ( react)").equals("Not available")));
        Assert.assertTrue("Error in 'Malicious Damage' field", (generalTab.getInformationField("Malicious Damage").equals("Not available")));
        Assert.assertTrue("Error in 'Coverage for Radio/Tapes' field", (generalTab.getInformationField("Coverage for Radio/Tapes").equals("Not available")));
        Assert.assertTrue("Error in 'New Car Replacement' field", (generalTab.getInformationField("New Car Replacement").equals("Not available")));
        Assert.assertTrue("Error in 'Hand bag Coverage' field", (generalTab.getInformationField("Hand bag Coverage").equals("Not available")));
        Assert.assertTrue("Error in 'Critcal Illness Cover' field", (generalTab.getInformationField("Critcal Illness Cover").equals("Not available")));

        //Discounts

        Assert.assertTrue("Error in 'Tracking device installed on the vehicle' field", (generalTab.getInformationField("Tracking device installed on the vehicle").equals("No")));
        Assert.assertTrue("Error in 'Jamaica Teacher's Association (JTA)' field", (generalTab.getInformationField("Jamaica Teacher's Association (JTA)").equals("No")));
        Assert.assertTrue("Error in 'Jamaica Defense Force (JDF)' field", (generalTab.getInformationField("Jamaica Defense Force (JDF)").equals("No")));
        Assert.assertTrue("Error in 'Are you a Non-Commissioned JDF Officer?' field", (generalTab.getInformationField("Are you a Non-Commissioned JDF Officer?").equals("No")));
        Assert.assertTrue("Error in 'Jamaica Constabulary Force (JCF)' field", (generalTab.getInformationField("Jamaica Constabulary Force (JCF)").equals("No")));
        Assert.assertTrue("Error in 'Jamaica Automobile Association (JAA)' field", (generalTab.getInformationField("Jamaica Automobile Association (JAA)").equals("No")));
        Assert.assertTrue("Error in 'Jamaica Auto Club' field", (generalTab.getInformationField("Jamaica Auto Club").equals("No")));
        Assert.assertTrue("Error in 'Jamaica Civil Service Association (JCSA)' field", (generalTab.getInformationField("Jamaica Civil Service Association (JCSA)").equals("No")));
        Assert.assertTrue("Error in 'Insurance Institute of Jamaica Discount (IIJ)' field", (generalTab.getInformationField("Insurance Institute of Jamaica Discount (IIJ)").equals("No")));
        Assert.assertTrue("Error in 'NCD' field", (generalTab.getInformationField("NCD").equals("2")));
        Assert.assertTrue("Error in 'Would you like to apply the NCD to this vehicle?' field", (generalTab.getInformationField("Would you like to apply the NCD to this vehicle?").equals("Yes")));
        Assert.assertTrue("Error in 'Do you have valuation/proforma invoice for your vehicle' field", (generalTab.getInformationField("Do you have valuation/proforma invoice for your vehicle").equals("No")));
        Assert.assertTrue("Error in 'Do you have a home owner’s policy?' field", (generalTab.getInformationField("Do you have a home owner’s policy?").equals("No")));
        Assert.assertTrue("Error in 'Do you have this policy through Marathon?' field", (generalTab.getInformationField("Do you have this policy through Marathon?").equals("No")));
        Assert.assertTrue("Error in 'How many years with insurance provider' field", (generalTab.getInformationField("How many years with insurance provider").equals("")));
        Assert.assertTrue("Error in 'Please specify provider name' field", (generalTab.getInformationField("Please specify provider name").equals("")));
        Assert.assertTrue("Error in 'Do you have another motor insurance policy?' field", (generalTab.getInformationField("Do you have another motor insurance policy?").equals("No")));
        Assert.assertTrue("Error in 'How many vehicles are currently insured with same provider' field", (generalTab.getInformationField("How many vehicles are currently insured with same provider").equals("")));
        Assert.assertTrue("Error in 'How many years with insurance provider' field", (generalTab.getInformationField("How many years with insurance provider").equals("")));
        Assert.assertTrue("Error in 'Please specify provider name' field", (generalTab.getInformationField("Please specify provider name").equals("")));
        Assert.assertTrue("Error in 'Are you presently insured through a broker?' field", (generalTab.getInformationField("Are you presently insured through a broker?").equals("No")));


        //Credit/Debit/Cover Note Details
        // Validacion de la tabla fila por fila

    }
}
