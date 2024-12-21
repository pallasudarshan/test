package ClinicalServices_Test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.AppointmentsAdminPage;
import Hello_Bff_ObjectRepository.ClinicalServicesPage;
import Hello_Bff_ObjectRepository.ManageBffPage;
import Hello_Bff_ObjectRepository.ManageSeekerPage;
import Hello_Bff_ObjectRepository.SchedulePage;

public class ClinicalServiceBillingFlow_Test extends BaseClass {

	@Test
	public void createBff_CreateSeeker_Schedule_AppointmentAdmin_ClinicalServiceFlow_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

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
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);

		String billingType = "Organization";

		clinicalService.clickOnClinicalServicPage(driver);
		clinicalService.selectBillingType(driver, billingType);
		clinicalService.selectOrganizationName(driver, bffName);
		clinicalService.clickOnGenerateInvoiceBtn(driver);
		String text2 = captureAlertText_2(driver);
		Assert.assertEquals(text2, "billing created");
	}

	@Test
	public void clinicalServiceBillingFlowWithmultipleServices_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

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
		String serviceName1 = "Anti";
		String serviceName2 = "mri";
		String serviceName3 = "homo";
		String serviceName4 = "zinc";
		String serviceName5 = "uric";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.selectTemplateDropDown_AssessmentTab(driver, template_Assessment);
		appointmentAdmin.clickOnSaveBtn_Assessment(driver);

		appointmentAdmin.clickOnProgressRecordTab(driver);
		appointmentAdmin.selectTemplateDropDown_ProgressRecordTab(driver, template_ProgressRecord);
		appointmentAdmin.clickOnSaveBtn_ProgressRecord(driver);

		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.addServices_Indent(driver, serviceName2);
		appointmentAdmin.addServices_Indent(driver, serviceName3);
		appointmentAdmin.addServices_Indent(driver, serviceName4);
		appointmentAdmin.addServices_Indent(driver, serviceName5);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);

		String billingType = "Organization";

		clinicalService.clickOnClinicalServicPage(driver);
		clinicalService.selectBillingType(driver, billingType);
		Thread.sleep(3000);
		clinicalService.selectOrganizationName(driver, bffName);
		Thread.sleep(1000);
		clinicalService.clickOnGenerateInvoiceBtn(driver);
		String text2 = captureAlertText_2(driver);
		Assert.assertEquals(text2, "billing created");
	}

	@Test
	public void verifyClinicalServicesBillingForExistingSeeker_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

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

		Thread.sleep(12000);

		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table_Lastrow(driver);

		String selectBff = bffName;

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		String customerName = schedulePage.captureCustomerNameFirstrow_Table(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.createSchedule(driver, seekerCode, selectBff);
		schedulePage.clickOnBookButton(driver);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnConfirmBtn_Action(driver);

		String serviceName1 = "Anti";
		String serviceName2 = "mri";
		String serviceName3 = "homo";
		String serviceName4 = "zinc";
		String serviceName5 = "uric";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		Thread.sleep(2000);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.addServices_Indent(driver, serviceName2);
		appointmentAdmin.addServices_Indent(driver, serviceName3);
		appointmentAdmin.addServices_Indent(driver, serviceName4);
		appointmentAdmin.addServices_Indent(driver, serviceName5);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);

		String billingType = "Organization";

		clinicalService.clickOnClinicalServicPage(driver);
		clinicalService.selectBillingType(driver, billingType);
		Thread.sleep(3000);
		clinicalService.selectOrganizationName(driver, customerName);
		Thread.sleep(1000);
		clinicalService.clickOnGenerateInvoiceBtn(driver);
		String text2 = captureAlertText_2(driver);
		Assert.assertEquals(text2, "billing created");
	}

	@Test
	public void verifyThatAddedServicesInAppontmentAdminScreenIsReflectedAccuratlyInCliniCalServiceScreen_Test()
			throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

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

		String serviceName1 = "Anti";
		String serviceName2 = "mri";
		String serviceName3 = "homo";
		String serviceName4 = "zinc";
		String serviceName5 = "uric";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.addServices_Indent(driver, serviceName2);
		appointmentAdmin.addServices_Indent(driver, serviceName3);
		appointmentAdmin.addServices_Indent(driver, serviceName4);
		appointmentAdmin.addServices_Indent(driver, serviceName5);
		List<String> serviceNames = appointmentAdmin.captureListOfServiceNames(driver);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);

		String billingType = "Organization";

		clinicalService.clickOnClinicalServicPage(driver);
		clinicalService.selectBillingType(driver, billingType);
		Thread.sleep(3000);
		clinicalService.selectOrganizationName(driver, bffName);
		clinicalService.clickOnViewServices_eyeIcon_Lastrow(driver);
		List<String> serviceNames2 = clinicalService.captureServiceNamesList(driver);
		System.out.println(serviceNames);
		System.out.println(serviceNames2);
		Assert.assertEquals(serviceNames, serviceNames2, "Service names are miss matched");
	}

	@Test
	public void verifyTotalAmountCalculationInClinicalService_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

		String serviceName1 = "Anti";
		String serviceName2 = "mri";
		String serviceName3 = "homo";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		String customerName = appointmentAdmin.captureCustomerName_Table(driver);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.addServices_Indent(driver, serviceName2);
		appointmentAdmin.addServices_Indent(driver, serviceName3);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);

		String billingType = "Organization";

		clinicalService.clickOnClinicalServicPage(driver);
		clinicalService.selectBillingType(driver, billingType);
		Thread.sleep(3000);
		clinicalService.selectOrganizationName(driver, customerName);
		clinicalService.clickOnViewServices_eyeIcon_Lastrow(driver);

		double totalAmount = clinicalService.calculateTotalAmount_List(driver);
		String totalAmount2 = clinicalService.captureTotalAmount_Total_ServiceListPopUp(driver);
		System.out.println(totalAmount);
		double totalAmount3 = Double.parseDouble(totalAmount2);

		System.out.println(totalAmount3);
		Assert.assertEquals(totalAmount, totalAmount3, "Total amount calculation is failed");
	}

	@Test
	public void verifyThatDetailsAreReflectedInTheListCorrectlyAfterBillingIsDone_ClinicalService_Test()
			throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

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
		String customerName = "Customer one";
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
		manageSeekerPage.clickOnCreateManageSeeker(driver, sourceType, maritalStatus, customerName, file);
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

		String serviceName1 = "Anti";
		String serviceName2 = "mri";

		Thread.sleep(12000);
		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.addServices_Indent(driver, serviceName2);
		String totalAmount = appointmentAdmin.captureTotalAmount(driver);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);

		String billingType = "Organization";

		clinicalService.clickOnClinicalServicPage(driver);
		clinicalService.selectBillingType(driver, billingType);
		Thread.sleep(3000);
		clinicalService.selectOrganizationName(driver, customerName);
		Thread.sleep(1000);
		clinicalService.clickOnGenerateInvoiceBtn(driver);
		Thread.sleep(4000);
		String customername_List = clinicalService.captureCustomerName_table(driver);
		String invoiceDate_List = clinicalService.captureInvoiceDate_table(driver);
		String totalAmount_List = clinicalService.captureTotalAmount_table(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(customername_List.toUpperCase(), customerName.toUpperCase(), "Customer name is miss matched");
		sa.assertEquals(invoiceDate_List, generateCurrentDate_YYYYMMDD(), "invoice date is miss matched");
		sa.assertEquals(totalAmount_List, totalAmount + ".000", "total amount is miss matched");
		sa.assertAll();
	}

	@Test
	public void verifyThatSeekerDetailsAreReflectingCorrectlyInClinicalServiceScreen_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

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
		String customerName = "Innovate nexus";
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
		String seekerName = manageSeekerPage.clickOnCreateManageSeeker(driver, sourceType, maritalStatus, customerName,
				file);
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

		String serviceName1 = "Anti";
		String serviceName2 = "mri";

		Thread.sleep(12000);
		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.addServices_Indent(driver, serviceName2);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);

		String billingType = "Organization";

		clinicalService.clickOnClinicalServicPage(driver);
		clinicalService.selectBillingType(driver, billingType);
		Thread.sleep(3000);
		clinicalService.selectOrganizationName(driver, customerName);
		Thread.sleep(1000);
		String seekerName_SeekersList = clinicalService.captureSeekerName_SeekersList_LastRow(driver);
		String consultationDate_SeekersList = clinicalService.captureConsultationDate_SeekersList_LastRow(driver);
		String bffName_SeekersList = clinicalService.captureBffName_SeekersList_LastRow(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(seekerName_SeekersList.toUpperCase(), seekerName.toUpperCase(), "Seeker name is miss matched");
		sa.assertEquals(consultationDate_SeekersList, generateCurrentDate_YYYYMMDD(),
				"Consultation date is miss matched");
		sa.assertEquals(bffName_SeekersList.toUpperCase(), firstname.toUpperCase(), "Bff name is miss matched");
		sa.assertAll();
	}

	@Test
	public void verifyDiscountAmountCalculationInClinicalServiceScreen_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

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
		String customerName = "zenith innovation";

		Thread.sleep(12000);
		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.clickOnCreateManageSeeker(driver, sourceType, maritalStatus, customerName, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);
		String selectBff = bffName;

		Thread.sleep(6000);

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.captureCustomerNameFirstrow_Table(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.createSchedule(driver, seekerCode, selectBff);
		schedulePage.clickOnBookButton(driver);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnConfirmBtn_Action(driver);

		String serviceName1 = "uric";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		Thread.sleep(2000);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);

		String billingType = "Organization";

		clinicalService.clickOnClinicalServicPage(driver);
		clinicalService.selectBillingType(driver, billingType);
		Thread.sleep(3000);
		clinicalService.selectOrganizationName(driver, customerName);
		Thread.sleep(1000);
		clinicalService.clickOnViewServices_eyeIcon_Lastrow(driver);
		Thread.sleep(3000);
		String discountPercentage = "18";
		double discountPercentage_double = Double.parseDouble(discountPercentage);

		String rate = clinicalService.captureRate_ServiceList(driver);
		double rate_double = Double.parseDouble(rate);

		double discountAmountCalculated_double = rate_double * discountPercentage_double / 100;
		String discountAmountCalculated = String.valueOf(discountAmountCalculated_double);

		clinicalService.enterDiscountPercentage(driver, discountPercentage);
		Thread.sleep(2000);
		String discountAmt = clinicalService.captureDiscountAmountFeildData(driver);

		System.out.println(discountAmountCalculated);
		System.out.println(discountAmt);

		Assert.assertEquals(discountAmountCalculated, discountAmt);
	}

	@Test
	public void verifyTaxAmountCalculationInClinicalServiceScreen_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

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
		String customerName = "zenith innovation";

		Thread.sleep(12000);
		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.clickOnCreateManageSeeker(driver, sourceType, maritalStatus, customerName, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);
		String selectBff = bffName;

		Thread.sleep(6000);

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.captureCustomerNameFirstrow_Table(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.createSchedule(driver, seekerCode, selectBff);
		schedulePage.clickOnBookButton(driver);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnConfirmBtn_Action(driver);

		String serviceName1 = "uric";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		Thread.sleep(2000);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);

		String billingType = "Organization";

		clinicalService.clickOnClinicalServicPage(driver);
		clinicalService.selectBillingType(driver, billingType);
		Thread.sleep(3000);
		clinicalService.selectOrganizationName(driver, customerName);
		Thread.sleep(1000);
		clinicalService.clickOnViewServices_eyeIcon_Lastrow(driver);
		Thread.sleep(3000);
		String taxPercentage = "18";
		double taxPercentage_double = Double.parseDouble(taxPercentage);

		String rate = clinicalService.captureRate_ServiceList(driver);
		double rate_double = Double.parseDouble(rate);

		double taxAmountCalculated_double = rate_double * taxPercentage_double / 100;
		String taxAmountCalculated = String.valueOf(taxAmountCalculated_double);

		clinicalService.enterTaxPercentage(driver, taxPercentage);
		Thread.sleep(2000);
		String taxAmt = clinicalService.captureTaxAmountFeildData(driver);

		System.out.println(taxAmountCalculated_double);
		System.out.println(taxAmt);

		Assert.assertEquals(taxAmountCalculated, taxAmt);
	}

	@Test
	public void verifyTaxAmountCalculationInClinicalServiceScreen_Test12() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);
		ManageSeekerPage manageSeekerPage = new ManageSeekerPage(driver);
		SchedulePage schedulePage = new SchedulePage(driver);
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);
		ClinicalServicesPage clinicalService = new ClinicalServicesPage(driver);

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
		String customerName = "zenith innovation";

		Thread.sleep(12000);
		manageSeekerPage.clickOnManageSeekerPageButton(driver);
		manageSeekerPage.clickOnAddButton(driver);
		manageSeekerPage.clickOnCreateManageSeeker(driver, sourceType, maritalStatus, customerName, file);
		manageSeekerPage.clickOnSaveButton(driver);
		String seekerCode = manageSeekerPage.captureSeekerCode_Table(driver);
		String selectBff = bffName;

		Thread.sleep(6000);

		schedulePage.clickOnSchedulePage(driver);
		schedulePage.captureCustomerNameFirstrow_Table(driver);
		schedulePage.clickOnAddButton(driver);
		schedulePage.createSchedule(driver, seekerCode, selectBff);
		schedulePage.clickOnBookButton(driver);
		schedulePage.enterKeywordSearch(driver, seekerCode);
		schedulePage.clickOnActionsFirstRowButton_Table(driver);
		schedulePage.clickOnConfirmBtn_Action(driver);

		String serviceName1 = "uric";

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		appointmentAdmin.enterKeywordSearch(driver, seekerCode);
		appointmentAdmin.clickOnConsultBtn(driver);
		Thread.sleep(2000);
		appointmentAdmin.clickOnIndentServiceTab(driver);
		appointmentAdmin.addServices_Indent(driver, serviceName1);
		appointmentAdmin.clickOnSaveBtn_IndnetService(driver);

		String billingType = "Organization";

		clinicalService.clickOnClinicalServicPage(driver);
		clinicalService.selectBillingType(driver, billingType);
		Thread.sleep(3000);
		clinicalService.selectOrganizationName(driver, customerName);
		Thread.sleep(1000);
		clinicalService.clickOnViewServices_eyeIcon_Lastrow(driver);
		Thread.sleep(3000);
		String taxPercentage = "18";
		double taxPercentage_double = Double.parseDouble(taxPercentage);

		String rate = clinicalService.captureRate_ServiceList(driver);
		double rate_double = Double.parseDouble(rate);

		double taxAmountCalculated_double = rate_double * taxPercentage_double / 100;
		String taxAmountCalculated = String.valueOf(taxAmountCalculated_double);

		clinicalService.enterTaxPercentage(driver, taxPercentage);
		Thread.sleep(2000);
		String taxAmt = clinicalService.captureTaxAmountFeildData(driver);

		System.out.println(taxAmountCalculated_double);
		System.out.println(taxAmt);

		Assert.assertEquals(taxAmountCalculated, taxAmt);
	}

}
