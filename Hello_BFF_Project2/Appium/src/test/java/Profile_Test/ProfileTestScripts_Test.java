package Profile_Test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility_Appium.BaseClass_Appium;
import Hello_Bff_ObjectRepository.LoginPage;
import Hello_Bff_ObjectRepository.UserListPage;
import ObjectRepository_Appium.ProfilePage;

public class ProfileTestScripts_Test extends BaseClass_Appium {

	@OpenBrowser
	@Test
	public void test() throws Throwable {
		LoginPage lp = new LoginPage(driver);

		lp.loginTheApplication(driver, "https://test.vykohms.com/hellobff-qa/#/auth/login", "surya.v@dalvkot.com",
				"Dalvkot@123");

		UserListPage userList = new UserListPage(driver);
		ProfilePage profile = new ProfilePage(androidDriver);

		String text = "soumya@dalvkot.com";

		userList.clickOnTheUserListPage(driver);
		userList.clickOnSideMenuBtn(driver);
		userList.enterKeywordSearch(driver, text);
		String name = userList.captureNameFirstrow_Table(driver);
//		String mobile = userList.captureMobileNumberReqErrorMessage(driver);
//		String email = userList.captureEmailFirstrow_Table(driver);
//		userList.clickOnEditButton(driver);
//		String address = userList.captureAddressTextField(driver);

		profile.clickOnProfileBtn(androidDriver);
		String name2 = profile.captureName(androidDriver);
		System.out.println();
		System.out.println();
		Assert.assertEquals(name, name2);
	}
}
