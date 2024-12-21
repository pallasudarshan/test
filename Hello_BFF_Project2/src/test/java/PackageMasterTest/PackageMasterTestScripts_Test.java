package PackageMasterTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.PackageMasterPage;
@Listeners(AllureTestListeners.class)
public class PackageMasterTestScripts_Test extends BaseClass {

	@Test
	public void checkThatUserAbleToCreateThePackageMaster_Test() throws Throwable {
		int count = 0;

		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		pm.enterPackageName(driver);
		pm.addServiceNamesAndQuantityAndRate(driver, count);
		pm.clickOnSaveButton(driver);
		String msg = pm.captureRightCornerPopupMessage(driver);
		Assert.assertEquals("Package created successfully", msg);
	}

	@Test
	public void createPackageWithMultipleServices_Test() {
		int count = 3;

		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		pm.enterPackageName(driver);
		pm.addServiceNamesAndQuantityAndRate(driver, count);
		pm.clickOnSaveButton(driver);
		String msg = pm.captureRightCornerPopupMessage(driver);
		Assert.assertEquals("Package created successfully", msg);
	}

	@Test
	public void checkThatCreatedPackageIsReflectedInListInAscendingOrder_Test() throws Throwable {
		int count = 0;

		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		String packageName = pm.enterPackageName(driver);
		pm.addServiceNamesAndQuantityAndRate(driver, count);
		pm.clickOnSaveButton(driver);
		Thread.sleep(3000);
		String packageName2 = pm.capturePackageName_Table(driver);
		Assert.assertEquals(packageName, packageName2);
	}

	@Test
	public void checkThatUserIsAbleToEditTheCreatedPackage_Test() throws Throwable {
		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnEdit_Action(driver);
		pm.clickOnSaveButton(driver);
		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "updated Successfully");
	}

	@Test
	public void verifyThatEditedPackageNameIsReflectedCorrectlyInTheList_Test() throws Throwable {
		PackageMasterPage pm = new PackageMasterPage(driver);

		int count = 0;

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		pm.enterPackageName(driver);
		pm.addServiceNamesAndQuantityAndRate(driver, count);
		pm.clickOnSaveButton(driver);
		pm.clickOnEdit_Action(driver);
		String packageName = pm.enterPackageName(driver);
		pm.clickOnSaveButton(driver);
		Thread.sleep(2000);
		String packageName2 = pm.capturePackageName_Table(driver);
		Assert.assertEquals(packageName, packageName2);
	}

	@Test
	public void verifyThatUserIsAbleToDeactivateTheStatusOfCreatedPackage_Test() throws Throwable {
		PackageMasterPage pm = new PackageMasterPage(driver);

		int count = 0;

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		pm.enterPackageName(driver);
		pm.addServiceNamesAndQuantityAndRate(driver, count);
		pm.clickOnSaveButton(driver);
		Thread.sleep(5000);
		pm.clickOnStatusToggleButton(driver);
		Thread.sleep(2000);
		String text = captureAlertText_2(driver);
		pm.clickOnStatusToggleButton(driver);
		Assert.assertEquals(text, "isActive updated");
	}

	@Test
	public void verifyThatSystemPreventsAdditionOfLineItemWithoutEnteringData_EnterMandatoryFields_Test()
			throws Throwable {
		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		pm.clickOnActionButton(driver);
		String text = captureAlertText_2(driver);
		pm.clickOnCancelButton(driver);
		Assert.assertEquals(text, "Enter Mandatory fields");
	}

	@Test
	public void verifyThatSystemPreventsPackageCreationWithoutInputtingDataInAllFields_PleaseFillAllRequiredFields_Test()
			throws Throwable {
		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		pm.clickOnSaveButton(driver);
		String text = captureAlertText_2(driver);
		pm.clickOnCancelButton(driver);
		Assert.assertEquals(text, "Please fill All required fields");
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingPackageCodeInKeywordSearch_Test() throws Throwable {
		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		String text = pm.capturePackageCode_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = pm.capturePackageCode_Table(driver);
		Assert.assertEquals(text2, text);
	}

//	@Test
//	public void verifythatUserIsAbleToFilterTheDataUsingPackageNameInKeywordSearch_Test() throws Throwable {
//		PackageMasterPage pm = new PackageMasterPage(driver);
//
//		pm.clickOnThePackageMasterPageButton(driver);
//		clickOnSideMenuBtn(driver);
//		String text = pm.capturePackageName_Table_Lastrow(driver);
//		enterKeywordSearch(driver, text);
//		String text2 = pm.capturePackageName_Table(driver);
//		Assert.assertEquals(text2, text);
//	}
//
//	@Test
//	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() {
//		PackageMasterPage pm = new PackageMasterPage(driver);
//
//		pm.clickOnThePackageMasterPageButton(driver);
//		clickOnSideMenuBtn(driver);
//
//		String text = "Test";
//
//		enterKeywordSearch(driver, text);
//		clickOnClearBtn_KeywordSearch(driver);
//		String text2 = captureKeywordSearchField(driver);
//		Assert.assertEquals("", text2);
//	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		String lastPaginationNumber = captureLastPaginationNumber(driver);
		int number = Integer.parseInt(lastPaginationNumber);
		int number2 = number - 1;
		String result = Integer.toString(number2);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(result + "1", text);
	}

	@Test
	public void verifyfirstPagePaginationBtn_Test() throws Throwable {
		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
//		clickOnLastButton(driver);
//		String slNo = captureSlNo_Table_Lastrow(driver);
//		int slNo2 = Integer.parseInt(slNo);
//		clickOnFirstButton(driver);
//		String no = clickOnMiddlePageNumber(driver, slNo2);
		String no = clickOnMiddlePageNumber(driver);
		String slNo3 = captureSlNo_Table_Lastrow(driver);
		Assert.assertEquals(slNo3, no + "0");
	}

	@Test
	public void verifyUserIsAbleToDeleteTheAddedServices_Test() {
		int count = 3;
		int count2 = 2;
		int count3 = count - count2;

		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		pm.enterPackageName(driver);
		pm.addServiceNamesAndQuantityAndRate(driver, count);
		pm.deleteServices_List(driver, count2);
		int noOFLineItem = pm.getNoOfLineItemsPresent(driver);
		Assert.assertEquals(noOFLineItem, count3);
	}

	@Test
	public void verifyThatDeletedServiceWhileEditingIsUpdatedCorrectly_Test() throws InterruptedException {
		int count = 3;
		int count2 = 2;
		int count3 = count - count2;

		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		pm.enterPackageName(driver);
		pm.addServiceNamesAndQuantityAndRate(driver, count);
		pm.clickOnSaveButton(driver);
		Thread.sleep(2000);
		pm.clickOnEdit_Action(driver);

		pm.deleteServices_List(driver, count2);
		pm.clickOnSaveButton(driver);

		Thread.sleep(4000);
		pm.clickOnEdit_Action(driver);
		int noOFLineItem = pm.getNoOfLineItemsPresent(driver);
		Assert.assertEquals(noOFLineItem, count3);
	}

	@Test
	public void verifyThatDeletedServicesInCreationAreNotReflectedWhileEditing_Test() {
		int count = 3;
		int count2 = 2;
		int count3 = count - count2;

		PackageMasterPage pm = new PackageMasterPage(driver);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		pm.enterPackageName(driver);
		pm.addServiceNamesAndQuantityAndRate(driver, count);
		pm.deleteServices_List(driver, count2);
		pm.clickOnSaveButton(driver);
		pm.clickOnEdit_Action(driver);
		int noOFLineItem = pm.getNoOfLineItemsPresent(driver);
		Assert.assertEquals(noOFLineItem, count3);
	}

	@Test
	public void verifyThatAddedServicesCountWhileEditingIsDisplayedCorrectly_Test() throws Throwable {
		PackageMasterPage pm = new PackageMasterPage(driver);

		int count = 1;
		int count2 = 3;
		int finalCount = count + 1 + count2 + 1;

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		pm.enterPackageName(driver);
		pm.addServiceNamesAndQuantityAndRate(driver, count);
		pm.clickOnSaveButton(driver);

		pm.clickOnEdit_Action(driver);
		pm.addServiceNamesAndQuantityAndRate(driver, count2);
		pm.clickOnSaveButton(driver);

		pm.clickOnEdit_Action(driver);
		int noOfLineItem = pm.getNoOfLineItemsPresent(driver);
		Assert.assertEquals(noOfLineItem, finalCount);
	}

}
