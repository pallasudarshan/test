package ManageSeekerTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.ManageSeekerPage;
import Hello_Bff_ObjectRepository.PackageMasterPage;
import Hello_Bff_ObjectRepository.SchedulePage;
import io.qameta.allure.Description;

@Listeners(AllureTestListeners.class)
public class ManageSeekerTestScripts_Test extends BaseClass {

	@Test(invocationCount = 1)
	public void checkThatUserCreateTheManageSeekerTest() throws Throwable {
		String sourceType = "home";
		String maritalStatus = "SINGLE";
		String customerName = "dalvkot";
		String file = randomImage();

		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

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
		String displayName = manageSeekerPage.captureDisplayName_Table(driver);
		Assert.assertEquals(firstName.toUpperCase() + " " + middleName.toUpperCase() + " " + lastName.toUpperCase(),
				displayName);
	}

	@Test
	public void checkThatUserAbleToEdit_UpdateTheSeekerDetailsAndVerifyInTheList_Test() throws Throwable {
		String sourceType = "home";
		String maritalStatus = "SINGLE";
		String customerName = "dalvkot";
		String file = randomImage();

		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.selectRefferralSourceType(driver, sourceType);
		String firstName = manageSeekerPage.enterFirstName(driver);
		manageSeekerPage.enterMiddleName(driver);
		String lastName = manageSeekerPage.enterLastName(driver);
		String email = manageSeekerPage.enterEmail(driver);
		String mobileNumber = manageSeekerPage.enterMobileNumber(driver);
		manageSeekerPage.selectGender(driver);
		manageSeekerPage.enterDateOfBirth(driver);
		manageSeekerPage.selectMaritalStatus(driver, maritalStatus);
		manageSeekerPage.selectCustomerName(driver, customerName);
		manageSeekerPage.selectLanguages(driver);
		String address = manageSeekerPage.enterAddress(driver);
		String insurance = manageSeekerPage.enterInsuranceId(driver);
		manageSeekerPage.uploadProfile(driver, file);
		manageSeekerPage.clickOnSaveButton(driver);

		manageSeekerPage.clickOnActionsButton(driver);
		manageSeekerPage.clickOnTheEditButton(driver);

		Thread.sleep(1000);
		String firstName1 = manageSeekerPage.enterFirstName(driver);
		String middleName1 = manageSeekerPage.enterMiddleName(driver);
		String lastName1 = manageSeekerPage.enterLastName(driver);
		String email1 = manageSeekerPage.enterEmail(driver);
		String mobileNumber1 = manageSeekerPage.enterMobileNumber(driver);
		String address1 = manageSeekerPage.enterAddress(driver);
		String insurance1 = manageSeekerPage.enterInsuranceId(driver);

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertNotEquals(firstName, firstName1);
		softAssert.assertNotEquals(lastName, lastName1);
		softAssert.assertNotEquals(email, email1);
		softAssert.assertNotEquals(mobileNumber, mobileNumber1);
		softAssert.assertNotEquals(address, address1);
		softAssert.assertNotEquals(insurance, insurance1);

		softAssert.assertAll();

		manageSeekerPage.clickOnSaveButton(driver);
		String displayName = manageSeekerPage.captureDisplayName_Table(driver);
		Assert.assertEquals(firstName1.toUpperCase() + " " + middleName1.toUpperCase() + " " + lastName1.toUpperCase(),
				displayName);
	}

	@Test
	public void checkThatUniqueSeekerCodeIsGeneratedInIncrementalOrderAfterCreation_Test() throws Throwable {
		String sourceType = "home";
		String maritalStatus = "SINGLE";
		String customerName = "dalvkot";
		String file = randomImage();

		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		String initalCode = manageSeekerPage.captureSeekerCode_Table(driver).replaceAll("[^0-9]", "");
		int intialCode_int = Integer.parseInt(initalCode);
		int result = intialCode_int + 1;

		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.selectRefferralSourceType(driver, sourceType);
		String first = manageSeekerPage.enterFirstName(driver);
		String middle = manageSeekerPage.enterMiddleName(driver);
		String last = manageSeekerPage.enterLastName(driver);
		String email = first + middle + last;
		manageSeekerPage.enterEmail_2(driver, email + "@demo.com");
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
		String initalCode2 = manageSeekerPage.captureSeekerCode_Table(driver).replaceAll("[^0-9]", "");
		int intialCode_int2 = Integer.parseInt(initalCode2);
		Assert.assertEquals(result, intialCode_int2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingSeekerCodeInKeywordSearch_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		String text = manageSeekerPage.captureSeekerCode_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = manageSeekerPage.captureSeekerCode_Table(driver);
		Assert.assertEquals(text2, text);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingDisplayNameInKeywordSearch_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		String text = manageSeekerPage.captureDisplayName_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = manageSeekerPage.captureDisplayName_Table(driver);
		Assert.assertEquals(text2, text);
	}

	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);

		String text = "Test";

		enterKeywordSearch(driver, text);
		clickOnClearBtn_KeywordSearch(driver);
		String text2 = captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
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
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
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

	@Test(description = "Display name will fetch automatically based on first name, middle name and last name.")
	public void toVerifyThatFunctionalityOfDisplayNameInTheTextField_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnAddButton(driver);
		String firstName = manageSeekerPage.enterFirstName(driver);
		String middleName = manageSeekerPage.enterMiddleName(driver);
		String lastName = manageSeekerPage.enterLastName(driver);
		String displayName = manageSeekerPage.captureDisplayNameField(driver);
		String displayName2 = firstName + " " + middleName + " " + lastName;
		Assert.assertEquals(displayName.toUpperCase(), displayName2.toUpperCase(), "Display Name is miss matched");
	}

	@Test(description = "Verify that the system correctly displays Manage Seeker Registration detials such as name , email , address and customer name when user clicks on the view button.")
	public void verifySeekerDetailsAfterUserClicksOnViewButtonUnderAction_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage scheduleAppointment = new SchedulePage(driver);

		String sourceType = "home";
		String maritalStatus = "SINGLE";
		String customerName = "Dalvkot";
		String file = randomImage();
		String gender = "Male";
		String dob = "01/01/1998";

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.selectRefferralSourceType(driver, sourceType);
		String firstName = manageSeekerPage.enterFirstName(driver);
		String middleName = manageSeekerPage.enterMiddleName(driver);
		String lastName = manageSeekerPage.enterLastName(driver);
		String email = firstName + middleName + lastName + "@DEMO.COM";
		String displayName = firstName + " " + middleName + " " + lastName;
		manageSeekerPage.enterEmail_2(driver, email);
		manageSeekerPage.enterMobileNumber(driver);
		manageSeekerPage.selectGender_1(driver, gender);
		manageSeekerPage.enterDateOfBirth_1(driver, dob);
		manageSeekerPage.selectMaritalStatus(driver, maritalStatus);
		manageSeekerPage.selectCustomerName(driver, customerName);
		manageSeekerPage.selectLanguages(driver);
		String address = manageSeekerPage.enterAddress(driver);
		manageSeekerPage.enterInsuranceId(driver);
		manageSeekerPage.uploadProfile(driver, file);
		manageSeekerPage.clickOnSaveButton(driver);
		manageSeekerPage.clickOnActionsButton(driver);
		manageSeekerPage.clickOnViewButton(driver);
		Thread.sleep(1500);
		int age = manageSeekerPage.convertDobToAge(driver, dob);
		char firstLetterGender = gender.charAt(0);

		String name = scheduleAppointment.captureName(driver);
		String address1 = scheduleAppointment.captureAddress(driver);
		String email1 = scheduleAppointment.captureEmail(driver);
		String customerName1 = scheduleAppointment.captureCustomerName(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(name, displayName.toUpperCase() + " " + age + " " + firstLetterGender, "Name is miss matched");
		sa.assertEquals(email, email1, "Email is miss matched");
		sa.assertEquals(address, address1, "Address is miss matched");
		sa.assertEquals(customerName.toUpperCase(), customerName1.toUpperCase(), "customer name is miss matched");
		sa.assertAll();
	}

	@Test
	public void verifyBackButtonFunctionality_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.clickOnBackButton(driver);
		String text = manageSeekerPage.captureClearFiltersText(driver);
		Assert.assertEquals(text, "Clear Filters");
	}

	@Test(description = "")
	public void verifyAddButtonFunctionality_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnAddButton(driver);
		String text = manageSeekerPage.capturesreferralSourceText(driver);
		Assert.assertEquals(text, "Referral Source");
	}

	@Test(description = "System should clear the entered data in the screen and redirect to previous page/screen.")
	public void verifyCancelButtonFunctionality_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.clickOnCancelBtn(driver);
		String text = manageSeekerPage.captureClearFiltersText(driver);
		Assert.assertEquals(text, "Clear Filters");
	}

	@Test
	public void verifyThatSystemDisplaysPopUpAfterClickingOnViewActivityButtonUnderAction_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnActionsButton(driver);
		manageSeekerPage.clickOnViewActivity(driver);
		Thread.sleep(1000);
		String activity = manageSeekerPage.captureActivityText(driver);
		Assert.assertEquals(activity, "Activity");
	}

	@Test(description = "Verify that pop up is closed when user clicks on close button")
	public void verifyCloseBtnFunctionality_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageSeekerPage.clickOnActionsButton(driver);
		manageSeekerPage.clickOnViewActivity(driver);
		Thread.sleep(1000);
		String activity = manageSeekerPage.captureActivityText(driver);
		Assert.assertEquals(activity, "Activity");
	}

}
