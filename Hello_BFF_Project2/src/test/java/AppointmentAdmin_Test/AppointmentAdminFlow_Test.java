package AppointmentAdmin_Test;

import java.util.List;

import org.apache.commons.io.filefilter.AgeFileFilter;
import org.apache.poi.ss.formula.functions.Replace;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.AppointmentsAdminPage;
import Hello_Bff_ObjectRepository.ManageBffPage;
import Hello_Bff_ObjectRepository.ManageSeekerPage;
import Hello_Bff_ObjectRepository.SchedulePage;

public class AppointmentAdminFlow_Test extends BaseClass {

	@Test
	public void createBff_CreateSeeker_Schedule_AddDataInAssessmentTab_Flow_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		String bffType = "PHYSICIAN";
		String bffCategory = "cardiovascular drugs";
		String skill = "Counseling Techniques";
		String currentDepartment = "TEST";
		String currentDesignation = "TEST";
		String file = randomImage();

		manageBff.setAge("12");
		manageBff.setRelation("BROTHER");
		manageBff.setIssueDate("01/23/2023");
		manageBff.setExpiryDate("12/12/2023");
		manageBff.setIssuePlace("INDIA");
		manageBff.setCity("Bangalore");
		manageBff.setState("Option 1");

		manageBff.clickOnTheManageBffPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageBff.clickOnTheAddButton(driver);
		String firstname = manageBff.enterFirstName(driver);
		String lasName = manageBff.enterLastName_2(driver);
		String bffName = firstname + " " + lasName;
		manageBff.enterEmail(driver);
		manageBff.enterMobileNumber(driver);
		manageBff.selectGender(driver);
		manageBff.uploadImage(driver, file);
		manageBff.createGeneralInfo(driver, bffType, bffCategory, skill, currentDepartment, currentDesignation);
		manageBff.clickOnSaveButton_GeneralInfo(driver);

		String sourceType = "home";
		String maritalStatus = "SINGLE";

		Thread.sleep(12000);
		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.clickOnCreateManageSeeker(driver, sourceType, maritalStatus, bffName, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);

		String selectBff = bffName;

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.createSchedule(driver, seekerCode, selectBff);
		schedulePage.clickOnBookButton(driver);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnConfirmBtn_Action(driver);

		String template_Assessment = "journey";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.selectTemplateDropDown_AssessmentTab(driver, template_Assessment);
		Thread.sleep(4000);
		appointmentAdmin.clickOnSaveBtn_Assessment(driver);

		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "Successfully Assesment Created");
	}

	@Test
	public void createBff_CreateSeeker_Schedule_AddDataInProgressRecordTab_Flow_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		String bffType = "PHYSICIAN";
		String bffCategory = "cardiovascular drugs";
		String skill = "Counseling Techniques";
		String currentDepartment = "TEST";
		String currentDesignation = "TEST";
		String file = randomImage();

		manageBff.setAge("12");
		manageBff.setRelation("BROTHER");
		manageBff.setIssueDate("01/23/2023");
		manageBff.setExpiryDate("12/12/2023");
		manageBff.setIssuePlace("INDIA");
		manageBff.setCity("Bangalore");
		manageBff.setState("Option 1");

		manageBff.clickOnTheManageBffPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageBff.clickOnTheAddButton(driver);
		String firstname = manageBff.enterFirstName(driver);
		String lasName = manageBff.enterLastName_2(driver);
		String bffName = firstname + " " + lasName;
		manageBff.enterEmail(driver);
		manageBff.enterMobileNumber(driver);
		manageBff.selectGender(driver);
		manageBff.uploadImage(driver, file);
		manageBff.createGeneralInfo(driver, bffType, bffCategory, skill, currentDepartment, currentDesignation);
		manageBff.clickOnSaveButton_GeneralInfo(driver);

		String sourceType = "home";
		String maritalStatus = "SINGLE";

		Thread.sleep(12000);
		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.clickOnCreateManageSeeker(driver, sourceType, maritalStatus, bffName, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);

		String selectBff = bffName;

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.createSchedule(driver, seekerCode, selectBff);
		schedulePage.clickOnBookButton(driver);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnConfirmBtn_Action(driver);

		String template_ProgressRecord = "journey";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnProgressRecordTab(driver);
		appointmentAdmin.selectTemplateDropDown_ProgressRecordTab(driver, template_ProgressRecord);
		Thread.sleep(3000);
		appointmentAdmin.clickOnSaveBtn_ProgressRecord(driver);

		String text = captureAlertText_2(driver);

		Assert.assertEquals(text, "Successfully Progress Report Created");
	}

	@Test
	public void createBff_CreateSeeker_Schedule_AddDataInAssessmentProgressReportAndIndentService_Flow_Test()
			throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		String bffType = "PHYSICIAN";
		String bffCategory = "cardiovascular drugs";
		String skill = "Counseling Techniques";
		String currentDepartment = "TEST";
		String currentDesignation = "TEST";
		String file = randomImage();

		manageBff.setAge("12");
		manageBff.setRelation("BROTHER");
		manageBff.setIssueDate("01/23/2023");
		manageBff.setExpiryDate("12/12/2023");
		manageBff.setIssuePlace("INDIA");
		manageBff.setCity("Bangalore");
		manageBff.setState("Option 1");

		manageBff.clickOnTheManageBffPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageBff.clickOnTheAddButton(driver);
		String firstname = manageBff.enterFirstName(driver);
		String lasName = manageBff.enterLastName_2(driver);
		String bffName = firstname + " " + lasName;
		manageBff.enterEmail(driver);
		manageBff.enterMobileNumber(driver);
		manageBff.selectGender(driver);
		manageBff.uploadImage(driver, file);
		manageBff.createGeneralInfo(driver, bffType, bffCategory, skill, currentDepartment, currentDesignation);
		manageBff.clickOnSaveButton_GeneralInfo(driver);

		String sourceType = "home";
		String maritalStatus = "SINGLE";

		Thread.sleep(12000);
		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.clickOnCreateManageSeeker(driver, sourceType, maritalStatus, bffName, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);

		String selectBff = bffName;

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.createSchedule(driver, seekerCode, selectBff);
		schedulePage.clickOnBookButton(driver);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnConfirmBtn_Action(driver);

		String template_Assessment = "journey";
		String template_ProgressRecord = "wellness";
		String serviceName = "Anti";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.selectTemplateDropDown_AssessmentTab(driver, template_Assessment);
		appointmentAdmin.clickOnSaveBtn_Assessment(driver);

		appointmentAdmin.clickOnProgressRecordTab(driver);
		appointmentAdmin.selectTemplateDropDown_ProgressRecordTab(driver, template_ProgressRecord);
		appointmentAdmin.clickOnSaveBtn_ProgressRecord(driver);

		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.selectServiceName_IndentService(driver, serviceName);
		appointmentAdmin.clickOnAddActionBtn_IndnetService(driver);

		Thread.sleep(4000);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);

		String text = captureAlertText_2(driver);

		Assert.assertEquals(text, "Successfully Investigation Created");
	}

	@Test
	public void verifyThatSystemCorrectlyCalculatesTotalAmountByRateIntoQuantityAndFetchInTheTotalAmountFieldAccurately_Test()
			throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		String serviceName = "Zinc";
		String qty = "23";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.selectServiceName_IndentService(driver, serviceName);
		appointmentAdmin.enterQuantity_IndentService(driver, qty);
		String rate = appointmentAdmin.captureRateFieldData_IndentService(driver);
		String totalAmount = appointmentAdmin.captureTotalAmountFieldData_IndentService(driver);
		double totalAmount_double = Double.parseDouble(totalAmount);

		double rate_Double = Double.parseDouble(rate);
		double qty_Double = Double.parseDouble(qty);
		double calculatedTotalAmount_Double = rate_Double * qty_Double;

		Assert.assertEquals(totalAmount_double, calculatedTotalAmount_Double, "Total amount is miss matched");
	}

	@Test
	public void VerifyThatSystemCorrectlyCalculatesTotalAmountByAddingRateOfAllTheServicesAndDisplayAccurately_Test()
			throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		String serviceName1 = "Zinc";
		String serviceName2 = "Adrenocorticotropic Hormone (ACTH)";
		String serviceName3 = "IgE Allergy Testing";
		String serviceName4 = "Cholinesterase Test ";
		String serviceName5 = "Fibrin Degradation Products (FDP)";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.addServices_Indent(driver, serviceName2);
		appointmentAdmin.addServices_Indent(driver, serviceName3);
		appointmentAdmin.addServices_Indent(driver, serviceName4);
		appointmentAdmin.addServices_Indent(driver, serviceName5);
		List<String> listOfTotalAmount = appointmentAdmin.captureListOfTotalAmount(driver);
		String[] arrayOfTotalAmount = listOfTotalAmount.toArray(new String[0]);
		double calculatedTotalAmount = appointmentAdmin.addListOfTotalAmount(driver, arrayOfTotalAmount);

		String totalAmount = appointmentAdmin.captureTotalAmount(driver);
		Double totalAmount_double = Double.parseDouble(totalAmount);

		Assert.assertEquals(totalAmount_double, calculatedTotalAmount, "Total amount is miss matched");
	}

	@Test
	public void VerifyThatSystemUpdatesTheTotalAmountCorrectlyAfterServicesAreDeletedInIndentAndServiceTab_Test()
			throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		String serviceName1 = "Zinc";
		String serviceName2 = "Adrenocorticotropic Hormone (ACTH)";
		String serviceName3 = "IgE Allergy Testing";
		String serviceName4 = "Cholinesterase Test ";
		String serviceName5 = "Fibrin Degradation Products (FDP)";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.addServices_Indent(driver, serviceName2);
		appointmentAdmin.addServices_Indent(driver, serviceName3);
		appointmentAdmin.addServices_Indent(driver, serviceName4);
		appointmentAdmin.addServices_Indent(driver, serviceName5);
		Thread.sleep(2000);
		appointmentAdmin.clickOnDeleteBtn_IndentService(driver);
		appointmentAdmin.clickOnDeleteBtn_IndentService(driver);

		List<String> listOfTotalAmount = appointmentAdmin.captureListOfTotalAmount(driver);
		String[] arrayOfTotalAmount = listOfTotalAmount.toArray(new String[0]);
		double calculatedTotalAmount = appointmentAdmin.addListOfTotalAmount(driver, arrayOfTotalAmount);

		String totalAmount = appointmentAdmin.captureTotalAmount(driver);
		Double totalAmount_double = Double.parseDouble(totalAmount);

		Assert.assertEquals(totalAmount_double, calculatedTotalAmount, "Total amount is miss matched");
	}

	@Test
	public void VerifyThatAfterSavingIndentServicesIfWeGoBackAndIfWeClickOnConsultAgainTotalAmountIsDisplayedCorrectly_Test()
			throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);

		String serviceName1 = "Zinc";
		String serviceName2 = "Adrenocorticotropic Hormone (ACTH)";
		String serviceName3 = "IgE Allergy Testing";

		String bffType = "PHYSICIAN";
		String bffCategory = "cardiovascular drugs";
		String skill = "Counseling Techniques";
		String currentDepartment = "TEST";
		String currentDesignation = "TEST";
		String file = randomImage();

		manageBff.setAge("12");
		manageBff.setRelation("BROTHER");
		manageBff.setIssueDate("01/23/2023");
		manageBff.setExpiryDate("12/12/2023");
		manageBff.setIssuePlace("INDIA");
		manageBff.setCity("Bangalore");
		manageBff.setState("Option 1");

		manageBff.clickOnTheManageBffPageButton(driver);
		clickOnSideMenuBtn(driver);
		manageBff.clickOnTheAddButton(driver);
		String firstname = manageBff.enterFirstName(driver);
		String lasName = manageBff.enterLastName_2(driver);
		String bffName = firstname + " " + lasName;
		manageBff.enterEmail(driver);
		manageBff.enterMobileNumber(driver);
		manageBff.selectGender(driver);
		manageBff.uploadImage(driver, file);
		manageBff.createGeneralInfo(driver, bffType, bffCategory, skill, currentDepartment, currentDesignation);
		manageBff.clickOnSaveButton_GeneralInfo(driver);

		String sourceType = "home";
		String maritalStatus = "SINGLE";

		Thread.sleep(12000);
		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.clickOnCreateManageSeeker(driver, sourceType, maritalStatus, bffName, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);

		String selectBff = bffName;

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.createSchedule(driver, seekerCode, selectBff);
		schedulePage.clickOnBookButton(driver);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnConfirmBtn_Action(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.addServices_Indent(driver, serviceName2);
		appointmentAdmin.addServices_Indent(driver, serviceName3);
		String totalAmount = appointmentAdmin.captureTotalAmount(driver);
		Double totalAmountDouble = Double.parseDouble(totalAmount);

		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);
		Thread.sleep(5000);
		appointmentAdmin.clickOnBackBtn(driver);

		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		String totalAmount2 = appointmentAdmin.captureTotalAmount(driver);
		Double totalAmount2Double = Double.parseDouble(totalAmount2);

		Assert.assertEquals(totalAmount2Double, totalAmountDouble, "total amount is miss matched");
	}

	@Test
	public void VerifyThatSystemCorrectlyDisplaysUserNameAfterAssessmentIsSavedInTheAssessmentHistory_Test()
			throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		String template = "empoerment";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		String userName = appointmentAdmin.captureUsername(driver);
		clickOnSideMenuBtn(driver);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnAssessmentTab(driver);
		appointmentAdmin.clickOnNewBtn_Assessment(driver);
		appointmentAdmin.selectTemplateDropDown_AssessmentTab(driver, template);
		appointmentAdmin.clickOnSaveBtn_Assessment(driver);
		String assessmentUsername = appointmentAdmin.captureAssessmentHistoryUsername(driver);
		Assert.assertEquals(userName, assessmentUsername);
	}

	@Test
	public void VerifyThatSystemCorrectlyDisplaysUserNameAfterProgressRecordIsSavedInTheProgressRecordList_Test()
			throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		String template = "empoerment";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		String userName = appointmentAdmin.captureUsername(driver);
		clickOnSideMenuBtn(driver);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnProgressRecordTab(driver);
		appointmentAdmin.clickOnNewBtn_ProgressRecord(driver);
		appointmentAdmin.selectTemplateDropDown_ProgressRecordTab(driver, template);
		appointmentAdmin.clickOnSaveBtn_ProgressRecord(driver);
		String ProgressRecordtUsername = appointmentAdmin.captureProgressRecordListUsername(driver);
		Assert.assertEquals(userName, ProgressRecordtUsername);
	}

	@Test
	public void VerifyThatSystemCorrectlyDisplaysUserNameAfterIndentServicesIsSavedInTheServiceList_Test()
			throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		String serviceName1 = "Zinc";
		String serviceName2 = "Adrenocorticotropic Hormone (ACTH)";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		String userName = appointmentAdmin.captureUsername(driver);
		clickOnSideMenuBtn(driver);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.clickOnNewBtn_IndentService(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.addServices_Indent(driver, serviceName2);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);
		String indentServiceUsername = appointmentAdmin.captureServiceListUsername(driver);
		Assert.assertEquals(userName, indentServiceUsername);
	}

	@Test
	public void VerifyThatUserIsAbleToDeleteTheAddedServices_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		String serviceName1 = "Zinc";
		String serviceName2 = "Adrenocorticotropic Hormone (ACTH)";
		String serviceName3 = "IgE Allergy Testing";
		String serviceName4 = "Cholinesterase Test ";
		String serviceName5 = "Fibrin Degradation Products (FDP)";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.clickOnNewBtn_IndentService(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.addServices_Indent(driver, serviceName2);
		appointmentAdmin.addServices_Indent(driver, serviceName3);
		appointmentAdmin.addServices_Indent(driver, serviceName4);
		appointmentAdmin.addServices_Indent(driver, serviceName5);
		Thread.sleep(2000);
		appointmentAdmin.clickOnDeleteBtn_IndentService(driver);
		appointmentAdmin.clickOnDeleteBtn_IndentService(driver);
		int size = appointmentAdmin.captureindentServiceSize(driver);
		Assert.assertEquals(size, 3);
	}

	@Test
	public void VerifyThatAfterDeletingServicesAndSaveItIfWeGoBackAndIfWeClickOnConsultAgainCheckSystemDoesNotDisplayesDeletedServices_Test()
			throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		String serviceName1 = "Zinc";
		String serviceName2 = "Adrenocorticotropic Hormone (ACTH)";
		String serviceName3 = "IgE Allergy Testing";
		String serviceName4 = "Cholinesterase Test ";
		String serviceName5 = "Fibrin Degradation Products (FDP)";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.clickOnNewBtn_IndentService(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.addServices_Indent(driver, serviceName2);
		appointmentAdmin.addServices_Indent(driver, serviceName3);
		appointmentAdmin.addServices_Indent(driver, serviceName4);
		appointmentAdmin.addServices_Indent(driver, serviceName5);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);
		appointmentAdmin.clickOnBackBtn(driver);

		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.clickOnLastIndentedData(driver);
		appointmentAdmin.clickOnDeleteBtn_IndentService(driver);
		appointmentAdmin.clickOnDeleteBtn_IndentService(driver);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);
		appointmentAdmin.clickOnBackBtn(driver);

		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.clickOnLastIndentedData(driver);
		int size = appointmentAdmin.captureindentServiceSize(driver);
		Assert.assertEquals(size, 3, "Services are not deleted after saving it");
	}

	@Test
	public void VerifyThatSystemDisplaysSeekerNameAndAgeAccuratelyInAppointmentAdminScreen_Test() throws Throwable {
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);
		SchedulePage schedule = new SchedulePage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		String seekerCode = appointmentAdmin.captureSeekerCode_Table(driver);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		enterKeywordSearch(driver, seekerCode);
		manageSeekerPage.clickOnActionsButton(driver);
		manageSeekerPage.clickOnViewButton(driver);
		String name_age = schedule.captureName(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		String name = appointmentAdmin.captureNametext(driver);
		String age_Gender = appointmentAdmin.captureAgeAndGender(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(name_age.replace(" ", ""),
				name.replace(" ", "") + age_Gender.replace(" ", "").replace("(", "").replace(")", ""),
				"Name age or gender is miss matched");
		sa.assertAll();

	}

}
