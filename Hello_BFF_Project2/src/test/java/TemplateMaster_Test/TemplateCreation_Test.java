package TemplateMaster_Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.AppointmentsAdminPage;
import Hello_Bff_ObjectRepository.NewsRoomPage;
import Hello_Bff_ObjectRepository.SchedulePage;
import Hello_Bff_ObjectRepository.TemplateListPage;
@Listeners(AllureTestListeners.class)
public class TemplateCreation_Test extends BaseClass {

	@Test
	public void createTemplateWithActiveStatus_Test() throws Throwable {
		TemplateListPage template = new TemplateListPage(driver);

		String templateName = template.randomTemplateName(driver) + " " + generateRandomNumber();
		String textArea = generateRandomContent_JavaFaker() + " " + generateRandomContent_JavaFaker();

		template.clickOnTemplateMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		template.enterTemplateName(driver, templateName);
		template.clickOnActiveStatus_ToggleBtn(driver);
		template.enterDataInTextArea(driver, textArea);
		template.clickOnSaveBtn(driver);
		String text = captureAlertText(driver);
		Assert.assertEquals(text, "created");
	}

	@Test
	public void createTemplateWithoutActiveStatus_Test() throws Throwable {
		TemplateListPage template = new TemplateListPage(driver);

		String templateName = template.randomTemplateName(driver) + " " + generateRandomNumber();
		String textArea = generateRandomContent_JavaFaker() + " " + generateRandomContent_JavaFaker();

		template.clickOnTemplateMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		template.enterTemplateName(driver, templateName);
		template.enterDataInTextArea(driver, textArea);
		template.clickOnSaveBtn(driver);
		String text = captureAlertText(driver);
		Assert.assertEquals(text, "created");
	}

	@Test
	public void createTemplateAndVerifyDataIsReflectedInTheList_Test() throws Throwable {
		TemplateListPage template = new TemplateListPage(driver);

		String templateName = template.randomTemplateName(driver) + " " + generateRandomNumber();
		String textArea = generateRandomContent_JavaFaker() + " " + generateRandomContent_JavaFaker();

		template.clickOnTemplateMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		template.enterTemplateName(driver, templateName);
		template.clickOnActiveStatus_ToggleBtn(driver);
		template.enterDataInTextArea(driver, textArea);
		template.clickOnSaveBtn(driver);
		template.clickOnBackBtn(driver);
		String name = template.captureTemplateName_Table(driver);
		Assert.assertEquals(templateName, name);
	}

	@Test
	public void verifyEditFunctionalityAndDataIsUpdatedCorrectlyInTheList_Test() throws Throwable {
		TemplateListPage template = new TemplateListPage(driver);

		String templateName = template.randomTemplateName(driver) + " " + generateRandomNumber();
		String textArea = generateRandomContent_JavaFaker() + " " + generateRandomContent_JavaFaker();

		String templateName2 = template.randomTemplateName(driver) + " " + generateRandomNumber();

		template.clickOnTemplateMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		template.enterTemplateName(driver, templateName);
		template.clickOnActiveStatus_ToggleBtn(driver);
		template.enterDataInTextArea(driver, textArea);
		template.clickOnSaveBtn(driver);
		template.clickOnAction_ClickOnEditBtn(driver);
		template.enterTemplateName(driver, templateName2);
		template.clickOnSaveBtn(driver);
		String name = template.captureTemplateName_Table(driver);
		Assert.assertEquals(templateName2, name);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingTemplateCodeInKeywordSearch_Test() throws Throwable {
		TemplateListPage template = new TemplateListPage(driver);

		template.clickOnTemplateMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		template.clickOnBackBtn(driver);
		String code = template.captureTemplateCode_Table_Lastrow(driver);
		template.enterKeywordSearch(driver, code);
		String code2 = template.captureTemplateCode_Table(driver);
		Assert.assertEquals(code, code2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingTemplateNameInKeywordSearch_Test() throws Throwable {
		TemplateListPage template = new TemplateListPage(driver);

		template.clickOnTemplateMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		template.clickOnBackBtn(driver);
		String templateName = template.captureTemplateName_Table_Lastrow(driver);
		template.enterKeywordSearch(driver, templateName);
		String templateName2 = template.captureTemplateName_Table(driver);
		Assert.assertEquals(templateName2, templateName);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		TemplateListPage template = new TemplateListPage(driver);

		template.clickOnTemplateMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		template.clickOnBackBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		TemplateListPage template = new TemplateListPage(driver);

		template.clickOnTemplateMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		template.clickOnBackBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		TemplateListPage template = new TemplateListPage(driver);

		template.clickOnTemplateMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		template.clickOnBackBtn(driver);
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
		TemplateListPage template = new TemplateListPage(driver);

		template.clickOnTemplateMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		template.clickOnBackBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		TemplateListPage template = new TemplateListPage(driver);

		template.clickOnTemplateMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		template.clickOnBackBtn(driver);
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
	public void verifyTheCreatedTemplateInScheduleScreen_Test() throws Throwable {
		TemplateListPage template = new TemplateListPage(driver);
		AppointmentsAdminPage appointPage = new AppointmentsAdminPage(driver);

		String templateName = template.randomTemplateName(driver) + " " + generateRandomNumber();
		String textArea = generateRandomContent_JavaFaker() + " " + generateRandomContent_JavaFaker();

		template.clickOnTemplateMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		template.enterTemplateName(driver, templateName);
		template.clickOnActiveStatus_ToggleBtn(driver);
		template.enterDataInTextArea(driver, textArea);
		template.clickOnSaveBtn(driver);

		Thread.sleep(3000);
		appointPage.clickOnAppointmentAdminBtn(driver);
		appointPage.clickOnConsultBtn(driver);
		Thread.sleep(2000);
		appointPage.selectTemplateDropDown_AssessmentTab(driver, templateName);
		String text = appointPage.captureAssessmentHistoryTemplateData(driver);
		Assert.assertEquals(text, textArea);
	}

}
