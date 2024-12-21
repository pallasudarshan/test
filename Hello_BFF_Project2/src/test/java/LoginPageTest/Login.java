package LoginPageTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.LoginPage;
import Hello_Bff_ObjectRepository.LogoutPage;
@Listeners(AllureTestListeners.class)
public class Login extends BaseClass {

	@Test
	public void checkThatUserAbleToClickOnSendOTP_ButtonWithputEnterEmailTest() throws Throwable {
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");

		LoginPage lp = new LoginPage(driver);
		LogoutPage out = new LogoutPage(driver);

		out.logoutTheApplication(driver);
		lp.clickOnEnterPasswordBtn(driver);
		String errorMsg = lp.captureTheErrorMessage(driver);
		lp.loginTheApplication(driver, username, password);
		Assert.assertEquals("email is a required field", errorMsg);
	}

	@Test
	public void checkThatUserAbleToEnterInvalidEmailAndClickOnTheSendOtpButton_Test() throws Throwable {
		String email = "test";
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");

		LoginPage lp = new LoginPage(driver);
		LogoutPage out = new LogoutPage(driver);

		out.logoutTheApplication(driver);
		lp.enterTheEmail(driver, email);
		lp.clickOnEnterPasswordBtn(driver);
		String errorMsg = lp.captureTheErrorMessage(driver);
		lp.loginTheApplication(driver, username, password);
		Assert.assertEquals("Enter a valid email", errorMsg);
	}

	@Test
	public void checkThatTryToLoginTheNotRegisteredUserAndVerifyTheErrorPopupMessageTest() throws Throwable {
		String email = "testadasd@dalvkot.com";
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");

		LoginPage lp = new LoginPage(driver);
		LogoutPage out = new LogoutPage(driver);

		out.logoutTheApplication(driver);
		lp.enterTheEmail(driver, email);
		lp.clickOnEnterPasswordBtn(driver);
		String errorMsg = lp.captureTheErrorMessageCorners(driver);
		lp.loginTheApplication(driver, username, password);
		Assert.assertEquals("Not a registered user!", errorMsg);
	}

	@Test
	public void checkThatUserAbleToEnterTheCorrectEmailAndWrongPasswordAndVerifyTheErrorMessage_Test()
			throws Throwable {
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");
		String password1 = "test";

		LoginPage lp = new LoginPage(driver);
		LogoutPage out = new LogoutPage(driver);

		out.logoutTheApplication(driver);
		lp.enterTheEmail(driver, username);
		lp.clickOnEnterPasswordBtn(driver);
		lp.enterThePassword(driver, password1);
		String errorMsg = lp.captureErrorMessageOfInvalidPassword(driver);
		lp.enterThePassword(driver, password);
		lp.clickOnSignInButton(driver);
		Assert.assertEquals("Enter Valid Password", errorMsg);
	}

	/*
	 * @Test public void
	 * checkThatUserAbleToEnterTheCorrectEmailAndWrongStrongPassword_Test() throws
	 * Throwable { String username = futil.getProperyKeyValue("username"); String
	 * password = futil.getProperyKeyValue("password"); String password1 =
	 * "testTest@123";
	 * 
	 * LoginPage lp = new LoginPage(driver); LogoutPage out = new
	 * LogoutPage(driver);
	 * 
	 * out.logoutTheApplication(driver); lp.enterTheEmail(driver, username);
	 * lp.clickOnTheSendOTP(driver); lp.enterThePassword(driver, password1);
	 * lp.clickOnSignInButton(driver); String errorMsg =
	 * lp.captureTheErrorMessageCorners(driver); lp.enterThePassword(driver,
	 * password); lp.clickOnSignInButton(driver); lp.clickOnSignInButton(driver);
	 * Assert.assertEquals("Enter Valid Password", errorMsg);
	 * 
	 * }
	 */

	@Test
	public void checkThatUserAbleToClickOnTheSendEmailButtonWithoutPassingTheEmailInTheForgotPasswordPopup_Test()
			throws Throwable {
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");

		LoginPage lp = new LoginPage(driver);
		LogoutPage out = new LogoutPage(driver);

		out.logoutTheApplication(driver);
		lp.clickOnTheForgotPasswordButton(driver);
		lp.clickOnTheSendEmailButtonForgotPasswordPopup(driver);
		String msg = lp.captureTheErrorMessageCorners(driver);
		lp.clickOnTheCancelButtonForgotPasswordPopup(driver);
		lp.loginTheApplication(driver, username, password);
		Assert.assertEquals("Please enter Email Id", msg);
	}

	@Test
	public void checkThatUserEnterTheWrongEmailInTheTextOfForgotPasswordPopupText_Test() throws Throwable {
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");
		String email = "test";

		LoginPage lp = new LoginPage(driver);
		LogoutPage out = new LogoutPage(driver);

		out.logoutTheApplication(driver);
		lp.clickOnTheForgotPasswordButton(driver);
		lp.enterEmailTextForgotPassword(driver, email);
		lp.clickOnTheSendEmailButtonForgotPasswordPopup(driver);
		String msg = lp.captureEmailInvalidErrorMessage(driver);
		String msg1 = lp.captureTheErrorMessageCorners(driver);
		lp.clickOnTheCancelButtonForgotPasswordPopup(driver);
		lp.loginTheApplication(driver, username, password);

		Assert.assertEquals("Enter a valid email", msg);
		Assert.assertEquals("user not found", msg1);
	}

	@Test
	public void checkThatUserSendTheForgotPasswordToTheUnregistredUserAndVerifyTheErrorMessage_Test() throws Throwable {
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");
		String email = "test";

		LoginPage lp = new LoginPage(driver);
		LogoutPage out = new LogoutPage(driver);

		out.logoutTheApplication(driver);
		lp.clickOnTheForgotPasswordButton(driver);
		lp.enterEmailTextForgotPassword(driver, email);
		lp.clickOnTheSendEmailButtonForgotPasswordPopup(driver);
		String msg1 = lp.captureTheErrorMessageCorners(driver);
		lp.clickOnTheCancelButtonForgotPasswordPopup(driver);
		lp.loginTheApplication(driver, username, password);

		Assert.assertEquals("user not found", msg1);
	}

	@Test
	public void checkThatUserSendTheForgotPassowrdLinkToTheRespctiveUser_Test() throws Throwable {
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");

		LoginPage lp = new LoginPage(driver);
		LogoutPage out = new LogoutPage(driver);

		out.logoutTheApplication(driver);
		lp.enterTheEmail(driver, username);
		lp.clickOnTheSendOTP(driver);
		lp.clickOnTheForgotPasswordButton(driver);
		lp.clickOnTheSendEmailButtonForgotPasswordPopup(driver);
		String msg = lp.captureTheErrorMessageCorners(driver);
		lp.enterThePassword(driver, password);
		lp.clickOnSignInButton(driver);

		Assert.assertEquals("reset password link is sent to your email.", msg);
	}

}