package SystemCodeTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.HomePage;
import Hello_Bff_ObjectRepository.SystemCodePage;

public class SystemCodeTestScripts_Test extends BaseClass {

	@Test
	public void checkThatUserGiveTheSameApplicationCodeAndVerifyTheErrorMessage_Test() {
		String applicationCodeDescription = "Test";

		SystemCodePage sc = new SystemCodePage(driver);
		HomePage hp = new HomePage(driver);

		sc.clickOnSystemCodePage(driver);
		hp.clickOnSideMenuButton(driver);
		sc.clickOnTheDescriptionBtnFirstRowTable(driver);
		String applicationCode = sc.captureApplicationCodeTable_Popup(driver);
		sc.enterApplicationCode_Popup(driver, applicationCode);
		sc.enterApplicationCodeDescription_Popup(driver, applicationCodeDescription);
		sc.clickOnSaveButton(driver);
	}

	@Test
	public void checkThatUserAbleToUpdateTheDescriptionOfTheApplicationCode_Test() throws Throwable {
		String description1 = "test" + generateRandomNumber();

		SystemCodePage sc = new SystemCodePage(driver);
		HomePage hp = new HomePage(driver);

		sc.clickOnSystemCodePage(driver);
		hp.clickOnSideMenuButton(driver);
		sc.clickOnTheDescriptionBtnFirstRowTable(driver);
		String description = sc.captureDescriptionFirstrowTable_Popup(driver);
		sc.clickOnEditBtn_Popup(driver);
		Thread.sleep(2000);
		sc.enterDescriptionFirstrowTable_Popup(driver, description1);
		Thread.sleep(2000);
		sc.clickOnCorrectButton_FirstRowTable_ApplicationPopup(driver);
		Thread.sleep(2000);
		String description2 = sc.captureDescriptionFirstrowTable_Popup(driver);
		Thread.sleep(2000);
		Assert.assertNotEquals(description, description2);
	}
}
