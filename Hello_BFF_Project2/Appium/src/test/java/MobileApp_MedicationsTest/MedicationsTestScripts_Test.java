package MobileApp_MedicationsTest;

import org.testng.annotations.Test;

import GenericUtility_Appium.BaseClass_Appium;
import Hello_Bff_GenericUtility.JavaUtility;
import ObjectRepository_Appium.HomePage_Appium;
import ObjectRepository_Appium.MedicationsPage;

public class MedicationsTestScripts_Test extends BaseClass_Appium {

	@Test
	public void test() {
		JavaUtility jutil = new JavaUtility();
		String medicineDate = jutil.generateDatesForTheNext30Days();
		String medicineName = "Test";
		String medicineType = "Pills";

		HomePage_Appium hp = new HomePage_Appium(androidDriver);
		MedicationsPage mp = new MedicationsPage(androidDriver);

		hp.clickOnThePlusButton();
		mp.clickOnTheMedicationButton();
		mp.clickOnThePlus_AddButton();
		mp.enterTheMedicineDate(medicineDate);
		mp.enterTheMedicineName(medicineName);
		mp.selectMedicineType(medicineType);

	}
}
