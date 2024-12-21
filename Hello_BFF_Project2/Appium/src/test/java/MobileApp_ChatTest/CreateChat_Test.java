package MobileApp_ChatTest;

import org.testng.annotations.Test;

import GenericUtility_Appium.BaseClass_Appium;
import ObjectRepository_Appium.ChatPage;

public class CreateChat_Test extends BaseClass_Appium {

	@Test
	public void chat_Test() {
		ChatPage chat = new ChatPage(androidDriver);

		String text = "hello";

		chat.clickOnChatBtn(androidDriver);
		chat.clickOnAutoChat(androidDriver);
		chat.enterDataInTetField(androidDriver, text);
		chat.clickOnSendBtn(androidDriver);
		String text2 = chat.captureHelloText(androidDriver);
		System.out.println(text2);
	}

}
