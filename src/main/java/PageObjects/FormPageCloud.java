package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;


public class FormPageCloud {

    private RemoteWebDriver driver;


    public FormPageCloud(AndroidDriver driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator((SearchContext) driver), this);
    }


    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public AndroidElement nameField;


    @AndroidFindBy(xpath = "//*[@text='Female']")
    public WebElement femaleOption;

    @AndroidFindBy(id = "android:id/text1")
    private AndroidElement countrySelection;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Argentina" +
            "\"))")
    AndroidElement element;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private AndroidElement letsShop;


    public AndroidElement getNameField() {
        System.out.println("trying to find the Name field");
        return (AndroidElement) nameField;
    }

    public AndroidElement getFemaleOption() {
        System.out.println("trying to find the Name field");
        return (AndroidElement) femaleOption;
    }
    public AndroidElement getCountrySelection() {
        System.out.println("Selecting the option from dropdown");
        return (AndroidElement) countrySelection;
    }

    public AndroidElement getCountry() {
        System.out.println("Selecting the option from dropdown");
        return (AndroidElement) element;
    }

    public AndroidElement getLetsShop() {
        System.out.println("trying to find the Name field");
        return (AndroidElement) letsShop;
    }


}



