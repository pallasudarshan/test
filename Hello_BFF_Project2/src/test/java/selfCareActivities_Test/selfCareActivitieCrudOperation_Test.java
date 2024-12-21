package selfCareActivities_Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.SelfCareActivitiesPage;
@Listeners(AllureTestListeners.class)
public class selfCareActivitieCrudOperation_Test extends BaseClass {

	@Test
	public void createSelfCareActivitieMaster_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		String selfCareActivitieType = "Brain Stroming";
		String selfCareActivitieName = selfCareActivitie.randomselfCareActivitieName(driver);
		String file = randomImage();
		String selfCareActivitieDescription = generateRandomDescriptionData(20);
		String type = "Brain Stroming";
		String content = generateRandomDescriptionData(2);
		String title = generateRandomTitle_JavaFaker();
		String description = generateRandomDescriptionData(1);
		String file2 = randomImage();
		String file3 = randomImage();
		String answer = generateRandomTitle_JavaFaker();

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		selfCareActivitie.clickOnAddBtn(driver);
		selfCareActivitie.selectselfCareActivitieType(driver, selfCareActivitieType);
		selfCareActivitie.enterselfCareActivitieName(driver, selfCareActivitieName);
		selfCareActivitie.uploadFile(driver, file);
		selfCareActivitie.enterselfCareActivitieDecription(driver, selfCareActivitieDescription);
		selfCareActivitie.selectType(driver, type);
		selfCareActivitie.chooseFile_Image_table(driver, file2);
		selfCareActivitie.enterAnswer(driver, answer);
		selfCareActivitie.enterContent(driver, content);
		selfCareActivitie.enterTitle(driver, title);
		selfCareActivitie.enterDescription(driver, description);
		selfCareActivitie.enterUpload_Table(driver, file3);
		selfCareActivitie.clickOnAddAction(driver);
		selfCareActivitie.clickOnSaveBtn(driver);
		String text = captureAlertText(driver);
		Assert.assertEquals(text, "Created Successfully");
	}

	@Test
	public void createSelfCareActivitieMasterWithMultipleLineItems_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		String selfCareActivitieType = "Brain Stroming";
		String selfCareActivitieName = selfCareActivitie.randomselfCareActivitieName(driver);
		String file = randomImage();
		String selfCareActivitieDescription = generateRandomDescriptionData(20);
		String type = "Brain Stroming";
		String content1 = generateRandomDescriptionData(20);
		String content2 = generateRandomDescriptionData(20);
		String content3 = generateRandomDescriptionData(20);
		String content4 = generateRandomDescriptionData(20);
		String content5 = generateRandomDescriptionData(20);
		String title1 = generateRandomTitle_JavaFaker();
		String title2 = generateRandomTitle_JavaFaker();
		String title3 = generateRandomTitle_JavaFaker();
		String title4 = generateRandomTitle_JavaFaker();
		String title5 = generateRandomTitle_JavaFaker();
		String description1 = generateRandomDescriptionData(20);
		String description2 = generateRandomDescriptionData(20);
		String description3 = generateRandomDescriptionData(20);
		String description4 = generateRandomDescriptionData(20);
		String description5 = generateRandomDescriptionData(20);
		String file1 = randomImage();
		String file2 = randomImage();
		String file3 = randomImage();
		String file4 = randomImage();
		String file5 = randomImage();
		String answer1 = generateRandomTitle_JavaFaker();
		String answer2 = generateRandomTitle_JavaFaker();
		String answer3 = generateRandomTitle_JavaFaker();
		String answer4 = generateRandomTitle_JavaFaker();
		String answer5 = generateRandomTitle_JavaFaker();

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		selfCareActivitie.clickOnAddBtn(driver);
		selfCareActivitie.selectselfCareActivitieType(driver, selfCareActivitieType);
		selfCareActivitie.enterselfCareActivitieName(driver, selfCareActivitieName);
		selfCareActivitie.uploadFile(driver, file);
		selfCareActivitie.enterselfCareActivitieDecription(driver, selfCareActivitieDescription);

		selfCareActivitie.AddLineItem(driver, type, file2, answer1, content1, title1, description1, file1);
		selfCareActivitie.AddLineItem(driver, type, file4, answer2, content2, title2, description2, file2);
		selfCareActivitie.AddLineItem(driver, type, file5, answer3, content3, title3, description3, file3);
		selfCareActivitie.AddLineItem(driver, type, file1, answer4, content4, title4, description4, file4);
		selfCareActivitie.AddLineItem(driver, type, file3, answer5, content5, title5, description5, file5);
		selfCareActivitie.clickOnSaveBtn(driver);
		String text = captureAlertText(driver);
		Assert.assertEquals(text, "Created Successfully");
	}

	@Test
	public void verifyThatCreatedSelfCareActivitieIsDisplayedInTheListAccuratly_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		String selfCareActivitieType = "Brain Storming";
		String selfCareActivitieName = selfCareActivitie.randomselfCareActivitieName(driver);
		String file = randomImage();
		String selfCareActivitieDescription = generateRandomDescriptionData(20);
		String type = "Brainstroming Activity";
		String content = generateRandomDescriptionData(20);
		String title = generateRandomTitle_JavaFaker();
		String description = generateRandomDescriptionData(20);
		String file2 = randomImage();
		String file3 = randomImage();
		String answer = generateRandomTitle_JavaFaker();

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		selfCareActivitie.clickOnAddBtn(driver);
		selfCareActivitie.selectselfCareActivitieType(driver, selfCareActivitieType);
		selfCareActivitie.enterselfCareActivitieName(driver, selfCareActivitieName);
		selfCareActivitie.uploadFile(driver, file);
		selfCareActivitie.enterselfCareActivitieDecription(driver, selfCareActivitieDescription);
		selfCareActivitie.AddLineItem(driver, type, file2, answer, content, title, description, file3);
		selfCareActivitie.clickOnSaveBtn(driver);
		Thread.sleep(3000);
		String selfCareActivitieType2 = selfCareActivitie.captureselfCareActivitieType_Table(driver);
		String selfCareActivitieName2 = selfCareActivitie.captureselfCareActivitieName_Table(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(selfCareActivitieType2, selfCareActivitieType);
		sa.assertEquals(selfCareActivitieName2, selfCareActivitieName);
		sa.assertAll();
	}

	@Test
	public void verifyThatUserIsAbleToEditTheCreatedSelfCareActivitie_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		selfCareActivitie.clickOnEditBtn_Action(driver);
		closeAlertPopup(driver);
		Thread.sleep(5000);
		selfCareActivitie.clickOnSaveBtn(driver);
		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "updated Successfully");
	}

	@Test
	public void checkThatEditedDataIsDisplayedInTheListCorrectly_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		String selfCareActivitieType = "Brain Storming";
		String selfCareActivitieName = selfCareActivitie.randomselfCareActivitieName(driver);
		String selfCareActivitieName2 = selfCareActivitie.randomselfCareActivitieName(driver);
		String file = randomImage();
		String selfCareActivitieDescription = generateRandomDescriptionData(20);
		String type = "Brain Stroming";
		String content = generateRandomDescriptionData(20);
		String title = generateRandomTitle_JavaFaker();
		String description = generateRandomDescriptionData(20);
		String file2 = randomImage();
		String file3 = randomImage();
		String answer = generateRandomTitle_JavaFaker();

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		selfCareActivitie.clickOnAddBtn(driver);
		selfCareActivitie.selectselfCareActivitieType(driver, selfCareActivitieType);
		selfCareActivitie.enterselfCareActivitieName(driver, selfCareActivitieName);
		selfCareActivitie.uploadFile(driver, file);
		selfCareActivitie.enterselfCareActivitieDecription(driver, selfCareActivitieDescription);
		selfCareActivitie.AddLineItem(driver, type, file2, answer, content, title, description, file3);
		selfCareActivitie.clickOnSaveBtn(driver);

		selfCareActivitie.clickOnEditBtn_Action(driver);
		selfCareActivitie.selectselfCareActivitieType(driver, selfCareActivitieType);
		selfCareActivitie.enterselfCareActivitieName(driver, selfCareActivitieName2);
		selfCareActivitie.clickOnSaveBtn(driver);
		Thread.sleep(3000);
		String selfCareActivitieType3 = selfCareActivitie.captureselfCareActivitieType_Table(driver);
		String selfCareActivitieName3 = selfCareActivitie.captureselfCareActivitieName_Table(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(selfCareActivitieType3, selfCareActivitieType);
		sa.assertEquals(selfCareActivitieName3, selfCareActivitieName2);
		sa.assertAll();
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingselfCareActivitieTypeInKeywordSearch_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		String type = selfCareActivitie.captureselfCareActivitieType_Table_Lastrow(driver);
		selfCareActivitie.enterKeywordSearch(driver, type);
		String type2 = selfCareActivitie.captureselfCareActivitieType_Table(driver);
		Assert.assertEquals(type, type2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingselfCareActivitieNameInKeywordSearch_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		String workShapeName = selfCareActivitie.captureselfCareActivitieName_Table_Lastrow(driver);
		selfCareActivitie.enterKeywordSearch(driver, workShapeName);
		String workShapeName2 = selfCareActivitie.captureselfCareActivitieName_Table(driver);
		Assert.assertEquals(workShapeName.toUpperCase(), workShapeName2.toUpperCase());
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "11");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
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
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
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
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);
		String text = "Test";
		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		selfCareActivitie.enterKeywordSearch(driver, text);
		clickOnClearBtn_KeywordSearch(driver);
		String text2 = captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test(description = "Verify that system redirects to creation page after clicking on add button")
	public void verifyAddButtonFunctionality_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		selfCareActivitie.clickOnAddBtn(driver);
		String text = selfCareActivitie.captureSelfCareActivityType(driver);
		Assert.assertEquals(text, "Self Care Activity Type *");
	}

	@Test(description = "Verify that system redirects to previous page after clicking on back button")
	public void verifyBackButtonFunctionality_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		selfCareActivitie.clickOnAddBtn(driver);
		selfCareActivitie.clickOnBackBtn(driver);
		String text = selfCareActivitie.captureSnoText(driver);
		Assert.assertEquals(text, "SL.No");
	}

	@Test
	public void verifyThatUserIsAbleToDeleteTheAddedLineItems_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		String selfCareActivitieType = "Brain Stroming";
		String selfCareActivitieName = selfCareActivitie.randomselfCareActivitieName(driver);
		String file = randomImage();
		String selfCareActivitieDescription = generateRandomDescriptionData(20);
		String type = "Brain Stroming";
		String content1 = generateRandomDescriptionData(20);
		String content2 = generateRandomDescriptionData(20);
		String content3 = generateRandomDescriptionData(20);
		String content4 = generateRandomDescriptionData(20);
		String title1 = generateRandomTitle_JavaFaker();
		String title2 = generateRandomTitle_JavaFaker();
		String title3 = generateRandomTitle_JavaFaker();
		String title4 = generateRandomTitle_JavaFaker();
		String description1 = generateRandomDescriptionData(20);
		String description2 = generateRandomDescriptionData(20);
		String description3 = generateRandomDescriptionData(20);
		String description4 = generateRandomDescriptionData(20);
		String file1 = randomImage();
		String file2 = randomImage();
		String file3 = randomImage();
		String file4 = randomImage();
		String file5 = randomImage();
		String answer1 = generateRandomTitle_JavaFaker();
		String answer2 = generateRandomTitle_JavaFaker();
		String answer3 = generateRandomTitle_JavaFaker();
		String answer4 = generateRandomTitle_JavaFaker();

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		selfCareActivitie.clickOnAddBtn(driver);
		selfCareActivitie.selectselfCareActivitieType(driver, selfCareActivitieType);
		selfCareActivitie.enterselfCareActivitieName(driver, selfCareActivitieName);
		selfCareActivitie.uploadFile(driver, file);
		selfCareActivitie.enterselfCareActivitieDecription(driver, selfCareActivitieDescription);
		selfCareActivitie.AddLineItem(driver, type, file2, answer1, content1, title1, description1, file1);
		selfCareActivitie.AddLineItem(driver, type, file4, answer2, content2, title2, description2, file2);
		selfCareActivitie.AddLineItem(driver, type, file5, answer3, content3, title3, description3, file3);
		selfCareActivitie.AddLineItem(driver, type, file1, answer4, content4, title4, description4, file4);
		selfCareActivitie.clickOnDeleteBtn_LineItem(driver);
		selfCareActivitie.clickOnDeleteBtn_LineItem(driver);
		int count = selfCareActivitie.getNoOfLineItem(driver);
		Assert.assertEquals(2, count, "Delete button is functioning as expected");
	}

	@Test
	public void VerifyThatTheSystemIsUpdatingTheDeletedLineItemsAfterEditingAndUpdating_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		String selfCareActivitieType = "Brain Stroming";
		String selfCareActivitieName = selfCareActivitie.randomselfCareActivitieName(driver);
		String file = randomImage();
		String selfCareActivitieDescription = generateRandomDescriptionData(20);
		String type = "Brain Stroming";
		String content1 = generateRandomDescriptionData(20);
		String content2 = generateRandomDescriptionData(20);
		String content3 = generateRandomDescriptionData(20);
		String content4 = generateRandomDescriptionData(20);
		String title1 = generateRandomTitle_JavaFaker();
		String title2 = generateRandomTitle_JavaFaker();
		String title3 = generateRandomTitle_JavaFaker();
		String title4 = generateRandomTitle_JavaFaker();
		String description1 = generateRandomDescriptionData(20);
		String description2 = generateRandomDescriptionData(20);
		String description3 = generateRandomDescriptionData(20);
		String description4 = generateRandomDescriptionData(20);
		String file1 = randomImage();
		String file2 = randomImage();
		String file3 = randomImage();
		String file4 = randomImage();
		String file5 = randomImage();
		String answer1 = generateRandomTitle_JavaFaker();
		String answer2 = generateRandomTitle_JavaFaker();
		String answer3 = generateRandomTitle_JavaFaker();
		String answer4 = generateRandomTitle_JavaFaker();

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		selfCareActivitie.clickOnAddBtn(driver);
		selfCareActivitie.selectselfCareActivitieType(driver, selfCareActivitieType);
		selfCareActivitie.enterselfCareActivitieName(driver, selfCareActivitieName);
		selfCareActivitie.uploadFile(driver, file);
		selfCareActivitie.enterselfCareActivitieDecription(driver, selfCareActivitieDescription);
		selfCareActivitie.AddLineItem(driver, type, file2, answer1, content1, title1, description1, file1);
		selfCareActivitie.AddLineItem(driver, type, file4, answer2, content2, title2, description2, file2);
		selfCareActivitie.AddLineItem(driver, type, file5, answer3, content3, title3, description3, file3);
		selfCareActivitie.AddLineItem(driver, type, file1, answer4, content4, title4, description4, file4);
		selfCareActivitie.clickOnSaveBtn(driver);
		selfCareActivitie.clickOnEditBtn_Action(driver);
		selfCareActivitie.clickOnDeleteBtn_LineItem(driver);
		selfCareActivitie.clickOnDeleteBtn_LineItem(driver);
		selfCareActivitie.clickOnSaveBtn(driver);
		selfCareActivitie.clickOnEditBtn_Action(driver);
		int count = selfCareActivitie.getNoOfLineItem(driver);
		Assert.assertEquals(2, count, "Delete button is functioning as expected");
	}

	@Test
	public void verifyThatSystemShouldNotAllowToAddTheLineItemWithoutEnteringMandatoryData_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		selfCareActivitie.clickOnAddBtn(driver);
		selfCareActivitie.clickOnAddAction(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Enter Mandatory fields");
	}

	@Test
	public void verifyThatSystemShouldNotAllowToSaveWithoutEnteringMandatoryData_Test() throws Throwable {
		SelfCareActivitiesPage selfCareActivitie = new SelfCareActivitiesPage(driver);

		selfCareActivitie.clickOnselfCareActivitieMaster(driver);
		clickOnSideMenuBtn(driver);
		selfCareActivitie.clickOnAddBtn(driver);
		selfCareActivitie.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Please Enter Mandatory Fields.");
	}

}
