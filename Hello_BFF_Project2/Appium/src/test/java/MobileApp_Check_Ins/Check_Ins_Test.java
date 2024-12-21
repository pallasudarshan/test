package MobileApp_Check_Ins;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility_Appium.BaseClass_Appium;
import Hello_Bff_ObjectRepository.HomePage;
import Hello_Bff_ObjectRepository.QuestionarieMasterPage;
import ObjectRepository_Appium.Check_InsPage;

public class Check_Ins_Test extends BaseClass_Appium {

	@OpenBrowser
	@Test
	public void verifyCheckInQuestionsInMobileApp_Test() throws Throwable {
		String questionarieType = "Loneliness";
		String checkInType = "Rate";
		String options = "Address concerns";
		QuestionarieMasterPage qm = new QuestionarieMasterPage(driver);
		HomePage hp = new HomePage(driver);

		qm.clickOnQuestionarieMasterPage(driver);
		hp.clickOnSideMenuButton(driver);
		qm.clickOnAddButton(driver);
		qm.selectQuestionarieType(driver, questionarieType);
		qm.selectCheckInType(driver, checkInType);
		String question = qm.enterTheQuestions_random(driver);
		qm.enterOptionsInTheText(driver, options);
		qm.clickOnActionButton(driver);
		qm.clickOnSaveButton(driver);

		Check_InsPage checkIn = new Check_InsPage(androidDriver);
		checkIn.clickOnPlusBtn(androidDriver);
		checkIn.clickOnCheckInBtn();
		checkIn.clickOnLonelinessButton();
		String text = checkIn.captureFirstQuestion();
		Assert.assertTrue(text.contains(question));
	}
}
