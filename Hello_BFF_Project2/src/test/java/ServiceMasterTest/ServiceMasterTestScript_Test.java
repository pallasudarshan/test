package ServiceMasterTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.HomePage;
import Hello_Bff_ObjectRepository.PackageMasterPage;
import Hello_Bff_ObjectRepository.ServiceMasterPage;

@Listeners(AllureTestListeners.class)
public class ServiceMasterTestScript_Test extends BaseClass {

	@Test(invocationCount = 1)
	public void checkThatUserCreateTheServiceMasterForCodeTypeAsCPT_Test() throws Throwable {

		String maxQuantity = "45";
		String codeType = "CPT";

		ServiceMasterPage sp = new ServiceMasterPage(driver);
		HomePage hp = new HomePage(driver);

		sp.clickOnServiceMasterPageButton(driver);
		hp.clickOnSideMenuButton(driver);
		sp.clickOnNewButton(driver);
		sp.selectBillingType(driver, codeType);
		sp.enterBillingCode(driver);
		sp.enterBillingDescription(driver);
		sp.enterBillingeRate(driver);
		sp.enterMaxQuantity(driver, maxQuantity);
		sp.clickOnSaveButton(driver);
		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "successfully services has been created");
	}

	@Test(invocationCount = 1)
	public void checkThatUserCreateTheServiceMasterForCodeTypeAsICD_Test() throws Throwable {

		String maxQuantity = "45";
		String codeType = "ICD";

		ServiceMasterPage sp = new ServiceMasterPage(driver);
		HomePage hp = new HomePage(driver);

		sp.clickOnServiceMasterPageButton(driver);
		hp.clickOnSideMenuButton(driver);
		sp.clickOnNewButton(driver);
		sp.selectBillingType(driver, codeType);
		sp.enterBillingCode(driver);
		sp.enterBillingDescription(driver);
		sp.enterBillingeRate(driver);
		sp.enterMaxQuantity(driver, maxQuantity);
		sp.clickOnSaveButton(driver);
		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "successfully services has been created");
	}

	@Test
	public void checkThatUserEdit_UpdateTheDetailsAndVerifyInTheList_Test() throws Throwable {
		String maxQuantity = "45";
		String codeType = "ICD";

		ServiceMasterPage sp = new ServiceMasterPage(driver);
		HomePage hp = new HomePage(driver);

		sp.clickOnServiceMasterPageButton(driver);
		hp.clickOnSideMenuButton(driver);
		sp.clickOnNewButton(driver);
		sp.selectBillingType(driver, codeType);
		String serviceCode = sp.enterBillingCode(driver);
		String serviceDescription = sp.enterBillingDescription(driver);
		String serviceRate = sp.enterBillingeRate(driver);
		sp.enterMaxQuantity(driver, maxQuantity);
		sp.clickOnSaveButton(driver);

		sp.searchFilterText(driver, serviceCode);
		sp.clickOnActionsEditButton(driver);

		sp.serviceDetailsPopupClearFiledsData(driver);

		String maxQuantity1 = "34";
		String serviceCode1 = sp.enterBillingCode(driver);
		String serviceDescription1 = sp.enterBillingDescription(driver);
		String serviceRate1 = sp.enterBillingeRate(driver);
		sp.enterMaxQuantity(driver, maxQuantity1);
		sp.clickOnSaveButton(driver);

		SoftAssert as = new SoftAssert();
		as.assertNotEquals(serviceCode, serviceCode1);
		as.assertNotEquals(serviceDescription, serviceDescription1);
		as.assertNotEquals(serviceRate, serviceRate1);
		as.assertNotEquals(maxQuantity, maxQuantity1);
		System.out.println(serviceCode + "service code " + serviceCode1);
		as.assertAll();

	}

	@Test
	public void checkThatUserDeleteTheDetailsAndVerifyInTheListWheatherItsDeletedOrNot_Test() throws Throwable {
		String maxQuantity = "45";
		String codeType = "ICD";

		ServiceMasterPage sp = new ServiceMasterPage(driver);
		HomePage hp = new HomePage(driver);

		sp.clickOnServiceMasterPageButton(driver);
		hp.clickOnSideMenuButton(driver);

		sp.clickOnNewButton(driver);
		sp.selectBillingType(driver, codeType);
		String serviceCode = sp.enterBillingCode(driver);
		String serviceDescription = sp.enterBillingDescription(driver);
		String serviceRate = sp.enterBillingeRate(driver);
		sp.enterMaxQuantity(driver, maxQuantity);
		sp.clickOnSaveButton(driver);

		sp.searchFilterText(driver, serviceCode.replace(" ", ""));
		sp.clickOnActionsEditButton(driver);

		sp.serviceDetailsPopupClearFiledsData(driver);

		String maxQuantity1 = "34";
		String serviceCode1 = sp.enterBillingCode(driver);
		String serviceDescription1 = sp.enterBillingDescription(driver);
		String serviceRate1 = sp.enterBillingeRate(driver);
		sp.enterMaxQuantity(driver, maxQuantity1);
		sp.clickOnSaveButton(driver);

		SoftAssert as = new SoftAssert();
		as.assertNotEquals(serviceCode, serviceCode1);
		as.assertNotEquals(serviceDescription, serviceDescription1);
		as.assertNotEquals(serviceRate, serviceRate1);
		as.assertNotEquals(maxQuantity, maxQuantity1);
		System.out.println(serviceCode + "service code " + serviceCode1);

		as.assertAll();
		sp.searchFilterText(driver, serviceCode1);
		sp.clickOnActionsDeleteButton(driver);
		sp.clickOnYesInTheDelecteAction(driver);

		sp.searchFilterText(driver, serviceCode1);
		String serviceCode2 = sp.captureServiceCodeFirstRowTable(driver);
		Assert.assertNotEquals(serviceCode1, serviceCode2);
	}

	@Test
	public void verifyThatCreatedServicesAreReflecitingInPackageMasterScreen_Test() throws Throwable {
		ServiceMasterPage sp = new ServiceMasterPage(driver);
		PackageMasterPage pm = new PackageMasterPage(driver);

		String maxQuantity = "45";
		String codeType = "CPT";

		sp.clickOnServiceMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		sp.clickOnNewButton(driver);
		sp.selectBillingType(driver, codeType);
		sp.enterBillingCode(driver);
		String serviceName = sp.enterBillingDescription(driver);
		sp.enterBillingeRate(driver);
		sp.enterMaxQuantity(driver, maxQuantity);
		sp.clickOnSaveButton(driver);
		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "successfully services has been created");

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		pm.enterPackageName(driver);
		String sn2 = pm.captureServiceName1stDropDownData(driver, serviceName);
		Assert.assertTrue(sn2.contains(serviceName));
	}

	@Test
	public void verifyThatDeactivatedServicesAreNotReflectingInPackageMasterScrreen_Test() throws Throwable {
		ServiceMasterPage sp = new ServiceMasterPage(driver);
		PackageMasterPage pm = new PackageMasterPage(driver);

		String maxQuantity = "45";
		String codeType = "CPT";

		sp.clickOnServiceMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		sp.clickOnNewButton(driver);
		sp.selectBillingType(driver, codeType);
		sp.enterBillingCode(driver);
		String serviceName = sp.enterBillingDescription(driver);
		sp.enterBillingeRate(driver);
		sp.enterMaxQuantity(driver, maxQuantity);
		sp.clickOnSaveButton(driver);
		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "successfully services has been created");
		sp.clickOnStatusToggleBtn(driver);
		Thread.sleep(1000);

		pm.clickOnThePackageMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		pm.clickOnNewButton(driver);
		pm.enterPackageName(driver);
		String sn2 = pm.captureServiceName1stDropDownData_2(driver, serviceName);
		Assert.assertEquals("No results found", sn2);
	}
	
	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingBillingCodeInKeywordSearch_Test() throws Throwable {
		ServiceMasterPage sp = new ServiceMasterPage(driver);

		sp.clickOnServiceMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		String text = sp.captureBillingCode_Table_Lastrow(driver);
		sp.enterSearch(driver, text);
		String text2 = sp.captureBillingCode_Table(driver);
		Assert.assertEquals(text2, text);
	}
	
	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingBillingDescriptionInKeywordSearch_Test() throws Throwable {
		ServiceMasterPage sp = new ServiceMasterPage(driver);

		sp.clickOnServiceMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		String text = sp.captureBillingDescription_Table_Lastrow(driver);
		sp.enterSearch(driver, text);
		String text2 = sp.captureBillingDescription_Table(driver);
		Assert.assertEquals(text2, text);
	}
	
	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingBillingTypeInKeywordSearch_Test() throws Throwable {
		ServiceMasterPage sp = new ServiceMasterPage(driver);

		sp.clickOnServiceMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		String text = sp.captureBillingType_Table_Lastrow(driver);
		sp.enterSearch(driver, text);
		String text2 = sp.captureBillingType_Table(driver);
		Assert.assertEquals(text2, text);
	}
	
	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingBillingRateInKeywordSearch_Test() throws Throwable {
		ServiceMasterPage sp = new ServiceMasterPage(driver);

		sp.clickOnServiceMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		String text = sp.captureBillingRate_Table_Lastrow(driver);
		sp.enterSearch(driver, text);
		String text2 = sp.captureBillingRate_Table(driver);
		Assert.assertEquals(text2, text);
	}

	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() {
		ServiceMasterPage sp = new ServiceMasterPage(driver);

		sp.clickOnServiceMasterPageButton(driver);
		clickOnSideMenuBtn(driver);

		String text = "Test";

		sp.enterSearch(driver, text);
		sp.clickOnClearBtn(driver);
		String text2 = sp.captureSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		ServiceMasterPage sp = new ServiceMasterPage(driver);

		sp.clickOnServiceMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		ServiceMasterPage sp = new ServiceMasterPage(driver);

		sp.clickOnServiceMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		ServiceMasterPage sp = new ServiceMasterPage(driver);

		sp.clickOnServiceMasterPageButton(driver);
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
		ServiceMasterPage sp = new ServiceMasterPage(driver);

		sp.clickOnServiceMasterPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		ServiceMasterPage sp = new ServiceMasterPage(driver);

		sp.clickOnServiceMasterPageButton(driver);
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

}
