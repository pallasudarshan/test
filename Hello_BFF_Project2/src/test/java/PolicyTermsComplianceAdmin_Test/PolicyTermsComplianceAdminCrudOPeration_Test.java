package PolicyTermsComplianceAdmin_Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.NewsRoomPage;
import Hello_Bff_ObjectRepository.PolicyTermsAndComplainceAdminPage;
@Listeners(AllureTestListeners.class)
public class PolicyTermsComplianceAdminCrudOPeration_Test extends BaseClass {

	@Test
	public void createPolicyAndTermsForTypePolicy_Test() throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);

		String type = "policy";
		String categoryType = "Therapy session logs";
		String userType = "Customer";
		String title = ptc.randomPolicyTitles(driver);
		String template = generateRandomDescriptionData(900);

		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		ptc.clickOnAddBtn(driver);
		ptc.selectAType(driver, type);
		ptc.selectCategoryTypeDropDown(driver, categoryType);
		ptc.selectUserTypeDropDown(driver, userType);
		ptc.enterPolicyTitle(driver, title);
		ptc.enterTemplate(driver, template);
		ptc.clickOnSaveBtn(driver);
		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "Successfully created");
	}

	@Test
	public void createPolicyAndTermsForTypeTermsAndConiditon_Test() throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);

		String type = "Terms & Condition";
		String categoryType = "Other";
		String Type = "Seeker";
		String title = ptc.randomPolicyTitles(driver);
		String template = generateRandomDescriptionData(900);

		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		ptc.clickOnAddBtn(driver);
		ptc.selectAType(driver, type);
		ptc.selectATermsAndConditionCategory(driver, categoryType);
		ptc.selectATermsAndConditionFor(driver, Type);
		ptc.enterTermsAndConditionTitle(driver, title);
		ptc.enterTemplate(driver, template);
		ptc.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Successfully created");
	}

	@Test
	public void checkThatUserIsAbleToEditAndUpdateTheCreatedTermsAndCondition_Test() throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);

		String type = "Terms & Condition";
		String categoryType = "Other";
		String userType = "Seeker";
		String title = ptc.randomPolicyTitles(driver);
		String template = generateRandomDescriptionData(100);

		String categoryType2 = "Home";
		String userType2 = "customer";
		String title2 = ptc.randomPolicyTitles(driver);
		String template2 = generateRandomDescriptionData(100);

		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		ptc.clickOnAddBtn(driver);
		ptc.selectAType(driver, type);
		ptc.selectATermsAndConditionCategory(driver, categoryType);
		ptc.selectATermsAndConditionFor(driver, userType);
		ptc.enterTermsAndConditionTitle(driver, title);
		ptc.enterTemplate(driver, template);
		ptc.clickOnSaveBtn(driver);

		ptc.clickOnEditUnderAction(driver);
		ptc.selectATermsAndConditionCategory(driver, categoryType2);
		ptc.selectATermsAndConditionFor(driver, userType2);
		ptc.enterTermsAndConditionTitle(driver, title2);
		ptc.enterTemplate(driver, template2);
		ptc.clickOnSaveBtn(driver);
		Thread.sleep(2500);
		String type3 = ptc.capturePolicyType_Table(driver);
		String category3 = ptc.captureCategoryType_Table(driver);
		String userType3 = ptc.captureUserType_Table(driver);
		String title3 = ptc.captureTitle_Table(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(type3, type, "type is missmatched");
		sa.assertEquals(category3, categoryType2, "category is miss matched");
		sa.assertEquals(userType3, userType2, "user type is miss matched");
		sa.assertEquals(title3, title2, "title is miss matched");
		sa.assertAll();
	}

	@Test
	public void createPolicyTermsAndVerifyDetailsInTheListScreen_Test() throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);

		String type = "Policy";
		String categoryType = "Therapy Session Logs";
		String userType = "customer";
		String title = ptc.randomPolicyTitles(driver);
		String template = generateRandomDescriptionData(900);

		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		ptc.clickOnAddBtn(driver);
		ptc.selectAType(driver, type);
		ptc.selectCategoryTypeDropDown(driver, categoryType);
		ptc.selectUserTypeDropDown(driver, userType);
		ptc.enterPolicyTitle(driver, title);
		ptc.enterTemplate(driver, template);
		ptc.clickOnSaveBtn(driver);
		Thread.sleep(2500);
		String type3 = ptc.capturePolicyType_Table(driver);
		String category3 = ptc.captureCategoryType_Table(driver);
		String userType3 = ptc.captureUserType_Table(driver);
		String title3 = ptc.captureTitle_Table(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(type3, type, "type is missmatched");
		sa.assertEquals(category3, categoryType, "category is miss matched");
		sa.assertEquals(userType3, userType, "user type is miss matched");
		sa.assertEquals(title3, title, "title is miss matched");
		sa.assertAll();
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingPolicyTermsAndConditionCodeInKeywordSearch_Test()
			throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String text = ptc.capturePolicyTermsAndConditionCode_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = ptc.capturePolicyTermsAndConditionCode_Table(driver);
		Assert.assertEquals(text, text2);
	}
	
	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingPolicyTypeInKeywordSearch_Test()
			throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String text = ptc.capturePolicyType_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = ptc.capturePolicyType_Table(driver);
		Assert.assertEquals(text, text2);
	}
	
	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingCategoryTypeInKeywordSearch_Test()
			throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String text = ptc.captureCategoryType_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = ptc.captureCategoryType_Table(driver);
		Assert.assertEquals(text, text2);
	}
	
	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingUserTypeInKeywordSearch_Test()
			throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String text = ptc.captureUserType_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = ptc.captureUserType_Table(driver);
		Assert.assertEquals(text, text2);
	}
	
	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingTitleInKeywordSearch_Test()
			throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String text = ptc.captureTitle_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = ptc.captureTitle_Table(driver);
		Assert.assertEquals(text, text2);
	}
	
	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);

		String text = "Test";

		enterKeywordSearch(driver, text);
		clickOnClearBtn_KeywordSearch(driver);
		String text2 = captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
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
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
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
	public void verifyCancelButtonFunctionality_Test()
			throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		ptc.clickOnAddBtn(driver);
		ptc.clickOnCancelBtn(driver);
        String text = ptc.capturePolicyTermsText(driver);
        Assert.assertEquals(text, "Policy, Terms & Compliance Admin","text not found");
	}
	
	@Test
	public void verifyBackButtonFunctionality_Test()
			throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		ptc.clickOnAddBtn(driver);
		ptc.clickOnBackBtn(driver);
        String text = ptc.capturePolicyTermsText(driver);
        Assert.assertEquals(text, "Policy, Terms & Compliance Admin","text not found");
	}
	
	@Test
	public void verifyAddButtonFunctionality_Test()
			throws Throwable {
		PolicyTermsAndComplainceAdminPage ptc = new PolicyTermsAndComplainceAdminPage(driver);
		ptc.clickOnTermsAndComplianceAdminScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		ptc.clickOnAddBtn(driver);
		ptc.verifyAddBtnRedirectsToCreationPage(driver);
	}
	
}
