package ObjectRepository_Appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import GenericUtility_Appium.AndroidDriverUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MedicationsPage extends AndroidDriverUtility {
	public AndroidDriver androidDriver;

	public MedicationsPage(AndroidDriver androidDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Medications']")
	private WebElement medicationBtn;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Button")
	private WebElement plusBtn;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement calenderText;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement medicineNameText;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Syrup']")
	private WebElement syrup_MedicineType;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Pills']")
	private WebElement pills_MedicineType;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Syringe']")
	private WebElement syringe_MedicineType;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Tablets']")
	private WebElement tablets_MedicineType;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Select Time']")
	private WebElement selectTimeBtn;

	@AndroidFindBy(accessibility = "Morning")
	private WebElement morning_Schedule;

	@AndroidFindBy(accessibility = "Afternoon")
	private WebElement afternoon_Schedule;

	@AndroidFindBy(accessibility = "Night")
	private WebElement night_Schedule;

	@AndroidFindBy(accessibility = "Once")
	private WebElement once_Frequency;

	@AndroidFindBy(accessibility = "Twice")
	private WebElement twice_Frequency;

	@AndroidFindBy(accessibility = "Add Medicine")
	private WebElement addMedicineBtn;

	public void clickOnTheMedicationButton() {
		explicitWaitElementToBeClickable(androidDriver, medicationBtn);
		medicationBtn.click();
	}

	public void clickOnThePlus_AddButton() {
		plusBtn.click();
	}

	public void enterTheMedicineDate(String medicineDate) {
		calenderText.clear();
		calenderText.sendKeys(medicineDate);
	}

	public void enterTheMedicineName(String medicineName) {
		medicineNameText.clear();
		medicineNameText.sendKeys(medicineName);
	}

	public void selectMedicineType(String medicineType) {
		if (medicineType.contains("Syrup")) {
			syrup_MedicineType.click();
		} else if (medicineType.contains("Pills")) {
			pills_MedicineType.click();
		} else if (medicineType.contains("Syringe")) {
			syringe_MedicineType.click();
		} else if (medicineType.contains("Tablets")) {
			tablets_MedicineType.click();
		}
	}
}
