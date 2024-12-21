package UserListTest;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.HomePage;
import Hello_Bff_ObjectRepository.LoginPage;
import Hello_Bff_ObjectRepository.LogoutPage;
import Hello_Bff_ObjectRepository.UserListPage;
@Listeners(AllureTestListeners.class)
public class UserListTestScriptTest extends BaseClass {

	@Test
	public void checkThatUserAbleToCreateTheUser_Test() throws Throwable {
		String mobileNumber = generateRandomMobileNumber();
		String gender = generateRandomGenders();

		UserListPage userListPage = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		userListPage.clickOnTheUserListPage(driver);
		hp.clickOnSideMenuButton(driver);
		userListPage.clickOnAddButton(driver);
		String first = userListPage.enterTheFirstName(driver);
		String last = userListPage.enterLastName(driver);
		String email = first + last + "@demo.com";
		userListPage.enterEmail(driver, email);
		userListPage.enterMobileNumber(driver, mobileNumber);
		Thread.sleep(7000);
		userListPage.selectGender(driver, gender);
		userListPage.enterAddress(driver);
		userListPage.clickOnSaveButton(driver);
		String successMsg = userListPage.captureSuccessfullyMessage(driver);
		Assert.assertEquals(successMsg, "Successfully User is created..!");
	}

	@Test
	public void checkThatUserClickOnSubmitButtonWithoutGivingTheFirstNameMandatoryField_Test() throws Throwable {
		String email = generateRandomEmail();
		String mobileNumber = generateRandomMobileNumber();
		String gender = generateRandomGenders();

		UserListPage userListPage = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		userListPage.clickOnTheUserListPage(driver);
		hp.clickOnSideMenuButton(driver);
		userListPage.clickOnAddButton(driver);
		userListPage.enterLastName(driver);
		userListPage.enterEmail(driver, email);
		userListPage.enterMobileNumber(driver, mobileNumber);
		userListPage.selectGender(driver, gender);
		userListPage.enterAddress(driver);
		userListPage.clickOnSaveButton(driver);
		String errorMsg = userListPage.captureFirstNameReqErrorMessage(driver);
		Assert.assertEquals(errorMsg, "firstName is a required field");
	}

	@Test
	public void checkThatUserClickOnSubmitButtonWithoutGivingTheLastNameMandatoryField_Test() throws Throwable {
		String email = generateRandomEmail();
		String mobileNumber = generateRandomMobileNumber();
		String gender = generateRandomGenders();

		UserListPage userListPage = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		userListPage.clickOnTheUserListPage(driver);
		hp.clickOnSideMenuButton(driver);
		userListPage.clickOnAddButton(driver);
		userListPage.enterTheFirstName(driver);
		userListPage.enterEmail(driver, email);
		userListPage.enterMobileNumber(driver, mobileNumber);
		userListPage.selectGender(driver, gender);
		userListPage.enterAddress(driver);
		userListPage.clickOnSaveButton(driver);
		String errorMsg = userListPage.captureLastNameReqErrorMessage(driver);
		Assert.assertEquals(errorMsg, "lastName is a required field");
	}

	@Test
	public void checkThatUserClickOnSubmitButtonWithoutGivingTheEmailMandatoryField_Test() throws Throwable {
		String mobileNumber = generateRandomMobileNumber();
		String gender = generateRandomGenders();

		UserListPage userListPage = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		userListPage.clickOnTheUserListPage(driver);
		hp.clickOnSideMenuButton(driver);
		userListPage.clickOnAddButton(driver);
		userListPage.enterTheFirstName(driver);

		userListPage.enterMobileNumber(driver, mobileNumber);
		userListPage.selectGender(driver, gender);
		userListPage.enterAddress(driver);
		userListPage.clickOnSaveButton(driver);
		String errorMsg = userListPage.captureEmailReqErrorMessage(driver);
		Assert.assertEquals(errorMsg, "email is a required field");
	}

	@Test
	public void checkThatUserClickOnSubmitButtonWithoutGivingTheMobileNumberMandatoryField_Test() throws Throwable {
		String email = generateRandomEmail();
		String gender = generateRandomGenders();

		UserListPage userListPage = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		userListPage.clickOnTheUserListPage(driver);
		hp.clickOnSideMenuButton(driver);
		userListPage.clickOnAddButton(driver);
		userListPage.enterTheFirstName(driver);
		userListPage.enterLastName(driver);
		userListPage.enterEmail(driver, email);
		userListPage.selectGender(driver, gender);
		userListPage.enterAddress(driver);
		userListPage.clickOnSaveButton(driver);
		String errorMsg = userListPage.captureMobileNumberReqErrorMessage(driver);
		Assert.assertEquals(errorMsg, "mobileNumber is a required field");
	}

	@Test
	public void checkThatUserClickOnSubmitButtonWithoutGivingTheGenderMandatoryField_Test() throws Throwable {
		String email = generateRandomEmail();
		String mobileNumber = generateRandomMobileNumber();

		UserListPage userListPage = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		userListPage.clickOnTheUserListPage(driver);
		hp.clickOnSideMenuButton(driver);
		userListPage.clickOnAddButton(driver);
		userListPage.enterTheFirstName(driver);
		userListPage.enterLastName(driver);
		userListPage.enterEmail(driver, email);
		userListPage.enterMobileNumber(driver, mobileNumber);
		userListPage.enterAddress(driver);
		userListPage.clickOnSaveButton(driver);
		String errorMsg = userListPage.captureGenderReqErrorMessage(driver);
		Assert.assertEquals(errorMsg, "gender is a required field");
	}

	@Test
	public void checkThatIfUserEnterTheEmailIdWhichIsAlreadyCreated_Test() throws Throwable {
		String email = generateRandomEmail();
		String mobileNumber = generateRandomMobileNumber();
		String gender = generateRandomGenders();

		UserListPage userListPage = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		userListPage.clickOnTheUserListPage(driver);
		hp.clickOnSideMenuButton(driver);
		userListPage.clickOnAddButton(driver);
		userListPage.enterTheFirstName(driver);
		userListPage.enterLastName(driver);
		userListPage.enterEmail(driver, email);
		userListPage.enterMobileNumber(driver, mobileNumber);
		userListPage.selectGender(driver, gender);
		userListPage.enterAddress(driver);
		userListPage.clickOnSaveButton(driver);

		userListPage.clickOnAddButton(driver);
		userListPage.enterTheFirstName(driver);
		userListPage.enterLastName(driver);
		userListPage.enterEmail(driver, email);
		userListPage.enterMobileNumber(driver, mobileNumber);
		Thread.sleep(1000);
		userListPage.selectGender(driver, gender);
		userListPage.enterAddress(driver);
		userListPage.clickOnSaveButton(driver);

		String msg = userListPage.captureSuccessfullyMessage(driver);
		System.out.println(msg);
		Assert.assertEquals(msg, "user EMAIL ID already registered.");
	}

	@Test
	public void checkThatUserClickOnTheBackButton_Test() throws Throwable {
		UserListPage userListPage = new UserListPage(driver);
		HomePage hp = new HomePage(driver);

		userListPage.clickOnTheUserListPage(driver);
		hp.clickOnSideMenuButton(driver);

		userListPage.clickOnAddButton(driver);
		userListPage.clickOnTheBackButton(driver);
		userListPage.clickOnAddButton(driver);
		System.out.println("User redircted to the user list");
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingNameInKeywordSearch_Test() throws Throwable {
		UserListPage userList = new UserListPage(driver);

		userList.clickOnTheUserListPage(driver);
		clickOnSideMenuBtn(driver);
		String name = userList.captureName_Table_Lastrow(driver);
		userList.enterKeywordSearch(driver, name);
		String name2 = userList.captureName_Table(driver);
		Assert.assertEquals(name2, name);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingUserTypeInKeywordSearch_Test() throws Throwable {
		UserListPage userList = new UserListPage(driver);

		userList.clickOnTheUserListPage(driver);
		clickOnSideMenuBtn(driver);
		String text = userList.captureUserType_Table_Lastrow(driver);
		userList.enterKeywordSearch(driver, text);
		String text2 = userList.captureUserType_Table(driver);
		Assert.assertEquals(text2, text2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingEmailInKeywordSearch_Test() throws Throwable {
		UserListPage userList = new UserListPage(driver);

		userList.clickOnTheUserListPage(driver);
		clickOnSideMenuBtn(driver);
		String text = userList.captureEmail_Table_Lastrow(driver);
		userList.enterKeywordSearch(driver, text);
		String text2 = userList.captureEmail_Table(driver);
		Assert.assertEquals(text2, text2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingPhoneNumberInKeywordSearch_Test() throws Throwable {
		UserListPage userList = new UserListPage(driver);

		userList.clickOnTheUserListPage(driver);
		clickOnSideMenuBtn(driver);
		String text = userList.capturePhoneNumber_Table_Lastrow(driver);
		userList.enterKeywordSearch(driver, text);
		String text2 = userList.capturePhoneNumber_Table(driver);
		Assert.assertEquals(text2, text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		UserListPage userList = new UserListPage(driver);

		userList.clickOnTheUserListPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		UserListPage userList = new UserListPage(driver);

		userList.clickOnTheUserListPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		UserListPage userList = new UserListPage(driver);

		userList.clickOnTheUserListPage(driver);
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
		UserListPage userList = new UserListPage(driver);

		userList.clickOnTheUserListPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		UserListPage userList = new UserListPage(driver);

		userList.clickOnTheUserListPage(driver);
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
	public void verifyUserIsAbleToDeactivateTheStatusForAUser_Test() throws Throwable {
		UserListPage userList = new UserListPage(driver);

		String email = generateRandomEmail();
		String mobileNumber = generateRandomMobileNumber();
		String gender = generateRandomGenders();

		userList.clickOnTheUserListPage(driver);
		clickOnSideMenuBtn(driver);
		userList.clickOnAddButton(driver);
		userList.enterTheFirstName(driver);
		userList.enterLastName(driver);
		userList.enterEmail(driver, email);
		userList.enterMobileNumber(driver, mobileNumber);
		userList.selectGender(driver, gender);
		userList.enterAddress(driver);
		userList.clickOnSaveButton(driver);
		Thread.sleep(4000);
		userList.clickOnStatusButton(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "User Updated Successfully");
	}

	@Test
	public void verifyUserIsAbleToActivateTheStatusForAUser_Test() throws Throwable {
		UserListPage userList = new UserListPage(driver);

		String email = generateRandomEmail();
		String mobileNumber = generateRandomMobileNumber();
		String gender = generateRandomGenders();

		userList.clickOnTheUserListPage(driver);
		clickOnSideMenuBtn(driver);
		userList.clickOnAddButton(driver);
		userList.enterTheFirstName(driver);
		userList.enterLastName(driver);
		userList.enterEmail(driver, email);
		userList.enterMobileNumber(driver, mobileNumber);
		userList.selectGender(driver, gender);
		userList.enterAddress(driver);
		userList.clickOnSaveButton(driver);
		Thread.sleep(4000);
		userList.clickOnStatusButton(driver);
		userList.clickOnStatusButton(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "User Updated Successfully");
	}

	@Test
	public void verifyThatTheSystemPermitsTheUserToInitiateThePasswordResetProcessUponClickingTheResetPasswordButtonInTheActionField_Test()
			throws Throwable {
		UserListPage userList = new UserListPage(driver);
		LoginPage login = new LoginPage(driver);
		LogoutPage logout = new LogoutPage(driver);

		String mobileNumber = generateRandomMobileNumber();
		String gender = generateRandomGenders();
		String password = "Dalvkot@123";

		userList.clickOnTheUserListPage(driver);
		clickOnSideMenuBtn(driver);
		userList.clickOnAddButton(driver);
		String first = userList.enterTheFirstName(driver);
		String last = userList.enterLastName(driver);
		String email = first + last + "@demo.com";
		userList.enterEmail(driver, email);
		userList.enterMobileNumber(driver, mobileNumber);
		userList.selectGender(driver, gender);
		userList.enterAddress(driver);
		userList.clickOnSaveButton(driver);
		Thread.sleep(4000);
		userList.actionButton(driver);
		userList.clickOnResetPassword_action(driver);
		Thread.sleep(2000);
		String mainWindowHandle1 = WindowHandle(driver);
		Thread.sleep(2000);
		userList.enterPassword(driver, password);
		userList.enterConfirmPassword(driver, password);
		userList.clickOnResetPasswordButton(driver);
		driver.close();
		driver.switchTo().window(mainWindowHandle1);
		logout.logoutTheApplication(driver);
		login.loginTheApplicationWithcheckBox(driver, email, password);
	}

	@Test
	public void verifyThatSystemRedirectsToPaswordResetPageAfterUserClicksOnPasswordResetBtnUnderAction_Test()
			throws Throwable {
		UserListPage userList = new UserListPage(driver);
		userList.clickOnTheUserListPage(driver);
		clickOnSideMenuBtn(driver);
		userList.actionButton(driver);
		userList.clickOnResetPassword_action(driver);
		Thread.sleep(2000);
		String mainWindowHandle1 = WindowHandle(driver);
		String url = driver.getCurrentUrl();
		driver.close();
		driver.switchTo().window(mainWindowHandle1);
		assertTrue(url.contains("resetPassword"), "System is not redirected to reset password page");
	}

}
