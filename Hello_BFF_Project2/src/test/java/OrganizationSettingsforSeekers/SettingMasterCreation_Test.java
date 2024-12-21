package OrganizationSettingsforSeekers;

import java.util.ArrayList;
import java.util.HashSet;

import org.testng.Assert;
import org.testng.annotations.Test;

import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.OrganizationSettingsForSeekersPage;

public class SettingMasterCreation_Test extends BaseClass {

	@Test
	public void createSettingMasterByProvidingDataInAllFields_Test() throws Throwable {
		OrganizationSettingsForSeekersPage settingMaster = new OrganizationSettingsForSeekersPage(driver);

		String contactPerson = generateRandomNames(driver);
		String companyName = generateRandomVendorName();
		String shortName = generateRandomVendorName().substring(0, 3);
		String emailId = companyName.replace(" ", "") + "@demo.com";
		String landlineNumber = "798797987987696213";
		String contactNumber = generateRandomMobileNumber();
		String website = generateRandomWebsite();
		String localCurrency = "INR";
		String reportingCurrency = "USD";
		String timeZone = "INR";
		String reportingDateFormate = "DD-MM-YYYY";
		String faxNo = generateRandomSICCode();
		String userPrefix = "" + generateRandomCharacter() + generateRandomCharacter() + generateRandomCharacter();
		String adminPrefix = "" + generateRandomCharacter() + generateRandomCharacter() + generateRandomCharacter();
		String seekerCodePrefix = "" + generateRandomCharacter() + generateRandomCharacter()
				+ generateRandomCharacter();
		String customerCodePrefix = "" + generateRandomCharacter() + generateRandomCharacter()
				+ generateRandomCharacter();
		String checkinPeriod = "50";
		String file = "D:\\Automation Testing\\Hello_Bff\\hms-automation\\hms-automation\\Hello_BFF_Project\\src\\main\\resources\\CommanData\\Document\\productImage.png";

		settingMaster.clickOnSettingMasterPage(driver);
		clickOnSideMenuBtn(driver);
		settingMaster.enterContactPerson(driver, contactPerson);
		settingMaster.enterCompanyName(driver, companyName);
		settingMaster.enterShortName(driver, shortName);
		settingMaster.enterEmailId(driver, emailId);
		settingMaster.enterLandlineNumber(driver, landlineNumber);
		settingMaster.enterContactNumber(driver, contactNumber);
		settingMaster.enterWebsite(driver, website);
		settingMaster.selectLocalCurrency(driver, localCurrency);
		settingMaster.selectRportingCurrency(driver, reportingCurrency);
		settingMaster.selectTimezone(driver, timeZone);
		settingMaster.selectReportingDateFormate(driver, reportingDateFormate);
		settingMaster.enterFaxno(driver, faxNo);
		settingMaster.enterBffUserPrefix(driver, userPrefix);
		settingMaster.enterBffAdminPrefix(driver, adminPrefix);
		settingMaster.enterSeekerCodePrefix(driver, seekerCodePrefix);
		settingMaster.enterCustomerCodePrefix(driver, customerCodePrefix);
		settingMaster.enterCheckinPeriod(driver, checkinPeriod);
		settingMaster.uploadLogo(driver, file);
		settingMaster.clickOnSave(driver);
		String text = captureAlertText(driver);
		Assert.assertEquals(text, "success");
	}

	@Test
	public void createSettingMasterByProvidingDataInMandatoryFields_Test() throws Throwable {
		OrganizationSettingsForSeekersPage settingMaster = new OrganizationSettingsForSeekersPage(driver);

		String contactPerson = generateRandomNames(driver);
		String companyName = generateRandomVendorName();
		String shortName = generateRandomVendorName().substring(0, 3);
		String emailId = companyName.replace(" ", "") + "@demo.com";
		String landlineNumber = "998787";
		String contactNumber = generateRandomMobileNumber();
		String localCurrency = "INR";
		String reportingCurrency = "USD";
		String timeZone = "INR";
		String reportingDateFormate = "DD-MM-YYYY";
		String faxNo = generateRandomSICCode();
		String userPrefix = "" + generateRandomCharacter() + generateRandomCharacter() + generateRandomCharacter();
		String adminPrefix = "" + generateRandomCharacter() + generateRandomCharacter() + generateRandomCharacter();
		String seekerCodePrefix = "" + generateRandomCharacter() + generateRandomCharacter()
				+ generateRandomCharacter();
		String customerCodePrefix = "" + generateRandomCharacter() + generateRandomCharacter()
				+ generateRandomCharacter();
		String checkinPeriod = "50";

		settingMaster.clickOnSettingMasterPage(driver);
		clickOnSideMenuBtn(driver);
		settingMaster.enterContactPerson(driver, contactPerson);
		settingMaster.enterCompanyName(driver, companyName);
		settingMaster.enterShortName(driver, shortName);
		settingMaster.enterEmailId(driver, emailId);
		settingMaster.enterLandlineNumber(driver, landlineNumber);
		settingMaster.enterContactNumber(driver, contactNumber);
		settingMaster.selectLocalCurrency(driver, localCurrency);
		settingMaster.selectRportingCurrency(driver, reportingCurrency);
		settingMaster.selectTimezone(driver, timeZone);
		settingMaster.selectReportingDateFormate(driver, reportingDateFormate);
		settingMaster.enterFaxno(driver, faxNo);
		settingMaster.enterBffUserPrefix(driver, userPrefix);
		settingMaster.enterBffAdminPrefix(driver, adminPrefix);
		settingMaster.enterSeekerCodePrefix(driver, seekerCodePrefix);
		settingMaster.enterCustomerCodePrefix(driver, customerCodePrefix);
		settingMaster.enterCheckinPeriod(driver, checkinPeriod);
		settingMaster.clickOnSave(driver);
		String text = captureAlertText(driver);
		Assert.assertEquals(text, "success");
	}

	@Test
	public void editSettingMaster_Test() throws Throwable {
		OrganizationSettingsForSeekersPage settingMaster = new OrganizationSettingsForSeekersPage(driver);

		settingMaster.clickOnSettingMasterPage(driver);
		clickOnSideMenuBtn(driver);

		settingMaster.clickOnBack(driver);
		settingMaster.clickOnActionAndEdit(driver);
		Thread.sleep(2000);
		settingMaster.clickOnSave(driver);
		String text = captureAlertText(driver);
		Assert.assertEquals(text, "updated");
	}

}
