package ClinicalServices_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.ClinicalServicesPage;

public class ClinicalServiceSearchFiltersAndPaginationScripts_Test extends BaseClass {

	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() throws Throwable {
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

		clinicalService.clickOnClinicalServicPage(driver);
		clickOnSideMenuBtn(driver);
		clinicalService.clickOnBack(driver);
		String text = "Test";
		enterKeywordSearch(driver, text);
		clickOnClearBtn_KeywordSearch(driver);
		String text2 = captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPaginationButton_Test() throws Throwable {
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

		clinicalService.clickOnClinicalServicPage(driver);
		clickOnSideMenuBtn(driver);
		clinicalService.clickOnBack(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "11");
	}

	@Test
	public void verifyPreviousPageButton_Pagination_Test() throws Throwable {
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

		clinicalService.clickOnClinicalServicPage(driver);
		clickOnSideMenuBtn(driver);
		clinicalService.clickOnBack(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPage_Pagination_Test() throws Throwable {
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

		clinicalService.clickOnClinicalServicPage(driver);
		clickOnSideMenuBtn(driver);
		clinicalService.clickOnBack(driver);
		clickOnLastButton(driver);
		String lastPaginationNumber = captureLastPaginationNumber(driver);
		int number = Integer.parseInt(lastPaginationNumber);
		int number2 = number - 1;
		String result = Integer.toString(number2);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(result + "1", text);
	}

	@Test
	public void verifyfirstPage_Pagination_Test() throws Throwable {
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

		clinicalService.clickOnClinicalServicPage(driver);
		clickOnSideMenuBtn(driver);
		clinicalService.clickOnBack(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

		clinicalService.clickOnClinicalServicPage(driver);
		clickOnSideMenuBtn(driver);
		clinicalService.clickOnBack(driver);
		String no = clickOnMiddlePageNumber(driver);
		String slNo3 = captureSlNo_Table_Lastrow(driver);
		Assert.assertEquals(slNo3, no + "0");
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingInvoiceNumberToInKeywordSearch_Test() throws Throwable {
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

		clinicalService.clickOnClinicalServicPage(driver);
		clickOnSideMenuBtn(driver);
		clinicalService.clickOnBack(driver);
		String text = clinicalService.captureInvoiceNumber_table(driver);
		enterKeywordSearch(driver, text);
		Thread.sleep(1000);
		String text2 = clinicalService.captureInvoiceNumber_table(driver);
		Assert.assertEquals(text, text2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingCustomerNameToInKeywordSearch_Test() throws Throwable {
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

		clinicalService.clickOnClinicalServicPage(driver);
		clickOnSideMenuBtn(driver);
		clinicalService.clickOnBack(driver);
		String text = clinicalService.captureCustomerName_table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		Thread.sleep(1000);
		String text2 = clinicalService.captureCustomerName_table(driver);
		Assert.assertEquals(text, text2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingInvoiceDateToInKeywordSearch_Test() throws Throwable {
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

		clinicalService.clickOnClinicalServicPage(driver);
		clickOnSideMenuBtn(driver);
		clinicalService.clickOnBack(driver);
		String text = clinicalService.captureInvoiceNumber_table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		Thread.sleep(1000);
		String text2 = clinicalService.captureInvoiceNumber_table(driver);
		Assert.assertEquals(text, text2);

		Assert.assertEquals("123", text2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingTotalAmountToInKeywordSearch_Test() throws Throwable {
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

		clinicalService.clickOnClinicalServicPage(driver);
		clickOnSideMenuBtn(driver);
		clinicalService.clickOnBack(driver);
		String text = clinicalService.captureTotalAmount_table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		Thread.sleep(1000);
		String text2 = clinicalService.captureTotalAmount_table(driver);
		Assert.assertEquals(text, text2);
	}

}
