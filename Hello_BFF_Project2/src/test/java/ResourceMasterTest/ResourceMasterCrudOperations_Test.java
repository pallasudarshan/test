package ResourceMasterTest;

import java.io.File;
import org.testng.Assert;
import org.testng.annotations.Test;

import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.ResourcesMasterPage;

public class ResourceMasterCrudOperations_Test extends BaseClass {

	@Test
	public void verifyThatUserIsAbleToCreateResource_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		String category = "Caregiver support";
		String resourceName = resource.randomResourceName(driver);
		String link = "www.demo.com";
		String document = "./src/main/resources/CommanData/Document/datafile (12).pdf";
		String absoluteFilePath = new File(document).getAbsolutePath();
		String applicableFor = "Both";
		String image = randomImage();

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		resource.clickOnAddBtn(driver);
		resource.selectCategory(driver, category);
		resource.enterResourceName(driver, resourceName);
		resource.enterResourceLink(driver, link);
		resource.uploadDocument(driver, absoluteFilePath);
		resource.selectApplicableFOr(driver, applicableFor);
		resource.uploadImage(driver, image);
		resource.clickOnAddActionBtn(driver);
		resource.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Successfully created Source Data");
	}

	@Test
	public void verifyThatUserIsAbleToCreateResourceWithMultipleLineItems_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		String category = "General Health care";
		String resourceName1 = resource.randomResourceName(driver);
		String resourceName2 = resource.randomResourceName(driver);
		String resourceName3 = resource.randomResourceName(driver);
		String resourceName4 = resource.randomResourceName(driver);
		String link = "www.demo.com";
		String document = "./src/main/resources/CommanData/Document/datafile (12).pdf";
		String absoluteFilePath = new File(document).getAbsolutePath();
		String applicableFor = "Both";
		String image = randomImage();

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		resource.clickOnAddBtn(driver);
		resource.selectCategory(driver, category);
		resource.addLineItem(driver, resourceName1, link, absoluteFilePath, applicableFor, image);
		resource.addLineItem(driver, resourceName2, link, absoluteFilePath, applicableFor, image);
		resource.addLineItem(driver, resourceName3, link, absoluteFilePath, applicableFor, image);
		resource.addLineItem(driver, resourceName4, link, absoluteFilePath, applicableFor, image);
		resource.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Successfully created Source Data");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnEditAndSaveTheCreatedResource_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		resource.clickOnEdit_Action(driver);
		resource.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "updated");
	}

	@Test
	public void verifyThatSystemPreventsAddinglineItemWithoutEnteringData_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		resource.clickOnAddBtn(driver);
		resource.clickOnAddActionBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Enter Mandatory fields");
	}

	@Test
	public void verifyThatSystemPreventsSavingWithoutEnteringData_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		resource.clickOnAddBtn(driver);
		resource.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Please fill out all required fields");
	}

	@Test
	public void verifyThatUserIsABleToDeleteTheAddedLineItems_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		String category = "General Health care";
		String resourceName = resource.randomResourceName(driver);
		String link = "www.demo.com";
		String document = "./src/main/resources/CommanData/Document/datafile (12).pdf";
		String absoluteFilePath = new File(document).getAbsolutePath();
		String applicableFor = "Both";
		String image = randomImage();
		int count = 4;
		int count1 = 3;
		int finalCount = count - count1;

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		resource.clickOnAddBtn(driver);
		resource.selectCategory(driver, category);
		resource.addLineItem_Loop(driver, count, resourceName, link, absoluteFilePath, applicableFor, image);
		resource.clickOnDeletBtn_List(driver, count1);
		int size = resource.noOfLineItem_Size(driver);
		Assert.assertEquals(size, finalCount, "Line Items count is miss matched");
	}

	@Test
	public void verifyThatSystemAllowsUserToDeleteTheLineItemsWhileEditingAndUpdatesCorrectly_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		String category = "General Health care";
		String resourceName1 = resource.randomResourceName(driver);
		String resourceName2 = resource.randomResourceName(driver);
		String resourceName3 = resource.randomResourceName(driver);
		String resourceName4 = resource.randomResourceName(driver);
		String link = "www.demo.com";
		String document = "./src/main/resources/CommanData/Document/datafile (12).pdf";
		String absoluteFilePath = new File(document).getAbsolutePath();
		String applicableFor = "Both";
		String image = randomImage();
		int count1 = 3;
		int finalCount = 4 - count1;

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		resource.clickOnAddBtn(driver);
		resource.selectCategory(driver, category);
		resource.addLineItem(driver, resourceName1, link, absoluteFilePath, applicableFor, image);
		resource.addLineItem(driver, resourceName2, link, absoluteFilePath, applicableFor, image);
		resource.addLineItem(driver, resourceName3, link, absoluteFilePath, applicableFor, image);
		resource.addLineItem(driver, resourceName4, link, absoluteFilePath, applicableFor, image);
		resource.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Successfully created Source Data", "Unable to create resource");

		resource.clickOnEdit_Action(driver);
		resource.clickOnDeletBtn_List(driver, count1);
		resource.clickOnSaveBtn(driver);

		resource.clickOnEdit_Action(driver);
		int size = resource.noOfLineItem_Size(driver);
		Assert.assertEquals(size, finalCount, "Line Items count is miss matched");
	}

	@Test
	public void verifyThatSystemUpdatesEditedDataCorrectlyInThelist_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		String category = "Caregiver support";
		String category2 = "Social Service";
		String resourceName = resource.randomResourceName(driver);
		String link = "www.demo.com";
		String document = "./src/main/resources/CommanData/Document/datafile (12).pdf";
		String absoluteFilePath = new File(document).getAbsolutePath();
		String applicableFor = "Both";
		String image = randomImage();

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		resource.clickOnAddBtn(driver);
		resource.selectCategory(driver, category);
		resource.enterResourceName(driver, resourceName);
		resource.enterResourceLink(driver, link);
		resource.uploadDocument(driver, absoluteFilePath);
		resource.selectApplicableFOr(driver, applicableFor);
		resource.uploadImage(driver, image);
		resource.clickOnAddActionBtn(driver);
		resource.clickOnSaveBtn(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Successfully created Source Data");

		resource.clickOnEdit_Action(driver);
		resource.selectCategory(driver, category2);
		resource.clickOnSaveBtn(driver);
		Thread.sleep(3000);

		String category3 = resource.captureResourceCategory(driver);

		Assert.assertEquals(category2, category3, "Resource category is miss matched");
	}

	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);

		String text = "Test";
		enterKeywordSearch(driver, text);
		clickOnClearBtn_KeywordSearch(driver);
		String text2 = captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPaginationButton_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "11");
	}

	@Test
	public void verifyPreviousPageButton_Pagination_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPage_Pagination_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		resource.clickOnResourcesPage(driver);
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
	public void verifyfirstPage_Pagination_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);

		String no = clickOnMiddlePageNumber(driver);
		String slNo3 = captureSlNo_Table_Lastrow(driver);
		Assert.assertEquals(slNo3, no + "0");
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingResourceCodeToInKeywordSearch_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		String text = resource.captureResourceCode_Lastrow(driver);
		enterKeywordSearch(driver, text);
		Thread.sleep(1000);
		String text2 = resource.captureResourceCode(driver);
		Assert.assertEquals(text, text2);
	}
	
	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingResourceCategoryToInKeywordSearch_Test() throws Throwable {
		ResourcesMasterPage resource = new ResourcesMasterPage(driver);

		resource.clickOnResourcesPage(driver);
		clickOnSideMenuBtn(driver);
		String text = resource.captureResourceCategory_Lastrow(driver);
		enterKeywordSearch(driver, text);
		Thread.sleep(1000);
		String text2 = resource.captureResourceCategory(driver);
		Assert.assertEquals(text, text2);
	}
}
