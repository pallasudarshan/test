package NewsRoom_Test;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Hello_Bff_GenericUtility.AllureTestListeners;
import Hello_Bff_GenericUtility.BaseClass;
import Hello_Bff_ObjectRepository.NewsRoomPage;
@Listeners(AllureTestListeners.class)
public class NewsRoomCreation_Test extends BaseClass {

	@Test
	public void verifyThatUserIsAbleToDraftNewsRoomAndDetailsAreReflectedInTheList_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		String blogType = "blog 1";
		String blogCategory = "blog cat 1";
		String blogTitle = generateRandomTitle_JavaFaker();
		String blogContent = generateRandomContent_JavaFaker();

		String blogImage = randomImage();

		String author = generateRandomName_JavaFaker();
		String addLink = "https://www.lipsum.com";

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		newsRoom.clickOnNewBtn(driver);
		newsRoom.selectBlogType(driver, blogType);
		newsRoom.selectBlogCategory(driver, blogCategory);
		newsRoom.enterBlogTitle(driver, blogTitle);
		newsRoom.enterBlogContent(driver, blogContent);
		newsRoom.chooseBlogImage(driver, blogImage);
		newsRoom.enterAuthor(driver, author);
		newsRoom.selectPublishedOn(driver);
		newsRoom.enterAddLink(driver, addLink);
		newsRoom.clickOnAllowCommentsToggleBtn(driver);
		newsRoom.clickOnAllowLikesToggleBtn(driver);
		newsRoom.clickOnAllowShareToggleBtn(driver);
		newsRoom.clickOnDraftBtn(driver);

		Thread.sleep(3000);

		String blogType2 = newsRoom.captureBlogType_Table(driver);
		String blogCategory2 = newsRoom.captureBlogCategory_Table(driver);
		String blogTitle2 = newsRoom.captureBlogTitle_Table(driver);
		String author2 = newsRoom.captureAuthor_Table(driver);
		String publishedOn = newsRoom.capturePublishedOn_Table(driver);
		SoftAssert sa = new SoftAssert();

		sa.assertEquals(blogType2, blogType);
		sa.assertEquals(blogCategory2, blogCategory);
		sa.assertEquals(blogTitle2, blogTitle);
		sa.assertEquals(author2, author);
		sa.assertEquals(publishedOn, generateCurrentDate_YYYYMMDD());
		sa.assertAll();
	}

	@Test
	public void verifyThatUserIsAbleToPublishNewsRoomAndDetailsAreReflectedInTheList_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		String blogType = "blog 1";
		String blogCategory = "blog cat 1";
		String blogTitle = generateRandomTitle_JavaFaker();
		String blogContent = generateRandomContent_JavaFaker();

		String blogImage = randomImage();

		String author = generateRandomName_JavaFaker();
		String addLink = "https://www.lipsum.com/";

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		newsRoom.clickOnNewBtn(driver);
		newsRoom.selectBlogType(driver, blogType);
		newsRoom.selectBlogCategory(driver, blogCategory);
		newsRoom.enterBlogTitle(driver, blogTitle);
		newsRoom.enterBlogContent(driver, blogContent);
		newsRoom.chooseBlogImage(driver, blogImage);
		newsRoom.enterAuthor(driver, author);
		newsRoom.selectPublishedOn(driver);
		newsRoom.enterAddLink(driver, addLink);
		newsRoom.clickOnAllowCommentsToggleBtn(driver);
		newsRoom.clickOnAllowLikesToggleBtn(driver);
		newsRoom.clickOnAllowShareToggleBtn(driver);
		newsRoom.clickOnPublishBtn(driver);

		Thread.sleep(4000);

		String blogType2 = newsRoom.captureBlogType_Table(driver);
		String blogCategory2 = newsRoom.captureBlogCategory_Table(driver);
		String blogTitle2 = newsRoom.captureBlogTitle_Table(driver);
		String author2 = newsRoom.captureAuthor_Table(driver);
		String publishedOn = newsRoom.capturePublishedOn_Table(driver);
		SoftAssert sa = new SoftAssert();

		sa.assertEquals(blogType2, blogType);
		sa.assertEquals(blogCategory2, blogCategory);
		sa.assertEquals(blogTitle2, blogTitle);
		sa.assertEquals(author2, author);
		sa.assertEquals(publishedOn, generateCurrentDate_YYYYMMDD());
		sa.assertAll();
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingBlogTypeInKeywordSearch_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String blogType = newsRoom.captureBlogType_Table_Lastrow(driver);
		newsRoom.enterKeywordSearch(driver, blogType);
		String blogType2 = newsRoom.captureBlogType_Table(driver);
		Assert.assertEquals(blogType, blogType2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingBlogCategoryInKeywordSearch_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String blogCategory = newsRoom.captureBlogCategory_Table_Lastrow(driver);
		newsRoom.enterKeywordSearch(driver, blogCategory);
		String blogCategory2 = newsRoom.captureBlogCategory_Table(driver);
		Assert.assertEquals(blogCategory, blogCategory2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingBlogTitleInKeywordSearch_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String blogTitle = newsRoom.captureBlogTitle_Table_Lastrow(driver);
		newsRoom.enterKeywordSearch(driver, blogTitle);
		String blogTitle2 = newsRoom.captureBlogTitle_Table(driver);
		Assert.assertEquals(blogTitle, blogTitle2);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingAuthorInKeywordSearch_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String author = newsRoom.captureAuthor_Table_Lastrow(driver);
		newsRoom.enterKeywordSearch(driver, author);
		String author2 = newsRoom.captureAuthor_Table(driver);
		Assert.assertEquals(author2, author);
	}

	@Test
	public void verifythatUserIsAbleToFilterTheDataUsingPublishedOnInKeywordSearch_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		String publishedOn = newsRoom.capturePublishedOn_Table_Lastrow(driver);
		newsRoom.enterKeywordSearch(driver, publishedOn);
		String publishedOn2 = newsRoom.capturePublishedOn_Table(driver);
		Assert.assertEquals(publishedOn, publishedOn2);
	}

	@Test
	public void verifyClearButtonFunctionalityForKeywordSearchField_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		String text = "Test";

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		newsRoom.enterKeywordSearch(driver, text);
		newsRoom.clickOnClearBtn_KeywordSearch(driver);
		String text2 = newsRoom.captureKeywordSearchField(driver);
		Assert.assertEquals("", text2);
	}

	@Test
	public void verifyNextPageButtonPaginationBtn_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
//		clickOnNextButton(driver);
//		clickOnNextButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "11");
	}

	@Test
	public void verifyPreviousPageButtonPaginationBtn_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		clickOnNextButton(driver);
		clickOnPreviousButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyLastPagePaginationBtn_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		newsRoom.clickOnNewsRoomScreenBtn(driver);
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
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		clickOnLastButton(driver);
		clickOnFirstButton(driver);
		String text = captureSlNo_Table(driver);
		Assert.assertEquals(text, "1");
	}

	@Test
	public void verifyThatUserIsAbleToClickOnPaginationNumberAndDataIsReflectingCorrectly_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		newsRoom.clickOnNewsRoomScreenBtn(driver);
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
	public void verifyCloseButtonFunctionality_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		newsRoom.clickOnNewBtn(driver);
		newsRoom.clickOnCloseBtn(driver);
		String text = newsRoom.captureNewsRoomText(driver);
		Assert.assertEquals(text, "News Room");
	}

	@Test
	public void verifyThatUploadedBlogImageIsDisplayed_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		String blogImage = "./src/main/resources/CommanData/Document/productImage.png";
		String absoluteFilePath = new File(blogImage).getAbsolutePath();

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		newsRoom.clickOnNewBtn(driver);
		newsRoom.chooseBlogImage(driver, absoluteFilePath);
		Thread.sleep(1000);
		newsRoom.verifyThatImageIsDisplayed(driver);
	}

	@Test
	public void verifyThatUserIsAbleToEditAndUpdateTheCreatedNewsAndVerifyDetailsInTheList_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);

		String blogType = "blog 1";
		String blogCategory = "blog cat 1";
		String blogTitle = generateRandomTitle_JavaFaker();
		String blogContent = generateRandomContent_JavaFaker();
		String blogImage = randomImage();
		String author = generateRandomName_JavaFaker();
		String addLink = "https://www.lipsum.com/";

		String blogTitle2 = generateRandomTitle_JavaFaker();
		String blogImage2 = randomImage();
		String author2 = generateRandomName_JavaFaker();

		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		newsRoom.clickOnNewBtn(driver);
		newsRoom.selectBlogType(driver, blogType);
		newsRoom.selectBlogCategory(driver, blogCategory);
		newsRoom.enterBlogTitle(driver, blogTitle);
		newsRoom.enterBlogContent(driver, blogContent);
		newsRoom.chooseBlogImage(driver, blogImage);
		newsRoom.enterAuthor(driver, author);
		newsRoom.selectPublishedOn(driver);
		Thread.sleep(2000);
		newsRoom.enterAddLink(driver, addLink);
		newsRoom.clickOnAllowCommentsToggleBtn(driver);
		newsRoom.clickOnAllowLikesToggleBtn(driver);
		newsRoom.clickOnAllowShareToggleBtn(driver);
		newsRoom.clickOnPublishBtn(driver);
		Thread.sleep(2000);
		newsRoom.clickOnEditUnderAction(driver);
		newsRoom.enterBlogTitle(driver, blogTitle2);
//		newsRoom.enterBlogContent_AfterEdit(driver, blogContent2);
		newsRoom.chooseBlogImage(driver, blogImage2);
		newsRoom.enterAuthor(driver, author2);
		newsRoom.clickOnPublishBtn(driver);

		String blogType3 = newsRoom.captureBlogType_Table(driver);
		String blogCategory3 = newsRoom.captureBlogCategory_Table(driver);
		String blogTitle3 = newsRoom.captureBlogTitle_Table(driver);
		String author3 = newsRoom.captureAuthor_Table(driver);
		String publishedOn3 = newsRoom.capturePublishedOn_Table(driver);
		SoftAssert sa = new SoftAssert();

		sa.assertEquals(blogType3, blogType);
		sa.assertEquals(blogCategory3, blogCategory);
		sa.assertEquals(blogTitle3, blogTitle);
		sa.assertEquals(author3, author);
		sa.assertEquals(publishedOn3, generateCurrentDate_YYYYMMDD());
		sa.assertAll();
	}
	
	@Test
	public void verifyCloseButtonFunctionalityAfterClickingOnNewBtn_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);
		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		newsRoom.clickOnNewBtn(driver);
		newsRoom.clickOnCloseBtn(driver);
		newsRoom.verifyCloseBtnIsDisplayed(driver);
	}
	
	@Test
	public void verifyCloseButtonFunctionalityAfterClickingOnEditBtn_Test() throws Throwable {
		NewsRoomPage newsRoom = new NewsRoomPage(driver);
		newsRoom.clickOnNewsRoomScreenBtn(driver);
		clickOnSideMenuBtn(driver);
		newsRoom.clickOnEditUnderAction(driver);
		newsRoom.clickOnCloseBtn(driver);
		newsRoom.verifyCloseBtnIsDisplayed(driver);
	}
	

}
