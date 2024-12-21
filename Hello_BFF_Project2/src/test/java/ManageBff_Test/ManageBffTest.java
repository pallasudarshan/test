package ManageBff_Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.PhoneNumber;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.HomePage;
import Hello_Bff_ObjectRepository.ManageBffPage;
import Hello_Bff_ObjectRepository.NewsRoomPage;

@Listeners(AllureTestListeners.class)
public class ManageBffTest extends BaseClass {

	@Test(invocationCount = 1)
	public void createBffRegistrationWith_GeneralInfo_Test() throws Throwable {
		String bffType = "PHYSICIAN";
		String bffCategory = "cardiovascular drugs";
		String skill = "Counseling Techniques";
		String currentDepartment = "TEST";
		String currentDesignation = "TEST";
		String file = randomImage();

		ManageBffPage mp = new ManageBffPage(driver);
		mp.setAge("12");
		mp.setRelation("BROTHER");
		mp.setIssueDate("01/23/2023");
		mp.setExpiryDate("12/12/2023");
		mp.setIssuePlace("INDIA");
		mp.setCity("Bangalore");
		mp.setState("Option 1");

		mp.clickOnTheManageBffPageButton(driver);
		clickOnSideMenuBtn(driver);
		mp.clickOnTheAddButton(driver);
		mp.enterFirstName(driver);
		mp.enterLastName(driver);
		mp.enterEmail(driver);
		mp.enterMobileNumber(driver);
		mp.selectGender(driver);
		mp.uploadImage(driver, file);

		// General info
		mp.createGeneralInfo(driver, bffType, bffCategory, skill, currentDepartment, currentDesignation);
		mp.clickOnSaveButton_GeneralInfo(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "successfully registered", "Failed To Create BFF");
//		mp.clickOnEditBtn(driver);
//
//		// personal Info
//		mp.clickOnPersonalInfoTab(driver);
//		mp.createThePersonalInformationTabDetails(driver, mp);
//		mp.clickOnSaveButton_PersonalInfo(driver);
	}

	@Test
	public void createBffRegistrationWithAllData_GeneralInfo_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		String bffType = "PHYSICIAN";
		String bffCategory = "cardiovascular drugs";
		String skill = "Anger";
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
		String first = manageBff.enterFirstName(driver);
		String middle = manageBff.enterMiddleName_Random(driver);
		String last = manageBff.enterLastName(driver);
		manageBff.uploadImage(driver, file);
		String email = first + middle + last + "@demo.com";
		String email1 = email.toLowerCase();
		manageBff.enterEmail2(driver, email1);
		manageBff.enterMobileNumber(driver);
		manageBff.selectGender(driver);

		manageBff.selectBffType(driver, bffType);
		manageBff.selectBffCategory(driver, bffCategory);
		manageBff.selectSkills(driver, skill);
		manageBff.selectcurrentDepartment(driver, currentDepartment);
		manageBff.selectcurrentDesignation(driver, currentDesignation);
		manageBff.clickOnSaveButton_GeneralInfo(driver);
		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "successfully registered", "General info - success message is miss matched");

	}

	@Test
	public void createBffRegistrationWithAllData_GeneralInfoAndPersonalInfo_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		String bffType = "PHYSICIAN";
		String bffCategory = "cardiovascular drugs";
		String skill = "Anger";
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
		String first = manageBff.enterFirstName(driver);
		String middle = manageBff.enterMiddleName_Random(driver);
		String last = manageBff.enterLastName(driver);
		manageBff.uploadImage(driver, file);
		String email = first + middle + last + "@demo.com";
		manageBff.enterEmail2(driver, email);
		manageBff.enterMobileNumber(driver);
		manageBff.selectGender(driver);

		manageBff.selectBffType(driver, bffType);
		manageBff.selectBffCategory(driver, bffCategory);
		manageBff.selectSkills(driver, skill);
		manageBff.selectcurrentDepartment(driver, currentDepartment);
		manageBff.selectcurrentDesignation(driver, currentDesignation);
		manageBff.clickOnSaveButton_GeneralInfo(driver);
		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "successfully registered", "General info - success message is miss matched");
		manageBff.clickOnEditBtn(driver);
		
		Thread.sleep(3000);
		manageBff.clickOnPersonalInfoTab(driver);
		manageBff.createThePersonalInformationTabDetails_2(driver, manageBff);
		manageBff.clickOnSaveButton_PersonalInfo(driver);
		captureAlertText_2(driver);
		String text2 = captureAlertText_2(driver);
		Assert.assertEquals(text2, "success", "Personal info - success message is miss matched");

	}

	@Test
	public void createBffRegistrationWithAllData_GeneralInfo_PersonalInfo_EducationalInfo_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		String bffType = "PHYSICIAN";
		String bffCategory = "cardiovascular drugs";
		String skill = "Anger";
		String currentDepartment = "TEST";
		String currentDesignation = "TEST";
		String file = randomImage();
		String degreeLevel = "Masters";
		String school = "Masters";
		String yearsOfCompleted = "1";

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
		String first = manageBff.enterFirstName(driver);
		String middle = manageBff.enterMiddleName_Random(driver);
		String last = manageBff.enterLastName(driver);
		manageBff.uploadImage(driver, file);
		String email = first + middle + last + "@demo.com";
		manageBff.enterEmail2(driver, email);
		manageBff.enterMobileNumber(driver);
		manageBff.selectGender(driver);

		manageBff.selectBffType(driver, bffType);
		manageBff.selectBffCategory(driver, bffCategory);
		manageBff.selectSkills(driver, skill);
		manageBff.selectcurrentDepartment(driver, currentDepartment);
		manageBff.selectcurrentDesignation(driver, currentDesignation);
		manageBff.clickOnSaveButton_GeneralInfo(driver);
		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "successfully registered", "General info - success message is miss matched");

		Thread.sleep(3000);
		manageBff.clickOnPersonalInfoTab(driver);
		manageBff.createThePersonalInformationTabDetails_2(driver, manageBff);
		manageBff.clickOnSaveButton_PersonalInfo(driver);
		captureAlertText_2(driver);
		String text2 = captureAlertText_2(driver);
		Assert.assertEquals(text2, "success", "Personal info - success message is miss matched");

		manageBff.clickOnEducationalInfoTab(driver);
		manageBff.clickOnNewBtn(driver);
		manageBff.selectDegreeLevel(driver, degreeLevel);
		manageBff.enterSchool_University(driver, school);
		manageBff.enterYearsOfCompleted(driver, yearsOfCompleted);
		manageBff.selectSubject(driver);
		manageBff.enterDocumentUpload(driver, file);
		manageBff.clickOnSave_EducationalInfo(driver);
		captureAlertText_2(driver);
		String text3 = captureAlertText_2(driver);
		Assert.assertEquals(text3, "success", "Educational info - success message is miss matched");
	}

	@Test
	public void createBff_EditAndAddDataInDocumentTab_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		String bffType = "PHYSICIAN";
		String bffCategory = "cardiovascular drugs";
		String skill = "Anger";
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
		String first = manageBff.enterFirstName(driver);
		String middle = manageBff.enterMiddleName_Random(driver);
		String last = manageBff.enterLastName(driver);
		manageBff.uploadImage(driver, file);
		String email = first + middle + last + "@demo.com";
		manageBff.enterEmail2(driver, email);
		manageBff.enterMobileNumber(driver);
		manageBff.selectGender(driver);

		manageBff.selectBffType(driver, bffType);
		manageBff.selectBffCategory(driver, bffCategory);
		manageBff.selectSkills(driver, skill);
		manageBff.selectcurrentDepartment(driver, currentDepartment);
		manageBff.selectcurrentDesignation(driver, currentDesignation);
		manageBff.clickOnSaveButton_GeneralInfo(driver);
		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "successfully registered", "General info - success message is miss matched");

		String docType = "License";
		String docName = generateRandomTitle_JavaFaker();
		String docNo = generate_RandomNumbers();

		manageBff.clickOnEditBtn(driver);
		manageBff.clickOnDocumentTab(driver);

		manageBff.clickOnNewBtn_DocumentTab(driver);

		manageBff.selectDocumentType_DocumentTab(driver, docType);
		manageBff.enterDocumentName_DocumentTab(driver, docName);
		manageBff.enterDocumentNo_DocumentTab(driver, docNo);
		manageBff.enterValidFrom_DocumentTab(driver);
		manageBff.enterValidTo_DocumentTab(driver);
		manageBff.enterDocumentUpload_DocumentTab(driver, file);

		manageBff.clickOnSave_DocumentTab(driver);
//		String text2 = captureAlertText_last(driver);
//		Assert.assertEquals(text2, "success", "Document Tab - success message is miss matched");

	}

	@Test
	public void createBff_AddDataInDocumentTab_MultipleDocuments_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		String bffType = "PHYSICIAN";
		String bffCategory = "cardiovascular drugs";
		String skill = "Anger";
		String currentDepartment = "TEST";
		String currentDesignation = "TEST";
		String file = randomImage();
		String file2 = randomImage();
		String file3 = randomImage();
		String file4 = randomImage();
		String file5 = randomImage();

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
		String first = manageBff.enterFirstName(driver);
		String middle = manageBff.enterMiddleName_Random(driver);
		String last = manageBff.enterLastName(driver);
		manageBff.uploadImage(driver, file);
		String email = first + middle + last + "@demo.com";
		manageBff.enterEmail2(driver, email);
		manageBff.enterMobileNumber(driver);
		manageBff.selectGender(driver);

		manageBff.selectBffType(driver, bffType);
		manageBff.selectBffCategory(driver, bffCategory);
		manageBff.selectSkills(driver, skill);
		manageBff.selectcurrentDepartment(driver, currentDepartment);
		manageBff.selectcurrentDesignation(driver, currentDesignation);
		manageBff.clickOnSaveButton_GeneralInfo(driver);
//		String text = captureAlertText_2(driver);
//		Assert.assertEquals(text, "successfully registered", "General info - success message is miss matched");

		String docType = "License";
		String docName1 = generateRandomTitle_JavaFaker();
		String docName2 = generateRandomTitle_JavaFaker();
		String docName3 = generateRandomTitle_JavaFaker();
		String docName4 = generateRandomTitle_JavaFaker();
		String docName5 = generateRandomTitle_JavaFaker();
		String docNo1 = generate_RandomNumbers();
		String docNo2 = generate_RandomNumbers();
		String docNo3 = generate_RandomNumbers();
		String docNo4 = generate_RandomNumbers();
		String docNo5 = generate_RandomNumbers();
		
		manageBff.clickOnEditBtn(driver);
		manageBff.clickOnDocumentTab(driver);
		manageBff.clickOnNewBtn_DocumentTab(driver);
		manageBff.documentTab_Flow(driver, docType, docName1, docNo1, file);

		manageBff.clickOnEditBtn(driver);
		manageBff.clickOnDocumentTab(driver);
		manageBff.clickOnNewBtn_DocumentTab(driver);
		manageBff.documentTab_Flow(driver, docType, docName2, docNo2, file2);

		manageBff.clickOnEditBtn(driver);
		manageBff.clickOnDocumentTab(driver);
		manageBff.clickOnNewBtn_DocumentTab(driver);
		manageBff.documentTab_Flow(driver, docType, docName3, docNo3, file3);

		manageBff.clickOnEditBtn(driver);
		manageBff.clickOnDocumentTab(driver);
		manageBff.clickOnNewBtn_DocumentTab(driver);
		manageBff.documentTab_Flow(driver, docType, docName4, docNo4, file4);

		manageBff.clickOnEditBtn(driver);
		manageBff.clickOnDocumentTab(driver);
		manageBff.clickOnNewBtn_DocumentTab(driver);
		manageBff.documentTab_Flow(driver, docType, docName5, docNo5, file5);

		String text2 = captureAlertText_2(driver);
		Assert.assertEquals(text2, "success", "Document Tab - success message is miss matched");
	}

	@Test
	public void verifyThatCreatedBffDetailsAreReflectedInTheListAccuratly_Test_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		String bffType = "PHYSICIAN";
		String bffCategory = "cardiovascular drugs";
		String skill = "Anger";
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
		String first = manageBff.enterFirstName(driver);
		String middle = manageBff.enterMiddleName_Random(driver);
		String last = manageBff.enterLastName(driver);
		manageBff.uploadImage(driver, file);
		String email = first + middle + last + "@demo.com";
		manageBff.enterEmail2(driver, email);
		String mobileNumber = manageBff.enterMobileNumber(driver);
		manageBff.selectGender(driver);

		manageBff.selectBffType(driver, bffType);
		manageBff.selectBffCategory(driver, bffCategory);
		manageBff.selectSkills(driver, skill);
		manageBff.selectcurrentDepartment(driver, currentDepartment);
		manageBff.selectcurrentDesignation(driver, currentDesignation);
		manageBff.clickOnSaveButton_GeneralInfo(driver);

		String bffName = manageBff.captureBffName_Table(driver);
		String PhoneNumber = manageBff.capturePhoneNumber_Table(driver);
		String emailId = manageBff.captureEmailId_Table(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(bffName.toUpperCase(), first.toUpperCase() + " " + middle.toUpperCase() + " " + last.toUpperCase(), "Bff name is miss matched");
		sa.assertEquals(PhoneNumber.replaceAll("[^0-9]", ""), mobileNumber, "mobile number is miss matched");
		sa.assertEquals(emailId, email, "email is miss matched");
		sa.assertAll();
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingBffNameInKeywordSearch_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		manageBff.clickOnTheManageBffPageButton(driver);
		clickOnSideMenuBtn(driver);
		String text = manageBff.captureBffName_Table_Lastrow(driver);
		manageBff.enterKeywordSearch(driver, text);
		String text2 = manageBff.captureBffName_Table(driver);
		Assert.assertEquals(text, text2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingPhoneNumberInKeywordSearch_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		manageBff.clickOnTheManageBffPageButton(driver);
		clickOnSideMenuBtn(driver);
		String text = manageBff.capturePhoneNumber_Table_Lastrow(driver);
		manageBff.enterKeywordSearch(driver, text);
		String text2 = manageBff.capturePhoneNumber_Table(driver);
		Assert.assertEquals(text, text2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingEmailIdInKeywordSearch_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		manageBff.clickOnTheManageBffPageButton(driver);
		clickOnSideMenuBtn(driver);
		String text = manageBff.captureEmailId_Table_Lastrow(driver);
		manageBff.enterKeywordSearch(driver, text);
		String text2 = manageBff.captureEmailId_Table(driver);
		Assert.assertEquals(text, text2);
	}

	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		manageBff.clickOnTheManageBffPageButton(driver);
		clickOnSideMenuBtn(driver);

		String text = "Test";

		manageBff.enterKeywordSearch(driver, text);
		manageBff.clickOnClearBtn(driver);
		String text2 = manageBff.captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		manageBff.clickOnTheManageBffPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		manageBff.clickOnTheManageBffPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		manageBff.clickOnTheManageBffPageButton(driver);
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
		ManageBffPage manageBff = new ManageBffPage(driver);

		manageBff.clickOnTheManageBffPageButton(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		ManageBffPage manageBff = new ManageBffPage(driver);

		manageBff.clickOnTheManageBffPageButton(driver);
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
