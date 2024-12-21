package ActivityListTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.ActivityListPage;
import Hello_Bff_ObjectRepository.HomePage;
import Hello_Bff_ObjectRepository.ServiceMasterPage;

public class ActivityListTestScripts_Test extends BaseClass {

	@Test
	public void checkThatUserAbleToCreateTheActivitySuccessfully_Test() throws Throwable {

		String activityType = "Fun in Your Hands: Game On!";
		String title = generateRandomTitle_JavaFaker();
		String description = generateRandomDescriptionData(70);

		ActivityListPage acp = new ActivityListPage(driver);

		acp.clickOnTheActivityListPage(driver);
		clickOnSideMenuBtn(driver);
		acp.clickOnAddButton(driver);
		acp.enterActivityType(driver, activityType);
		acp.enterActivityName(driver);
		acp.enterActvityDescription(driver);
		acp.enterTheTitle(driver, title);
		acp.enterTheDescription(driver, description);
		acp.clickOnAddActionButton(driver);
		acp.clickOnSaveButton(driver);
		String text = acp.captureAlertText_2(driver);
		Assert.assertEquals(text, "Created Successfully");
	}

	@Test
	public void checkThatUserAbleToClickOnTheSaveButtonWithoutEnterTheManadatoryFields_Test() throws Throwable {
		ActivityListPage acp = new ActivityListPage(driver);
		HomePage hp = new HomePage(driver);

		acp.clickOnTheActivityListPage(driver);
		hp.clickOnSideMenuButton(driver);
		acp.clickOnAddButton(driver);
		acp.clickOnSaveButton(driver);
		String errorMsg = acp.captureAlertText_last(driver);
		acp.clickOnErrorPopupCloseButton(driver);
		Assert.assertEquals("Please Enter Mandatory Fields.", errorMsg);
	}

	@Test
	public void checkThatUserAbleToClickOnTheActionButtonWithoutEnterTheTitleAndDescription_Test() throws Throwable {
		ActivityListPage acp = new ActivityListPage(driver);
		HomePage hp = new HomePage(driver);

		acp.clickOnTheActivityListPage(driver);
		hp.clickOnSideMenuButton(driver);
		acp.clickOnAddButton(driver);
		acp.clickOnTheActionsButton(driver);
		String errorMsg = acp.captureAlertText_last(driver);
		acp.clickOnErrorPopupCloseButton(driver);
		Assert.assertEquals("Enter Mandatory fields", errorMsg);
	}

	@Test
	public void checkThatUserIsNotAbleToClickOnTheSaveButtonWithoutAddingTHeLineItems_Test() throws Throwable {
		ActivityListPage acp = new ActivityListPage(driver);
		HomePage hp = new HomePage(driver);

		acp.clickOnTheActivityListPage(driver);
		hp.clickOnSideMenuButton(driver);
		acp.clickOnAddButton(driver);
		acp.enterActivityType(driver, "yoga");
//		acp.selectActiptyType(driver);
		acp.enterActivityName(driver);
		acp.enterActvityDescription(driver);
		acp.clickOnSaveButton(driver);
		String msg = acp.captureAlertText_last(driver);
		System.out.println(msg);
		Assert.assertEquals("Please Enter Mandatory Fields.", msg);
	}

	@Test
	public void checkThatUserAbleToEdit_UpdateTheActivityDetailsAndVerifyInTheList_Tes() throws Throwable {

		String title = "Test";
		String description = " Description begins with observing the subject matter closely.";

		ActivityListPage acp = new ActivityListPage(driver);
		HomePage hp = new HomePage(driver);

		acp.clickOnTheActivityListPage(driver);
		hp.clickOnSideMenuButton(driver);
		acp.clickOnAddButton(driver);
		acp.enterActivityType(driver, "yoga");
		acp.enterActivityName(driver);
		String activityDeacription = acp.enterActvityDescription(driver);
		acp.enterTheTitle(driver, title);
		acp.enterTheDescription(driver, description);
		acp.clickOnAddActionButton(driver);
		acp.clickOnSaveButton(driver);

		acp.clickOnActionsButton(driver);
		acp.clickOnTheEditButton(driver);
		Thread.sleep(2000);
		String activityName1 = acp.enterActivityName(driver);
		String activityDeacription1 = acp.enterActvityDescription(driver);
		acp.clickOnSaveButton(driver);

		Thread.sleep(2000);
		String activityName2 = acp.captureActivityName_FirstrowTable(driver);
		Assert.assertEquals(activityName2, activityName1, "Activity name is miss matched");
		Assert.assertEquals(activityDeacription, activityDeacription1, "Activity description is miss matched");
	}

	@Test
	public void checkThatUserAbleToBackButton_Test() {
		ActivityListPage acp = new ActivityListPage(driver);
		HomePage hp = new HomePage(driver);

		acp.clickOnTheActivityListPage(driver);
		hp.clickOnSideMenuButton(driver);
		acp.clickOnAddButton(driver);
		acp.clickOnTheBackButton(driver);
		acp.clickOnAddButton(driver);
	}

	@Test
	public void checkThatUserAbleToAddTheMultipleDescriptionsInTheList_Test() {
		String title = "Test";
		String description = " Description begins with observing the subject matter closely. This involves using the senses to gather information about its appearance, characteristics, behavior, etc.";
		int count = 10;

		ActivityListPage acp = new ActivityListPage(driver);
		HomePage hp = new HomePage(driver);

		acp.clickOnTheActivityListPage(driver);
		hp.clickOnSideMenuButton(driver);

		acp.clickOnAddButton(driver);
		acp.addMultipleTitleAndDescriptionsInTheList(driver, title, description, count);
	}

	@Test
	public void checkThatUserCreateTheActivityWithMultipleDescriptionItmes_Test() throws Throwable {
		String title = "Test";
		String description = " Description begins with observing the subject matter closely..";
		int count = 10;
		String activityType = "There is always time for yoga";

		ActivityListPage alp = new ActivityListPage(driver);
		HomePage hp = new HomePage(driver);

		alp.clickOnTheActivityListPage(driver);
		hp.clickOnSideMenuButton(driver);

		alp.clickOnAddButton(driver);
		alp.enterActivityType(driver, activityType);
//		alp.selectActiptyType(driver);
		alp.enterActivityName(driver);
		alp.enterActvityDescription(driver);
		alp.addMultipleTitleAndDescriptionsInTheList(driver, title, description, count);
		alp.clickOnSaveButton(driver);
		String msg = alp.captureTheErrorMessage(driver);
		Assert.assertEquals("Created Successfully", msg);
	}

	@Test
	public void checkThatUserDeleteTheAddedDescriptionsInTheList_Test() throws Throwable {
		String title = "Test";
		String description = " Description begins with observing the subject matter closely..";
		int count = 10;
		String activityType = "There is always time for yoga";

		ActivityListPage alp = new ActivityListPage(driver);
		HomePage hp = new HomePage(driver);

		alp.clickOnTheActivityListPage(driver);
		hp.clickOnSideMenuButton(driver);

		alp.clickOnAddButton(driver);
		alp.enterActivityType(driver, activityType);
//		alp.selectActiptyType(driver);
		alp.enterActivityName(driver);
		alp.enterActvityDescription(driver);
		alp.addMultipleTitleAndDescriptionsInTheList(driver, title, description, count);
		alp.deleteTheDescriptionsnTheList(driver, count);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingActivityTypeInKeywordSearch_Test() throws Throwable {
		ActivityListPage alp = new ActivityListPage(driver);

		alp.clickOnTheActivityListPage(driver);
		clickOnSideMenuBtn(driver);
		String activityType = alp.captureActivityType_Table_Lastrow(driver);
		alp.enterKeywordSearch(driver, activityType);
		String activityType2 = alp.captureActivityType_FirstrowTable(driver);
		Assert.assertEquals(activityType2, activityType);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingActivityNameInKeywordSearch_Test() throws Throwable {
		ActivityListPage alp = new ActivityListPage(driver);

		alp.clickOnTheActivityListPage(driver);
		clickOnSideMenuBtn(driver);
		String activityName = alp.captureActivityName_Table_Lastrow(driver);
		alp.enterKeywordSearch(driver, activityName);
		String activityName2 = alp.captureActivityName_FirstrowTable(driver);
		Assert.assertEquals(activityName, activityName2);
	}

	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() {
		ActivityListPage alp = new ActivityListPage(driver);

		alp.clickOnTheActivityListPage(driver);
		clickOnSideMenuBtn(driver);

		String text = "Test";

		enterKeywordSearch(driver, text);
		clickOnClearBtn_KeywordSearch(driver);
		String text2 = captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		ActivityListPage alp = new ActivityListPage(driver);

		alp.clickOnTheActivityListPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		ActivityListPage alp = new ActivityListPage(driver);

		alp.clickOnTheActivityListPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		ActivityListPage alp = new ActivityListPage(driver);

		alp.clickOnTheActivityListPage(driver);
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
		ActivityListPage alp = new ActivityListPage(driver);

		alp.clickOnTheActivityListPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		ActivityListPage alp = new ActivityListPage(driver);

		alp.clickOnTheActivityListPage(driver);
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
	public void VerifyThatTheUserCanSelectAndModifyTheActivityTypeDropdownData() throws Throwable {
		ActivityListPage alp = new ActivityListPage(driver);

		String activityType1 = "mindfulness meditation";
		String activityType2 = "Physical Activity";

		alp.clickOnTheActivityListPage(driver);
		clickOnSideMenuBtn(driver);
		alp.clickOnAddButton(driver);
		alp.enterActivityType(driver, activityType1);
		alp.enterActivityType(driver, activityType2);
		String at = alp.captureActivityTypeDropDownData(driver);
		Assert.assertEquals(at, activityType2);
	}
}
