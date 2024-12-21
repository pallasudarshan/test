package ScheduleTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.ManageSeekerPage;
import Hello_Bff_ObjectRepository.SchedulePage;
@Listeners(AllureTestListeners.class)
public class ScheduleTestScripts_Test extends BaseClass {

	@Test
	public void checkThatUserAbleToVerifyTheSeekerDetailsBysearchingSeekerId_Test() throws Throwable {
		String sourceType = "home";
		String maritalStatus = "SINGLE";
		String customerName = "dalvkot";
		String file = randomImage();

		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.selectRefferralSourceType(driver, sourceType);
		String firstName = manageSeekerPage.enterFirstName(driver);
		String middleName = manageSeekerPage.enterMiddleName(driver);
		String lastName = manageSeekerPage.enterLastName(driver);
		String email = firstName + middleName + lastName + "@DEMO.COM";
		manageSeekerPage.enterEmail_2(driver, email);
		manageSeekerPage.enterMobileNumber(driver);
		manageSeekerPage.selectGender(driver);
		manageSeekerPage.enterDateOfBirth(driver);
		manageSeekerPage.selectMaritalStatus(driver, maritalStatus);
		manageSeekerPage.selectCustomerName(driver, customerName);
		manageSeekerPage.selectLanguages(driver);
		String address = manageSeekerPage.enterAddress(driver);
		manageSeekerPage.enterInsuranceId(driver);
		manageSeekerPage.uploadProfile(driver, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.enterSeekerId(driver, seekerCode);
		schedulePage.clickOnSearchButton(driver);
		Thread.sleep(2000);
		String address1 = schedulePage.captureAddress(driver);
		String email1 = schedulePage.captureEmail(driver);
		String customerName1 = schedulePage.captureCustomerName(driver);

		Assert.assertEquals(email, email1);
		Assert.assertEquals(address, address1);
		Assert.assertEquals(customerName, customerName1);
	}

	@Test
	public void checkThatUserAbleToCreateTheSchedule_Test() throws Throwable {
		String sourceType = "home";
		String maritalStatus = "SINGLE";
		String customerName = "dalvkot";
		String selectBff = "surya m p";
		String file = randomImage();

		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.selectRefferralSourceType(driver, sourceType);
		String firstName = manageSeekerPage.enterFirstName(driver);
		String middleName = manageSeekerPage.enterMiddleName(driver);
		String lastName = manageSeekerPage.enterLastName(driver);
		String email = firstName + middleName + lastName + "@DEMO.COM";
		manageSeekerPage.enterEmail_2(driver, email);
		manageSeekerPage.enterMobileNumber(driver);
		manageSeekerPage.selectGender(driver);
		manageSeekerPage.enterDateOfBirth(driver);
		manageSeekerPage.selectMaritalStatus(driver, maritalStatus);
		manageSeekerPage.selectCustomerName(driver, customerName);
		manageSeekerPage.selectLanguages(driver);
		manageSeekerPage.enterAddress(driver);
		manageSeekerPage.enterInsuranceId(driver);
		manageSeekerPage.uploadProfile(driver, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.enterSeekerId(driver, seekerCode);
		schedulePage.clickOnSearchButton(driver);
		Thread.sleep(3000);
		schedulePage.selectBffDropdown(driver, selectBff);
		schedulePage.enterScheduleTime(driver);
		schedulePage.clickOnBookButton(driver);
		String seekerCode1 = schedulePage.captureSeekerCodeFirstrow_Table(driver);
		Assert.assertEquals(seekerCode, seekerCode1);
	}

	@Test
	public void checkThatEnterWrongSeekerIdAndVerifyTheErrorMessage_Test() throws Throwable {
		String seekerId = "test123";

		SchedulePage schedulePage = new SchedulePage(driver);

		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.enterSeekerId(driver, seekerId);
		schedulePage.clickOnSearchButton(driver);
		String errorMsg = schedulePage.captureErrorMessage(driver);
		Assert.assertEquals(errorMsg, "Error");
	}

	@Test
	public void checkThatUserClickOnEditAndClickOnCancelButton_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);

		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnEditButton(driver);
		schedulePage.clickOnCancelButton(driver);
//		boolean tesasdst = schedulePage.clickOnBackButton(driver);
//		System.out.println(tesasdst + "   test test ");
//		Assert.assertEquals(tesasdst, "false");
	}

	@Test
	public void checkThatUserChangeTheScheduleDate_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);

		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnEditButton(driver);
		schedulePage.selectDate(driver, "2025 ", "Jan ", "15");
		schedulePage.clickOnBookButton(driver);
	}

	@Test
	public void checkThatUserTryToBookTheScheduleWithoutGivingThe_ScheduleDate_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);
		schedulePage.clickOnSchedulePage(driver);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnEditButton(driver);
	}

	@Test
	public void verifyThatUserIsAbleToFilterTheDataUsingSeekerCodeInKeywordSearch_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);
		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		String seekerCode = schedulePage.captureSeekerCodeFirstrow_Table(driver);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		String seekerCode2 = schedulePage.captureSeekerCodeFirstrow_Table(driver);
		Assert.assertEquals(seekerCode, seekerCode2);
	}

	@Test
	public void verifyThatUserIsAbleToFilterTheDataUsingSeekerNameInKeywordSearch_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);
		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		String seekerName = schedulePage.captureSeekerName_Table_Lastrow(driver);
		schedulePage.enterKeywordSearch(driver, seekerName);
		String seekerName2 = schedulePage.captureSeekerNameFirstrow_Table(driver);
		Assert.assertEquals(seekerName2, seekerName);
	}

	@Test
	public void verifyThatUserIsAbleToFilterTheDataUsingCustomerNameInKeywordSearch_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);
		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		String customerName = schedulePage.captureCustomerName_Table_Lastrow(driver);
		schedulePage.enterKeywordSearch(driver, customerName);
		String customerName2 = schedulePage.captureCustomerNameFirstrow_Table(driver);
		Assert.assertEquals(customerName2, customerName);
	}

	@Test
	public void verifyThatUserIsAbleToFilterTheDataUsingTherapistNameInKeywordSearch_Test() throws Throwable {
//		SchedulePage schedulePage = new SchedulePage(driver);
//		schedulePage.clickOnSchedulePage(driver);
//		clickOnSideMenuBtn(driver);
//		String therapistName = schedulePage.captureTherapistName_Table_Lastrow(driver);
//		schedulePage.enterKeywordSearch(driver, therapistName);
//		String therapistName2 = schedulePage.captureTherapistNameFirstrow_Table(driver);
//		Assert.assertEquals(therapistName, therapistName2);
	}

	@Test
	public void verifyThatUserIsAbleToFilterTheDataUsingScheduleDateInKeywordSearch_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);
		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		String scheduleDate = schedulePage.captureScheduleDate_Table_Lastrow(driver);
		schedulePage.enterKeywordSearch(driver, scheduleDate);
		String scheduleDate2 = schedulePage.captureScheduleDateFirstrow_Table(driver);
		Assert.assertEquals(scheduleDate, scheduleDate2);
	}

	@Test
	public void verifyThatUserIsAbleToFilterTheDataUsingScheduleTimeInKeywordSearch_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);
		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		String scheduleTime = schedulePage.captureScheduleTime_Table_Lastrow(driver);
		schedulePage.enterKeywordSearch(driver, scheduleTime);
		String scheduleTime2 = schedulePage.captureScheduleTimeFirstrow_Table(driver);
		Assert.assertEquals(scheduleTime, scheduleTime2);
	}

	@Test
	public void verifyClearButtonFunctionality_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);

		String text = "Test";

		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		schedulePage.enterKeywordSearch(driver, text);
		schedulePage.clickOnClearBtn_KeywordSearch(driver);
		String text2 = schedulePage.captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);

		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);

		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);

		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		String text = captureSlNo_Table(driver);
		System.out.println(text);
	}

	@Test
	public void verifyfirstPagePaginationBtn_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);

		schedulePage.clickOnSchedulePage(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		SchedulePage schedulePage = new SchedulePage(driver);

		schedulePage.clickOnSchedulePage(driver);
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
	public void checkThatUserIsAbleToCancelBooking_Test() throws Throwable {
		String sourceType = "home";
		String maritalStatus = "SINGLE";
		String customerName = "RamyaPunith";
		String selectBff = "surya";
		String file = randomImage();
		String reason = generateRandomTitle_JavaFaker();

		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.selectRefferralSourceType(driver, sourceType);
		String firstName = manageSeekerPage.enterFirstName(driver);
		String middleName = manageSeekerPage.enterMiddleName(driver);
		String lastName = manageSeekerPage.enterLastName(driver);
		String email = firstName + middleName + lastName + "@DEMO.COM";
		manageSeekerPage.enterEmail_2(driver, email);
		manageSeekerPage.enterMobileNumber(driver);
		manageSeekerPage.selectGender(driver);
		manageSeekerPage.enterDateOfBirth(driver);
		manageSeekerPage.selectMaritalStatus(driver, maritalStatus);
		manageSeekerPage.selectCustomerName(driver, customerName);
		manageSeekerPage.selectLanguages(driver);
		manageSeekerPage.enterAddress(driver);
		manageSeekerPage.enterInsuranceId(driver);
		manageSeekerPage.uploadProfile(driver, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.enterSeekerId(driver, seekerCode);
		schedulePage.clickOnSearchButton(driver);
		Thread.sleep(3000);
		schedulePage.selectBffDropdown(driver, selectBff);
		schedulePage.enterScheduleTime(driver);
		schedulePage.clickOnBookButton(driver);
		Thread.sleep(2000);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnCancelBtn_Action(driver);
		schedulePage.enterCancelBookingReason(driver, reason);
		schedulePage.clickOnOkBtn_CancelBooking(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Appointment Cancelled Successfully");
	}

	@Test
	public void verifyThatAfterBookingIsCancelledSystemDisplayedCancelledTextUnderAction() throws Throwable {
		String sourceType = "home";
		String maritalStatus = "SINGLE";
		String customerName = "RamyaPunith";
		String selectBff = "naveen";
		String file = randomImage();
		String reason = generateRandomTitle_JavaFaker();

		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.selectRefferralSourceType(driver, sourceType);
		String firstName = manageSeekerPage.enterFirstName(driver);
		String middleName = manageSeekerPage.enterMiddleName(driver);
		String lastName = manageSeekerPage.enterLastName(driver);
		String email = firstName + middleName + lastName + "@DEMO.COM";
		manageSeekerPage.enterEmail_2(driver, email);
		manageSeekerPage.enterMobileNumber(driver);
		manageSeekerPage.selectGender(driver);
		manageSeekerPage.enterDateOfBirth(driver);
		manageSeekerPage.selectMaritalStatus(driver, maritalStatus);
		manageSeekerPage.selectCustomerName(driver, customerName);
		manageSeekerPage.selectLanguages(driver);
		manageSeekerPage.enterAddress(driver);
		manageSeekerPage.enterInsuranceId(driver);
		manageSeekerPage.uploadProfile(driver, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.enterSeekerId(driver, seekerCode);
		schedulePage.clickOnSearchButton(driver);
		Thread.sleep(3000);
		schedulePage.selectBffDropdown(driver, selectBff);
		schedulePage.enterScheduleTime(driver);
		schedulePage.clickOnBookButton(driver);
		Thread.sleep(2000);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnCancelBtn_Action(driver);
		schedulePage.enterCancelBookingReason(driver, reason);
		schedulePage.clickOnOkBtn_CancelBooking(driver);
		driver.navigate().refresh();
		schedulePage.enterKeywordSearch(driver, seekerCode);
		Thread.sleep(1000);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		Thread.sleep(1000);
		String text = schedulePage.captureCancelledText_Action(driver);
		Assert.assertEquals(text, "Cancelled");
	}

	@Test
	public void checkThatUserIsAbleToConfirmBookingAfterScheduleIsDone_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);

		String sourceType = "home";
		String maritalStatus = "SINGLE";
		String customerName = "RamyaPunith";
		String selectBff = generateRandomName_JavaFaker();
		String file = randomImage();

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.selectRefferralSourceType(driver, sourceType);
		String firstName = manageSeekerPage.enterFirstName(driver);
		String middleName = manageSeekerPage.enterMiddleName(driver);
		String lastName = manageSeekerPage.enterLastName(driver);
		String email = firstName + middleName + lastName + "@DEMO.COM";
		manageSeekerPage.enterEmail_2(driver, email);
		manageSeekerPage.enterMobileNumber(driver);
		manageSeekerPage.selectGender(driver);
		manageSeekerPage.enterDateOfBirth(driver);
		manageSeekerPage.selectMaritalStatus(driver, maritalStatus);
		manageSeekerPage.selectCustomerName(driver, customerName);
		manageSeekerPage.selectLanguages(driver);
		manageSeekerPage.enterAddress(driver);
		manageSeekerPage.enterInsuranceId(driver);
		manageSeekerPage.uploadProfile(driver, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.enterSeekerId(driver, seekerCode);
		schedulePage.clickOnSearchButton(driver);
		Thread.sleep(3000);
		schedulePage.selectBffDropdown(driver, selectBff);
		schedulePage.enterScheduleTime(driver);
		schedulePage.clickOnBookButton(driver);
		Thread.sleep(2000);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnConfirmBtn_Action(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Appointment Confirmed Successfully");
	}

	@Test
	public void verifyThatAfterBookingIsConfirmedSystemDisplayesConfirmedTextUnderAction_Test() throws Throwable {
		String sourceType = "home";
		String maritalStatus = "SINGLE";
		String customerName = "RamyaPunith";
		String selectBff = generateRandomNames(driver);
		String file = randomImage();

		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.selectRefferralSourceType(driver, sourceType);
		String firstName = manageSeekerPage.enterFirstName(driver);
		String middleName = manageSeekerPage.enterMiddleName(driver);
		String lastName = manageSeekerPage.enterLastName(driver);
		String email = firstName + middleName + lastName + "@DEMO.COM";
		manageSeekerPage.enterEmail_2(driver, email);
		manageSeekerPage.enterMobileNumber(driver);
		manageSeekerPage.selectGender(driver);
		manageSeekerPage.enterDateOfBirth(driver);
		manageSeekerPage.selectMaritalStatus(driver, maritalStatus);
		manageSeekerPage.selectCustomerName(driver, customerName);
		manageSeekerPage.selectLanguages(driver);
		manageSeekerPage.enterAddress(driver);
		manageSeekerPage.enterInsuranceId(driver);
		manageSeekerPage.uploadProfile(driver, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.enterSeekerId(driver, seekerCode);
		schedulePage.clickOnSearchButton(driver);
		Thread.sleep(3000);
		schedulePage.selectBffDropdown(driver, selectBff);
		schedulePage.enterScheduleTime(driver);
		schedulePage.clickOnBookButton(driver);
		Thread.sleep(2000);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnConfirmBtn_Action(driver);
		driver.navigate().refresh();
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		Thread.sleep(1000);
		String text = schedulePage.captureConfirmedText_Action(driver);
		Assert.assertEquals(text, "Confirmed");
	}

}
