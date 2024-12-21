package ContentSourceDataTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.ContentSourceDataPage;

public class ContentSourceDataCrudOperations_Test extends BaseClass {

	@Test
	public void verifyThatUserIsAbleToCreateContentSourceAndDataSuccessfully_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		String dataSourceType = "Therapy Session Logs";
		String publicationType = "Other";
		String title = generateRandomTitle_JavaFaker().replaceAll("[^a-zA-Z0-9 ]", "");
		String source = generateRandomTitle_JavaFaker().replaceAll("[^a-zA-Z0-9 ]", "");

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		contentSourceData.clickOnAddBtn(driver);
		contentSourceData.selectDataSourceType(driver, dataSourceType);
		contentSourceData.selectPublicationType(driver, publicationType);
		contentSourceData.enterTitle(driver, title);
		contentSourceData.enterSource(driver, source);
		contentSourceData.selectPublisedOn(driver);
		contentSourceData.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Successfully created Source Data",
				"Unable to create content sourse & data or Success message is miss matched");
	}

	@Test
	public void verifyThatCreatedContentAndSourceAndDataIsReflectedInTheListCorrectly_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		String dataSourceType = "Therapy Session Logs";
		String publicationType = "Other";
		String title = generateRandomTitle_JavaFaker().replaceAll("[^a-zA-Z0-9 ]", "");
		String source = generateRandomTitle_JavaFaker().replaceAll("[^a-zA-Z0-9 ]", "");

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		contentSourceData.clickOnAddBtn(driver);
		contentSourceData.selectDataSourceType(driver, dataSourceType);
		contentSourceData.selectPublicationType(driver, publicationType);
		contentSourceData.enterTitle(driver, title);
		contentSourceData.enterSource(driver, source);
		contentSourceData.selectPublisedOn(driver);
		contentSourceData.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Successfully created Source Data",
				"Unable to create content sourse & data or Success message is miss matched");

		Thread.sleep(1500);

		String sourceName2 = contentSourceData.captureSourceName_Table(driver);
		String title2 = contentSourceData.captureTitle_Table(driver);
		String publicationType2 = contentSourceData.capturePublicationType_Table(driver);
		String sourceType2 = contentSourceData.captureSourceType_Table(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(sourceName2, source, "source name is miss matched");
		sa.assertEquals(title2, title, "title is miss matched");
		sa.assertEquals(publicationType2, publicationType, "publication type is miss matched");
		sa.assertEquals(sourceType2, dataSourceType, "data sourse type is miss matched");
		sa.assertAll();
	}

	@Test
	public void verifyThatUserIsAbleToEditContentSourceAndDataSuccessfully_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		contentSourceData.clickOnEditUnderAction(driver);
		contentSourceData.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "successfully Updated Source data Master",
				"Unable to update content sourse & data or Success message is miss matched");
	}

	@Test
	public void verifyThatUpdateDataWhileEditingIsUpdatedCorrectlyInTheList_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		String dataSourceType = "Therapy Session Logs";
		String publicationType = "Other";
		String title = generateRandomTitle_JavaFaker().replaceAll("[^a-zA-Z0-9 ]", "");
		String source = generateRandomTitle_JavaFaker().replaceAll("[^a-zA-Z0-9 ]", "");

		String dataSourceType2 = "Home";
		String publicationType2 = "None";
		String title2 = generateRandomTitle_JavaFaker().replaceAll("[^a-zA-Z0-9 ]", "");
		String source2 = generateRandomTitle_JavaFaker().replaceAll("[^a-zA-Z0-9 ]", "");

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		contentSourceData.clickOnAddBtn(driver);
		contentSourceData.selectDataSourceType(driver, dataSourceType);
		contentSourceData.selectPublicationType(driver, publicationType);
		contentSourceData.enterTitle(driver, title);
		contentSourceData.enterSource(driver, source);
		contentSourceData.selectPublisedOn(driver);
		contentSourceData.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Successfully created Source Data",
				"Unable to update content sourse & data or Success message is miss matched");

		Thread.sleep(2000);

		contentSourceData.clickOnEditUnderAction(driver);
		contentSourceData.selectDataSourceType(driver, dataSourceType2);
		contentSourceData.selectPublicationType(driver, publicationType2);
		contentSourceData.enterTitle(driver, title2);
		contentSourceData.enterSource(driver, source2);
		contentSourceData.clickOnSaveBtn(driver);
		String text2 = captureAlertText_last(driver);
		Assert.assertEquals(text2, "successfully Updated Source data Master",
				"Unable to create content sourse & data or Success message is miss matched");

		Thread.sleep(1500);

		String sourceName3 = contentSourceData.captureSourceName_Table(driver);
		String title3 = contentSourceData.captureTitle_Table(driver);
		String publicationType3 = contentSourceData.capturePublicationType_Table(driver);
		String sourceType3 = contentSourceData.captureSourceType_Table(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(sourceName3, source2, "source name is miss matched");
		sa.assertEquals(title3, title2, "title is miss matched");
		sa.assertEquals(publicationType3, publicationType2, "publication type is miss matched");
		sa.assertEquals(sourceType3, dataSourceType2, "data sourse type is miss matched");
		sa.assertAll();
	}

	@Test
	public void verifyAddBtnFunctionality_Test() {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		contentSourceData.clickOnAddBtn(driver);
		String text = contentSourceData.captureContentSourceDataText_CreationPage_Table(driver);
		Assert.assertTrue(text.contains("Content Source & Data"));
	}

	@Test
	public void verifyCancelBtnFunctionality_Test() {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		contentSourceData.clickOnAddBtn(driver);
		contentSourceData.clickOnCancelBtn(driver);
		String text = contentSourceData.captureContentSourceDataText_ListPage_Table(driver);
		Assert.assertEquals(text, "Content Source Data");
	}

	@Test
	public void verifyBackBtnFunctionality_Test() {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		contentSourceData.clickOnAddBtn(driver);
		contentSourceData.clickOnBackBtn(driver);
		String text = contentSourceData.captureContentSourceDataText_ListPage_Table(driver);
		Assert.assertEquals(text, "Content Source Data");
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingSourceCodeInKeywordSearch_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		String text = contentSourceData.captureSourceCode_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = contentSourceData.captureSourceCode_Table(driver);
		Assert.assertEquals(text, text2);
	}
	

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingSourceNameInKeywordSearch_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		String text = contentSourceData.captureSourceName_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = contentSourceData.captureSourceName_Table(driver);
		Assert.assertEquals(text, text2);
	}
	
	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingTitleInKeywordSearch_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		String text = contentSourceData.captureTitle_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = contentSourceData.captureTitle_Table(driver);
		Assert.assertEquals(text, text2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingPublicationTypeInKeywordSearch_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		String text = contentSourceData.capturePublicationType_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		Thread.sleep(1000);
		String text2 = contentSourceData.capturePublicationType_Table(driver);
		Assert.assertEquals(text, text2);
	}

	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);

		String text = "Test";

		contentSourceData.enterKeywordSearch(driver, text);
		clickOnClearBtn_KeywordSearch(driver);
		String text2 = contentSourceData.captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
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
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		ContentSourceDataPage contentSourceData = new ContentSourceDataPage(driver);

		contentSourceData.clickOnContentSourceDatePage(driver);
		clickOnSideMenuBtn(driver);
//		clickOnLastButton(driver);
//		String lastPno = captureLastPageNumber(driver);
//		int lastPno2 = Integer.parseInt(lastPno);
//		clickOnFirstButton(driver);
//		String no = clickOnMiddlePageNumber(driver, lastPno2);
		String no = clickOnMiddlePageNumber(driver);
		String slNo3 = captureSlNo_Table_Lastrow(driver);
		Assert.assertEquals(slNo3, no + "0");
	}
}
