package DailyMessageMasterTest;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.DailyMessageMasterPage;
@Listeners(AllureTestListeners.class)
public class DailyMessageMasterCreation_Test extends BaseClass {

	@Test
	public void createDailyMessageMaster_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		String category = "Seeker";
		String content = dailyMessageMaster.randomContent(driver) + " " + generateRandomCharacter()
				+ generateRandomCharacter() + generateRandomCharacter() + generateRandomCharacter();
		String file = randomImage();

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		dailyMessageMaster.clickOnNewBtn(driver);
		dailyMessageMaster.selectCategory_UserType(driver, category);
		dailyMessageMaster.enterContent(driver, content);
		dailyMessageMaster.selectFromDate(driver);
		dailyMessageMaster.selectToDate(driver);
		dailyMessageMaster.uploadImage(driver, file);
		dailyMessageMaster.clickOnSaveBtn(driver);
//		String text = captureAlertText_last(driver);
//		Assert.assertEquals(text, "Message saved successfully");
		Thread.sleep(5000);
	}

	@Test
	public void createDailyMessageMasterAndVerifyDataInTheList_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		String category = "Seeker";
		String content = dailyMessageMaster.randomContent(driver) + " " + generateRandomCharacter()
				+ generateRandomCharacter() + generateRandomCharacter() + generateRandomCharacter();
		String file = randomImage();

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		dailyMessageMaster.clickOnNewBtn(driver);
		dailyMessageMaster.selectCategory_UserType(driver, category);
		dailyMessageMaster.enterContent(driver, content);
		dailyMessageMaster.selectFromDate(driver);
		dailyMessageMaster.selectToDate(driver);
		dailyMessageMaster.uploadImage(driver, file);
		dailyMessageMaster.clickOnSaveBtn(driver);
		Thread.sleep(2000);
		String category2 = dailyMessageMaster.captureCategory_Table(driver);
		String content2 = dailyMessageMaster.captureContent_Table(driver);
		String fromDate2 = dailyMessageMaster.captureFromDate_Table(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(category2, category);
		sa.assertEquals(content2.replace(" ", ""), content.replaceAll("[^a-zA-Z0-9]", ""));
		sa.assertEquals(fromDate2, generateCurrentDate_YYYYMMDD());
		sa.assertAll();
	}

	@Test
	public void editCreatedDailyMessageMaster_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		dailyMessageMaster.clickOnAction_ClickOnEditBtn(driver);
		dailyMessageMaster.clickOnSaveBtn(driver);
//		String text = captureAlertText_2(driver);
//		Assert.assertEquals(text, "updated");
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingCategoryInKeywordSearch_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String category = dailyMessageMaster.captureCategory_Table_Lastrow(driver);
		dailyMessageMaster.enterKeywordSearch(driver, category);
		String category2 = dailyMessageMaster.captureCategory_Table(driver);
		Assert.assertEquals(category2, category);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingContentInKeywordSearch_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String content = dailyMessageMaster.captureContent_Table_Lastrow(driver);
		dailyMessageMaster.enterKeywordSearch(driver, content);
		String content2 = dailyMessageMaster.captureContent_Table(driver);
		Assert.assertEquals(content, content2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingFromDateInKeywordSearch_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String fromDate = dailyMessageMaster.captureFromDate_Table_Lastrow(driver);
		dailyMessageMaster.enterKeywordSearch(driver, fromDate);
		String fromDate2 = dailyMessageMaster.captureFromDate_Table(driver);
		Assert.assertEquals(fromDate2, fromDate);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingToDateInKeywordSearch_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String toDate = dailyMessageMaster.captureToDate_Table_Lastrow(driver);
		dailyMessageMaster.enterKeywordSearch(driver, toDate);
		String toDate2 = dailyMessageMaster.captureToDate_Table(driver);
		Assert.assertEquals(toDate2, toDate);
	}

	@Test
	public void verifyCancelButtonFunctionality_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		dailyMessageMaster.clickOnNewBtn(driver);
		dailyMessageMaster.clickOnCancelBtn(driver);
		String text = dailyMessageMaster.captureDailyMessageText(driver);
		Assert.assertEquals(text, "Daily Message List");
	}

	@Test
	public void verifyClearButtonFunctionality_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		String text = "Test";

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		dailyMessageMaster.enterKeywordSearch(driver, text);
		clickOnClearBtn_KeywordSearch(driver);
		String text2 = dailyMessageMaster.captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
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
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
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
	public void verifyThatUserIsAbleToEditAndUpdateTheDailyMassageDetails_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		String category = "Seeker";
		String category2 = "customer";
		String content = dailyMessageMaster.randomContent(driver) + " " + generateRandomCharacter()
				+ generateRandomCharacter() + generateRandomCharacter() + generateRandomCharacter();
		String content2 = dailyMessageMaster.randomContent(driver) + " " + generateRandomCharacter()
				+ generateRandomCharacter() + generateRandomCharacter() + generateRandomCharacter();
		String file = randomImage();
		String file2 = randomImage();

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		dailyMessageMaster.clickOnNewBtn(driver);
		dailyMessageMaster.selectCategory_UserType(driver, category);
		dailyMessageMaster.enterContent(driver, content);
		dailyMessageMaster.selectFromDate(driver);
		dailyMessageMaster.selectToDate(driver);
		dailyMessageMaster.uploadImage(driver, file);
		dailyMessageMaster.clickOnSaveBtn(driver);
		Thread.sleep(6000);
		dailyMessageMaster.clickOnAction_ClickOnEditBtn(driver);

		dailyMessageMaster.selectCategory_UserType(driver, category2);
		dailyMessageMaster.enterContent(driver, content2);
		dailyMessageMaster.selectFromDate(driver);
		dailyMessageMaster.selectToDate(driver);
		dailyMessageMaster.uploadImage(driver, file2);
		dailyMessageMaster.clickOnSaveBtn(driver);

		Thread.sleep(2000);
		String category3 = dailyMessageMaster.captureCategory_Table(driver);
		String content3 = dailyMessageMaster.captureContent_Table(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(category3, category2, "Category is miss matched");
		sa.assertEquals(content3.replace(" ", ""), content2.replaceAll("[^a-zA-Z0-9]", ""), "content is miss matched");
		sa.assertAll();
	}

	@Test
	public void verifyThatUploadedFileWhileCreatingTheDailyMessageIsReflectedWhenUserClicksOnEditButton()
			throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		String category = "Seeker";
		String content = dailyMessageMaster.randomContent(driver) + " " + generateRandomCharacter()
				+ generateRandomCharacter() + generateRandomCharacter() + generateRandomCharacter();
		String file = randomImage();

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		dailyMessageMaster.clickOnNewBtn(driver);
		dailyMessageMaster.selectCategory_UserType(driver, category);
		dailyMessageMaster.enterContent(driver, content);
		dailyMessageMaster.selectFromDate(driver);
		dailyMessageMaster.selectToDate(driver);
		dailyMessageMaster.uploadImage(driver, file);
		dailyMessageMaster.clickOnSaveBtn(driver);
		Thread.sleep(6000);
		dailyMessageMaster.clickOnAction_ClickOnEditBtn(driver);
		String file2 = dailyMessageMaster.captureUploadedFileName(driver);
		Path path = Paths.get(file2);
		String fileName = path.getFileName().toString();

		if (fileName.isEmpty()) {
			Assert.fail("Uploaded file is not reflected while editing");
		} else {
			Assert.assertTrue(file.contains(fileName), "Upladed file is not reflected while editing ->");
		}
	}

	@Test
	public void verifyCloseButtonFunctionalityInThePopUpAfterClickingOnNewBtn_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		dailyMessageMaster.clickOnNewBtn(driver);
		Thread.sleep(1000);
		dailyMessageMaster.clickOnCloseBtn(driver);
		dailyMessageMaster.verifyThatPopUpIsClosed(driver);
	}

	@Test
	public void verifyCloseButtonFunctionalityInThePopUpAfterClickingOnEditBtn_Test() throws Throwable {
		DailyMessageMasterPage dailyMessageMaster = new DailyMessageMasterPage(driver);

		dailyMessageMaster.clickOnDailyMessageMasterScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		Thread.sleep(2000);
		dailyMessageMaster.clickOnAction_ClickOnEditBtn(driver);
		Thread.sleep(2000);
		dailyMessageMaster.clickOnCloseBtn(driver);
		dailyMessageMaster.verifyThatPopUpIsClosed(driver);
	}
}
