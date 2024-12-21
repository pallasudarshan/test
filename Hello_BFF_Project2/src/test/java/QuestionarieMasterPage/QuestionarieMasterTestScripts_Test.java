package QuestionarieMasterPage;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.HomePage;
import Hello_Bff_ObjectRepository.QuestionarieMasterPage;
@Listeners(AllureTestListeners.class)
public class QuestionarieMasterTestScripts_Test extends BaseClass {

	@Test
	public void checkThatUserAbleToCreateTheQuestionarieDetails_Test() throws Throwable {
		String questionarieType = "Loneliness Questionnarie";
		String checkInType = "Rate";
		String question = "Need ";
		String options = "Address concerns";

		String questionarieType1 = "Depression/Anxiety Questionnaire";
		String questionarieType2 = "Needs Questionnaire";

		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);
		HomePage hp = new HomePage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		hp.clickOnSideMenuButton(driver);
		qm.clickOnAddButton(driver);
		qm.selectQuestionarieType(driver, questionarieType);
		qm.selectCheckInType(driver, checkInType);
		qm.enterTheQuestions(driver, question);
		qm.enterOptionsInTheText(driver, options);
		qm.clickOnActionButton(driver);

		qm.selectQuestionarieType(driver, questionarieType1);
		qm.selectCheckInType(driver, checkInType);
		qm.enterTheQuestions(driver, question);
		qm.enterOptionsInTheText(driver, options);
		qm.clickOnActionButton(driver);

		qm.selectQuestionarieType(driver, questionarieType2);
		qm.selectCheckInType(driver, checkInType);
		qm.enterTheQuestions(driver, question);
		qm.enterOptionsInTheText(driver, options);
		qm.clickOnActionButton(driver);

		qm.selectQuestionarieType(driver, questionarieType2);
		qm.selectCheckInType(driver, checkInType);
		qm.enterTheQuestions(driver, question);
		qm.enterOptionsInTheText(driver, options);
		qm.clickOnActionButton(driver);

		qm.clickOnSaveButton(driver);
	}

	@Test
	public void checkThatUserAbleToAddTheMoreQuestionsAt_A_Time_Test() throws Throwable {
		String questionarieType = "Loneliness Questionnarie";
		String checkInType = "Rate";
		String question = "Strong, Moderate, Weak";
		String options = "Address concerns";
		int count = 20;

		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);
		HomePage hp = new HomePage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		hp.clickOnSideMenuButton(driver);
		qm.clickOnAddButton(driver);
		qm.addMulitipleQuestions(driver, questionarieType, checkInType, question, options, count);
		qm.clickOnSaveButton(driver);
		qm.clickOnAddButton(driver);
	}

	@Test
	public void verifyThatSystemShouldNotAllowToSubmitWithoutAddingQuestions_Test() throws Throwable {
		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);
		HomePage hp = new HomePage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		hp.clickOnSideMenuButton(driver);
		qm.clickOnAddButton(driver);
		qm.clickOnSaveButton(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Please Enter Questions to Submit.");
	}

	@Test
	public void checkThatUserAbleToDeleteTheMoreQuestionsAt_A_TimesInTheTable_Test() throws Throwable {
		String questionarieType = "Loneliness Questionnarie";
		String checkInType = "Choice";
		String question = "How often do you feel lonely? ";
		String options = "Never, Rarely, Sometimes, Often, Always";
		int count = 10;

		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);
		HomePage hp = new HomePage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		hp.clickOnSideMenuButton(driver);
		qm.clickOnAddButton(driver);
		qm.addMulitipleQuestions(driver, questionarieType, checkInType, question, options, count);
		qm.deleteTheQuestionsInTheList(driver, count);
	}

	@Test
	public void checkThatUserAbleToClickOnTheBackButton() {
		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);
		HomePage hp = new HomePage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		hp.clickOnSideMenuButton(driver);
		qm.clickOnAddButton(driver);
		qm.clickOnBackButton(driver);
		qm.clickOnAddButton(driver);
	}

	@Test
	public void checkThatUserAbleToClickOnTheCancelButton() throws Throwable {
		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);
		HomePage hp = new HomePage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		hp.clickOnSideMenuButton(driver);
		qm.clickOnAddButton(driver);
		qm.clickOnCancelButtonMain(driver);
		qm.clickOnAddButton(driver);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingQuestionCodeOnInKeywordSearch_Test() throws Throwable {
		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		clickOnSideMenuBtn(driver);
		String text = qm.captureQuestionCode_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = qm.captureQuestionCode_Table(driver);
		Assert.assertEquals(text, text2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingQuestionCategoryOnInKeywordSearch_Test() throws Throwable {
		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		clickOnSideMenuBtn(driver);
		String text = qm.captureQuestionCategory_Table_Lastrow(driver);
		enterKeywordSearch(driver, text);
		String text2 = qm.captureQuestionCategory_Table(driver);
		Assert.assertEquals(text, text2);
	}

	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() {
		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		clickOnSideMenuBtn(driver);

		String text = "Test";
		enterKeywordSearch(driver, text);
		clickOnClearBtn_KeywordSearch(driver);
		String text2 = captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "21");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
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
		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
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
	public void qestionnaireMasterDetailsReflectionInTheListPageAfterCreation_Test() throws Throwable {
		String questionarieType = "Loneliness";
		String checkInType = "Rate";
		String question = "Need ";
		String options = "Address concerns";

		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);
		HomePage hp = new HomePage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		hp.clickOnSideMenuButton(driver);
		qm.clickOnAddButton(driver);
		qm.selectQuestionarieType(driver, questionarieType);
		qm.selectCheckInType(driver, checkInType);
		qm.enterTheQuestions(driver, question);
		qm.enterOptionsInTheText(driver, options);
		qm.clickOnActionButton(driver);
		qm.clickOnSaveButton(driver);
		Thread.sleep(1000);
		String category = qm.captureQuestionCategory_Table(driver);
		Assert.assertEquals(category, questionarieType);
	}

	@Test
	public void verifyThatUserIsAbleToEditAndAddQuestionsAndSubmitIt_Test() throws Throwable {
		String questionarieType = "Loneliness Questionnarie";
		String checkInType = "Rate";
		String question = "Need ";
		String options = "Address concerns";

		String questionarieType1 = "Depression/Anxiety Questionnaire";
		String questionarieType2 = "Needs Questionnaire";

		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);
		HomePage hp = new HomePage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		hp.clickOnSideMenuButton(driver);
		qm.clickOnAddButton(driver);
		qm.selectQuestionarieType(driver, questionarieType);
		qm.selectCheckInType(driver, checkInType);
		qm.enterTheQuestions(driver, question);
		qm.enterOptionsInTheText(driver, options);
		qm.clickOnActionButton(driver);

		qm.selectQuestionarieType(driver, questionarieType1);
		qm.selectCheckInType(driver, checkInType);
		qm.enterTheQuestions(driver, question);
		qm.enterOptionsInTheText(driver, options);
		qm.clickOnActionButton(driver);

		qm.clickOnSaveButton(driver);
		Thread.sleep(2000);
		qm.clickOnEditUnderAction(driver);

		qm.selectQuestionarieType(driver, questionarieType2);
		qm.selectCheckInType(driver, checkInType);
		qm.enterTheQuestions(driver, question);
		qm.enterOptionsInTheText(driver, options);
		qm.clickOnActionButton(driver);

		qm.selectQuestionarieType(driver, questionarieType2);
		qm.selectCheckInType(driver, checkInType);
		qm.enterTheQuestions(driver, question);
		qm.enterOptionsInTheText(driver, options);
		qm.clickOnActionButton(driver);
        Thread.sleep(3000);
		qm.clickOnSaveButton(driver);
		String text = qm.captureAlertText_2(driver);
		Assert.assertEquals(text, "Successfully updated questionnaire Data");
	}

}
