package MassEmailPublishing_Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.MassEmailPublishingPage;

public class MassEmailPublishingCrudOperation extends BaseClass {

	@Test
	public void verifyThatUserIsAbleToCreateMassEmailBySelectingBffRadioBtn_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		String subject = massEmail.randomSubjectNames(driver);
		String content = generateTemplateContent_JavaFaker();

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		massEmail.clickOnNewbtn(driver);
		massEmail.clickOnBffRadioBtn(driver);
		massEmail.enterSubject(driver, subject);
		massEmail.enterEmailContent(driver, content);
		massEmail.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "created successfully");
	}

	@Test
	public void verifyThatUserIsAbleToCreateMassEmailBySelectingSeekerRadioBtn_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		String subject = massEmail.randomSubjectNames(driver);
		String content = generateTemplateContent_JavaFaker();

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		massEmail.clickOnNewbtn(driver);
		massEmail.clickOnSeekerRadioBtn(driver);
		massEmail.enterSubject(driver, subject);
		massEmail.enterEmailContent(driver, content);
		massEmail.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "created successfully");
	}

	@Test
	public void verifyThatUserIsAbleToCreateMassEmailBySelectingCustomerRadioBtn_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		String subject = massEmail.randomSubjectNames(driver);
		String content = generateTemplateContent_JavaFaker();

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		massEmail.clickOnNewbtn(driver);
		massEmail.clickOnCustomerRadioBtn(driver);
		massEmail.enterSubject(driver, subject);
		massEmail.enterEmailContent(driver, content);
		massEmail.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "created successfully");
	}

	@Test
	public void verifyThatUserIsAbleToCreateMassEmailBySelectingAllRadioBtn_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		String subject = massEmail.randomSubjectNames(driver);
		String content = generateTemplateContent_JavaFaker();

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		massEmail.clickOnNewbtn(driver);
		massEmail.clickOnAllRadioBtn(driver);
		massEmail.enterSubject(driver, subject);
		massEmail.enterEmailContent(driver, content);
		massEmail.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "created successfully");
	}

	@Test
	public void verifyThatUserIsAbleToCreateMassEmailBySelectingOthersRadioBtn_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		String subject = massEmail.randomSubjectNames(driver);
		String content = generateTemplateContent_JavaFaker();

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		massEmail.clickOnNewbtn(driver);
		massEmail.clickOnOthersRadioBtn(driver);
		massEmail.enterSubject(driver, subject);
		massEmail.enterEmailContent(driver, content);
		massEmail.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "created successfully");
	}

	@Test
	public void verifyThatCreatedMassEmailIsReflectedInList_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		String subject = massEmail.randomSubjectNames(driver);
		String content = generateTemplateContent_JavaFaker();

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		massEmail.clickOnNewbtn(driver);
		massEmail.clickOnSeekerRadioBtn(driver);
		massEmail.enterSubject(driver, subject);
		massEmail.enterEmailContent(driver, content);
		massEmail.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "created successfully");

		String sentTo = massEmail.captureSentTo_table(driver);
		String subject2 = massEmail.captureSubject_table(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(sentTo, "Seeker", "Send to is miss matched");
		sa.assertEquals(subject2.replaceAll("[^a-zA-Z ]", ""), subject.replaceAll("[^a-zA-Z ]", ""),
				"subject is miss matched");
		sa.assertAll();
	}

	@Test
	public void verifyNewButtonFunctionality_test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		massEmail.clickOnNewbtn(driver);
		String save = massEmail.captureSaveBtn(driver);
		Assert.assertEquals(save, "Save");
	}

	@Test
	public void verifyThatUserisAbleToCloseThePopupByClickingUpOnCloseButton_test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		massEmail.clickOnNewbtn(driver);
		massEmail.clickOnCloseBtn_PopUp(driver);
		massEmail.verifyThatPopUpIsClosed(driver);
	}

	@Test
	public void verifyCancelButtonFunctionality_test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		String subject = massEmail.randomSubjectNames(driver);
		String content = generateTemplateContent_JavaFaker();

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		massEmail.clickOnNewbtn(driver);
		massEmail.clickOnBffRadioBtn(driver);
		massEmail.enterSubject(driver, subject);
		massEmail.enterEmailContent(driver, content);
		massEmail.clickOnCancelBtn(driver);
		massEmail.verifyCancelBtnFunctionalirt(driver);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingSentToInKeywordSearch_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		String text = massEmail.captureSentTo_table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		Thread.sleep(1000);
		String text2 = massEmail.captureSentTo_table(driver);
		Assert.assertEquals(text, text2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingSubjectInKeywordSearch_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		String text = massEmail.captureSubject_table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		Thread.sleep(1000);
		String text2 = massEmail.captureSubject_table(driver);
		Assert.assertEquals(text, text2);
	}

	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		String text = "Test";
		
		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		enterKeywordSearch(driver, text);
		clickOnClearBtn_KeywordSearch(driver);
		String text2 = captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPaginationButton_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButton_Pagination_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPage_Pagination_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		massEmail.clickOnMassEmailPublishingPage(driver);
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
	public void verifyfirstPage_Pagination_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		MassEmailPublishingPage massEmail = new MassEmailPublishingPage(driver);

		massEmail.clickOnMassEmailPublishingPage(driver);
		clickOnSideMenuBtn(driver);
		
		String no = clickOnMiddlePageNumber(driver);
		String slNo3 = captureSlNo_Table_Lastrow(driver);
		Assert.assertEquals(slNo3, no + "0");
	}
}
