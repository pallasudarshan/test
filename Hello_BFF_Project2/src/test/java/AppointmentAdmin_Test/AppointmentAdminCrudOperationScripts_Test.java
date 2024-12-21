package AppointmentAdmin_Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.AppointmentsAdminPage;
import Hello_Bff_ObjectRepository.ClinicalServicesPage;
import Hello_Bff_ObjectRepository.ManageBffPage;
import Hello_Bff_ObjectRepository.ManageSeekerPage;
import Hello_Bff_ObjectRepository.SchedulePage;

@Listeners(AllureTestListeners.class)
public class AppointmentAdminCrudOperationScripts_Test extends BaseClass {

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingSeekerCodeInKeywordSearch_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		String text = appointmentAdmin.captureSeekerCode_Table_Lastrow(driver);
		appointmentAdmin.enterKeywordSearch(driver, text);
		String text2 = appointmentAdmin.captureSeekerCode_Table(driver);
		Assert.assertEquals(text2, text);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingSeekerNameInKeywordSearch_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		String text = appointmentAdmin.captureSeekerName_Table_Lastrow(driver);
		appointmentAdmin.enterKeywordSearch(driver, text);
		String text2 = appointmentAdmin.captureSeekerName_Table(driver);
		Assert.assertEquals(text2, text);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingCustomerNameInKeywordSearch_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		String text = appointmentAdmin.captureCustomerName_Table_Lastrow(driver);
		appointmentAdmin.enterKeywordSearch(driver, text);
		String text2 = appointmentAdmin.captureCustomerName_Table(driver);
		Assert.assertEquals(text2, text);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingBffNameInKeywordSearch_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		String text = appointmentAdmin.captureBffName_Table_Lastrow(driver);
		appointmentAdmin.enterKeywordSearch(driver, text);
		String text2 = appointmentAdmin.captureBffName_Table(driver);
		Assert.assertEquals(text2, text);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingScheduleDateInKeywordSearch_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		String text = appointmentAdmin.captureSheduleDate_Table_Lastrow(driver);
		appointmentAdmin.enterKeywordSearch(driver, text);
		String text2 = appointmentAdmin.captureSheduleDate_Table(driver);
		Assert.assertEquals(text2, text);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingScheduleTimeInKeywordSearch_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		String text = appointmentAdmin.captureSheduleTime_Table_Lastrow(driver);
		appointmentAdmin.enterKeywordSearch(driver, text);
		String text2 = appointmentAdmin.captureSheduleTime_Table(driver);
		Assert.assertEquals(text2, text);
	}

	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);

		String text = "Test";

		enterKeywordSearch(driver, text);
		clickOnClearBtn_KeywordSearch(driver);
		String text2 = appointmentAdmin.captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "21");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
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
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		AppointmentsAdminPage appointmentAdmin = new AppointmentsAdminPage(driver);

		appointmentAdmin.clickOnAppointmentAdminBtn(driver);
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
