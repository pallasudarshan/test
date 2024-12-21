package ManageCustomerTest;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.ContentSourceDataPage;
import Hello_Bff_ObjectRepository.ManageCustomerPage;

@Listeners(AllureTestListeners.class)
public class ManageCustomerTestScript_Test extends BaseClass {
	@Test
	public void checkThatUserCreateTheManageCustomer_Test() throws Throwable {
		String customerType = "community";
		String state = "USA";
		String fax = "1234";
		String file = "./src/main/resources/CommanData/Document/download (1).png";
		String absoluteFilePath = new File(file).getAbsolutePath();

		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		mp.clickOnAddButton(driver);
		mp.selectCustomerType(driver, customerType);
		String customerName = mp.enterCustomerName(driver);
		mp.enterAddress(driver);
		mp.enterCity(driver);
		mp.selectStateDropdown(driver, state);
		mp.enterZipInTheText(driver);
		mp.uploadTheLogo(driver, absoluteFilePath);
		mp.enterBuisnessHead_Name(driver);
		mp.enterMobileNumber(driver);
		mp.enterFAX_Number(driver, fax);
		String email = customerName.toLowerCase().replace(" ", "") + "@demo.com";
		mp.enterEmailId_2(driver, email);
		mp.enterTermsAndConditions(driver);
		mp.clickOnSaveButton(driver);
		String text = captureAlertText_last(driver);
		Assert.assertEquals(text, "Successfully created");
	}

	@Test
	public void createCustomerByInputtingDataInAllFields_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		String customerType = "community";
		String state = "USA";
		String fax = "12345678962";
		String file = randomImage();
		String documentType = "PAN CARD";
		String docName = generateRandomTitle_JavaFaker();
		String docNo = generate_RandomNumbers();
		String file2 = randomImage();
		String time = "242";

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		mp.clickOnAddButton(driver);
		mp.selectCustomerType(driver, customerType);
		String customerName = mp.enterCustomerName(driver);
		mp.enterAddress(driver);
		mp.enterCity(driver);
		mp.selectStateDropdown(driver, state);
		mp.enterZipInTheText(driver);
		mp.uploadTheLogo(driver, file);
		mp.enterSlotBookingTime(driver, time);
		mp.enterBuisnessHead_Name(driver);
		mp.enterMobileNumber(driver);
		mp.enterFAX_Number(driver, fax);
		String email = customerName.toLowerCase().replace(" ", "") + "@demo.com";
		mp.enterEmailId_2(driver, email);
		mp.enterTermsAndConditions(driver);
		mp.clickOnSaveButton(driver);

		mp.clickOnEditUnderAction(driver);
		mp.clickOnDocumentsUpload(driver);
		mp.clickOnNewBtn(driver);
		mp.selectDocumentType(driver, documentType);
		mp.enterDocumentName(driver, docName);
		mp.enterDocumentNo(driver, docNo);
		mp.selectValidFrom(driver);
		mp.selectValidTo(driver, "2025 ", "Jan ", "15");
		mp.uploadDocumentInDocumentUploadField(driver, file2);
		mp.clickOnSaveButton_DocumentUploadPopUp(driver);
		String text2 = mp.captureAlertText_last(driver);
		Assert.assertEquals(text2, "success");
	}

	@Test
	public void verifyThatCreatedCustomerIsReflectedInTheListAccuratly_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		String customerType = "Community";
		String state = "USA";
		String fax = "1234567896";
		String file = randomImage();
		String time = "242";

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		mp.clickOnAddButton(driver);
		mp.selectCustomerType(driver, customerType);
		String customerName = mp.enterCustomerName(driver);
		String address = mp.enterAddress(driver);
		String city = mp.enterCity(driver);
		mp.selectStateDropdown(driver, state);
		mp.enterZipInTheText(driver);
		mp.uploadTheLogo(driver, file);
		mp.enterSlotBookingTime(driver, time);
		String businessName = mp.enterBuisnessHead_Name(driver);
		String contactNumber = mp.enterMobileNumber(driver);
		mp.enterFAX_Number(driver, fax);
		String email = customerName.toLowerCase().replace(" ", "") + "@demo.com";
		mp.enterEmailId_2(driver, email);
		mp.enterTermsAndConditions(driver);
		mp.clickOnSaveButton(driver);
		Thread.sleep(2000);
		String customerName2 = mp.captureCustomerName_Table(driver);
		String customerType2 = mp.captureCustomerType_Table(driver);
		String businessName2 = mp.captureBusinessName_Table(driver);
		String contactNumber2 = mp.captureContactNumber_Table(driver);
		String email2 = mp.captureEmail_Table(driver);
		String address2 = mp.captureAddress_Table(driver);
		String city2 = mp.captureCity_Table(driver);
		String faxNo2 = mp.captureFaxNo_Table(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(customerName2, customerName, "customer name is miss matched");
		sa.assertEquals(customerType2, customerType, "customer type is miss matched");
		sa.assertEquals(businessName2, businessName, "business name is miss matched");
		sa.assertEquals(contactNumber2.replace("-", "").replace(" ", "").replace("(", "").replace(")", ""),
				contactNumber, "contact number is miss matched");
		sa.assertEquals(email2, email, "email is miss matched");
		sa.assertEquals(address2.replace(" ", ""), address.replace(" ", ""), "address is miss matched");
		sa.assertTrue(city2.contains(city.replace(",", "")), "city is miss matched");
		sa.assertEquals(faxNo2.replace("-", ""), "1" + fax, "faxno is miss matched");
		sa.assertAll();
	}

	@Test
	public void verifyThatUserIsAbleToEditTheCreatedCustomer_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		mp.clickOnEditUnderAction(driver);
		Thread.sleep(5000);
		mp.clickOnSaveButton(driver);
		String text = captureAlertText_2(driver);
		Assert.assertEquals(text, "Successfully created");
	}

	@Test
	public void verifyThatEditedDataIsReflectedCorrectlyInTheList_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		String customerType = "Community";
		String customerType2 = "Corporate";
		String fax = "1234567896";
		String state = "USA";
		String file = randomImage();
		String time = "242";
		String city = "Bangalore";
		String city_ = "Haryana";

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		mp.clickOnAddButton(driver);
		mp.selectCustomerType(driver, customerType);
		String customerName = mp.enterCustomerName(driver);
		mp.enterAddress(driver);
		mp.enterCity_2(driver, city);
		mp.selectStateDropdown(driver, state);
		mp.enterZipInTheText(driver);
		mp.uploadTheLogo(driver, file);
		mp.enterSlotBookingTime(driver, time);
		mp.enterBuisnessHead_Name(driver);
		mp.enterMobileNumber(driver);
		mp.enterFAX_Number(driver, fax);
		mp.enterFAX_Number(driver, fax);
		String email = customerName.toLowerCase().replace(" ", "") + "@demo.com";
		mp.enterEmailId_2(driver, email);
		mp.enterTermsAndConditions(driver);
		mp.clickOnSaveButton(driver);
		mp.clickOnBackBtn(driver);

		Thread.sleep(2000);
		mp.clickOnEditUnderAction(driver);
		scrollToTop(driver);
		mp.selectCustomerType(driver, customerType2);
		String customerName2 = mp.enterCustomerName(driver);
		String address2 = mp.enterAddress(driver);
		mp.enterCity_2(driver, city_);
		String businessName2 = mp.enterBuisnessHead_Name(driver);
		String contactNumber2 = mp.enterMobileNumber(driver);
		String email2 = mp.enterEmailId(driver);

		mp.clickOnSaveButton(driver);
		mp.clickOnBackBtn(driver);
		driver.navigate().refresh();
		Thread.sleep(3000);
		String customerName3 = mp.captureCustomerName_Table(driver);
		String customerType3 = mp.captureCustomerType_Table(driver);
		String businessName3 = mp.captureBusinessName_Table(driver);
		String contactNumber3 = mp.captureContactNumber_Table(driver);
		String email3 = mp.captureEmail_Table(driver);
		String address3 = mp.captureAddress_Table(driver);
		String city3 = mp.captureCity_Table(driver);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(customerName2, customerName3, "customer name is miss matched");
		sa.assertEquals(customerType2, customerType3, "customer type is miss matched");
		sa.assertEquals(businessName2, businessName3, "business name is miss matched");
		sa.assertEquals(contactNumber3.replace("-", "").replace(" ", "").replace("(", "").replace(")", ""),
				contactNumber2, "contact number is miss matched");
		sa.assertEquals(email2, email3, "email is miss matched");
		sa.assertEquals(address3.replace(" ", ""), address2.replace(" ", ""), "address is miss matched");
		sa.assertEquals(city_, city3.replace(",", ""), "city is miss matched");
		sa.assertAll();
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingCustomerCodeInKeywordSearch_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		String code = mp.captureCustomerCode_Table_LastRow(driver);
		mp.enterKeywordSearch(driver, code);
		String code2 = mp.captureCustomerCode_Table(driver);
		Assert.assertEquals(code, code2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingCustomerNameInKeywordSearch_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		String customerName = mp.captureCustomerName_Table_LastRow(driver);
		mp.enterKeywordSearch(driver, customerName);
		String customerName2 = mp.captureCustomerName_Table(driver);
		Assert.assertEquals(customerName, customerName2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingCustomerTypeInKeywordSearch_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		String customerType = mp.captureCustomerType_Table_LastRow(driver);
		mp.enterKeywordSearch(driver, customerType);
		String customerType2 = mp.captureCustomerType_Table(driver);
		Assert.assertEquals(customerType, customerType2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingBusinessNameInKeywordSearch_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		String businessName = mp.captureBusinessName_Table_LastRow(driver);
		mp.enterKeywordSearch(driver, businessName);
		String businessName2 = mp.captureBusinessName_Table(driver);
		Assert.assertEquals(businessName, businessName2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingContactNumberInKeywordSearch_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		String contactNumber = mp.captureContactNumber_Table_LastRow(driver);
		mp.enterKeywordSearch(driver, contactNumber);
		String contactNumber2 = mp.captureContactNumber_Table(driver);
		Assert.assertEquals(contactNumber, contactNumber2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingEmailInKeywordSearch_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		String email = mp.captureEmail_Table_LastRow(driver);
		mp.enterKeywordSearch(driver, email);
		String email2 = mp.captureEmail_Table(driver);
		Assert.assertEquals(email, email2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingAddressInKeywordSearch_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		String address = mp.captureAddress_Table_LastRow(driver);
		mp.enterKeywordSearch(driver, address);
		String address2 = mp.captureAddress_Table(driver);
		Assert.assertEquals(address, address2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingCityInKeywordSearch_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		String city = mp.captureCity_Table_LastRow(driver);
		mp.enterKeywordSearch(driver, city);
		String city2 = mp.captureCity_Table(driver);
		Assert.assertEquals(city, city2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingFaxNoInKeywordSearch_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		String faxNo = mp.captureFaxNo_Table_LastRow(driver);
		mp.enterKeywordSearch(driver, faxNo);
		String faxNo2 = mp.captureFaxNo_Table(driver);
		Assert.assertEquals(faxNo2, faxNo);
	}

	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);

		String text = "Test";
		mp.enterKeywordSearch(driver, text);
		mp.clickOnClearBtn_KeywordSearch(driver);
		String text2 = mp.captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "31");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
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
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

//	@Test
//	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
//		ManageCustomerPage mp = new ManageCustomerPage(driver);
//
//		mp.clickOnManageCustomerPage(driver);
//		clickOnSideMenuBtn(driver);
//		clickOnLastButton(driver);
////		String slNo = captureSlNo_Table_Lastrow(driver);
//		String slNo = captureLastPageNumber(driver);
//		int slNo2 = Integer.parseInt(slNo);
//		System.out.println(slNo2);
//		clickOnFirstButton(driver);
//		String no = clickOnMiddlePageNumber(driver, slNo2);
//		String slNo3 = captureSlNo_Table_Lastrow(driver);
//		Assert.assertEquals(slNo3, no + "0");
//	}

	@Test
	public void createCustomerByAddingMultipleDocuments_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		String customerType = "community";
		String state = "USA";
		String fax = "12345678962";
		String file = randomImage();
		String documentType = "PAN CARD";
		String docName1 = generateRandomTitle_JavaFaker();
		String docName2 = generateRandomTitle_JavaFaker();
		String docName3 = generateRandomTitle_JavaFaker();
		String docName4 = generateRandomTitle_JavaFaker();
		String docName5 = generateRandomTitle_JavaFaker();
		String docName6 = generateRandomTitle_JavaFaker();
		String docNo1 = generate_RandomNumbers();
		String docNo2 = generate_RandomNumbers();
		String docNo3 = generate_RandomNumbers();
		String docNo4 = generate_RandomNumbers();
		String docNo5 = generate_RandomNumbers();
		String docNo6 = generate_RandomNumbers();
		String file1 = randomImage();
		String file2 = randomImage();
		String file3 = randomImage();
		String file4 = randomImage();
		String file5 = randomImage();
		String file6 = randomImage();
		String time = "242";

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		mp.clickOnAddButton(driver);
		mp.selectCustomerType(driver, customerType);
		mp.enterCustomerName(driver);
		mp.enterAddress(driver);
		mp.enterCity(driver);
		mp.selectStateDropdown(driver, state);
		mp.enterZipInTheText(driver);
		mp.uploadTheLogo(driver, file);
		mp.enterSlotBookingTime(driver, time);
		mp.enterBuisnessHead_Name(driver);
		mp.enterMobileNumber(driver);
		mp.enterFAX_Number(driver, fax);
		mp.enterEmailId(driver);
		mp.enterTermsAndConditions(driver);
		mp.clickOnSaveButton(driver);

		mp.clickOnEditUnderAction(driver);
		mp.clickOnDocumentsUpload(driver);

		mp.uploadDocumentFlow(driver, documentType, docName1, docNo1, file1);
		mp.clickOnSaveButton_DocumentUploadPopUp(driver);

		mp.uploadDocumentFlow(driver, documentType, docName2, docNo2, file2);
		mp.clickOnSaveButton_DocumentUploadPopUp(driver);

		mp.uploadDocumentFlow(driver, documentType, docName3, docNo3, file3);
		mp.clickOnSaveButton_DocumentUploadPopUp(driver);

		mp.uploadDocumentFlow(driver, documentType, docName4, docNo4, file4);
		mp.clickOnSaveButton_DocumentUploadPopUp(driver);

		mp.uploadDocumentFlow(driver, documentType, docName5, docNo5, file5);
		mp.clickOnSaveButton_DocumentUploadPopUp(driver);

		mp.uploadDocumentFlow(driver, documentType, docName6, docNo6, file6);
		mp.clickOnSaveButton_DocumentUploadPopUp(driver);

//		String text2 = mp.captureAlertText_last(driver);
//		Assert.assertEquals(text2, "success");
	}

	@Test
	public void verifyAddButtonFunctionality_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		mp.clickOnAddButton(driver);
		String text = mp.captureCustomerMasterText(driver);
		Assert.assertEquals(text, "Customer Master");
	}

	@Test
	public void verifyCancelButtonFunctionality_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		mp.clickOnAddButton(driver);
		mp.clickOnCancelButton(driver);
		Thread.sleep(6000);
		String text = mp.captureCustomerListText(driver);
		Assert.assertEquals(text, "Customer List");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		ManageCustomerPage mp = new ManageCustomerPage(driver);

		mp.clickOnManageCustomerPage(driver);
		clickOnSideMenuBtn(driver);
		String no = clickOnMiddlePageNumber(driver);
		String slNo3 = captureSlNo_Table_Lastrow(driver);
		Assert.assertEquals(slNo3, no + "0");
	}

}
